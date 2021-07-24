package br.programar.servicos;

import org.junit.Assert;
import org.junit.Test;

public class Asserttest {

	@Test
	public void test() {
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		Assert.assertEquals(5, 5);
		Assert.assertNotEquals(5, 0);
		Assert.assertSame(4,4);
		Assert.assertNotSame(5,4);
		Assert.assertNotNull(1);
		Assert.assertNull(null);
	}
}
