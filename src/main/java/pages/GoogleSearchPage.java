package pages;


import com.google.common.io.Resources;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
   // Resourcess ReSources;
    WebDriver driver;
    By searchBox = By.name("q");

    public GoogleSearchPage(WebDriver driver){
        this.driver = driver;
    }
    public void googleOpen(){
        driver.navigate().to("https://www.google.com");
    }
    public void Search(String text){
        driver.findElement(searchBox).sendKeys(text);
        driver.findElement(searchBox).submit();
    }
    public String getTitle() {
        return driver.getTitle();
    }
}
