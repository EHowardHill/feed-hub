package IDTechSDK;

public interface ThreeInterfaceDevice {
	int device_startTransaction(double amount, double amtOther, int type, final int timeout, byte[] tags);
	
	int device_cancelTransaction();
}
