package test;

import uk.ac.bham.sitra.*;
import cassandra.Row;
import couchbase.Document;
import couchbase.impl.DocumentImpl;;

public class Row2Document implements Rule<Row, Document> {
	
	
	public boolean check(Row b)
	{
		return true;
	}
	
	public Document build(Row source, Transformer transformer)
	{
		Document document = new DocumentImpl();
		
		//bucket.setName(source.getName());
		
		
		
		
		
		
		
		return document;
	}

	


	public void setProperties(Document target, Row source,
			Transformer transformer) {
		
		
	}
	
	
}
