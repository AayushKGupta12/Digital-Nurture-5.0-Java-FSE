package Week_1.module5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

// Interface
interface ExternalApi7 {

    void delete();

}

// Service Class
class MyService7 {

    private ExternalApi7 api;

    public MyService7(ExternalApi7 api) {
        this.api = api;
    }

    public void remove() {

        api.delete();

    }

}

// Test Class
public class Exercise7 {

    @Test
    void testVoidMethodException() {

        // Arrange
        ExternalApi7 mockApi = mock(ExternalApi7.class);

        doThrow(new RuntimeException("Delete Failed"))
                .when(mockApi)
                .delete();

        MyService7 service = new MyService7(mockApi);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> {

            service.remove();

        });

        verify(mockApi).delete();

    }

}