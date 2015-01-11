package com.zemingo.baseserver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zemingo.baseserver.util.ACLogger;


public class GlobalData {
		
	public static String DB_CONNECTION_STRING_READ;
	public static String DB_CONNECTION_STRING_WRITE;
	public static String DB_READ_USERNAME;
	public static String DB_WRITE_USERNAME; 
	public static String DB_READ_PASSWORD;
	public static String DB_WRITE_PASSWORD;
	public static String LOG_PATH;
	public static String IS_PRODUCTION;
	public static String LOG_LEVEL;
	public static boolean SERVER_INITIATED = false;
		
	public static String PNS_KEYSTORE_DEV_PATH = "";
	public static String PNS_KEYSTORE_PROD_PATH = "";
	public static String PNS_ANDROID_KEY = "";
	
	public static String SMS_SID = "";
	public static String SMS_TOKEN = "";
	public static String SMS_SENDER_NUMBER = "";
	public static String VERIFICATION_BACK_DOOR = "";
	public static String VERIFICATION_SMS_PATTERN = "";
	public static String VERIFICATION_CODE_LENGTH = "";	
	public static long EXPIRATION_REGISTRATION_CODE = 3600000; /* TODO: move to configuration file */
	public static boolean isSmsEnabled = true;
	
	public static final String PROJECT_DIRECTORY = "zemingoExampleServer";
	public static final String CONFIGURATION_FILE_NAME = "config.properties";	
	public static final String CONFIG_DIRECTORY = "config";
	
	public static ClassPathXmlApplicationContext applicationContext;
	
	private static ExecutorService executor;
			
	public static void initiateServer()
	{		
		Properties prop = new Properties();
		 
    	try {
    		
            //load a properties file
       		//-------------------------------------------------------------------------
       		   		
       		String configurationFilePath =
       				"." + //current directory
       				java.io.File.separator +
       				PROJECT_DIRECTORY +
       				java.io.File.separator +
       				CONFIG_DIRECTORY +
       				java.io.File.separator +
       				CONFIGURATION_FILE_NAME;
       		
       		System.out.println("User directory is "+System.getProperty("user.dir") + " configurationFilePath = " + configurationFilePath);
       		
       		prop.load(new FileInputStream(configurationFilePath));    	
 
            DB_WRITE_USERNAME = prop.getProperty("DB_WRITE_USERNAME");
    		DB_READ_USERNAME = prop.getProperty("DB_READ_USERNAME");
    		DB_READ_PASSWORD = prop.getProperty("DB_READ_PASSWORD");
    		DB_WRITE_PASSWORD = prop.getProperty("DB_WRITE_PASSWORD");
    		DB_CONNECTION_STRING_READ = prop.getProperty("DB_CONNECTION_STRING_READ");
    		DB_CONNECTION_STRING_WRITE = prop.getProperty("DB_CONNECTION_STRING_WRITE");
    		
    		PNS_KEYSTORE_DEV_PATH = prop.getProperty("PNS_KEYSTORE_DEV_PATH");
    		PNS_KEYSTORE_PROD_PATH = prop.getProperty("PNS_KEYSTORE_PROD_PATH");
    		PNS_ANDROID_KEY = prop.getProperty("PNS_ANDROID_KEY");
    		
    		LOG_LEVEL = prop.getProperty("LOG_LEVEL");
    		IS_PRODUCTION = prop.getProperty("IS_PRODUCTION");
    		
    		SMS_SID = prop.getProperty("SMS_SID");
    		SMS_TOKEN = prop.getProperty("SMS_TOKEN");
    		SMS_SENDER_NUMBER = prop.getProperty("SMS_SENDER_NUMBER");
    		VERIFICATION_BACK_DOOR = prop.getProperty("VERIFICATION_BACK_DOOR");
    		VERIFICATION_SMS_PATTERN = prop.getProperty("VERIFICATION_SMS_PATTERN");
    		VERIFICATION_CODE_LENGTH = prop.getProperty("VERIFICATION_CODE_LENGTH");
    		LOG_PATH = prop.getProperty("LOG_PATH");
    		
    		System.out.println("log path is "+LOG_PATH + ", user directory is "+System.getProperty("user.dir"));
    			
//    		executor = Executors.newFixedThreadPool(5); //TODO: solve thread leak
//    		
//    		//initialize SMS adapter
//    		SMSAdapter adapter = new TwilioSMSAdupter(SMS_SID, 
//    				SMS_TOKEN, 
//    				SMS_SENDER_NUMBER);
//    		
//    		SMSManager.getInstance().setSMSAdapter(adapter);    		

    		SERVER_INITIATED = true;
    		
    		// Start the push scheduler every time the server starts
    		//------------------------------------------------------------------------
    		ACLogger.getLogger().info("Starting the Server !!!!!!");
    		   		    		
    		
    	} catch (IOException ex) {
    		System.out.println("Failed to initiate server: " + ex.getMessage() +". " + ACLogger.stackTraceToString(ex)); //the log might be not initialize
    		ACLogger.getLogger().severe("Failed to initiate server: " + ex.getMessage());
    		ACLogger.getLogger().severe("StackTrace: " + ACLogger.stackTraceToString(ex));    		
        }
	}
	
	public static void killServer()
	{
		
	}

	public static boolean isProduction()
	{
		if (IS_PRODUCTION.toLowerCase().compareTo("true")== 0 )
			return true;
		else
			return false;
	}
	
	public static String getPNSDevKeystore(){
		return PNS_KEYSTORE_DEV_PATH;
	}
	
	public static String getPNSProdKeystore(){
		return PNS_KEYSTORE_PROD_PATH;
	}
	
	public static String getPNSAndroidKey() {
		return PNS_ANDROID_KEY; 
	}
		
	public static ExecutorService getExecutor(){
		return executor;
	}

	public static ClassPathXmlApplicationContext getApplicationContext() {
		
		if (applicationContext == null){ //TODO: should be synchronized
			applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		}
		return applicationContext;
	}
}
