package com.party.partymangement.util;

public class Util {

	public static int convertIdToInt(String id) {
		String num = id.split("_")[1];
		int intNum = Integer.parseInt(num);
		return intNum;
	}

}
