package assignment;

public class Main {

    public static void main(String[] args) {
        new NamePrinter().printNames();
    }
}

class NamePrinter {
    /**
     * Prints the names of the group members separated by commas.
     */
    public void printNames() {
        String separator = " , ";

        String[] names = {
                "Havish Kantheti",
                "Quan Pham",
                "Omundson",
                "Thomas Lea"};

        System.out.println(String.join(separator, names));
    }
}