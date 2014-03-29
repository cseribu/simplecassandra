package loader;

import java.util.List;
import java.util.Map;

import transform.Keyspace2Bucket;
import uk.ac.bham.cs.m2m.sitra.SimpleTraceableTransformer;
import uk.ac.bham.cs.tuple.Unit;
import uk.ac.bham.sitra.Transformer;
import cassandra.AsciiType;
import cassandra.CassandraFactory;
import cassandra.Column;
import cassandra.ColumnFamily;
import cassandra.Keyspace;
import cassandra.Row;
import cassandra.SuperColumn;
import cassandra.impl.CassandraFactoryImpl;



import couchbase.Bucket;


public class Bucket2Db {

	
	
	public static void main(String[] args)
	{
		
		
		Transformer transformer = new SimpleTraceableTransformer();
		transformer.addRuleType(Keyspace2Bucket.class);
		
		CassandraFactory factory = new CassandraFactoryImpl();
		
		Keyspace ks = factory.createKeyspace();
		ks.setName("ToysCorporation");
		
		ColumnFamily cf = factory.createColumnFamily();
		cf.setName("ToyStores");
		
		
		
		
		
		
		
		Row aRow = factory.createRow();
		aRow.setKey("GumDrop");
		
		Column col11 = factory.createColumn();
		col11.setKey("Section");
		AsciiType value11 = factory.createAsciiType();
		value11.setValue("Candy");
		col11.setValue(value11);
		
		Column col12 = factory.createColumn();
		col12.setKey("Price");
		AsciiType value12 = factory.createAsciiType();
		value12.setValue("0.25");
		col12.setValue(value12);
		
		aRow.getColumns().add(col11);
		aRow.getColumns().add(col12);
		
		
		
		Row aRow2 = factory.createRow();
		aRow2.setKey("Transformer");
		
		Column col21 = factory.createColumn();
		col21.setKey("Section");
		AsciiType value21 = factory.createAsciiType();
		value21.setValue("Action Figure");
		col21.setValue(value21);
		
		Column col22 = factory.createColumn();
		col22.setKey("Price");
		AsciiType value22 = factory.createAsciiType();
		value22.setValue("2.99");
		col22.setValue(value22);
		
		aRow2.getColumns().add(col21);
		aRow2.getColumns().add(col22);
		
		
		
		Row aRow3 = factory.createRow();
		aRow3.setKey("MatchboxCar");
		
		Column col31 = factory.createColumn();
		col31.setKey("Section");
		AsciiType value31 = factory.createAsciiType();
		value31.setValue("Vehicle");
		col31.setValue(value31);
		
		Column col32 = factory.createColumn();
		col32.setKey("Price");
		AsciiType value32 = factory.createAsciiType();
		value32.setValue("1.49");
		col32.setValue(value32);
		
		aRow3.getColumns().add(col31);
		aRow3.getColumns().add(col32);
		
		
		
		cf.getRows().add(aRow);		
		cf.getRows().add(aRow2);	
		cf.getRows().add(aRow3);
		
		
		//add supercolumn
		Row aRow6 = factory.createRow();
		aRow6.setKey("OhioStore");
		
		
		
		SuperColumn sc = factory.createSuperColumn();
		sc.setKey("Transformer");
		
		Column col61 = factory.createColumn();
		col61.setKey("Section");
		AsciiType value61 = factory.createAsciiType();
		value61.setValue("Action Figure");
		col61.setValue(value61);
		
		Column col62 = factory.createColumn();
		col62.setKey("Price");
		AsciiType value62 = factory.createAsciiType();
		value62.setValue("2.99");
		col62.setValue(value62);
		
		//add to supercolumn
		sc.getColumns().add(col61);
		sc.getColumns().add(col62);
		
		
		SuperColumn sc2 = factory.createSuperColumn();
		sc2.setKey("MatchboxCar");
		
		Column col71 = factory.createColumn();
		col71.setKey("Section");
		AsciiType value71 = factory.createAsciiType();
		value71.setValue("Vehicle");
		col71.setValue(value71);
		
		Column col72 = factory.createColumn();
		col72.setKey("Price");
		AsciiType value72 = factory.createAsciiType();
		value72.setValue("2.99");
		col72.setValue(value72);
		
		Column col73 = factory.createColumn();
		col73.setKey("Color");
		AsciiType value73 = factory.createAsciiType();
		value73.setValue("Black");
		col73.setValue(value73);
		
		//add to supercolumn
		sc2.getColumns().add(col71);
		sc2.getColumns().add(col72);
		sc2.getColumns().add(col73);
		
		aRow6.getSupercolumns().add(sc);
		aRow6.getSupercolumns().add(sc2);
		
		cf.getRows().add(aRow6);
		
		ks.getColumnfamilies().add(cf);
		
		Unit<Map<String, List<Bucket>>> ub = transformer.transform(Keyspace2Bucket.class, ks);
		Map<String, List<Bucket>> maps = ub.getA();
		
		for(Map.Entry<String, List<Bucket>> elem: maps.entrySet())
		{
			List<Bucket>  buckets = elem.getValue();
			CouchbaseLoader loader = new CouchbaseLoader("http://127.0.0.1:8091/pools","");
			Bucket bucket = buckets.get(0);
			
			loader.bucket2db(bucket);
		}
		

		
	}
	
}
