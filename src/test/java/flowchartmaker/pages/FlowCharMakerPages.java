package flowchartmaker.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import flowchartmaker.common.BaseClass;

public class FlowCharMakerPages {

	public WebDriver driver;
	BaseClass bc = new BaseClass();

	public FlowCharMakerPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Decide later']")
	public WebElement Decidelater;

	@FindBy(xpath = "//body//div[@class='geSidebarContainer']//div//div//a[7]")
	public WebElement Circle;

	@FindBy(xpath = "//a[2]//a[1]")
	public WebElement Rectangle;

	@FindBy(xpath = "//a[5]//a[1]")
	public WebElement RoundRectangle;

	@FindBy(xpath = "//a[4]//a[1]")
	public WebElement Diamond;

	@FindBy(xpath = "//a[8]//a[1]")
	public WebElement Hexagon;

	@FindBy(xpath = "//a[10]//a[1]")
	public WebElement Process;

	@FindBy(xpath = "//a[normalize-space()='100%'] |//td[normalize-space()='100%']")
	public WebElement zoom100;

	@FindBy(xpath = "//td[normalize-space()='25%'] | //a[normalize-space()='25%']")
	public WebElement zoom25;

	@FindBy(xpath = "//div[@title='Space+Drag to pan']//*[name()='svg']")
	public WebElement board;

	@FindBy(xpath = "(//*[name()='ellipse'])[4]")
	public WebElement CircleText;

	@FindBy(xpath = "(//*[name()='rect'])[29]")
	public WebElement RectText;

	@FindBy(xpath = "(//*[name()='path'])[129]")
	public WebElement DiamondText;

	@FindBy(xpath = "(//*[name()='rect'])[30]")
	public WebElement RoundRectText;

	@FindBy(xpath = "(//*[name()='rect'])[31]")
	public WebElement ProcessText;

	@FindBy(xpath = "(//*[name()='path'])[138]")
	public WebElement HexoText;

	@FindBy(xpath = "//div[@class='geDiagramContainer geDiagramBackdrop']//img[2]")
	public WebElement Connectorarrow;

	public void clickDecideLater() {
		bc.objFluentwaitclick(Decidelater, 5, 3);
		MinimizeBoard();
	}

	public void clickShapes(String Shape) {
		bc.info(Shape);

		switch (Shape.toLowerCase()) {

		case "rectangle":
			bc.objFluentwaitclick(Rectangle, 5, 3);
			bc.objFluentwaitclick(Connectorarrow, 5, 3);
			break;
		case "roundrectangle":
			bc.objFluentwaitclick(RoundRectangle, 5, 3);
			bc.objFluentwaitclick(Connectorarrow, 5, 3);
			break;
		case "diamond":
			bc.objFluentwaitclick(Diamond, 5, 3);
			bc.objFluentwaitclick(Connectorarrow, 5, 3);
			break;
		case "hexagon":
			bc.objFluentwaitclick(Hexagon, 5, 3);
			bc.objFluentwaitclick(Connectorarrow, 5, 3);
			break;
		case "process":
			bc.objFluentwaitclick(Process, 5, 3);
			bc.objFluentwaitclick(Connectorarrow, 5, 3);
			break;

		case "circle":
			bc.objFluentwaitclick(Circle, 5, 3);
			bc.objFluentwaitclick(Connectorarrow, 5, 3);
			break;

		default:
			bc.info("Invalid Shape");
		}
	}

	public void enterTextInShapes(String Shape,String Text) throws Exception {
		
			switch (Shape.toLowerCase()) {
		case "rectangle":
			bc.Robotdoubletab();
			bc.typeTextWithRobot(Text);
			bc.Robotescape();
			break;
		case "roundrectangle":
			bc.Robotdoubletab();
			bc.typeTextWithRobot(Text);
			bc.Robotescape();
			break;
		case "diamond":
			bc.Robotdoubletab();
			bc.typeTextWithRobot(Text);
			bc.Robotescape();
			break;
		case "hexagon":
			bc.Robotsingletab();
			bc.typeTextWithRobot(Text);
			bc.Robotescape();
			break;
		case "process":
			bc.Robotdoubletab();
			bc.typeTextWithRobot(Text);
			bc.Robotescape();
			break;

		case "circle":
			bc.Robotdoubletab();
			bc.typeTextWithRobot(Text);
			bc.Robotescape();
			break;

		default:
			bc.info("Invalid Shape");
		}
		
	}

	
	public void verifyFlowChartPresent() {
		assertTrue(CircleText.isDisplayed());
				
	}
	
	public void verifyFlowChartNotPresent() {
		assertFalse(bc.getObjectProperty(Connectorarrow, "Displayed"));
				
	}
	
	
	public void deleteFlowchat() throws Exception {
		bc.Robotedelete();
				
	}

	public void MinimizeBoard() {
		bc.objFluentwaitclick(zoom100, 5, 3);
		bc.objFluentwaitclick(zoom25, 5, 3);
	}

	public void MaxmizeBoard() {
		bc.objFluentwaitclick(zoom25, 5, 3);
		bc.objFluentwaitclick(zoom100, 5, 3);
	}

}
