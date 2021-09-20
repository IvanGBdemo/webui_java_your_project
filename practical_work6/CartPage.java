package practical_work6;

import org.openqa.selenium.WebDriver;

public class CartPage extends BaseView {

    public NavigationMenu navigationMenu;

    public CartPage(WebDriver driver) {
        super(driver);

        navigationMenu = new NavigationMenu(driver);
    }
}