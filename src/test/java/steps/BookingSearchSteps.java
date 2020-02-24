package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.SearchItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BookingSearchPage;
import pages.MainBookingPage;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class BookingSearchSteps {
    public static final String URL = "https://www.booking.com";
    MainBookingPage mainPage;
    BookingSearchPage searchPage;
    WebDriver driver;
    SearchItem searchItem;
    int hotelIndex;


    @Given("User on the search page")
    public void userOnTheSearchPage() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");



    }
    @And("Hotel's name is {string}")
    public void hotelSNameIs(String hotelName) {
        searchItem = new SearchItem(hotelName);
        searchItem.getSearchString();
    }

    @When("User performs search")
    public void userPerformsSearch(String keyword) {
    driver = new ChromeDriver();
    driver.get(URL);
    mainPage = new MainBookingPage(driver);
    mainPage.searchByKeyword(searchItem.getSearchString());
    searchPage = new BookingSearchPage(driver);

    }



    @Then("Hotel appears in the search")
    public void hotelAppearsInTheSearch(String hotelName) {
        BookingSearchPage searchPage = new BookingSearchPage(driver);
        List<String> hotels = searchPage.getResultLinks();
        hotelIndex = hotels.indexOf(hotelName);
        assertThat(hotels, hasItem(hotelName));
    }

    @And("Hotel has rating {string}")
    public void hotelHasRating( String hotelRate) {
        List<String> rate = searchPage.getRating();
        assertEquals(rate.get(hotelIndex), hotelRate);
        driver.quit();


    }
}
