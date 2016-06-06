package astroport.support.layout;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class HasSizeOfMatcher extends TypeSafeDiagnosingMatcher<WebElement> {

    private final Dimension expected;
    private WebElement elementUnderTest;

    public HasSizeOfMatcher(Dimension dimension) {
        this.expected = dimension;
    }

    public static HasSizeOfMatcher hasSizeOf(Dimension dimension) {
        return new HasSizeOfMatcher(dimension);
    }

    @Override
    protected boolean matchesSafely(WebElement item, Description mismatchDescription) {
        this.elementUnderTest = item;
        if (! LayoutAssertions.hasSize(item, expected)) {
            String message = "size is (" +
                    this.elementUnderTest.getRect().width +
                    ", " +
                    this.elementUnderTest.getRect().height +
                    ")";
            mismatchDescription.appendText(message);
            return false;
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        String message = "#" +
                this.elementUnderTest.getAttribute("id") +
                " to have size (" +
                this.expected.width +
                ", " +
                this.expected.height +
                ")";
        description.appendText(message);
    }
}
