package IDTechSDK;

public  class ErrorCodeInfo {

    public static String getErrorCodeDescription(int errorCode)
    {
 		errorCode =  (int)(errorCode &0x0000ffff);
 		switch(errorCode)
    	{
 		case    0x0000:	return "0x0000: Succeeded, beginning task .";
    	case	0x0001:	return "0x0001: Not connected with reader.";
    	case	0x0002:	return "0x0002: Invalid response data."; 
    	case	0x0003:	return "0x0003:	Time out for task or CMD."; 
    	case	0x0004:	return "0x0004:	Wrong parameter."; 
    	case	0x0005:	return "0x0005:	SDK is doing MSR task ."; 
    	case	0x0006:	return "0x0006:	SDK is doing PINPad task."; 
    	
    	case	0x0007:	return "0x0007:	SDK is doing EMV Level2 task."; 
    	case	0x0008:	return "0x0008:	SDK is doing Notify Response task."; 
    	case	0x0009:	return "0x0009:	Unknown error.";
    	case	0x000A:	return "0x000A:	Declined/Terminated.";//Failed/NACK."; 
    	
    	case	0x0010:	return "0x0010:	SDK is doing Auto Config task."; 
    	case	0x0011:	return "0x0011:	No Configuration XML file loaded."; 
    	case	0x0012:	return "0x0012:	The reader not attached."; 
    	case	0x0013:	return "0x0013:	SDK is busy."; 
    	case	0x0014:	return "0x0014:	The API is not supported."; 
    	case	0x0015:	return "0x0015:	No Response from the reader."; 
    	case	0x0016: return "0x0016: Volume not in control";

    	case	0x0017: return "0x0017: Timeout: Connection";
    	case	0x0018: return "0x0018: Timeout: MSR Swipe";
    	case	0x0019: return "0x0019: Timeout: AutoConfig";

    	case	0x0101: return "0x0101: Timeout: Remote Key Injection";
    	case	0x0102: return "0x0102: Failed to initialize Remote Key Injection";
    	case	0x0103: return "0x0103: Failed to authenticate Remote Key Injection";
    	case	0x0104: return "0x0104: RKI TR31 Key block error";
    	case	0x0105: return "0x0105: Not online; failed to connect to server.";
    	
    	case	0x0300:	return "0x0300:	Key Type(TDES) of Session Key is not same as the related Master Key."; 
    	case	0x0400:	return "0x0400:	Related Key was not loaded."; 
    	case	0x0500:	return "0x0500:	Key is the same."; 
    	case	0x0501:	return "0x0501:	Key is all zero."; 
    	case	0x0502:	return "0x0502:	TR-31 format error."; 
    	case	0x0702:	return "0x0702:	PAN is Error Key."; 
    	case	0x0D00:	return "0x0D00:	This Key had been loaded."; 
    	case	0x0E00:	return "0x0E00:	Base Time was loaded.."; 
    	case	0x0F00:	return "0x0F00:	Encryption Or Decryption Failed";
    	case	0x1000:	return "0x1000:	Battery Low Warning (It is High Priority Response while Battery is Low.)";
    	case	0x1800:	return "0x1800:	Cancel enter from Keyboard by sending command."; 
    	case	0x1900:	return "0x1900:	Cancel enter from Keyboard by pressing Cancel button in Keyboard."; 
    	case	0x2C06:	return "0x2C06:	No card seated to request ATR."; 
    	case	0x2D01:	return "0x2D01:	Card Not Supported."; 
    	case	0x2D03:	return "0x2D03:	Card Not Supported, wants CRC."; 
    	case	0x3000:	return "0x3000:	Security Chip is deactivation & Device is In Removal Legally State."; 
    	case	0x30ff:	return "0x30ff:	Security Chip is not connect."; 
    	case	0x3101:	return "0x3101:	Security Chip is activation & Device is In Removal Legally State."; 
    	case	0x5500:	return "0x5500:	No Admin DUKPT Key. "; 
    	case	0x5501:	return "0x5501:	Admin DUKPT Key STOP."; 
    	case	0x5502:	return "0x5502:	Admin DUKPT Key KSN is Error."; 
    	case	0x5503:	return "0x5503:	Get Authentication Code1 Failed."; 
    	case	0x5504:	return "0x5504:	Validate Authentication Code Error."; 
    	case	0x5505:	return "0x5505:	Encrypt or Decrypt data failed."; 
    	case	0x5506:	return "0x5506:	Not Support the New Key Type."; 
    	case	0x5507:	return "0x5507:	New Key Index is Error."; 
    	case	0x5508:	return "0x5508:	Step is error."; 
    	case	0x5509:	return "0x5509:	KSN is error."; 
    	case	0x550A:	return "0x550A:	MAC Error."; 
    	case	0x550B:	return "0x550B:	Key Usage Error."; 
    	case	0x550C:	return "0x550C:	Mode Of Use Error."; 
    	case	0x550F:	return "0x550F:	Other Error."; 
    	case	0x6000:	return "0x6000:	Save or Config Failed / Or Read Config Error."; 
    	case	0x6200:	return "0x6200:	No Serial Number."; 
    	case	0x6900:	return "0x6900:	Invalid Command - Protocol is right, but task ID is invalid."; 
    	case	0x690D:	return "0x690D:	Without ICC Supported."; 
    	case	0x6A00:	return "0x6A00:	Unsupported Command - Protocol and task ID are right, but command is invalid."; 
    	case	0x6A01:	return "0x6A01:	Unsupported Command - Protocol and task ID are right, but command is invalid– In this State."; 
    	case	0x6B00:	return "0x6B00:	Unknown parameter in command - Protocol task ID and command are right, but parameter is invalid."; 
    	case	0x6C00:	return "0x6C00:	Unknown length in command – Protocol task ID and command are right, but length is out of the requirement."; 
    	case	0x7200:	return "0x7200:	Device is suspend (MKSK suspend or press password suspend)."; 
    	case	0x7300:	return "0x7300:	PIN DUKPT is STOP (21 bit 1)."; 
    	case	0x7400:	return "0x7400:	Device is Busy."; 
    	case	0x8100:	return "0x8100:	Time Out."; 
    	case	0x8200:	return "0x8200:	Invalid TS character received."; 
    	case	0x8300:	return "0x8300:	No Card Data."; 
    	case	0x8400:	return "0x8400:	TriMagII no Response."; 

    	case	0x8500:	return "0x8500:	Pps confirmation error."; 
    	case	0x8600:	return "0x8600:	Unsupported F, D, or combination of F and D."; 
    	case	0x8700:	return "0x8700:	Protocol not supported EMV TD1 out of range."; 
    	case	0x8800:	return "0x8800:	Power not at proper level."; 
    	case	0x8900:	return "0x8900:	ATR length too long."; 
    	case	0x8B01:	return "0x8B01:	EMV invalid TA1 byte value."; 
    	case	0x8B02:	return "0x8B02:	EMV TB1 required.";
    	case	0x8B03:	return "0x8B03:	EMV Unsupported TB1 only 00 allowed.";
    	case	0x8B04:	return "0x8B04:	EMV Card Error, invalid BWI or CWI.";
    	case	0x8B06:	return "0x8B06:	EMV TB2 not allowed in ATR.";
    	case	0x8B07:	return "0x8B07:	EMV TC2 out of range.";
    	case	0x8B08:	return "0x8B08:	EMV TC2 out of range.";
    	case	0x8B09:	return "0x8B09:	Per EMV96 TA3 must be > 0xF.";
    	case	0x8B10:	return "0x8B10:	ICC error on power-up.";
    	case	0x8B11:	return "0x8B11:	EMV T=1 then TB3 required.";
    	case	0x8B12:	return "0x8B12:	Card Error, invalid BWI or CWI.";
    	case	0x8B13:	return "0x8B13:	Card Error, invalid BWI or CWI.";
    	case	0x8B17:	return "0x8B17:	EMV TC1/TB3 conflict*.";
    	case	0x8B20:	return "0x8B20:	EMV TD2 out of range must be T=1.";	    	
    	case	0x8C00:	return "0x8C00:	TCK error.";
    	case	0xA304:	return "0xA304:	Connector has no voltage setting .";
    	case	0xA305:	return "0xA305:	ICC error on power-up invalid (SBLK(IFSD) exchange.";
    	case	0xD000:	return "0xD000:	Data is not exist.";
    	case	0xD001:	return "0xD001:	Data access error.";
    	case	0xD102:	return "0xD102:	Index is not exist.";
    	case	0xD200:	return "0xD200:	Exceeded Maximum.";
    	case	0xD201:	return "0xD201:	Hash error.";
    	case	0xD204:	return "0xD204:	Other error.";
    	case	0xD205:	return "0xD205:	System is busy.";
    	case	0xE100:	return "0xE100:	Can not enter sleep mode.";
    	case	0xE200:	return "0xE200:	File has existed.";
    	case	0xE300:	return "0xE300:	File has not existed.";
    	case	0xE301:	return "0xE301:	ICC error after session start.";
    	case	0xE400:	return "0xE400:	Open File Error.";
    	case	0xE500:	return "0xE500:	Smart Card Error.";
    	case	0xE600:	return "0xE600:	Get MSR Card data is error.";
    	case	0xE700:	return "0xE700:	Command time out.";
    	case	0xE800:	return "0xE800:	File read or write is error.";
    	case	0xE900:	return "0xE900:	Active 1850 error.";
    	case	0xE901:	return "0xE901:	TLV format error.";
    	case	0xEA00:	return "0xEA00:	Load bootloader error.";
    	case	0xEB00:	return "0xEB00:	Picture is not exist.";
    	case	0xEF00:	return "0xEF00:	Protocol Error- STX or ETX or check error.";
    	
    	case	0xF002:	return "0xF002:	ICC communication timeout.";
    	case	0xF003:	return "0xF003:	ICC communication Error.";
    	case	0xF00F:	return "0xF00F:	ICC Card Seated and Highest Priority, disable MSR work request.";
    		
    	case	0xF200:	return "0xF200:	AID List / Application Data is not exist.";
    	case	0xF201:	return "0xF201:	Terminal Data is not exist.";
    	case	0xF202:	return "0xF202:	TLV format is error.";
    	case	0xF203:	return "0xF203:	AID List is full.";
    	case	0xF204:	return "0xF204:	Any CA Key is not exist.";
    	case	0xF205:	return "0xF205:	CA Key RID is not exist.";
    	case	0xF206:	return "0xF206:	CA Key Index it not exist.";
    	case	0xF207:	return "0xF207:	CA Key is full.";
    	case	0xF208:	return "0xF208:	CA Key Hash Value is Error.";
    	case	0xF209:	return "0xF209:	Transaction  format error.";
    	case	0xF20A:	return "0xF20A:	The command will not be processing.";
    	case	0xF20B:	return "0xF20B:	CRL is not exist.";
    	case	0xF20C:	return "0xF20C:	CRL number  exceed max number.";
    	case	0xF20D:	return "0xF20D:	Amount,Other Amount,Trasaction Type  are  missing.";
    	case	0xF20E:	return "0xF20E:	The Identification of algorithm is mistake.";
    	case	0xF20F:	return "0xF20F:	No Financial Card.";
    	case	0xF210:	return "0xF210:	In Encrypt Result state, TLV total Length is greater than Max Length.";
    	
    	//IDG Error Code
    	case	0xEE00: return "0x00: Command Successful.";      //!<Command Successful
    	case	0xEE01: return "0x01: Incorrect Header Tag.";      //!<Incorrect Header Tag
    	case	0xEE02: return "0x02: Unknown Command.";	      //!<Unknown Command
    	case	0xEE03: return "0x03: Unknown Sub-Command.";      //!<Unknown Sub-Command
    	case	0xEE04: return "0x04: CRC Error in Frame.";      //!<CRC Error in Frame
    	case	0xEE05: return "0x05: Incorrect Parameter.";      //!<Incorrect Parameter
    	case	0xEE06: return "0x06: Parameter Not Supported.";      //!<Parameter Not Supported
    	case	0xEE07: return "0x07: Mal-formatted Data.";      //!<Mal-formatted Data
    	case	0xEE08: return "0x08: Timeout.";      //!<Timeout
    	case	0xEE0A: return "0x0A: Failed / NACK.";      //!<Failed / NACK
    	case	0xEE0B: return "0x0B: Command not Allowed.";      //!<Command not Allowed
    	case	0xEE0C: return "0x0C: Sub-Command not Allowed.";      //!<Sub-Command not Allowed
    	case	0xEE0D: return "0x0D: Buffer Overflow (Data Length too large for reader buffer).";      //!<Buffer Overflow (Data Length too large for reader buffer)
    	case	0xEE0E: return "0x0E: User Interface Event.";      //!<User Interface Event
    	case	0xEE10: return "0x10: Need clear firmware(apply in boot loader only).";      //!<Need clear firmware(apply in boot loader only)
    	case	0xEE11: return "0x11: Communication type not supported, VT-1, burst, etc..";      //!<Communication type not supported, VT-1, burst, etc.
    	case	0xEE12: return "0x12: Secure interface is not functional or is in an intermediate state..";      //!<Secure interface is not functional or is in an intermediate state.
    	case	0xEE13: return "0x13: Data field is not mod 8.";      //!<Data field is not mod 8
    	case	0xEE14: return "0x14: Pad 0x80 not found where expected.";      //!<Pad 0x80 not found where expected
    	case	0xEE15: return "0x15: Specified key type is invalid.";      //!<Specified key type is invalid
    	case	0xEE16: return "0x16: Could not retrieve key from the SAM (InitSecureComm).";      //!<Could not retrieve key from the SAM (InitSecureComm)
    	case	0xEE17: return "0x17: Hash code problem.";      //!<Hash code problem
    	case	0xEE18: return "0x18: Could not store the key into the SAM (InstallKey).";      //!<Could not store the key into the SAM (InstallKey)
    	case	0xEE19: return "0x19: Frame is too large.";      //!<Frame is too large
    	case	0xEE1A: return "0x1A: Unit powered up in authentication state but POS must resend the InitSecureComm command.";      //!<Unit powered up in authentication state but POS must resend the InitSecureComm command
    	case	0xEE1B: return "0x1B: The EEPROM may not be initialized because SecCommInterface does not make sense.";      //!<The EEPROM may not be initialized because SecCommInterface does not make sense
    	case	0xEE1C: return "0x1C: Problem encoding APDU.";      //!<Problem encoding APDU
    	case	0xEE20: return "0x20: Unsupported Index (ILM). SAM Transceiver error – problem communicating with the SAM (Key Mgr).";      //!<Unsupported Index (ILM). SAM Transceiver error – problem communicating with the SAM (Key Mgr)
    	case	0xEE21: return "0x21: Unexpected Sequence Counter in multiple frames for single bitmap (ILM). Length error in data returned from the SAM (Key Mgr).";      //!<Unexpected Sequence Counter in multiple frames for single bitmap (ILM). Length error in data returned from the SAM (Key Mgr)
    	case	0xEE22: return "0x22: Improper bit map (ILM).";      //!<Improper bit map (ILM)
    	case	0xEE23: return "0x23: Request Online Authorization.";      //!<Request Online Authorization
    	case	0xEE24: return "0x24: ViVOCard3 raw data read successful.";      //!<ViVOCard3 raw data read successful
    	case	0xEE25: return "0x25: Message index not available (ILM). ViVOcomm activate transaction card type (ViVOcomm).";      //!<Message index not available (ILM). ViVOcomm activate transaction card type (ViVOcomm)
    	case	0xEE26: return "0x26: Version Information Mismatch (ILM).";      //!<Version Information Mismatch (ILM)
    	case	0xEE27: return "0x27: Not sending commands in correct index message index (ILM).";      //!<Not sending commands in correct index message index (ILM)
    	case	0xEE28: return "0x28: Time out or next expected message not received (ILM).";      //!<Time out or next expected message not received (ILM)
    	case	0xEE29: return "0x29: ILM languages not available for viewing (ILM).";      //!<ILM languages not available for viewing (ILM)
    	case	0xEE2A: return "0x2A: Other language not supported (ILM).";      //!<Other language not supported (ILM)
    	case	0xEE41: return "0x41: Module-specific errors for Key Manager.";      //!<Module-specific errors for Key Manager
    	case	0xEE42: return "0x42: Module-specific errors for Key Manager.";      //!<Module-specific errors for Key Manager
    	case	0xEE43: return "0x43: Module-specific errors for Key Manager.";      //!<Module-specific errors for Key Manager
    	case	0xEE44: return "0x44: Module-specific errors for Key Manager.";      //!<Module-specific errors for Key Manager
    	case	0xEE45: return "0x45: Module-specific errors for Key Manager.";      //!<Module-specific errors for Key Manager
    	case	0xEE46: return "0x46: Module-specific errors for Key Manager.";      //!<Module-specific errors for Key Manager
    	case	0xEE47: return "0x47: Module-specific errors for Key Manager.";      //!<Module-specific errors for Key Manager
    	case	0xEE48: return "0x48: Module-specific errors for Key Manager.";      //!<Module-specific errors for Key Manager
    	case	0xEE49: return "0x49: Module-specific errors for Key Manager.";      //!<Module-specific errors for Key Manager
    	case	0xEE4A: return "0x4A: Module-specific errors for Key Manager.";      //!<Module-specific errors for Key Manager
    	case	0xEE4B: return "0x4B: Module-specific errors for Key Manager.";      //!<Module-specific errors for Key Manager
    	case	0xEE4C: return "0x4C: Module-specific errors for Key Manager.";      //!<Module-specific errors for Key Manager
    	case	0xEE4D: return "0x4D: Module-specific errors for Key Manager.";      //!<Module-specific errors for Key Manager
    	case	0xEE4E: return "0x4E: Module-specific errors for Key Manager.";      //!<Module-specific errors for Key Manager
    	case	0xEE4F: return "0x4F: Module-specific errors for Key Manager.";      //!<Module-specific errors for Key Manager
    	case	0xEE50: return "0x50: Auto-Switch OK.";      //!Auto-Switch OK
    	case	0xEE51: return "0x51: Auto-Switch failed.";      //!Auto-Switch failed
    	case	0xEE60: return "0x60: Data not exist.";      //!Data not exist
    	case	0xEE61: return "0x61: Data Full.";      //!Data Full
    	case	0xEE62: return "0x62: Write Flash Error.";      //!Write Flash Error
    	case	0xEE63: return "0x63: Ok and Have Next Command.";      //!Ok and Have Next Command
    	case	0xEE90: return "0x90: Account DUKPT Key not exist.";      //!Account DUKPT Key not exist
    	case	0xEE91: return "0x91: Account DUKPT Key KSN exhausted.";      //!Account DUKPT Key KSN exhausted
    	default :
		String str = String.format("0x%04X", errorCode);
		return str+": Unknown error code.";
    	}
    }
}
