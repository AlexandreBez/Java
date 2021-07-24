import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TesteGoogle {
	
	@Test
	public void testMozila() {
		
		System.setProperty("webdriver.gecko.driver", "/home/countzero/Área de trabalho/Java/Selenium/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
//		driver.manage().window().setSize(new Dimension(1280, 765));
		driver.manage().window().maximize();
//		System.out.println(driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
	
//	@Test
//	public void testChrome() {
//		
//		System.setProperty("webdriver.chrome.driver", "/home/countzero/Área de trabalho/Java/Selenium/chromedriver");
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://www.google.com");
//		Assert.assertEquals("Google", driver.getTitle());
//	}
//	
//	@Test
//	public void testSeIssoNaoèUmVirusNaoSeiOQueE() {
//		
//		System.setProperty("webdriver.ie.driver", "/home/countzero/Área de trabalho/Java/Selenium/virusIE.bat");
//		WebDriver driver = new InternetExplorerDriver();
//		driver.get("http://www.google.com");
//		driver.manage().window().setSize(new Dimension(1280, 765));
//		Assert.assertEquals("Google", driver.getTitle());
//	}
	
}
