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

public class Profile_Settings extends All_Reusability_Methods implements All_Xpaths {

	public static AppiumDriver<MobileElement> driver;
	private static final Logger logger = LogManager.getLogger(Profile_Settings.class);
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

			// Parent Profile Settings

		} catch (Exception e) {

			/* logger.error("Test Fail", e); */
			captureScreenShots();
			driver.quit();
			Assert.fail("");

		}
		Close();
	}
}
