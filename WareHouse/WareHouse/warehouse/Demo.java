package warehouse;

public class Demo {

	public static void main(String[] args) {
		
		IShoppingCenter warehouse = new WareHouse();
		
		Shop[] shops = new Shop[3];
		for(int i = 0; i < 3; i++){
			shops[i] = new Shop(warehouse);
		}
		
		//znam che e grozno
		for(int index = 1; index <= 3; index++){
			
			Thread supplier = new Thread(new Supplier(warehouse));
			supplier.start();
			int count = 0;
			
			for(int i = 0; i < 9; i++){
				switch(count){
				case 0:
				case 1:
				case 2:
					new Thread(new Client(shops[0], supplier)).start();
				case 3:
				case 4:
				case 5:
					new Thread(new Client(shops[1], supplier)).start();
				case 6:
				case 7:
				case 8:
					new Thread(new Client(shops[2], supplier)).start();
				
				}
				count++;
			}
		}
		
	}
}
