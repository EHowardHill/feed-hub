package IDTechSDK;

public class ErrorCode {
	
	//SDK Status code
	/**SDK Status code*/
	/**The code description can be retrieved from the API device_getResponseCodeString. */
	/**0x0000*/	public static final int SUCCESS							=0x0000;
	/**0x0001*/public static final int NOT_CONNECT						=0x0001;
	/**0x0002*/public static final int INVALID_REPONSE_DATA				=0x0002;
	/**0x0003*/public static final int TIMEOUT_TASK						=0x0003;
	/**0x0004*/public static final int WRONG_PARAMETER					=0x0004;
	/**0x0005*/public static final int MSR_MODEL						=0x0005;
	/**0x0006*/public static final int PIN_MODEL						=0x0006;
	/**0x0007*/public static final int EMVL2_MODEL						=0x0007;
	/**0x0008*/public static final int NOTIFYRESPONSE_MODEL				=0x0008;
	/**0x0009*/public static final int UNKNOW_ERROR						=0x0009;
	/**0x0009*/public static final int FAILED_NACK						=0x000A;
	/**0x0010*/public static final int AUTO_CONFIG_MODEL				=0x0010;
	/**0x0011*/public static final int NO_CONFIG						=0x0011;
	/**0x0012*/public static final int NO_READER						=0x0012;
	/**0x0013*/public static final int SDK_BUSY							=0x0013;
	/**0x0014*/public static final int NOT_SUPPORTED					=0x0014;
	/**0x0015*/public static final int NO_RESPONSE						=0x0015;
	/**0x0016*/public static final int VOLUME_NOT_IN_CONTROL			=0x0016;
	
	/**0x0017*/public static final int TIMEOUT_CONNECTION				=0x0017;
	/**0x0018*/public static final int TIMEOUT_SWIPE					=0x0018;
	/**0x0019*/public static final int TIMEOUT_AUTOCONFIG				=0x0019;
	/**0xF210*/public static final int TIMEOUT_ACTIVATE_TRANSACTION		=0x0020;
	
	/**0x0101*/public static final int TIMEOUT_RKI						=0x0101;
	/**0x0102*/public static final int RKI_INITIALIZATION_ERROR			=0x0102;
	/**0x0103*/public static final int RKI_AUTHENTICATION_ERROR			=0x0103;
	/**0x0104*/public static final int RKI_TR31_ERROR					=0x0104;
	/**0x0105*/public static final int RKI_NOT_ONLINE_ERROR				=0x0105;
	
	/**Reader Status code*/	
	/**0x0300*/public static final int KEY_TYPE_NOT_MATCH				=0x0300;	
	/**0x0400*/public static final int KEY_NOT_LOAD						=0x0400;
	/**0x0500*/public static final int SAME_KEY_ERROR					=0x0500;
	/**0x0501*/public static final int KEY_ALL_ZERO						=0x0501;
	/**0x0502*/public static final int TR31_FORMAT_ERROR				=0x0502;
	
	/**0x0702*/public static final int PAN_ERROR						=0x0702;
	/**0x0D00*/public static final int KEY_HAS_LOADED					=0x0D00;
	/**0x0E00*/public static final int TIME_HAS_LOADED					=0x0E00;
	/**0x0F00*/public static final int ENCRYPT_DECRYPT_FAILED			=0x0F00;
	
	/**0x1000*/public static final int LOW_BATTERY						=0x1000;
	/**0x1800*/public static final int ACTION_CANCELED					=0x1800;
	/**0x1900*/public static final int ACTION_ABORTED					=0x1900;
	/**0x2C02*/public static final int ICC_CARD_NOT_SEATED				=0x2C02;
	/**0x2C06*/public static final int NO_SMARTCARD_REQUEST				=0x2C06;
	/**0x2D01*/public static final int CARD_NOT_SUPPORTED				=0x2D01;
	/**0x2D03*/public static final int CARD_NOT_SUPPORTED_WANTS_CRC		=0x2D03;
	/**0x3000*/public static final int CHIP_IS_DEACTIVATION				=0x3000;
	/**0x30FF*/public static final int CHIP_NOT_CONNECT					=0x30FF;	
	/**0x3101*/public static final int CHIP_IS_ACTIVATION				=0x3101;
	/**0x5500*/public static final int NOT_ADMIN_KEY					=0x5500;
	/**0x5501*/public static final int ADMIN_KEY_STOP					=0x5501;
	/**0x5502*/public static final int ADMIN_KSN_ERROR					=0x5502;
	/**0x5503*/public static final int GET_AUTHENTICATION_CODE_FAIL		=0x5503;
	/**0x5504*/public static final int AUTHENTICATION_CODE_ERROR		=0x5504;
	/**0x5505*/public static final int ENCRYPTED_DECRYPTED_DATA_ERROR 	=0x5505;
	/**0x5506*/public static final int KEY_TYPE_NOT_SUPPORTED			=0x5506;
	/**0x5507*/public static final int KEY_INDEX_ERROR					=0x5507;
	/**0x5508*/public static final int STEP_ERROR						=0x5508;
	/**0x5509*/public static final int KSN_ERROR						=0x5509;

