package com.aol.cyclops.validation;

import static com.aol.cyclops.control.Validator.of;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.jooq.lambda.tuple.Tuple;

import lombok.Value;

import org.junit.Test;

import com.aol.cyclops.control.Validator;
import com.aol.cyclops.util.validation.ValidationResults;

import fj.data.Validation;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
public class ValidationAccumulateUntilFailTest {

	@Value
	static class User { 
		int age;
		String email;
	}
	@Test
	public void testAccumulateUntilFailSuccess() {
		ValidationResults<String,String> results  = Validator.of((User user)->user.age>18, "too young", "age ok")
												.add(Tuple.tuple((User user)->user.email!=null, "user email null","email ok"))
												.accumulateUntilFail(new User(20,"email@email.com"));
	
		assertThat(results.getResults().size(),equalTo(2));
	}
	@Test
	public void testAccumulateUntilFailAtStart() {
		ValidationResults<String,String> results  = Validator.of((User user)->user.age>18, "too young", "age ok")
												.add(Tuple.tuple((User user)->user.email!=null, "user email null","email ok"))
												.accumulateUntilFail(new User(10,"email@email.com"));
	
		assertThat(results.getResults().size(),equalTo(1));
	}
	
	
}
