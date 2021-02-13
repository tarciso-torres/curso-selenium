import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://www.google.com");
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void test() {
		
		driver.manage().window().setSize(new Dimension(1200, 765));
		
		Assert.assertEquals("Google", driver.getTitle());
		
		driver.quit();
	}

}
