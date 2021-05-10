package IDTechSDK;

import IDTechSDK.ReaderInfo.DEVICE_TYPE;

public abstract class IDT_Device extends Device {
	public abstract void release();
	
	public abstract boolean device_setDeviceType(ReaderInfo.DEVICE_TYPE deviceType);
	
	public abstract DEVICE_TYPE device_getDeviceType();
	
	public abstract String config_getSDKVersion();
	
	public abstract String device_getResponseCodeString(int errorCode);
	
	public abstract int device_getDRS(ResDataStruct respData);
	
	public abstract int device_verifyBackdoorKey();
	
	public abstract int device_selfTest();
	
	public abstract int device_getKeyStatus(ResDataStruct respData);
	
	public abstract int device_getFirmwareVersion(StringBuilder version);
	
	public abstract int config_getModelNumber(StringBuilder modNumber);

	public abstract int config_getSerialNumber(StringBuilder serialNumber);
	
	public abstract int device_sendDataCommand(String cmd, boolean calcLRC, String data, ResDataStruct respData);
	
	public abstract boolean device_isConnected();
	
	public abstract int device_getTransactionResults(IDTMSRData cardData);
}