	/**0x550A*/public static final int MAC_ERROR						=0x550A;
	/**0x550B*/public static final int KEY_USAGE_ERROR					=0x550B;
	/**0x550C*/public static final int MODE_ERROR						=0x550C;
	/**0x550F*/public static final int OTHER_ERROR						=0x550F;
	/**0x6000*/public static final int LANGUAGE_CONFIG_FAIL				=0x6000;
	/**0x6200*/public static final int SERIAL_NUMBER_NOT_EXIST			=0x6200;
	/**0x6900*/public static final int INVALID_TASKID					=0x6900;
	/**0x690D*/public static final int WITHOUT_ICC_SUPPORTED			=0x690D;	
	/**0x6A00*/public static final int UNSUPPORTED_COMMAND				=0x6A00;
	/**0x6A01*/public static final int UNSUPPORTED_COMMAND_IN_STATE		=0x6A01;
	/**0x6B00*/public static final int INVALID_PARAMETER				=0x6B00;
	/**0x6C00*/public static final int INVALID_COMMAND_LENGTH			=0x6C00;
	/**0x7200*/public static final int DEVICE_SUSPEND					=0x7200;
	/**0x7300*/public static final int PIN_STOP							=0x7300;
	/**0x7400*/public static final int DEVICE_BUSY						=0x7400;
	/**0x8100*/public static final int TIMEOUT							=0x8100;
	/**0x8200*/public static final int INVALID_TS						=0x8200;
	/**0x8300*/public static final int NO_CARD_DATA						=0x8300;
	/**0x8400*/public static final int TRIMAGII_NO_RESPONSE				=0x8400;
	
