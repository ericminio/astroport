package astroport.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class With {

    public static Device iPhone = new Device() {
        @Override
        public java.awt.Dimension getWindowSize() {
            return new java.awt.Dimension(320, 568);
        }
        @Override
        public java.awt.Dimension inputFieldSize() {
            return new java.awt.Dimension(100, 20);
        }
        @Override
        public WebDriver getFavoriteBrowser() {
            return new FirefoxDriver();
        }
    };

    public static Device laptop = new Device() {
        @Override
        public java.awt.Dimension getWindowSize() {
            return new java.awt.Dimension(1440, 900);
        }
        @Override
        public java.awt.Dimension inputFieldSize() {
            return new java.awt.Dimension(150, 25);
        }
        @Override
        public WebDriver getFavoriteBrowser() {
            return new FirefoxDriver();
        }
    };

}
