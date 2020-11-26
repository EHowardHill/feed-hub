package IDTechSDK;

import IDTechSDK.ReaderInfo.DEVICE_TYPE;

public class IDT_KioskIII extends IDT_Device implements Configurable, CTLSFunctional {
	/**
	 * It is the constructor of the main class IDT_KioskIII. When it is
	 * called, the SDK will create the Instance for IDT_KioskIII device. The
	 * interface OnReceiverListner needs to be implemented in
	 * the application.
	 * 
	 * @param callback  OnReceiverListener callback
	 * 
	 */
	public IDT_KioskIII(OnReceiverListener callback) {
		IDTechSDKBridge.m_recListener = callback;		
	}
	
	/**
	 * Defines connection USB.
	 * 
	 * @param deviceType  DEVICE_TYPE.IDT_KioskIII
	 * 
	 */
	public boolean device_setDeviceType(ReaderInfo.DEVICE_TYPE deviceType) {
		int rc = IDTechSDKBridge.jdeviceinit();
		
		if (rc != 0)
			return false;
		
		switch (deviceType) {
			case IDT_DEVICE_KIOSK_III:
				return IDTechSDKBridge.jdevicesetCurrentDevice(DEVICE_TYPE.IDT_DEVICE_KIOSK_III.getNumVal());
			case IDT_DEVICE_KIOSK_III_S:
				return IDTechSDKBridge.jdevicesetCurrentDevice(DEVICE_TYPE.IDT_DEVICE_KIOSK_III_S.getNumVal());
		default:
			break;
		}
		
		return false;
	}
	
	/**
	 * Gets type of device
	 */
	public DEVICE_TYPE device_getDeviceType() {
		return DEVICE_TYPE.get(IDTechSDKBridge.jdevicegetCurrentDeviceType());
    }
	
	/**
	 * READER CONFIG API LIST Get the version of SDK.
	 * 
	 * @param sdkVersion
	 *            for version string.
	 * @return success or error code.
	 * @see ErrorCode
	 */
	public String config_getSDKVersion() {
        return IDTechSDKBridge.jSDKVersion();
    }
	
	/**
	 * get the status if the device connected.
	 * 
	 * @return true: connected, false: disconnected
	 */
    public boolean device_isConnected() {
        return IDTechSDKBridge.jdeviceisConnected() == 0 ? false : true;
    }
    
	/**
	 * Start remote key injection.
	 * 
	 * @return success or error code.
	 * @see ErrorCode
	 */
    public int device_startRKI() {
    	return IDTechSDKBridge.jdevicestartRKI();
    }
    
    /**
     * Set Merchant Record
     *
     * Sets the merchant record for the device.
     *
     * @param index: Merchant Record Index.  The valid value is 1--6.
     * @param enabled: 1: The Merchant ID is valid, 0: The Merchant ID is not valid.
     * @param merchantID: The tag is 9F25.
     * @param merchantURL: The tag is 9F29.
     *
     * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     */
	public int device_setMerchantRecord(int index, boolean enabled, String merchantID, String merchantURL){
		return IDTechSDKBridge.jdevicesetMerchantRecord(index, enabled, merchantID, merchantURL);
	}
	
	/**
     * Get Merchant Record
     *
     * Gets the merchant record for the device.
     *
     * @param respData
	 *            response data from reader.
	 *            Merchant Record Index: 1 byte
	 *            enabled: 1 byte
	 *            Merchant ID: 32 bytes
	 *            Length of Merchant URL: 1 byte
	 *            Merchant URL: 64 bytes
     *
     * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     */
	public int device_getMerchantRecord(int index, ResDataStruct respData) {
		return IDTechSDKBridge.device_getMerchantRecord(index, respData);
	}
	
	/**
	 * DEVICE INFO API Get the firmware version of device.
	 *
	 * @param version
	 *            for version string.
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
    public int device_getFirmwareVersion(StringBuilder version) {
    	return IDTechSDKBridge.device_getFirmwareVersion(version);
    }
    
    /**
     * Ping Device
     *
     * Pings the reader.  If connected, returns success.  Otherwise, returns timeout.
	 *
     * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     */
	public int device_pingDevice() {
		return IDTechSDKBridge.jdevicepingDevice();
	}
	
