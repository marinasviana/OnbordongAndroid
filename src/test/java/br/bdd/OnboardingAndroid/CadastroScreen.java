package br.bdd.OnboardingAndroid;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CadastroScreen {
	private AppiumDriver<MobileElement> driver;
	public CadastroScreen(AppiumDriver<MobileElement> driver)  {
		PageFactory.initElements( new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	  }
	
	@AndroidFindBy(id = "dialog_edtName")
	public RemoteWebElement  nome;
	
	@AndroidFindBy(id = "dialog_edtLastName")
	public RemoteWebElement sobrenome;
	
	@AndroidFindBy(id = "dialog_edtBirthDate")
	public RemoteWebElement dataNascimento;
	
	@AndroidFindBy(id = "dialog_edtMail")
	public RemoteWebElement email;
	
	@AndroidFindBy(id = "create_dialog")
	public RemoteWebElement ddd;
	
	@AndroidFindBy(id = "dialog_edtPhone")
	public RemoteWebElement telefone;
	
	@AndroidFindBy(id = "dialog_edtCompany")
	public RemoteWebElement empresa;
	
	@AndroidFindBy(id = "dialog_edtNotes")
	public RemoteWebElement notas;
}