	/**0x8500*/public static final int PPS_CONFIRMATION_ERROR			=0x8500;
	/**0x8600*/public static final int UNSUPPORTED_FD					=0x8600;
	/**0x8700*/public static final int PROTOCOL_NOT_SUPPORTED_EMV		=0x8700;
	/**0x8800*/public static final int POWER_NOT_POWERLEVEL				=0x8800;
	/**0x8900*/public static final int ATR_LENGTH_EXCEED				=0x8900;
	/**0x8B01*/public static final int EMV_INVALID_TA1					=0x8B01;
	/**0x8B02*/public static final int EMV_TB1_REQUIRED					=0x8B02;
	/**0x8B03*/public static final int EMV_UNSUPPORTED_TB1				=0x8B03;
	/**0x8B04*/public static final int EMV_CARD_ERROR					=0x8B04;
	/**0x8B06*/public static final int EMV_TB2_NOT_ALLOWED				=0x8B06;
	/**0x8B07*/public static final int EMV_TC2_EXCEED					=0x8B07;
	/**0x8B08*/public static final int EMV_TC2_OUT_RANGE				=0x8B08;
	/**0x8B09*/public static final int EMV96_TA3_ERROR					=0x8B09;
	/**0x8B10*/public static final int ICC_ERROR_ON_POWERUP				=0x8B10;
	/**0x8B11*/public static final int EMV_TB3_REQUIRED					=0x8B11;
	/**0x8B12*/public static final int INVALID_BWIORCWI					=0x8B12;
	/**0x8B13*/public static final int CARD_ERROR_INVALID_BWIORCWI		=0x8B13;
	/**0x8B17*/public static final int EMV_TCI_TB3_CONFLICT				=0x8B17;
	/**0x8B20*/public static final int EMV_TD2_OUT_RANGE				=0x8B20;
	/**0x8C00*/public static final int TCK_ERROR						=0x8C00;
	/**0xA304*/public static final int CONNECTOR_NO_VOLTAGE_SETTING		=0xA30C;
	/**0xA305*/public static final int INVALID_SBLK_IFSD_EXCHANGE		=0xA305;	
	/**0xD000*/public static final int DATA_NOT_EXIST					=0xD000;
	/**0xD001*/public static final int DATA_ACCESS_ERROR				=0xD001;
	/**0xD102*/public static final int INDEX_NOT_EXIST					=0xD102;
	/**0xD200*/public static final int MAXIMUM_EXCEEDED					=0xD200;
	/**0xD201*/public static final int HASH_ERROR						=0xD201;
	/**0xD204*/public static final int Other_ERROR						=0xD204;
	/**0xD205*/public static final int SYSTEM_BUSY						=0xD205;
	/**0xE100*/public static final int CANNOT_SLEEP_MODE				=0xE100;
	/**0xE200*/public static final int FILE_HAS_EXISTED					=0xE200;
	/**0xE300*/public static final int FILE_NOT_EXIST					=0xE300;
	/**0xE301*/public static final int ICC_ERROR_AFTER_SESSION_START	=0xE301;
	/**0xE313*/public static final int IO_LINE_LOW						=0xE313;
	/**0xE400*/public static final int OPEN_FILE_ERROR					=0xE400;
	/**0xE500*/public static final int SMARTCARD_ERROR					=0xE500;
	/**0xE600*/public static final int CARD_DATA_ERROR					=0xE600;	
	/**0xE700*/public static final int TIMEOUT_COMMAND					=0xE700;
	/**0xE800*/public static final int FILE_READ_WRITE_ERROR			=0xE800;
	/**0xE900*/public static final int ACTIVE_1850_ERROR				=0xE900;
	/**0xEA00*/public static final int BOOTLOADER_ERROR					=0xEA00;
	/**0xEB00*/public static final int PICTURE_NOT_EXIST				=0xEB00;
	/**0xEF00*/public static final int PROCOTOL_ERROR					=0xEF00;
	
	/**0xF002*/public static final int ICC_COMMUNICATION_TIMEOUT		=0xF002;
	/**0xF003*/public static final int ICC_COMMUNICATION_ERROR			=0xF003;
	/**0xF00F*/public static final int ICC_NEED_DISABLE_MSR				=0xF00F;
	/**0xF200*/public static final int AID_NOT_EXIST					=0xF200;
	/**0xF201*/public static final int TERMINATE_DATA_NOT_EXIST			=0xF201;
	/**0xF202*/public static final int TLV_FORMAT_ERROR					=0xF202;
	/**0xF203*/public static final int AID_LIST_OVERFLOW				=0xF203;
	/**0xF204*/public static final int CAKEY_NOT_EXIST					=0xF204;
	/**0xF205*/public static final int CAKEY_RID_NOT_EXIST				=0xF205;
	/**0xF206*/public static final int CAKEY_INDEX_NOT_EXIST			=0xF206;
	/**0xF207*/public static final int CAKEY_LIST_OVERFLOW				=0xF207;
	/**0xF208*/public static final int CAKEY_HASH_ERROR					=0xF208;
	/**0xF209*/public static final int TRANSACTION_FORMAT_ERROR			=0xF209;
	/**0xF20A*/public static final int COMMAND_NOT_PROCESS				=0xF20A;
	/**0xF20B*/public static final int CRL_NOT_EXIST					=0xF20B;
	/**0xF20C*/public static final int CRL_LIST_OVERFLOW					=0xF20C;
	/**0xF20D*/public static final int MISS_AMOUNT_OTHERAMOUNT_TRANXTYPE	=0xF20D;
	/**0xF20E*/public static final int ID_ALGORITHM_MISTAKE					=0xF20E;
	/**0xF20F*/public static final int NO_FINANCIAL_CARD					=0xF20F;
	/**0xF210*/public static final int TLV_BUFFER_OVERFLOW					=0xF210;
	
