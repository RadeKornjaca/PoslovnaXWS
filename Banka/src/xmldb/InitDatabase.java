package xmldb;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.xml.bind.JAXBException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PutMethod;

import poslovnaxws.banke.RacunBanke;
import sessionbeans.concrete.RacunBankeDao;

/**
 * Klasa dodaje po jednog poslovnog partnera i jednu fakturu u [praznu] XML bazu
 * podataka
 */
public final class InitDatabase {
	public static final String REST_URL = "http://localhost:8984/rest/";

	private static final String headerParameters[][] = {
			{ "Accept", "text/xml" }, { "Content-Type", "application/xml" } };

	public static void init() throws Exception {
		/*
		 * // *****kreiranje kolekcije partnera***** URL url = new URL(REST_URL
		 * + "partneri");
		 * 
		 * System.out.println(url);
		 * 
		 * 
		 * HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		 * conn.setDoOutput(true);
		 * 
		 * conn.setRequestMethod(RequestMethod.PUT);
		 * 
		 * int responseCode = conn.getResponseCode(); String message =
		 * conn.getResponseMessage(); System.out.println("\n* HTTP response: " +
		 * responseCode + " (" + message + ')');
		 * 
		 * conn.disconnect();
		 * 
		 * System.out.println("\n");
		 * System.out.println("Sent HTTP PUT request to add bussiness partner");
		 * 
		 * File input = new File("data/dobavljac_test.xml");
		 * 
		 * PutMethod put = new PutMethod(REST_URL + "/partneri/1");
		 * put.addRequestHeader(headerParameters[0][0] ,
		 * headerParameters[0][1]); put.addRequestHeader(headerParameters[1][0]
		 * , headerParameters[1][1]); RequestEntity entity = new
		 * FileRequestEntity(input, "text/xml; charset=" + "UTF-8");
		 * put.setRequestEntity(entity); HttpClient httpclient = new
		 * HttpClient();
		 * 
		 * try { int result = httpclient.executeMethod(put);
		 * System.out.println("Response status code: " + result);
		 * System.out.println("Response body: ");
		 * System.out.println(put.getResponseBodyAsString()); } finally {
		 * 
		 * //* Oslobodi konekciju...
		 * 
		 * put.releaseConnection(); }
		 */
		// *****kreiranje kolekcije faktura*****

		URL url = new URL(REST_URL + "fakture");

		System.out.println(url);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);

		conn.setRequestMethod(RequestMethod.PUT);

		int responseCode = conn.getResponseCode();
		String message = conn.getResponseMessage();
		System.out.println("\n* HTTP response: " + responseCode + " ("
				+ message + ')');

		conn.disconnect();

		System.out.println("\n");
		System.out.println("Sent HTTP PUT request to add an invoice");

		// File input = new File("data/faktura_test.xml");

		PutMethod put = new PutMethod(REST_URL + "/nalozi/");
		put.addRequestHeader(headerParameters[0][0], headerParameters[0][1]);
		put.addRequestHeader(headerParameters[1][0], headerParameters[1][1]);
		// FileRequestEntity entity = new FileRequestEntity(input,
		// "text/xml; charset=" + "UTF-8");
		// put.setRequestEntity(entity);
		HttpClient httpclient = new HttpClient();

