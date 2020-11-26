package IDTechSDK;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class ReaderInfo {

	/**
	 * Device interface type.	 	 
	 */
	public enum DEVICE_TYPE
	{ 
			
		  IDT_DEVICE_UNKNOWN(0),
				  IDT_DEVICE_AUGUSTA_HID(1),
				  IDT_DEVICE_AUGUSTA_KB(2),
				  IDT_DEVICE_AUGUSTA_S_HID(3),
				  IDT_DEVICE_AUGUSTA_S_KB(4),
				  IDT_DEVICE_AUGUSTA_S_TTK_HID(5),
				  IDT_DEVICE_SPECTRUM_PRO(6),
				  IDT_DEVICE_MINISMART_II(7),
				  IDT_DEVICE_L100(8),
				  IDT_DEVICE_UNIPAY(9),
				  IDT_DEVICE_UNIPAY_I_V(10),
				  IDT_DEVICE_VP3300_AJ(11),
				  IDT_DEVICE_KIOSK_III(12),
				  IDT_DEVICE_KIOSK_III_S(13),
				  IDT_DEVICE_PIP_READER(14),
				  IDT_DEVICE_VENDI(15),
				  IDT_DEVICE_VP3300_USB(16),
				  IDT_DEVICE_UNIPAY_I_V_TTK(17),
				  IDT_DEVICE_VP3300_BT(18),
				  IDT_DEVICE_VP8800(19),
				  IDT_DEVICE_SREDKEY2_HID(20),
				  IDT_DEVICE_SREDKEY2_KB(21),
				  IDT_DEVICE_NEO2(22),
				  IDT_DEVICE_MINISMART_II_COM(27),
				  IDT_DEVICE_SPECTRUM_PRO_COM(28),
				  IDT_DEVICE_KIOSK_III_COM(29),
				  IDT_DEVICE_KIOSK_III_S_COM(30),
				  IDT_DEVICE_VP3300_COM(31),
				  IDT_DEVICE_NEO2_COM(32),
				  IDT_DEVICE_NEO2_TCPIP(37),
				  IDT_DEVICE_MAX_DEVICES(42);
	
		
        
        private int numVal;

        DEVICE_TYPE(int numVal) {
            this.numVal = numVal;
        }

        public int getNumVal() {
            return numVal;
        }
	
	
        // Lookup table
        private static final Map<Integer, DEVICE_TYPE> lookup = new HashMap<Integer, DEVICE_TYPE>();
       
        // Populate the lookup table on loading time
        static {
          for (DEVICE_TYPE s : EnumSet.allOf(DEVICE_TYPE.class))
            lookup.put(s.getNumVal(), s);
        }
       
        // This method can be used for reverse lookup purpose
        public static DEVICE_TYPE get(int numVal) {
          return (DEVICE_TYPE) lookup.get(numVal);
        }
        
	}
	/**
	 * Define MSR type.	 	 
	 */
	public enum EVENT_MSR_Types
	{ 
		EVENT_MSR_UNKNOWN, EVENT_MSR_CARD_DATA, EVENT_MSR_CANCEL_KEY, EVENT_MSR_BACKSPACE_KEY, EVENT_MSR_ENTER_KEY, EVENT_MSR_DATA_ERROR
	}
	/**
	 * Define Card type.	 	 
	 */
	public enum CAPTURE_ENCODE_TYPE
	{
		CAPTURE_ENCODE_TYPE_UNKNOWN,
		CAPTURE_ENCODE_TYPE_ISOABA, 
		CAPTURE_ENCODE_TYPE_AAMVA, 
		CAPTURE_ENCODE_TYPE_Other,
		CAPTURE_ENCODE_TYPE_Raw,
		CAPTURE_ENCODE_TYPE_Jis_II,
		CAPTURE_ENCODE_TYPE_Jis_I, 
		CAPTURE_ENCODE_TYPE_Jis_II_Security, 
		CAPTURE_ENCODE_TYPE_Contactless_Visa_Kernel1, 
		CAPTURE_ENCODE_TYPE_Contactless_MasterCard,
		CAPTURE_ENCODE_TYPE_Contactless_Visa_Kernel3, 
		CAPTURE_ENCODE_TYPE_Contactless_AmericanExpress, 
		CAPTURE_ENCODE_TYPE_Contactless_JCB,
		CAPTURE_ENCODE_TYPE_Contactless_Discover, 
		CAPTURE_ENCODE_TYPE_Contactless_UnionPay, 
		CAPTURE_ENCODE_TYPE_Contactless_Others,
		CAPTURE_ENCODE_TYPE_Manual_Entry_Enhanced_Mode, 
		CAPTURE_ENCODE_TYPE_JisI_II
	}
	
	/**
    * Define CTLS_APPLICATION.	 	 
    */
    public enum CTLS_APPLICATION
    {
        CTLS_APPLICATION_NONE(0),
        CTLS_APPLICATION_MASTERCARD(1),
        CTLS_APPLICATION_VISA(2),
        CTLS_APPLICATION_AMEX(3),
        CTLS_APPLICATION_DISCOVER(4),
        CTLS_APPLICATION_SPEEDPASS(5),
        CTLS_APPLICATION_GIFT_CARD(6),
        CTLS_APPLICATION_DINERS_CLUB(7),
        CTLS_APPLICATION_EN_ROUTE(8),
        CTLS_APPLICATION_JCB(9),
        CTLS_APPLICATION_VIVO_DIAGNOSTIC(10),
        CTLS_APPLICATION_HID(11),
        CTLS_APPLICATION_MSR_SWIPE(12),
        CTLS_APPLICATION_RESERVED(13),
        CTLS_APPLICATION_DES_FIRE_TRACK_DATA(14),
        CTLS_APPLICATION_DES_FIRE_RAW_DATA(15),
        CTLS_APPLICATION_RBS(17),
        CTLS_APPLICATION_VIVO_COMM(20);
        
        private int numVal;

        CTLS_APPLICATION(int numVal) {
            this.numVal = numVal;
        }

        public int getNumVal() {
            return numVal;
        }

    }
    /**
	 * Define encrypted type.	 	 
	 */
    public enum CAPTURE_ENCRYPT_TYPE
    {
        CAPTURE_ENCRYPT_TYPE_UNKNOWN, CAPTURE_ENCRYPT_TYPE_TDES, CAPTURE_ENCRYPT_TYPE_AES, CAPTURE_ENCRYPT_TYPE_NONE, CAPTURE_ENCRYPT_TRANS_ARMOUR
    }
    
	public enum DEVICE_INTERFACE_Types
	{ 
		DEVICE_UNKNOWN,DEVICE_AUDIO_JACK,DEVICE_USB
	}
	public static  DEVICE_INTERFACE_Types detectedDeviceInterface  = DEVICE_INTERFACE_Types.DEVICE_UNKNOWN;
	public static DEVICE_INTERFACE_Types connectedInterface  = DEVICE_INTERFACE_Types.DEVICE_UNKNOWN;
	

    //---------------------------------------------------------------------------------------------
    // Read other info
    //---------------------------------------------------------------------------------------------
	/**
	 * Define the reader type.	 	 
	 */
//    public enum ReaderType { UNKNOWN, UM_OR_PRO, UM, UM_PRO, UM_II, SHUTTLE, UNIPAY}//, UNIPAYII }

	/**
	 * Define the phone support status.	 	 
	 */
    public enum SupportStatus { UNSUPPORTED, SUPPORTED, MAYBE_SUPPORTED }

}
