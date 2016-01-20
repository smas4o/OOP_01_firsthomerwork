package test.task.vignette;

import java.text.ParseException;
import java.util.Random;

public class DemoProgram {

	private static final int MAX_OWNED_VENCHILES_PER_DRIVER = 10;

	public static void main(String[] args) throws ParseException {
		
		GasStation omv = new GasStation("OMV");
		
//		omv.printVignette();
		
		Driver[] drivers = new Driver[20];
		
		createDrivers(drivers, omv);
		
		Venchile[] venchiles = new Venchile[200];
		
		createVenchiles(venchiles);
		
		for(int i = 0; i < drivers.length; i++){
			System.out.println(drivers[i].getName() + " "+ drivers[i].getMoney());
		}
		
//		displayInfo(venchiles);
		
		
		addVenchiles(drivers[0], venchiles, 0, 10);
		addVenchiles(drivers[1], venchiles, 10, 20);
		addVenchiles(drivers[2], venchiles, 20, 30);
		addVenchiles(drivers[3], venchiles, 30, 40);
		addVenchiles(drivers[4], venchiles, 40, 50);
		addVenchiles(drivers[5], venchiles, 50, 60);
		addVenchiles(drivers[6], venchiles, 60, 70);
		addVenchiles(drivers[7], venchiles, 70, 80);
		addVenchiles(drivers[8], venchiles, 80, 90);
		addVenchiles(drivers[9], venchiles, 90, 100);
		addVenchiles(drivers[10], venchiles, 100, 110);
		addVenchiles(drivers[11], venchiles, 110, 120);
		addVenchiles(drivers[12], venchiles, 120, 130);
		addVenchiles(drivers[13], venchiles, 130, 140);
		addVenchiles(drivers[14], venchiles, 140, 150);
		addVenchiles(drivers[15], venchiles, 150, 160);
		addVenchiles(drivers[16], venchiles, 160, 170);
		addVenchiles(drivers[17], venchiles, 170, 180);
		addVenchiles(drivers[18], venchiles, 180, 190);
		addVenchiles(drivers[19], venchiles, 190, 200);
		
		
//		for(int i = 0; i < drivers.length; i++){
//			drivers[i].displayVenchiles();
//			System.out.println();
//		}
		
		System.out.println();
		
//		System.out.println("The starting turnover for today is " + omv.getTurnoverForToday() + ".");
		
		System.out.println();
		
		purchaseVignettes(drivers);
		
		System.out.println();
		
		for(int i = 0; i < drivers.length; i++){
			drivers[i].displayVenchiles();
			System.out.println();
		}
		
		System.out.println("The final turnonver for today is " + omv.getTurnoverForToday() + ".");
		
		System.out.println();
		
		omv.printVignette();
		
		
	}
	
	//dobavqne na prevozni sredstva na shofiorite,
	//sushto kato dolniq metod ne mnogo random :\
	static void addVenchiles(Driver drivers, Venchile[] venchiles, int firstIndex, int lastIndex){
		for(int i = firstIndex; i < lastIndex; i++){
			drivers.addVenchiles(venchiles[i]);
		}
	}
	
	//metod za printirane na vsichki suzdadeni prevozni sredstva,
	//ne mnogo random :/
	static void displayInfo(Venchile[] venchiles){
		for(Venchile v : venchiles){
			if(v != null){
				Class<? extends Venchile> c = v.getClass();
				if(c.equals(Car.class)){
					System.out.println(v.getModel() + " " + v.getYear());
				}else if(c.equals(Truck.class)){
					System.out.println(v.getModel() + " " + v.getYear());
				}else if(c.equals(Autobus.class)){
					System.out.println(v.getModel() + " " + v.getYear());
				}
			}
		}
	}
	
	//metod za suzdavane na prevozni sredstva
	private static void createVenchiles(Venchile[] venchiles) {
		int index = 0;
		for(int i = 0; i < venchiles.length; i++){
			if(i % 3 == 0){
				index = i;
			}
			if(i - index == 0){
				venchiles[i] = new Car("Car" + i, (int)(Math.random() * (2015 - 1970) + 1970));	
			}else if(i - index == 1){
				venchiles[i] = new Truck("Truck" + i, (int)(Math.random() * (2015 - 1970) + 1970));
			}else if(i - index == 2){
				venchiles[i] = new Autobus("Autobus" + i, (int)(Math.random() * (2015 - 1970) + 1970));
			}
		}
	}
	
	//metod za suzdavane na shofior
	static void createDrivers(Driver[] drivers, GasStation gasStation){
		for(int i = 0; i < drivers.length; i++){
			drivers[i] = new Driver("Driver" + i, (int)(Math.random() * (20000 - 10000) + 10000), gasStation);
		}
	}
	
	//metod za kupuvane na vinetki po uslovie?!
	static void purchaseVignettes(Driver[] drivers) throws ParseException{
		for(int i = 0; i < drivers.length; i++){
			if(i % 3 == 0){
				int count = 0;
				int days = 0;
				while(count < 5){
					for(int j = 0; j < MAX_OWNED_VENCHILES_PER_DRIVER; j+=2){
						if(count < 2){
							days = 7;
						}else if(count == 2){
							days = 31;
						}else if(count > 2){
							days = 365;
						}
						
						drivers[i].buyVignette(j,days);
						count++;
					}
				}
			}else{
				int count = 0;
				int days = 0;
				for(int j = 0; j < MAX_OWNED_VENCHILES_PER_DRIVER; j++){
					if(count < 3){
						days = 7;
					}else if(count >= 3 && count <= 6){ //tuk neshto zabiva i mi dava null
						days = 31;
					}else if(count < MAX_OWNED_VENCHILES_PER_DRIVER){
						days = 365;
					}
					drivers[i].buyVignette(j, days);
					count++;
				}
			}
		}
	}
	
	//napravih gi za vseki sluchai no mi krashvaha i za momenta sum gi zakomentiral
	//generirane na proizvolni prevozni sredstva
//	static int generateRandomVenchile() {
//		return (int)(Math.random() * (9 - 1) + 1);
//	}
	
	//generirane na proizvolni dni za vinetkata
//	static int generateDays(){
//		int days = (int)(Math.random() * (365 - 7) + 7);
//		if(days <= 15){
//			days = 7;
//		}else if(days > 15 && days <= 30){
//			days = 30;
//		}else if(days > 30){
//			days = 365;
//		}
//		return days;
//	}
}
