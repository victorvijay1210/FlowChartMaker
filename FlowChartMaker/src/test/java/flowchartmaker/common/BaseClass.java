//Developed by Vijay

package flowchartmaker.common;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import javax.swing.KeyStroke;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;


import flowchartmaker.utils.BrowserFactory;
import flowchartmaker.utils.Config;

public class BaseClass extends BrowserFactory {

	public static WebDriver driver;
	public Config config;

	

	public static Logger Log = LoggerFactory.getLogger(BaseClass.class);

	public void info(String message) {
		Log.info(message);

	}

	public void warn(String message) {

		Log.warn(message);

	}

	public void error(String message) {

		Log.error(message);

	}

	public void fatal(String message) {

		Log.trace(message);

	}

	public void debug(String message) {

		Log.debug(message);

	}

	 //Fluentwait for an element
	public boolean objFluentwait(WebElement element, int timeout, int polltime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(BrowserFactory.getDriver())
				.withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(polltime))
				.ignoring(NoSuchElementException.class);

		try {
			info(element.getText());
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;

		}

	}

	 //Fluentwait and click for an element
	public boolean objFluentwaitclick(WebElement element, int timeout, int polltime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(BrowserFactory.getDriver())
				.withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(polltime))
				.ignoring(NoSuchElementException.class);

		try {
			info(element.getText());
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	//scrollto particular element
	public void scrolltoElement(WebElement element) throws Exception {
		try {
			((JavascriptExecutor) BrowserFactory.getDriver()).executeScript("arguments[0].scrollIntoView(false);",
					element);
			Thread.sleep(500);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
   //javascript element click
	public void javascriptClick(WebElement element) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) BrowserFactory.getDriver();
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//actionclick
	public void actionsClick(WebElement element) {
		Actions builder = new Actions(BrowserFactory.getDriver());
		builder.moveToElement(element).click(element);

	}
    
	//action double click
	public void doubleClickelement(WebElement element) {
		Actions act = new Actions(BrowserFactory.getDriver());
		act.doubleClick(element).perform();
	}
	
	

	//move to child window
	public boolean movetoWindows() {

		try {

			Set<String> windows = BrowserFactory.getDriver().getWindowHandles();

			for (String window : windows) {
				getDriver().switchTo().window(window);
			}

			return true;
		}

		catch (Exception e) {

			return false;
		}
	}

	
	//handle default content
	public void handleDefaultContent() {
		getDriver().switchTo().defaultContent();
	}

	
//wait func
	public void Wait(long value) throws Exception {
		try {
			Thread.sleep(value * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean scrollDown() {
	    try {
	        JavascriptExecutor js = (JavascriptExecutor) BrowserFactory.getDriver();
	        // Scroll down by 500 pixels vertically
	        js.executeScript("window.scrollBy(0, 500);");
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception for debugging purposes
	        return false;
	    }
	}


	
	// method return property value
	public Boolean getObjectProperty(WebElement element, String propertytype) {

		Boolean result = null;
		try {
			info("Trying element property");

			switch (propertytype.toLowerCase()) {
			case "enabled":
				result = element.isEnabled();
				break;
			case "displayed":
				result = element.isDisplayed();
				break;
			case "selected":
				result = element.isSelected();
				break;

			}
			return result;

		}

		catch (Exception e) {
			e.printStackTrace();
			info("Element not found");
			return false;
		}

	}


//check alert is present
	public boolean isAlertPresent() {
		try {
			BrowserFactory.getDriver().switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

//dismiss alert by clicking cancel
	public void dismissAlert() {
		try {

			BrowserFactory.getDriver().switchTo().alert().dismiss();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			error("Alert not found");
		}
	}

	// accept alert by clicking ok
	public void acceptAlert() {
		try {
			BrowserFactory.getDriver().switchTo().alert().accept();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			error("Alert not found");
		}
	}

	
	public void RobotEnter() throws Exception {
		Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void Robotdoubletab() throws Exception {
		Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        
        
	}
	
	public void Robotsingletab() throws Exception {
		Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        
	}
	
	public void Robotescape() throws Exception{
		Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
	}
	
	public void Robotedelete() throws Exception{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
	}

	public  void typeTextWithRobot(String text) throws AWTException {
        Robot robot = new Robot();

        for (char character : text.toCharArray()) {
            try {
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(character);
                if (keyCode != KeyEvent.VK_UNDEFINED) {
                    robot.keyPress(keyCode);
                    robot.keyRelease(keyCode);
                } else {
                    System.out.println("Key code not found for character: " + character);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            robot.delay(100);
        }
    }
	}



