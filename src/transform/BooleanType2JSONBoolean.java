package transform;

import uk.ac.bham.cs.tuple.Unit;
import uk.ac.bham.cs.m2m.sitra.SimpleTraceableTransformer;
import uk.ac.bham.cs.m2m.sitra.Rule;
import uk.ac.bham.sitra.Transformer;
import cassandra.*;
import cassandra.impl.*;
import couchbase.*;
import couchbase.impl.*;

public class BooleanType2JSONBoolean extends Rule<BooleanType, Unit<JSONBooleanImpl>> {

	public boolean check(BooleanType b)
	{
		return true;
	}
	
	public Unit<JSONBooleanImpl> build(BooleanType source, Transformer transformer)
	{
		CouchbaseFactoryImpl factory = new CouchbaseFactoryImpl();
		
		JSONBooleanImpl value = (JSONBooleanImpl)factory.createJSONBoolean();
		value.setValue(source.isValue());
		
		return Unit.with(value);
		
		
	}
	
	@Override
	public void bind(Unit<JSONBooleanImpl> target, BooleanType source,
			Transformer transformer) {
		
		
	}
	
	public static void main(String[] args)
	{
		Transformer transformer = new SimpleTraceableTransformer();
		transformer.addRuleType(BooleanType2JSONBoolean.class);
		
		CassandraFactory factory = new CassandraFactoryImpl();
		BooleanType val = factory.createBooleanType();
		
		val.setValue(true);
		
		Unit<JSONBooleanImpl> ub = transformer.transform(BooleanType2JSONBoolean.class, val);
		System.out.println(ub.getA().isValue());
		
		
	}
}
