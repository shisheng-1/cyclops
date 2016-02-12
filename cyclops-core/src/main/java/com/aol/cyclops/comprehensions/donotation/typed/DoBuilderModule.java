package com.aol.cyclops.comprehensions.donotation.typed;

import java.util.function.Function;

import lombok.Value;

public interface DoBuilderModule {
	@Value
	public static class Assignment{

		Function f;
	}
	@Value
	public static  class Entry{
		String key;
		Object value;
	}
	@Value
	public class Guard{
		
		Function f;
	}

}
