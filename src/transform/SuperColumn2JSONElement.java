package transform;

import java.util.ArrayList;
import java.util.List;

import uk.ac.bham.cs.tuple.Unit;
import uk.ac.bham.cs.m2m.sitra.SimpleTraceableTransformer;
import uk.ac.bham.cs.m2m.sitra.Rule;
import uk.ac.bham.sitra.Transformer;
import cassandra.*;
import cassandra.impl.*;
import couchbase.*;
import couchbase.impl.*;

public class SuperColumn2JSONElement extends Rule<SuperColumn, Unit<EStringToJSONElementImpl>> {
	
	public boolean check(SuperColumn b)
	{
		return true;
	}
	
	public Unit<EStringToJSONElementImpl> build(SuperColumn source, Transformer transformer)
	{
		
		CouchbaseFactoryImpl factory = new CouchbaseFactoryImpl();
		
		
		EStringToJSONElementImpl supercol = (EStringToJSONElementImpl)factory.createEStringToJSONElement();
		supercol.setKey(source.getKey());
		
		
		JSONObjectImpl object =  (JSONObjectImpl)factory.createJSONObject();
		supercol.setValue(object);
		
		for(Column col : source.getColumns())
		{
			DataType d = col.getValue();
			String s = ((AsciiType)d).getValue();
			
			EStringToJSONElementImpl elem = (EStringToJSONElementImpl) factory.createEStringToJSONElement();		
			
			//set key
			elem.setKey(col.getKey());
			
			//test string
			JSONString val = factory.createJSONString();
			val.setValue(s);
			
			elem.setValue(val);
			object.getMap().add(elem);
			
		}
		
		return Unit.with(supercol);
	}
	
	
	public Unit<EStringToJSONElementImpl> instantiate(SuperColumn source, Transformer transformer) {
		CouchbaseFactoryImpl factory = new CouchbaseFactoryImpl();
		EStringToJSONElementImpl object =  (EStringToJSONElementImpl)factory.createEStringToJSONElement();
	    return Unit.with(object);
	}
	
	@Override
	public void bind(Unit<EStringToJSONElementImpl> target, SuperColumn source,
			Transformer transformer) {
		
		
	}

	public void setProperties(Unit<EStringToJSONElementImpl> target, SuperColumn source,
			Transformer transformer) {
	}
	
	public static void main(String[] args)
	{
		Transformer transformer = new SimpleTraceableTransformer();
		transformer.addRuleType(SuperColumn2JSONElement.class);
		
		CassandraFactory factory = new CassandraFactoryImpl();
		
		SuperColumn sc = factory.createSuperColumn();
		sc.setKey("Transformer");
		
		
		Column column = factory.createColumn();
		column.setKey("Section");
		
		AsciiType string = factory.createAsciiType();
		string.setValue("Action Figure");
	
		column.setValue(string);
		
		sc.getColumns().add(column);
		
		
		Column column2 = factory.createColumn();
		column2.setKey("Price");
		AsciiType string2 = factory.createAsciiType();
		string2.setValue("2.0");
	
		column2.setValue(string2);
		
		sc.getColumns().add(column2);
		
		
		
		Unit<EStringToJSONElementImpl> ub = transformer.transform(SuperColumn2JSONElement.class, sc);
		EStringToJSONElementImpl object = ub.getA();
		
		JSONObjectImpl jc = (JSONObjectImpl)object.getValue();
		
		List columns = jc.getMap();
		for(int i=0; i<columns.size(); i++)
		{
			
			EStringToJSONElementImpl ed = (EStringToJSONElementImpl)columns.get(i);
			System.out.println(ed.getKey());
			JSONString s = (JSONString)ed.getValue();
			System.out.println(s);
			
			
		}
		
		
		
		
		
	}

	
	
}