import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

// Interface
interface ExternalApi3 {
    void sendData(String name);
}

// Service Class
class MyService3 {

    private ExternalApi3 api;

    public MyService3(ExternalApi3 api) {
        this.api = api;
    }

    public void process() {
        api.sendData("Aayush");
    }

}

// Test Class
public class Exercise3 {

    @Test
    void testArgumentMatching() {

        // Arrange
        ExternalApi3 mockApi = mock(ExternalApi3.class);

        MyService3 service = new MyService3(mockApi);

        // Act
        service.process();

        // Assert
        verify(mockApi).sendData(anyString());

    }
}