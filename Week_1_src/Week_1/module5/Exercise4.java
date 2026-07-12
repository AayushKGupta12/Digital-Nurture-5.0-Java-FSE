package Week_1.module5;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

// Interface
interface ExternalApi4 {

    void printMessage();

}

// Service Class
class MyService4 {

    private ExternalApi4 api;

    public MyService4(ExternalApi4 api) {
        this.api = api;
    }

    public void display() {
        api.printMessage();
    }

}

// Test Class
public class Exercise4 {

    @Test
    void testVoidMethod() {

        // Arrange
        ExternalApi4 mockApi = mock(ExternalApi4.class);

        doNothing().when(mockApi).printMessage();

        MyService4 service = new MyService4(mockApi);

        // Act
        service.display();

        // Assert
        verify(mockApi).printMessage();

    }

}