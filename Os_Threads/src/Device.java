public class Device extends Thread {
	private static Router router = new Router();
	private String DeviceName;
	private static Semaphore s;
	private String DeviceType;

	Device() {
		DeviceName = "";
		DeviceType = "";

	}

	Device(String DeviceName, String DeviceType, Semaphore semaphore) {
		this.DeviceName = DeviceName;
		this.DeviceType = DeviceType;
		Device.s = semaphore;

	}

	public void setDeviceName(String DeviceName) {
		this.DeviceName = DeviceName;
	}

	public void setDeviceType(String DeviceType) {
		this.DeviceType = DeviceType;
	}

	public String getDeviceName() {

		return DeviceName;
	}

	public String gettDeviceType() {
		return DeviceType;
	}

	public void run() {

		router.Connect(this);
		router.activity(this);
		router.logOut(this);

	}

	public Semaphore getSemaphore() {
		return s;
	}
}

