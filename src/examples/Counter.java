package examples;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by nicasandra on 11/1/2016.
 */
public class Counter {

    public int count(int position, String str, String sourceFile) {
        int counter = 0;
        try (RandomAccessFile file = new RandomAccessFile(sourceFile, "rw")) {
            file.seek(position);
            String line = null;
            StringBuffer buffer = new StringBuffer();
            while ((line = file.readLine()) != null) {
                buffer.append(line);
            }
            String[] words = buffer.toString().split("");
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(str)) {
                    counter++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }
}
