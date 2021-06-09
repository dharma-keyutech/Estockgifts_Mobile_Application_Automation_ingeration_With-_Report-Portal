package All_Functionalitys;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.All_Reusability_Methods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Create_Certificate extends All_Reusability_Methods {
	public static AppiumDriver<MobileElement> driver;
	private static final Logger logger = LogManager.getLogger(Create_Certificate.class);
	Properties prop;
	FileInputStream fso;

	@Test
	public void Gift_Card() throws IOException, InterruptedException {
		// To read The Property File
		Properties prop = new Properties();
		FileInputStream fso = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/Data.properties");
		prop.load(fso);
		try {
			app_open();
			logger.info("App Open Successfully");
			// Create Certificate
			Click(Create_Gift_Card_Button);
			logger.info("Selected Create gift Card Button");

			Click(Crypto_Certificate_Button);
			Click(Blue);
			Select_Dropdown(Choose_Crypto, Ethereum);
			logger.info("Selected card ");
			Insert_Data(Recipient_Name, prop.getProperty("Recipient_Name"));
			Insert_Data(Recipient_Email, prop.getProperty("Recipient_Emailid"));
			Insert_Data(CryptoAmount, prop.getProperty("Amount_Value"));
			Insert_Data(Sender_Name, prop.getProperty("Sender_FullName"));
			Insert_Data(Sender_Email, prop.getProperty("Sender_Emailid"));
			Insert_Data(message, prop.getProperty("Message1"));
			Insert_Data(Disclaimer, prop.getProperty("Message2"));
			UploadImage(Upload_signature, Select_SourceType, Select_FolderType, Image_Index1, Select_OkButton);

			Select_Dropdown(Expire_Date, Expire_Date_90);
			Click(purchase);
			Click(Proceed_To_Checkout);
			logger.info("Click on Proceed to checkout");
			Click(Credit_Debit_Button);
			logger.info("Click on credit/Debit ");

			Payment_Process("credit/Debit");
			Insert_Data(Name_on_Card, prop.getProperty("NameonCard"));
			Insert_Data(card_Number, prop.getProperty("card_No"));
			Insert_Data(Expiration, prop.getProperty("Expire"));
			Insert_Data(CVV_Number, prop.getProperty("CVV_No"));

			// Click on Submit Button
			Click(Submit_Button);
			logger.info("Selected Submit Button");
			System.out.println("Gift Card Created Successfully..");

		} catch (Exception e) {

			/* logger.error("Test Fail", e); */
			captureScreenShots();
			driver.quit();
			Assert.fail("");

		}
		Close();
	}
}
