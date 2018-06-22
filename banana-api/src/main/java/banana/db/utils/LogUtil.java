package banana.db.utils;

public abstract class LogUtil {
	
	public static String formatDBLog(String methodName, Object input, Object response) {
		
		StringBuffer strBuff = new StringBuffer();
		strBuff.append(methodName + " ");
		strBuff.append("--> " + input + " ");
		strBuff.append("|" + response);
		
		return strBuff.toString();
		
	}

}
