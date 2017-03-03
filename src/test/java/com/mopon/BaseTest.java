package com.mopon;

import org.junit.Assert;
import org.junit.Test;

public class BaseTest {

	@Test
	public void test() {
		Base base = new Base();
		Assert.assertEquals("Error", base.doSomething(), "Hello world!");
	}

}
