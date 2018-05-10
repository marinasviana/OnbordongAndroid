package br.bdd.OnboardingAndroid;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen {
	private AppiumDriver<MobileElement> driver;
	
	public HomeScreen(AppiumDriver<MobileElement> driver)  {
		PageFactory.initElements( new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	  }
	
	@AndroidFindBy(id = "list_fab")
	public RemoteWebElement  cad;
	
	public HomeScreen exibirCadastro() {
		cad.click();
		return this;
	}
	
}
