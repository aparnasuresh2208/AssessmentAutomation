package Carttest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomationExercise {

		WebDriver driver = new ChromeDriver();

		@BeforeClass
		public void setup(){
		
		System.setProperty("webdriver.Chrome.driver", "/Users/admin/Documents/chromedriver-mac-x64/chromedriver");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://automationexercise.com/");
		
		}

		@Test(priority=1)
		
		public void login() {
		//Login
		
		driver.findElement(By.linkText("Signup / Login")).click();
		driver.findElement(By.name("email")).sendKeys("aparnasuresh2208@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Aparna@123");
		driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
		
		  // Verify login
        WebElement loggedInText = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
        Assert.assertTrue(loggedInText.isDisplayed(), "Login failed!");
		
		}
		
		@Test(priority=2)
		public void SearchProduct() {
		
		//Clicking on Product
		
		driver.findElement(By.xpath("//a[@href='/products']")).click();
		driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("shirt");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		
		//View details
		
		driver.findElement(By.linkText("View Product")).click();
		}
		
		@Test(priority=3)
		public void Addtocart() {
		
		//Adding to Cart
		driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
        
		//View Cart
		driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();
		
		// Verify product is in cart
	    WebElement cartItem = driver.findElement(By.xpath("//td[@class='description']"));
	    Assert.assertTrue(cartItem.isDisplayed(), "Product not added to cart!");
		
		//proceeding to checkout
		driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
		
		}
		
		@Test(priority=4)
		public void Placeorder() {
			
		//Place Order
		driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
		
		//Entering Card details
		driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("01");
		driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("01");
		
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		// Verify if Order is placed
        WebElement Order = driver.findElement(By.xpath("//b[normalize-space()='Order Placed!']"));
        Assert.assertTrue(Order.isDisplayed(), "Order Failed!");
		
		System.out.println(driver.findElement(By.xpath("//b[normalize-space()='Order Placed!']")).getText());
		}
		
		@AfterClass
		public void Browserclose() {
		driver.quit();
		
		}


}
