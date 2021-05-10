package IDTechSDK;

public interface CTLSFunctional {
	
	int ctls_startTransaction(double amount, double amtOther, int type, final int timeout, byte[] tags);
	
	int ctls_activateTransaction(final int timeout, byte[] tags);
	
	int ctls_cancelTransaction();
	
	int ctls_getAllConfigurationGroups(byte[] tlv);
	
	int ctls_getConfigurationGroup(int group, byte[] tlv);
	
	int ctls_retrieveApplicationData(String aid, ResDataStruct respData);
	
	int ctls_removeApplicationData(String aid);
	
	int ctls_removeAllApplicationData();
	
	int ctls_setApplicationData(byte[] TLV);
	
	int ctls_removeConfigurationGroup(int group);
	
	int ctls_setConfigurationGroup(byte[] TLV);
	
	int ctls_retrieveTerminalData(ResDataStruct respData);
	
	int ctls_setTerminalData(byte[] TLV);
	
	int ctls_retrieveAidList(ResDataStruct respData);
	
	int ctls_retrieveCAPK(byte[] data, ResDataStruct respData);
	
	int ctls_removeCAPK(byte[] capk);
	
	int ctls_removeAllCAPK();
	
	int ctls_setCAPK(byte[] key);
	
	int ctls_retrieveCAPKList(ResDataStruct respData);
}
