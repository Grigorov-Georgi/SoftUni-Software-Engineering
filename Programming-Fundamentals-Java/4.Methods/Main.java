public class Main {
    public static void printLine (String name){

        for (int i = 0; i < name.length(); i++) {
            System.out.print('-');
        }
        System.out.println();
        System.out.println(name);
        for (int i = 0; i < name.length(); i++) {
            System.out.print('-');
        }
    }
    public static void main(String[] args) {
	printLine("Chapter 123452");
    }
}
