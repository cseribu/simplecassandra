package transform;

import uk.ac.bham.cs.tuple.Unit;
import uk.ac.bham.cs.m2m.sitra.SimpleTraceableTransformer;
import uk.ac.bham.cs.m2m.sitra.Rule;
import uk.ac.bham.sitra.Transformer;
import cassandra.*;
import cassandra.impl.*;
import couchbase.*;
import couchbase.impl.*;

public class FloatType2JSONFloat extends Rule<FloatType, Unit<JSONFloatImpl>> {

	public boolean check(FloatType b)
	{
		return true;
	}
	
	public Unit<JSONFloatImpl> build(FloatType source, Transformer transformer)
	{
		CouchbaseFactoryImpl factory = new CouchbaseFactoryImpl();
		
		JSONFloatImpl value = (JSONFloatImpl)factory.createJSONFloat();
		value.setValue(source.getValue());
		
		return Unit.with(value);
		
		
	}
	
	@Override
	public void bind(Unit<JSONFloatImpl> target, FloatType source,
			Transformer transformer) {
		
		
	}
	
	public static void main(String[] args)
	{
		Transformer transformer = new SimpleTraceableTransformer();
		transformer.addRuleType(FloatType2JSONFloat.class);
		
		CassandraFactory factory = new CassandraFactoryImpl();
		FloatType val = factory.createFloatType();
		
		val.setValue(100.8f);
		
		Unit<JSONFloatImpl> ub = transformer.transform(FloatType2JSONFloat.class, val);
		System.out.println(ub.getA().getValue());
		
		
	}
}
