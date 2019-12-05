public class HelloWorld{
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        while (i < 5) {
            j = i;
            while (j >= 0) {
                System.out.print("*");
                j -= 1;
            }
            System.out.print("\n");
            i += 1;
        }
    }
}