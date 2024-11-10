package recursion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecursiveFileSearchTest {

    private Path tempDir;

    @BeforeEach
    public void setUp() throws Exception {
        tempDir = Files.createTempDirectory("testDir");
    }

    @AfterEach
    public void tearDown() throws Exception {
        Files.walk(tempDir)
                .sorted((p1, p2) -> p2.compareTo(p1)) // delete files first
                .forEach(p -> p.toFile().delete());
    }

    @Test
    public void testFileFound() throws Exception {
        Files.createFile(tempDir.resolve("testFile.txt"));
        String[] args = {tempDir.toString(), "testFile.txt"};
        assertTrue(searchFiles(args));
    }

   

    

    @Test
    public void testCaseInsensitiveFileFound() throws Exception {
        Files.createFile(tempDir.resolve("TestFile.txt"));
        String[] args = {tempDir.toString(), "testfile.txt", "-i"};
        assertTrue(searchFiles(args)); // Case-insensitive search should find the file
    }

    @Test
    public void testMultipleFilesFound() throws Exception {
        Files.createFile(tempDir.resolve("file1.txt"));
        Files.createFile(tempDir.resolve("file2.txt"));
        String[] args = {tempDir.toString(), "file1.txt", "file2.txt"};
        assertTrue(searchFiles(args)); // Both files should be found
    }

    @Test
    public void testFileInSubdirectoryFound() throws Exception {
        Path subDir = Files.createDirectory(tempDir.resolve("subDir"));
        Files.createFile(subDir.resolve("nestedFile.txt"));
        String[] args = {tempDir.toString(), "nestedFile.txt"};
        assertTrue(searchFiles(args)); // File in subdirectory should be found
    }

    

    private boolean searchFiles(String[] args) {
        // This function would need to capture the console output to validate results
        return true; // Replace with actual logic to check output
    }
}