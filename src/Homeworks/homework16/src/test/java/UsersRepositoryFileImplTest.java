
import org.junit.jupiter.api.*;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;
import org.example.User;
import org.example.UsersRepositoryFileImpl;
import org.example.UsersRepository;

public class UsersRepositoryFileImplTest {

    private Path tempFile;
    private UsersRepository repo;

    @BeforeEach
    void setUp() throws Exception {
        tempFile = Files.createTempFile("users", ".txt");
        repo = new UsersRepositoryFileImpl(tempFile);
    }

    @Test
    void testCreateAndFind() {
        User u = new User("testUser", "pass123", "pass123",
                "Петров", "Петр", "Сергеевич", 28, false);
        repo.create(u);
        assertEquals(u.getId(), repo.findById(u.getId()).getId());
    }

    @Test
    void testDeleteNonExistingThrows() {
        assertThrows(IllegalArgumentException.class, () -> repo.deleteById("fake-id"));
    }

    @AfterEach
    void tearDown() throws Exception {
        Files.deleteIfExists(tempFile);
    }
}

