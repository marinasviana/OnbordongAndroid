package br.bdd.OnboardingAndroid;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestHome {

	private static HomeScreen homeScreen;
	private static CadastroScreen cadastroScreen;
	private static AndroidDriver<MobileElement> androidDriver;
	static Dimension size;

	@BeforeClass
	public static void setup() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app", new File("apps/app-debug.apk"));
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Nexus 5X API 27");
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("disableAndroidWatchers", true);
		capabilities.setCapability("noReset", false);
		androidDriver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
		homeScreen = new HomeScreen(androidDriver);
		
		
		androidDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		// MobileElement teste = androidDriver.findElement(By.id("main_rvUser"));
		boolean text;
		try {
			androidDriver.findElement(By.id("main_rvUser"));//.isDisplayed();
			text = true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			text = false;
		}
		System.out.println(text);
		// Boolean teste2 = teste.isDisplayed();
		if (!text) {
			MobileElement naoCarregouUsuarios = androidDriver.findElement(By.id("main_tv_no_friends"));
			Boolean usuariosLista = naoCarregouUsuarios.getText().contains("Não encontramos nenhum contato no momento :(");
			if (usuariosLista) {
				size = androidDriver.manage().window().getSize();
				int starty = (int) (size.height * 0.80);
				int endy = (int) (size.height * 0.20);
				int startx = size.width / 2;
				androidDriver.swipe(startx, endy, startx, starty, 3000);
				Thread.sleep(2000);
			}
		}

	}
	
	@Test
	public void alterarCadastro() {
		androidDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		androidDriver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"teste 3\"));");

		// MobileElement elementOne = androidDriver.findElementByLinkText("teste 3");
		// System.out.println(elementOne);

		homeScreen.exibirCadastro();

	}
	
	
	public void novoCadastro() {
		cadastroScreen = new CadastroScreen(androidDriver);
		cadastroScreen.cadastrar.click();
	}
	
	
	

}
