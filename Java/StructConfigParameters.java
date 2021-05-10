package IDTechSDK;

import IDTechSDK.ReaderInfo.DEVICE_TYPE;
import IDTechSDK.ReaderInfo.SupportStatus;


public class StructConfigParameters implements Cloneable {

	
    //RECORDER
    private int             frequencyInput = 48000;
    private int             iRecordReadBufferSize = 0;
    private int             iRecordBufferSize = 0;
    private short           useVOICE_RECOGNIZITION = 0;
    
    //PLAYER
    private int             frequencyOutput = 48000;
    private short           directionOutputWave = 0;
    private String			versionToTestOtherDirection = null;			
  
    //UM READER
    private int             baudRate = 9600;
    private byte            shuttleChannel = 0x30; // default channel is L1
    
    //INFO
    private String          strModel = "";
      // A list of support status. List size is the number items in the ReaderType enum.
      // A null value (unspecified) indicates UNSUPPORTED
    private SupportStatus[] supportStatuses = new SupportStatus[DEVICE_TYPE.values().length];
    
    //HACKS
    private short           powerupWhenSwipe = 0;
    private short           powerupLastBeforeCMD = 200;
    private short           forceHeadsetPlug = 0;
    private short           volumeLevelAdjust = 0;
    private short			reverseAudioEvents = 0;

    
    // --------------------------------------------------------------------------------------------
    // Getters
    // --------------------------------------------------------------------------------------------
    
    //RECORDER
    public int             getFrequenceInput()       {return frequencyInput;}
    public int             getRecordReadBufferSize() {return iRecordReadBufferSize;}
    public int             getRecordBufferSize()     {return iRecordBufferSize;}
    public short           getUseVoiceRecognition()  {return useVOICE_RECOGNIZITION;}
    
    //PLAYER
    public int             getFrequenceOutput()      {return frequencyOutput;}
    public short           getDirectionOutputWave()  {return directionOutputWave;}
    public String 		   getVersionToTestOtherDirection()  {return versionToTestOtherDirection;} 
   
    //UM READER
    public int             getBaudRate()             {return baudRate;}
    public byte            getShuttleChannel()       {return shuttleChannel;}
    
    //INFO
    public String          getModelNumber()          {return strModel;}
    public SupportStatus[] getSupportStatuses()      {return supportStatuses.clone();}
    
    //HACKS
    public short           getPowerupWhenSwipe()     {return powerupWhenSwipe;}
    public short           getPowerupLastBeforeCMD() {
        if (forceHeadsetPlug == 1)
            return 600;
        else
            return powerupLastBeforeCMD;
    }
    public short           getForceHeadsetPlug()     {return forceHeadsetPlug;}
    public short           getVolumeLevelAdjust()    {return volumeLevelAdjust;}
	public short 		   getReverseAudioEvents() 	 {return reverseAudioEvents;}

    // --------------------------------------------------------------------------------------------
    // Setters
    // --------------------------------------------------------------------------------------------
    
    //RECORDER
    public void setFrequenceInput       (int             value) {frequencyInput = value;}
    public void setRecordReadBufferSize (int             value) {iRecordReadBufferSize = value;}
    public void setRecordBufferSize     (int             value) {iRecordBufferSize = value;}
    public void setUseVoiceRecognition  (short           value) {useVOICE_RECOGNIZITION = value;}
    
    //PLAYER
    public void setFrequenceOutput      (int             value) {frequencyOutput = value;}
    public void setDirectionOutputWave  (short           value) {directionOutputWave = value;}
    public void setVersionToTestOtherDirection (String	 value) {versionToTestOtherDirection = value;}
   
    //UM READER
    public void setBaudRate             (int             value) {baudRate = value;}
    public void setShuttleChannel       (byte            value) {shuttleChannel = value;}
    
    //INFO
    public void setModelNumber          (String          value) {strModel = value;}
    public void setSupportStatuses      (SupportStatus[] value) {supportStatuses = value.clone();}
    
    //HACKS
    public void setPowerupWhenSwipe     (short           value) {powerupWhenSwipe = value;}
    public void setPowerupLastBeforeCMD (short           value) {powerupLastBeforeCMD = value;}
    public void setForceHeadsetPlug     (short           value) {forceHeadsetPlug = value;}
    public void setVolumeLevelAdjust    (short           value) {volumeLevelAdjust = value;}
	public void setReverseAudioEvents	(short 			 value) {reverseAudioEvents = value;}
	
    // --------------------------------------------------------------------------------------------
    // Other
    // --------------------------------------------------------------------------------------------
    
    public StructConfigParameters clone() {
        StructConfigParameters ret = new StructConfigParameters();
        
        //RECORDER
        ret.setFrequenceInput        (getFrequenceInput());
        ret.setRecordReadBufferSize  (getRecordReadBufferSize());
        ret.setRecordBufferSize      (getRecordBufferSize());
        ret.setUseVoiceRecognition   (getUseVoiceRecognition());
        
        //PLAYER
        ret.setFrequenceOutput       (getFrequenceOutput());
        ret.setDirectionOutputWave   (getDirectionOutputWave());
        ret.setVersionToTestOtherDirection(getVersionToTestOtherDirection());
        
        //UM READER
        ret.setBaudRate              (getBaudRate());
        ret.setShuttleChannel        (getShuttleChannel());
        
        //INFO
        ret.setModelNumber           (getModelNumber());
        ret.setSupportStatuses       (getSupportStatuses());
        
        //HACKS
        ret.setPowerupWhenSwipe      (getPowerupWhenSwipe());
        ret.setPowerupLastBeforeCMD  (getPowerupLastBeforeCMD());
        ret.setForceHeadsetPlug      (getForceHeadsetPlug());
        ret.setVolumeLevelAdjust     (getVolumeLevelAdjust());
        ret.setReverseAudioEvents	 (getReverseAudioEvents());

        return ret;
    }

    /**
     * Getting supported statuses (higher level) Return support status. If status is unspecified by config file, return
     * UNSUPPORTED Return null on error
     */
    public SupportStatus querySupportStatus(DEVICE_TYPE readerType) {
        // return null if argument invalid
        if (readerType == null)
            return null;
        if (readerType == DEVICE_TYPE.IDT_DEVICE_UNKNOWN)
            return null;
        SupportStatus ret = supportStatuses[readerType.ordinal()];
        return ret == null ? SupportStatus.UNSUPPORTED : ret;
    }
}
