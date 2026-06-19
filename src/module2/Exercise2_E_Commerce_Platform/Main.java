//
//E-commerce Platform Search Function
//        1 What is BigO Notation ?
//        Big O Notation is used to measure the efficienc of an Algorith, by describing how ts execution time groes as the input size increases
//
//        | Complexity | Meaning           |
//        | ---------- | ----------------- |
//        | O(1)       | Constant Time     |
//        | O(log n)   | Logarithmic Time  |
//        | O(n)       | Linear Time       |
//        | O(n log n) | Linearithmic Time |
//        | O(n²)      | Quadratic Time    |

package module2.Exercise2_E_Commerce_Platform;

class Product{
    private int productID;
    private String ProductName;
    private String category;

    public Product(int productID,String productName, String category){
        this.productID = productID;
        this.ProductName = ProductName;
        this.category = category;
    }

    public int getProductID(){
        return productID;
    }

    @Override
    public String toString(){
        return productID + " " + ProductName + " " + category;
    }
}

class SearchOperation{
    public static Product LinearSearch(Product[] products, int id){

        for(int i = 0 ; i < products.length; i++){
            if(products[i].getProductID() == id){
                return products[i];
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int id){
        int left = 0;
        int right = products.length;

        while(left < right){
            int mid = left - (right - left) / 2;

            if(products[mid].getProductID() == id){
                return products[mid];
            }
            if(products[mid].getProductID() < id){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return null;
    }
}

public class Main{
    public static void main(String[] args){

        Product[] products = {
                new Product(101,"Laptop", "Electronice"),
                new Product(102,"Mouse","Electronics"),
                new Product(102, "Keyboard", "Electronice"),
                new Product(104, "Monitor", "Electronics"),
                new Product(105, "Printer", "Office"),
        };

        Product result1 = SearchOperation.LinearSearch(products,103);

        if(result1 != null){
            System.out.println("Linear Search Found: " + result1);
        }

        Product result2 = SearchOperation.binarySearch(products, 104);

        if(result2 != null){
            System.out.println("Binary Search Found:" + result2);
        }
    }
}

//Analysis
//| Operation    | Linear Search | Binary Search |
//        | ------------ | ------------- | ------------- |
//        | Best Case    | O(1)          | O(1)          |
//        | Average Case | O(n)          | O(log n)      |
//        | Worst Case   | O(n)          | O(log n)      |
