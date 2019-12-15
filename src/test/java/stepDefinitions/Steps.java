package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {
	WebDriver driver;
	
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
//		WebDriverManager.firefoxdriver().setup();
//		driver=new FirefoxDriver();
	
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
//		WebDriverManager.edgedriver().setup();
//		driver=new EdgeDriver();
	
		driver.get("http://www.shop.demoqa.com");
	}
	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String arg1) {
		
	}

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item()  {
		
		List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
		 items.get(0).click();
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart()  {
		
		WebElement chooseColor=driver.findElement(By.id("pa_color"));
		 Select selectColor =new Select(chooseColor);
		 selectColor.selectByVisibleText("Pink");
		 
		
		 WebElement chooseSize=driver.findElement(By.id("pa_size"));
		 Select selectSize =new Select(chooseSize);
		 selectSize.selectByVisibleText("36");
		 
		 driver.findElement(By.xpath("//div[@class=\"single_variation_wrap\"]//button[@type=\"submit\"]")).click();
	
		 driver.findElement(By.linkText("Dismiss")).click();
		 driver.findElement(By.xpath("//a[@title='View cart']")).click();
		 driver.findElement(By.cssSelector(".checkout-button.alt")).click();
	}

	@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page()  {
		
		 driver.findElement(By.id("billing_first_name")).sendKeys("kezban");
		 driver.findElement(By.id("billing_last_name")).sendKeys("koca");
		 Select selectBillingCountry=new Select(driver.findElement(By.id("billing_country")));
		 selectBillingCountry.selectByValue("US");
		 
		 driver.findElement(By.id("billing_address_1")).sendKeys("102 kolin avenue");
		 driver.findElement(By.id("billing_city")).sendKeys("clinton");
		 
		 Select selectBillingState=new Select(driver.findElement(By.id("billing_state")));
		 selectBillingState.selectByIndex(4);;
		 
		 driver.findElement(By.id("billing_postcode")).sendKeys("13456");
		 
		 driver.findElement(By.id("billing_email")).sendKeys("kezbanKoca@gmail.com");
		 driver.findElement(By.id("billing_phone")).sendKeys("5555555555");
	}

	@When("^select same delivery address$")
	public void select_same_delivery_address() throws Throwable {
	    
	}

	@When("^select payment method as \"([^\"]*)\" payment$")
	public void select_payment_method_as_payment(String arg1) throws Throwable {
	    
	}

	@When("^place the order$")
	public void place_the_order()  {
		

//		//if(driver.findElement(By.linkText("Dismiss")).isDisplayed()) {driver.findElement(By.linkText("Dismiss")).click();}
//		 driver.findElement(By.id("terms")).click();
//		 driver.findElement(By.id("place_order")).click();
	}
}
