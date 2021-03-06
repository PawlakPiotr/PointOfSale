package Mock;

import Core.DeviceType;
import Core.Output_Logger;

public class Mock_LCD_OutputLogger implements Output_Logger {

	DeviceType type;
	public Mock_LCD_OutputLogger() {
		this.type=DeviceType.LCD;  
	}
	
	@Override
	public DeviceType getDeviceType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public void setDeviceType(DeviceType type_of_device) {
		// TODO Auto-generated method stub
		this.type=type_of_device;
	}

	@Override
	public String handleOutputLogger(String message) {
		// TODO Auto-generated method stub
		String outputMessage = String.format("Printed on LCD:  %s", message);
		System.out.println(outputMessage);
		return outputMessage;
	}

}
