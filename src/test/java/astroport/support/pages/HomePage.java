package astroport.support.pages;

import astroport.support.AppDriver;

public class HomePage extends InspectablePage {

    public HomePage(AppDriver driver) {
        super(driver);
    }

    public CreateAstroportPage goToAstroportCreationForm() {
        navigateTo("/astroport-creation");
        return new CreateAstroportPage(driver);
    }
}
