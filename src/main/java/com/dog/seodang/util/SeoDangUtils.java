package com.dog.seodang.util;

import java.util.List;

public class SeoDangUtils {
	
	public static boolean isListEmpty(List list) {
		
		if(list == null || list.size() == 0){
			return true;
		} else {
			return false;	
		}
	}
	
	public static boolean isMoreThanZero(int result) {
		if(result > 0){
			return true;
		}else {
			return false;	
		}
	}
}
