package IDTechSDK;

/**
 * The class for ICC Reader Status. 
 */	
public class ICCReaderStatusStruct {
	
	public byte[] resData;
	/**
	 * Determines if ICC has been powered up. 
	 */	
	public boolean iccPower;
	/**
	 * Determines if card is inserted. 
	 */	
	public boolean cardSeated;

	/**
	 * Determines if Card Latch is engaged.If device does not have a latch,value is always FALSE. 
	 */	
//	public boolean latchClosed;
	/**
	 * If device has a latch, determines if the card is present in device.If the device does not have a latch,value is always FALSE.
	 */	
//	public boolean cardPresent;
	/**
	 * True = Magnetic data present,False = No Magnetic Data. 
	 */	
//	public boolean magneticDataPresent;
}
