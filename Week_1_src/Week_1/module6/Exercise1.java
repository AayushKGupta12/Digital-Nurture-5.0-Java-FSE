package Week_1.module5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// Repository
interface Repository8 {
    String getData();
}

// Service
class Service8 {

    private Repository8 repository;

    public Service8(Repository8 repository) {
        this.repository = repository;
    }

    public String processData() {
        return "Processed " + repository.getData();
    }
}

// Test
class Exercise8 {

    @Test
    void testServiceWithMockRepository() {

        Repository8 mockRepository = mock(Repository8.class);

        when(mockRepository.getData()).thenReturn("Mock Data");

        Service8 service = new Service8(mockRepository);

        String result = service.processData();

        assertEquals("Processed Mock Data", result);

    }
}