package pt.ldlima.ether.controllers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pt.ldlima.ether.core.DriverFactory;
import pt.ldlima.ether.page.MenuPage;

public class MenuController {

	private MenuPage page;
	
	public MenuController() {
		page = new MenuPage();
	}
	
	/********	 BUTTONS	********/	
	public void clickButton(By type) {//Click in any type of button
		DriverFactory.getDriver().findElement(type).click();
	}
	
	public void clickLogoButton() {
		clickButton(By.id(page.getEtherscanLogo()));
	}


	public void clickGasInfo() {
		clickButton(By.xpath(page.getGasInfo()));
	}
	
	public void clickSearchButton() {
		clickButton(By.xpath(page.getSearchButton()));
	}

	
	/********	 COMBOBOX	********/
	public void selectComboMenuOption() {
		WebElement element = selectComboByValue(page.getCombo());
		Select combo = new Select (element);
		combo.selectByVisibleText("Labels");//Could be anyone. Choose Labels.
	}
	
	private WebElement selectComboByValue(String field) {
		return DriverFactory.getDriver().findElement(By.xpath(field));
	}
	
	
	/********	 TEXTAREA	********/
	public void randomSearch() {
		writeText(page.getSearchArea(), "Gas Tracker");
	}
	
	/********	 TEXT	********/
	public void writeText(String field, String text) {
		DriverFactory.getDriver().findElement(By.xpath(field)).clear();
		DriverFactory.getDriver().findElement(By.xpath(field)).sendKeys(text);
	}
	
	/********	 LINKS	********/
	public void clickOnLink(String fieldLink) {
		DriverFactory.getDriver().findElement(By.linkText(fieldLink)).click();
	}
	
	
	/********	 LINK HOME	********/
	public void menuHome() {
		clickOnLink("Home");
	}
	
	
	/********	 LINKS BLOCKCHAIN ********/
	public void menuBlockchain() {
		clickOnLink("Blockchain");
	}
	
	public void submenuBlockchainViewTxns() {
		clickOnLink("TView Txns");
	}
	
	public void submenuBlockchainViewPending() {
		clickOnLink("View Pending Txns");
	}
	
	public void submenuBlockchainViewContract() {
		clickOnLink("View Contract Internal Txns");
	}
	
	public void submenuBlockchainViewBlocks() {
		clickOnLink("View Blocks");
	}
	
	public void submenuBlockchainForkedBlocks() {
		clickOnLink("Forked Blocks (Reorgs)");
	}
	
	public void submenuBlockchainViewUncles() {
		clickOnLink("View Uncles");
	}
	
	public void submenuBlockchainAccount() {
		clickOnLink("Top Accounts");
	}
	
	public void submenuBlockchainVerifiedContracts() {
		clickOnLink("Verified Contracts");
	}
	
	
	/********	 LINKS TOKENS ********/
	public void menuTokens() {
		clickOnLink("Tokens");
	}
	
	public void submenuERC20TOP() {
		clickOnLink("ERC20 Top Tokens");
	}
	
	public void submenuiewERC20() {
		clickOnLink("View ERC20 Transfers");
	}
	
	public void submenuERC71TOP() {
		clickOnLink("ERC721 Top Tokens");
	}
	
	public void submenuViewERC71() {
		clickOnLink("View ERC721 Transfers");
	}
	
	public void submenuERC1155TOP() {
		clickOnLink("ERC1155 Top Tokens");
	}
	
	public void submenuViewERC155() {
		clickOnLink("View ERC1155 Transfers ");
	}
	
	
	/********	 LINKS RESOURCES ********/
	public void menuResources() {
		clickOnLink("Resources");
	}
	
	public void submenuChartsStarts() {
		clickOnLink("Charts & Stats");
	}
	
	public void submenuTopStatistics() {
		clickOnLink("Top Statistics");
	}
	
	public void submenuDevelopers() {
		clickOnLink("Developer APIs");
	}
	
	public void submenuEthereum() {
		clickOnLink("Ethereum Directory");
	}
	
	public void submenuExploreDApps() {
		clickOnLink("Explore dApps");
	}
	
	public void submenuYieldFarms() {
		clickOnLink("Yield Farms ");
	}
	
	public void submenuAirdrops() {
		clickOnLink("Airdrops");
	}
	
	/********	 MORE  ********/
	public void menuMORE() {
		clickOnLink("MORE");
	}
	
	/********	 MORE DEVELOPERS ********/
	public void submenuDevelpersAPI() {
		clickOnLink("API Documentation");
	}
	public void submenuDevelpersContract() {
		clickOnLink("Verify Contract");
	}
	public void submenuDevelpersByte() {
		clickOnLink("Byte to Opcode");
	}
	public void submenuDevelpersBroadcastTXN() {
		clickOnLink("Broadcast TXN");
	}
	public void submenuDevelpersVyperCompiler() {
		clickOnLink("Vyper Online Compiler");
	}
	public void submenuDevelpersSmartContract() {
		clickOnLink("Smart Contract Search");
	}
	public void submenuDevelpersContractDiff() {
		clickOnLink("Contract Diff Checker");
	}
	
	/********	 MORE DeFI ********/
	public void submenuDeFiDEXTransaction() {
		clickOnLink("DEX Transactions");
	}
	public void submenuDeFiDEXTrading() {
		clickOnLink("DEX Trading Pairs ");
	}
	
	/********	 MORE EXPLORE ********/
	public void submenuExploreGasTracker() {
		clickOnLink("Gas Tracker");
	}
	public void submenuExploreNodeTracker() {
		clickOnLink("Node Tracker");
	}
	public void submenuExploreEtherumNameLookup() {
		clickOnLink("Ethereum Name Lookup");
	}
	public void submenuExploreEtherscanConnect() {
		clickOnLink("Etherscan Connect");
	}
	public void submenuExploreEth2Beacon() {
		clickOnLink("Eth2 Beacon Chain Deposits");
	}
	public void submenuExploreIDM() {
		clickOnLink("IDM");
	}
	
	/********	 MORE TOOLS ********/
	public void submenuToolsLabelWord() {
		clickOnLink("Label Word Cloud");
	}
	public void submenuToolsMinig() {
		clickOnLink("Mining Calculator");
	}
	public void submenuToolsVerified() {
		clickOnLink("Verified Signature");
	}
	public void submenuToolsTokenAprrovals() {
		clickOnLink("Token Approvals ");
	}
	public void submenuUnitSubmenu() {
		clickOnLink("Unit Converter ");
	}
	
	/********	 SIGN IN  ********/
	public void menuSignIn() {
		clickOnLink("Sign In");
	}
	
	/********	Etherscan Image	********/
	public void menuEtherscanImage() {
		clickButton(By.xpath(page.menuEtherscanImage()));
	}
	
	/********	Etherscan subMenu	********/
	public void submenuEtherscanMainnet() {
		clickOnLink("Ethereum Mainnet");
	}
	public void submenuEtherscanMainnetCN() {
		clickOnLink("Ethereum Mainnet ");
	}
	public void submenuEtherscanRopsten() {
		clickOnLink("Ropsten Testnet");
	}
	public void submenuEtherscanKovan() {
		clickOnLink("Kovan Testnet");
	}
	public void submenuEtherscanRinkeby() {
		clickOnLink("Rinkeby Testnet");
	}
	public void submenuEtherscanGoerli() {
		clickOnLink("Goerli Testnet");
	}
	public void submenuEtherscanBeaconScan() {
		clickOnLink("BeaconScan ");
	}
	
}
