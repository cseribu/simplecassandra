package transform;

import java.util.List;

import uk.ac.bham.cs.m2m.sitra.Rule;
import uk.ac.bham.cs.m2m.sitra.SimpleTraceableTransformer;
import uk.ac.bham.cs.tuple.Unit;
import uk.ac.bham.sitra.Transformer;
import cassandra.AsciiType;
import cassandra.UTF8Type;
import cassandra.BooleanType;
import cassandra.CassandraFactory;
import cassandra.Column;
import cassandra.ColumnFamily;
import cassandra.DataType;
import cassandra.FloatType;
import cassandra.IntegerType;
import cassandra.Row;
import cassandra.SuperColumn;
import cassandra.impl.CassandraFactoryImpl;
import couchbase.Bucket;
import couchbase.Document;
import couchbase.JSONBoolean;
import couchbase.JSONFloat;
import couchbase.JSONInt;
import couchbase.JSONString;
import couchbase.Metadata;
import couchbase.impl.CouchbaseFactoryImpl;
import couchbase.impl.EStringToDocumentImpl;
import couchbase.impl.EStringToJSONElementImpl;
import couchbase.impl.JSONObjectImpl;


public class ColumnFamily2Bucket extends Rule<ColumnFamily, Unit<Bucket>> {
	
	public boolean check(ColumnFamily b)
	{
		return true;
	}
	
	public Unit<Bucket> build(ColumnFamily source, Transformer transformer)
	{
		CouchbaseFactoryImpl factory = new CouchbaseFactoryImpl();
		
		Bucket bucket = factory.createBucket();
		bucket.setName(source.getName());
		

		for (Row row : source.getRows())
		{
			EStringToDocumentImpl ed = (EStringToDocumentImpl) factory.createEStringToDocument();
			ed.setKey(row.getKey());
			
			Document document = factory.createDocument();
			
			
			Metadata meta = factory.createMetadata();
			meta.setType("json");
			meta.setId(row.getKey());
			
			document.setMeta(meta);
			
			for(SuperColumn scol: row.getSupercolumns())
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
					else if(d instanceof UTF8Type)
					{
						JSONString val = factory.createJSONString();
						val.setValue(((UTF8Type) d).getValue());
						
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
					else
					{
						JSONString val = factory.createJSONString();
						val.setValue(((AsciiType) d).getValue());
						
						e.setValue(val);
					}
					
					
					object.getMap().add(e);
					
				}
				ee.setValue(object);
				document.getMap().add(ee);
				ed.setValue(document);
				
				
			}
			
			for(Column col : row.getColumns())
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
				else if(d instanceof UTF8Type)
				{
					JSONString val = factory.createJSONString();
					val.setValue(((UTF8Type) d).getValue());
					
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
				
				else
				{
					JSONString val = factory.createJSONString();
					val.setValue(((AsciiType) d).getValue());
					
					e.setValue(val);
				}
				
				document.getMap().add(e);
				ed.setValue(document);
			}
			
			bucket.getDocuments().add(ed);
		}
		

		return Unit.with(bucket);
	}

	@Override
	public void bind(Unit<Bucket> target, ColumnFamily source, Transformer transformer) {
		
	}
	
	public Unit<Bucket> instantiate(ColumnFamily source, Transformer transformer) {
		CouchbaseFactoryImpl factory = new CouchbaseFactoryImpl();
		
	    return Unit.with(factory.createBucket());
	}


	public void setProperties(Unit<Bucket> target, ColumnFamily source, Transformer transformer) {
		
		
	}
	
	public static void main(String[] args)
	{
		Transformer transformer = new SimpleTraceableTransformer();
		transformer.addRuleType(ColumnFamily2Bucket.class);
		
		//Create a row
		CassandraFactory factory = new CassandraFactoryImpl();
		
		ColumnFamily cf = factory.createColumnFamily();
		cf.setName("ToyStore");
		
		Row aRow = factory.createRow();
		aRow.setKey("OhioStore");
		
		Column col1 = factory.createColumn();
		col1.setKey("Section");
		AsciiType value = factory.createAsciiType();
		value.setValue("Action Figure");
		col1.setValue(value);
		
		aRow.getColumns().add(col1);
		
		cf.getRows().add(aRow);
		
		
		SuperColumn sc = factory.createSuperColumn();
		sc.setKey("Transformer");
		
		Column col2 = factory.createColumn();
		col2.setKey("Section");
		AsciiType value2 = factory.createAsciiType();
		value2.setValue("Action Figure");
		col2.setValue(value2);
		
		sc.getColumns().add(col2);
		
		Column col3 = factory.createColumn();
		col3.setKey("Section");
		AsciiType value3 = factory.createAsciiType();
		value3.setValue("Action Figure");
		col3.setValue(value3);
		
		sc.getColumns().add(col3);
		
		aRow.getSupercolumns().add(sc);
		
		
		Unit<Bucket> ub = transformer.transform(ColumnFamily2Bucket.class, cf);
		Bucket bucket = ub.getA();
		System.out.println("Bucket Name:" + bucket.getName());
		System.out.println("--------------------\n");
		
		for(int i=0; i< bucket.getDocuments().size(); i++)
		{
			Document doc = bucket.getDocuments().get(i).getValue();
			Metadata meta = doc.getMeta();
			System.out.println("Document Key:" + meta.getId());
			
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
	
	
}