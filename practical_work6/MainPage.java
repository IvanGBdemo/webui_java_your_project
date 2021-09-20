package practical_work6;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseView {

    public NavigationMenu navigationMenu;

    public MainPage(WebDriver driver) {
        super(driver);

        navigationMenu = new NavigationMenu(driver);
    }

    @FindBy(xpath = "//a[text()='Все верно']")
    public WebElement clickLocation;

    @FindBy(xpath = "//iframe[@id= 'fl-436095']")
    public WebElement clickBanningNotifications;

    @FindBy(xpath = "//*[@class='i-icon i-icon-fl-profile']")
    public WebElement clickIcon;

    @FindBy(id = "header-search-input")
    public WebElement inputSearch;

    @FindBy(id = "header-search-input")
    public WebElement clickSearch;

    public MainPage clickLocation() {
        clickLocation.click();
        return this;
    }

    public MainPage clickBanningNotifications() {
        clickBanningNotifications.click();
        return this;
    }

    public LoginPage clickIcon() {
        clickIcon.click();
        return new LoginPage(driver);
    }

    public MainPage fillInputSearch(String search) {
        inputSearch.sendKeys(search);
        return this;
    }

    public ResultSearchPage runClickSearch(Keys enter) {
        clickSearch.sendKeys(enter);
        return new ResultSearchPage(driver);
    }

    public void mainMethod() {
        clickLocation.click();
        clickBanningNotifications.click();
        clickIcon.click();
        inputSearch.sendKeys();
        clickSearch.sendKeys();

    }
}

