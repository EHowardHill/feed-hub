/*
 * IDTechSDK JNI class.
 * © G J Barnard 2013 - Attribution-NonCommercial-ShareAlike 3.0 Unported - http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB.
 * 
 * Defines the native functions to use and loads the resulting 'libidtech_jni.so' for Java to use at runtime.
 * 
 * Start here.
 * So with this file operating above the package folder:
 * javac IDTechSDK/IDTechSDKBridge.java to generate the .class file for IDTechSDKBridge.
 * javah IDTechSDK.IDTechSDKBridge to generate the idtech_jni_IDTechSDK_Bridge.h file with the function declarations to implement.
 * Then look at the instructions in idtech_jni_IDTechSDK_Bridge.c.
 * 
 * Useful websites:
 * http://jonisalonen.com/2012/calling-c-from-java-is-easy/
 * http://www.steveolyo.com/JNI/JNI.html
 */

package IDTechSDK;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

public class IDTechSDKBridge {

	
    // Load the C dynamic 'so' library which will contain the implemented 'C' functions....
    static
    {
    		System.loadLibrary("IDTechSDK");
    }
    
    public static OnReceiverListener m_recListener;
    
    private interface OPERATING_SYSTEM {
    	String WINDOWS = "windows";
    }
    
    private static final int RETURN_CODE_SUCCESS = 0;
            
