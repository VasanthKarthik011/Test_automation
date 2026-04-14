package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	Properties P=new Properties();
	
	WebDriver driver;
	@BeforeClass
	@Parameters("browser")
	public void launchBrowser(String browser) throws IOException {
		FileReader fs=new FileReader("C:\\Users\\2140894\\eclipse-workspace\\AutomationFramework\\src\\test\\resources\\config.properties");
		P.load(fs);
		switch(browser.toLowerCase()) {
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver(); break; 
		case "firefox": driver=new FirefoxDriver(); break; 
		default: System.out.println("Not a valid browser"); return;
		}
		driver.get(P.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
