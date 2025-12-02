import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileScan {

    public static void main(String[] args) {
        File fileToScan = null;


        if (args.length == 1) {
            fileToScan = new File(args[0]);

            if (!fileToScan.exists()) {
                System.out.println("File not found: " + args[0]);
                return;
            }
            System.out.println("Using cmd line argument file: " + args[0]);

        } else {


            JFileChooser chooser = new JFileChooser(".");
            chooser.setDialogTitle("Choose a file to scan");

            int result = chooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                fileToScan = chooser.getSelectedFile();
                System.out.println("File chosen: " + fileToScan.getName());
            } else {
                System.out.println("No file selected. Exiting.");
                return;
            }
        }

        // ------------------------------------------
        // 3. Process the file (same logic from Lab 12)
        // ------------------------------------------
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try {
            Scanner inFile = new Scanner(fileToScan);

            while (inFile.hasNextLine()) {
                String line = inFile.nextLine();
                lineCount++;

                if (!line.isEmpty()) {
                    String[] words = line.split("\\s+");
                    wordCount += words.length;
                    charCount += line.length();
                }
            }

            inFile.close();

            System.out.println("\n=== Scan Results ===");
            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + charCount);

        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }

    }
}
