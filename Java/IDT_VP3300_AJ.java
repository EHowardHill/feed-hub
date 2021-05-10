package IDTechSDK;

import IDTechSDK.IDTechSDKBridge;
import IDTechSDK.ReaderInfo.DEVICE_TYPE;

public class IDT_VP3300_AJ extends IDT_Device implements Configurable, MSRInterface, ICCInterface, EMVFunctional, CTLSFunctional, ThreeInterfaceDevice {
	
	/**
	 * It is the constructor of the main class IDT_GooseRun. When it is
	 * called, the SDK will create the Instance for IDT_GooseRun device. The
	 * interface OnReceiverListner needs to be implemented in
	 * the application.
	 * 
	 * @param callback  OnReceiverListener callback
	 * 
	 */
	public IDT_VP3300_AJ(OnReceiverListener callback) {
		IDTechSDKBridge.m_recListener = callback;
	}
	
	/**
	 * Defines connection USB or Audio Jack
	 * 
	 * @param deviceType  DEVICE_TYPE.IDT_DEVICE_VP3300_AJ
	 * 
	 */
	public boolean device_setDeviceType(ReaderInfo.DEVICE_TYPE deviceType) {
		if (deviceType == DEVICE_TYPE.IDT_DEVICE_VP3300_AJ) {
			int rc = IDTechSDKBridge.jdeviceinit();
			if (rc != 0) return false;
			return IDTechSDKBridge.jdevicesetCurrentDevice(DEVICE_TYPE.IDT_DEVICE_VP3300_AJ.getNumVal());
		}
		return false;
	}	
	
	/**
	 * Gets type of device
	 */
	public DEVICE_TYPE device_getDeviceType() {
		return  DEVICE_TYPE.get(IDTechSDKBridge.jdevicegetCurrentDeviceType());
    }



	/**
	 * release, make the SDK in the idle status.
	 */
	public void release() {
		IDTechSDKBridge.jdeviceclose();
	}
	
	
    //---------------------------------------------------------------------------------------------
    // Get info
    //---------------------------------------------------------------------------------------------
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
	 * Enable MSR swipe card. Returns encrypted MSR data or function key value
	 * by call back function.
	 * The function swipeMSRData in interface OnReceiverListener will be called
	 * if swiping card data received.
	 * 
	 * @see OnReceiverListener
	 * 
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
    public int msr_startMSRSwipe() {
    	return IDTechSDKBridge.jmsrstartMSRSwipe(); 
    }
    
	/**
	 * Disable MSR swipe card.
	 * 
	 * Cancels MSR swipe request.
	 * 
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 * 
	 */
	public int msr_cancelMSRSwipe(){
		return IDTechSDKBridge.jmsrcancelMSRSwipe();
	}

