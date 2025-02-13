package threads_part_1;

public class Demo {
	public static void main(String[] args) throws InterruptedException {

		// when extending Thread class
		Thread1 thread1 = new Thread1();
		thread1.setPriority(Thread.MIN_PRIORITY);

		// when implementing Runnable interface
		Thread thread2 = new Thread(new Thread2(), "Gosho");
		thread2.setPriority(Thread.MAX_PRIORITY);
		
//		Thread.sleep(2300);

//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				for (int i = 1; i < 10; i++) {
//					System.out.println("Eto ti nishka s anonimen class. Ae chestito." + i);
//				}
//			}
//		}).start();

		Thread t = new Thread(() -> {
			for (int i = 1; i <= 20; i++)
				System.out.println("Ei ti neshto s lmbda izraz paralelno." + i);
		});
		t.start();

		// start to work in parallel
		thread1.start();
		thread2.start();
		
		System.out.println("In main thread.");
//		thread1.daPrikluchvamLi = true;
		
	}
}
