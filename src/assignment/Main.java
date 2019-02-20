package assignment;

public class Main {

    public static void main(String[] args) {
        new NamePrinter().printNames();
    }
}

class NamePrinter {
    /**
     * Prints the names of the group members separated by spaces.
     */
    public void printNames() {
        String separator = " , ";

        String[] names = {
                "Name 1",
                "Quan Pham",
                "Omundson",
                "Thomas Lea",
                "Name 5"};

        System.out.println(String.join(separator, names));
    }
}