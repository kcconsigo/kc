package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	
	WebDriver driver = null;
	
	@Given("browser is open")
	public void browser_is_open() {
	    System.out.println("Inside Step - browser is open");
	    
	    System.setProperty("webdriver.chrome.driver", "C:/Users/KC/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    
	    driver = new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    
	    driver.manage().window().minimize();
	    
	    
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		System.out.println("Inside Step - user is on google page");
		
		driver.get("https://www.google.com/");
		
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() throws InterruptedException {
		System.out.println("Inside Step - user enters a text in search box");
		
		driver.findElement(By.name("q")).sendKeys("Puerto Gallera");
		
		Thread.sleep(2000);
	}

	@And("hits enter button")
	public void hits_enter_button() throws InterruptedException {
		System.out.println("Inside Step - hits enter");
		
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() throws InterruptedException{
		System.out.println("Inside Step - user is navigated to search result");
		
		driver.getPageSource().contains("Welcome to Puerto Galera | Puerto Galera Online Services");
		Thread.sleep(2000);
		
		driver.close();
		driver.quit();
	}


}
