interface Shape{
    void draw();
}

class Circle implements Shape{
    public void draw(){
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape{
    public void draw(){
        System.out.println("Drawing Rectangle");
    }
}

class Square implements Shape{
    public void draw(){
        System.out.println("Drawing Square");
    }
}

class ShapeFactory{
    public Shape getShape(String shapeType){
        if(shapeType == null)
            return null;

        switch (shapeType.toLowerCase()) {
            case "circle":
                return new Circle();

            case "rectangle":
                return new Rectangle();

            case "square":
                return new Square();
            default:
                return null;
        }
    }
}

public class Main{
    public static void main(String[] args){
        ShapeFactory factory = new ShapeFactory();
        Shape s1 = factory.getShape("Circle");
        s1.draw();

        Shape s2 = factory.getShape("Rectangle");
        s2.draw();

        Shape s3 = factory.getShape("Square");
        s3.draw();
    }
}