package utilityLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import baseLayer.BaseClass;

public class HandleDropdown extends BaseClass {

	public static void selectbyvisibletext(WebElement wb,String value) {
		new Select(wb).selectByVisibleText(value);
	}
	
	public static void selectbyvalue(WebElement wb,String value) {
		new Select(wb).selectByValue(value);
	}
	
	public static void selectbyindex(WebElement wb,int i) {
		new Select(wb).selectByIndex(i);
	}
}
