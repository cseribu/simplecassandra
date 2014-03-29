package loader;

import java.util.List;

import couchbase.Bucket;
import transform.*;
import uk.ac.bham.cs.m2m.sitra.SimpleTraceableTransformer;
import uk.ac.bham.cs.tuple.Unit;
import uk.ac.bham.sitra.Transformer;
import cassandra.ColumnFamily;
import cassandra.Keyspace;

public class Cassandra2Couchbase {
	
	private void testColumnFamily()
	{
		CassandraLoader c = new CassandraLoader("Test Cluster","127.0.0.1:9160");
		//ColumnFamily cf = c.getColumnFamily("ToysCorp","ToyStores");
		ColumnFamily cf = c.getColumnFamilySuper("ToysCorp","ToyStores2");
		
		Transformer transformer = new SimpleTraceableTransformer();
		transformer.addRuleType(ColumnFamily2Bucket.class);
		
		Unit<Bucket> ub = transformer.transform(ColumnFamily2Bucket.class, cf);
		
		CouchbaseLoader loader = new CouchbaseLoader("http://127.0.0.1:8091/pools","");
		Bucket bucket = ub.getA();
		
		//System.out.println(bucket.getDocuments().size());
		//System.out.println(bucket.getName());
		
		loader.bucket2db(bucket);
	}
	
	
	
	public static void main(String[] args)
	{
		
		new Cassandra2Couchbase().testColumnFamily();
		
		
	}
}
