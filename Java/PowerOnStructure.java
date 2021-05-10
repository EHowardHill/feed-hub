package IDTechSDK;

/**
 * The class for PowerOn Option. 
 */	
public class PowerOnStructure {
	/**
	 * true:Send S(IFS) request if T=1 protocolError: Reference source not found; false:no IFS. 
	 */	
	public boolean sendIFS;
	/**
	 * true:Explicit PPSError: Reference source not found; false:No Explicit PPS. 
	 */	
	public boolean explicitPPS;
	/**
	 * true:No auto PPS for negotiate mode; false:Auto PPS. 
	 */	
	public boolean disableAutoPPS;
	
	/**
	 * true:No check on response of S(IFS) request; false:IFS response check. 
	 */	
	public boolean disableResponseCheck;
	/**
	 * pps is used to set the Protocol and Parameters Selection between card and reader, only Di <= 4 are supported. pps must follow the structure specified in ISO 7816-3 as PPS0, [PPS1], [PPS2], and [PPS3]. For more information see ISO 7816-3 section 7.2. 
	 */
	public byte[] pps;
	/**
	 * the length of pps data.
	 */
	public byte ppsLength;
}
