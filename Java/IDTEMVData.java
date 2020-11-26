package IDTechSDK;

import java.util.Map;





/**
 * This class provides all information for emv transaction data.<br/>
 * Application can get the card data by calling the Properties of class IDTEMVData when received by emv callbak. 
 */
public class IDTEMVData {
	
	public static final int APPROVED_OFFLINE = 0x0000;
	public static final int DECLINED_OFFLINE = 0x0001;
	public static final int APPROVED = 0x0002;
	public static final int DECLINED = 0x0003;
    public static final int GO_ONLINE = 0x0004;
    public static final int CALL_YOUR_BANK = 0x0005;
    public static final int NOT_ACCEPTED = 0x0006;
    public static final int USE_MAGSTRIPE = 0x0007;
    public static final int TIME_OUT = 0x0008;
    public static final int START_TRANS_SUCCESS = 0x0010;
    public static final int MSR_SUCCESS = 0x0011;
    public static final int FILE_ARG_INVALID = 0x1001;
    public static final int FILE_OPEN_FAILED = 0x1002;
    public static final int FILE_OPERATION_FAILED = 0X1003;
    public static final int MEMORY_NOT_ENOUGH = 0x2001;
    public static final int SMARTCARD_FAIL = 0x3001;
    public static final int SMARTCARD_INIT_FAILED = 0x3003;
    public static final int FALLBACK_SITUATION = 0x3004;
    public static final int SMARTCARD_ABSENT = 0x3005;
    public static final int SMARTCARD_TIMEOUT = 0x3006;
    public static final int MSR_CARD_ERROR = 0x3007;
    public static final int PARSING_TAGS_FAILED= 0X5001;
    public static final int CARD_DATA_ELEMENT_DUPLICATE = 0X5002;
    public static final int DATA_FORMAT_INCORRECT = 0X5003;
    public static final int APP_NO_TERM = 0X5004;
    public static final int APP_NO_MATCHING = 0X5005;
    public static final int AMANDATORY_OBJECT_MISSING = 0X5006;
    public static final int APP_SELECTION_RETRY = 0X5007;
    public static final int AMOUNT_ERROR_GET = 0X5008;
    public static final int CARD_REJECTED = 0X5009;
    public static final int AIP_NOT_RECEIVED = 0X5010;
    public static final int AFL_NOT_RECEIVEDE = 0X5011;
    public static final int AFL_LEN_OUT_OF_RANGE = 0X5012;
    public static final int SFI_OUT_OF_RANGE = 0X5013;
    public static final int AFL_INCORRECT = 0X5014;
    public static final int EXP_DATE_INCORRECT = 0X5015;
    public static final int EFF_DATE_INCORRECT = 0X5016;
    public static final int ISS_COD_TBL_OUT_OF_RANGE = 0X5017;
    public static final int CRYPTOGRAM_TYPE_INCORRECT = 0X5018;
    public static final int PSE_BY_CARD_NOT_SUPPORTED = 0X5019;
    public static final int USER_LANGUAGE_SELECTED = 0X5020;
    public static final int SERVICE_NOT_ALLOWED = 0X5021;
    public static final int NO_TAG_FOUND = 0X5022;
    public static final int CARD_BLOCKED = 0X5023;
    public static final int LEN_INCORRECT = 0X5024;
    public static final int CARD_COM_ERROR = 0X5025;
    public static final int TSC_NOT_INCREASED = 0X5026;
    public static final int HASH_INCORRECT = 0X5027;
    public static final int ARC_NOT_PRESENCED = 0X5028;
    public static final int ARC_INVALID = 0X5029;
    public static final int COMM_NO_ONLINE = 0X5030;
    public static final int TRAN_TYPE_INCORRECT = 0X5031;
    public static final int APP_NO_SUPPORT = 0X5032;
    public static final int APP_NOT_SELECT = 0X5033;
    public static final int LANG_NOT_SELECT = 0X5034;
    public static final int TERM_DATA_NOT_PRESENCED = 0X5035;
    public static final int CVM_TYPE_UNKNOWN = 0X6001;
    public static final int CVM_AIP_NOT_SUPPORTED = 0X6002;
    public static final int CVM_TAG_8E_MISSING = 0X6003;
    public static final int CVM_TAG_8E_FORMAT_ERROR = 0X6004;
    public static final int CVM_CODE_IS_NOT_SUPPORTED = 0X6005;
    public static final int CVM_COND_CODE_IS_NOT_SUPPORTED = 0X6006;
    public static final int CVM_NO_MORE = 0X6007;
    public static final int PIN_BYPASSED_BEFORE = 0X6008;
	
	
	
	public int result;   //!< Result Code =
    public int encryptionMode;  //!< 0 = TDES, 1 = AES
    public int cardType;  //!< 0 = Contact, 1 = Contactless
    public boolean emv_hasReversal = false;
    public boolean emv_hasAdvise = false;
    public Map<String,byte[]> unencryptedTags; //!< Unencrypted EMV Tags.  Key = tag name (String), Object = tag value (byte[])
    public Map<String,byte[]> encryptedTags; //!< Encrypted EMV Tags.  Key = tag name (String), Object = tag value (byte[])
    public Map<String,byte[]> maskedTags; //!< Masked EMV Tags.  Key = tag name (String), Object = tag value (byte[])
    public IDTMSRData msr_cardData;  //!< Tag DFEE23 parsed into a msr_cardData object
}
