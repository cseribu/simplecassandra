package loader;

import java.util.List;

import cassandra.*;
import cassandra.impl.*;
import me.prettyprint.cassandra.model.ConfigurableConsistencyLevel;
import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.cassandra.service.ColumnSliceIterator;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.HConsistencyLevel;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.beans.ColumnSlice;
import me.prettyprint.hector.api.beans.HColumn;
import me.prettyprint.hector.api.beans.HSuperColumn;
import me.prettyprint.hector.api.beans.OrderedRows;
import me.prettyprint.hector.api.beans.OrderedSuperRows;
import me.prettyprint.hector.api.beans.SuperSlice;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.query.QueryResult;
import me.prettyprint.hector.api.query.RangeSlicesQuery;
import me.prettyprint.hector.api.query.RangeSubSlicesQuery;
import me.prettyprint.hector.api.query.RangeSuperSlicesQuery;
import me.prettyprint.hector.api.query.SliceQuery;
import me.prettyprint.hector.api.query.SubSliceQuery;
import me.prettyprint.hector.api.query.SuperSliceQuery;


public class CassandraLoader {

	Cluster cluster = null;
	
	public CassandraLoader(String clusterName, String url)
	{
		this.cluster = HFactory.getOrCreateCluster(clusterName, url);
	}
	
	public ColumnFamily getColumnFamilySuper(String keyspaceName, String cfName)
	{
		CassandraFactoryImpl factory = new CassandraFactoryImpl();
		ColumnFamily cf = factory.createColumnFamily();
		
		cf.setName(cfName);
		
		
		ConfigurableConsistencyLevel ccl = new ConfigurableConsistencyLevel();
        ccl.setDefaultReadConsistencyLevel(HConsistencyLevel.ONE);
		
        Keyspace keyspace = HFactory.createKeyspace(keyspaceName, this.cluster);
        
        
        
        RangeSuperSlicesQuery<String, String, String, String> rangeSlicesQuery =
                HFactory.createRangeSuperSlicesQuery(keyspace, StringSerializer.get(), StringSerializer.get(),
                		StringSerializer.get(), StringSerializer.get() );
        
        
        
        rangeSlicesQuery.setColumnFamily(cfName);
        rangeSlicesQuery.setKeys("", "");
        
        rangeSlicesQuery.setRange(null, null, false, Integer.MAX_VALUE);
        QueryResult<OrderedSuperRows<String, String, String, String>> result = rangeSlicesQuery.execute();
        OrderedSuperRows<String, String, String, String> orderedRows = result.get();
        for (me.prettyprint.hector.api.beans.SuperRow<String, String, String, String> row : orderedRows) {
        	
        	 String rowkey = row.getKey();
        	 //System.out.println(rowkey);
        	 
        	 Row aRow = factory.createRow();
        	 aRow.setKey(rowkey);
        	 
        	 SuperSlice ss = row.getSuperSlice();
        	 List<HSuperColumn<String, String, String>> list = ss.getSuperColumns();
        	 
        	 for (HSuperColumn<String, String, String> hsc: list)
        	 {
        		 SuperColumn sc = factory.createSuperColumn();
        		 sc.setKey(hsc.getName());
        		 
        		 
        		 List<HColumn<String, String>> collist = hsc.getColumns();
        		 
        		 for(HColumn<String, String> col : collist)
        		 {
        			 
        			 Column c = factory.createColumn();
        			 c.setKey(col.getName());
        			 
        			 UTF8Type val = factory.createUTF8Type();
                	 val.setValue(col.getValue());
        			 
                	 c.setValue(val);
                	 
                	 sc.getColumns().add(c);        			 
        			 //System.out.println(col.getName());
        		 }
        		 
        		 aRow.getSupercolumns().add(sc);
        		 
        		 
        	 }
        	cf.getRows().add(aRow);
        	 
        	
        }
		
		
		return cf;
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
		
		
        RangeSlicesQuery<String, String, String> rangeSlicesQuery =
                HFactory.createRangeSlicesQuery(keyspace, StringSerializer.get(), StringSerializer.get(),
                		StringSerializer.get());
        
        rangeSlicesQuery.setColumnFamily(cfName);
        rangeSlicesQuery.setKeys("", "");
        rangeSlicesQuery.setRange(null, null, false, Integer.MAX_VALUE);
        QueryResult<OrderedRows<String, String, String>> result = rangeSlicesQuery.execute();
        OrderedRows<String, String, String> orderedRows = result.get();
        for (me.prettyprint.hector.api.beans.Row<String, String, String> row : orderedRows) {
        	
        	 String rowkey = row.getKey();
        	 //System.out.println(rowkey);
        	 
        	 Row aRow = factory.createRow();
        	 aRow.setKey(rowkey);
        	 
        	
        	 
        	 SliceQuery<String, String, String> q = 
        			 HFactory.createSliceQuery(keyspace, StringSerializer.get(), StringSerializer.get(), StringSerializer.get());
             q.setColumnFamily(cfName);
             q.setRange("", "", false, 3);
             q.setKey(row.getKey());
             
             ColumnSliceIterator<String, String, String> csItr = 
            		 new ColumnSliceIterator<String, String, String>(q, null, "\uFFFF", false);
             while (csItr.hasNext()) {
            	 HColumn<String, String> col = csItr.next();
            	 
            	 String colName = col.getName();
            	 String value = col.getValue();
            	 //System.out.println(colName + " : " + value);
            	 
            	 
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
		CassandraLoader c = new CassandraLoader("Test Cluster","127.0.0.1:9160");
		//ColumnFamily cf = c.getColumnFamily("ToysCorporation","ToyStores");
		ColumnFamily cf = c.getColumnFamilySuper("ToysCorp","ToyStores2");
	}
	
}
