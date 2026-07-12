package Week_1.module1.factorymethodpattern.module2;

public class ExcelDocumentFactory extends DocumentFactory{

    @Override
    public Document createDocument(){
        return new ExcelDocument();
    }
}
