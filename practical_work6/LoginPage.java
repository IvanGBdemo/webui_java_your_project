package practical_work6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {

    @FindBy(xpath = "//label[text()='Войти с помощью пароля']")
    public WebElement clickTitleEntrance;

    @FindBy(id = "login-original")
    public WebElement inputLogin;

    @FindBy(id = "login_password")
    public WebElement inputPassword;

    @FindBy(id = "submit-button")
    public WebElement loginButton;

    public LoginPage clickTitleEntrance() {
        clickTitleEntrance.click();
        return this;
    }

    public LoginPage fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

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
