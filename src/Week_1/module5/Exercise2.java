package Week_1.module5;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

// Interface
interface ExternalApi {

    String getData();

}

// Service Class
class MyService {

    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

}

// Test Class
public class Exercise2 {

    @Test
    void testVerifyInteraction() {

        // Arrange
        ExternalApi mockApi = mock(ExternalApi.class);

        MyService service = new MyService(mockApi);

        // Act
        service.fetchData();

        // Assert
        verify(mockApi).getData();

    }

}