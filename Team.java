import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;

public class Team implements TeamInterface, Serializable{
    private String name;
    private static int registerNumberCounter = 1;
    private int registerNumber;
    private TeamCategory category;
    private ArrayList<Player> players;
    private ArrayList<Trainer> trainers;

    public Team(String name, TeamCategory category) {
        this.name = name;
        this.category = category;
        this.players = new ArrayList<>();
        this.trainers = new ArrayList<>();
        this.registerNumber = registerNumberCounter++;
    }
    
    public void playerCategoryUpdate(){
        for (Player player : players) {
            player.setCategory();
        }
    }
    
    public void playerAvaliation(){
        Scanner scanner = new Scanner(System.in);
    
        for (Player player : players) {
            System.out.print("Enter performance evaluation for player " + player.getName() + ": ");
            int performance = scanner.nextInt();
            player.setPerformance(performance);
        }
        playerCategoryUpdate();
        scanner.close();
    }
    
    public void addPlayer(Player player) {
        if (player != null) {
            int age = player.getAge();

            TeamCategory category = getCategory();
            
            // Check if playerCategory is valid
            if (player.getCategory() == PlayerCategory.NONE) {
                if(((this.category.PETIZES == category && age <= 7) 
                    || (this.category.TRAQUINAS == category && age > 7 && age <= 9) 
                    || (this.category.BENJAMINS == category && age > 9 && age <= 11))){
                    players.add(player);
                    playerCategoryUpdate();
                } else {
                    System.out.println("Player age is not valid.");
                }
            } else {
                System.out.println("Player is already on a team" + player.getCategory());
            }
        } else {
            System.out.println("Player not found.");
        }
    }
    
    public void addTrainer(Trainer trainer) {
        if (trainer != null) {
            trainers.add(trainer);
        } else {
            System.out.println("Trainer not found.");
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getRegisterNumber() {
        return registerNumber;
    }

    public TeamCategory getCategory() {
        return category;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }
    
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(TeamCategory category) {
        this.category = category;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Register Number: ").append(registerNumber).append("\n");
        builder.append("Team Name: ").append(name).append("\n");
        builder.append("Category: ").append(category).append("\n");
        
        builder.append("Trainers:\n");
        for (Trainer trainer : trainers) {
            builder.append("- " + trainer.getName() + " - " + trainer.getCategory()).append("\n");
        }
        
        builder.append("Players:\n");
        for (Player player : players) {
            builder.append("- " + player.getName() + " - " + player.getCategory()).append("\n");
        }
        
        return builder.toString();
    }
}
