package flowchartmaker.utils;

import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;

public class BrowserFactory {

	public Config config;
	Properties pro;

	protected static ThreadLocal<WebDriver> TLdriver = new ThreadLocal<>();

	public static synchronized WebDriver getDriver() {
		return TLdriver.get();

	}

	public WebDriver startApp() {
	    config=new Config();
		pro = config.init_properties();
		String browsername = pro.getProperty("Browser");
		String URL = pro.getProperty("URL");
		if (browsername.equalsIgnoreCase("Chrome")) {
			TLdriver.set(ThreadGuard.protect(new ChromeDriver()));

		} else if (browsername.equalsIgnoreCase("Firefox")) {
			TLdriver.set(ThreadGuard.protect(new FirefoxDriver()));
		}

		else if(browsername.equalsIgnoreCase("Edge")) {
			TLdriver.set(ThreadGuard.protect(new EdgeDriver()));
		}
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		getDriver().get(URL);
		return getDriver();
	}
  

	public void closeApp() {
		getDriver().quit();
	}

	}
