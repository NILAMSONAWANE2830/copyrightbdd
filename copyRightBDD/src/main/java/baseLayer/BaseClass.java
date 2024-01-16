package baseLayer;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {
	protected static Properties pro;
	protected static WebDriver driver;
	public BaseClass() {
		try {
			FileInputStream fis = new FileInputStream(new File(
					System.getProperty("user.dir") + "\\src\\main\\java\\configurationLayer\\config.properties"));
          pro =new Properties();
           pro.load(fis);
		} catch (Exception e) {
           e.printStackTrace();
		}
	}
	
	public static void initilization(String browsername) {
		if(browsername.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Alldrivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else if(browsername.equalsIgnoreCase("incognito")) {
			driver=new ChromeDriver(new ChromeOptions().addArguments("--incognito"));
		}else {
			System.out.println("enter valid browsername");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		String url=pro.getProperty("URL");
	    driver.get(url);
	}
}
