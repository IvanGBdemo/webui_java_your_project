package practical_work6;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class PageObjectTest extends BaseTest {

    @Test
    void loginInMVideoWithPageObjTest() throws InterruptedException {
        driver.get("https://www.mvideo.ru");

        new MainPage(driver)
                .clickLocation()
                .clickBanningNotifications()
                .clickIcon();

        new LoginPage(driver)
                .clickTitleEntrance()
                .fillInputLogin("jokovich85@mail.ru")
                .fillInputPassword("Мвидео21")
                .clickLoginButton();

        webDriverWait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='header-icon__text']")));
        List<WebElement> headersList = driver.findElements(By.xpath("//*[@class='header-icon__text']"));
        assertThat(headersList.get(0), hasText(" Дмитрий"));

        Thread.sleep(5000);
    }

    @Test
    void ProductSearchTest() throws InterruptedException {

        driver.get("https://www.mvideo.ru");

        new MainPage(driver)
                .clickLocation()
//                .clickBanningNotifications()
                .clickIcon();

        new LoginPage(driver)
                .clickTitleEntrance()
                .fillInputLogin("jokovich85@mail.ru")
                .fillInputPassword("Мвидео21")
                .clickLoginButton();

        new MainPage(driver)
                .fillInputSearch("монитор")
                .runClickSearch(Keys.ENTER);

        webDriverWait.until(
                ExpectedConditions.invisibilityOfElementLocated(By
                        .xpath("//mvid-product-list-controls/mvid-dropdown/div[@class=\"dropdown with-icon\"]/div/span")));
        List<WebElement> headersList = driver.findElements(By
                .xpath("//mvid-product-list-controls/mvid-dropdown/div[@class=\"dropdown with-icon\"]/div/span"));
        assertThat(headersList.get(0), hasText("Сначала популярные"));

        Thread.sleep(5000);
    }

    @Test
    void addToCartTest() throws InterruptedException {

        driver.get("https://www.mvideo.ru");

        new MainPage(driver)
                .clickLocation()
//                .clickBanningNotifications()
                .clickIcon();

        new LoginPage(driver)
                .clickTitleEntrance()
                .fillInputLogin("jokovich85@mail.ru")
                .fillInputPassword("Мвидео21")
                .clickLoginButton();

        new MainPage(driver)
                .fillInputSearch("монитор")
                .runClickSearch(Keys.ENTER);
        new ResultSearchPage(driver)
                .runClickCart();

        webDriverWait.until(
                ExpectedConditions.invisibilityOfElementLocated(By
                        .xpath("//span[@class='c-header-checkout__logo u-ml-0']")));
        List<WebElement> headersList = driver.findElements(By.xpath("//span[@class='c-header-checkout__logo u-ml-0']"));
        assertThat(headersList.get(0), hasText("Моя корзина"));

        Thread.sleep(5000);
    }

    @Test
    void addToFavoritesTest() throws InterruptedException {
        driver.get("https://www.mvideo.ru");

        new MainPage(driver)
                .clickLocation()
//                .clickBanningNotifications()
                .clickIcon();

        new LoginPage(driver)
                .clickTitleEntrance()
                .fillInputLogin("jokovich85@mail.ru")
                .fillInputPassword("Мвидео21")
                .clickLoginButton();

        new MainPage(driver)
                .fillInputSearch("монитор")
                .runClickSearch(Keys.ENTER);

        new ResultSearchPage(driver)
                .clickFavourites()
                .clickGoToFavorites();

        webDriverWait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h1")));
        List<WebElement> headersList = driver.findElements(By.xpath("//h1"));
        assertThat(headersList.get(0), hasText("Избранное"));

        Thread.sleep(5000);
    }
}