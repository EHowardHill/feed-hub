package IDTechSDK;

public interface ICCInterface {
	int icc_passthroughOnICC();
	
	int icc_passthroughOffICC();
	
	int icc_powerOnICC(ResDataStruct atrPPS);
	
	int icc_powerOffICC();
	
	int icc_getICCReaderStatus(ICCReaderStatusStruct ICCStatus);
	
	int icc_exchangeAPDU(byte[] dataAPDU, ResDataStruct response);
}
