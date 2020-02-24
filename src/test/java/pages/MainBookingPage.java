package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainBookingPage extends BasePage {
    WebDriverWait wait;
    @FindBy(id = "ss")
    WebElement nameInput;
    @FindBy(className = "sb-searchbox__button")
    WebElement searchButton;
    public MainBookingPage(WebDriver driver){super(driver);}

    public void searchByKeyword(String keyword ){
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.sendKeys(keyword);
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }

}
