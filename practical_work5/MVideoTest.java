package practical_work5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;


public class MVideoTest {
    static WebDriver driver;
    WebDriverWait webDriverWait;

    private static final String BASE_URL = "https://www.mvideo.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
    }

    @Test
    void logInToYourAccountTest() throws InterruptedException {
        driver.get(BASE_URL);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Все верно']")));
        driver.findElement(By.xpath("//a[text()='Все верно']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@id= 'fl-436095']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id= 'fl-436095']")));
        driver.findElement(By.xpath("//html/body/section/a")).click();
        driver.switchTo().parentFrame();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='i-icon i-icon-fl-profile']")));
        driver.findElement(By.xpath("//*[@class='i-icon i-icon-fl-profile']")).click();

//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Войти с помощью пароля']")));
//        driver.findElement(By.xpath("//label[text()='Войти с помощью пароля']")).click();

        driver.findElement(By.xpath("//*[@id='login-original']")).sendKeys("jokovich85@mail.ru");
        driver.findElement(By.xpath("//*[@id='login_password']")).sendKeys("Мвидео21");
        driver.findElement(By.id("submit-button")).click();

        assertThat(driver.findElement(By.xpath("//*[@class='header-icon__text']")), hasText(" Дмитрий"));

        Thread.sleep(10000);
    }

    @Test
    void ProductSearchTest() throws InterruptedException {
        loginToMvideo();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header-search-input\"]")));
        driver.findElement(By.xpath("//*[@id=\"header-search-input\"]")).sendKeys("монитор");
        driver.findElement(By.xpath("//*[@id=\"header-search-input\"]")).sendKeys(Keys.ENTER);

        assertThat(driver.findElement(By.xpath("//button[@class='tab tab--selected ng-star-inserted']")),
                hasText("Мониторы 774"));

        Thread.sleep(10000);
    }

    @Test
    void addToCartTest() throws InterruptedException {

        loginToMvideo();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//div[1]/mvid-plp-product-checkout[1]/div/div[1]/mvid-plp-checkout-tooltip/mvid-plp-cart-button/mvid-button/button/span")));
        driver.findElement(By
                .xpath("//div[1]/mvid-plp-product-checkout[1]/div/div[1]/mvid-plp-checkout-tooltip/mvid-plp-cart-button/mvid-button/button/span")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("cart")));
        driver.findElement(By.id("cart")).click();

        assertThat(driver.findElement(By.xpath("//span[@class='c-header-checkout__logo u-ml-0']")), hasText("Моя корзина"));

        Thread.sleep(10000);
    }
    @Test
    void addToFavoritesTest() throws InterruptedException {
        loginToMvideo();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header-search-input\"]")));
        driver.findElement(By.xpath("//*[@id=\"header-search-input\"]")).sendKeys("монитор");
        driver.findElement(By.xpath("//*[@id=\"header-search-input\"]")).sendKeys(Keys.ENTER);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//div[1]/mvid-plp-product-checkout[1]/div/div[2]/div[1]/mvid-plp-checkout-tooltip/mvid-button/button/mvid-icon")));
        driver.findElement(By
                .xpath("//div[1]/mvid-plp-product-checkout[1]/div/div[2]/div[1]/mvid-plp-checkout-tooltip/mvid-button/button/mvid-icon")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Избранное']")));
        driver.findElement(By.xpath("//p[text()='Избранное']")).click();

        assertThat(driver.findElement(By.xpath("//h1")), hasText("Избранное"));

        Thread.sleep(10000);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    public static void loginToMvideo() throws InterruptedException {
        driver.get(BASE_URL);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Все верно']")));
        driver.findElement(By.xpath("//a[text()='Все верно']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@id= 'fl-436095']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id= 'fl-436095']")));
        driver.findElement(By.xpath("//html/body/section/a")).click();
        driver.switchTo().parentFrame();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='i-icon i-icon-fl-profile']")));
        driver.findElement(By.xpath("//*[@class='i-icon i-icon-fl-profile']")).click();

//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Войти с помощью пароля']")));
//        driver.findElement(By.xpath("//label[text()='Войти с помощью пароля']")).click();

        driver.findElement(By.xpath("//*[@id='login-original']")).sendKeys("jokovich85@mail.ru");
        driver.findElement(By.xpath("//*[@id='login_password']")).sendKeys("Мвидео21");
        driver.findElement(By.id("submit-button")).click();
    }
}

