import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Router {
	Random rand;

	public void printIntoFile(String output) {
		try {
			FileWriter printer = new FileWriter("last.txt", true);
			printer.write(output);
			printer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Connect(Device device) {

		if (device.getSemaphore().p() == true) {

			printIntoFile(device.getDeviceName() + "(" + device.gettDeviceType() + ")" + " arrived and waiting \n");

		} else {
			printIntoFile("(" + device.getDeviceName() + ")(" + device.gettDeviceType() + ")" + " arrived \n");
		}

		try {
			rand = new Random();
			Thread.sleep(rand.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		printIntoFile("Connection :" + device.getDeviceName() + " Occupied \n");
	}

	public void activity(Device device) {
		try {
			rand = new Random();
			Thread.sleep(rand.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		printIntoFile("Connection :" + device.getDeviceName() + " Performs online activity \n");

	}

	public void logOut(Device device) {
		device.getSemaphore().v();
		try {
			rand = new Random();
			Thread.sleep(rand.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		printIntoFile("Connection :" + device.getDeviceName() + "  logged out \n");

	}

}
