package IDTechSDK;

public interface Configurable {
	int device_setMerchantRecord(int index, boolean enabled, String merchantID, String merchantURL);
	
	int device_setBurstMode(byte mode);
	
	int device_setPollMode(byte mode);
}
