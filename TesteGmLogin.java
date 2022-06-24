package br.senai.sp.testegamemania;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGmLogin {
	private WebDriver driver;
	
	@Before
	public void Setup() {
		driver.get("http://localhost:4200/");
		
		driver.findElement(By.xpath("/html/body/app-root/app-header/section/div/div[1]/a[7]")).click();
		
		WebElement inputEmail = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		WebElement inputSenha = driver.findElement(By.xpath("//*[@id=\"senha\"]"));
		WebElement botao = driver.findElement(By.xpath("/html/body/app-root/app-login/div/form[1]/button"));
		
		String[] listaSenhas = {"123senha", "9013senha", "senha1234"};
						
		for(int tentativas = 0; tentativas < 3; tentativas++) {
			try {
				
				inputEmail.clear();
				inputSenha.clear();
				
				inputEmail.sendKeys("saymon@email.com");
				//inputSenha.sendKeys("senha1234");
				inputSenha.sendKeys(listaSenhas[tentativas]);
				botao.click();
				
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		WebElement mensagem = driver.findElement(By.id("mensagem"));
		
		System.out.println(mensagem.getText());
	}
}
