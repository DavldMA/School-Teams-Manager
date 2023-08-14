import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;
import java.io.Serializable;

public class FootballSchool implements Serializable {
    private String name;
    private LocalDate foundationDate;
    private String headquartersAddress;
    public HashMap<Integer, Player> players;
    public HashMap<Integer, Trainer> trainers;
    public HashMap<Integer, Team> teams;

    public FootballSchool(String name, LocalDate foundationDate, String headquartersAddress) {
        this.name = name;
        this.foundationDate = foundationDate;
        this.headquartersAddress = headquartersAddress;
        
        players = new HashMap<>();
        trainers = new HashMap<>();
        teams = new HashMap<>();
    }
    
    // Player
    public void createPlayer() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Enter the name of the player:");
        String playerName = scanner.nextLine();
    
        System.out.println("Enter the performance of the player:");
        int playerPerformance = scanner.nextInt();
    
        System.out.println("Enter the born date (yyyy-MM-dd):");
        LocalDate bornDate = DefaultFunctions.dateVerifier();
        System.out.println("Enter the date joined the school (yyyy-MM-dd):");
        LocalDate joinSchoolDate = DefaultFunctions.dateVerifier();
        Player player = new Player(playerPerformance, playerName, bornDate, joinSchoolDate);        
        
        if (player.canCreate(bornDate)) {
            addPlayer(player);
            System.out.println("Player created successfully.");
        } else {
            System.out.println("Player must be 4 years or older.");
        }
    }
    
    public void addPlayer(Player player) {
        players.put(player.getRegisterNumber(), player);
    }

    public Player findPlayer(int registerNumber) {
        return players.get(registerNumber);
    }

    public void listAllPlayers() {
        for (Player player : players.values()) {
            System.out.println(player.toString());
        }
    }
    
    public void modifyPlayer() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Enter the register number of the player to modify:");
        int registerNumber = scanner.nextInt();
        scanner.nextLine();
    
        Player player = findPlayer(registerNumber);
        if (player != null) {
            System.out.println("Player found. Enter the new information:");
            
            System.out.println("Enter the new name:");
            String newName = scanner.nextLine();
            player.setName(newName);
            
            System.out.println("Enter the new performance:");
            int newPerformance = scanner.nextInt();
            player.setPerformance(newPerformance);
            
            System.out.println("Enter the new born date (yyyy-MM-dd):");
            LocalDate newBornDate = DefaultFunctions.dateVerifier();
            player.setBornDate(newBornDate);
            
            System.out.println("Enter the new join school date (yyyy-MM-dd):");
            LocalDate newJoinSchoolDate = DefaultFunctions.dateVerifier();
            player.setJoinSchoolDate(newJoinSchoolDate);
            
            System.out.println("Player modified successfully.");
        } else {
            System.out.println("Player not found.");
        }
        
        scanner.nextLine(); // Clear the buffer
    }


    public void searchPlayerById() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the register number of the player to search:");
        int registerNumber = scanner.nextInt();
        
        Player player = findPlayer(registerNumber);
        if (player != null) {
            System.out.println(player.toString());
        } else {
            System.out.println("Player not found.");
        }
    }
    
    public void listPlayersByString() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the string to search for in player names:");
        String searchString = scanner.nextLine();
        
        listAllPlayersByName(searchString);
    }

    
    public void findPlayerByRegisterNumber(int registerNumber){
        System.out.println(findPlayer(registerNumber).toString());
    }
    
    public void listAllPlayersByName(String name){
        for (Player player : players.values()){
            if(player.getName().contains(name)){
                 System.out.println(player.toString());               
            }
        }
    }
    
    
    // Trainer
    public void createTrainer() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Enter the name of the trainer:");
        String trainerName = scanner.nextLine();
    
        System.out.println("Enter the category of the trainer (choose one):");
        for (TrainerCategory category : TrainerCategory.values()) {
            System.out.println(category.name());
        }
        String trainerCategoryStr = scanner.nextLine();
        TrainerCategory trainerCategory = TrainerCategory.valueOf(trainerCategoryStr);
        System.out.println("Enter the born date (yyyy-MM-dd):");
        LocalDate bornDate = DefaultFunctions.dateVerifier();
        System.out.println("Enter the date joined the school (yyyy-MM-dd):");
        LocalDate joinSchoolDate = DefaultFunctions.dateVerifier();

    
        // Create a new Trainer object with the inputted information
        Trainer trainer = new Trainer(trainerCategory, trainerName, bornDate, joinSchoolDate); 
        
        if (trainer.canCreate(bornDate)) {
            addTrainer(trainer);
            System.out.println("Trainer created successfully.");
        } else {
            System.out.println("Trainer must be 18 years or older.");
        }
    }   
    
    public void addTrainer(Trainer trainer) {
        trainers.put(trainer.getRegisterNumber(), trainer);
    }

    public Trainer findTrainer(int registerNumber) {
        return trainers.get(registerNumber);
    }

    public void searchTrainerById() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the register number of the trainer to search:");
        int registerNumber = scanner.nextInt();
        
        Trainer trainer = findTrainer(registerNumber);
        if (trainer != null) {
            System.out.println(trainer.toString());
        } else {
            System.out.println("Trainer not found.");
        }
    }
    
    public void listTrainersByString() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the string to search for in trainer names:");
        String searchString = scanner.nextLine();
        
        for (Trainer trainer : trainers.values()) {
            if (trainer.getName().contains(searchString)) {
                System.out.println(trainer.toString());
            }
        }
    }
    
    public void listAllTrainers() {
        for (Trainer trainer : trainers.values()) {
            System.out.println(trainer.toString());
        }
    }

    
    // Team
    public void createTeam() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the name of the team:");
        String teamName = scanner.nextLine();
        
        System.out.println("Enter the category of the team (choose one):");
        for (TeamCategory category : TeamCategory.values()) {
            System.out.println(category.name());
        }
        String teamCategoryStr = scanner.nextLine();
        TeamCategory teamCategory = TeamCategory.valueOf(teamCategoryStr);
        
        Team team = new Team(teamName, teamCategory);

        addTeam(team);
        
        System.out.println("Team created successfully.");
    }
    
    public void addTeam(Team team){
        teams.put(team.getRegisterNumber(), team);
    }
    
    public Team findTeam(int registerNumber){
        return teams.get(registerNumber);
    }
    
    public void findTeamByRegisterNumber(int registerNumber){
        System.out.println(findTeam(registerNumber).toString());
    }
    
    public void listAllTeams(){
        for (Team team : teams.values()){
            System.out.println(team.toString());
        }
    }
    
    public void listAllTeamsByName(String name){
        for (Team team : teams.values()){
            if(team.getName().contains(name)){
                 System.out.println(team.toString());               
            }
        }
    }
    public void modifyTeam() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the ID of the team to modify:");
        int teamId = scanner.nextInt();
        Team team = findTeam(teamId);
        if (team != null) {
    
            System.out.println("Enter the new name of the team:");
            String newName = scanner.nextLine();
    
            System.out.println("Enter the new category of the team (choose one):");
            for (TeamCategory category : TeamCategory.values()) {
                System.out.println(category.name());
            }
            String newCategoryStr = scanner.nextLine();
            TeamCategory newCategory = TeamCategory.valueOf(newCategoryStr);
    
            team.setName(newName);
            team.setCategory(newCategory);
    
            System.out.println("Team modified successfully.");
        } else {
            System.out.println("Team not found.");
        }
    }
    
    public void searchTeamById() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the ID of the team to search:");
        int teamId = scanner.nextInt();
        
        Team team = findTeam(teamId);
        
        if (team != null) {
            System.out.println(team.toString());
        } else {
            System.out.println("Team not found.");
        }
    }
    
    public void listTeamsByString() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the string to search for in team names:");
        String searchString = scanner.nextLine();
        
        listAllTeamsByName(searchString);
    }
    
    public void evaluateTeam() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the ID of the team to evaluate the players:");
        int teamId = scanner.nextInt();
        
        Team team = findTeam(teamId);
        
        team.playerAvaliation();
    }
    
    public void listAllPlayersOfTeam() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the ID of the team to list players:");
        int teamId = scanner.nextInt();
        
        Team team = findTeam(teamId);
        
        if (team != null) {
            for (Player player : team.getPlayers()) {
                System.out.println(player.toString());
            }
        } else {
            System.out.println("Team not found.");
        }
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public String getHeadquartersAddress() {
        return headquartersAddress;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }
    
    public void setName(String name) {
        this.name = name;
    }


    public void setHeadquartersAddress(String headquartersAddress) {
        this.headquartersAddress = headquartersAddress;
    }
}