package util;

import java.lang.reflect.Field;

import entity.NaseljenoMesto;

public class Test {

	public static void main(String[] args) {
		Field[] fields = NaseljenoMesto.class.getDeclaredFields();
		for (Field field : fields){
			MetaData meta = new MetaData(field, new Restriction());
		}
		

	}

}
