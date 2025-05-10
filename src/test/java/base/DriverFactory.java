package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utils.ConfigReader;

public class DriverFactory {

    public static WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:/Users/donam/intellij_workplace/MyProject/src/test/resources/chromedriver.exe/");
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
                return new FirefoxDriver();
            case "edge":
                System.setProperty("webdriver.edge.driver", "path/to/msedgedriver");
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }
}
