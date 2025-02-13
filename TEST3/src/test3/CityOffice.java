package test3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CityOffice {
	
	private CityName name;
	private Map<Client, List<Protocol>> protokoli = new HashMap<Client, List<Protocol>>();
	private List<Pratka> pratkiZaGlaven = new LinkedList<Pratka>();
	private List<Pratka> pratkiOtGlaven = new LinkedList<Pratka>();
	
	public CityOffice(CityName name) {
		this.name = name;
	}
	
	public CityName getName() {
		return name;
	}

	public void addPratka(Pratka pratka) throws CityOfficeException{
		if(pratka == null){
			throw new CityOfficeException("Ne moje da izpratite takava pratka!");
		}
		synchronized(pratkiZaGlaven){
			pratkiZaGlaven.add(pratka);
		}
	}
	
	public void createProtocol(Client sender, Client receiver){
		synchronized(protokoli){
			Protocol protokol = new Protocol(sender, receiver);
			if(!protokoli.containsKey(sender)){
				protokoli.put(sender, new LinkedList<Protocol>());
			}else{
				protokoli.get(sender).add(protokol);
			}
		}
	}

	public List<Pratka> getAll(){
		List<Pratka> zaCentralen = new LinkedList<Pratka>();
		synchronized(pratkiZaGlaven){
			zaCentralen.addAll(pratkiZaGlaven);
			pratkiZaGlaven.clear();
		}
		return zaCentralen;
	}
	
	public List<Pratka> sendToReceiver(){
		List<Pratka> zaPoluchateli = new LinkedList<Pratka>();
		synchronized(pratkiOtGlaven){
			zaPoluchateli.addAll(pratkiOtGlaven);
			pratkiOtGlaven.clear();
		}
		return zaPoluchateli;
	}
	
	public void addPratki(List<Pratka> prakti){
		if(prakti != null){
			synchronized(pratkiOtGlaven){
				pratkiOtGlaven.addAll(prakti);
			}
		}
	}
	
	public int getNumberOfPackages(){
		return pratkiZaGlaven.size();
	}
	
	public int getNumberOfPachagesFromCentral(){
		return pratkiOtGlaven.size();
	}
	
}
