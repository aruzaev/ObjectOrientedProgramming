/**
 * method1
 */
class method1 {
    int i = 0;
    int sum = 0;
    int limit = 10;

    while (i <= limit) {
        i++;
        if (i % 3 == 0 || i % 5 == 0) {
            sum = sum + 1;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        
    }
}