package httpexception;

import com.dog.seodang.util.SedangResult;

public class JsonException {

	public static String makeJsonException(String code) {
		
		
		return "{ \""+ SedangResult.RESULT+ "\": \"" + code + "\" }";
		
	}
}
