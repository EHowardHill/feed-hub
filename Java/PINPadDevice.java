package IDTechSDK;

public interface PINPadDevice {
	int pin_getEncryptedOnlinePIN(int keyType, int timeout);
	
	int pin_getPAN(int getCSC, int timeout);
	
	int pin_promptCreditDebit(String currencySymbol, String displayAmount, int timeout);
}
