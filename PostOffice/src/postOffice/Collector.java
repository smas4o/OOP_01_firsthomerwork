package postOffice;

import java.util.List;

public class Collector extends Postman{

	public Collector(String firstName, String lastName, String address) {
		super(firstName, lastName, address);
	}
	
	@Override
	public void run(){
		while(true){
			while(getPostOffice().getNumberOfMailObjects() > MINIMUM_OF_LETTER){
				synchronized(getPostOffice()){
					try {
						System.out.println("Waiting to go for letters.");
						getPostOffice().wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			System.out.println("I will go for letter.");
			
			for(Mailbox mailbox : getMailboxes()){
				List<Letter> list = mailbox.getAll();
				getPostOffice().addMailObject(list);
				System.out.println("I am giving letters in the post office.");
				synchronized(getPostOffice()){
					getPostOffice().notifyAll();
				}
			}
		}
	}
	@Override
	public int getProcessedMailObjects() {
		return 0;
	}
}
