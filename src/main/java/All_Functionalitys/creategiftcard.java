package All_Functionalitys;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.All_Reusability_Methods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class creategiftcard extends All_Reusability_Methods {
	public static AppiumDriver<MobileElement> driver;
	private static final Logger logger = LogManager.getLogger(creategiftcard.class);
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
			captureScreenShots();

			Click(Create_Gift_Card_Button);
			logger.info("Selected Create gift Card Button");

			Select_Dropdown(SelectType, Ethereum);
			logger.info("Selected card ");

			// Recipient and Sender Data
			Insert_Data(Amount, prop.getProperty("Amount_Value"));

			Insert_Data(Recipient, prop.getProperty("Recipient_Name"));

			Click(Edit_Preview);

			Insert_Data(Recipient_Name, prop.getProperty("Recipient_FullName"));

			Insert_Data(Recipient_Email, prop.getProperty("Recipient_Emailid"));

			Insert_Data(Recipient_Mobile_No, prop.getProperty("Recipient_MobileNumber"));

			Insert_Data(Recipient_Message, prop.getProperty("Message"));

			Insert_Data(Sender_Name, prop.getProperty("Sender_FullName"));

			Insert_Data(Sender_Email, prop.getProperty("Sender_Emailid"));

			Insert_Data(Sender_Mobile, prop.getProperty("Sender_MobileNumber"));

			// Upload Frontend image
			UploadImage(Front_Image, Select_SourceType, Select_FolderType, Image_Index1, Select_OkButton);

			// Upload Background image
			UploadImage(Background_Image, Select_SourceType, Select_FolderType, Image_Index1, Select_OkButton);

			// Upload Background image
			UploadImage(Redeem_Image, Select_SourceType, Select_FolderType, Image_Index1, Select_OkButton);

			Select_Dropdown(Expire_Date, Expire_Date_60);

			logger.info("Selected Expire Date ");

			Click(Save_Button);
			logger.info("Save Button Clicked");

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
