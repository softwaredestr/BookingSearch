package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class BookingSearchPage extends BasePage {
    @FindBy(className = "sr-hotel__name")
    List<WebElement> resultsLinks;
    @FindBy(className = "bui-review-score__badge")
    List<WebElement> rating;
    public BookingSearchPage(WebDriver driver){super(driver);}

    public List<String> getResultLinks() {
        return resultsLinks.stream().map(result->result.getAttribute("innerText"))
                .filter(result-> !result.isEmpty()).collect(Collectors.toList());
    }
    public List<String> getRating(){
        return  rating.stream().map(result->result.getAttribute("innerText"))
                .filter(result-> !result.isEmpty()).collect(Collectors.toList());
    }


}
