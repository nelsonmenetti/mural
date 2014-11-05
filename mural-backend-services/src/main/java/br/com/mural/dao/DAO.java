/*
 * Pearson All Rights Reserved
 * Nelson Fernando da Silva Menetti - Developer 
 */
package br.com.mural.dao;

import java.net.UnknownHostException;

import org.jongo.Jongo;

import br.com.mural.util.PropertiesUtil;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * The Class DAO.
 */
public class DAO  {

	
	/** The mongo uri. */
	private String mongoURI = "";
	
	/** The use fake connection. */
	private boolean useFakeConnection =false;
	
	/** The fake connection. */
	private static DB fakeConnection = null;
	
	private static DB realConnection = null;

	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 * @throws UnknownHostException the unknown host exception
	 */
	public Jongo getConnection() throws UnknownHostException{
		mongoURI = PropertiesUtil.getMongoPropertie(PropertiesUtil.MONGO_URI);		
		useFakeConnection = new Boolean(PropertiesUtil.getMongoPropertie(PropertiesUtil.USE_FAKE));
		DB db = null;
		if(useFakeConnection){
			db = fakeConnection;			
		}
		else{
			if(realConnection == null){
				MongoClientURI uri =  new MongoClientURI(mongoURI);
				MongoClient mongoClient = new MongoClient(uri);
				realConnection = mongoClient.getDB(PropertiesUtil.getMongoPropertie(PropertiesUtil.DB_NAME));
			}
			db = realConnection;
		}
		Jongo jongo = new Jongo(db);
		return jongo;
		
	}



	/**
	 * Gets the fake connection.
	 *
	 * @return the fake connection
	 */
	public static DB getFakeConnection() {
		return fakeConnection;
	}



	/**
	 * Sets the fake connection.
	 *
	 * @param fakeConnection the new fake connection
	 */
	public static void setFakeConnection(DB fakeConnection) {
		DAO.fakeConnection = fakeConnection;
	}
	
	
}
