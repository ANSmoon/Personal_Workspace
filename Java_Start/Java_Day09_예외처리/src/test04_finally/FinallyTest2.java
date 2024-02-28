package test04_finally;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FinallyTest2 {
    public static void main(String[] args) {
        // try ~ catch ~ finally => try with
        
        FileInputStream fis = null;
        
        try {
            fis = new FileInputStream("test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        try(FileInputStream fis2 = new FileInputStream("test.txt")){
        }catch(IOException e) {
        }
        

    }

}
