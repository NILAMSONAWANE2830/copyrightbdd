package pageLayer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import baseLayer.BaseClass;
import utilityLayer.HandleDropdown;
import utilityLayer.Waits;

public class RegestrationPage extends BaseClass{

//	@FindBy(id="ctl00_ContentPlaceHolder1_txtFName")
//	private WebElement name;
//	
//	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtAddress']")
//	private WebElement addr;
//	
//	@FindBy(xpath="//input[contains(@id,'ctl00_ContentPlaceHolder1_txtCi')]")
//	private WebElement city;
//	
//	@FindBy(xpath="(//select[@class='dropDown'])[2]")
//	private WebElement country;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_ddlState")
	private WebElement state;

	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_txtNationality']")
	private WebElement nationality;

	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_txtEmail']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_txtMobileNum']")
	private WebElement mobno;

	@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_ddlQuestions']")
	WebElement s1;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_txtAnswer']")
	WebElement ans;
	
	@FindBys(@FindBy(xpath="//label[@for='ctl00_ContentPlaceHolder1_rdoGeneral']"))//take class atribute
	List<WebElement> type;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_txtUserId")
	WebElement username;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_txtPassword']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_txtConfirmPwd']")
	WebElement conpassword;
	
	
	public RegestrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterGeneralDatails(String state1,String nationality1,String emal1,String mob) {
		HandleDropdown.selectbyvisibletext(state, state1);
		Waits.sendkeys(nationality, nationality1);
		Waits.sendkeys(email, emal1);
		Waits.sendkeys(mobno, mob);
	}
	
	public void queAndans(String que,String ans1) {
		HandleDropdown.selectbyvisibletext(s1, que);
		Waits.sendkeys(ans, ans1);
		
	}
	public void usertype(String type1) {
		Waits.selectoption(type, type1);
	}
	public void logIn(String user,String pass,String cpss) {
		Waits.sendkeys(username, user);
		Waits.sendkeys(password, pass);
		Waits.sendkeys(conpassword, cpss);
	}
}