	/**
     * Set Burst Mode
     *
     * Sets the burst mode for the device.
     *
     * @param mode 0 = OFF, 1 = Always On, 2 = Auto Exit
     *
     * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     */
	public int device_setBurstMode(byte mode) {
		return IDTechSDKBridge.jdevicesetBurstMode(mode);
	}
	
	/**
     * Set Poll Mode
     *
     * Sets the poll mode for the device. Auto Poll keeps reader active, Poll On Demand only polls when requested by terminal
     *
     * @param mode 0 = Auto Poll, 1 = Poll On Demand
	 *
     * @return RETURN_CODE:  Values can be parsed with errorCode.getErrorString()
     */
	public int device_setPollMode(byte mode) {
		return IDTechSDKBridge.jdevicesetPollMode(mode);
	}
	
	/**
     * Control User Interface
	 *
     *
     * Controls the User Interface:  Display, Beep, LED
	 *
     *    @param values Four bytes to control the user interface
     *    Byte[0] = LCD Message
     *    Messages 00-07 are normally controlled by the reader.
     *    - 00h: Idle Message (Welcome)
     *    - 01h: Present card (Please Present Card)
     *    - 02h: Time Out or Transaction cancel (No Card)
     *    - 03h: Transaction between reader and card is in the middle (Processing...)
     *    - 04h: Transaction Pass (Thank You)
     *    - 05h: Transaction Fail (Fail)
     *    - 06h: Amount (Amount $ 0.00 Tap Card)
     *    - 07h: Balance or Offline Available funds (Balance $ 0.00) Messages 08-0B are controlled by the terminal
     *    - 08h: Insert or Swipe card (Use Chip & PIN)
     *    - 09h: Try Again(Tap Again)
     *    - 0Ah: Tells the customer to present only one card (Present 1 card only)
     *    - 0Bh: Tells the customer to wait for authentication/authorization (Wait)
     *    - FFh: indicates the command is setting the LED/Buzzer only.
     *    Byte[1] = Beep Indicator
     *    - 00h: No beep
     *    - 01h: Single beep
     *    - 02h: Double beep
     *    - 03h: Three short beeps
     *    - 04h: Four short beeps
     *    - 05h: One long beep of 200 ms
     *    - 06h: One long beep of 400 ms
     *    - 07h: One long beep of 600 ms
     *    - 08h: One long beep of 800 ms
     *    Byte[2] = LED Number
     *    - 00h: LED 0 (Power LED) 01h: LED 1
     *    - 02h: LED 2
     *    - 03h: LED 3
     *    - FFh: All LEDs
     *    Byte[3] = LED Status
     *    - 00h: LED Off
     *    - 01h: LED On
     * @return RETURN_CODE:  Values can be parsed with errorCode.getErrorString()
     */
	public int device_controlUserInterface(byte[] values) {
		return IDTechSDKBridge.jdevicecontrolUserInterface(values);
	}
	
	/**
     * Get Transaction Results
     * Gets the transaction results when the reader is functioning in "Auto Poll" mode
     *
     * @param cardData The transaction results
     *
     * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     */
	public int device_getTransactionResults(IDTMSRData cardData) {
		return IDTechSDKBridge.device_getTransactionResults(cardData);
	}
	
    /**
	 * Get the serial number of device.
	 *
	 * @param serialNumber
	 *            returns Serial Number string.
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
    public int config_getSerialNumber(StringBuilder serialNumber) {
    	return IDTechSDKBridge.config_getSerialNumber(serialNumber);
    }
    
	/**
	 * Get Response Code String
	 *
	 * Interpret a response code and return string description.
	 *
	 * @param errorCode Error code, range 0x0000 - 0xFFFF, example 0x0300
	 *
	 * @return Verbose error description
	 */
	public String device_getResponseCodeString(int errorCode) {
		return ErrorCodeInfo.getErrorCodeDescription(errorCode);
	}
	
