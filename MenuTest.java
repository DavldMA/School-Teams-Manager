
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuTest
{
    @Test
    public void testFootballSchoolCreation() {
        FootballSchool school = new FootballSchool("ABC School", LocalDate.of(2021, 1, 1), "123 Main Street");
        assertNotNull(school);
        assertEquals("ABC School", school.getName());
    }
}
