package threads_part_4_more_on_threads;

public class Account implements IAccount {

	private Integer balance;
	private String name = "Stratilatka";
	private static String bankName = "KTB - moita banka"; 

	
	
	public static String getBankName() {
		return bankName;
	}

	public static void setBankName(String bankName) {
		synchronized (Account.bankName) {
			Account.bankName = bankName;
		}
	}

	public Account(int balance) {
		if (balance > 0) {
			this.balance = balance;
		} else {
			this.balance = 50;
		}
	}

	@Override
	public void withdraw(int sum) {
		System.out.println("Suma predi teglene : " + this.balance);

		synchronized (this.balance) {
			synchronized (this.name) {
				System.out.println("Pochvam da teglq ot " + this.name);
				this.name = "Pesho " + sum;
				if (balance >= sum) {
					try {
						Thread.sleep(100);
						balance -= sum;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Suma sled teglene : " + balance);
				} else {
					System.out.println("Sorry ama nqma pari. Ae chao.");
				}
			}
		}
		System.out.println("Izteglih!");
	}

	synchronized void printSum() {
		System.out.println(this.balance);
	}
	
	

}
