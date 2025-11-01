package pages;


import resources.Resources;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {



    WebDriver driver;
    By searchBox = By.name("q");

    public GoogleSearchPage(WebDriver driver){
        this.driver = driver;
    }
    public void googleOpen(){

        driver.navigate().to(Resources.url);
    }
    public void Search(String text){
        driver.findElement(searchBox).sendKeys(text);
        driver.findElement(searchBox).submit();
    }
    public String getTitle() {
        return driver.getTitle();
    }
}
