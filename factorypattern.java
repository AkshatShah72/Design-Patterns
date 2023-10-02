 interface Computer {
    

	double price();
	String brand();
	String name();
	String details();
}
 class Dell implements Computer{
	
	private double price = 500;
	private String brand = "Dell";
	private String name = "Vostro 3000";

	@Override
	public double price() {
		return this.price;
	}

	@Override
	public String brand() {
		return this.brand;
	}

	@Override
	public String name() {
		return this.name;
	}

	@Override
	public String details() {
		return "Name: "+ this.name() + "\t Brand: "+this.brand() + "\t Price: "+this.price()+" USD";
	}

}
 class Hp implements Computer{
	private double price = 700;
	private String brand = "Hp";
	private String name  = "Spectre x360 ";

	@Override
	public double price() {
		return this.price;
	}

	@Override
	public String brand() {
		return this.brand;
	}

	@Override
	public String name() {
		return this.name;
	}

	@Override
	public String details() {
		return "Name: "+ this.name() + "\t Brand: "+this.brand() + "\t Price: "+this.price()+" USD";
	}
}
 class MacBook implements Computer{
	private double price = 1100;
	private String brand = "Apple";
	private String name  = "Macbook pro ";

	@Override
	public double price() {
		return this.price;
	}

	@Override
	public String brand() {
		return this.brand;
	}

	@Override
	public String name() {
		return this.name;
	}

	@Override
	public String details() {
		return "Name: "+ this.name() + "\t Brand: "+this.brand() + "\t Price: "+this.price()+" USD";
	}
}
 class Factory {
	public Computer getComputer(String type) {
		
		if(type.equalsIgnoreCase("Dell")) {
			return new Dell();
		} 
		
		if(type.equalsIgnoreCase("Hp")) {
			return new Hp();
		} 
		
		if(type.equalsIgnoreCase("Macbook")) {
			return new MacBook();
		} 
		
		return null;
	}
}
  class Main {

	public static void main(String[] args) {
		
		Factory factory = new Factory();
		
		// products
		Computer dell = factory.getComputer("dell");
		Computer hp = factory.getComputer("hp");
		Computer macbook = factory.getComputer("macbook");
		
		// Display output
		System.out.println("--------------- computer details ---------------");
		System.out.println(dell.details());
		System.out.println(hp.details());
		System.out.println(macbook.details());
	}
}