    /**
     * Set Merchant Record
     *
     * Sets the burst mode for the device.
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
	 * Get Response Code String
	 * 
	 * Interpret a response code and return string description.
	 * 
	 * @param errorCode Error code, range 0x0000 - 0xFFFF, example 0x0300
	 *   
	 * @return Verbose error description
	 */
	public String device_getResponseCodeString(int errorCode) {
		return IDTechSDKBridge.jdevicegetResponseCodeString(errorCode);
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
	
	/**
	 * Enables pass through mode for ICC. Required when direct ICC commands are required
	 * (power on/off ICC, exchange APDU)
	 * 
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
	public int icc_passthroughOnICC(){
		return IDTechSDKBridge.jiccpassthroughOnICC();
	}
	
	/**
	 * Disables pass through mode for ICC. Required when executing transactions
	 * (start EMV, start MSR, authenticate transaction)
	 * 
	 * @return success or error code.
	 * @see ErrorCode
	 */
	public int icc_passthroughOffICC(){
		return IDTechSDKBridge.jiccpassthroughOffICC();
	}
	
	/**
	 * Power up the currently selected microprocessor card in the ICC reader. It
	 * follows the ISO7816-3 power up sequence and returns the ATR as its
	 * response.
	 * 
	 * @param options
	 *            the options is optional.<br/>
	 *            please see PowerOnStructure class for more information.
	 * @see PowerOnStructure (not used for the UniPay II)
	 * @param atrPPS
	 *            the class for ATR string.<br/>
	 *            the ATR string is following:<br/>
	 *            1. 2D01: Card Not Supported;<br/>
	 *            2. 2D03: Card Not Supported, wants CRC;<br/>
	 *            3. 690D: Command not supported on reader without ICC support;<br/>
	 *            4. 8100: ICC error time out on power-up;<br/>
	 *            5. 8200: invalid TS character received;<br/>
	 *            6. 8500: PPS confirmation error;<br/>
	 *            7. 8600: Unsupported F, D, or combination of F and D;<br/>
	 *            8. 8700: protocol not supported EMV TD1 out of range;<br/>
	 *            9. 8800: power not at proper level;<br/>
	 *            10. 8900: ATR length too long;<br/>
	 *            11. 8B01: EMV invalid TA1 byte value*;<br/>
	 *            12. 8B02: EMV TB1 required*;<br/>
	 *            13. 8B03: EMV Unsupported TB1 only 00 allowed*;<br/>
	 *            14. 8B04: EMV Card Error, invalid BWI or CWI*;<br/>
	 *            15. 8B06: EMV TB2 not allowed in ATR*;<br/>
	 *            16. 8B07: EMV TC2 out of range*;<br/>
	 *            17. 8B08: EMV TC2 out of range*;<br/>
	 *            18. 8B09: per EMV96 TA3 must be > 0xF*;<br/>
	 *            20. 8B10: ICC error on power-up;<br/>
	 *            21. 8B11: EMV T=1 then TB3 required*;<br/>
	 *            22. 8B12: Card Error, invalid BWI or CWI;<br/>
	 *            23. 8B13: Card Error, invalid BWI or CWI;<br/>
	 *            24. 8B17: EMV TC1/TB3 conflict*;<br/>
	 *            25. 8B20: EMV TD2 out of range must be T=1*;<br/>
	 *            26. 8C00: TCK error;<br/>
	 *            27. A304: connector has no voltage setting;<br/>
	 *            28. A305: ICC error on power-up invalid (SBLK(IFSD) exchange;<br/>
	 *            29. E301: ICC error after session start<br/>
	 *            <p>
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
	public int icc_powerOnICC(ResDataStruct atrPPS) {
		return IDTechSDKBridge.icc_powerOnICC(atrPPS);
	}
	
	/**
     * Power Off ICC
     *
     * Powers down the ICC
     *
     * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     *  If Success, empty
     *  If Failure, ASCII encoded data of error string
     */
	public int icc_powerOffICC() {
		return IDTechSDKBridge.jiccpowerOffICC();
	}
	
	/**
     * Get Reader Status
     *
     * Returns the reader status
     *
     * @param status Pointer that will return with the ICCReaderStatus results.
     *   bit 0:  0 = ICC Power Not Ready, 1 = ICC Powered
     *   bit 1:  0 = Card not seated, 1 = card seated
     *
     * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     */
	public int icc_getICCReaderStatus(ICCReaderStatusStruct ICCStatus) {
		return IDTechSDKBridge.icc_getICCReaderStatus(ICCStatus);
	}
	
	/**
     * Exchange APDU
     *
     * Sends an APDU packet to the ICC.  If successful, response is returned in APDUResult class instance in response parameter.
     *
     * @param dataAPDU  APDU data packet
     * @param response Unencrypted/encrypted parsed APDU response
     *
     * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     *
     */
	public int icc_exchangeAPDU(byte[] dataAPDU, ResDataStruct response) {
		return IDTechSDKBridge.icc_exchangeAPDU(dataAPDU, response);
	}
	
	/**
	 * Allow fallback for EMV transactions.  Default is TRUE
	 * 
	 * @param allow TRUE = allow fallback, FALSE = don't allow fallback
	 * 
	 */
	public void emv_allowFallback(boolean allow){
		IDTechSDKBridge.jemvallowFallback(allow);
	}
	
    /**
	 * Sets Auto Authentication for EMV Transactions
	 * Tells the SDK to automatically execute Authenticate Transaction after StartEMV Transaction.  TRUE by default
	 * 
	 */
    public void emv_setAutoAuthenticateTransaction(boolean auto)
    {
    	IDTechSDKBridge.jemvsetAutoAuthenticateTransaction(auto);
    }
    
	/**
     * Start EMV Transaction Request
     *
     * Authorizes the EMV transaction for an ICC card
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
     * @param forceOnline TRUE = do not allow offline approval,  FALSE = allow ICC to approve offline if terminal capable
     * Note:  To request tags to be  included in default response, use tag DFEE1A, and specify tag list.  
     *    Example four tags 9F02, 9F36, 95, 9F37 to be included in response = DFEE1A079F029F369f9F37
	 *
     * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     */
	public int emv_startTransaction(double amount, double amtOther, int type, final int timeout, byte[] tags, boolean forceOnline){
		return IDTechSDKBridge.jemvstartTransaction(amount, amtOther, type, timeout, tags, forceOnline);
	}
	
	/**
     * Authenticate EMV Transaction Request
     *
     * Authenticates the EMV transaction for an ICC card.  Execute this after receiving response with result code 0x10 to emv_startTransaction
	 *
     * The tags will be returned in the callback routine.
	 *
     * @param tags  TLV stream that can be used to update the following values:
     *     - 9F02: Amount
     *     - 9F03: Other amount
     *     - 9C: Transaction type
     *     - 5F57: Account type
     *    In addition tag DFEE1A can be sent to specify tag list to include in results. Example four tags 9F02, 9F36, 95, 9F37 
     *    to be included in response = DFEE1A079F029F369f9F37
	 *
     * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     */
	public int emv_authenticateTransaction(byte[] tags) {
		return IDTechSDKBridge.jemvauthenticateTransaction(tags);
	}
	
	/**
     * Complete EMV Transaction Request
     *
     * Completes the EMV transaction for an ICC card when online authorization request is received from emv_authenticateTransaction
	 *
     * The tags will be returned in the callback routine.
	 *
     * @param commError Communication error with host.  Set to TRUE if host was unreachable, or FALSE if host response received.  If Communication error, authCode, iad, tlvScripts can be null.
     * @param authCode Authorization code from host.  Two bytes.  Example 0x3030.  (Tag value 8A).  Required
     * @param iad Issuer Authentication Data, if any.  Example 0x11223344556677883030 (tag value 91).
     * @param tlvScripts 71/72 scripts, if any
     * @param tags Additional TVL data to return with transaction results (if any)
	 *
     * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     */
	public int emv_completeTransaction(boolean commError, byte[] authCode, byte[] iad, byte[] tlvScripts, byte[] tags) {
		return IDTechSDKBridge.jemvcompleteTransaction(commError, authCode, iad, tlvScripts, tags);
	}
	
	/**
     * Cancel EMV Transaction 
     *
     * Cancels the currently executing EMV transaction.
     *
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     */
	public int emv_cancelTransaction(ResDataStruct respData){
		return IDTechSDKBridge.jemvcancelTransaction();
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
	public int emv_retrieveApplicationData(String aid, ResDataStruct respData) {
		return IDTechSDKBridge.emv_retrieveApplicationData(aid, respData);
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
	public int emv_removeApplicationData(String aid) {
		return IDTechSDKBridge.emv_removeApplicationData(aid);
	}
	
	/**
	 * Set Application Data
	 * 
	 * Sets the Application Data as specified by the application name and TLV data
	 * 
	 * @param name Application name, 10-32 ASCII hex characters representing 5-16 bytes  Example "a0000000031010"
	 * @param tlv  Application data in TLV format. 
	 * @param respData  Status Code in ResDataStruct.statusCode.
	 * 			If AID list is full, status code will be 0x61. Format error status code 0x05
	 * 
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
	public int emv_setApplicationData(String aid, byte[] TLV) {
		return IDTechSDKBridge.emv_setApplicationData(aid, TLV);
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
	public int emv_retrieveTerminalData(ResDataStruct respData) {
		return IDTechSDKBridge.emv_retrieveTerminalData(respData);
	}
	
	/**
	 * Remove Terminal Data
	 * 
	 * Removes the Terminal Data.
	 * 
	 * @param respData  Status Code in ResDataStruct.statusCode.
	 * 
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
	 */
	public int emv_removeTerminalData() {
		return IDTechSDKBridge.jemvremoveTerminalData();
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
	public int emv_setTerminalData(byte[] TLV) {
		return IDTechSDKBridge.jemvsetTerminalData(TLV);
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
	public int emv_retrieveAidList(ResDataStruct respData) {
		return IDTechSDKBridge.emv_retrieveAidList(respData);
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
	public int emv_retrieveCAPK(byte[] data, ResDataStruct respData) {
		return IDTechSDKBridge.emv_retrieveCAPK(data, respData);
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
	public int emv_removeCAPK(byte[] capk) {
		return IDTechSDKBridge.jemvremoveCAPK(capk);
	}
	
	/**
     * Set Certificate Authority Public Key
     *
     * Sets the CAPK as specified by the CAKey structure
     *
     * @param key CAKey format:
     *   [5 bytes RID][1 byte Index][1 byte Hash Algorithm][1 byte Encryption Algorithm][20 bytes HashValue][4 bytes Public Key Exponent][2 bytes Modulus Length][Variable bytes Modulus][2 bytes MAC Length][Variable bytes MAC Data]
     *   Where:
     *    - Hash Algorithm: The only algorithm supported is SHA-1.The value is set to 0x01
     *    - Encryption Algorithm: The encryption algorithm in which this key is used. Currently support only one type: RSA. The value is set to 0x01.
     *    - HashValue: Which is calculated using SHA-1 over the following fields: RID & Index & Modulus & Exponent
     *    - Public Key Exponent: Actually, the real length of the exponent is either one byte or 3 bytes. It can have two values: 3 (Format is 0x00 00 00 03), or  65537 (Format is 0x00 01 00 01)
     *    - Modulus Length: LenL LenH Indicated the length of the next field.
     *    - Modulus: This is the modulus field of the public key. Its length is specified in the field above.
     *    - MAC Length: LenL LenH Indicated the length of the next field.  For Non-PCI device, it is 0x00 0x00.  For PCI device, it is 0x1E 0x00.
     *    - MAC Data:
     *    		For Non-PCI device, i does not exist.
     *    		For PCI device, it is 30 bytes data consists of [2 bytes MAC Value Length][16 bytes MAC Value][2 bytes MAC Key KSN Length][10 bytes MAC Key KSN]
     *    		Where:
     *    			- MAC Value Length: 0x10 0x00
     *    			- MAC value: MAC-HOST.
     *    			- MAC Key KSN Length: 0x0A 0x00
     *    			- MAC Key KSN: MAC DUKPT Key KSN
     * @param respData  Status Code in ResDataStruct.statusCode.
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     *
     */
	public int emv_setCAPK(byte[] key) {
		return IDTechSDKBridge.jemvsetCAPK(key);
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
	public int emv_retrieveCAPKList(ResDataStruct respData) {
		return IDTechSDKBridge.emv_retrieveCAPKList(respData);
	}
	
	/**
     * Retrieve the Certificate Revocation List
     *
     * Returns the CRL entries on the terminal.
     *
     * @param key Response returned in ResDataStruct.resData:
     *   list [CRL1][CRL2]...[CRLn], each CRL 9 bytes where
     *   CRL = 5 bytes RID + 1 byte index + 3 bytes serial number
	 *
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     */
	public int emv_retrieveCRL(ResDataStruct respData) {
		return IDTechSDKBridge.emv_retrieveCRL(respData);
	}
	
	/**
     * Remove Certificate Revocation List Entries
     *
     * Removes CRLEntries as specified by the RID and Index and serial number passed as 9 bytes
     *
     * @param crlList containing the list of CRL to remove:
     *   [CRL1][CRL2]...[CRLn] where each [CRL]  is 9 bytes:
     *   [5 bytes RID][1 byte CAPK Index][3 bytes serial number]
     * @param respData  Status Code in ResDataStruct.statusCode.
	 *
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     *
     */
	public int emv_removeCRL(byte[] crlList) {
		return IDTechSDKBridge.jemvremoveCRL(crlList);
	}
	
	/**
     * Set Certificate Revocation List 
     *
     * Sets the CRL 
     *
     * @param list CRL Entries containing the RID, Index, and serial numbers to set
     *   [CRL1][CRL2]...[CRLn] where each [CRL]  is 9 bytes:
     *   [5 bytes RID][1 byte CAPK Index][3 bytes serial number]
     *
     * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     *
     */
	public int emv_setCRL(byte[] crlList) {
		return IDTechSDKBridge.jemvsetCRL(crlList);
	}
	
	/**
	 * Callback Response LCD Display
	 *
	 Provides menu selection responses to the kernel after a callback was received lcdDisplay delegate.
	 
	 @param mode The choices are as follows
	 - 0x00 Cancel
	 - 0x01 Menu Display
	 - 0x02 Normal Display get Function Key  supply either 0x43 ('C') for Cancel, or 0x45 ('E') for Enter/accept
	 - 0x08 Language Menu Display
	 
	 @param selection Line number in hex (0x01, 0x02), or 'C'/'E' of function key
	 
	 * @return RETURN_CODE:  Values can be parsed with errorCode.getErrorString()
	 
	 */
	public void emv_lcdControlResponse(byte mode, byte data){
		IDTechSDKBridge.jemvlcdControlResponse(mode, data);
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
        A second tag must exisdt
     
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
     * Send a direct command to device
     *
     * Sends a command represented by the provide string to the device.
     *
     * @param cmd NSData representation of command to execute
     * @param calcLRC If <c>TRUE</c>, this will wrap command with start/length/lrc/sum/end:  '{STX}{Len_Low}{Len_High} data {CheckLRC} {CheckSUM} {ETX}'
     * @param data Ignored.  Not applicable for use with Augusta's NGA protocol
     * @param response  Returns response ResDataStruct.respData
     * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     */
	public int device_sendDataCommand(String cmd, boolean calcLRC, String data, ResDataStruct respData) {
		return IDTechSDKBridge.device_sendDataCommand(cmd, calcLRC, data, respData);
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
     * Polls device for EMV Kernel Version
     *
     * @param version Response returned of Kernel Version
     *
     * @return RETURN_CODE:  Values can be parsed with device_getResponseCodeString()
     *
     */
    public int emv_getEMVKernelVersion(StringBuilder version) {
    	return IDTechSDKBridge.emv_getEMVKernelVersion(version);
    }
    
    /**
    * Get EMV Kernel check value info
    *
    * @param checkValue Response returned of Kernel check value info
    * @param checkValueLen the length of checkValue
    *
    * @return RETURN_CODE:  Values can be parsed with device_getResponseCodeString
    *
    */
    public int emv_getEMVKernelCheckValue(ResDataStruct respData) {
    	return IDTechSDKBridge.emv_getEMVKernelCheckValue(respData);
    }
    
    /**
     * Get EMV Kernel configuration check value info
     *
     * @param checkValue Response returned of Kernel configuration check value info
     * @return RETURN_CODE:  Values can be parsed with device_getResponseCodeString
     *
     */
    public int emv_getEMVConfigurationCheckValue(ResDataStruct respData) {
    	return IDTechSDKBridge.emv_getEMVConfigurationCheckValue(respData);
    }
    
    /**
     * Retrieve the EMV Exception List
     *
     Returns the EMV Exception entries on the terminal.
     @param respData.resData [Exception1][Exception2]...[Exceptionn], where  [Exception]  is 12 bytes:
        [1 byte Len][10 bytes PAN][1 byte Sequence Number]

     * @return RETURN_CODE:	Values can be parsed with device_getIDGStatusCodeString()
     */
    public int emv_retrieveExceptionList(ResDataStruct respData) {
    	return IDTechSDKBridge.emv_retrieveExceptionList(respData);
    }
    
    /**
     * Set EMV Exception
     *
     Adds an entry to the EMV Exception List

     @param exception EMV Exception entry containing the PAN and Sequence Number
        where  [Exception]  is 12 bytes:
        [1 byte Len][10 bytes PAN][1 byte Sequence Number]
        PAN, in compressed numeric, padded with F if required (example 0x5413339000001596FFFF)

    * @return RETURN_CODE:	Values can be parsed with device_getIDGStatusCodeString()
     */
    public int emv_setException(byte[] exception) {
    	return IDTechSDKBridge.jemvsetException(exception);
    }
    
    /**
     * Remove EMV Exception
     *
     Removes an entry to the EMV Exception List

     @param exception EMV Exception entry containing the PAN and Sequence Number
        where  [Exception]  is 12 bytes:
        [1 byte Len][10 bytes PAN][1 byte Sequence Number]
        PAN, in compressed numeric, padded with F if required (example 0x5413339000001596FFFF)

     * @return RETURN_CODE:	Values can be parsed with device_getIDGStatusCodeString()
     */
    public int emv_removeException(byte[] exception) {
    	return IDTechSDKBridge.jemvremoveException(exception);
    }
    
    /**
     * Remove All EMV Exceptions
     *
     Removes all entries from the EMV Exception List

    * @return RETURN_CODE:	Values can be parsed with device_getIDGStatusCodeString()
     */
    public int emv_removeAllExceptions() {
    	return IDTechSDKBridge.jemvremoveAllExceptions();
    }
    
    /**
    * Get EMV Exception Log Status
    *
    This command returns information about the EMV Exception log. The version number, record size,
        and number of records contained in the file are returned.

     @param respData.resData 12 bytes returned
        - bytes 0-3 = Version Number
        - bytes 4-7 = Number of records
        - bytes 8-11 = Size of record

    * @return RETURN_CODE:	Values can be parsed with device_getIDGStatusCodeString()
    */
    public int emv_retrieveExceptionLogStatus(ResDataStruct respData) {
    	return IDTechSDKBridge.emv_retrieveExceptionLogStatus(respData);
    }
    
    /**
    * Clear Transaction Log
    *
    Clears the transaction  log.

    * @return RETURN_CODE:	Values can be parsed with device_getIDGStatusCodeString()
    */
    public int emv_removeTransactionLog() {
    	return IDTechSDKBridge.jemvremoveTransactionLog();
    }
    
    /**
    * Get Transaction Log Status
    *
    This command returns information about the EMV transaction log. The version number, record size,
        and number of records contained in the file are returned.

     @param respData.resData 12 bytes returned
        - bytes 0-3 = Version Number
        - bytes 4-7 = Number of records
        - bytes 8-11 = Size of record

    * @return RETURN_CODE:	Values can be parsed with device_getIDGStatusCodeString()
    */
    public int emv_retrieveTransactionLogStatus(ResDataStruct respData) {
    	return IDTechSDKBridge.emv_retrieveTransactionLogStatus(respData);
    }
    
    /**
    * Get Transaction Log Record
    *
    Retrieves  oldest transaction record on the Transaction Log. At successful completion, the oldest transaction
        record is deleted from the transaction log

     @param respData.resData Transaction Record
     @param remainingTransactionLogLen Number of records remaining on the transaction log

    Length | Description | Type
    ----- | ----- | -----
    4 | Transaction Log State (TLS) | Enum (4-byte number, LSB first), SENT ONLINE = 0, NOT SENT = 1
    4 | Transaction Log Content (TLC) | Enum (4-byte number, LSB first), BATCH = 0, OFFLINE ADVICE = 1, ONLINEADVICE = 2, REVERSAL = 3
    4 | AppExpDate | unsigned char [4]
    3 | AuthRespCode | unsigned char [3]
    3 | MerchantCategoryCode | unsigned char [3]
    16 | MerchantID | unsigned char [16]
    2 | PosEntryMode | unsigned char [2]
    9 | TermID | unsigned char [9]
    3 | AIP | unsigned char [3]
    3 | ATC | unsigned char [3]
    33 | IssuerAppData | unsigned char [33]
    6 | TVR | unsigned char [6]
    3 | TSI | unsigned char [3]
    11 | Pan | unsigned char [11]
    2 | PanSQNCNum | unsigned char [2]
    3 | TermCountryCode | unsigned char [3]
    7 | TranAmount | unsigned char [7]
    3 | TranCurCode | unsigned char [3]
    4 | TranDate | unsigned char [4]
    2 | TranType | unsigned char [2]
    9 | IFDSerialNum | unsigned char [9]
    12 | AcquirerID | unsigned char [12]
    2 | CID | unsigned char [2]
    9 | AppCryptogram | unsigned char [9]
    5 | UnpNum | unsigned char [5]
    7 | AmountAuth | unsigned char [7]
    4 | AppEffDate | unsigned char [4]
    4 | CVMResults | unsigned char [4]
    129 | IssScriptResults | unsigned char [129]
    4 | TermCap | unsigned char [4]
    2 | TermType | unsigned char [2]
    20 | Track2 | unsigned char [20]
    4 | TranTime | unsigned char [4]
    7 | AmountOther | unsigned char [7]
    1 | Unused | Unsigned char [1]

    * @return RETURN_CODE:  Values can be parsed with errorCode.getErrorString()

    */
    public int emv_retrieveTransactionLog(ResDataStruct respData, MutableInteger remainingTransactionLogLen) {
    	return IDTechSDKBridge.emv_retrieveTransactionLog(respData, remainingTransactionLogLen);
    }
    
	/**
     * Start Transaction Request for All Three Interfaces
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
	public int device_startTransaction(double amount, double amtOther, int type, final int timeout, byte[] tags) {
		return IDTechSDKBridge.jdevicestartTransaction(amount, amtOther, type, timeout, tags);
	}
	
	/**
     * Cancel Transaction for All Three Interfaces
     *
     * Cancels the currently executing transaction.
     *
	 * @return success or error code.  Values can be parsed with device_getResponseCodeString
	 * @see ErrorCode
     */
	public int device_cancelTransaction() {
		return IDTechSDKBridge.jdevicecancelTransaction();
	}
}
