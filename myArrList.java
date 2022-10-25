import java.util.ArrayList;
import java.util.Scanner;
@SuppressWarnings ("unused")
class myArrList {
  public static void main(String[] args) throws InterruptedException{
    ArrayList<String> myArr = new ArrayList<String>();

    System.out.println("This project will demonstrate the ArrayList class using user input");
    Scanner obj1 = null;
    Scanner obj2 = null;
    Scanner obj3 = null;
    Scanner obj4 = null;
    Scanner obj5 = null;
    Scanner obj6 = null;
    Scanner obj7 = null;
try {
  obj1 = new Scanner(System.in);
  System.out.println("Enter a string");
  String in1 = obj1.nextLine();

  obj2 = new Scanner(System.in);
  System.out.println("Enter a second string");
  String in2 = obj2.nextLine();

  obj3 = new Scanner(System.in);
  System.out.println("Enter a third string");
  String in3 = obj3.nextLine();

  myArr.add(in1);
  myArr.add(in2);
  myArr.add(in3);

  System.out.println("The ArrayList is " + myArr.get(0) + " " + myArr.get(1) + " " + myArr.get(2));
  Thread.sleep(1000);
  
  obj4 = new Scanner(System.in);
  System.out.println("Enter a keyword in order to modify the array list. (Case sensitive)");
  System.out.println("Use keyword skip to end program.");
  System.out.println("Use keyword delete to remove a string.");
  System.out.println("Use keyword clear to remove all strings.");
  
  String in4 = obj4.nextLine();
  in4.toLowerCase();
  switch (in4) {
    case "skip":
      System.out.println("Keyword received. Now closing program.");
      break;
      
    case "delete":
      obj5 = new Scanner(System.in);
      System.out.println("Enter the number of the string you want to delete (List starts from 0)");
      int in5 = obj5.nextInt();
      myArr.remove(in5);
      System.out.print("The array is now ");
      System.out.println(myArr);
      
      obj6 = new Scanner(System.in);
      System.out.println("Enter delete again if you want to delete another string");
      String in6 = obj6.nextLine();
      in6.toLowerCase();
      if (in6.equals("delete")) {
        obj7 = new Scanner(System.in);
      System.out.println("Enter the number of the string you want to delete");
      int in7 = obj7.nextInt();
      myArr.remove(in7);
      }
      System.out.print("The array is now ");
      System.out.println(myArr);
      break;
      
    case "clear":
      System.out.println("Now clearing array.");
      myArr.clear();
      break;
      
    default:
      System.out.println("Invalid keyword");
    
  }
  obj5.close();
  obj6.close();
  obj7.close();
}
catch (Exception e) {
  System.out.println("Now ending program");
  Thread.sleep(1000);
}
finally {
  obj1.close();
  obj2.close();
  obj3.close();
  obj4.close();

  System.out.println("Program concluded");
}
    
    
  }
}