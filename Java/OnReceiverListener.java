package IDTechSDK;

/**
 * The interface includes the callback functions for card data, PIN data and EMV data. 
 * The android activity should implement this interface then implement callback functions.
 */
public interface OnReceiverListener 
{
	

	public enum EMV_RESULT_CODE_Types{
		EMV_RESULT_CODE_OFFLINE_APPROVED,EMV_RESULT_CODE_OFFLINE_DECLINED,EMV_RESULT_CODE_APPROVED,EMV_RESULT_CODE_DECLINED,
		EMV_RESULT_CODE_GO_ONLINE,EMV_RESULT_CODE_CALL_YOUR_BANK,EMV_RESULT_CODE_NOT_ACCEPTED,
		EMV_RESULT_CODE_USE_MAGSTRIPE,EMV_RESULT_CODE_TIME_OUT,
		EMV_RESULT_CODE_TRANSACTION_SUCCESS,EMV_RESULT_CODE_TERMINATE
		};
		
	/**
	 * Call back function,this function will be called automatically if Card decode has been completed after swiping card.
	 * @param card the MSR data.<br/>
	 * Card data.It is encrypted data and format is following:<br/>
	 * 	1.	Data Length low byte - 1 byte;<br/r>
	 * 	2.	Data length high byte - 1 byte;<br/r>
	 *  3.	Card Encode Type - 1 byte.0x00/0x80-ISO/ABA format,0x01/0x81-AAMVA format,0x03/0x83-Other and 0x04/0x84-undecoded format.<br/>
	 *  4.	Track1~3 Status - 1 byte.Bit0,1,2:Track1~3 decode and Bit3,4,5:Track1~3 sampling.<br/>
	 *  5.	Track1 data length - 1 byte.This length is the plain card data's length.<br/>
	 *  6.	Track2 data length - 1 byte.<br/>
	 *  7.	Track3 data length - 1 byte.<br/>
	 *  8.	Clear/mask data sent status - 1 byte.<br/>
	 *  Bit0:1--Track1 clear/mask status present,0--not present.<br/>
	 *  Bit1:1--Track2 clear/mask status present,0--not present.<br/>
	 *  Bit2:1--Track1 clear/mask status present,0--not present.<br/>
	 *  Bit3~Bit7:Reserved.Set to 0.<br/>
	 *  9.Encrypted/Hash data sent status - 1 byte.<br/>
	 *  Bit0:1--Track1 encrypted data present.<br/>
	 *  Bit1:1--Track2 encrypted data present.<br/>
	 *  Bit2:1--Track3 encrypted data present.<br/>
	 *  Bit3:1--Track1 hash data present.<br/>
	 *  Bit4:1--Track2 hash data present.<br/>
	 *  Bit5:1--Track3 hash data present.<br/>
	 *  Bit0:0.<br/>
	 *  Bit7:1--KSN present.<br/>
	 *  10.	Track1 clear/mask data -- Var bytes.<br/>
	 *  11.	Track2 clear/mask data -- Var bytes.<br/>
	 *  12.	Track3 clear/mask data -- Var bytes.<br/>
	 *  13.	Track1 encrypted data -- Var bytes.<br/>
	 *  14.	Track2 encrypted data -- Var bytes.<br/>
	 *  15.	Track3 encrypted data -- Var bytes.<br/>
	 *  16.	Track1 hash data -- 20 bytes if exist.<br/>
	 *  17.	Track2 hash data -- 20 bytes if exist.<br/>
	 *  18.	Track3 hash data -- 20 bytes if exist.<br/>
	 *  19.	KSN -- 10 bytes.<p>		
	 */
	public void swipeMSRData(IDTMSRData card);
	
	
	/**
	 LCD Display Request
	 During an EMV transaction, this delegate will receive data to clear virtual LCD display, display messages, display menu, or display language.  Applies to UniPay III
	 
	 @param mode LCD Display Mode:
	 - 0x01: Menu Display.  A selection must be made to resume the transaction
	 - 0x02: Normal Display get function key.  A function must be selected to resume the transaction
	 - 0x03: Display without input.  Message is displayed without pausing the transaction
	 - 0x04: List of languages are presented for selection. A selection must be made to resume the transaction
	 - 0x10: Clear Screen. Command to clear the LCD screen
	 
	 @param lines Line(s) of data to display
	 @param timeout  Timeout value when displaying dialog box
	 
	 */
	public void lcdDisplay(int mode, String[] lines, int timeout);
	
	/**
	 EMV Transaction Data
	 
	 This protocol will receive results from IDT_Device::startEMVTransaction:otherAmount:timeout:cashback:additionalTags:()
	 
	 
	 @param emvData EMV Results Data.  Result code, card type, encryption type, masked tags, encrypted tags, unencrypted tags and KSN
	 
	 */
	public void emvTransactionData(IDTEMVData emvData);
	
	
	/**
	*Fires when device connects.
	*/
	public void deviceConnected();

	/**
	*Fires when device disconnects.
	*/
	public void deviceDisconnected();

	/**
	*Timeout when wait for the response.<br/>
	*This happens in the process of get PINpad, swipe MSR, EMV Level 2 transaction<br/>
	*/	
	public void timeout(int errorCode);

	/**
	*RKI succeeded; MAC result as return value.<br/>
	*/	
	public void msgRKICompleted(String MACResult);
	
	/**
	 * The ICC Card seated status notification,
	*@param dataNotify: the response data.<br/>
	*@param strMessage, the ICC notification message information.<br/>
	*/		
	public void ICCNotifyInfo(byte[] dataNotify , String strMessage);
	
	/**
	 * The message notify the application to connect the device. 
	 */
	public void msgToConnectDevice();
	
	/**
	 * The input/output data notification,
	*@param data: the input/output data.<br/>
	*@param isIncoming: true if is incoming data, false if it is out going data.<br/>
	*/
	public void dataInOutMonitor(byte[] data, boolean isIncoming);

}
