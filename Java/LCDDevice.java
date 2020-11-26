package IDTechSDK;

public interface LCDDevice {
	int ctls_displayOnlineAuthResult(int isOK, byte[] TLVs);
	
	int lcd_resetInitialState();
	
	int lcd_customDisplayMode(int enable);
	
	int lcd_setForeBackColor(byte[] foreRGB, byte[] backRGB);
	
	int lcd_clearDisplay();
	
	int lcd_captureSignature(int timeout);
	
	int lcd_startSlideShow(String files, int posX, int posY, int posMode, int touchEnable, int recursion, int touchTerminate, int delay, int loops, int clearScreen);
	
	int lcd_setDisplayImage(String file, int posX, int posY, int posMode, int touchEnable, int clearScreen);
	
	int lcd_setBackgroundImage(String file, int enable);
}
