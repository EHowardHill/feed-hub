package IDTechSDK;

public interface InterfaceControllable {
	int device_controlUserInterface(byte[] values);

	int device_controlIndicator(int indicator, int enable);
}
