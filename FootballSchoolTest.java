
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FootballSchoolTest
{
    @Test
    public void testAddPlayer() {
        FootballSchool footballSchool = new FootballSchool("My Football School", LocalDate.now(), "123 Main Street");
        Player player = new Player(80, "John Doe", LocalDate.of(2000, 1, 1), LocalDate.now());
        footballSchool.addPlayer(player);
    }

    @Test
    public void testAddTrainer() {
        FootballSchool footballSchool = new FootballSchool("My Football School", LocalDate.now(), "123 Main Street");
        Trainer trainer = new Trainer(TrainerCategory.HEADTRAINER, "Jane Smith", LocalDate.of(1980, 5, 10), LocalDate.now());
        footballSchool.addTrainer(trainer);
    }

    @Test
    public void testAddTeam() {
        FootballSchool footballSchool = new FootballSchool("My Football School", LocalDate.now(), "123 Main Street");
        Team team = new Team("Team A", TeamCategory.PETIZES);
        footballSchool.addTeam(team);
    }
}
