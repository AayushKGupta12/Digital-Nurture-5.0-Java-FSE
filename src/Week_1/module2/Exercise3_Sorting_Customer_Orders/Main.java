// Exercise 3: Sorting Customer Orders
// 1. Understand Sorting Algorithms

//Bubble Sort
//        - Compares adjacent elements
//        - Swaps if required
//        - Repeats until Sorted.
//
//        Time Complexity:
//        - best: O(n)
//        - average: O(n^2)
//        - Worst: O(n^2)
//
//        Insertion Sort
//        - inserts each elemts into its correct position.
//
//        Time Complexity
//        - best: O(n)
//        - Average: O(n2)
//        - Worst: O(n2)
//
//Quick Sort
//- selects a pivot
//- Partitions the array
//Recursively sorts left and right Parts.
//
//Time Complexity:
//        Best: O(n logn)
//        Average : O(n log n)
//        Worst: O(n2)
//
//Merge Sort
//- divides the array
//- sort recursively.
//- Merges sorted Arrays.
//        Time COmplexity
//      -  Best: O(n log n)
//      -  Average: O(n log n)
//      -  Worst: O(n log n)


package Week_1.module2.Exercise3_Sorting_Customer_Orders;


class Order{
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice){
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString(){
        return orderId + " " + customerName + " Rs" + totalPrice;
    }
}

class BubbleSort{
    public static void sort(Order[] order){
        int n = order.length;

        for(int i = 0 ; i < n - 1 ; i++){
            for(int j = 0 ; j < n - 1 ; j++){
                if(order[j].totalPrice > order[j + 1].totalPrice){
                    Order temp = order[j];
                    order[j] = order[j+1];
                    order[j + 1] = temp;
                }
            }
        }
    }
}

class QuickSort{
    public static void quickSort(Order[] orders, int low, int high){
        if(low < high){
            int pi = partition(orders,low,high);

            quickSort(orders, low, pi -1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high){
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(orders[j].totalPrice < pivot){
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
}
public class Main {
    public static void main(String[] args){
        Order[] orders = {
                new Order(1,"Aayush", 1200),
                new Order(2,"Rahul", 9000),
                new Order(3,"Amit", 4500),
                new Order(4,"Neha", 2500),
                new Order(5,"Riya", 7000),
        };

        System.out.println("Before Sorting");
        for(Order order : orders){
            System.out.println(order);
        }

        QuickSort.quickSort(orders,0,orders.length - 1);
        System.out.println("\n After Qucksort");

        for(Order order : orders){
            System.out.println(order);
        }
    }
}

//        | Algorithm   | Best       | Average    | Worst |
//        | ----------- | ---------- | ---------- | ----- |
//        | Bubble Sort | O(n)       | O(n²)      | O(n²) |
//        | Quick Sort  | O(n log n) | O(n log n) | O(n²) |

