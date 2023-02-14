package com.collections;

import java.util.Map;
import java.util.TreeMap;

public class MapsTest {

	public static void main(String[] args) throws Exception {

		Map<String, Integer> map = new TreeMap<>();

		map.put("chandra", 11221);
		map.put("kiran", 11222);
		map.put("alekhya", 11223);
		map.put("syed", 11224);

		for(Map.Entry<String, Integer> k : map.entrySet() ) {
			System.out.println("key =" + k.getKey() + ", value = " + k.getValue() );
		}

	}

}
