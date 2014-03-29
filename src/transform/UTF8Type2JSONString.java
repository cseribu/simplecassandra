package transform;

import uk.ac.bham.cs.tuple.Unit;
import uk.ac.bham.cs.m2m.sitra.SimpleTraceableTransformer;
import uk.ac.bham.cs.m2m.sitra.Rule;
import uk.ac.bham.sitra.Transformer;
import cassandra.*;
import cassandra.impl.*;
import couchbase.*;
import couchbase.impl.*;

public class UTF8Type2JSONString extends Rule<UTF8Type, Unit<JSONStringImpl>> {

	public boolean check(UTF8Type b)
	{
		return true;
	}
	
	public Unit<JSONStringImpl> build(UTF8Type source, Transformer transformer)
	{
		CouchbaseFactoryImpl factory = new CouchbaseFactoryImpl();
		
		JSONStringImpl value = (JSONStringImpl)factory.createJSONString();
		value.setValue(source.getValue());
		
		return Unit.with(value);
		
		
	}
	
	@Override
	public void bind(Unit<JSONStringImpl> target, UTF8Type source,
			Transformer transformer) {
		
		
	}
	
	public static void main(String[] args)
	{
		Transformer transformer = new SimpleTraceableTransformer();
		transformer.addRuleType(UTF8Type2JSONString.class);
		
		CassandraFactory factory = new CassandraFactoryImpl();
		UTF8Type string = factory.createUTF8Type();
		string.setValue("This is utf8");
		
		Unit<JSONStringImpl> ub = transformer.transform(UTF8Type2JSONString.class, string);
		System.out.println(ub.getA().getValue());
		
		
	}
}
