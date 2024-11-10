package recursion;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RecursiveFileSearch {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java RecursiveFileSearch <directory> <file1> [file2 ...] [-i]");
            return;
        }

        String directoryPath = args[0];
        boolean caseInsensitive = false;
        List<String> filesToSearch = new ArrayList<>();

        // Check for case-insensitive flag
        if (args[args.length - 1].equalsIgnoreCase("-i")) {
            caseInsensitive = true;
            for (int i = 1; i < args.length - 1; i++) {
                filesToSearch.add(args[i]);
            }
        } else {
            for (int i = 1; i < args.length; i++) {
                filesToSearch.add(args[i]);
            }
        }

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The specified directory does not exist.");
            return;
        }

        // List all available files in the directory
        listFiles(directory);

        // Search for specified files
        for (String fileName : filesToSearch) {
            int count = searchFiles(directory, fileName, caseInsensitive);
            if (count > 0) {
                System.out.printf("File '%s' found %d time(s).\n", fileName, count);
            } else {
                System.out.printf("File '%s' not found.\n", fileName);
            }
        }
    }

    private static void listFiles(File directory) {
        System.out.println("Available files in the directory:");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("[DIR] " + file.getName());
                } else {
                    System.out.println(file.getName());
                }
            }
        }
    }

    private static int searchFiles(File directory, String fileName, boolean caseInsensitive) {
        int count = 0;

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                // Check if it's a directory
                if (file.isDirectory()) {
                    count += searchFiles(file, fileName, caseInsensitive);
                } else {
                    // Check for file name match
                    if (caseInsensitive) {
                        if (file.getName().equalsIgnoreCase(fileName)) {
                            System.out.println("Found: " + file.getAbsolutePath());
                            count++;
                        }
                    } else {
                        if (file.getName().equals(fileName)) {
                            System.out.println("Found: " + file.getAbsolutePath());
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}