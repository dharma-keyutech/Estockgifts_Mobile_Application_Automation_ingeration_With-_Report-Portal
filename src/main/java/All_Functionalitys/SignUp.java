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

public class SignUp extends All_Reusability_Methods implements All_Xpaths {
	public static AppiumDriver<MobileElement> driver;
	private static final Logger logger = LogManager.getLogger(SignUp.class);
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

			// Sign Up
			Click(Sign_Up_Button);
			logger.info("Selected SignUp Button");
			Insert_Data(First_Name, prop.getProperty("FirstName"));
			logger.info("Entered First Name");
			Insert_Data(Last_Name, prop.getProperty("LastName"));
			logger.info("Entered Last Name");
			Insert_Data(Email, prop.getProperty("EmailId"));
			logger.info("Entered EmailId");
			Insert_Data(Confirm_Email, prop.getProperty("Confirm_EmailId"));
			logger.info("Entered Confirm EmailId");
			Insert_Data(Mobile_No, prop.getProperty("Mobile_Num"));
			logger.info("Entered Mobile Number");
			Select_Dropdown(Select_Gender, Gender_Female);
			logger.info("Selected Gender");
		} catch (Exception e) {

			/* logger.error("Test Fail", e); */
			captureScreenShots();
			driver.quit();
			Assert.fail("");

		}
		Close();
	}
}
