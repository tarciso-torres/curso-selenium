import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {

	private DSL dsl;

	public CampoTreinamentoPage(WebDriver driver) {
		this.dsl = new DSL(driver);
	}

	public void setNome(String nome) {
		dsl.escrever("elementosForm:nome", nome);
	}

	public void setSobrenome(String sobrenome) {
		dsl.escrever("elementosForm:sobrenome", "Torres");
	}

	public void setSexoMasculino() {
		dsl.clicarRadio("elementosForm:sexo:0");
	}

	public void setSexoFeminino() {
		dsl.clicarRadio("elementosForm:sexo:1");
	}

	public void setComidaCarne() {
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
	}

	public void setComidaPizza() {
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
	}

	public void setComidaVegetariano() {
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
	}

	public void setEscolaridade(String escolaridade) {
		dsl.selecionarCombo("elementosForm:escolaridade", escolaridade);
	}

	public void setEsporte(String... modalidades) {
		for(String modalidade : modalidades) {			
			dsl.selecionarCombo("elementosForm:esportes", modalidade);
		}
	}

	public void clicarBotaoCadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}

	public String getResultadoCadastro() {
		return dsl.obterTexto("resultado");
	}

	public String getNomeCadastro() {
		return dsl.obterTexto("descNome");
	}

	public String getSobrenomeCadastro() {
		return dsl.obterTexto("descSobrenome");
	}

	public String getSexoCadastro() {
		return dsl.obterTexto("descSexo");
	}

	public String getComidaCadastro() {
		return dsl.obterTexto("descComida");
	}

	public String getEscolaridadeCadastro() {
		return dsl.obterTexto("descEscolaridade");
	}

	public String getEsporteCadastro() {
		return dsl.obterTexto("descEsportes");
	}

}
