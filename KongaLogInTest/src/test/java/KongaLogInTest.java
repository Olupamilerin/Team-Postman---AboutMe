import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaLogInTest {
    private WebDriver driver;

@BeforeTest
    public void setUp() throws InterruptedException {
    //locate where the chromedriver is
    System.setProperty("webdriver.chrome.driver", "resources/chromedriver_win32/chromedriver.exe");
    //Open your Chrome browser
    driver = new ChromeDriver();
    //Input your konga page URL ("https://www.konga.com/")
    driver.get("https://www.konga.com/");
    //Test 1. Verify that user inputted the right URL in his browser
    String expectedUrl = "https://www.konga.com";
    String actualUrl = driver.getCurrentUrl();
    if (actualUrl.contains(expectedUrl)) {
        System.out.println("correct webpage");
    }else {
        System.out.println("wrong webpage");
    }
    Thread.sleep(5000);
    //Maximize the browser
    driver.manage().window().maximize();
    //Get the Page Title
    driver.findElement(By.xpath("/html/body/div/div/section/div[3]/nav/div[2]/div[1]/div/a/img")).click();
    Thread.sleep(5000);
}
  //1.Verify that user can click on the login/sign up button and it shows the login page.
 @Test (priority = 0)
      public void loginButton() throws InterruptedException {
     //Click on the logIN/Signup Button
     driver.findElement(By.xpath("/html/body/div/div/section/div[3]/nav/div[2]/div[1]/div/div/div[4]/a")).click();
     Thread.sleep(3000);
 }

    //2. Verify that user can successfully log in with valid email and valid password
 @Test (priority = 1)
  public void positiveLogin() throws InterruptedException {
     //Click on the Signup/Login Button
     driver.findElement(By.xpath("/html/body/div/div/section/div[3]/nav/div[2]/div[1]/div/div/div[4]/a")).click();
     Thread.sleep(3000);
     // Enter email address in email address field
     driver.findElement(By.id("username")).sendKeys("fpamilerin16@yahoo.com");
     // Enter password in the password field
     driver.findElement(By.id("password")).sendKeys("Pammy120@");
     Thread.sleep(3000);
     // Click on the Login Button
     driver.findElement(By.xpath("/html/body/div/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
     Thread.sleep(5000);
 }

   //3. Verify that when user click on the myAccount button, the drop down pops up
    @Test (priority = 2)
    public void myAccount() throws InterruptedException {
    //Click on myAccount Button
    driver.findElement(By.xpath("/html/body/div[1]/div/section/nav/div[2]"));
     Thread.sleep(3000);
}

   //4. Verify that the logout button redirects you back to the homepage when clicked.
    @Test (priority = 3)
    public void successfulLogout() throws InterruptedException {
    //Click on the logout button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
    String expectedUrl = "https://www.konga.com";
    String actualUrl = driver.getCurrentUrl();
    if (actualUrl.contains(expectedUrl))
         System.out.println("correct webpage");
    else
        System.out.println("wrong webpage");
    Thread.sleep(5000);
}


    //Verify that user cannot login with incorrect login details
    @Test (priority = 4)
    public void negativeLogin() throws InterruptedException {
        //Click on the Signup/Login Button
        driver.findElement(By.xpath("/html/body/div/div/section/div[3]/nav/div[2]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(3000);
        // Enter email address in email address field
        driver.findElement(By.id("username")).sendKeys("fpamilereen16@yahoo.com");
        // Enter password in the password field
        driver.findElement(By.id("password")).sendKeys("Pammie120@");
        Thread.sleep(3000);
        // Click on the Login Button
        driver.findElement(By.xpath("/html/body/div/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }
     @AfterTest
     public void closeBrowser(){
        //Quit Browser
         driver.quit();
    }
}
