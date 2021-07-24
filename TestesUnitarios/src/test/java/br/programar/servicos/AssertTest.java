package br.programar.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.programar.entidades.Usuario;

public class AssertTest {
	
	@Test
	public void test() {
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		Assert.assertEquals("Erro de comparacao", 1, 1);
		Assert.assertEquals(0.512345, 0.512, 0.001);
		Assert.assertEquals(Math.PI, 3.14, 0.01);
		
		int i = 5;
		Integer i2 = 5;
		Assert.assertEquals(Integer.valueOf(i), i2);
		Assert.assertEquals(i, i2.intValue());
		
		Assert.assertEquals("abobrinha", "abobrinha");
		Assert.assertTrue("abobrinha".equalsIgnoreCase("Abobrinha"));
		Assert.assertTrue("abobrinha".startsWith("ab"));
		
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		Usuario u3 = null;
		
		Assert.assertEquals(u1, u2);
		
		Assert.assertNotSame(u1, u2);
		
		Assert.assertNull(u3);
		
	}

}
