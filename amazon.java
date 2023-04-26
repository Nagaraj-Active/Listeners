 package Listners;
 import org.testng.Assert;
import org.testng.AssertJUnit;


 import java.time.Duration;

 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.testng.annotations.*;
 import io.github.bonigarcia.wdm.WebDriverManager;
 
@Listeners(Listners.listner_amzone.class)
  public class amazon 
  {
  WebDriver driver;
  @Test
  void setup()
  {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.amazon.in");
  }
  @Test(priority=1)
  void logocheck()
  {
	boolean logo=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();
	AssertJUnit.assertEquals(logo, true);
  }		
  @Test(priority=2)
  void title()
  {
	AssertJUnit.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	
  }
  @Test(priority=3)
  void text()
  {
	Assert.fail();
  }
   @Test( priority=4, dependsOnMethods = {"text"})
   void skip()
  {
   Assert.fail();
  }
   @AfterClass
   void exit()
  {  
	driver.quit();
  }

}
