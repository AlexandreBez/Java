import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	@Test
	public void testMozila() {
		
		System.setProperty("webdriver.gecko.driver", "/home/countzero/Área de trabalho/Java/Selenium/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///" 
			+ System.getProperty("user.dir") 
			+ "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita!");		
		Assert.assertEquals("Teste de escrita!", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void deveinteragirComtextoArea() {
		
		System.setProperty("webdriver.gecko.driver", "/home/countzero/Área de trabalho/Java/Selenium/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///" 
			+ System.getProperty("user.dir") 
			+ "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste");		
		Assert.assertEquals("Teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		
		System.setProperty("webdriver.gecko.driver", "/home/countzero/Área de trabalho/Java/Selenium/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///" 
			+ System.getProperty("user.dir") 
			+ "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		driver.quit();
	}
	
	@Test
	public void deveInteragirComCheckBox() {
		
		System.setProperty("webdriver.gecko.driver", "/home/countzero/Área de trabalho/Java/Selenium/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///" 
			+ System.getProperty("user.dir") 
			+ "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:comidafavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidafavorita:2")).isSelected());
		driver.quit();
	}
	
	@Test
	public void deveInteragirComComboBox() {
		
		System.setProperty("webdriver.gecko.driver", "/home/countzero/Área de trabalho/Java/Selenium/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///" 
			+ System.getProperty("user.dir") 
			+ "/src/main/resources/componentes.html");

		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByIndex(2);
		combo.selectByValue("superior");
		combo.selectByVisibleText("Doutorado");
		
		Assert.assertEquals("Doutorado", combo.getFirstSelectedOption().getText());
		
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Doutorado")) {
				encontrou = true;
				System.out.println("Encontrou");
				break;
			}
		}
		Assert.assertTrue(encontrou);
		
		driver.quit();
	}
	
	@Test
	public void deveVerificarValoresComboMultiplos() {
		
		System.setProperty("webdriver.gecko.driver", "/home/countzero/Área de trabalho/Java/Selenium/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///" 
			+ System.getProperty("user.dir") 
			+ "/src/main/resources/componentes.html");

		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Futebol");
		combo.selectByVisibleText("Karate");
		combo.selectByVisibleText("Corrida");

		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(4, allSelectedOptions.size());
		
		combo.deselectByVisibleText("Karate");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
		driver.quit();
	}
	
	@Test
	public void deveInteragirComBotoes() {
		
		System.setProperty("webdriver.gecko.driver", "/home/countzero/Área de trabalho/Java/Selenium/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///" 
			+ System.getProperty("user.dir") 
			+ "/src/main/resources/componentes.html");

		driver.findElement(By.id("buttonSimple")).click();
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void deveInteragirComLinks() {
		
		System.setProperty("webdriver.gecko.driver", "/home/countzero/Área de trabalho/Java/Selenium/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///" 
			+ System.getProperty("user.dir") 
			+ "/src/main/resources/componentes.html");

		driver.findElement(By.linkText("Voltar")).click();
		WebElement link = driver.findElement(By.linkText("Voltar"));
//		Assert.fail();
		driver.quit();
	}
}
