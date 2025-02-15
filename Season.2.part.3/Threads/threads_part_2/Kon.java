package threads_part_2;

public class Kon implements Runnable {

	private static final int TIME_TO_RUN_A_METER = 10;
	private static final int METERS_TO_RUN = 90;

	@Override
	public void run() {
		String horseName = Thread.currentThread().getName();
		System.out.println(horseName + " pochna da bqga.");

		for (int meter = 1; meter <= METERS_TO_RUN; meter++) {
			try {
				Thread.sleep(getTimeToRunAMeter());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			System.out.println(horseName + " stigna do " + meter + " meter.");
		}

		System.out.println(horseName + " finishira.");
	}
	
	public int getTimeToRunAMeter() {
		return TIME_TO_RUN_A_METER;
	}
}
