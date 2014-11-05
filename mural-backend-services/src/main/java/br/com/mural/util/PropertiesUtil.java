package br.com.mural.util;

import java.util.ResourceBundle;

public class PropertiesUtil {

	private static ResourceBundle generalbundle =null;
	private static String GENERAL_BUNDLE="general";

	
	private static ResourceBundle mongoBundle =null;
	private static final String MONGO_BUNDLE = "mongo";
	public static final String MONGO_URI = "mongo.uri";
	public static final String USE_FAKE ="mongo.use.fake";	
	public static final String DB_NAME ="mongo.dbname";
	
	public static String getApplicationGeneralPropertie(String messageKey){
		if(generalbundle == null){
			generalbundle = ResourceBundle.getBundle(GENERAL_BUNDLE);
		}		
		return generalbundle.getString(messageKey);
	}
	
	public static String getMongoPropertie(String messageKey){
		if(mongoBundle == null){
			mongoBundle = ResourceBundle.getBundle(MONGO_BUNDLE);
		}		
		return mongoBundle.getString(messageKey);
	}
}
