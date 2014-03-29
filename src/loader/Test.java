package loader;

import cassandra.*;
import cassandra.impl.*;
import me.prettyprint.cassandra.model.ConfigurableConsistencyLevel;
import me.prettyprint.cassandra.serializers.ObjectSerializer;
import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.cassandra.service.ColumnSliceIterator;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.HConsistencyLevel;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.beans.ColumnSlice;
import me.prettyprint.hector.api.beans.HColumn;
import me.prettyprint.hector.api.beans.OrderedRows;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.query.QueryResult;
import me.prettyprint.hector.api.query.RangeSlicesQuery;
import me.prettyprint.hector.api.query.SliceQuery;


public class Test {

	Cluster cluster = null;
	
	public Test(String clusterName, String url)
	{
		this.cluster = HFactory.getOrCreateCluster(clusterName, url);
	}
	
	public ColumnFamily getColumnFamily(String keyspaceName, String cfName)
	{
		CassandraFactoryImpl factory = new CassandraFactoryImpl();
		ColumnFamily cf = factory.createColumnFamily();
		
		cf.setName(cfName);
		
	
		ConfigurableConsistencyLevel ccl = new ConfigurableConsistencyLevel();
        ccl.setDefaultReadConsistencyLevel(HConsistencyLevel.ONE);
		
        Keyspace keyspace = HFactory.createKeyspace(keyspaceName, this.cluster);
        
        //System.out.println(keyspace.getKeyspaceName());
		
		
        RangeSlicesQuery<String, String, Object> rangeSlicesQuery =
                HFactory.createRangeSlicesQuery(keyspace, StringSerializer.get(), StringSerializer.get(),
                		ObjectSerializer.get());
        
        rangeSlicesQuery.setColumnFamily(cfName);
        rangeSlicesQuery.setKeys("", "");
        rangeSlicesQuery.setRange(null, null, false, Integer.MAX_VALUE);
        QueryResult<OrderedRows<String, String, Object>> result = rangeSlicesQuery.execute();
        OrderedRows<String, String, Object> orderedRows = result.get();
        for (me.prettyprint.hector.api.beans.Row<String, String, Object> row : orderedRows) {
        	
        	 String rowkey = row.getKey();
        	 System.out.println(rowkey);
        	 
        	 Row aRow = factory.createRow();
        	 aRow.setKey(rowkey);
        	 
        	 
        	 SliceQuery<String, String, Object> q = 
        			 HFactory.createSliceQuery(keyspace, StringSerializer.get(), StringSerializer.get(), ObjectSerializer.get());
             q.setColumnFamily(cfName);
             q.setRange("", "", false, 3);
             q.setKey(row.getKey());
             
             ColumnSliceIterator<String, String, Object> csItr = 
            		 new ColumnSliceIterator<String, String, Object>(q, null, "\uFFFF", false);
             while (csItr.hasNext()) {
            	 HColumn<String, Object> col = csItr.next();
            	 
            	 String colName = col.getName();
            	 String value = col.getValue().toString();
            	 System.out.println(colName + " : " + value);
            	 
            	 
            	 Column aColumn = factory.createColumn();
            	 aColumn.setKey(colName);
            	 
            	 UTF8Type val = factory.createUTF8Type();
            	 val.setValue(value);
            	 
            	 aColumn.setValue(val);
            	 
            	 aRow.getColumns().add(aColumn);
            	 
             }
        	 
        	 cf.getRows().add(aRow);
        	 
        	
        }
        

		return cf;
		
	}
	
	public static void main(String[] args)
	{
		Test c = new Test("Test Cluster","127.0.0.1:9160");
		ColumnFamily cf = c.getColumnFamily("ToysCorporation","ToyStores");
	}
	
}
