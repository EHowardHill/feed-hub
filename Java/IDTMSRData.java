package IDTechSDK;

import java.util.Map;

import IDTechSDK.ReaderInfo.CAPTURE_ENCODE_TYPE;
import IDTechSDK.ReaderInfo.CAPTURE_ENCRYPT_TYPE;
import IDTechSDK.ReaderInfo.CTLS_APPLICATION;
import IDTechSDK.ReaderInfo.EVENT_MSR_Types;



/**
 * This class provides all information of card data.<br/>
 * Application can get the card data by calling the Properties of class IDTMSRData when finish swiping. 
 */
public class IDTMSRData {

	
	/**
	 * MSR type,please see EVENT_MSR_Types for more information.<br/>	
	 */
	public EVENT_MSR_Types event;
	
	public byte cardDataFlag;
	
	/**
     * Track data was captured via CTLS interface
     */
    public boolean isCTLS;
	
	
	 /**
	 * Get the swiped card data.<br/>		 
	 * Containing complete unparsed swipe data as received from MSR.<br/>
	 * NOTE: <br/>
	 * Just refer to this item cardData if the card data is the clear data.<br/>
	 * 
	 */
	public byte[] cardData;
	
	public byte t1DecodeStatus;
	
	public byte t2DecodeStatus;
	
	public byte t3DecodeStatus;
	
	 /**
	 * Get the swiped card Track1 encrypted data.<br/>		 
	 * A byte array containing Track1 encrypted data.
	 */
	public byte[] encTrack1;
	
	 /**
	 * Get the swiped card Track2 encrypted data.<br/>		 
	 * A byte array containing Track2 encrypted data.
	 */
	public byte[] encTrack2;
	
	 /**
	 * Get the swiped card Track3 encrypted data.<br/>		 
	 * A byte array containing Track3 encrypted data.
	 */
	public byte[] encTrack3;
	
	/**	
	 * Get the swiped card Track1 data.<br/>
	 * A string containing Track1 masked data expressed as hex characters.
	 */
	public String track1;
	
	/**	
	 * Get the swiped card Track2 data.<br/>
	 * A string containing Track2 masked data expressed as hex characters.
	 */
	public String track2;
	
	/**	
	 * Get the swiped card Track3 data.<br/>
	 * A string containing Track3 masked data expressed as hex characters.
	 */
	public String track3;
	
	/**	
	 * Get the Reader Serial Number.<br/>	
	 */
	public byte[] serialNumber;
	/**
	 * Get the swiped card KSN (Key Serial Number).<br/>	 
	 * A byte array containing 10 bytes.
	 */
	public byte[] KSN;
	
	/**
	 * Get the swiped card length of Track1 data.
	 */
	public int track1Length;
	
	/**
	 * Get the swiped card length of Track2 data.	
	 */
	public int track2Length;
	
	/**
	 * Get the swiped card length of Track3 data.
	 */
	public int track3Length;
	
	/**
	 * Determines if ICC is present in card (service code starts with "2" or "6".
	 */
	public boolean iccPresent;
	/**
	 * Get the swiped card type,please see CAPTURE_ENCODE_TYPE for more information.<br/>	
	 * MSR card type:<br/>
	 *				CAPTURE_ENCODE_TYPE_ISOABA:ISO/ABA format<br/>
	 *				CAPTURE_ENCODE_TYPE_AAMVA:AAMVA format<br/>
	 *				CAPTURE_ENCODE_TYPE_Other:Other<br/>
	 *				CAPTURE_ENCODE_TYPE_Raw:Raw; undecoded format<br/>	
	 *				CAPTURE_ENCODE_TYPE_JisI_II:JIS I or JIS II  
     *
	 */
	public CAPTURE_ENCODE_TYPE cardType;
	
	/**
     * CTLS Application
     */
    public CTLS_APPLICATION ctlsApplication;
	
	/**
	 * Get optional bytes of the swiped card data.
	 */
	public byte[] optionalBytes;
	
	/**
	 * Get the swiped card decoded status.<br/>	 
	 *          0x00:decoded data success;<br/>
	 *			Bit0:1-track1 data error;<br/>
	 *			Bit1:1-track2 data error;<br/>
	 *			Bit2:1-track3 data error;<br/>
	 *			Bit3:1-track1 encrypted data error;<br/>
	 *			Bit4:1-track2 encrypted data error;<br/>
	 *			Bit5:1-track3 encrypted data error;<br/>
	 *			Bit6:1-KSN error;<br/>
     *
	 */
	public byte captureEncodeStatus;
	
	
	/**
	 * Get the swiped card encrypted type,please see CAPTURE_ENCRYPT_TYPE for more information.<br/>	
	 *          CAPTURE_ENCRYPT_TYPE_TDES:TDES;<br/>
	 *			CAPTURE_ENCRYPT_TYPE_AES:AES;	
     *
	 */
	public CAPTURE_ENCRYPT_TYPE captureEncryptType;
	
	/**
	 * The flag to indicate the availability of the swiped card DE055 data.
	 */
	public byte hasDE055;
	
	/**
	 * Get the swiped card length of DE055 data.
	 */
	public int DE055Len;
	
	/**
	 * Get the swiped card of DE055 data.
	 */
	public byte[] DE055Data;
	
	/**
	 * Get the swiped card length of TLV data.
	 */
	public int TLVLen;
	
	/**
	 * Get the swiped card TLV data.
	 */
	public byte[] TLVData;
	
	/**
	 * Get the DFEE23 MSR raw data.
	 */
	public byte[] rawTrackData;
	/**
	 * Unencrypted card data provided via TLV.
	 */
	public Map<String, byte[]> unencryptedTags;
	
	/**
	 * Encrypted card data provided via TLV.
	 */
	public Map<String, byte[]> encryptedTags;
	
	/**
	 * Masked card data provided via TLV.
	 */
	public Map<String, byte[]> maskedTags;
	
	/**
	 * Return error code.
	 */
	public int result = ErrorCode.SUCCESS;
}
