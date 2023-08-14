import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Scanner;


public class Trainer extends Person {
    private TrainerCategory category;

    public Trainer(TrainerCategory category, String name, LocalDate bornDate, LocalDate joinSchoolDate) {
        super(name, bornDate, joinSchoolDate);
        setCategory(category);
    }

    private TrainerCategory verifyCategory(TrainerCategory category) {
        return (category != null) ? category : TrainerCategory.ASSISTANTTRAINER;
    }
    
    public boolean canCreate(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthDate, currentDate).getYears();
        return age >= 18;
    }

    // Setters
    public void setCategory(TrainerCategory category) {
        this.category = verifyCategory(category);
    }

    // Getters
    public TrainerCategory getCategory() {
        return this.category;
    }

    // To String
    @Override
    public String toString() {
        return super.toString() + "\nCategory: " + getCategory();
    }
}
