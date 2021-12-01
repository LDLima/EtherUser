package pt.ldlima.ether.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import pt.ldlima.ether.core.DriverFactory;

public class BaseTest {

	@Rule
	public TestName name = new TestName();
	
	@Before
	public void inicialize() {
		DriverFactory.getDriver().get("https://etherscan.io/register");
	}
	
	@After
	public void endTest() throws IOException {
		takeScreenshot();
		DriverFactory.shutDownDriver();
	}
	
	public void takeScreenshot() throws IOException {
		TakesScreenshot shot = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = shot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + File.separator +  name.getMethodName() + ".jpg"));//Ele joga a exceção que o JUnit irá tratar
	}
	
}
