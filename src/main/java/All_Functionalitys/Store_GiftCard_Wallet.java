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

public class Store_GiftCard_Wallet extends All_Reusability_Methods implements All_Xpaths {
	public static AppiumDriver<MobileElement> driver;
	private static final Logger logger = LogManager.getLogger(Store_GiftCard_Wallet.class);
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

			// Login
			Click(Login);
			Insert_Data(Enter_PIN, prop.getProperty("MPin"));
			System.out.println("Login Successfully...");
			captureScreenShots();

			// Store GiftCard Wallet
			Click(Hamburger_Menu);
			logger.info("Hamburger_Menu selected");
			Click(StoreGiftCrad_Button);
			logger.info("StoreGiftCrad_Button Selected");
			Click(AddCard_Button);
			logger.info("AddCard_Button Selected");
			Select_Dropdown(Select_Store, Amazon_Card);
			logger.info("Card Selected");
			Click(Card_Expire_No);
			Insert_Data(Card_Num, prop.getProperty("card_No"));
			logger.info("Card Number Entered");
			Insert_Data(Pin, prop.getProperty("pin"));
			Insert_Data(Store_Amount, prop.getProperty("Amount"));

			UploadImage(GiftCard_Image1, Select_SourceType, Select_FolderType, Image_Index1, Select_OkButton);
			Click(Addanother_Image_Button);
			UploadImage(GiftCard_Image2, Select_SourceType, Select_FolderType, Image_Index1, Select_OkButton);

			Insert_Data(Details, prop.getProperty("Card_Message"));
			Click(Save_StoreGiftCard);
			System.out.println("Gift card Stored Successfully..");
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
