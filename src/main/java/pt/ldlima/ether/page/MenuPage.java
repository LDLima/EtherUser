package pt.ldlima.ether.page;

public class MenuPage {

	/*********	BUTTONS	*********/
	public String getEtherscanLogo() {
		return "logo-header";
	}
	
	public String getGasInfo() {
		return "//a[@class='text-secondary']";
	}
	
	public String getHomePage() {
		return "//a[@class='nav-link u-header__nav-link']";
	}
	
	public String menuEtherscanImage() {
		return "//img[@class='u-xs-avatar btn-icon__inner']";
	}
	
	public String getSearchButton() {
		return "//button[@class='btn btn-primary']";
	}
	
	/*********	TEXT AREA	*********/
	public String getSearchArea() {
		return "//input[@id='txtSearchInput']";
	}
	
	/*********	COMBO BOX	*********/
	public String getCombo() {
		return "//select[@name='f']";
	}
	
}
