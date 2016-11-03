package examples;

/**
 * Created by nicasandra on 11/1/2016.
 */
public class Main {
    public static void main(String[] args) {
        Counter c = new Counter();
        System.out.println("Number: " + c.count(0, "t", "D:\\Java IO\\src\\source-file.txt"));

        Operation o = new Operation();
        o.reverse("D:\\Java IO\\src\\source-file.txt", "D:\\Java IO\\src\\destination-file.txt");
    }
}
