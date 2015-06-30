package com.dog.seodang.util;

public class SedangResult {

	public static final String RESULT = "resultCode";
	
	public static class CODE {

		// 성공
		public static final String SUCCESS = "200";
		// 실패 ( 로그인시 )
		public static final String FAIL = "600";
		// 서버 에러
		public static final String SERVER_ERROR= "500";
		// 인증 에러
		public static final String UNAUTHORIZED= "401";
		
		// 존재하지 않음
		public static final String NO_EXSIST = "501";
	}
}
