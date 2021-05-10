package IDTechSDK;

/**
 * Response data. 	 
 */
public class ResDataStruct {
/**
 * resData: Response data buffer. 	 
 */	
	public int ret;
	public int timeout;
	public int statusCode;
	public byte[] resData;
	public String[] stringArray;
	public byte encryptionOption;
	public byte functionStatus;
	public byte keyType;
	public byte settingValue;
	public int[] responseIdxes;
}


