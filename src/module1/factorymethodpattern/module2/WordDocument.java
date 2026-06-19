package module1.factorymethodpattern.module2;

public class WordDocument implements Document{

    @Override
    public void open(){
        System.out.println("Opening word Document...");
    }
}
