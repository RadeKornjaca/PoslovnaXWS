package util;

import java.util.HashMap;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import entity.Drzava;

public class Test {

	public static void main(String[] args) {

		try {
			HashMap<String, String> mapa = new HashMap<String, String>();
			mapa.put("idDrzave", "1");
			mapa.put("sifraDrzave", "RSD");
			mapa.put("sort", "sifraDrzadve:asc,idDrzave:desc");
			System.out.println(EntityInfoUtil
					.getQueryString(Drzava.class, mapa));
		} catch (QueryBuilderException e) {
			e.printStackTrace();
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Bad request.");
			mapper.put("reason", e.getMessage());
			System.out.println("tostring"+mapper.toString());
			System.out.println("astext"+mapper.asText());
		}
		


	}

}
