package automatizados.pageObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO {

    public ProdutoPO(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    @FindBy(xpath = "//*[@id=\"btn-adicionar\"]")
    public WebElement buttonCriar;

    @FindBy(xpath = "//*[@id=\"codigo\"]")
    public WebElement inputCodigo;
    
    @FindBy(xpath = "//*[@id=\"nome\"]")
    public WebElement inputNome;

    @FindBy(xpath = "//*[@id=\"quantidade\"]")
    public WebElement inputQtde;

    @FindBy(xpath = "//*[@id=\"valor\"]")
    public WebElement inputValor;

    @FindBy(xpath = "//*[@id=\"data\"]")
    public WebElement inputData;

    @FindBy(xpath = "//*[@id=\"btn-salvar\"]")
    public WebElement buttonSalvar;

    @FindBy(xpath = "//*[@id=\"mensagem\"]")
    public WebElement spanMensagem;

    @FindBy(xpath = "/html/body/div/div[2]/table/tbody")
    public WebElement linhaProdutos;

    public String obterMensagem() {
		return this.spanMensagem.getText();
	}

    public void criarProduto(int codigo, String nome, int qtde, int valor, Date data){
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormat = formatoData.format(data);

        buttonCriar.click();
        buttonCriar.click();
        escrever(inputCodigo, Integer.toString(codigo));
        escrever(inputNome, nome);
        escrever(inputQtde, Integer.toString(qtde));
        escrever(inputValor, Integer.toString(valor));
        escrever(inputData, dataFormat);
        buttonSalvar.click();
    }

    private void escrever(WebElement input, String texto) {
	input.clear();
	input.sendKeys(texto + Keys.TAB);

	}

    public int contaProdutos() { 
        List<WebElement> linhas = linhaProdutos.findElements(By.tagName("tr"));
        // return linhas.isEmpty(); caso queira fazer voltando boolean
        return linhas.size();
    }
}
