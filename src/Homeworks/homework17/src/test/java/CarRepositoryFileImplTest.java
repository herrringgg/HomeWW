import org.example.Car;
import org.example.repo.CarRepositoryFileImpl;
import org.junit.jupiter.api.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class CarRepositoryFileImplTest {
    private Path tmp;
    private CarRepositoryFileImpl repo;

    @BeforeEach
    void setup() throws Exception {
        tmp = Files.createTempFile("cars-test", ".txt");
        Files.writeString(tmp, "1|Toyota|Corolla|2010|132|10|50|80\n", java.nio.charset.StandardCharsets.UTF_8);
        repo = new CarRepositoryFileImpl(tmp);
    }

    @Test
    void testFindById() {
        Car c = repo.findById("Toyota|Corolla|2010"); 
        assertNotNull(c);
        assertEquals("Corolla", c.getModel());
    }

    @Test
    void testCreateAndDelete() {
        Car newCar = new Car("Honda", "Civic", 2015, 140, 9, 55, 70);
        repo.create(newCar);
        assertTrue(repo.findAll().stream().anyMatch(car -> car.getModel().equals("Civic")));
        // удаляем по composite id
        repo.deleteById(newCar.getBrand() + "|" + newCar.getModel() + "|" + newCar.getYear());
    }

    @AfterEach
    void tearDown() throws Exception {
        Files.deleteIfExists(tmp);
    }
}
