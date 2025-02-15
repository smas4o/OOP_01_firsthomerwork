package music_shop;

public interface IShop {

	void sellInstrument(Instrument instrument, int quantity) throws ShopException;

	void addInstrument(Instrument instrument, int quantity) throws ShopException;

	void sortedByType();

	void sortedByName();

	void sortedByPrice();

	void availableInstruments();
	
	public void soldInstruments(Instrument instrument, int quantity);

	void soldInstruments();
	
	public void countMoney(int newAmount);

	void mostSellInstrument();

	void mostUnselledInstrument();

}