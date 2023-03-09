import java.util.Random;
import java.util.Scanner;
class Main {
  public static void main(final String[] args) throws InterruptedException{
    Scanner obj1 = null;
    Scanner obj2 = null;
    Scanner obj3 = null;

    System.out.println("The purpose of this project is to demonstrate the Random class using user input.");

  try {
    obj1 = new Scanner(System.in);
    System.out.println("Enter a String value");
    final String in1 = obj1.nextLine();
    final String rnd1 = in1.toString();

    obj2 = new Scanner(System.in);
    System.out.println("Enter a second String value");
    final String in2 = obj2.nextLine();
    final String rnd2 = in2.toString();

    obj3 = new Scanner(System.in);
    System.out.println("Enter a final String value");
    final String in3 = obj3.nextLine();
    final String rnd3 = in3.toString();

    final String[] myStrs = {rnd1, rnd2, rnd3};

    final Random generator = new Random();
    final int randomIndex = generator.nextInt(myStrs.length);
    System.out.println("The randomly selected String is "
    .concat(myStrs[randomIndex]));
  }
    catch(final Exception e) {
      System.out.println("Something went wrong. Now closing scanners");
    }

    finally {
      obj1.close();
      obj2.close();
      obj3.close();
      Thread.sleep(1000);
      System.out.println("Program concluded");
    }
  }
}