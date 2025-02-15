package supermarket;

public class Customer {
	
	private String name;
	private int age;
	private double balance;
	private Product product;

	public Customer(String name, int age, double balance) {
		this.setName(name);
		this.setAge(age);
		this.setBalance(balance);
	}
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(!name.equalsIgnoreCase("") && !name.equalsIgnoreCase(null)){
			this.name = name;
		}
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age <= 0){
			this.age = 0;
		}else{
			this.age = age;
		}
	}
	
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		if(balance <= 0){
			this.balance = 0;
		}else{
			this.balance = balance;
		}
	}
	
	
}
