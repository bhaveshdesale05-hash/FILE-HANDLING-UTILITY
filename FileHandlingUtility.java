import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    static String fileName = "sample.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== File Handling Utility ======");
            System.out.println("1. Write to File");
            System.out.println("2. Read File");
            System.out.println("3. Modify File (Append)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    writeToFile(sc);
                    break;

                case 2:
                    readFromFile();
                    break;

                case 3:
                    modifyFile(sc);
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }

    // WRITE
    public static void writeToFile(Scanner sc) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            System.out.print("Enter text to write in file: ");
            String data = sc.nextLine();
            bw.write(data);
            bw.close();
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error while writing file.");
        }
    }

    // READ
    public static void readFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            System.out.println("\nFile Content:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

        } catch (IOException e) {
            System.out.println("File not found or error while reading.");
        }
    }

    // MODIFY (APPEND)
    public static void modifyFile(Scanner sc) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
            System.out.print("Enter text to append: ");
            String data = sc.nextLine();
            bw.newLine();
            bw.write(data);
            bw.close();
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error while modifying file.");
        }
    }
}
