import java.time.*;
import java.io.*;
import java.util.HashMap;

public abstract class Person implements Serializable {
    private String name;
    private static int registerNumberCounter = 1;
    private int registerNumber;
    private LocalDate bornDate;
    private LocalDate joinSchoolDate;

    public Person(String name, LocalDate bornDate, LocalDate joinSchoolDate) {
        setName(name);
        this.registerNumber = this.registerNumberCounter++;
        setBornDate(bornDate);
        setJoinSchoolDate(joinSchoolDate);
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public void setJoinSchoolDate(LocalDate joinSchoolDate) {
        this.joinSchoolDate = joinSchoolDate;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public int getRegisterNumber() {
        return this.registerNumber;
    }

    public LocalDate getBornDate() {
        return this.bornDate;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(bornDate, currentDate);
        return period.getYears();
    }

    public LocalDate getJoinSchoolDate() {
        return this.joinSchoolDate;
    }

    // Abstract functions
    public abstract boolean canCreate(LocalDate birthDate);

    // To String
    @Override
    public String toString() {
        return ("\nRegister Number: " + getRegisterNumber() + "\nName: " + getName() + "\nBorn Date: " + getBornDate()
                + "\nJoined School: " + getJoinSchoolDate());
    }
}

