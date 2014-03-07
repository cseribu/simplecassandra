package test;


import uk.ac.bham.sitra.*;
import cassandra.ColumnFamily;
import couchbase.Bucket;
import couchbase.impl.BucketImpl;

public class ColumnFamily2Bucket implements Rule<ColumnFamily, Bucket> {
	
	
	public boolean check(ColumnFamily b)
	{
		return true;
	}
	
	public Bucket build(ColumnFamily source, Transformer transformer)
	{
		Bucket bucket = new BucketImpl();
		
		bucket.setName(source.getName());
		//bucket.setDocuments(source.,source.getRows());
		
		
		
		
		
		
		
		
		return bucket;
	}

	


	public void setProperties(Bucket target, ColumnFamily source,
			Transformer transformer) {
		
		
	}
	
	
}
