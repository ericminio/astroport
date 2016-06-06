package astroport.support.layout;

import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class LayoutAssertions {

    public static boolean hasSize(WebElement element, Dimension expected) {
        return
            (element.getSize().width == expected.width) &&
            (element.getSize().height == expected.height);
    }

    public static boolean areInVerticalOrder(WebElement one, WebElement two) {
        Rectangle oneBox = one.getRect();
        Rectangle twoBox = two.getRect();

        return twoBox.y >= (oneBox.y + oneBox.height);
    }

    public static boolean areInHorizontalOrder(WebElement one, WebElement two) {
        Rectangle oneBox = one.getRect();
        Rectangle twoBox = two.getRect();

        return twoBox.x >= (oneBox.x + oneBox.width);
    }
}
