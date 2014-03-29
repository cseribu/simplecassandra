package transform;

import uk.ac.bham.cs.tuple.Unit;
import uk.ac.bham.cs.m2m.sitra.SimpleTraceableTransformer;
import uk.ac.bham.cs.m2m.sitra.Rule;
import uk.ac.bham.sitra.Transformer;
import cassandra.*;
import cassandra.impl.*;
import couchbase.*;
import couchbase.impl.*;

public class AsciiType2JSONString extends Rule<AsciiType, Unit<JSONStringImpl>> {

	public boolean check(AsciiType b)
	{
		return true;
	}
	
	public Unit<JSONStringImpl> build(AsciiType source, Transformer transformer)
	{
		CouchbaseFactoryImpl factory = new CouchbaseFactoryImpl();
		
		JSONStringImpl value = (JSONStringImpl)factory.createJSONString();
		value.setValue(source.getValue());
		
		return Unit.with(value);
		
		
	}
	
	@Override
	public void bind(Unit<JSONStringImpl> target, AsciiType source,
			Transformer transformer) {
		
		
	}
	
	public static void main(String[] args)
	{
		Transformer transformer = new SimpleTraceableTransformer();
		transformer.addRuleType(AsciiType2JSONString.class);
		
		CassandraFactory factory = new CassandraFactoryImpl();
		AsciiType string = factory.createAsciiType();
		string.setValue("This is ascii");
		
		Unit<JSONStringImpl> ub = transformer.transform(AsciiType2JSONString.class, string);
		System.out.println(ub.getA().getValue());
		
		
	}
}
