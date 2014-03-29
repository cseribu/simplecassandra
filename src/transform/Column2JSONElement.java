package transform;

import uk.ac.bham.cs.tuple.Unit;
import uk.ac.bham.cs.m2m.sitra.SimpleTraceableTransformer;
import uk.ac.bham.cs.m2m.sitra.Rule;
import uk.ac.bham.sitra.Transformer;
import cassandra.*;
import cassandra.impl.*;
import couchbase.*;
import couchbase.impl.*;

public class Column2JSONElement extends Rule<Column, Unit<EStringToJSONElementImpl>> {
	
	public boolean check(Column b)
	{
		return true;
	}
	
	public Unit<EStringToJSONElementImpl> build(Column source, Transformer transformer)
	{
		
		CouchbaseFactoryImpl factory = new CouchbaseFactoryImpl();
		
		DataType d = source.getValue();
		String s = ((AsciiType)d).getValue();
		EStringToJSONElementImpl e = (EStringToJSONElementImpl) factory.createEStringToJSONElement();
		e.setKey(source.getKey());
		
		if(d instanceof AsciiType)
		{
			JSONString val = factory.createJSONString();
			val.setValue(((AsciiType) d).getValue());
			
			e.setValue(val);
			
		}
		else if (d instanceof IntegerType)
		{
			JSONInt val = factory.createJSONInt();
			val.setValue(((IntegerType) d).getValue());
			
			e.setValue(val);
		}
		else if (d instanceof FloatType)
		{
			JSONFloat val = factory.createJSONFloat();
			val.setValue(((FloatType) d).getValue());
			
			e.setValue(val);
		}
		else if (d instanceof BooleanType)
		{
			JSONBoolean val = factory.createJSONBoolean();
			val.setValue(((BooleanType) d).isValue());
			
			e.setValue(val);
		}
		
		
		return Unit.with(e);
	}
	
	
	public Unit<EStringToJSONElementImpl> instantiate(Column source, Transformer transformer) {
		CouchbaseFactoryImpl factory = new CouchbaseFactoryImpl();
		EStringToJSONElementImpl e = (EStringToJSONElementImpl)factory.createEStringToJSONElement();
	    return Unit.with(e);
	}
	
	@Override
	public void bind(Unit<EStringToJSONElementImpl> target, Column source,
			Transformer transformer) {
		
		target.getA().setKey(source.getKey());
	}

	public void setProperties(Unit<EStringToJSONElementImpl> target, Column source,
			Transformer transformer) {
	}
	
	
	public String toString()
	{
		StringBuffer buf = new StringBuffer();
		
		return new String(buf);
	}
	
	public static void main(String[] args)
	{
		Transformer transformer = new SimpleTraceableTransformer();
		transformer.addRuleType(Column2JSONElement.class);
		
		CassandraFactory factory = new CassandraFactoryImpl();
		Column column = factory.createColumn();
		column.setKey("ColumnKey");
		
		AsciiType string = factory.createAsciiType();
		string.setValue("This is value");
	
		column.setValue(string);
		
		//System.out.println(((AsciiType)column.getValue()).getValue());
		
		Unit<EStringToJSONElementImpl> ub = transformer.transform(Column2JSONElement.class, column);
		JSONString s = (JSONString)ub.getA().getValue();
		//System.out.println(ub.getA().getKey());
		//System.out.println(s.getValue());
		
		System.out.println(ub.getA().toString());
		
		
		
	}

	
	
}