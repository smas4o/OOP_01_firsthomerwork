package music_shop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Shop implements IShop {
	private static final int STARTING_QUANTITY = 10;
	
	Map<Instrument, Integer> products = new HashMap<Instrument, Integer>();
	
	private int money;
	
	Shop(){
		for(String instrumentName : new String[] { "violin", "viola", "contrabass", "harp", "guitar", "gadoulka", "tambura", "violoncello"}){
			products.put(new Instrument(instrumentName, MusicInstrument.STRINGS, (int)(Math.random() * 1000)), (int)(Math.random()*10 + 1));
		}
		for(String instrumentName : new String[] { "drums", "timpani", "tarambuka", "congas", "xylophone", "vibraphone", "claves", "maracas", "clapper"}){
			products.put(new Instrument(instrumentName, MusicInstrument.PERCUSSIVE, (int)(Math.random() * 1000)), (int)(Math.random()*10 + 1));
		}
		for(String instrumentName : new String[] { "bagpipe", "waldhorn", "saxophone", "trombone", "tuba", "flugelhorn", "oboe", "clarinet", "pipe"}){
			products.put(new Instrument(instrumentName, MusicInstrument.BRASS, (int)(Math.random() * 1000)), (int)(Math.random()*10 + 1));
		}
		for(String instrumentName : new String[] { "piano", "organ", "grand piano", "accordion", "spinet", "bandoneon"}){
			products.put(new Instrument(instrumentName, MusicInstrument.KEYBOARDS, (int)(Math.random() * 1000)), (int)(Math.random()*10 + 1));
		}
		for(String instrumentName : new String[] { "synthesizer", "electric guitar", "bass guitar", "electric violin"}){
			products.put(new Instrument(instrumentName, MusicInstrument.ELECTRONIC, (int)(Math.random() * 1000)), (int)(Math.random()*10 + 1));
		}
		this.money = (int) (Math.random() * 3000 - 2000);
		
	}
	
	@Override
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
	
	@Override
	public void addInstrument(Instrument instrument, int quantity) throws ShopException{
		if(instrument != null && quantity > 0 && products.containsKey(instrument)){
			int newQuantity = products.get(instrument);
			newQuantity += quantity;
			products.put(instrument, newQuantity);
		}else{
			throw new ShopException("Can't add that instrument right now!");
		}
	}
	
	@Override
	public void sortedByType(){
		List<Map.Entry<Instrument, Integer>> entryList = new ArrayList<Map.Entry<Instrument, Integer>>(products.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<Instrument, Integer>>(){
			@Override
			public int compare(Map.Entry<Instrument, Integer> instrument1, Map.Entry<Instrument, Integer> instrument2){
				return instrument1.getKey().getType().compareTo(instrument2.getKey().getType());
			}
		});
		System.out.println(entryList.toString());
	}
	
	@Override
	public void sortedByName(){
		List<Map.Entry<Instrument, Integer>> entryList = new ArrayList<Map.Entry<Instrument, Integer>>(products.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<Instrument, Integer>>(){
			@Override
			public int compare(Map.Entry<Instrument, Integer> instrument1, Map.Entry<Instrument, Integer> instrument2){
				return instrument1.getKey().getName().compareTo(instrument2.getKey().getName());
			}
		});
		System.out.println(entryList.toString());
	}
	
	@Override
	public void sortedByPrice(){
		List<Map.Entry<Instrument, Integer>> entryList = new ArrayList<Map.Entry<Instrument, Integer>>(products.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<Instrument, Integer>>(){
			@Override
			public int compare(Map.Entry<Instrument, Integer> instrument1, Map.Entry<Instrument, Integer> instrument2){
				return (instrument1.getKey().getPrice()).compareTo(instrument2.getKey().getPrice());
			}
		});
		System.out.println(entryList.toString());
	}
	
	@Override
	public void availableInstruments(){
		List<Map.Entry<Instrument, Integer>> entryList = new ArrayList<Map.Entry<Instrument, Integer>>(products.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<Instrument, Integer>>(){
			@Override
			public int compare(Map.Entry<Instrument, Integer> instrument1, Map.Entry<Instrument, Integer> instrument2){
				return (instrument1.getValue()).compareTo(instrument2.getValue());
			}
		});
		System.out.println(entryList.toString());
	}
}
