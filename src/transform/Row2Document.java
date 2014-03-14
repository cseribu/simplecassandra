package transform;

import uk.ac.bham.cs.tuple.Unit;
import uk.ac.bham.cs.m2m.sitra.SimpleTraceableTransformer;
import uk.ac.bham.cs.m2m.sitra.Rule;
import uk.ac.bham.sitra.Transformer;
import cassandra.*;
import cassandra.impl.CassandraFactoryImpl;
import couchbase.*;
import couchbase.impl.*;


public class Row2Document extends Rule<Row, Unit<Document>> {
	
	public boolean check(Row b)
	{
		return true;
	}
	
	public Unit<Document> build(Row source, Transformer transformer)
	{
		CouchbaseFactoryImpl factory = new CouchbaseFactoryImpl();
		
		Document document = factory.createDocument();
		
		
		EStringToDocumentImpl ed = (EStringToDocumentImpl) factory.createEStringToDocument();
		ed.setKey(source.getKey());
		for(SuperColumn scol: source.getSupercolumns())
		{
			
			
			
			for(Column col : scol.getColumns())
			{
				
				EStringToJSONElementImpl e = (EStringToJSONElementImpl) factory.createEStringToJSONElement();
				e.setKey(scol.getKey()+"."+ col.getKey());
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
			
		}
		
		
		for(Column col : source.getColumns())
		{
			EStringToJSONElementImpl e = (EStringToJSONElementImpl) factory.createEStringToJSONElement();
			e.setKey("."+ col.getKey());
			
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
		
		
		
		return Unit.with(document);
	}

	@Override
	public void bind(Unit<Document> target, Row source, Transformer transformer) {
		//EStringToDocumentImpl estring = new EStringToDocumentImpl();
		//estring.setKey(source.getKey());
		
		
	}
	
	public Unit<Document> instantiate(Row source, Transformer transformer) {
		CouchbaseFactoryImpl factory = new CouchbaseFactoryImpl();
		
	    return Unit.with(factory.createDocument());
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
		
		Column col1 = factory.createColumn();
		col1.setKey("KeyColumn");
		AsciiType value = factory.createAsciiType();
		value.setValue("This is value");
		col1.setValue(value);
		
		aRow.getColumns().add(col1);
		
		Unit<Document> ub = transformer.transform(Row2Document.class, aRow);
		Document document = ub.getA();
		
		
		//System.out.println(ub.getA().getKey());
		//System.out.println(s.getValue());
		
		
		
		
	}
	
	
}