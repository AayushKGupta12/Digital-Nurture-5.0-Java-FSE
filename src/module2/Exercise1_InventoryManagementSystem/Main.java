// Why Data Structures and Algo. impo ?
//
//It is essential for managing large inventories because they :
//- Stroe thoudasa of product efficicently
//- Allows fast searching of products
//- Enable quick insertion, updating and deletion
//- Reduce memory usages
//- Improve the overall performance of the inventory system
//
//
//        Suitable Data Structure
//
//        | Data Structure | Advantages                          | Disadvantages                |
//        | -------------- | ----------------------------------- | ---------------------------- |
//        | ArrayList      | Easy to implement, maintains order  | Searching is slow (O(n))     |
//        | LinkedList     | Fast insertion/deletion             | Slow searching               |
//        | HashMap        | Very fast search, update and delete | Does not maintain order      |
//        | TreeMap        | Sorted data                         | Slightly slower than HashMap |
//
//For this product the best we can use is the HashMap <Integer, product> is the best option
//because - Product ID is unique
//        - Searching by ID is very Fast
//        - Updating is efficient
//        - Deleting is efficient


package module2.Exercise1_InventoryManagementSystem;
import java.util.HashMap;

class Product{

    private int ProductID;
    private String ProductName;
    private int quantity;
    private double price;

    public Product(int productID, String ProductName, int quantity, double price){
        this.ProductID = productID;
        this.ProductName = ProductName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductID(){
        return ProductID;
    }

    public void setProductName(String ProductName){
        this.ProductName = ProductName;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public String toString(){
        return "Product ID:" + ProductID + ", Name: " + ProductName + " Quantity: " + quantity + ",Price: Rs" + price;
    }
}

class InventoryManager{
    private HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product){
        inventory.put(product.getProductID(), product);
        System.out.println("Product Added Sucessfully");
    }

    public void updateProduct(int id, String name, int quantity, double price){

        Product product = inventory.get(id);

        if(product != null){
            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product Updated Successfully");
        }else{
            System.out.println("Product not found");
        }
    }

    public void deleteProduct(int id){
        if(inventory.remove(id) != null){
            System.out.println("Product Deleted Successfully");
        }else{
            System.out.println("Product Not Found.");
        }
    }

    public void displayInventory(){
        System.out.println("\n Inventory:");
        for(Product product : inventory.values()){
            System.out.println(product);
        }
    }
}

public class Main{
    public static void main(String []args){
        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product(101, "Laptop",20,65000));
        manager.addProduct(new Product(102, "Mouse", 100, 500));
        manager.addProduct(new Product(103, "Keyboard", 50,1200));

        manager.displayInventory();

        manager.updateProduct(102,"Wireless Mouse", 90,700);
        manager.displayInventory();
        manager.deleteProduct(101);
        manager.displayInventory();

    }
}

// Time Complexity
//        | Operation      | HashMap Time Complexity |
//        | -------------- | ----------------------- |
//        | Add Product    | O(1) Average            |
//        | Update Product | O(1) Average            |
//        | Delete Product | O(1) Average            |
//        | Search Product | O(1) Average            |

//    Why HashMap is Efficient:
//
//    Uses hashing to locate products quickly.
//        No need to scan the entire inventory.
//        Suitable for warehouses with millions of products.
//        Provides excellent average-case performance for CRUD operations.