	/**
	 * Sends a Direct Command
	 * Sends a NEO IDG ViVOtech 2.0 command
	 *
	 * @param command Two bytes command (including subCommand) as per NEO IDG Reference Guide (UniPayIII)
	 * @param calcLRC  Not used for IDG devices
	 * @param data  Command data (if applicable) for IDG devices
	 * @param response  Returns response ResDataStruct.resData. Status Code in ResDataStruct.statusCode
	 *
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
	public int device_sendDataCommand(String cmd, boolean calcLRC, String data, ResDataStruct respData) {
		return IDTechSDKBridge.device_sendDataCommand(cmd, calcLRC, data, respData);
	}
	
	/**
	 * Retrieve Application Data
	 *
	 * Retrieves the TLV values of a provide AID.
	 *
	 * @param aid  Aid file to retrieve.
	 * @param respData  Returns TLV in ResDataStruct.resData. Status Code in ResDataStruct.statusCode.
	 * 		If no application data exists, status code will be 0x60
	 *
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
	public int ctls_retrieveApplicationData(String aid, ResDataStruct respData) {
		return IDTechSDKBridge.ctls_retrieveApplicationData(aid, respData);
	}
	
	/**
	 * Remove Application Data
	 *
	 * Removes the Application Data as specified by the AID name passed as a parameter
	 *
	 * @param aid  Aid file to remove.
	 * @param respData  Status Code in ResDataStruct.statusCode.
	 * If no application data exists, status code will be 0x60. Format error status code 0x05
	 *
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
	public int ctls_removeApplicationData(String aid) {
		return IDTechSDKBridge.ctls_removeApplicationData(aid);
	}
	
    /**
     * Set Application Data by AID
     *
     Sets the Application Data for CTLS as specified by the  TLV data

     @param tlv  Application data in TLV format
        The first tag of the TLV data must be the group number (FFE4).
        The second tag of the TLV data must be the AID (9F06)

        Example valid TLV, for Group #2, AID a0000000035010:
        "ffe401029f0607a0000000051010ffe10101ffe50110ffe30114ffe20106"

    * @return RETURN_CODE:  Values can be parsed with errorCode.getErrorString()
    * @see ErrorCode
     */
	public int ctls_setApplicationData(byte[] TLV) {
		return IDTechSDKBridge.jctlssetApplicationData(TLV);
	}
	
    /**
     * Set Configuration Data for AID Group
     *
     Sets the Configuration Data for CTLS as specified by the TLV data

     @param tlv  Configuration data in TLV format
        The first tag of the TLV data must be the group number (FFE4).
        A second tag must exist

    * @return RETURN_CODE:  Values can be parsed with errorCode.getErrorString()
    * @see ErrorCode
     */
	public int ctls_setConfigurationGroup(byte[] TLV) {
		return IDTechSDKBridge.jctlssetConfigurationGroup(TLV);
	}
	
	/**
	 * Retrieve Terminal Data
	 *
	 * Retrieves the TLV values of a the terminal.
	 *
	 * @param respData  Returns TLV in ResDataStruct.resData. Status Code in ResDataStruct.statusCode.
	 * 					If no terminal data exists, status code will be 0x60
	 *
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
	public int ctls_retrieveTerminalData(ResDataStruct respData) {
		return IDTechSDKBridge.ctls_retrieveTerminalData(respData);
	}
	
	/**
	 * Set Terminal Data
	 *
	 * Sets the Terminal Data as specified by the TerminalData structure passed as a parameter
	 *
	 * @param TLV  TerminalData configuration file.
	 * @param respData  Status Code in ResDataStruct.statusCode.
	 * 			If Flash error, status code will be 0x62. Format error status code 0x05
	 *
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
	public int ctls_setTerminalData(byte[] TLV) {
		return IDTechSDKBridge.jctlssetTerminalData(TLV);
	}
	
	/**
	 * Retrieve Aid List
	 *
	 * Returns all the AID names installed on the terminal.
	 *
	 * @param respData  Array of AID string names passed back in ResDataStruct.stringArray.
	 * 					Status Code in ResDataStruct.statusCode.
	 * 					If no AIDs exists, status code will be 0x60
	 *
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
	public int ctls_retrieveAidList(ResDataStruct respData) {
		return IDTechSDKBridge.ctls_retrieveAidList(respData);
	}
	
	/**
     * Retrieve Certificate Authority Public Key
     *
     * Retrieves the CAPK as specified by the RID/Index  passed as a parameter.
     *
     * @param capk 6 bytes CAPK = 5 bytes RID + 1 byte Index
     * @param key Response returned in ResDataStruct.resData:
     *   [5 bytes RID][1 byte Index][1 byte Hash Algorithm][1 byte Encryption Algorithm][20 bytes HashValue][4 bytes Public Key Exponent][2 bytes Modulus Length][Variable bytes Modulus]
     *   Where:
     *    - Hash Algorithm: The only algorithm supported is SHA-1.The value is set to 0x01
     *    - Encryption Algorithm: The encryption algorithm in which this key is used. Currently support only one type: RSA. The value is set to 0x01.
     *    - HashValue: Which is calculated using SHA-1 over the following fields: RID & Index & Modulus & Exponent
     *    - Public Key Exponent: Actually, the real length of the exponent is either one byte or 3 bytes. It can have two values: 3 (Format is 0x00 00 00 03), or  65537 (Format is 0x00 01 00 01)
     *    - Modulus Length: LenL LenH Indicated the length of the next field.
     *    - Modulus: This is the modulus field of the public key. Its length is specified in the field above.
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     */
	public int ctls_retrieveCAPK(byte[] data, ResDataStruct respData) {
		return IDTechSDKBridge.ctls_retrieveCAPK(data, respData);
	}
	
