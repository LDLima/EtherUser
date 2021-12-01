package pt.ldlima.ether.page;

public class RegistrationPage {


	/*********	FIELDS	*********/
	public String getUsername() {
		return "ContentPlaceHolder1_txtUserName";
	}
	
	public String getEmail() {
		return "ContentPlaceHolder1_txtEmail";
	}
	
	public String getPassword() {
		return "ContentPlaceHolder1_txtPassword";
	}
	
	public String getConfirmPassword() {
		return "ContentPlaceHolder1_txtPassword2";
	}
	
	/*********	CHECKBOX	*********/
	public String getTermsAndConditions() {
		return "//input[@type='checkbox' and @id='ContentPlaceHolder1_MyCheckBox']";
	}
	
	public String getEtherscanNewsletter() {
		return "//input[@type='checkbox' and @id='ContentPlaceHolder1_SubscribeNewsletter']";
	}
	
	public String notARobot() {
		return "recaptcha-anchor-label"; //How to get the correct images?!
	}
	
	/*********	FRAMES	*********/
	public String getFrameCaptcha() {
		return "//*[@name='a-vod0hqwgs1vl']";
	}
	
	/*********	LINKS	*********/
	public String getSingInButton() {
		return "Click to Sign In"; 
	}
	
	public String getTearmsAndCoditionLink() {
		return "Terms and Conditions"; 
	}
	
	public String getUnsunscribeNewsletter() {
		return "unsubscribe"; 
	}
	
	public String getMutedLinks() {
		return "//a[@class='link-muted']";
	}
	
	public String getTitlePageLink() {
		return "//h1"; 
	}
	
	/*********	BUTTONS	*********/
	public String getCreateNewAccountButton() {
		return "//input[@id='ContentPlaceHolder1_btnRegister']";
	}
	
	public String agreeWithCookies() {
		return "//button[@id='btnCookie']";
	}
	
	/*********	ERRORS	*********/
	public String getMessageErrors() {
		return "//div[@class='invalid-feedback']"; 
	}
	
	/*********	SPAMS	*********/
	public String getPasswordStrength() {
		return "//span[@id='passstrength']";
	}
	
}
