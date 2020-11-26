package IDTechSDK;

public interface StorageDevice {
	int device_getDriveFreeSpace(MutableInteger free, MutableInteger used);
	
	int device_listDirectory(String directoryName, int recursive, int onSD, StringBuilder directories);
	
	int device_createDirectory(String directoryName);
	
	int device_deleteDirectory(String directoryName);
	
	int device_transferFile(String fileName, byte[] file);
	
	int device_deleteFile(String fileName);
}
