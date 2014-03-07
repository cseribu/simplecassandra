package test;

import org.eclipse.emf.ecore.impl.EDataTypeImpl;

import cassandra.CassandraFactory;
import cassandra.CassandraPackage;
import cassandra.Column;
import cassandra.impl.CassandraPackageImpl;
import cassandra.impl.ColumnImpl;

public class Test {
	
	public static void main(String[] args)
	{
		CassandraPackageImpl.init();
		CassandraFactory factory = CassandraFactory.eINSTANCE;
		
		
		Column col = factory.createColumn();
		
		//col.setValue("Test");
		col.setValue(1);
		
		//col.setValue(0x00);
		if(col.getValue() instanceof String)
		{
			//this is string
		}
		
		
		
	}
}
