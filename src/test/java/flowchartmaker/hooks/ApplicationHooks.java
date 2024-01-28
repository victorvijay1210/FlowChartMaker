package flowchartmaker.hooks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import flowchartmaker.utils.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class ApplicationHooks extends BrowserFactory {

	@After(order = 1)
	public void closebrowser() {

		closeApp();
	}

	@AfterStep
	public void stepWiseScreenshot(Scenario scenario) {
		TakesScreenshot ts = (TakesScreenshot) BrowserFactory.getDriver();
		byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(src, "image/png", "stepwiseSC_" + new SimpleDateFormat("MMddyyyy_HH_mm_ss").format(new Date()));

	}

}
