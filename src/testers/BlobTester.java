package testers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import git.Blob;

public class BlobTester {
	static void setUpBeforeClass() throws Exception {
		Path p = Paths.get("junit.txt");
        try {
            Files.writeString(p, "JackB Test", StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Path p1 = Paths.get("junit1.txt");
        try {
            Files.writeString(p1, "junit1", StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Path p2 = Paths.get("junit2.txt");
        try {
            Files.writeString(p2, "junit2", StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
		
	}

	@AfterAll
	//FINISH THIS, DELETE OBJ FOLDER AND INDEX FILE
	static void tearDownAfterClass() throws Exception {
		File file= new File("junit.txt");
		file.delete();
		
		File Indexfile=new File("index");
		Indexfile.delete();
		
		File Objectfile=new File("objects");
		Objectfile.delete();
	}

	
	@Test
	void testBlob() throws IOException, NoSuchAlgorithmException {		
		Blob b=new Blob("junit.txt");
		
		File file=new File("objects/f85d527604444aa350aa09dfe93baefbd88f804c");// PUT IN SHA1 STRING
		assertTrue(file.exists());// this is returning false bc file never gets created
	}
	
	@Test
	void testGetSha() throws NoSuchAlgorithmException, IOException {
		Blob b=new Blob("junit.txt");
		assertTrue(b.getSha().equals("f85d527604444aa350aa09dfe93baefbd88f804c"));
		
	}
}
