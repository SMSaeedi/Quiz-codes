package AbstractionFactoryPattern;

public class ColorFactory extends AbstractFactory{
	@Override
	Color getColor(String color) {
		if(color==null){return null;}
		if(color.equalsIgnoreCase("Red")){return new Red();}
		if(color.equalsIgnoreCase("Blue")){return new Blue();}
		if(color.equalsIgnoreCase("Yellow")){return new Yellow();}
		return null;
	}
	@Override
	Shape getShape(String shape) {
		return null;
	}
}
