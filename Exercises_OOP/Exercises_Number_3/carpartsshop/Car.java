package carpartsshop;

public class Car {
	
	String name;
	int yearOfManifacturing;
	int month;
	
	
	public Car(String name, int yearOfManifacturing, int month){
		this.setName(name);
		this.setYearOfManifacturing(yearOfManifacturing);
		this.setMonth(month);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public int getYearOfManifacturing() {
		return yearOfManifacturing;
	}
	public void setYearOfManifacturing(int yearOfManifacturing) {
		if(yearOfManifacturing > 1975 && yearOfManifacturing < 2016){
			this.yearOfManifacturing = yearOfManifacturing;
		}
	}
	
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(month > 0 && month < 13){
			this.month = month;
		}
	}
	
}
