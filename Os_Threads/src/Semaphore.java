public class Semaphore {
	private int wifi;
	Semaphore()
	    {
	        wifi =0;
	    }
	
	Semaphore(int initial)
    {
        wifi = initial;
    }
	 public int getwifi()
	 {
		 return wifi;
	 }
	
	 public synchronized boolean p() {
			wifi--;		
		try {
		if (wifi<0) { 
			
			wait();
			return true;
			}

			} catch (InterruptedException e) {
				e.printStackTrace();
		}
		return false;
			
	 }
	 public synchronized void v() {
		 wifi++;
		 try {
			if (wifi<=0) {                 
			notify();
				 
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
}
