package music_shop;

import java.util.concurrent.atomic.AtomicInteger;

public class Instrument {
	
	private String name;
	private MusicInstrument type;
	private Integer price;
	
	Instrument(String name, MusicInstrument type, Integer price){
		this.type = type;
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public MusicInstrument getType() {
		return type;
	}

	public Integer getPrice() {
		return price;
	}
//
//	public void setPrice(int price) {
//		if(price <= 0){
//			this.price = (int)(Math.random() * 10);
//		}else{
//			this.price = price;
//		}
//	}

	@Override
	public String toString() {
		return "\n Instrument:" + name + ", type:" + type + ", price:" + price;
	}
	
	
	
}
