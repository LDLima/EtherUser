package pt.ldlima.ether.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pt.ldlim.ether.datapool.ReadJSONFile;
import pt.ldlima.ether.core.DriverFactory;
import pt.ldlima.ether.page.RegistrationPage;

public class RegistrationController {
	
	private RegistrationPage page;
	
	public RegistrationController() {
		page = new RegistrationPage();
	}
	
	/********	 READJSON	********/
	public void readJSONData(String cenario) {
		try {
			inputData(ReadJSONFile.readJSON(cenario));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/********	 INPUT DATA	********/
	public void inputData(JSONObject data) {
		writeText(page.getUsername(),(String)data.get("username"));
		writeText(page.getEmail(),(String)data.get("email"));
		writeText(page.getPassword(),(String)data.get("password"));
		writeText(page.getConfirmPassword(),(String)data.get("confirmPassword"));
	}
	
	/********	 TEXT	********/
	public void writeText(String field, String text) {
		DriverFactory.getDriver().findElement(By.id(field)).clear();
		DriverFactory.getDriver().findElement(By.id(field)).sendKeys(text);
	}
	
	
	/********	 GET TEXT FROM PAGE	********/
	private String getText(String field) {
		return DriverFactory.getDriver().findElement(By.xpath(field)).getText();
	}
	
	public String getPasswordStrengthText() {
		return getText(page.getPasswordStrength());
	}
	
	public String getTextTile() {
		return getText("//h1");
	}
	
	/********	 BUSINESS RULE	********/
	public List<String> catchErrors() {
		List<WebElement> errors = DriverFactory.getDriver().findElements(By.xpath(page.getMessageErrors()));
		List<String> erroReturned = new ArrayList<String>();
		for(WebElement error:errors) 
			erroReturned.add(error.getText());
		return erroReturned;
	}

	public void viewTermsConditions() {
		DriverFactory.getDriver().get(catchLinks(page.getTearmsAndCoditionLink()));
	}
	
	public void viewUnsubscribeNewsletter() {
		DriverFactory.getDriver().get(catchLinks(page.getUnsunscribeNewsletter()));
	}
	
	public String catchLinks(String field) {
		List<WebElement> links = DriverFactory.getDriver().findElements(By.xpath(page.getMutedLinks()));
		for(WebElement link:links) {
			if (link.getText().equals(field))
				return link.getAttribute("href");
		}
		return null;
	}
	
	/********	 BUTTONS	********/	
	public void clickButton(By type) {//Click in any type of button
		DriverFactory.getDriver().findElement(type).click();
	}
	
	public void clickButtonCreatAccount() {
		clickButton(By.xpath(page.getCreateNewAccountButton()));
	}
	
	public void clickButton(String frameName, String field) throws InterruptedException {
		DriverFactory.getDriver().switchTo().frame(DriverFactory.getDriver().findElement(By.cssSelector("iframe[title='reCAPTCHA']")));
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("arguments[0].scrollIntoView()", DriverFactory.getDriver().findElement(By.id("recaptcha-anchor")));
        js.executeScript("arguments[0].click();", DriverFactory.getDriver().findElement(By.id("recaptcha-anchor")));
		
		/*DriverFactory.getDriver().switchTo().frame(DriverFactory.getDriver().findElement(By.cssSelector("iframe[title='reCAPTCHA']")));
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("arguments[0].scrollIntoView()", DriverFactory.getDriver().findElement(By.id("recaptcha-anchor")));
        js.executeScript("arguments[0].click();", DriverFactory.getDriver().findElement(By.id("recaptcha-anchor")));
		System.out.println("Test");*/
	}
	
	/********	 Cookies ********/
	public void clickCookies() {
		this.clickButton(By.xpath(page.agreeWithCookies()));
	}
	
	/********	 CHECKBOX	********/
	public void selectTearmsAndConditionsCheckbox() {
		this.selectCheckbox(page.getTermsAndConditions());
	}
	
	public void selectEtherslanNewsletterCheckbox() {
		this.selectCheckbox(page.getEtherscanNewsletter());
	}
	public void selectCheckbox(String field) {
//		DriverFactory.getDriver().findElement(By.xpath(field)).click(); //Not going to working. Elements overlapping. Need to use Actions so that work properly.
		fixingOverlapElements(field);
	}
	
	public void fixingOverlapElements(String field) {
		WebElement element = DriverFactory.getDriver().findElement(By.xpath(field));//Find the element we wanted
		Actions action = new Actions(DriverFactory.getDriver());//Driver to do the action
		action.moveToElement(element).click().perform();//Click on the right element
	}
	
	/********	 LINKS	********/
	public void clickOnLink(String fieldLink) {
		DriverFactory.getDriver().findElement(By.linkText(fieldLink));
	}
	
	/********	 FRAMES	********/
	public void switchToFrame(String frameName) {
		DriverFactory.getDriver().switchTo().frame(frameName);
	}
	
	public void switchBackToFrame() {
		DriverFactory.getDriver().switchTo().defaultContent();
	}
	
	/********	 NOT A ROBOT ********/
	public void clickNotARobot(){
		try {
			Thread.sleep(34000);
			this.clickButton(page.getFrameCaptcha(), page.notARobot());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
