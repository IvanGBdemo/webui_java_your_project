package practical_work3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInToYourAccount {

// Объявляю переменную драйвера
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
// Создаю код выполнения сценария
        WebDriverManager.chromedriver().setup();
// Инициализирую драйвер
        driver = new ChromeDriver();
        driver.get("https://www.mvideo.ru");

        driver.manage().window().maximize();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Все верно']")));
        driver.findElement(By.xpath("//a[text()='Все верно']")).click();

        Thread.sleep(5000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'fl-436095')]")));
        driver.findElement(By.xpath("//html/body/section/a")).click();
        driver.switchTo().parentFrame();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div/div/div/div/div/div/div/a/div/i[@class='i-icon i-icon-fl-profile']"))); 
        driver.findElement(By.xpath("//body/div/div/div/div/div/div/div/a/div/i[@class='i-icon i-icon-fl-profile']")).click(); // ненадёжный локатор !

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='\n" +
                "            Войти с помощью пароля\n" +
                "        ']")));
        driver.findElement(By.xpath("//label[text()='\n" +
                "            Войти с помощью пароля\n" +
                "        ']")).click();
//input[@class='c-text-field__input js-field__login u-valid']
        driver.findElement(By.xpath("//html/body/div[2]/div/div[3]/div/div/div[2]/div/div[2]/div[2]/div/div[2]/form/div/div[1]/div/input[1]"))
                .sendKeys("jokovich85@mail.ru");
        driver.findElement(By.xpath("//html/body/div[2]/div/div[3]/div/div/div[2]/div/div[2]/div[2]/div/div[2]/form/div/div[2]/input[1]"))  // ненадёжный локатор !
                .sendKeys("Мвидео21");
        driver.findElement(By.id("submit-button")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
