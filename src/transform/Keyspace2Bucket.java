package transform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import uk.ac.bham.cs.m2m.sitra.Rule;
import uk.ac.bham.cs.m2m.sitra.SimpleTraceableTransformer;
import uk.ac.bham.cs.tuple.Unit;
import uk.ac.bham.sitra.Transformer;
import cassandra.AsciiType;
import cassandra.BooleanType;
import cassandra.CassandraFactory;
import cassandra.Column;
import cassandra.ColumnFamily;
import cassandra.DataType;
import cassandra.FloatType;
import cassandra.IntegerType;
import cassandra.Keyspace;
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


public class Keyspace2Bucket extends Rule<Keyspace, Unit<Map<String,List<Bucket>>>> {
	
	public boolean check(Keyspace b)
	{
		return true;
	}
	
	public Unit<Map<String,List<Bucket>>> build(Keyspace source, Transformer transformer)
	{
		CouchbaseFactoryImpl factory = new CouchbaseFactoryImpl();
		
		Map<String, List<Bucket>> map = new HashMap();
		
		List<Bucket> list = new ArrayList<Bucket>();
		
		for (ColumnFamily cf : source.getColumnfamilies())
		{
		
			Bucket bucket = factory.createBucket();
			bucket.setName(cf.getName());
			
			
			
			//System.out.println("rows "+cf.getRows().size());
			
			for (Row row : cf.getRows())
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
				
				
				bucket.getDocuments().add(ed);
				//System.out.println("size "+bucket.getDocuments().size());
				//System.out.println(meta.getId());
			}
			
			
			list.add(bucket);
			
		}
		
		map.put(source.getName(), list);

		return Unit.with(map);
	}

	@Override
	public void bind(Unit<Map<String, List<Bucket>>> target, Keyspace source, Transformer transformer) {
		
		
	}
	
	public Unit<Map<String, List<Bucket>>> instantiate(Keyspace source, Transformer transformer) {
		
		Map<String, List<Bucket>> map = new HashMap();
		List<Bucket> list = new ArrayList<Bucket>();
		map.put(source.getName(), list);
		
	    return Unit.with(map);
	}


	public void setProperties(Unit<Map<String, List<Bucket>>> target, Keyspace source, Transformer transformer) {
		
		
	}
	
	public static void main(String[] args)
	{
		Transformer transformer = new SimpleTraceableTransformer();
		transformer.addRuleType(Keyspace2Bucket.class);
		
		CassandraFactory factory = new CassandraFactoryImpl();
		
		Keyspace ks = factory.createKeyspace();
		ks.setName("ToysCorp");
		
		ColumnFamily cf = factory.createColumnFamily();
		cf.setName("ToyStores");
		
		Row aRow = factory.createRow();
		aRow.setKey("Transformer");
		
		Column col1 = factory.createColumn();
		col1.setKey("Section");
		AsciiType value = factory.createAsciiType();
		value.setValue("Action Figure");
		col1.setValue(value);
		
		aRow.getColumns().add(col1);
		cf.getRows().add(aRow);
		
		
		SuperColumn sc = factory.createSuperColumn();
		sc.setKey("Batman");
		
		Column col2 = factory.createColumn();
		col2.setKey("Section");
		AsciiType value2 = factory.createAsciiType();
		value2.setValue("Action Figure");
		col2.setValue(value2);
		
		sc.getColumns().add(col2);
		
		Column col3 = factory.createColumn();
		col3.setKey("Color");
		AsciiType value3 = factory.createAsciiType();
		value3.setValue("Black");
		col3.setValue(value3);
		
		sc.getColumns().add(col3);
		
		aRow.getSupercolumns().add(sc);
		cf.getRows().add(aRow);
		
		
		
		ks.getColumnfamilies().add(cf);
		
		
		Unit<Map<String, List<Bucket>>> obj = transformer.transform(Keyspace2Bucket.class, ks);
		Map<String, List<Bucket>> maps = obj.getA();
		
		
		for(Map.Entry<String, List<Bucket>> elem : maps.entrySet())
		{
			String keyspaceName = elem.getKey();
			System.out.println("Keyspace: " + keyspaceName);
			System.out.println("--------------------");
			List<Bucket> buckets = elem.getValue();
			
			for(int k = 0; k< buckets.size(); k++)
			{
			
				Bucket bucket = buckets.get(k);
				System.out.println("Bucket Name: " + bucket.getName());
				System.out.println("--------------------\n");
				
				for(int i=0; i< bucket.getDocuments().size(); i++)
				{
					Document doc = bucket.getDocuments().get(i).getValue();
					Metadata meta = doc.getMeta();
					System.out.println("Document Key: " + meta.getId());
					System.out.println("--------------------");
					
					
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
		
		
		
		
		
		
		
		
		
	}
	
	
}