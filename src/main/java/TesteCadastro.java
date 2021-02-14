import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCadastro {
	
	private WebDriver driver;
	
	private DSL dsl;
	
	private CampoTreinamentoPage page;
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		dsl = new DSL(driver);
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
	
	@Test
	public void deveValidarNomeObrigatorio(){
		page.clicarBotaoCadastrar();
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarSobrenomeObrigatorio(){
		page.setNome("Nome qualquer");
		page.clicarBotaoCadastrar();
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarSexoObrigatorio(){
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.clicarBotaoCadastrar();
		Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarComidaVegetariana(){
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.setSexoFeminino();
		page.setComidaCarne();
		page.setComidaVegetariano();
		page.clicarBotaoCadastrar();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarEsportistaIndeciso(){
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.setSexoFeminino();
		page.setComidaCarne();
		page.setEsporte("Karate", "O que eh esporte?");
		page.clicarBotaoCadastrar();
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
	}

}