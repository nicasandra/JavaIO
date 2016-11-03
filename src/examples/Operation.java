package examples;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by nicasandra on 11/1/2016.
 */
public class Operation {

    public void reverse(String sourcePath, String destinationPath) {
        try (RandomAccessFile source = new RandomAccessFile(sourcePath, "rw");
             RandomAccessFile destination = new RandomAccessFile(destinationPath, "rw")) {
            String line = null;
            StringBuffer bfr = new StringBuffer();
            while ((line = source.readLine()) != null) {
                if (line.length() != 0) {
                    bfr.append(line).append("\n");
                }
                /* Uncomment if you don't want to ignore empty lines */
//                else {
//                    bfr.append("\n");
//                }
            }
            String[] lines = bfr.toString().split("\n");
            for (int i = lines.length - 1; i >= 0; i--) {
                String[] words = lines[i].split(" ");
                for (int j = words.length - 1; j >= 0; j--) {
                    destination.write((words[j] + " ").getBytes());
                }
                destination.write("\n".getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
