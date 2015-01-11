package com.zemingo.baseserver.util;

import java.util.ArrayList;

public class ZemingoUtils {
	public static int getRandom(int lowerbound, int upperbound){
		return (int)(Math.random() * ((upperbound - lowerbound) + 1) + lowerbound);
	}

	public static String arrayListToCommaSeparated(ArrayList<String> duplicateIds) {
		if (duplicateIds == null)
			return "null";
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (String str : duplicateIds){
			if (!isFirst){
				sb.append(',');
			}
			else{
				isFirst = false;
			}
			sb.append(str);
		}
		return sb.toString();
	}
}
