package GenericUtilities;

/**
 * This class consists of all the configuration annotations of TestNG.
 * It includes database connection handling, browser initialization, 
 * and WebDriver setup for running test cases.
 * 
 * @author rohit
 */


import org.testng.ITestResult;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public WebDriverUtilities wUtil = new WebDriverUtilities();
    public JavaUtilities jUtil = new JavaUtilities();
    public PropertiesFileUtilities pUtil;
    protected WebDriver driver;

    @BeforeSuite()
    public void BS_Config()  {
        
        System.out.println("-----DataBase Connection Established-----");
    }

    //@BeforeClass()
    public void bcConfig() {
        
    }

    @BeforeMethod()
    public void bmConfig(){

        
        String environment = System.getProperty("environment");
        if (environment == null || environment.isEmpty()) {
            environment = "DEV"; 
        }
        pUtil = new PropertiesFileUtilities(environment);
//
//        
//        String BROWSER = pUtil.getData("Browser");
//
//        if (BROWSER.equalsIgnoreCase("Chrome")) {
//            WebDriverManager.chromedriver().setup();
//            
//            
//            ChromeOptions options = new ChromeOptions();
//            options.setAcceptInsecureCerts(true);  
//            options.addArguments("--ignore-certificate-errors");  
//            options.addArguments("--disable-web-security");  
//            options.addArguments("force-device-scale-factor=1");  
//            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//            options.addArguments("ignore-certificate-errors");
//            options.addArguments("--disable-blink-features=AutomationControlled");
//            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--no-sandbox");
//            //options.addArguments("--headless");
////            options.addArguments("--disable-gpu"); // Applicable on Windows, but not needed on Linux
//            options.addArguments("--remote-allow-origins=*");
//            options.addArguments("--disable-dev-tools");
//
//            // Add headless option for Linux environments
//            if (System.getProperty("os.name").toLowerCase().contains("linux")) {
//                options.addArguments("--headless");  // Run in headless mode for Linux servers
//                options.addArguments("--remote-debugging-port=9222");  // Required for headless mode
//            }
//
//            driver = new ChromeDriver(options);
//            System.out.println("-----Chrome Browser Launched with Security Settings and 100% Zoom-----");
//            
//        } else if (BROWSER.equalsIgnoreCase("Firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//            System.out.println("-----Firefox Browser Launched-----");
//            
//        } else {
//            System.out.println("Invalid browser name");
//        }
//
//        
//        wUtil.MaximizeTheBrowser(driver);
//        wUtil.WaitforSpeceficTiming(driver, 10);
    }

    @AfterMethod()
    public void amConfig(ITestResult result) {
    	
    	   
    	  
        String methodName = result.getMethod().getMethodName();
        StringBuilder messageBuilder = new StringBuilder();

        if (result.getStatus() == ITestResult.SUCCESS) {
            messageBuilder.append("***** TEST PASSED *****\n")
                          .append("Test method: ").append(methodName).append(" passed successfully.\n")
                          .append("*************************\n");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            messageBuilder.append("***** TEST FAILED *****\n")
                          .append("Test method: ").append(methodName).append(" failed.\n")
                          .append("Reason for failure: ").append(result.getThrowable().getMessage()).append("\n")
                          .append("*************************\n");
        }

        
        if (messageBuilder.length() > 0) {
            System.out.println(messageBuilder.toString());
        }
        
//        driver.quit();
//        System.out.println("-----Browser Closed Successfully-----");
    }

    //@AfterClass()
    public void acConfig() {
        
    }

    //@AfterTest()
    
    @AfterSuite()
    public void AS_Config() {
      
        System.out.println("-----DataBase Connection Closed-----");
    }
}