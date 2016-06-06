package astroport.support;

import astroport.support.pages.HomePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class AppDriver {

    public static Device device = null;
    private static AppDriver instance;
    public WebDriver browser;

    public AppDriver(WebDriver browser) {
        this.browser = browser;
    }

    public static HomePage openBrowser(Device current) {
        device = current;
        WebDriver browser = device.getFavoriteBrowser();
        AppDriver.instance = new AppDriver(browser);
        browser.manage().window().setSize(new Dimension(device.getWindowSize().width, device.getWindowSize().height));
        return new HomePage(AppDriver.instance);
    }

    public static void close() {
        AppDriver.instance.browser.quit();
    }

}
