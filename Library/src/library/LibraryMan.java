package library;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class LibraryMan extends Thread {
	
	private static final double PERCENT = 100.0;
	private static final int TIME_TO_WAIT = 1000;
	private Map<ReadingMaterial, Double> materialsToFollow;
	
	public LibraryMan(){
		this.setDaemon(true);
		materialsToFollow = new HashMap<ReadingMaterial, Double>();
	}
	
	public int getNumberOfTakenMaterials(){
		return materialsToFollow.size();
	}
	
	public SortedSet<ReadingMaterial> getMaterialsByDateTaken(){
		TreeSet<ReadingMaterial> set 
			= new TreeSet<ReadingMaterial>(
						(r1,r2) -> r1.getTimeTaken().compareTo(r2.getTimeTaken()));
		set.addAll(materialsToFollow.keySet());
		return set;
	}
	
	public SortedSet<ReadingMaterial> getMaterialsOverdue(){
		TreeSet<ReadingMaterial> set 
			= new TreeSet<ReadingMaterial>(
						(r1,r2) -> materialsToFollow.get(r1).compareTo(materialsToFollow.get(r2)));
		set.addAll(materialsToFollow.keySet());
		return set;
	}
	
	@Override
	public void run(){
		while(true){
			try {
				Thread.sleep(TIME_TO_WAIT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for(ReadingMaterial r : materialsToFollow.keySet()){
				try {
					int secForThisBook = r.getSecondsForTake();
					LocalDateTime time = r.getTimeTaken();
					Duration d = Duration.between(time, LocalDateTime.now());
					if(d.getSeconds() > secForThisBook){
						int sec = (int) (d.getSeconds() - secForThisBook);
						Double money = ((PERCENT + (double)sec)/PERCENT) * r.getPrice();
						synchronized(materialsToFollow){
							materialsToFollow.put(r, money);
						}
					}
				} catch (LibraryException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void addMaterialToWatch(ReadingMaterial readingMaterial){
		try {
			synchronized(materialsToFollow){
				materialsToFollow.put(readingMaterial, readingMaterial.getPrice());
			}
		} catch (LibraryException e) {
			e.printStackTrace();
		}
	}
	
	public Double getHowMuchIHaveToPayForThis(ReadingMaterial rm){
		return materialsToFollow.get(rm);
	}
	
	public void removeMaterialToWatch(ReadingMaterial readingMaterial){
		if(readingMaterial != null && materialsToFollow.containsKey(readingMaterial)){
			synchronized(materialsToFollow){
				materialsToFollow.remove(readingMaterial);
			}
		}
	}
}
