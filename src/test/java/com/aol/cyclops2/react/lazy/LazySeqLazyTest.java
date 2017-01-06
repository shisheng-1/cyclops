package com.aol.cyclops2.react.lazy;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.jooq.lambda.tuple.Tuple.tuple;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.function.Supplier;

import org.jooq.lambda.tuple.Tuple2;
import org.junit.Test;

import com.aol.cyclops2.react.base.BaseSeqLazyTest;
import cyclops.stream.FutureStream;

public class LazySeqLazyTest extends BaseSeqLazyTest{
	
	  @Test
	    public void testZipDifferingLength() {
	        List<Tuple2<Integer, String>> list = of(1, 2).zip(of("a", "b", "c", "d"))
	        		.foldLazy(s->s.toList())
	        		.get();

	        assertEquals(2, list.size());
	        assertTrue(asList(1,2).contains( list.get(0).v1));
	        assertTrue(""+list.get(1).v2,asList(1,2).contains( list.get(1).v1)); 
	        assertTrue(asList("a", "b", "c", "d").contains( list.get(0).v2));
	        assertTrue(asList("a", "b", "c", "d").contains( list.get(1).v2));
	       
	        
	    }


		@Override
		protected <U> FutureStream<U> of(U... array) {
			return FutureStream.of(array);
		}

		@Override
		protected <U> FutureStream<U> ofThread(U... array) {
			return FutureStream.freeThread(array);
		}

		@Override
		protected <U> FutureStream<U> react(Supplier<U>... array) {
			return FutureStream.react(array);
		}

	   
	
	

}
