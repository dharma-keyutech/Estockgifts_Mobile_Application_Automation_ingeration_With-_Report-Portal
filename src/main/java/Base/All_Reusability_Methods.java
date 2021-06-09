package Base;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.Test;

import com.epam.reportportal.message.ReportPortalMessage;

//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class All_Reusability_Methods implements All_Xpaths{
	public static AppiumDriver<MobileElement> driver;
	private static final Logger logger = LogManager.getLogger(All_Reusability_Methods.class);
	Properties prop;
	FileInputStream fso;
   public static String Mobile_OS=System.getProperty("PlatformName");
   public static String Mobile_name=System.getProperty("Devicename");
   public static String App=System.getProperty("App_Name");

	
	public static void app_open(){
		try{
		
		Properties prop=new Properties();
		FileInputStream fso= new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Data.properties");
		prop.load(fso);	
		
	    DesiredCapabilities caps=new DesiredCapabilities();
		//caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability("deviceName",Mobile_name);
		caps.setCapability("udid",prop.getProperty("id")); 
		//Give Device ID of your mobile phone 192.168.0.100:5555 or 165974077d15
		caps.setCapability("platformName",Mobile_OS);
		caps.setCapability("platformVersion",prop.getProperty("Version") );
		caps.setCapability("appPackage",prop.getProperty("Package") );
		caps.setCapability("appActivity",App );
		caps.setCapability("noReset", "true" );
	    driver = new AndroidDriver<MobileElement>(new URL(" http://0.0.0.0:4723/wd/hub"), caps);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    logger.info("EstockGifts OpenSuccessfully");
	    System.out.println("EstockGifts Open Successfully");
	    
	}catch(Exception exp){
		System.out.println("cause is:"+exp.getCause());
		System.out.println("Message is:"+exp.getMessage());
		
	}
	}
	     //After signup Login Module
		
		/*public static void Login(String locator, String testdata) throws IOException{
			
			driver.findElement(By.id(locator)).click();
			driver.findElement(By.id(locator)).sendKeys(testdata);
			logger.info("Login successfully");
		}*/
		// Create Single gift card
	 /*  public static void Click(String locator){
		   driver.findElement(By.id(locator)).click();;
	   }*/
	
	//Method to perform click


		public static void Click(String locator) {

			try {
				 driver.findElement(By.xpath(locator)).click();

					logger.info("clicked ");
			

			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}
		public static void Insert_Data(String locator, String testdata){
			try{
			    
			    // Recipient and Sender Data
				driver.findElement(By.xpath(locator)).sendKeys(testdata);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				logger.info("All Data inserted Successfully");
			}catch(Exception exp){
    			System.out.println("cause is:"+exp.getCause());
    			logger.info("Create Gift Card Faild");
		
	}
		}			
			
			public static void UploadImage(String image,String gallery ,String folder,String index,String ok) throws IOException {
				try{
					driver.findElement(By.xpath((image))).click();
					// Select Photos Or  gallery
	                driver.findElement(By.xpath(gallery)).click();
	            	Thread.sleep(3000);
	               	logger.info("Selected Source Type ");
	               //Opening perticular folder "Photos"
	            	driver.findElement(By.xpath(folder)).click();
	            	Thread.sleep(3000);
	            	logger.info("Selected folder Type ");
	            	//Select image
	            	driver.findElement(By.xpath(index)).click();
	        		//Select Ok Button
	            	driver.findElement(By.xpath(ok)).click();
	            	logger.info("Selected Ok Button");
	            	logger.info("Uploaded image Successfully");
				
					}catch(Exception exp){
		    			System.out.println("cause is:"+exp.getCause());
		    			logger.info("Upload image Faild");
		}
	}
	
		public static void Select_Dropdown(String locator,String id)throws IOException{
        	    try{
        	       /* MobileElement value=driver.findElement(By.xpath(locator));
    				Select st = new Select(value);
        	    	//st.selectByIndex(2);
    				st.selectByVisibleText(Testdata);*/
        	    	
        	    	//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        	    	driver.findElement(By.xpath(locator)).click();
        	    	driver.findElement(By.xpath(id)).click();
        	    	
        	    	
        	   }catch(Exception exp){
	    			System.out.println("cause is:"+exp.getCause());
	    			logger.info("Select Expire Date Faild");

		}	
        	   }    
        
       
  
		// Click on Payment
        public static void Payment_Process(String Payment)throws IOException{
        	  try{ 
        	//Click on Proceed To Checkout Button
        	  
        	    if(Payment.equalsIgnoreCase("Paypal")){
        	    	
        	    		
        	    	logger.info("Paypal Selected");
        	    }
        	    else if(Payment.equalsIgnoreCase("credit/Debit")){
        	    	
        	    	logger.info("Credit/Debit Selected");
        	    	}
        	    

        		}catch(Exception exp){
        			System.out.println("cause is:"+exp.getCause());
        			logger.info("Payment Faild");
			
		}
	}		

	/*	
        //Method to take screen shot
        
		public void captureScreenShots() throws IOException {
			// TODO Auto-generated method stub
			String folder_name = "Screenshot";
	        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        //Date format for screenshot file name
	        SimpleDateFormat df = new  SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
	        //create directory with given folder name
	        new File(folder_name).mkdir();
	        //Setting file name
	        String file_name=df.format(new Date())+".png";
	        //coppy screenshot file into screenshot folder.
	        FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
	        System.out.println("Screenshot is saved sucessfully "+"Screenshot Folder");

	}
	*/
		public static void Close(){
			driver.quit();
		}
		
     // Take screenshots
     		public static void captureScreenShots() {
     			   
     			 ReportPortalMessage message = null;
     			    try {
     			    	TakesScreenshot ts = (TakesScreenshot)driver;
     			    	File srcFile = ts.getScreenshotAs(OutputType.FILE);
     			    	java.util.Date d= new java.util.Date();
     			    	 org.apache.commons.io.FileUtils.copyFile(srcFile, new File("./ScreenShots/"+d.toString().replace(":", "_")+".png"));
     			    	String rp_message = "test message for ReportPortal";
     			        message = new ReportPortalMessage(srcFile, rp_message);
     			    	//ReportPortal.Shared.Log.Info(srcFile, rp_message);
     			    } catch (IOException e) {
     			        e.printStackTrace();
     			    }
     			    logger.error(message);
     		   
     		}
        
        
}
		
		
		
		


	
	                                          
	
	
	
	
	
	

	
