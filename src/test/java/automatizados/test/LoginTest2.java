package automatizados.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;


import automatizados.pageObject.LoginPO;

public class LoginTest2 extends BaseTest{
	
	private static LoginPO loginPage;
	
	@BeforeClass
	public static void prepararTestes() {
		loginPage = new LoginPO(driver);
	}
	
	
	@Test
	public void TC001_DeveLogarNoSistema() {

		loginPage.executarAcaoDeLogar("admin@admin.com","admin@123");
		
		String url = driver.getCurrentUrl();
		
		assertEquals(url, "file:///C:/Users/guilh/Downloads/sistema/produtos.html?teste=123");
	}

}
