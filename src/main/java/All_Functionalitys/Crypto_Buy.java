package All_Functionalitys;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.All_Reusability_Methods;
import Base.All_Xpaths;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Crypto_Buy extends All_Reusability_Methods implements All_Xpaths {

	public static AppiumDriver<MobileElement> driver;
	private static final Logger logger = LogManager.getLogger(Crypto_Buy.class);
	Properties prop;
	FileInputStream fso;

	@Test(groups = { "Smoke" })
	public void Gift_Card() throws IOException, InterruptedException {
		// To read The Property File
		Properties prop = new Properties();
		FileInputStream fso = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/Data.properties");
		prop.load(fso);
		try {

			app_open();
			logger.info("App Open Successfully");
			captureScreenShots();

			// Login
			Click(Login);
			Insert_Data(Enter_PIN, prop.getProperty("MPin"));
			System.out.println("Login Successfully...");
			captureScreenShots();

			// Crypto Buy
			Click(Crypto_Buy_Button);
			logger.info("Crypto button selected");
			Select_Dropdown(Crypto_Select, Crypto_Bitcoin);
			logger.info("Selected card ");
			Insert_Data(Crypto_Amount, prop.getProperty("Amount"));
			Click(Confirm_Button);
			System.out.println("Crypto Buy Successfully..");
			captureScreenShots();

			// Add Amount

			Click(Add_Money_Button);
			Insert_Data(Add_Amount, prop.getProperty("Amount"));

			Click(Credit_Button);
			logger.info("Click on credit/Debit ");

			// Payment_Process("credit/Debit");

			Insert_Data(Credit_Name, prop.getProperty("NameonCard"));
			Insert_Data(Credit_Number, prop.getProperty("card_No"));
			Insert_Data(Credit_Exp, prop.getProperty("Expire"));
			Insert_Data(Credit_CVV_No, prop.getProperty("CVV_No"));

			Click(Add_Money_Confirm_Button);
			System.out.println("Amount Added Successfully...");
			captureScreenShots();

		} catch (Exception e) {

			/* logger.error("Test Fail", e); */
			captureScreenShots();
			driver.quit();
			Assert.fail("");

		}
		Close();
	}
}