	/**
     * Remove Certificate Authority Public Key
     *
     * Removes the CAPK as specified by the RID/Index
     *
     * @param capk 6 byte CAPK =  5 bytes RID + 1 byte INDEX
     * @param respData  Status Code in ResDataStruct.statusCode.
	 *
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     */
	public int ctls_removeCAPK(byte[] capk) {
		return IDTechSDKBridge.jctlsremoveCAPK(capk);
	}
	
	/**
     * Set Certificate Authority Public Key
     *
     * Sets the CAPK as specified by the CAKey structure
     *
     * @param key CAKey format:
     *   [5 bytes RID][1 byte Index][1 byte Hash Algorithm][1 byte Encryption Algorithm][20 bytes HashValue][4 bytes Public Key Exponent][2 bytes Modulus Length][Variable bytes Modulus]
     *   Where:
     *    - Hash Algorithm: The only algorithm supported is SHA-1.The value is set to 0x01
     *    - Encryption Algorithm: The encryption algorithm in which this key is used. Currently support only one type: RSA. The value is set to 0x01.
     *    - HashValue: Which is calculated using SHA-1 over the following fields: RID & Index & Modulus & Exponent
     *    - Public Key Exponent: Actually, the real length of the exponent is either one byte or 3 bytes. It can have two values: 3 (Format is 0x00 00 00 03), or  65537 (Format is 0x00 01 00 01)
     *    - Modulus Length: LenL LenH Indicated the length of the next field.
     *    - Modulus: This is the modulus field of the public key. Its length is specified in the field above.
     * @param respData  Status Code in ResDataStruct.statusCode.
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     *
     */
	public int ctls_setCAPK(byte[] key) {
		return IDTechSDKBridge.jctlssetCAPK(key);
	}
	
    /**
     * Retrieve the Certificate Authority Public Key list
     *
     * Returns all the CAPK RID and Index installed on the terminal.
     *
     * @param respData ResDataStruct.resData = [key1][key2]...[keyn], each key 6 bytes where
     *   key = 5 bytes RID + 1 byte index
     *
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     */
	public int ctls_retrieveCAPKList(ResDataStruct respData) {
		return IDTechSDKBridge.ctls_retrieveCAPKList(respData);
	}
	
	/**
	 * Remove all Application Data
	 *
	 * Removes all the Application Data
	 *
	 *
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
	public int ctls_removeAllApplicationData() {
		return IDTechSDKBridge.jctlsremoveAllApplicationData();
	}
	
	/**
	 * Remove All Certificate Authority Public Key
	 *
	 * Removes all CAPK
	 *
	 *
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
	public int ctls_removeAllCAPK() {
		return IDTechSDKBridge.jctlsremoveAllCAPK();
	}
	
	/**
     * Start CTLS (or MSR) Transaction Request
     *
     * Authorizes the CTLS (or MSR) transaction for an ICC card
	 *
     * The tags will be returned in the callback routine.
	 *
     * @param amount Transaction amount value  (tag value 9F02)
     * @param amtOther Other amount value, if any  (tag value 9F03)
     * @param type Transaction type (tag value 9C).
     * @param timeout Timeout value in seconds.
     * @param tags Any other tags to be included in the request.  Passed as a string.  Example, tag 9F0C with amount 0x000000000100 would be "9F0C06000000000100"
     *    If tags 9F02 (amount),9F03 (other amount), or 9C (transaction type) are included, they will take priority over these values
     *    supplied as individual parameters to this method.
     * Note:  To request tags to be  included in default response, use tag DFEE1A, and specify tag list.
     *    Example four tags 9F02, 9F36, 95, 9F37 to be included in response = DFEE1A079F029F369f9F37
	 *
     * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     */
	public int ctls_startTransaction(double amount, double amtOther, int type, final int timeout, byte[] tags){
		return IDTechSDKBridge.jctlsstartTransaction(amount, amtOther, type, timeout, tags);
	}
	
