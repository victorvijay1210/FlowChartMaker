package flowchartmaker.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

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

	@FindBy(xpath = "//a[14]//a[1]")
	public WebElement cloud;

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

	@FindBy(xpath = "//*[name()='ellipse' and contains(@cx,'1290')]")
	public WebElement CircleText;

	@FindBy(xpath = "(//*[name()='path' and contains(@fill,'rgb(255, 255, 255)')])[1]")
	public WebElement cloudText;

	@FindBy(xpath = "(//*[name()='path' and contains(@fill,'rgb(255, 255, 255)')])[2]")
	public WebElement DiamondText;

	@FindBy(xpath = "(//*[name()='rect' and contains (@fill,'rgb(255, 255, 255)') ])[2]")
	public WebElement RoundRectText;

	@FindBy(xpath = "(//*[name()='rect' and contains (@fill,'rgb(255, 255, 255)') ])[3]")
	public WebElement ProcessText;

	@FindBy(xpath = "(//*[name()='path' and contains(@fill,'rgb(255, 255, 255)')])[3]")
	public WebElement HexoText;

	@FindBy(xpath = "//div[@class='geDiagramContainer geDiagramBackdrop']//img[2]")
	public WebElement Connectorarrow;

	@FindBy(xpath = "//div[@class='mxCellEditor geContentEditable']")
	public WebElement TextEditor;

	@FindBy(xpath = "//a[normalize-space()='Edit']")
	public WebElement Edit;

	@FindBy(xpath = "//td[normalize-space()='Edit']")
	public WebElement EditData;

	@FindBy(xpath = "//div[@class='geDiagramContainer geDiagramBackdrop']//*[name()='svg']")
	public WebElement Dashboard;

	@FindBy(xpath = "//div[@class='geSprite geSprite-delete']")
	public WebElement Delete;

	@FindBy(xpath = "//td[normalize-space()='Select All']")
	public WebElement SelectALL;
	
	@FindBy(xpath = "//td[normalize-space()='Select All']")
	public List<WebElement>SelectALLs;
	
	public void clickDecideLater() {
		bc.objFluentwaitclick(Decidelater, 5, 3);
		MinimizeBoard();
	}

	public void clickShapes(String Shape) {
		bc.info(Shape);

		switch (Shape.toLowerCase()) {

		case "cloud":
			bc.objFluentwaitclick(cloud, 5, 3);
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

	public void verifyFlowChartPresent() {
		assertTrue(HexoText.isDisplayed(), "Connectorarrow is not displayed");

	}

	public void verifyFlowChartNotPresent() {
		assertFalse(bc.getObjectProperty(Connectorarrow, "Displayed"));

	}

	public void deleteFlowchat() throws Exception {
		bc.actionsRightClick(Dashboard);
		bc.objFluentwaitclick(SelectALL, 5, 3);
		bc.objFluentwaitclick(Delete, 5, 3);

	}

	public void MinimizeBoard() {
		bc.objFluentwaitclick(zoom100, 5, 3);
		bc.objFluentwaitclick(zoom25, 5, 3);
	}

	public void MaxmizeBoard() {
		bc.objFluentwaitclick(zoom25, 5, 3);
		bc.objFluentwaitclick(zoom100, 5, 3);
	}

	public void editData() {
		bc.objFluentwaitclick(Edit, 5, 3);
		bc.objFluentwaitclick(EditData, 5, 3);
	}

	public void enterTextInShapes(String Shape, String Text) throws Exception {
		bc.objFluentwaitclick(Dashboard, 5, 3);
		switch (Shape.toLowerCase()) {
		case "cloud":
			bc.scrolltoElementbyAction(cloudText);
			bc.objFluentwaitclick(cloudText, 5, 3);
			editData();
			TextEditor.sendKeys(Text);

			break;
		case "roundrectangle":
			bc.scrolltoElementbyAction(RoundRectText);
			bc.objFluentwaitclick(RoundRectText, 5, 3);
			editData();
			TextEditor.sendKeys(Text);
			break;
		case "diamond":
			bc.scrolltoElementbyAction(DiamondText);
			bc.objFluentwaitclick(DiamondText, 5, 3);
			editData();
			TextEditor.sendKeys(Text);
			break;
		case "hexagon":
			bc.scrolltoElementbyAction(HexoText);
			bc.objFluentwaitclick(HexoText, 5, 3);
			editData();
			TextEditor.sendKeys(Text);
			break;
		case "process":
			bc.scrolltoElementbyAction(ProcessText);
			bc.objFluentwaitclick(ProcessText, 5, 3);
			editData();
			TextEditor.sendKeys(Text);
			break;

		case "circle":
			bc.scrolltoElementbyAction(CircleText);
			bc.objFluentwaitclick(CircleText, 5, 3);
			editData();
			TextEditor.sendKeys(Text);
			break;

		default:
			bc.info("Invalid Shape");
		}

	}
	
	public String getCircleText() {
		bc.scrolltoElementbyAction(CircleText);
		bc.actionsClick(CircleText);
		editData();
		bc.info(TextEditor.getText());
		return TextEditor.getText();
	}
	
	public String getCouldText() {
		bc.scrolltoElementbyAction(cloudText);
		bc.actionsClick(cloudText);
		editData();
		bc.info(TextEditor.getText());
		return TextEditor.getText();
	}
	
	public String getRoundRectText() {
		bc.scrolltoElementbyAction(RoundRectText);
		bc.actionsClick(RoundRectText);
		editData();
		bc.info(TextEditor.getText());
		return TextEditor.getText();
	}
	
	public String getDiamondText() {
		bc.scrolltoElementbyAction(DiamondText);
		bc.actionsClick(DiamondText);
		editData();
		bc.info(TextEditor.getText());
		return TextEditor.getText();
	}
	
	public String getHexoText() {
		bc.scrolltoElementbyAction(HexoText);
		bc.actionsClick(HexoText);
		editData();
		bc.info(TextEditor.getText());
		return TextEditor.getText();
	}
	
	public String getProcessText() {
		bc.scrolltoElementbyAction(ProcessText);
		bc.actionsClick(ProcessText);
		editData();
		bc.info(TextEditor.getText());
		return TextEditor.getText();
	}
	

	public void verifyTextinsideShapes() {
		assertTrue(getCircleText().equalsIgnoreCase("Start"),"Text inside circle shape is not matching");
		assertTrue(getCouldText().equalsIgnoreCase("Read A"),"Text inside cloud shape is not matching");
		assertTrue(getHexoText().equalsIgnoreCase("End"),"Text inside diamond shape is not matching");
	}
	
	
}
