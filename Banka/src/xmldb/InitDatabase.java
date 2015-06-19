package xmldb;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.FileRequestEntity;
import org.apache.commons.httpclient.methods.PutMethod;


/**
 * Klasa dodaje po jednog poslovnog partnera i jednu fakturu u [praznu] XML bazu podataka
 */
public final class InitDatabase {
	public static final String REST_URL = "http://localhost:8984/rest/";
	
	private static final String headerParameters[][] = {{"Accept", "text/xml"}, {"Content-Type", "application/xml"}};
	
	public static void init() throws Exception {
		/*
		//	*****kreiranje kolekcije partnera*****
		URL url = new URL(REST_URL + "partneri");
		
		System.out.println(url);
		
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		
		conn.setRequestMethod(RequestMethod.PUT);
		
		int responseCode = conn.getResponseCode();
		String message = conn.getResponseMessage();
		System.out.println("\n* HTTP response: " + responseCode + " (" + message + ')');
		
		conn.disconnect();
		
        System.out.println("\n");
        System.out.println("Sent HTTP PUT request to add bussiness partner");

        File input = new File("data/dobavljac_test.xml");
        
        PutMethod put = new PutMethod(REST_URL + "/partneri/1");
        put.addRequestHeader(headerParameters[0][0] , headerParameters[0][1]);
        put.addRequestHeader(headerParameters[1][0] , headerParameters[1][1]);
        RequestEntity entity = new FileRequestEntity(input, "text/xml; charset=" + "UTF-8");
        put.setRequestEntity(entity);
        HttpClient httpclient = new HttpClient();

        try {
            int result = httpclient.executeMethod(put);
            System.out.println("Response status code: " + result);
            System.out.println("Response body: ");
            System.out.println(put.getResponseBodyAsString());
        } finally {
        	
        	 //* Oslobodi konekciju...
        	 
            put.releaseConnection();
        }
*/
        //	*****kreiranje kolekcije faktura*****
        
		URL url = new URL(REST_URL + "fakture");
		
		System.out.println(url);
		
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		
		conn.setRequestMethod(RequestMethod.PUT);
		
		int responseCode = conn.getResponseCode();
		String message = conn.getResponseMessage();
		System.out.println("\n* HTTP response: " + responseCode + " (" + message + ')');
		
		conn.disconnect();
        
        
        System.out.println("\n");
        System.out.println("Sent HTTP PUT request to add an invoice");

        //File input = new File("data/faktura_test.xml");
        
        PutMethod put = new PutMethod(REST_URL + "/nalozi/");
        put.addRequestHeader(headerParameters[0][0] , headerParameters[0][1]);
        put.addRequestHeader(headerParameters[1][0] , headerParameters[1][1]);
        //FileRequestEntity entity = new FileRequestEntity(input, "text/xml; charset=" + "UTF-8");
        //put.setRequestEntity(entity);
        HttpClient httpclient = new HttpClient();

        try {
            int result = httpclient.executeMethod(put);
            System.out.println("Response status code: " + result);
            System.out.println("Response body: ");
            System.out.println(put.getResponseBodyAsString());
        } finally {
        	
        	 //* Oslobodi konekciju...
        	 
            put.releaseConnection();
        }
	}
	
	public static void main(String[] args) throws HttpException, IOException {
        
		URL url = new URL(REST_URL + "stavke");
		
		System.out.println(url);
		
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		
		conn.setRequestMethod(RequestMethod.PUT);
		
		int responseCode = conn.getResponseCode();
		String message = conn.getResponseMessage();
		System.out.println("\n* HTTP response: " + responseCode + " (" + message + ')');
		
		conn.disconnect();
        
	}
}
