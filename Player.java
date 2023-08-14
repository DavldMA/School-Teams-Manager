import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Scanner;

public class Player extends Person {
    private int shirtNumber;
    private int performance;
    private static int shirtNumberCounter = 1;
    private PlayerCategory category;

    public Player(int performance, String name, LocalDate bornDate, LocalDate joinSchoolDate) {
        super(name, bornDate, joinSchoolDate);
        this.shirtNumber = this.shirtNumberCounter++;
        setPerformance(performance);
        this.category = PlayerCategory.NONE;
    }

    private int performanceValidator(Integer performance) {
        return ((performance >= 0 && performance <= 100) || performance == null) ? performance : 0;
    }

    public boolean canCreate(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthDate, currentDate).getYears();
        return age >= 4;
    }

    
    // Setters
    public void setPerformance(int performance) {
        this.performance = performanceValidator(performance);
    }

    public void setCategory() {
        int age = getAge();
        if (age <= 7) {
            if (this.performance < 40) {
                this.category = PlayerCategory.REGULAR;
            } else if (this.performance >= 70) {
                this.category = PlayerCategory.ESTRELA;
            } else {
                this.category = PlayerCategory.PROMESSA;
            }
        } else if (age > 7 && age <= 9) {
            if (this.performance < 50) {
                this.category = PlayerCategory.REGULAR;
            } else if (this.performance >= 80) {
                this.category = PlayerCategory.ESTRELA;
            } else {
                this.category = PlayerCategory.PROMESSA;
            }
        } else if (age > 9 && age <= 11) {
            if (this.performance < 60) {
                this.category = PlayerCategory.REGULAR;
            } else if (this.performance >= 90) {
                this.category = PlayerCategory.ESTRELA;
            } else {
                this.category = PlayerCategory.PROMESSA;
            }
        }
    }

    // Getters
    public int getShirtNumber() {
        return this.shirtNumber;
    }

    public int getPerformance() {
        return this.performance;
    }

    public PlayerCategory getCategory() {
        return this.category;
    }

    // To String
    @Override
    public String toString() {
        return super.toString() + "\nShirt Number: " + getShirtNumber() + "\nPerformance: " + getPerformance();
    }
}
