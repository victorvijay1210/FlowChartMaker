package flowchartmaker.steps;

import flowchartmaker.pages.FlowCharMakerPages;
import flowchartmaker.utils.BrowserFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlowChartMakerSteps extends BrowserFactory {

	@Given("the user opens the flowchart application")
	public void User_Opens_Flowchart_Application() throws Exception {
		startApp();
		FlowCharMakerPages fc = new FlowCharMakerPages(BrowserFactory.getDriver());
		fc.clickDecideLater();

	}

	@When("^the user draws a flowchart by selecting (.+), (.+), (.+), (.+), (.+), and (.+)$")
	public void userDrawsFlowchart(String shape_1, String shape_2, String shape_3, String shape_4, String shape_5,
			String shape_6) {
		FlowCharMakerPages fc = new FlowCharMakerPages(BrowserFactory.getDriver());
		fc.clickShapes(shape_1);
		fc.clickShapes(shape_2);
		fc.clickShapes(shape_3);
		fc.clickShapes(shape_4);
		fc.clickShapes(shape_5);
		fc.clickShapes(shape_6);
	}
	
	@When("^the user enters (.+) inside (.+), (.+) inside (.+), (.+) inside (.+), (.+) inside (.+), (.+) inside (.+), and finally (.+) inside (.+)$")
	public void userEnterText(String text_1, String shape_1, String text_2, String shape_2, String text_3,
			String shape_3, String text_4, String shape_4, String text_5, String shape_5, String text_6, String shape_6)
			throws Exception {
		FlowCharMakerPages fc = new FlowCharMakerPages(BrowserFactory.getDriver());
		fc.MaxmizeBoard();
		fc.enterTextInShapes(shape_1, text_1);
		fc.enterTextInShapes(shape_2, text_2);
		fc.enterTextInShapes(shape_3, text_3);
		fc.enterTextInShapes(shape_4, text_4);
		fc.enterTextInShapes(shape_5, text_5);
		fc.enterTextInShapes(shape_6, text_6);
	}

	@Then("the user verifies that the flowchart is created")
	public void verifyFlowChartIsAvaialble() {
		FlowCharMakerPages fc = new FlowCharMakerPages(BrowserFactory.getDriver());
		fc.verifyFlowChartPresent();
	}

	@And("the user deletes the flowchart and verifies that the flowchart is not available")
	public void deleteFlowChat() throws Exception {
		FlowCharMakerPages fc = new FlowCharMakerPages(BrowserFactory.getDriver());
		fc.deleteFlowchat();
		fc.verifyFlowChartNotPresent();
	}
	
	@And("the user verifies that the text inside the flowchart shapes is correct")
	public void verifyText() {
		FlowCharMakerPages fc = new FlowCharMakerPages(BrowserFactory.getDriver());
		fc.verifyTextinsideShapes();
	}
}
