package transform;

import java.util.List;

import uk.ac.bham.cs.tuple.Unit;
import uk.ac.bham.cs.m2m.sitra.SimpleTraceableTransformer;
import uk.ac.bham.cs.m2m.sitra.Rule;
import uk.ac.bham.sitra.Transformer;
import cassandra.*;
import cassandra.impl.CassandraFactoryImpl;
import couchbase.*;
import couchbase.impl.*;


public class Row2Document extends Rule<Row, Unit<EStringToDocumentImpl>> {
	
	public boolean check(Row b)
	{
		return true;
	}
	
	public Unit<EStringToDocumentImpl> build(Row source, Transformer transformer)
	{
		CouchbaseFactoryImpl factory = new CouchbaseFactoryImpl();
		
		EStringToDocumentImpl ed = (EStringToDocumentImpl) factory.createEStringToDocument();
		ed.setKey(source.getKey());
		
		Document document = factory.createDocument();
		
		Metadata meta = factory.createMetadata();
		meta.setType("json");
		meta.setId(source.getKey());
		
		document.setMeta(meta);
		
		for(SuperColumn scol: source.getSupercolumns())
		{
			EStringToJSONElementImpl ee = (EStringToJSONElementImpl) factory.createEStringToJSONElement();
			
			ee.setKey(scol.getKey());
			
			JSONObjectImpl object = (JSONObjectImpl)factory.createJSONObject();
			
			
			for(Column col : scol.getColumns())
			{
				
				EStringToJSONElementImpl e = (EStringToJSONElementImpl) factory.createEStringToJSONElement();
				e.setKey(col.getKey());
				DataType d = col.getValue();
				//string
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
				
				
				object.getMap().add(e);
				
			}
			ee.setValue(object);
			document.getMap().add(ee);
			ed.setValue(document);
			
		}
		
		
		for(Column col : source.getColumns())
		{
			EStringToJSONElementImpl e = (EStringToJSONElementImpl) factory.createEStringToJSONElement();
			e.setKey(col.getKey());
			
			DataType d = col.getValue();
			//string
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
			
			
			document.getMap().add(e);
			ed.setValue(document);
		}
		
		
		
		
		
		return Unit.with(ed);
	}

	@Override
	public void bind(Unit<EStringToDocumentImpl> target, Row source, Transformer transformer) {	
		
	}
	
	public Unit<EStringToDocumentImpl> instantiate(Row source, Transformer transformer) {
		CouchbaseFactoryImpl factory = new CouchbaseFactoryImpl();
		EStringToDocumentImpl e = (EStringToDocumentImpl)factory.createEStringToDocument();
	    return Unit.with(e);
	}


	public void setProperties(Unit<Document> target, Row source, Transformer transformer) {
		
		
	}
	
	public static void main(String[] args)
	{
		Transformer transformer = new SimpleTraceableTransformer();
		transformer.addRuleType(Row2Document.class);
		
		//Create a row
		CassandraFactory factory = new CassandraFactoryImpl();
		Row aRow = factory.createRow();
		aRow.setKey("Transformer");
		
		Column col1 = factory.createColumn();
		col1.setKey("Section");
		AsciiType value = factory.createAsciiType();
		value.setValue("Action Figure");
		col1.setValue(value);
		
		aRow.getColumns().add(col1);
		
		Unit<EStringToDocumentImpl> ub = transformer.transform(Row2Document.class, aRow);
		EStringToDocumentImpl edoc = ub.getA();
		
		
		System.out.println(edoc.getKey());
		
		
		Document doc = edoc.getValue();
		Metadata  meta = doc.getMeta();
		System.out.println("Id: " + meta.getId());
		System.out.println("Revision: " + meta.getRev());
		System.out.println("Expiration: " + meta.getExpiration());
		System.out.println("Type: " + meta.getType());
		
		for(int j=0; j<doc.getMap().size(); j++)
		{
			EStringToJSONElementImpl e = (EStringToJSONElementImpl)doc.getMap().get(j);
			
			
			if(e.getValue() instanceof JSONObjectImpl)
			{
				System.out.println("Super Col Key: " + e.getKey());
				JSONObjectImpl object = (JSONObjectImpl)e.getValue();
				List columns = object.getMap();
				for(int n = 0; n< columns.size(); n++)
				{
					EStringToJSONElementImpl element = (EStringToJSONElementImpl)columns.get(n);
					System.out.println("Col Key: " + element.getKey());
					JSONString s = (JSONString)element.getValue();
					System.out.println("Col Value: " + s.getValue());
					System.out.println("--------------------");
				}
				
			}
			else
			{
				System.out.println("Col Key: " + e.getKey());
				JSONString s = (JSONString)e.getValue();
				System.out.println("Col Value: " + s.getValue());
				System.out.println("--------------------");
			}
			
		}
		System.out.println("--------------------");
		
	}
	
	
}