    private static void copyObject(Object object, Object objectToCopy) {
    	Field[] fields = object.getClass().getDeclaredFields();
    	
    	for (Field field : fields) {
    		try {
				field.set(object, field.get(objectToCopy));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }   
    
    public static String byteToString(byte[] bytes){
    	String result = "";
    	if (bytes ==  null || bytes.length == 0) return result;
    	for(int i = 0; i < bytes.length; i++){
    		if ((bytes[i] & 0x80) == 0x00)
    			result += String.format("%c", bytes[i]);
    	}
		return result;	
    }
    
    public static byte[] stringToByteArray(String hex) {
    	byte[] byteArray = new byte[hex.length() / 2];
    	
    	for (int i = 0; i < byteArray.length; i++) {
    		int index = i * 2;
    		int hexByte = Integer.parseInt(hex.substring(index, index + 2), 16);
    		byteArray[i] = (byte)hexByte;
    	}
    	
    	return byteArray;
    }
    
    public static void enableLogging(int logLevel){
    	jenableLogging(logLevel);
    }
    
    public static int msr_getExpirationMask(ResDataStruct respData) {
    	int rc = jmsrgetExpirationMask();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int msr_getClearPANID(ResDataStruct respData) {
    	int rc = jmsrgetClearPANID();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int msr_getSwipeForcedEncryptionOption(ResDataStruct respData) {
    	int rc = jmsrgetSwipeForcedEncryptionOption();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int msr_getSwipeMaskOption(ResDataStruct respData) {
    	int rc = jmsrgetSwipeMaskOption();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int msr_getSetting(byte setting, ResDataStruct respData) {
    	int rc = jmsrgetSetting(setting);
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int msr_getSwipeEncryption(ResDataStruct respData) {
    	int rc = jmsrgetSwipeEncryption();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int msr_RetrieveWhiteList(ResDataStruct respData) {
    	int rc = jmsrRetrieveWhiteList();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int msr_getFunctionStatus(ResDataStruct respData) {
    	int rc =jmsrgetFunctionStatus();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int msr_getMSRData(ResDataStruct respData) {
    	int rc = jmsrgetMSRData();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int msr_getKeyTypeForICCDUKPT(ResDataStruct respData) {
    	int rc = jmsrgetKeyTypeForICCDUKPT();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int msr_getKeyFormatForICCDUKPT(ResDataStruct respData) {
    	int rc = jmsrgetKeyFormatForICCDUKPT();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int device_getFirmwareVersion(StringBuilder version){    	
    	int rc = jdevicegetFirmwareVersion();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		version.append(jdevicegetGeneralString());
    	
    	return rc;
    }
    
    public static int device_getDRS(ResDataStruct respData) {
    	int rc = jdevicegetDRS();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());

    	return rc;
    }
    
    public static int device_getKeyStatus(ResDataStruct respData) {
    	int rc = jdevicegetKeyStatus();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int device_sendDataCommand(String cmd, boolean calcLRC, String data, ResDataStruct respData) {
    	byte[] cmdBytes = stringToByteArray(cmd);
    	byte[] dataBytes = null;
    	if (data != null)
    		dataBytes = stringToByteArray(data);
    	    	
    	int rc = jdevicesendDataCommand(cmdBytes, calcLRC, dataBytes);
    	    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int device_getMerchantRecord(int index, ResDataStruct respData) {
    	int rc = jdevicegetMerchantRecord(index);
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int device_getTransactionResults(IDTMSRData cardData) {
    	int rc = jdevicegetTransactionResults();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(cardData, jgetLastIDTMSRDataObj());
    		
    	return rc;
    }
    
    public static int device_pollCardReader(ResDataStruct respData) {
    	int rc = jdevicepollCardReader();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int device_getSpectrumProKSN(int type, ResDataStruct respData) {
    	int rc = jdevicegetSpectrumProKSN(type);
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int device_getDriveFreeSpace(MutableInteger free, MutableInteger used) {
    	int rc = jdevicegetDriveFreeSpace();
    	
    	if (rc == RETURN_CODE_SUCCESS) {
    		free.set(jgetGeneralIntOne());
    		used.set(jgetGeneralIntTwo());
    	}
    		
    	return rc;
    }
    
    public static int device_listDirectory(String directoryName, int recursive, Integer onSD, StringBuilder directories) {
    	int rc = jdevicelistDirectory(directoryName, recursive, onSD);
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		directories.append(jdevicegetGeneralString());
    	
    	return rc;
    }
    
    public static int config_getSerialNumber(StringBuilder serialNumber) {
    	int rc = jconfiggetSerialNumber();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		serialNumber.append(jdevicegetGeneralString());

    	return rc;
    }
    
    public static int config_getModelNumber(StringBuilder modelNumber) {
    	int rc = jconfiggetModelNumber();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		modelNumber.append(jdevicegetGeneralString());
    	
    	return rc;
    }
    
    public static int config_getEncryptionControl(ResDataStruct respData) {
    	int rc = jconfiggetEncryptionControl();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int icc_powerOnICC(ResDataStruct atrPPS) {
    	int rc = jiccpowerOnICC();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(atrPPS, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int icc_getICCReaderStatus(ICCReaderStatusStruct ICCStatus) {
    	int rc = jiccgetICCReaderStatus();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(ICCStatus, jgetLastICCReaderStatusStructObj());
    	    	
    	return rc;
    }
    
    public static int icc_exchangeAPDU(byte[] dataAPDU, ResDataStruct response) {
    	int rc = jiccexchangeAPDU(dataAPDU);
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(response, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int icc_getKeyTypeForICCDUKPT(ResDataStruct respData) {
    	int rc = jiccgetKeyTypeForICCDUKPT();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int icc_getKeyFormatForICCDUKPT(ResDataStruct respData) {
    	int rc = jiccgetKeyFormatForICCDUKPT();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int icc_getFunctionStatus(ResDataStruct respData) {
    	int rc = jiccgetFunctionStatus();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
	
	public static int emv_retrieveApplicationData(String aid, ResDataStruct respData) {
		byte[] AIDBytes = stringToByteArray(aid);
				
		int rc = jemvretrieveApplicationData(AIDBytes);
		
		if (rc == RETURN_CODE_SUCCESS)
			copyObject(respData, jgetLastResDataStructObj());
		
		return rc;
	}
	
	public static int emv_removeApplicationData(String aid) {
		byte[] AIDBytes = stringToByteArray(aid);
		
		return jemvremoveApplicationData(AIDBytes);
	}
	
	public static int emv_setApplicationData(String aid, byte[] TLV) {
		byte[] AIDBytes = stringToByteArray(aid);
		
		return jemvsetApplicationData(AIDBytes, TLV);
	}
	
    public static int emv_retrieveTerminalData(ResDataStruct respData) {
    	int rc = jemvretrieveTerminalData();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	    	    	    	
    	return rc;
    }
    
    public static int emv_retrieveAidList(ResDataStruct respData) {
    	int rc = jemvretrieveAidList();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int emv_retrieveCAPK(byte[] data, ResDataStruct respData) {
    	int rc = jemvretrieveCAPK(data);
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
        
    public static int emv_retrieveCAPKList(ResDataStruct respData) {
    	int rc = jemvretrieveCAPKList();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int emv_retrieveTerminalID(StringBuilder terminalID) {
    	int rc = jemvretrieveTerminalID();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		terminalID.append(jdevicegetGeneralString());
    	
    	return rc;
    }
    
    public static int emv_retrieveCRL(ResDataStruct respData) {
    	int rc = jemvretrieveCRL();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int emv_getEMVKernelVersion(StringBuilder version) {
    	int rc = jemvgetEMVKernelVersion();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		version.append(jdevicegetGeneralString());
    	
    	return rc;
    }
    
    public static int emv_getEMVKernelCheckValue(ResDataStruct respData) {
    	int rc = jemvgetEMVKernelCheckValue();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int emv_getEMVConfigurationCheckValue(ResDataStruct respData) {
    	int rc = jemvgetEMVConfigurationCheckValue();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int emv_retrieveTransactionResult(byte[] tags, Map<String, Map<String, byte[]>> retrievedTags) {
    	int rc = jemvretrieveTransactionResult(tags);
    	    	
    	if (rc == RETURN_CODE_SUCCESS) {    		
    		Map<String, Map<String, byte[]>> nativeTransactionResult = jgetLastTransactionResult();
    		
    		ArrayList<String> keys = new ArrayList<String>(nativeTransactionResult.keySet());
    		
    		for (String key : keys)
    			retrievedTags.put(key, nativeTransactionResult.get(key));    		
    	}
    	    	
    	return rc;
    }
    
    public static int emv_retrieveExceptionList(ResDataStruct respData) {
    	int rc = jemvretrieveExceptionList();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int emv_retrieveExceptionLogStatus(ResDataStruct respData) {
    	int rc = jemvretrieveExceptionLogStatus();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int emv_retrieveTransactionLogStatus(ResDataStruct respData) {
    	int rc = jemvretrieveTransactionLogStatus();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int emv_retrieveTransactionLog(ResDataStruct respData, MutableInteger remainingTransactionLogLen) {
    	int rc = jemvretrieveTransactionLog();
    	
    	if (rc == RETURN_CODE_SUCCESS) {
    		copyObject(respData, jgetLastResDataStructObj());
    		remainingTransactionLogLen.set(jgetGeneralIntOne());
    	}
    	
    	return rc;
    }
    
    public static int ctls_retrieveApplicationData(String aid, ResDataStruct respData) {
    	byte[] AIDBytes = stringToByteArray(aid);
    	
    	int rc = jctlsretrieveApplicationData(AIDBytes);
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int ctls_removeApplicationData(String aid) {
    	byte[] AIDBytes = stringToByteArray(aid);
    	
    	return jctlsremoveApplicationData(AIDBytes);    	    	
    }
    
    public static int ctls_retrieveTerminalData(ResDataStruct respData) {
    	int rc = jctlsretrieveTerminalData();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int ctls_retrieveAidList(ResDataStruct respData) {
    	int rc = jctlsretrieveAidList();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int ctls_retrieveCAPK(byte[] data, ResDataStruct respData) {
    	int rc = jctlsretrieveCAPK(data);
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    public static int ctls_retrieveCAPKList(ResDataStruct respData) {
    	int rc = jctlsretrieveCAPKList();
    	
    	if (rc == RETURN_CODE_SUCCESS)
    		copyObject(respData, jgetLastResDataStructObj());
    	
    	return rc;
    }
    
    // C functions - can be implemented in C++....
    public static native char[] getCharArray();
    public static native byte[] getByteArray();
    
    public static native String jSDKVersion();    
    public static native int jlastReturnCode();
    public static native ResDataStruct jgetLastResDataStructObj();
    public static native IDTMSRData jgetLastIDTMSRDataObj();
    public static native ICCReaderStatusStruct jgetLastICCReaderStatusStructObj();
    public static native Map<String, Map<String, byte[]>> jgetLastTransactionResult();
    public static native int jgetGeneralIntOne();
    public static native int jgetGeneralIntTwo();
    
    public static native void jenableLogging(int logLevel);
    
    public static native int jmsrstartMSRSwipe();
    public static native int jmsrstartMSRSwipe(int timeout);
    public static native int jmsrcancelMSRSwipe();
    public static native int jmsrsetExpirationMask(boolean mask);
    public static native int jmsrgetExpirationMask();
    public static native int jmsrsetClearPANID(byte value);
    public static native int jmsrgetClearPANID();
    public static native int jmsrsetSwipeForcedEncryptionOption(boolean track1, boolean track2, boolean track3, boolean track3card0);
    public static native int jmsrgetSwipeForcedEncryptionOption();
    public static native int jmsrsetSwipeMaskOption(boolean track1, boolean track2, boolean track3);
    public static native int jmsrgetSwipeMaskOption();
    public static native int jmsrsetSetting(byte setting, byte val);
    public static native int jmsrgetSetting(byte setting);
    public static native int jmsrsetSwipeEncryption(byte encryption);
    public static native int jmsrgetSwipeEncryption();
    public static native int jmsrdisable();
    public static native int jmsrRetrieveWhiteList();
    public static native int jmsrgetFunctionStatus();
    public static native int jmsrclearMSRData();
    public static native int jmsrgetMSRData();
    public static native int jmsrgetKeyTypeForICCDUKPT();
    public static native int jmsrgetKeyFormatForICCDUKPT();
    public static native int jmsrsetKeyFormatForICCDUKPT(byte encryption);
    public static native int jmsrsetKeyTypeForICCDUKPT(byte encryption);
    public static native int jmsrcaptureMode(int isBufferMode, int withNotification);
    
    public static native int jdeviceinit();
    public static native int jrs232deviceinit(int deviceType, int port_number, int brate);
    public static native boolean jdevicesetCurrentDevice(int deviceType);
    public static native int jdevicegetCurrentDeviceType();
    public static native void jdeviceclose();
    public static native int jdevicesetMerchantRecord(int index, boolean enabled, String merchantID, String merchantURL);
    public static native int jdevicegetMerchantRecord(int index);
    public static native int jdevicegetFirmwareVersion();
    public static native String jdevicegetGeneralString();
    public static native int jdevicesetBurstMode(byte mode);
    public static native int jdevicesetPollMode(byte mode);
    public static native String jdevicegetResponseCodeString(int returnCode);
    public static native int jdevicegetDRS();
    public static native int jdeviceverifyBackdoorKey();
    public static native int jdeviceselfTest();
    public static native int jdeviceisConnected();
    public static native int jdevicestartRKI();
    public static native int jdevicecontrolBeep(int index, int frequency, int duration);
    public static native int jdevicecontrolLED(byte indexLED, byte control, int intervalOn, int intervalOff);
    public static native int jdevicecontrolLEDICC(int controlMode, int interval);
    public static native int jdevicegetKeyStatus();
    public static native int jdevicesendDataCommand(byte[] cmd, boolean calcLRC, byte[] data);
    public static native int jdevicerebootDevice();
    public static native int jdevicepingDevice();
    public static native int jdevicecontrolUserInterface(byte[] values);
    public static native int jdevicegetTransactionResults();
    public static native int jdevicepollCardReader();
    public static native int jdevicegetSpectrumProKSN(int type);
    public static native int jdevicestartTransaction(double amount, double amtOther, int type, final int timeout, byte[] tags);
    public static native int jdevicecancelTransaction();
    public static native int jdevicecontrolIndicator(int indicator, int enable);
    public static native int jdevicecalibrateParameters(byte delta);
    public static native int jdevicegetDriveFreeSpace();
    public static native int jdevicelistDirectory(String directoryName, int recursive, int onSD);
    public static native int jdevicecreateDirectory(String directoryName);
    public static native int jdevicedeleteDirectory(String directoryName);
    public static native int jdevicetransferFile(String fileName, byte[] file);
    public static native int jdevicedeleteFile(String fileName);
    
    public static native int jconfiggetSerialNumber();
    public static native int jconfiggetModelNumber();
    public static native int jconfigsetBeeperController(boolean firmwareControlBeeper);
    public static native int jconfigsetLEDController(boolean firmwareControlMSRLED, boolean firmwareControlICCLED);
    public static native int jconfigsetEncryptionControl(boolean msr, boolean icc);
    public static native int jconfiggetEncryptionControl();
    
    public static native int jiccpassthroughOnICC();
    public static native int jiccpassthroughOffICC();
    public static native int jiccpowerOnICC();
    public static native int jiccpowerOffICC();
    public static native int jiccgetICCReaderStatus();
    public static native int jiccexchangeAPDU(byte[] dataAPDU);
    public static native int jiccsetKeyTypeForICCDUKPT(byte encryption);
    public static native int jiccgetKeyTypeForICCDUKPT();
    public static native int jiccsetKeyFormatForICCDUKPT(byte encryption);
    public static native int jiccgetKeyFormatForICCDUKPT();
    public static native int jiccenable(boolean withNotification);
    public static native int jiccdisable();
    public static native int jiccgetFunctionStatus();   
    
    public static native void jemvallowFallback(boolean allow);
    public static native void jemvsetAutoAuthenticateTransaction(boolean auto);
    public static native int jemvstartTransaction(double amount, double amtOther, int type, final int timeout, byte[] tags, boolean forceOnline);
    public static native int jemvauthenticateTransaction(byte[] tags);
    public static native int jemvcompleteTransaction(boolean commError, byte[] authCode, byte[] iad, byte[] tlvScripts, byte[] tags);
    public static native int jemvcancelTransaction();
    public static native int jemvretrieveApplicationData(byte[] aid);
    public static native int jemvremoveApplicationData(byte[] aid);
    public static native int jemvsetApplicationData(byte[] aid, byte[] TLV);
    public static native int jemvretrieveTerminalData();
    public static native int jemvremoveTerminalData();
    public static native int jemvsetTerminalData(byte[] TLV);
    public static native int jemvretrieveAidList();
    public static native int jemvretrieveCAPK(byte[] data);
    public static native int jemvremoveCAPK(byte[] capk);
    public static native int jemvsetCAPK(byte[] key);
    public static native int jemvretrieveCAPKList();
    public static native int jemvretrieveTerminalID();
    public static native int jemv_setTerminalID(String terminalID);
    public static native int jemvretrieveCRL();
    public static native int jemvremoveCRL(byte[] crlList);
    public static native int jemvsetCRL(byte[] crlList);
    public static native void jemvlcdControlResponse(byte mode, byte data);
    public static native int jemvgetEMVKernelVersion();
    public static native int jemvgetEMVKernelCheckValue();
    public static native int jemvgetEMVConfigurationCheckValue();
    public static native int jemvremoveAllApplicationData();
    public static native int jemvremoveAllCAPK();
    public static native int jemvremoveAllCRL();
    public static native int jemvretrieveTransactionResult(byte[] tags);
    public static native int jemvretrieveExceptionList();
    public static native int jemvsetException(byte[] exception);
    public static native int jemvremoveException(byte[] exception);
    public static native int jemvremoveAllExceptions();
    public static native int jemvretrieveExceptionLogStatus();
    public static native int jemvremoveTransactionLog();
    public static native int jemvretrieveTransactionLogStatus();
    public static native int jemvretrieveTransactionLog();
    
    public static native int jctlsstartTransaction(double amount, double amtOther, int type, final int timeout, byte[] tags);
    public static native int jctlsactivateTransaction(final int timeout, byte[] tags);
    public static native int jctlsgetAllConfigurationGroups(byte[] tlv);
    public static native int jctlsgetConfigurationGroup(int group, byte[] tlv);
    public static native int jctlsremoveConfigurationGroup(int group);
    
    public static native int jctlscancelTransaction();
    public static native int jctlsretrieveApplicationData(byte[] aid);
    public static native int jctlsremoveApplicationData(byte[] aid);
    public static native int jctlsremoveAllApplicationData();
    public static native int jctlssetApplicationData(byte[] TLV);
    public static native int jctlssetConfigurationGroup(byte[] TLV);
    public static native int jctlsretrieveTerminalData();
    public static native int jctlssetTerminalData(byte[] TLV);
    public static native int jctlsretrieveAidList();
    public static native int jctlsretrieveCAPK(byte[] data);
    public static native int jctlsremoveCAPK(byte[] capk);
    public static native int jctlsremoveAllCAPK();
    public static native int jctlssetCAPK(byte[] key);
    public static native int jctlsretrieveCAPKList();
    public static native int jctlsdisplayOnlineAuthResult(int isOK, byte[] TLVs);
    
    public static native int jpingetPIN(int mode, int PANSource, String iccPAN, int startTimeout, int entryTimeout, String language);
    public static native int jpincancelPINEntry();
    public static native int jpingetEncryptedOnlinePIN(int keyType, int timeout);
    public static native int jpingetPAN(int getCSC, int timeout);
    public static native int jpinpromptCreditDebit(String currencySymbol, String displayAmount, int timeout);
    
    public static native int jlcdresetInitialState();
    public static native int jlcdcustomDisplayMode(int enable);
    public static native int jlcdsetForeBackColor(byte[] foreRGB, byte[] backRGB);
    public static native int jlcdclearDisplay();
    public static native int jlcdcaptureSignature(int timeout);
    public static native int jlcdstartSlideShow(String files, int posX, int posY, int posMode, int touchEnable, int recursion, int touchTerminate, int delay, int loops, int clearScreen);
    public static native int jlcdsetDisplayImage(String file, int posX, int posY, int posMode, int touchEnable, int clearScreen); 
    public static native int jlcdsetBackgroundImage(String file, int enable);
}
