package practical_work6;

import org.openqa.selenium.WebDriver;

public class FavouritesPage extends BaseView {

    public NavigationMenu navigationMenu;

    public FavouritesPage(WebDriver driver) {
        super(driver);

        navigationMenu = new NavigationMenu(driver);
    }
}
