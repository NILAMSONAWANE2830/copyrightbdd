package stepdefination;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import baseLayer.BaseClass;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageLayer.RegestrationPage;

public class StepsforReg extends BaseClass {

	@Given("user open {string} browser and nevigate to copyright.gov WebSite")
	public void user_open_browser_and_nevigate_to_copyright_gov_web_site(String browsername) {
	   BaseClass.initilization(browsername);
	}

	@Then("user enter general details like name,address,city,country")
	public void user_enter_general_details_like_name_address_city_country(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>>ls=dataTable.asLists();
		String name=ls.get(0).get(0);
		String addr=ls.get(0).get(1);
		String city=ls.get(0).get(2);
		String country=ls.get(0).get(3);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFName")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']")).sendKeys(addr);
		driver.findElement(By.xpath("//input[contains(@id,'ctl00_ContentPlaceHolder1_txtCi')]")).sendKeys(city);
		driver.findElement(By.xpath("(//select[@class='dropDown'])[2]")).sendKeys(country);
	}


	@Given("user enter {string} {string} {string} {string}")
	public void user_enter(String state, String natinality, String emailid, String mobno) {
		RegestrationPage reg=new RegestrationPage();
     	reg.enterGeneralDatails(state,natinality, emailid, mobno);
	}

	@When("user select que from Question dropdown and enter the answer")
	public void user_select_que_from_question_dropdown_and_enter_the_answer() {
		RegestrationPage reg=new RegestrationPage();
		reg.queAndans("Who is your favorite Hero???", "SRK");
	}

	@Then("user chooes user type")
	public void user_chooes_user_type() {
		RegestrationPage reg=new RegestrationPage();
		reg.usertype("Society User");
	}

	@Then("choose {string} {string} {string}")
	public void choose(String uname, String passw, String cpassword) {
		RegestrationPage reg=new RegestrationPage();
		reg.logIn(uname, passw, cpassword);
	}
	@AfterStep
	public void teardown(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[]b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			String date=new SimpleDateFormat("ddMMyyyy_HHssmm").format(new Date());
			scenario.attach(b,"image/png", date+scenario.getName());	
		}else {
			byte[]b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			String date=new SimpleDateFormat("ddMMyyyy_HHssmm").format(new Date());
			scenario.attach(b,"image/png", date+scenario.getName());
		}
	}
	
	
}
