package common.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class AutoDownloadedWebDriver implements DriverSource {
    public enum WebBrowsers {CHROME, FIREFOX, CHROME_HEADLESS, FIREFOX_HEADLESS}

    @Override
    public WebDriver newDriver() {
        WebBrowsers browserType = WebBrowsers.valueOf(new BaseConfiguration().getProperty("browser"));
        switch (browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(new ChromeOptions().addArguments("start-maximized", "--disable-gpu", "--ignore-certificate-errors", "–disable-extensions"));
            case CHROME_HEADLESS:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(new ChromeOptions().addArguments("--headless", "--disable-gpu", "--window-size=1920,1080", "--ignore-certificate-errors", "–disable-extensions"));
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(new FirefoxOptions().addArguments("--start-maximized", "--disable-gpu", "--ignore-certificate-errors", "–disable-extensions"));
            case FIREFOX_HEADLESS:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(new FirefoxOptions().addArguments("--headless", "--disable-gpu", "--window-size=1920,1080", "--ignore-certificate-errors", "–disable-extensions"));
            default:
                return null;
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
