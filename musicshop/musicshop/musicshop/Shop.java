package musicshop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Shop {
	private static final int STARTING_QUANTITY = 10;
	
	Map<Instrument, Integer> products = new HashMap<Instrument, Integer>();
	
	private int money;
	
	Shop(){
		for(String instrumentName : new String[] { "violin", "viola", "contrabass", "harp", "guitar", "gadoulka", "tambura", "violoncello"}){
			products.put(new Instrument(instrumentName, MusicInstrument.STRINGS, (int)(Math.random() * 1000)), STARTING_QUANTITY);
		}
		for(String instrumentName : new String[] { "drums", "timpani", "tarambuka", "congas", "xylophone", "vibraphone", "claves", "maracas", "clapper"}){
			products.put(new Instrument(instrumentName, MusicInstrument.PERCUSSIVE, (int)(Math.random() * 1000)), STARTING_QUANTITY);
		}
		for(String instrumentName : new String[] { "bagpipe", "waldhorn", "saxophone", "trombone", "tuba", "flugelhorn", "oboe", "clarinet", "pipe"}){
			products.put(new Instrument(instrumentName, MusicInstrument.BRASS, (int)(Math.random() * 1000)), STARTING_QUANTITY);
		}
		for(String instrumentName : new String[] { "piano", "organ", "grand piano", "accordion", "spinet", "bandoneon"}){
			products.put(new Instrument(instrumentName, MusicInstrument.KEYBOARDS, (int)(Math.random() * 1000)), STARTING_QUANTITY);
		}
		for(String instrumentName : new String[] { "synthesizer", "electric guitar", "bass guitar", "electric violin"}){
			products.put(new Instrument(instrumentName, MusicInstrument.ELECTRONIC, (int)(Math.random() * 1000)), STARTING_QUANTITY);
		}
		this.money = (int) (Math.random() * 3000 - 2000);
		
	}
	
	public void sellInstrument(Instrument instrument, int quantity, int money) throws ShopException{
		if(instrument != null && quantity > 0 && products.containsKey(instrument) && products.get(instrument) > 0){
			int newQuantity = products.get(instrument);
			newQuantity -= quantity;
			products.put(instrument, newQuantity);
			this.money += instrument.getPrice() * quantity;
		}else{
			throw new ShopException("The instrument is out of stock!");
		}
	}
	
	public void addInstrument(Instrument instrument, int quantity) throws ShopException{
		if(instrument != null && quantity > 0 && products.containsKey(instrument)){
			int newQuantity = products.get(instrument);
			newQuantity += quantity;
			products.put(instrument, newQuantity);
		}else{
			throw new ShopException("Can't add that instrument right now!");
		}
	}
	
	public void SortedByType(){
		Set set = products.entrySet();
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			Map.Entry entry = (Map.Entry) iter.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			System.out.println(key + " => " + value);
		}
	}
}