		try {
			int result = httpclient.executeMethod(put);
			System.out.println("Response status code: " + result);
			System.out.println("Response body: ");
			System.out.println(put.getResponseBodyAsString());
		} finally {

			// * Oslobodi konekciju...

			put.releaseConnection();
		}
	}

	public static void initRacuni(){
		//Za racune-----------------------------------------------------
		URL url;
		try {
			
			url = new URL(REST_URL + "racuniBanke");
			System.out.println(url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(RequestMethod.PUT);
			int responseCode = conn.getResponseCode();
			String message = conn.getResponseMessage();
			System.out.println("\n* HTTP response: " + responseCode + " ("
					+ message + ')');
			RacunBankeDao racunBankeDao = new RacunBankeDao();
			RacunBanke racunBanke = new RacunBanke();
			racunBanke.setRacunKlijenta("111-1111111111111-11");
			racunBanke.setStanjeRacuna(new BigDecimal(200000));
			System.out.println("Pre persista");
			racunBankeDao.persist(racunBanke);
			racunBanke = new RacunBanke();
			racunBanke.setRacunKlijenta("111-3333333333333-33");
			racunBanke.setStanjeRacuna(new BigDecimal(200000));
			System.out.println("Pre persista");
			racunBankeDao.persist(racunBanke);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//--------------------------------------------------------------
	}
	
	public static void main(String[] args) throws HttpException, IOException,
			JAXBException {

		
		initRacuni();
		
		/*URL url = new URL(REST_URL + "mt102");

		System.out.println(url);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);

		conn.setRequestMethod(RequestMethod.PUT);

		int responseCode = conn.getResponseCode();
		String message = conn.getResponseMessage();
		System.out.println("\n* HTTP response: " + responseCode + " ("
				+ message + ')');

		url = new URL(REST_URL + "mt103");

		System.out.println(url);

		conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);

		conn.setRequestMethod(RequestMethod.PUT);

		responseCode = conn.getResponseCode();
		message = conn.getResponseMessage();
		System.out.println("\n* HTTP response: " + responseCode + " ("
				+ message + ')');

		url = new URL(REST_URL + "mt900");

		System.out.println(url);

		conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);

		conn.setRequestMethod(RequestMethod.PUT);

		responseCode = conn.getResponseCode();
		message = conn.getResponseMessage();
		System.out.println("\n* HTTP response: " + responseCode + " ("
				+ message + ')');

		url = new URL(REST_URL + "mt910");

		System.out.println(url);

		conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);

		conn.setRequestMethod(RequestMethod.PUT);

		responseCode = conn.getResponseCode();
		message = conn.getResponseMessage();
		System.out.println("\n* HTTP response: " + responseCode + " ("
				+ message + ')');

		url = new URL(REST_URL + "preseci");

		System.out.println(url);

		conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);

		conn.setRequestMethod(RequestMethod.PUT);

		responseCode = conn.getResponseCode();
		message = conn.getResponseMessage();
		System.out.println("\n* HTTP response: " + responseCode + " ("
				+ message + ')');

		url = new URL(REST_URL + "uplata");

		System.out.println(url);

		conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);

		conn.setRequestMethod(RequestMethod.PUT);

		responseCode = conn.getResponseCode();
		message = conn.getResponseMessage();
		System.out.println("\n* HTTP response: " + responseCode + " ("
				+ message + ')');

		url = new URL(REST_URL + "banka");

		System.out.println(url);

		conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);

		conn.setRequestMethod(RequestMethod.PUT);

		responseCode = conn.getResponseCode();
		message = conn.getResponseMessage();
		System.out.println("\n* HTTP response: " + responseCode + " ("
				+ message + ')');

		conn.disconnect();

		
		
		
		BankaDao bankaDao = new BankaDao();
		Banka bankaWrapper = new Banka();
		TBanka banka = new TBanka();
		banka.setNaziv("Banka12");
		banka.setModel(new BigInteger("97"));
		banka.setRacun("111-1111111111111-11");
		banka.setPozivNaBroj("AKA");
		banka.setSwiftKod("BANKAS12");
		banka.setSifra(111);
		bankaWrapper.setBanka(banka);
		bankaWrapper.setId("111");
		bankaDao.persist(bankaWrapper);

		banka = new TBanka();
		bankaWrapper = new Banka();
		banka.setNaziv("Banka34");
		banka.setModel(new BigInteger("97"));
		banka.setRacun("222-2222222222222-22");
		banka.setPozivNaBroj("ADA");
		banka.setSwiftKod("BANKAS34");
		banka.setSifra(222);
		bankaWrapper.setBanka(banka);
		bankaWrapper.setId("222");
		bankaDao.persist(bankaWrapper);

		/*
		 * File file = new File("C:/Users/Lazar/Desktop/Faks/presek.xml");
		 * JAXBContext jaxbContext = JAXBContext.newInstance(Preseci.class);
		 * Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		 * Preseci preseci = (Preseci) jaxbUnmarshaller.unmarshal(file);
		 * 
		 * PreseciDao dao = new PreseciDao();
		 * 
		 * dao.persist(preseci);
		 */

	}
}