	/**
	 * Cancel CTLS (or MSR) Transaction
	 *
	 * Cancels the currently executing CTLS transaction (or MSR swipe request).
	 *
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 *
	 */
    public int ctls_cancelTransaction() {
    	return IDTechSDKBridge.jctlscancelTransaction();
    }

/**
	 * Start CTLS Transaction Request
	 *
	 Authorizes the CTLS transaction for an ICC card
	 
	 The tags will be returned in the callback routine.
	 
	 @param timeout Timeout value in seconds.
	 @param tags The tags to be included in the request.  Passed as TLV stream.	Example, tag 9F0C with amount 0x000000000100 would be 0x9F0C06000000000100
	 
	 >>>>>IMPORTANT: parameters for amount and amtOther MUST BE PASSED AS A DOUBLE VALUE WITH DECIMAL POINT.  Example, do not pass 1, but instead pass 1.0 or 1.00. Otherwise, results will be unpredictable
	 
	 
	 
	 * @return RETURN_CODE:	Values can be parsed with device_getIDGStatusCodeString()
	 * Note: if auto poll is on, it will returm the error IDG_P2_STATUS_CODE_COMMAND_NOT_ALLOWED
	 *
	 * NOTE ON APPLEPAY VAS:
	 * To enable ApplePay VAS, first a merchant record must be defined in one of the six available index positions (1-6) using device_setMerchantRecord, then container tag FFEE06
	 * must be sent as part of the additional tags parameter of ctls_startTransaction.  Tag FFEE06 must contain tag 9F26 and 9F22, and can optionanally contain tags 9F2B and DFO1.
	 * Example FFEE06189F220201009F2604000000009F2B050100000000DF010101
	 * 9F22 = two bytes = ApplePay Terminal Applicaiton Version Number.	Hard defined as 0100 for now. (required)
	 * 9F26 = four bytes = ApplePay Terminal Capabilities Information (required)
	 *  - Byte 1 = RFU
	 *  - Byte 2 = Terminal Type
	 *  - - Bit 8 = VAS Support	(1=on, 0 = off)
	 *  - - Bit 7 = Touch ID Required  (1=on, 0 = off)
	 *  - - Bit 6 = RFU
	 *  - - Bit 5 = RFU
	 *  - - Bit 1,2,3,4
	 *  - - - 0 = Payment Terminal
	 *  - - - 1 = Transit Terminal
	 *  - - - 2 = Access Terminal
	 *  - - - 3 = Wireless Handoff Terminal
	 *  - - - 4 = App Handoff Terminal
	 *  - - - 15 = Other Terminal
	 *  - Byte 3 = RFU
	 *  - Byte 4 = Terminal Mode
	 *  - - 0 = ApplePay VAS OR ApplePay
	 *  - - 1 = ApplePay VAS AND ApplePay
	 *  - - 2 = ApplePay VAS ONLY
	 *  - - 3 = ApplePay ONLY
	 *  9F2B = 5 bytes = ApplePay VAS Filter.  Each byte filters for that specific merchant index  (optional)
	 *  DF01 = 1 byte = ApplePay VAS Protocol.  (optional)
	 *  - - Bit 1 : 1 = URL VAS, 0 = Full VAS
	 *  - - Bit 2 : 1 = VAS Beeps, 0 = No VAS Beeps
	 *  - - Bit 3 : 1 = Silent Comm Error, 2 = EMEA Comm Error
	 *  - - Bit 4-8 : RFU
	 *
	 */
public int ctls_activateTransaction(final int _timeout, byte[] tags){
    	return IDTechSDKBridge.jctlsactivateTransaction(_timeout, tags); 
    }

/**
 * Retrieve All Configuration Groups
 *
 * Returns all the Configuration Groups installed on the terminal for CTLS
 *
 * @param tlv  The TLV elements data
 *
 * @return RETURN_CODE:    Values can be parsed with device_getIDGStatusCodeString()
 */
public int ctls_getAllConfigurationGroups(byte[] tlv){
    	return IDTechSDKBridge.jctlsgetAllConfigurationGroups(tlv); 
    }

/**
 * Get Configuration Group
 *
 * Retrieves the Configuration for the specified Group.
 *
 * @param group Configuration Group
 * @param tlv return data
 * @param tlvLen the length of tlv data buffer
 *
 * @return RETURN_CODE:    Values can be parsed with device_getIDGStatusCodeString()
 */
public int ctls_getConfigurationGroup(int group, byte[] tlv){
    	return IDTechSDKBridge.jctlsgetConfigurationGroup(group, tlv); 
    }

/**
 * Remove Configuration Group
 *
 * Removes the Configuration as specified by the Group.  Must not by group 0
 *
 * @param group Configuration Group
 *
 * @retval RETURN_CODE:    Values can be parsed with device_getIDGStatusCodeString()
 */
public int ctls_removeConfigurationGroup(int group){
    	return IDTechSDKBridge.jctlsremoveConfigurationGroup(group); 
    }


