
import java.util.ArrayList;
import java.util.Scanner;

public class Network {
      
    int numDevice;
    int wifiConnection;
    ArrayList<Device>Devices=new ArrayList<Device>();
    
    public void main(){
    	
    Scanner in =new Scanner(System.in);
    int wifiConnection;
    int numDevice;
    String DeviceName="";
    String DeviceType="";
    
    System.out.println("What is number of WI-FI Connections? ");
    wifiConnection=in.nextInt();
    setWifiConnection(wifiConnection);
    
   Semaphore y=new Semaphore(wifiConnection);
    
    
    System.out.println("What is number of devices Clients want to connect?");
    numDevice=in.nextInt();
   setNumDevice(numDevice);
   
   
    for(int i=0;i<getNumDevice();i++){
        DeviceName=in.next(); 
        DeviceType=in.next();
    	Device d=new Device(DeviceName,DeviceType,y);
    	Devices.add(d);

    }
    
   for (int i=0;i<Devices.size();i++) { 
	   try {
		Thread.sleep(10);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    Devices.get(i).start();
    }
    
    }
     public void setWifiConnection(int wifiConnection) {
        this.wifiConnection = wifiConnection;
    }
     public int getWifiConnection() {
        return wifiConnection;
    }
    public void setNumDevice(int numDevice) {
        this.numDevice = numDevice;
    }
    public int getNumDevice() {
        return numDevice;
    }

}
