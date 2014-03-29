package transform;

import uk.ac.bham.cs.tuple.Unit;
import uk.ac.bham.cs.m2m.sitra.SimpleTraceableTransformer;
import uk.ac.bham.cs.m2m.sitra.Rule;
import uk.ac.bham.sitra.Transformer;
import cassandra.*;
import cassandra.impl.*;
import couchbase.*;
import couchbase.impl.*;

public class IntegerType2JSONInt extends Rule<IntegerType, Unit<JSONIntImpl>> {

	public boolean check(IntegerType b)
	{
		return true;
	}
	
	public Unit<JSONIntImpl> build(IntegerType source, Transformer transformer)
	{
		CouchbaseFactoryImpl factory = new CouchbaseFactoryImpl();
		
		JSONIntImpl value = (JSONIntImpl)factory.createJSONInt();
		value.setValue(source.getValue());
		
		return Unit.with(value);
		
		
	}
	
	@Override
	public void bind(Unit<JSONIntImpl> target, IntegerType source,
			Transformer transformer) {
		
		
	}
	
	public static void main(String[] args)
	{
		Transformer transformer = new SimpleTraceableTransformer();
		transformer.addRuleType(IntegerType2JSONInt.class);
		
		CassandraFactory factory = new CassandraFactoryImpl();
		IntegerType val = factory.createIntegerType();
		val.setValue(10);
		
		Unit<JSONIntImpl> ub = transformer.transform(IntegerType2JSONInt.class, val);
		System.out.println(ub.getA().getValue());
		
		
	}
}
