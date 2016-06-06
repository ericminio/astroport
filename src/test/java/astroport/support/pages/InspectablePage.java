package astroport.support.pages;

import astroport.support.AppDriver;
import astroport.support.Launcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InspectablePage {

    protected AppDriver driver;

    public InspectablePage(AppDriver driver) {
        this.driver = driver;
    }

    public String pageTitle() {
        return driver.browser.getTitle();
    }

    public WebElement element(String selector) {
        return driver.browser.findElement(By.cssSelector(selector));
    }

    public String value(WebElement element) {
        return element.getAttribute("value");
    }

    public void type(String value, WebElement element) {
        element.sendKeys(value);
    }

    public void navigateTo(String resource) {
        driver.browser.get("http://localhost:" + Launcher.port + resource);
    }

}
