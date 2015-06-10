package xmldb;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.FileRequestEntity;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

public final class InitDatabase {
	public static final String REST_URL = "http://localhost:8984/rest/";
	
	public static void init() throws Exception {
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
        //String inputFile = ClassLoader.getSystemResource("partner.xml").getFile();
        File input = new File("data/partner.xml");
        
        PutMethod put = new PutMethod(REST_URL + "/partneri/1");
        put.addRequestHeader("Accept" , "text/xml");
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

        //	*****kreiranje kolekcije faktura*****
        
		url = new URL(REST_URL + "fakture");
		
		System.out.println(url);
		
		
		conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		
		conn.setRequestMethod(RequestMethod.PUT);
		
		responseCode = conn.getResponseCode();
		message = conn.getResponseMessage();
		System.out.println("\n* HTTP response: " + responseCode + " (" + message + ')');
		
		conn.disconnect();
        
        
        System.out.println("\n");
        System.out.println("Sent HTTP PUT request to add bussiness partner");
        //String inputFile = ClassLoader.getSystemResource("partner.xml").getFile();
        input = new File("data/faktura.xml");
        
        put = new PutMethod(REST_URL + "/fakture/1");
        put.addRequestHeader("Accept" , "text/xml");
        entity = new FileRequestEntity(input, "text/xml; charset=" + "UTF-8");
        put.setRequestEntity(entity);
        httpclient = new HttpClient();

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
}
