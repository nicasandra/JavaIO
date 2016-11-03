package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by nicasandra on 11/2/2016.
 */
public class Tree {
    public static void printTree(String path, int level, RandomAccessFile raf) throws IOException {
        File file = new File(path);
        File[] currentLevel = file.listFiles();
        if (currentLevel != null && currentLevel.length > 0) {
            for (File f : currentLevel) {
                for (int i = 0; i < level; i++) {
                    raf.write("\t".getBytes());
                }
                if (f.isFile()) {
                    raf.write((f.getName()+"\n").getBytes());
                } else {
                    raf.write((f.getName() + "\\\n").getBytes());
                    printTree(f.getAbsolutePath(), level + 1, raf);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("tree.txt", "rw");
            Tree.printTree(".", 0, raf); //search in current directory
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
