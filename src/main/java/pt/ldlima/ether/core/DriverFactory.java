package pt.ldlima.ether.core;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	private static ThreadLocal<WebDriver> thread = new ThreadLocal<WebDriver>() {//Precisa entender exatamente o que foi feito aqui
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};
	
	public static WebDriver initDriver() {
		WebDriver driver = null;
		switch (Properties.browser) {
				case FIREFOX:
					iniciateDriverFirefox();
					driver = new FirefoxDriver();
					break;
				case CHROME:
					iniciateDriverChrome();
					driver = new ChromeDriver(); 
					break;
		}
		driver.manage().window().maximize();
		return driver; 
	}
	
	public static WebDriver getDriver() {
		return thread.get();
	}
	
	public static void shutDownDriver() {
		WebDriver driver = getDriver();
		if (driver!= null) {
			driver.quit();
			driver = null;
		}
		if (thread != null)
			thread.remove();
	}
	
	public static void iniciateDriverChrome() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +  File.separator +"src"+ File.separator +
				"main"+ File.separator +"resources"+ File.separator +"assets"+ File.separator +"chromedriver");
	}
	
	public static void iniciateDriverFirefox() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +  File.separator + "src"+ File.separator +
				"main"+ File.separator +"resources"+ File.separator +"assets"+ File.separator +"geckodriver");
	}
}
