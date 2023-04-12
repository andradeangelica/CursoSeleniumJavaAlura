package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;

public class LoginPage extends PageObject {
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	
	public LoginPage() {
		super(null);
		this.browser.navigate().to(URL_LOGIN);
		}


	public void preencheFormularioDeLogin(String username, String password) {
		browser.findElement(By.cssSelector("#login-form > div:nth-child(1) > input")).sendKeys(username);
		browser.findElement(By.cssSelector("#login-form > div:nth-child(2) > input")).sendKeys(password);	
	}

	public LeiloesPage efetuaLogin() {
		browser.findElement(By.cssSelector("#login-form > button")).click();
		return new LeiloesPage(browser);
		
	}

	public boolean isPaginaDeLogin() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}

	public String getNomeUsuarioLogado() {
		try {
			return browser.findElement(By.cssSelector("body > div.logo-container.mb-3.p-3.d-flex.justify-content-between > span > span")).getText();
		}catch (NoSuchElementException e) {
			return null;
		}
}

	public void navegaParaPaginaDeLances() {
		this.browser.navigate().to("http://localhost:8080/leiloes/2");
		
	}

	public boolean contemTexto(String texto) {
		return browser.getPageSource().contains(texto);
	}

	public boolean isPaginaDeLoginComDadosInvalidos() {
		return browser.getCurrentUrl().equals(URL_LOGIN + "?error");
	}
	

}