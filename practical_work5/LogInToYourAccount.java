package practical_work5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInToYourAccount {
// Объявляю переменную драйвера
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
// Создаю код выполнения сценария
        WebDriverManager.chromedriver().setup();
// Инициализирую драйвер
        driver = new ChromeDriver();
        loginToMvideo();

        Thread.sleep(5000);
        driver.quit();

    }

    // Создаю метод для входа на сайт
    public static void loginToMvideo() {
        driver.get("https://www.mvideo.ru");
        driver.findElement(By.id("login-original")).sendKeys("jokovich85@mail.ru");
        driver.findElement(By.id("login_password")).sendKeys("Мвидео21");
        driver.findElement(By.id("submit-button")).click();
    }
}
