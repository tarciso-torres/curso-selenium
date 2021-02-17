import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCadastro {
	
	private WebDriver driver;
	
	private CampoTreinamentoPage page;
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		page = new CampoTreinamentoPage(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void deveFazerCadastroComSucesso() {
		page.setNome("Tarciso");
		page.setSobrenome("Torres");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsporte("Natacao");
		page.clicarBotaoCadastrar();
		
		Assert.assertTrue(page.getResultadoCadastro().startsWith("Cadastrado!"));
		Assert.assertTrue(page.getNomeCadastro().endsWith("Tarciso"));
		Assert.assertEquals("Sobrenome: Torres", page.getSobrenomeCadastro());
		Assert.assertEquals("Sexo: Masculino", page.getSexoCadastro());
		Assert.assertEquals("Comida: Pizza", page.getComidaCadastro());
		Assert.assertEquals("Escolaridade: mestrado", page.getEscolaridadeCadastro());
		Assert.assertEquals("Esportes: Natacao", page.getEsporteCadastro());
	}

}