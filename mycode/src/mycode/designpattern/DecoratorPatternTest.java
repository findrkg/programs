package mycode.designpattern;

public class DecoratorPatternTest {

	public static void main(String[] args) {
		Car basicCar = new BasicCar();
		System.out.println("Basic Car cost : "+basicCar.cost());

		Car sportsCar = new SportsCar(new BasicCar());
		System.out.println("Sports Car cost : "+sportsCar.cost());

		Car luxuryCar = new LuxuryCar(new BasicCar());		
		System.out.println("Luxury Car cost : "+luxuryCar.cost());

		Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));		
		System.out.println("Sports Luxury Car cost : "+sportsLuxuryCar.cost());
	}

}

interface Car {

	public int cost();
}

class BasicCar implements Car {

	@Override
	public int cost() {
		return 100;
	}

}

class CarDecorator implements Car {

	protected Car car;

	public CarDecorator(Car c) {
		this.car = c;
	}

	@Override
	public int cost() {
		return this.car.cost();
	}
}

class SportsCar extends CarDecorator {

	public SportsCar(Car c) {
		super(c);
	}

	@Override
	public int cost() {
		return super.cost() + 100;
	}
}

class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car c) {
		super(c);
	}
	
	@Override
	public int cost(){
		return super.cost() + 200;
	}
}