	/**
	 * release, make the SDK in the idle status.
	 */
	public void release() {
		IDTechSDKBridge.jdeviceclose();
	}	

	/**
	 * Get DRS
	 * 
	 * @param respData.resData
	 *            Response Body is <DRS SourceBlk Number> <SourceBlk1> � [<SourceBlkN>] 
     *              Where:
	 *                DRS �Destructive Reset
	 *                <DRS SourceBlk Number> is 2 bytes, format is NumL NumH. It is Number of <SourceBlkX>
	 *                <SourceBlkX> is n bytes, Format is <SourceID> <SourceLen> <SourceData>
	 *                  <SourceID> is 1 byte
     *                  <SourceLen> is 1 byte, it is length of <SourceData>
     *                                 Item                 |    SourceID   |  SourceLen  |  SourceData
     *                --------------------------------------------------------------------------------------------------------------------
     *                    Master Chip Check Value Error     |       00      |      1      |  01 � Application Error
     *                --------------------------------------------------------------------------------------------------------------------
     *                     Slave Chip Check Value Error     |       01      |      1      |  01 � Application Error
     *                --------------------------------------------------------------------------------------------------------------------
     *                         Korea Self-Test Error        |       02      |      1      |  0x01 � EMV L2 Configuration Check Value Error
     *                                                      |               |             |  0x02 � Future Key Check Value Error
     *                --------------------------------------------------------------------------------------------------------------------
     *                                Battery               |       10      |      1      |  01 � Battery Error
     *                --------------------------------------------------------------------------------------------------------------------
     *                              Tamper Switch           |       11      |      1      |  Bit 0 � Tamper Switch 1 (0-No, 1-Error)
     *                                                      |               |             |  Bit 1 � Tamper Switch 2 (0-No, 1-Error)
     *                                                      |               |             |  Bit 2 � Tamper Switch 3 (0-No, 1-Error)
     *                                                      |               |             |  Bit 3 � Tamper Switch 4 (0-No, 1-Error)
     *                                                      |               |             |  Bit 4 � Tamper Switch 5 (0-No, 1-Error)
     *                                                      |               |             |  Bit 5 � Tamper Switch 6 (0-No, 1-Error)
     *                --------------------------------------------------------------------------------------------------------------------
     *                               Temperature            |       12      |       1     |  01 �TemperatureHigh or Low
     *                --------------------------------------------------------------------------------------------------------------------
     *                                 Voltage              |       13      |       1     |  01 �Voltage High or Low
     *                --------------------------------------------------------------------------------------------------------------------
     *                                  Other               |       1F      |       4     |  Reg31~24bits, Reg23~16bits,
     *                                                      |               |             |  Reg15~8bits, Reg7~0bits
	 * 
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
	public int device_getDRS(ResDataStruct respData) {
		return IDTechSDKBridge.device_getDRS(respData);
	}

	/**
	 * Verify Backdoor Key to Unlock Security
	 * 
	 * 
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
	public int device_verifyBackdoorKey() {
		if (device_getDeviceType() != DEVICE_TYPE.IDT_DEVICE_AUGUSTA_S_TTK_HID) 
			return ErrorCode.NOT_SUPPORTED;
		
		return IDTechSDKBridge.jdeviceverifyBackdoorKey();
	}
	
	/**
     * Self check for TTK 
     *   If Self-Test function Failed, then work into De-activation State.
     *   If device work into De-activation State, All Sensitive Data will be erased and it need be fixed in Manufacture.
     * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     */
	public int device_selfTest() {
		if (device_getDeviceType() != DEVICE_TYPE.IDT_DEVICE_AUGUSTA_S_TTK_HID) 
			return ErrorCode.NOT_SUPPORTED;
		
		return IDTechSDKBridge.jdeviceselfTest();
	}

