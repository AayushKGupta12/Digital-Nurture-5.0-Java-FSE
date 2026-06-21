//Array Representation in Memory
//        An array stores elements in contiguous memory locations.
//        Each element is accessed using its index.
//        Since memory locations are continuous, accessing an element is very fast.
//
//        Fast access using index (O(1)).
//        Easy to traverse.
//        Memory efficient.
//        Simple to implement.
//
package Week_1.module2.Exercise4_Employee_management;

class Employee{
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary){
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString(){
        return employeeId + " " + name + " " + position + " Rs" + salary;
    }
}

class EmployeeManager{
    private Employee[] employees;
    private int size;

    public EmployeeManager(int capacity){
        employees = new Employee[capacity];
        size = 0;
    }

    void addEmployee(Employee employee){
        if(size < employees.length){
            employees[size++] = employee;
            System.out.println("Employee Added");
        }else{
            System.out.println("Array Full.");
        }
    }

    public Employee searchEmployee(int id){
        for(int i = 0 ; i < size ; i++){
            if(employees[i].employeeId == id){
                return employees[i];
            }
        }

        return null;
    }

    public void displayEmployees(){
        for(int i = 0 ; i < size; i++ ){
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int id){
        int index = -1;

        for(int i = 0 ; i < size; i++){
            if(employees[i].employeeId == id){
                index = i;
                break;
            }
        }

        if(index == -1){
            System.out.println("Employee Not Found");
            return;
        }

        for(int i = index; i < size - 1 ; i++){
            employees[i] = employees[i + 1];
        }

        employees[size - 1] = null;
        size--;

        System.out.println("Employee Deleted.");
    }
}



public class Main {
    public static void main(String[] args){
        EmployeeManager manager = new EmployeeManager(10);

        manager.addEmployee(new Employee(101, "Aayush", "Developer", 60000));
        manager.addEmployee(new Employee(102, "Rahul", "Tester", 45000));
        manager.addEmployee(new Employee(103, "Neha", "Manager", 90000));

        System.out.println("Employees:");

        manager.displayEmployees();

        System.out.println("\nSearching Employee:");

        System.out.println(manager.searchEmployee(102));

        manager.deleteEmployee(101);

        System.out.println("\nAfter Deletion:");

        manager.displayEmployees();
    }
}
//
//        | Operation | Complexity |
//        | --------- | ---------- |
//        | Add       | O(1)       |
//        | Search    | O(n)       |
//        | Traverse  | O(n)       |
//        | Delete    | O(n)       |

