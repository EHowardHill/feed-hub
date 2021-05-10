import IDTechSDK.ICCReaderStatusStruct;
import IDTechSDK.IDTEMVData;
import IDTechSDK.IDTMSRData;
import IDTechSDK.IDT_UniPayIII;
import IDTechSDK.IDTechSDKBridge;
import IDTechSDK.OnReceiverListener;
import IDTechSDK.ReaderInfo;
import IDTechSDK.ResDataStruct;
import IDTechSDK.StructConfigParameters;

public Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("\tLogging Level " + args[0]);
            IDTechSDK.IDTechSDKBridge.enableLogging(Integer.valueOf(args[0]));
        }
        OnReceiverListenerImp MessageCallBack = new OnReceiverListenerImp();
        device = new IDT_UniPayIII(MessageCallBack);
    }

    static class OnReceiverListenerImp implements OnReceiverListener {
        public void swipeMSRData(IDTMSRData card) {
        }
        public void lcdDisplay(int mode, String[] lines, int timeout) {
        }
        public void emvTransactionData(IDTEMVData emvData) {
        }
        public void deviceConnected() {
        }
        public void deviceDisconnected() {
        }
        public void timeout(int errorCode) {
        }
        public void dataInOutMonitor(byte[] data, boolean isIncoming) {
        }
    }        
}