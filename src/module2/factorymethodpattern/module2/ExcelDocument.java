package module2.factorymethodpattern.module2;

public class ExcelDocument implements Document{

    @Override
    public void open(){
        System.out.println("Opening Excel Document");
    }
}
