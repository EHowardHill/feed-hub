package IDTechSDK;

public interface EMVFunctional {
	void emv_allowFallback(boolean allow);
	
	void emv_setAutoAuthenticateTransaction(boolean auto);
	
	int emv_startTransaction(double amount, double amtOther, int type, final int timeout, byte[] tags, boolean forceOnline);
	
	int emv_authenticateTransaction(byte[] tags);
	
	int emv_completeTransaction(boolean commError, byte[] authCode, byte[] iad, byte[] tlvScripts, byte[] tags);
	
	int emv_cancelTransaction(ResDataStruct respData);
	
	int emv_retrieveApplicationData(String aid, ResDataStruct respData);
	
	int emv_removeApplicationData(String aid);
	
	int emv_setApplicationData(String aid, byte[] TLV);
	
	int emv_retrieveTerminalData(ResDataStruct respData);
	
	int emv_removeTerminalData();
	
	int emv_setTerminalData(byte[] TLV);
	
	int emv_retrieveAidList(ResDataStruct respData);
	
	int emv_retrieveCAPK(byte[] data, ResDataStruct respData);
	
	int emv_removeCAPK(byte[] capk);
	
	int emv_setCAPK(byte[] key);
	
	int emv_retrieveCAPKList(ResDataStruct respData);
	
	int emv_retrieveCRL(ResDataStruct respData);
	
	int emv_removeCRL(byte[] crlList);
	
	int emv_setCRL(byte[] crlList);
	
	void emv_lcdControlResponse(byte mode, byte data);
	
	int emv_getEMVKernelVersion(StringBuilder version);
	
	int emv_getEMVKernelCheckValue(ResDataStruct respData);
	
	int emv_getEMVConfigurationCheckValue(ResDataStruct respData);

	int emv_retrieveExceptionList(ResDataStruct respData);
	
	int emv_setException(byte[] exception);
	
	int emv_removeException(byte[] exception);
	
	int emv_removeAllExceptions();
	
	int emv_retrieveExceptionLogStatus(ResDataStruct respData); 
	
	int emv_removeTransactionLog();
	
	int emv_retrieveTransactionLogStatus(ResDataStruct respData);
	
	int emv_retrieveTransactionLog(ResDataStruct respData, MutableInteger remainingTransactionLogLen);
}
