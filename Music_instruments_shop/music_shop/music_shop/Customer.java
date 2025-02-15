package music_shop;

public class Customer implements Runnable{
	
	private IShop shop;
	
	Customer(IShop shop){
		this.shop = shop;
	}
	
	public void run() {
		try{
			Thread.sleep(1000);
			
			int quantity = (int) (Math.random() * 5);
			int number = (int) (Math.random() * 15);
			Instrument product = null;
			switch(number){
			case 0:
				product = new Instrument("violin");
				break;
			case 1:
				product = new Instrument("viola");
				break;
			case 2:
				product = new Instrument("contrabass");
				break;
			case 3:
				product = new Instrument("drums");
				break;
			case 4:
				product = new Instrument("timpani");
				break;
			case 5: 
				product = new Instrument("tarambuka");
				break;
			case 6:
				product = new Instrument("bagpipe");
				break;
			case 7:
				product = new Instrument("waldhorn");
				break;
			case 8:
				product = new Instrument("saxophone");
				break;
			case 9:
				product = new Instrument("piano");
				break;
			case 10:
				product = new Instrument("organ");
				break;
			case 11:
				product = new Instrument("grand piano");
				break;
			case 12:
				product = new Instrument("synthesizer");
				break;
			case 13:
				product = new Instrument("electric guitar");
				break;
			case 14:
				product = new Instrument("bass guitar");
				break;
			}
			System.out.println("I am going to buy " + product.getName());
			this.shop.sellInstrument(product, quantity);
			System.out.println("I have bought " + product.getName());
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
