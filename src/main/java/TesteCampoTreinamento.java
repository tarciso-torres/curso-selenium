import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; 

public class TesteCampoTreinamento {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@Test
	public void teste() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste do sucesso");
		Assert.assertEquals("Teste do sucesso",  driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		driver.quit();
		
	}
	
	@Test
	public void deveInteragirComTextArea() {
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste sugestão\n\nNova linha\nMais uma linha");
		Assert.assertEquals("Teste sugestão\n\nNova linha\nMais uma linha",  driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		driver.quit();
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		driver.quit();
	}
	
	@Test
	public void deveInteragirComCheckbox() {
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		
		driver.quit();
	}

}
