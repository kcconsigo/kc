package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	By txt_username = By.id("name");
	
	By txt_password = By.id("password");
	
	By btn_login = By.xpath("//button[@id='login']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
		if(!driver.getTitle().equals("TestProject Demo")) {
			throw new IllegalStateException("This is not login page"+driver.getCurrentUrl());
		}
	}
	
	public void enterUsername(String name) {
		
		driver.findElement(txt_username).sendKeys(name);
	}
	
	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void enterBtnLogin() {
		driver.findElement(btn_login).click();
	}
	
	public void loginValidUser(String username, String password) {
		driver.findElement(txt_username).sendKeys(username);
		driver.findElement(txt_password).sendKeys(password);
		driver.findElement(btn_login).click();
	}

}
