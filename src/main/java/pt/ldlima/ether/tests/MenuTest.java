package pt.ldlima.ether.tests;

import org.junit.Test;

import pt.ldlima.ether.controllers.MenuController;

public class MenuTest extends BaseTest{
	private MenuController control;

	public MenuTest() {
		control = new MenuController();
	}
	
	@Test
	public void test13_clickLogo() {
		control.clickLogoButton();
	}
	
	@Test
	public void test14_clickGas() {
		control.clickGasInfo();
	}
	
	@Test
	public void test15_doSearchTroughSite() {
		control.selectComboMenuOption();
		control.randomSearch();
		control.clickSearchButton();
	}
	
	@Test
	public void test16_selectOneOptionFromMenu() {
		control.menuResources();
		control.submenuEthereum();
//		System.out.println("Comment just to see the new screen");
	}
}