	/**
	 * get key status of the device
	 * 
	 * @param respData.resData
	 *          For Augusta:
	 *            Response Body is PIN DUKPT Status + PIN Master Key Status + PIN Session Key Status + Data encryption KeyStatus + Data encryption KeyStatus + RKI-KEK
     *            Where:
     *            ------------------------------------------------------------------------------------------------------------------
     *            Key                               |    Status                          |         Note
     *            ------------------------------------------------------------------------------------------------------------------
     *            PIN DUKPT Key	                    |    0: None.                        |
     *                                              |    1: Exist                        |   Does not support this key.  Always 0
     *                                              |    0xFF: STOP                      |
     *            ------------------------------------------------------------------------------------------------------------------
     *            PIN Master Key                    |    0: None                         |
     *                                              |    1: At least Exist a Master Key  |   Does not support this key.  Always 0
     *            ------------------------------------------------------------------------------------------------------------------
     *            PIN Session Key                   |    0: None.                        |
     *                                              |    1: Exist                        |   Does not support this key.  Always 0
     *            ------------------------------------------------------------------------------------------------------------------
     *            Data encryption Key/MSRDUKPT Key  |    0: None.                        |
     *                                              |    1: Exist                        |
     *                                              |    0xFF: STOP                      |
     *            ------------------------------------------------------------------------------------------------------------------
     *            Data encryption Key/ICC DUKPT Key |    0: None.                        |
     *                                              |    1: Exist                        |
     *                                              |    0xFF: STOP                      |
     *            ------------------------------------------------------------------------------------------------------------------
     *            RKI-KEK                           |    0: None.                        |
     *                                              |    1: Exist                        |
     *                                              |    0xFF: STOP                      |
     *            ------------------------------------------------------------------------------------------------------------------
     *            
     *         For Augusta S TTK
     *           <Block Length> <KeyStatusBlock1> <[KeyStatusBlock2]> �<[KeyStatusBlockN]>
	 *            Where:
	 *              <Block Length> is 2 bytes, format is Len_L Len_H, is KeyStatusBlock Number
	 *              <KeyStatusBlockX> is 4 bytes, format is <Key Index and Key Name> <key slot> <key status>:
	 *                <Key Index and Key Name> is 1 byte. Please refer to following table and <80000426-001 KeyNameIndex Database � V51.xls>
	 *                <key slot> is 2 bytes. Range is 0 � 9999
	 *                <key status> is 1 byte.
	 *                  0 � Not Exist
	 *                  1 � Exist
     *                  0xFF � (Stop. Only Valid for DUKPT Key)
     *                  
     *           Support <Key Index and Key Name> Table
     *           
     *           KeyNameIndex     |    Key Name              |      Definition                  |   Key Slot
     *           --------------------------------------------------------------------------------------------------------
     *           0x14             |   LCL-KEK                |   Encrypt Other Keys             |      0
     *           0x02	          |   Data encryption Key	 |   Encrypt ICC                    |      0
     *           0x05             |   MAC DUKPT Key          |   Host-Device � MAC Verification |      0
     *           0x05             |   MTK DUKPT Key          |    TTK Self-Test                 |      16
     *           0x0C             |   RKI-KEK                |   Remote Key Injection           |      0
	 *
	 * 
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
	public int device_getKeyStatus(ResDataStruct respData) {
		return IDTechSDKBridge.device_getKeyStatus(respData);
	}

    /**
	 * Get the model number of device.
	 * 
	 * @param modNumber
	 *            returns Model Number string.
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
    public int config_getModelNumber(StringBuilder modNumber) {
    	return IDTechSDKBridge.config_getModelNumber(modNumber);
    }
}

