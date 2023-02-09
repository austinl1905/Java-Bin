import java.util.Stack;
import java.util.Scanner;
import java.util.Random;

public class javaStack {

    private static Scanner scanner1 = new Scanner(System.in);
    private static Scanner scanner2 = new Scanner(System.in);
    private static Stack<Character> stack = new Stack<>();

    static void getInput() {
        String userInput1 = scanner1.nextLine();
        char[] charArray = userInput1.toCharArray();

        for (int i = 0; i < userInput1.length(); i++) {
            stack.push(charArray[i]);
        }
    }

    public static void main(String[]args) {
        try {
            getInput();
            System.out.println("Object at the top of the stack is: " + stack.peek());
            System.out.println("Enter 1 to peek at a random object from the stack. Enter 2 to end program.");

            String userInput2 = scanner2.nextLine();

            switch (userInput2) {
                case "1":
                    Random generator = new Random();
                    int randomIndex = generator.nextInt(stack.size());
                    System.out.println("The randomly selected object is: " + stack.get(randomIndex));
                    break;
                case "2":
                    break;
            }
        }

        finally {
            scanner1.close();
            scanner2.close();
        }
    }
}