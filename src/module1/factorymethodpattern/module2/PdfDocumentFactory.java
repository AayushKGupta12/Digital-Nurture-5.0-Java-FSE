package module1.factorymethodpattern.module2;

public class PdfDocumentFactory extends DocumentFactory{

    @Override
    public Document createDocument(){
        return new PdfDocument();
    }
}
