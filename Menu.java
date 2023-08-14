import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;



public class Menu {
    
    private List<FootballSchool> footballSchools;
    private FootballSchool selectedSchool;

    public Menu() {
        footballSchools = new ArrayList<>();
    }

    public void loadData() {
        footballSchools = load("footballSchools.bin");
        executeSchoolMenu();
    }


    
    public void executeSchoolMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
    
        do {
            System.out.println("\n-------- Menu --------");
            System.out.println("1. Add a new football school");
            System.out.println("2. Choose a football school");
            System.out.println("3. List all football schools");
            System.out.println("4. Save");
            System.out.println("0. Exit the program");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer
    
            switch (option) {
                case 1:
                    addFootballSchool();
                    break;
                case 2:
                    chooseFootballSchool();
                    break;
                case 3:
                    listAllFootballSchools();
                    break;
                case 4:
                    save("footballSchools.bin");
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
    
        } while (option != 0);
    
        scanner.close();
    }
    
    private void addFootballSchool() {
        DefaultFunctions.clearConsole();
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Enter the name of the football school:");
        String name = scanner.nextLine();
        
        // Check if a football school with the same name already exists
        boolean nameExists = footballSchools.stream().anyMatch(footballSchool -> footballSchool.getName().equals(name));
        if (nameExists) {
            System.out.println("A football school with the same name already exists. Please choose a different name.");
            return;
        }
    
        System.out.println("Enter the foundation date of the football school (yyyy-MM-dd):");
        LocalDate foundationDate = DefaultFunctions.dateVerifier();
    
        System.out.println("Enter the headquarters address of the football school:");
        String headquartersAddress = scanner.nextLine();
    
        // Create a new FootballSchool object with the inputted information
        FootballSchool footballSchool = new FootballSchool(name, foundationDate, headquartersAddress);
    
        // Add the footballSchool object to the footballSchools array
        footballSchools.add(footballSchool);
    
        System.out.println("Football school added successfully!");
    }

    
    private void listAllFootballSchools() {
        DefaultFunctions.clearConsole();
        System.out.println("-------- List of Football Schools --------");
        for (int i = 0; i < footballSchools.size(); i++) {
            System.out.println("School " + (i + 1) + ":");
            System.out.println("Name: " + footballSchools.get(i).getName());
            System.out.println("Foundation Date: " + footballSchools.get(i).getFoundationDate());
            System.out.println("Headquarters Address: " + footballSchools.get(i).getHeadquartersAddress());
        }
        System.out.println("-----------------------------------------");
        System.out.println("Press Enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    
    private void chooseFootballSchool() {
        DefaultFunctions.clearConsole();
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("\nChoose a football school:");
    
        for (int i = 0; i < footballSchools.size(); i++) {
            System.out.println((i + 1) + ". " + footballSchools.get(i).getName());
        }
    
        int choice = scanner.nextInt();
        scanner.nextLine();
    
        if (choice > 0 && choice <= footballSchools.size()) {
            selectedSchool = footballSchools.get(choice - 1);
            executeMenu();
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }


    public void executeMenu() {
        System.out.println("Selected Football School: " + selectedSchool.getName());

        //selectedSchool = loadOrCreate(selectedSchool.getName());
        
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n-------- Menu --------");
            System.out.println("1. Insert a new player record");
            System.out.println("2. Modify player");
            System.out.println("3. Search player by id");
            System.out.println("4. List players by string");
            System.out.println("5. List all players");
            System.out.println("6. Insert a new trainer record");
            System.out.println("7. Search trainer by id");
            System.out.println("8. List trainer by string");
            System.out.println("9. List all trainers");
            System.out.println("10. Create team");
            System.out.println("11. Modify team");
            System.out.println("12. Search team by id");
            System.out.println("13. List teams by string");
            System.out.println("14. List all teams");
            System.out.println("15. Evaluate team performance");
            System.out.println("16. List all players of a team");
            System.out.println("0. Exit the program");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();
            DefaultFunctions.clearConsole();
            switch (option) {
                case 1:
                    selectedSchool.createPlayer();
                    break;
                case 2:
                    selectedSchool.modifyPlayer();
                    break;
                case 3:
                    selectedSchool.searchPlayerById();
                    break;
                case 4:
                    selectedSchool.listPlayersByString();
                    break;
                case 5:
                    selectedSchool.listAllPlayers();
                    break;
                case 6:
                    selectedSchool.createTrainer();
                    break;
                case 7:
                    selectedSchool.searchTrainerById();
                    break;
                case 8:
                    selectedSchool.listTrainersByString();
                    break;
                case 9:
                    selectedSchool.listAllTrainers();
                    break;
                case 10:
                    selectedSchool.createTeam();
                    break;
                case 11:
                    selectedSchool.modifyTeam();
                    break;
                case 12:
                    selectedSchool.searchTeamById();
                    break;
                case 13:
                    selectedSchool.listTeamsByString();
                    break;
                case 14:
                    selectedSchool.listAllTeams();
                    break;
                case 15:
                    selectedSchool.evaluateTeam();
                    break;
                case 16:
                    selectedSchool.listAllPlayersOfTeam();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 0);

        scanner.close();
    }
    
    public static void main(String[] args) {
        Menu footballSchool = new Menu();
        footballSchool.loadData();
    }
    
    public void save(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(footballSchools);
            out.close();
            fileOut.close();
            System.out.println("Object saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<FootballSchool> load(String filename) {
        List<FootballSchool> loadedSchools = new ArrayList<>();
    
        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fileIn = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                loadedSchools = (List<FootballSchool>) in.readObject();
                in.close();
                fileIn.close();
                System.out.println("Object loaded successfully.");
            } else {
                System.out.println("Save file not found.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    
        return loadedSchools;
    }
}
