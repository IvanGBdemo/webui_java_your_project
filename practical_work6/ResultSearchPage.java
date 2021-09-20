package practical_work6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultSearchPage extends BaseView {

    public NavigationMenu navigationMenu;
    public ResultSearchTitles resultSearchTitles;

    public ResultSearchPage(WebDriver driver) {
        super(driver);

        navigationMenu = new NavigationMenu(driver);
        resultSearchTitles = new ResultSearchTitles(driver);
    }
    @FindBy(id = "cart")
    public WebElement clickCart;

    @Step("Клик на кнопку В корзину")
    public CartPage runClickCart() {
        clickCart.click();
        return new CartPage(driver);
    }
    @FindBy(xpath = "//div[1]/mvid-plp-product-checkout[1]/div/div[2]/div[1]/mvid-plp-checkout-tooltip/mvid-button/button/mvid-icon")
    public WebElement favourites;

    @Step("Клик на иконку добавления в Избранное")
    public ResultSearchPage clickFavourites() {
        favourites.click();
        return this;
    }

    @FindBy(xpath = "//p[text()='Избранное']")
    public WebElement goToFavorites;

    @Step("Клик на иконку перехода в Избранное")
    public FavouritesPage clickGoToFavorites() {
        goToFavorites.click();
        return new FavouritesPage(driver);
    }

    public void result() {
        clickCart.click();
        favourites.click();
        goToFavorites.click();
    }
}
