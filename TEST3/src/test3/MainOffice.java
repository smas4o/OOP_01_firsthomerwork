package test3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainOffice {
	
	private String name;
	Map<CityName, List<Pratka>> pratkiZaOfisite = new TreeMap<CityName, List<Pratka>>();
	Map<Client, List<Protocol>> protokoli = new HashMap<Client, List<Protocol>>();
	
	public MainOffice(){
		this.name = "Veliko Turnovo";
		pratkiZaOfisite.put(CityName.SOFIA, new LinkedList<Pratka>());
		pratkiZaOfisite.put(CityName.PLOVDIV, new LinkedList<Pratka>());
		pratkiZaOfisite.put(CityName.VARNA, new LinkedList<Pratka>());
		pratkiZaOfisite.put(CityName.RUSE, new LinkedList<Pratka>());
	}
	
	public String getName() {
		return name;
	}

	public int returnNumberOfPackages(CityName cityName){
		int size = 0;
		if(pratkiZaOfisite.containsKey(cityName)){
			if(pratkiZaOfisite.get(cityName).size() > 0){
				size = pratkiZaOfisite.get(cityName).size() ;
			}
		}
		return size;
	}
	
	public void addPratka(List<Pratka> pratkiOtOfisite){
		List list = pratkiOtOfisite;
		Iterator it = list.iterator();
		if(pratkiOtOfisite != null){
			synchronized(pratkiZaOfisite){
				while(it.hasNext()){
					Pratka pratkaZaDobavqne = (Pratka) it.next();
					if(pratkiZaOfisite.containsKey(pratkaZaDobavqne.getPoluchatel().getCity())){
						pratkiZaOfisite.get(pratkaZaDobavqne.getPoluchatel().getCity()).add(pratkaZaDobavqne);
					}
				}
			}
		}
	}
	
	public List<Pratka> sendPratki(CityName cityName){
		synchronized(pratkiZaOfisite){
			List<Pratka> pratkiZaIzprashtane = null;
			if(pratkiZaOfisite.get(cityName).size() > 0){
				pratkiZaIzprashtane.addAll(pratkiZaOfisite.get(cityName));
				pratkiZaOfisite.get(cityName).removeAll(pratkiZaIzprashtane);
			}
			return pratkiZaIzprashtane;
		}
	}

}