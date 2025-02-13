package test3;

import java.util.List;

public class Staff extends Client implements Runnable{
	
	private final static int MIN_NUMBER_FOR_SENDING = 5;
	private CityOffice cityOffice;
	private int numberOfPackagesForSending;
	private Client poluchatel;
	
	public Staff(String name, String gsm, long number, String address, CityOffice cityOffice) throws ClientException {
		super(name, gsm, number, address, cityOffice.getName());
		this.cityOffice = cityOffice;
	}
	
	public Staff(String name, String gsm, long number, String address, CityOffice cityOffice, Client poluchatel) throws ClientException {
		super(name, gsm, number, address, cityOffice.getName());
		this.cityOffice = cityOffice;
		this.poluchatel = poluchatel;
	}

	@Override
	public void run() {
		synchronized(cityOffice){
			try{
				System.out.println("Poluchih paket.");
				sendPackage();
				System.out.println("Dadoh go da se izprati do centralen.");
			}catch(CityOfficeException | ClientException e){
				e.printStackTrace();
			}
		}
		
		while(true){
			if(cityOffice.getNumberOfPachagesFromCentral() >= MIN_NUMBER_FOR_SENDING){
				synchronized(cityOffice){
					List<Pratka> pratkiZaKlienti = cityOffice.sendToReceiver();
					for(Pratka p : pratkiZaKlienti){
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("Predavam pratka do " + p.getPoluchatel());
					}
				}
			}
		}
	}

	private void sendPackage() throws ClientException, CityOfficeException {
		Client podatel = new Client("Ivan Ivanov", "0898789789", 9105056565l, "ulica 'purva' nomer 9", this.getCity());
		Pratka pratka = null;
		if(this.poluchatel != null){
			pratka = new Pratka(podatel, this.poluchatel, "some stuff");
			cityOffice.addPratka(pratka);
			cityOffice.createProtocol(pratka.getPodatel(), this);
		}else{
			throw new ClientException("Ne moga da prata prataka bez poluchatel.");
		}
		System.out.println(pratka);
	}

	public CityOffice getCityOffice() {
		return cityOffice;
	}
	
}
