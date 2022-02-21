package AbstractionFactoryPattern;

public class FactoryPattrenDemo {

	public static void main(String[] args) {
			 AbstractFactory shapeFactory = FactoryProducer.getFactory("Shape"); 
	         Shape shape1 = shapeFactory.getShape("CIRCLE");
	         shape1.Draw();
	         Shape shape2 = shapeFactory.getShape("RECTANGLE");
	         shape2.Draw();
	         Shape shape3 = shapeFactory.getShape("SQUARE");
	         shape3.Draw();
	         AbstractFactory colorFactory = FactoryProducer.getFactory("Color");
	         Color color1 = colorFactory.getColor("RED");
	         color1.fill();
	         Color color2 = colorFactory.getColor("Yellow");
	         color2.fill();
	         Color color3 = colorFactory.getColor("BLUE");
	         color3.fill();
	}
}
