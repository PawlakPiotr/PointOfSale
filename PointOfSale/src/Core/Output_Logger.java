package Core;

public interface Output_Logger {

	DeviceType getDeviceType();
	void setDeviceType(DeviceType type_of_device);
	String handleOutputLogger(String message);
	
}
