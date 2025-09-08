public class RodriguezHelloWorld {
    private static void printName(String name_first, String name_last) 
    {
        System.out.printf("Hello World from %2$s %1$s.", name_first, name_last);
    }

    public static void main(String[] args)
    {
        printName("Alex","Rodriguez");
    }
}