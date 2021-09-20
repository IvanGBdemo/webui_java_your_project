package practical_work6;

import io.qameta.allure.Step;
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

    @Step("Клик-согласие с местоположением")
    public MainPage clickLocation() {
        clickLocation.click();
        return this;
    }
    @Step("Клик-закрытие окна оповещения об уведомлениях")
    public MainPage clickBanningNotifications() {
        clickBanningNotifications.click();
        return this;
    }
    @Step("Клик на иконку перехода на страницу ввода логина")
    public LoginPage clickIcon() {
        clickIcon.click();
        return new LoginPage(driver);
    }
    @Step("Ввод запроса в поисковую строку")
    public MainPage fillInputSearch(String search) {
        inputSearch.sendKeys(search);
        return this;
    }
    @Step("Нажание клавиши Enter для начала поиска по запросу")
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

