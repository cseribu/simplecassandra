package loader;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;

import com.couchbase.client.CouchbaseClient;

import couchbase.Bucket;
import couchbase.Document;
import couchbase.JSONElement;
import couchbase.JSONString;
import couchbase.Metadata;
import couchbase.impl.EStringToDocumentImpl;
import couchbase.impl.EStringToJSONElementImpl;
import couchbase.impl.JSONObjectImpl;

public class CouchbaseLoader {
	
	private String url = "http://127.0.0.1:8091/pools";
	private String password = "";
	private List<URI> hosts;

	public CouchbaseLoader(String url, String password)
	{
		this.url = url;
		this.password = password;
		
		
		try
		{
			this.hosts = Arrays.asList(
					new URI(this.url)
			);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void bucket2db(Bucket bucket)
	{
		try
		{
						
			String bucketName = bucket.getName().substring(bucket.getName().indexOf('.')+1);
			CouchbaseClient client = new CouchbaseClient(this.hosts, bucketName, this.password);
		    
			for(int i=0; i<bucket.getDocuments().size(); i++)
			{
				
				
				EStringToDocumentImpl ed = (EStringToDocumentImpl)bucket.getDocuments().get(i);
				StringBuffer buffer = new StringBuffer();
				
				
				
				
				Document doc = ed.getValue();
				buffer.append("{");
				buffer.append("\n");
				for(int j = 0; j<doc.getMap().size(); j++)
				{
					
					
					Entry<String, JSONElement> ej = doc.getMap().get(j);
					
					
					if(ej.getValue() instanceof JSONObjectImpl)
					{
						buffer.append('"');
						buffer.append(ej.getKey());
						buffer.append('"');
						buffer.append(":");
						
						buffer.append('{');
						buffer.append("\n");
						JSONObjectImpl object = (JSONObjectImpl)ej.getValue();
						List columns = object.getMap();
						
						for(int k = 0; k < columns.size(); k++)
						{
							
							EStringToJSONElementImpl elem = (EStringToJSONElementImpl)columns.get(k);
							buffer.append('"');
							buffer.append(elem.getKey());
							buffer.append('"');
							buffer.append(':');
							buffer.append('"');
							
							if(elem.getValue() != null)
								buffer.append(elem.getValue());
							
							buffer.append('"');
							
							if(k < columns.size()-1)
								buffer.append(',');
							
							buffer.append("\n");
						}
						buffer.append('}');
						
						
						if(j < doc.getMap().size()-1)
							buffer.append(',');
						
						buffer.append("\n");
						
					}
					
					else if(ej.getValue() instanceof JSONString)
					{
						JSONString js = (JSONString)ej.getValue();
						
						
						buffer.append('"');
						if(ej != null)
							buffer.append(ej.getKey());
						
						buffer.append('"');
						buffer.append(':');
						buffer.append('"');
						if(js != null)
							buffer.append(js.getValue());
						
						buffer.append('"');
							
						if(j < doc.getMap().size()-1)
								buffer.append(',');
							
						buffer.append("\n");
					}
					
					
						
				}
				buffer.append("}");
				//buffer.append("\n");
				
				Metadata meta = doc.getMeta();
				String docKey = meta.getId();
				
				//System.out.println(docKey);
			    System.out.println(buffer.toString());
				System.out.println("---");
				
				
				client.set(docKey, buffer.toString()).get();
			
				
			}
			
			client.shutdown();	
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
}
