package br.bdd.OnboardingAndroid;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestHome {
	
	private static HomeScreen homeScreen;
	private static AppiumDriver<MobileElement> appiumDriver;
	private static AndroidDriver<MobileElement> androidDriver;
	
	@BeforeClass
	public static void setup() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability("app",new File("apps/app-debug.apk"));
		  capabilities.setCapability("platformName","Android" );
		  capabilities.setCapability("deviceName","Android Emulator API 22");
		  capabilities.setCapability("unicodeKeyboard", true);
		  capabilities.setCapability("disableAndroidWatchers" , true);
		  androidDriver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub") , capabilities);
		  homeScreen = new HomeScreen(androidDriver);
	}
	
	@Test
	public void selecionarUsuario() {
		androidDriver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		androidDriver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView("+ "new UiSelector().text(\"teste 3\"));");
		
		//MobileElement elementOne = androidDriver.findElementByLinkText("teste 3");
		//System.out.println(elementOne);
		
		homeScreen.cadastro();
		 
	}
	
}
