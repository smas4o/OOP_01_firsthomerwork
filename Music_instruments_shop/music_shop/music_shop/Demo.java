package music_shop;

public class Demo {

		public static void main(String[] args) {
			IShop shop = new Shop();
			
			shop.sortedByType();
			shop.sortedByName();
			shop.sortedByPrice();
			shop.availableInstruments();
		}
		
	

}
