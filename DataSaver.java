import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataSaver {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Collect user information using SafeInput
        String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
        String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");

        int idNum = SafeInput.getRangedInt(in, "Enter ID Number (1 - 999999)", 1, 999999);
        String idFormatted = String.format("%06d", idNum);  // zero-filled to 6 digits

        String email = SafeInput.getNonZeroLenString(in, "Enter Email");

        int birthYear = SafeInput.getRangedInt(in, "Enter Year of Birth (1900–2099)", 1900, 2099);

        // Format as CSV
        String csvRecord = String.format("%s, %s, %s, %s, %d",
                firstName, lastName, idFormatted, email, birthYear);

        // Save to file (append mode)
        String fileName = "data_output.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(csvRecord);
            writer.newLine();
            System.out.println("\nRecord saved successfully to " + fileName);
        }
        catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
