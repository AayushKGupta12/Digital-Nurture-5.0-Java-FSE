package Week_1.module5;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

// Interface
interface ExternalApi6 {

    void login();

    void logout();

}

// Service Class
class MyService6 {

    private ExternalApi6 api;

    public MyService6(ExternalApi6 api) {
        this.api = api;
    }

    public void execute() {

        api.login();
        api.logout();

    }

}

// Test Class
class Exercise6 {

    @Test
    void testInteractionOrder() {

        // Arrange
        ExternalApi6 mockApi = mock(ExternalApi6.class);

        MyService6 service = new MyService6(mockApi);

        // Act
        service.execute();

        // Assert
        InOrder inOrder = inOrder(mockApi);

        inOrder.verify(mockApi).login();
        inOrder.verify(mockApi).logout();

    }

}