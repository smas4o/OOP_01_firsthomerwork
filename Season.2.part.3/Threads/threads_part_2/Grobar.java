package threads_part_2;

public class Grobar implements Runnable {
	
	private Thread pytnik;

	public Thread getPytnik() {
		return pytnik;
	}

	public void setPytnik(Thread pytnik) {
		this.pytnik = pytnik;
	}

	@Override
	public void run() {
		System.out.println("Are pyrvo shte go pochakam malko toq da pukne.");
		try {
			pytnik.join(3000);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		System.out.println("Pochvam da rovq");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Hvyrlqm go vytre");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Zarovih go. Ae chao.");
	}
	
}
