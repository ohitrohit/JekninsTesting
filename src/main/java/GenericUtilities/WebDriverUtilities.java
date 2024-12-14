package GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contain all the genric methods for WebDriver 
 * @author rohitlodhi
 */
public class WebDriverUtilities {

	/**
	 * This method is use to Maximize the Window
	 * @param driver
	 */
	public void MaximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * this method is used to minimize the browser
	 * @param driver
	 */
	public void MinimizeTheBroswer(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * this method is used to perform mouseHovering Action
	 * @param driver
	 * @param element
	 */
	public void MouseHoveringAction(WebDriver driver , WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * this method is used to perform double click action
	 * @param driver
	 * @param element
	 */
	public void DoubleClickAction(WebDriver driver , WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	/**
	 * this method is used to perform right click action
	 * @param driver
	 * @param element
	 */
	public void RightClickAction(WebDriver driver , WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * this method is used to perform drag and drop action
	 * @param driver
	 * @param src
	 * @param trg
	 */
	public void DragAndDropAction(WebDriver driver , WebElement src , WebElement trg) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, trg).perform();
	}
	/**
	 * this method is use for wait for perticular timing(Implicitly wait)
	 * @param driver
	 * @param time
	 */
	public void WaitforSpeceficTiming(WebDriver driver , int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	/**
	 * this method is used for wait until title contains
	 * @param driver
	 * @param time
	 * @param title
	 */
	public void WaitUntilTitleContains(WebDriver driver , int time , String title) {
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(time));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public boolean WaitUntilTitleContainsForReg(WebDriver driver , int time , String title) {
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * this method is used for wait untill element visible
	 * @param driver
	 * @param time
	 * @param element
	 */
	public void WaitUntilElementToBeVisible(WebDriver driver , int time , WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * this method is used for wait untill element is clickable
	 * @param driver
	 * @param time
	 * @param element
	 */
	public void WaitUntilElementToBeClickable(WebDriver driver , int time , WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * this method is used for HandleDropDownByIndex
	 * @param element
	 * @param index
	 */
	public void HandleDropDownByIndex(WebElement element , int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * this method is used for HandleDropDownBy Visible Text
	 * @param element
	 * @param VisibleText
	 */
	public void HandleDropDownByVisibleText(WebElement element , String visibleText) {
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}
	
	/**
	 * this method is used for HandleDropdown by value
	 * @param element
	 * @param value
	 */
	public void HandleDropDownByValue(WebElement element ,String value ) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	/**
	 * this method is used for gettext of firstselected options from dropdown
	 * @param element
	 * @return
	 */
	public  String GetFirstSelectedOptionFromDropdown(WebElement element) {
		Select s = new Select(element);
		return s.getFirstSelectedOption().getText();
	}
	
	/**
	 * this method is used getAllOption from dropdown
	 * @param element
	 * @return
	 */
//	public java.util.List<String> GetAllOptionsFromDropdown(WebElement element) {
//		Select s = new Select(element);
//		java.util.List<WebElement> options = s.getOptions();
//		return options.stream().map(WebElement::getText).toList();
//	}
	/**
	 * this method is used to take screenshot
	 * @param driver
	 * @param name
	 * @throws IOException
	 */
	public void GetScreenShot(WebDriver driver , String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/"+name+".png");
		FileUtils.copyFile(src, dest);
		
	}
	
	/**
	 * this method is used to scroll into X , Y Loction
	 * @param driver
	 * @param x
	 * @param y
	 */
//	public void ScrollBarActionByCordinates(WebDriver driver , String x , String y) {
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.ScrollBy("+x+" , "+y+")");
//	}
	
	public void ScrollBarActionByCordinates(WebDriver driver, int x, int y) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
	    
	    Long initialScrollPosition = (Long) js.executeScript("return window.pageYOffset;");
	    System.out.println("Initial scroll position: " + initialScrollPosition);

	    
	    js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);

	    
	    Long finalScrollPosition = (Long) js.executeScript("return window.pageYOffset;");
	    System.out.println("Scrolled down by: " + (finalScrollPosition - initialScrollPosition) + " pixels.");
	}


	
	 public void scrollByPixels(WebDriver driver , int pixels) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
	    }
	 
	 public void scrollHalfPageDown(WebDriver driver ) {
	        int halfPageHeight = driver.manage().window().getSize().getHeight() / 2;
	        scrollByPixels(driver, halfPageHeight);
	    }
	 
	 public void scrollHalfPageUp(WebDriver driver ) {
	        int halfPageHeight = driver.manage().window().getSize().getHeight() / 2;
	        scrollByPixels( driver, -halfPageHeight);
	    }
	/**
	 * this method is used to scroll up to perticular element
	 * @param driver
	 * @param value
	 */
	public void ScrollBarActionByElement(WebDriver driver, WebElement value) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", value);
	}

	public void ScrollBarActionByElementForString(WebDriver driver, String value) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", value);
	}
	/**
	 * this method is used for switch to frame by index
	 * @param driver
	 * @param index
	 */
	public void SwitchToFrameByIndex(WebDriver driver , int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * this method is used for switch to frame by name
	 * @param driver
	 * @param name
	 */
	public void SwitchToFrameById_Name(WebDriver driver , String name) {
		driver.switchTo().frame(name);
	}
	
	/**
	 * this method is used for switch to frame by webelement present in the frame
	 * @param driver
	 * @param element
	 */
	public void SwitchToFrameByWebElement(WebDriver driver , WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * this method is used for switch to Default frame
	 * @param driver
	 */
	public void SwitchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * this method is used to accept the alert popup
	 * @param driver
	 */
	public void AcceptAlertPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * this method is used to dismiss the alert popup
	 * @param driver
	 */
	public void DissmissAlertPopup(WebDriver driver) {
		driver.switchTo().alert().dismiss();;
	}
	
	/**
	 * this method is used to get text from the alert popup
	 * @param driver
	 */
	public void GetTextAlertPopup(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	
	/**
	 * this method is used to send data to the alert popup
	 * @param driver
	 */
	public void SendDataAlertPopup(WebDriver driver , String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	
	 /**
     * Get the window handle of the current window.
     *
     * @return The window handle of the current window.
     */
    public String getCurrentWindowHandle(WebDriver driver) {
        return driver.getWindowHandle();
    }
	
    /**
     * Switch to a window based on the window title.
     *
     * @param windowTitle The title of the window to switch to.
     */
    public void switchToWindowByTitle(WebDriver driver ,String windowTitle) {
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
        	driver.switchTo().window(handle);
            if (driver.getTitle().equals(windowTitle)) {
                break;
            }
        }
    }
    
    
    /**
     * Switch back to the original window.
     */
    public  void switchBackToOriginalWindow(WebDriver driver , String originalWindowHandle) {
        driver.switchTo().window(originalWindowHandle);
    }
    
    /**
     * this method is used to file upload by robot class
     * @param Filepath
     * @throws AWTException
     */
    public void FileUploadUsingRobotClass(String Filepath) throws AWTException {
    	Robot r = new Robot();
    	StringSelection path = new StringSelection(Filepath);
    	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
    	r.keyPress(KeyEvent.VK_CONTROL);
    	r.keyPress(KeyEvent.VK_V);
    	r.keyRelease(KeyEvent.VK_CONTROL);
    	r.keyRelease(KeyEvent.VK_V);
    	r.keyPress(KeyEvent.VK_ENTER);
    	r.keyRelease(KeyEvent.VK_ENTER);
    	
    	
    }
    
	
}
