package utilityLayer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseLayer.BaseClass;

public class Waits extends BaseClass {

	 public static WebElement visibilityStatus(WebElement wb) {
		 return new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(wb));
	 }
	 
	 public static void sendkeys(WebElement wb,String value) {
		 visibilityStatus(wb).sendKeys(value);
		 
	 }
	 
	 public static void click(WebElement wb) {
		 visibilityStatus(wb).click();
	 }
	 public static void selectoption(List<WebElement> wb,String value){

        for(WebElement ls:wb) {
        	if(ls.getText().equals(value)) {
        		ls.click();
        		break;
        	}
        }
		 
	 }
	 public static List<WebElement> visibilityOfAllElements(WebElement wb){
     	return new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElements(wb));
     }
}
