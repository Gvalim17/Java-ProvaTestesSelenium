package automatizados.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizados.pageObject.ProdutoPO;

public class ProdutoTest3 extends BaseTest{

    public static ProdutoPO produtoPage;

    @BeforeClass
	public static void prepararTestes() {
		produtoPage = new ProdutoPO(driver);
	}


    @Test
    public void TC003_excluirProduto(){
        produtoPage.criarProduto(1, "HondaCB300", 20, 50000, new Date());
        produtoPage.buttonClose.click();
        produtoPage.buttonExcluir.click();
        int qtde = produtoPage.contaProdutos();
        assertTrue(qtde==0);
    }

}

