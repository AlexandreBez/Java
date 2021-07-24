package br.programar.servicos;

import org.junit.Assert;
import org.junit.Test;


public class CalculadoraTeste {

	@Test
	public void deveSomarDoisNumeros() {
		
		int a = 5;
		int b = 3;
		Calculadora calc = new Calculadora();
		
		int resultado = calc.somar(a, b);
		
		Assert.assertEquals(8, resultado);
	}
	
	@Test
	public void devedividirDoisNumeros() {
		
		int a = 10;
		int b = 2;
		Calculadora calc = new Calculadora();
		
		int resultado = calc.dividir(a, b);
		
		Assert.assertEquals(5, resultado);
	}
	
	@Test
	public void devemultiplicarDoisNumeros() {
		
		int a = 5;
		int b = 5;
		Calculadora calc = new Calculadora();
		
		int resultado = calc.multiplicar(a, b);
		
		Assert.assertEquals(25, resultado);
	}
	
	@Test
	public void deveSubtrairDoisNumeros() {
		
		int a = 5;
		int b = 3;
		Calculadora calc = new Calculadora();
		
		int resultado = calc.subtrair(a, b);
		
		Assert.assertEquals(2, resultado);
	}
}
