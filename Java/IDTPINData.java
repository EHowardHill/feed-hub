package IDTechSDK;

public class IDTPINData {
	/**
	 * Get the swiped card KSN (Key Serial Number).<br/>
	 * A byte array containing 10 bytes.
	 */
	public byte[] KSN;

	/**
	 * Get the PIN block data.
	 */
	public byte[] pinBlockData;
	
	/**
	 * This initial vector is used for all encryptions in this command. If encryption is off this field will be filled with zeros (00h).
	 *	Format: binary, most significant byte first
	 */
	public byte[] InitVector;
	
	/**
	 * Complete PAN, either plain or encrypted.
	 *  Format: ASCII (no null terminator), if plain text
     *    	 	Binary (most significant byte first), if encrypted.
	 *	Supports AES in the new format.
	 */
	public byte[] PAN;
	
	/**
	 * First digits of unencrypted PAN, in plain text.
	 *	Format: ASCII (no null terminator)
	 */
	public byte[] FirstPANDigits;
	
	/**
	 * Last digits of unencrypted PAN, in plain text.
	 *	Format: ASCII (no null terminator)
	 */
	public byte[] LastPANDigits;
	
	/**
	 * Complete Expiry Date string
	 *	Format: ASCII (no null terminator), if plain text
     * 		    Binary (most significant byte first), if encrypted
	 */
	public byte[] ExpiryDate;
	
	/**
	 * Complete CSC
	 *	Format: ASCII (no null terminator), if plain text
     * 			Binary (most significant byte first), if encrypted
	 */
	public byte[] CSC;
	
	/**
	 * MAC Status Byte
	 * 	Bit 0:	If 1SHA-256. If 0SHA-1 (Note: If no optional status byte, use default SHA-1)
	 	 * 	Bit 1: If 1Encryption type TDES.
     *		   If 0Encryption type AES
	 *	Bit 4, 3, 2: 000RFU
	 *	Bit 5:   If 1 MAC Value Length, MAC Value and MAC Key KSN
	 *			 If 0 No MAC Value Length, MAC Value and MAC Key KSN.
	 *	Bit 6:  RFU
	 *	Bit 7:  RFU
	 */
	public byte MACStatus;
	
	/**
	 * Authenticate message from Initial Vector field to MAC Value Length field
	 *	Will not be available when encryption is off.
	 */
	public byte[] MACValue;
	
	/**
	 * Complete CSC
	 *	Format: ASCII (no null terminator), if plain text
	 * 			Binary (most significant byte first), if encrypted
	 */
	public byte[] MACKSN;
}
