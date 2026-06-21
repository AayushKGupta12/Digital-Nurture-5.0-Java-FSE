package Week_1.module1.dependencyinjection;

// Repository Interface
interface CustomerRepository {

    String findCustomerById(int id);
}

// Repository Implementation
class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public String findCustomerById(int id) {
        return "Customer ID : " + id + ", Name : Aayush Gupta";
    }
}

// Service
class CustomerService {

    private CustomerRepository repository;

    // Constructor Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void getCustomer(int id) {
        System.out.println(repository.findCustomerById(id));
    }
}

// Main Class
public class Main {

    public static void main(String[] args) {

        CustomerRepository repository =
                new CustomerRepositoryImpl();

        CustomerService service =
                new CustomerService(repository);
        service.getCustomer(101);
    }
}