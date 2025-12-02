import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileInspector {

    public static void main(String[] args) {

        // Set JFileChooser to open in the project's src directory
        JFileChooser chooser = new JFileChooser(new File("src"));
        chooser.setDialogTitle("Select a Text File");

        int result = chooser.showOpenDialog(null);

        if (result != JFileChooser.APPROVE_OPTION) {
            System.out.println("No file was selected. Exiting program...");
            return;
        }

        File chosenFile = chooser.getSelectedFile();

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        System.out.println("----- FILE CONTENTS -----");

        try (BufferedReader reader = new BufferedReader(new FileReader(chosenFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);   // Echo each line

                lineCount++;

                // Count words (split on whitespace)
                if (!line.trim().isEmpty()) {
                    String[] words = line.trim().split("\\s+");
                    wordCount += words.length;
                }

                // Count characters
                charCount += line.length();
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        System.out.println("\n----- SUMMARY REPORT -----");
        System.out.println("File Name: " + chosenFile.getName());
        System.out.println("Number of Lines: " + lineCount);
        System.out.println("Number of Words: " + wordCount);
        System.out.println("Number of Characters: " + charCount);
    }
}
