package automatizados.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizados.pageObject.ProdutoPO;

public class CriarProdutoTest2 extends BaseTest{

    public static ProdutoPO produtoPage;

    @BeforeClass
	public static void prepararTestes() {
		produtoPage = new ProdutoPO(driver);
	}

    @Test
    public void TC002_naoDeveCriarOProduto(){
        produtoPage.criarProduto(0, "", 0, 0, new Date());
        int qtde = produtoPage.contaProdutos();

		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
    }
    
}
