package practical_work6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultSearchTitles extends BaseView {

    public ResultSearchTitles(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class=\"product-card__title-line-container ng-star-inserted\"]/mvid-plp-product-title")
    public List<WebElement> resultSearchTitlesItems;

    public void openResultSearchTitlesItem(String menuName) {

        Actions actions = new Actions(driver);

        actions.moveToElement(resultSearchTitlesItems.stream()
                .filter(element -> element.getText().equals(menuName))
                .findFirst().get()).perform();
    }
}