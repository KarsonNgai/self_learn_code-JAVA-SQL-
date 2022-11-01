//read the file with the Path and Files.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileExceptionTest{
  public static void main(String [] arg) throws Exception{
    List<String> lines = new ArrayList<>();
    try{
      Path filePath = Paths.get("C:/assignments/Week5/src/main/java/com/vtxlab/readfile/somefile.txt");
      lines = Files.readAllLines(filePath);
    }catch(IOException ioe){
      Path filePath = Paths.get("C:/assignments/Week5/src/main/java/com/vtxlab/readfile/backup.txt");
      lines = Files.readAllLines(filePath);
    
    }finally{
      System.out.println(lines);
    }
  }
}
