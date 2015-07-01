package httpexception;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.dog.seodang.util.SedangResult;

public class JsonException {

	public static String makeJsonException(String code, String message) {
		
		Map<String, String> result = new HashMap<String, String>();
		result.put(SedangResult.RESULT, code);
		result.put(SedangResult.MESSAGE, message);
		return JSONObject.toJSONString(result);
		
	}
}
