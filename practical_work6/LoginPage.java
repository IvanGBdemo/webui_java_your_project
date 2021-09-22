package practical_work6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {

    @FindBy(xpath = "//*[@id=\"js-product-tabs\"]/div[2]/div/div[1]/label")
    public WebElement clickTitleEntrance;

    @FindBy(id = "login-original")
    public WebElement inputLogin;

    @FindBy(id = "login_password")
    public WebElement inputPassword;

    @FindBy(id = "submit-button")
    public WebElement loginButton;

    @Step("Переход на страницу ввода логина")
    public LoginPage clickTitleEntrance() {
        clickTitleEntrance.click();
        return this;
    }
    @Step("Ввод логина")
    public LoginPage fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }
    @Step("Ввод пароля")
    public LoginPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }
    @Step("Клик на кнопку Войти")
    public MainPage clickLoginButton() {
        loginButton.click();
        return new MainPage(driver);
    }

    public void login(String login, String password) {
        clickTitleEntrance.click();
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        loginButton.click();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
