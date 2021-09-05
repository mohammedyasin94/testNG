package grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestGrid 
{
	static WebDriver driver;
	static String nodeURL;

	public static void main(String[] args) throws MalformedURLException 
	{
			nodeURL="http://192.168.1.6:5555/wd/hub";
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.MAC);
			
			ChromeOptions option= new ChromeOptions();
			option.setAcceptInsecureCerts(true);
			option.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
			option.merge(capabilities);
			driver= new RemoteWebDriver(new URL(nodeURL), option);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
			driver.get("http://www.amazon.in");
	}

}
