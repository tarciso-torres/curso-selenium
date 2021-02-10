import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {
	
	@Test
	public void test() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().setSize(new Dimension(1200, 765));
		
		Assert.assertEquals("Google", driver.getTitle());
		
		driver.quit();
	}

}
