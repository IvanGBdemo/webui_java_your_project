package practical_work5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSearch {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginToMvideo();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header-search-input\"]")));
        driver.findElement(By.xpath("//*[@id=\"header-search-input\"]")).sendKeys("монитор");
        driver.findElement(By.xpath("//*[@id=\"header-search-input\"]")).sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        driver.quit();

    }
    public static void loginToMvideo() throws InterruptedException {
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
        driver.findElement(By.xpath("//body/div/div/div/div/div/div/div/a/div/i[@class='i-icon i-icon-fl-profile']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='\n" +
                "            Войти с помощью пароля\n" +
                "        ']")));
        driver.findElement(By.xpath("//label[text()='\n" +
                "            Войти с помощью пароля\n" +
                "        ']")).click();

        driver.findElement(By.xpath("//html/body/div[2]/div/div[3]/div/div/div[2]/div/div[2]/div[2]/div/div[2]/form/div/div[1]/div/input[1]"))
                .sendKeys("jokovich85@mail.ru");
        driver.findElement(By.xpath("//html/body/div[2]/div/div[3]/div/div/div[2]/div/div[2]/div[2]/div/div[2]/form/div/div[2]/input[1]"))
                .sendKeys("Мвидео21");
        driver.findElement(By.id("submit-button")).click();
    }
}
