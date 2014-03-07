package test;

import java.util.Map;

import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;
import cassandra.Keyspace;
import couchbase.Bucket;
import couchbase.Document;
import couchbase.JSONElement;
import couchbase.JSONString;
import couchbase.impl.BucketImpl;
import couchbase.impl.DocumentImpl;

public class Keyspace2Bucket implements Rule<Keyspace, Bucket> {
	
	
	public boolean check(Keyspace b)
	{
		return true;
	}
	
	public Bucket build(Keyspace source, Transformer transformer)
	{
		Bucket bucket = new BucketImpl();
		
		bucket.setName(source.getName());
		//bucket.setDocuments(source.getName(),source.getColumnfamilies());
		
		
		
		Bucket b  = new BucketImpl();
		b.setName("bucketsssss");
		
		Document d = new DocumentImpl();
		//MetaData md = new MetadataImpl();
		//d.setMeta(value);
		
		
		
		Map.Entry<String, Document> mymap = bucket.getDocuments();
		
		Map.Entry<String, JSONElement> data = mymap.getValue().getMap();
		
		String s = ((JSONString)(data.getValue())).getValue();
		String key = data.getKey();
		
		
		
		return bucket;
	}

	


	public void setProperties(Bucket target, Keyspace source,
			Transformer transformer) {
		
		
	}
	
	
}
