package test;

import cassandra.AsciiType;
import cassandra.CassandraFactory;
import cassandra.Column;
import cassandra.IntegerType;
import cassandra.UTF8Type;
import cassandra.impl.CassandraPackageImpl;

public class Test {
	
	public static void main(String[] args)
	{
		CassandraPackageImpl.init();
		CassandraFactory factory = CassandraFactory.eINSTANCE;
		
		
		Column col = factory.createColumn();

		IntegerType t = factory.createIntegerType();
		t.setValue(100);
		
		col.setValue(t);
		
		int x = ((IntegerType)col.getValue()).getValue();
		System.out.println(x);
		
		
		AsciiType s = factory.createAsciiType();
		s.setValue("This is my string");
		
		Column col2 = factory.createColumn();
		col2.setKey("12345");
		col2.setValue(s);
		
		String key = col2.getKey();
		String s2 = ((AsciiType)col2.getValue()).getValue();
		System.out.println("key: " + key + " value: " +s2);
		
	
		
	}
}