	//IDG Error Codes
	//IDG Return Codes
	public static final int RETURN_CODE_NEO_SUCCESS = 0xEE00;      //!<Command Successful
	public static final int RETURN_CODE_NEO_INCORRECT_HEADER_TAG = 0xEE01;      //!<Incorrect Header Tag
	public static final int RETURN_CODE_NEO_UNKNOWN_COMMAND = 0xEE02;      //!<Unknown Command
	public static final int RETURN_CODE_NEO_UNKNOWN_SUB_COMMAND = 0xEE03;      //!<Unknown Sub-Command
	public static final int RETURN_CODE_NEO_CRC_ERROR_IN_FRAME = 0xEE04;      //!<CRC Error in Frame
	public static final int RETURN_CODE_NEO_INCORRECT_PARAMETER = 0xEE05;      //!<Incorrect Parameter
	public static final int RETURN_CODE_NEO_PARAMETER_NOT_SUPPORTED = 0xEE06;      //!<Parameter Not Supported
	public static final int RETURN_CODE_NEO_MAL_FORMATTED_DATA = 0xEE07;      //!<Mal-formatted Data
	public static final int RETURN_CODE_NEO_TIMEOUT = 0xEE08;      //!<Timeout
	public static final int RETURN_CODE_NEO_FAILED_NAK = 0xEE0A;      //!<Failed / NACK
	public static final int RETURN_CODE_NEO_COMMAND_NOT_ALLOWED = 0xEE0B;      //!<Command not Allowed
	public static final int RETURN_CODE_NEO_SUB_COMMAND_NOT_ALLOWED = 0xEE0C;      //!<Sub-Command not Allowed
	public static final int RETURN_CODE_NEO_BUFFER_OVERFLOW = 0xEE0D;      //!<Buffer Overflow (Data Length too large for reader buffer)
	public static final int RETURN_CODE_NEO_USER_INTERFACE_EVENT = 0xEE0E;      //!<User Interface Event
	public static final int RETURN_CODE_NEO_COMM_TYPE_NOT_SUPPORTED = 0xEE11;      //!<Communication type not supported, VT-1, burst, etc.
	public static final int RETURN_CODE_NEO_SECURE_INTERFACE_NOT_FUNCTIONAL = 0xEE12;      //!<Secure interface is not functional or is in an intermediate state.
	public static final int RETURN_CODE_NEO_DATA_FIELD_NOT_MOD8 = 0xEE13;      //!<Data field is not mod 8
	public static final int RETURN_CODE_NEO_PADDING_UNEXPECTED = 0xEE14;      //!<Pad 0x80 not found where expected
	public static final int RETURN_CODE_NEO_INVALID_KEY_TYPE = 0xEE15;      //!<Specified key type is invalid
	public static final int RETURN_CODE_NEO_CANNOT_RETRIEVE_KEY = 0xEE16;      //!<Could not retrieve key from the SAM (InitSecureComm)
	public static final int RETURN_CODE_NEO_HASH_CODE_ERROR = 0xEE17;      //!<Hash code problem
	public static final int RETURN_CODE_NEO_CANNOT_STORE_KEY = 0xEE18;      //!<Could not store the key into the SAM (InstallKey)
	public static final int RETURN_CODE_NEO_FRAME_TOO_LARGE = 0xEE19;      //!<Frame is too large
	public static final int RETURN_CODE_NEO_RESEND_COMMAND = 0xEE1A;      //!<Unit powered up in authentication state but POS must resend the InitSecureComm command
	public static final int RETURN_CODE_NEO_EEPROM_NOT_INITALIZED = 0xEE1B;      //!<The EEPROM may not be initialized because SecCommInterface does not make sense
	public static final int RETURN_CODE_NEO_PROBLEM_ENCODING_APDU = 0xEE1C;      //!<Problem encoding APDU
	public static final int RETURN_CODE_NEO_UNSUPPORTED_INDEX = 0xEE20;      //!<Unsupported Index (ILM). SAM Transceiver error – problem communicating with the SAM (Key Mgr)
	public static final int RETURN_CODE_NEO_UNEXPECTED_SEQUENCE_COUNTER = 0xEE21;      //!<Unexpected Sequence Counter in multiple frames for single bitmap (ILM). Length error in data returned from the SAM (Key Mgr)
	public static final int RETURN_CODE_NEO_IMPROPER_BITMAP = 0xEE22;      //!<Improper bit map (ILM)
	public static final int RETURN_CODE_NEO_REQUEST_ONLINE_AUTHORIZATION = 0xEE23;      //!<Request Online Authorization
	public static final int RETURN_CODE_NEO_RAW_DATA_READ_SUCCESSFUL = 0xEE24;      //!<ViVOCard3 raw data read successful
	public static final int RETURN_CODE_NEO_MESSAGE_NOT_AVAILABLE = 0xEE25;      //!<Message index not available (ILM). ViVOcomm activate transaction card type (ViVOcomm)
	public static final int RETURN_CODE_NEO_VERSION_INFORMATION_MISMATCH = 0xEE26;      //!<Version Information Mismatch (ILM)
	public static final int RETURN_CODE_NEO_NOT_SENDING_COMMANDS = 0xEE27;      //!<Not sending commands in correct index message index (ILM)
	public static final int RETURN_CODE_NEO_TIMEOUT_ILM = 0xEE28;      //!<Time out or next expected message not received (ILM)
	public static final int RETURN_CODE_NEO_ILM_NOT_AVAILABLE = 0xEE29;      //!<ILM languages not available for viewing (ILM)
	public static final int RETURN_CODE_NEO_OTHER_LANG_NOT_SUPPORTED = 0xEE2A;      //!<Other language not supported (ILM)
	public static final int RETURN_CODE_NEO_KEY_ERROR_41 = 0xEE41;      //!<Module-specific errors for Key Manager
	public static final int RETURN_CODE_NEO_KEY_ERROR_42 = 0xEE42;      //!<Module-specific errors for Key Manager
	public static final int RETURN_CODE_NEO_KEY_ERROR_43 = 0xEE43;      //!<Module-specific errors for Key Manager
	public static final int RETURN_CODE_NEO_KEY_ERROR_44 = 0xEE44;      //!<Module-specific errors for Key Manager
	public static final int RETURN_CODE_NEO_KEY_ERROR_45 = 0xEE45;      //!<Module-specific errors for Key Manager
	public static final int RETURN_CODE_NEO_KEY_ERROR_46 = 0xEE46;      //!<Module-specific errors for Key Manager
	public static final int RETURN_CODE_NEO_KEY_ERROR_47 = 0xEE47;      //!<Module-specific errors for Key Manager
	public static final int RETURN_CODE_NEO_KEY_ERROR_48 = 0xEE48;      //!<Module-specific errors for Key Manager
	public static final int RETURN_CODE_NEO_KEY_ERROR_49 = 0xEE49;      //!<Module-specific errors for Key Manager
	public static final int RETURN_CODE_NEO_KEY_ERROR_4A = 0xEE4A;      //!<Module-specific errors for Key Manager
	public static final int RETURN_CODE_NEO_KEY_ERROR_4B = 0xEE4B;      //!<Module-specific errors for Key Manager
	public static final int RETURN_CODE_NEO_KEY_ERROR_4C = 0xEE4C;      //!<Module-specific errors for Key Manager
	public static final int RETURN_CODE_NEO_KEY_ERROR_4D = 0xEE4D;      //!<Module-specific errors for Key Manager
	public static final int RETURN_CODE_NEO_KEY_ERROR_4E = 0xEE4E;      //!<Module-specific errors for Key Manager
	public static final int RETURN_CODE_NEO_KEY_ERROR_4F = 0xEE4F;      //!<Module-specific errors for Key Manager
	public static final int RETURN_CODE_NEO_AUTO_SWITCH_OK = 0xEE50;      //!Auto-Switch OK
	public static final int RETURN_CODE_NEO_AUTO_SWITCH_FAILED = 0xEE51;      //!Auto-Switch failed
	public static final int RETURN_CODE_DATA_DOES_NOT_EXIST = 0xEE60;      //!Data not exist
	public static final int RETURN_CODE_DATA_FULL = 0xEE61;      //!Data Full
	public static final int RETURN_CODE_WRITE_FLASH_ERROR = 0xEE62;      //!Write Flash Error
	public static final int RETURN_CODE_OK_NEXT_COMMAND = 0xEE63;      //!Ok and Have Next Command
	public static final int RETURN_CODE_ACCT_DUKPT_KEY_NOT_EXIST = 0xEE90;      //!Account DUKPT Key not exist
	public static final int RETURN_CODE_ACCT_DUKPT_KEY_EXHAUSTED = 0xEE91;      //!Account DUKPT Key KSN exhausted
}