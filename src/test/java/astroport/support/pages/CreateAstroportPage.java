package astroport.support.pages;

import astroport.support.AppDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CreateAstroportPage extends InspectablePage {

    public CreateAstroportPage(AppDriver driver) {
        super(driver);
        assertThat(pageTitle(), equalTo("Create new astroport"));
    }

    public WebElement nameField() {
        return element("input#astroport-name");
    }

    public WebElement nameLabel() {
        return element("#astroport-creation-invitation");
    }

    public CreateAstroportPage typeName(String value) {
        type(value, nameField());
        return this;
    }

    public CreateAstroportPage andVerifyThatNameFieldContains(String expected) {
        assertThat(value(nameField()), equalTo(expected));
        return this;
    }
}
