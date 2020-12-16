import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        //int variable to store user input
        int userInput;
        //created scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number you want to reverse.");
        //reads user input and stores in variable
        userInput = scanner.nextInt();
        while(userInput>0){
            //modulus gives the remainder of input
            System.out.print(userInput%10);
            //divides by 10 to remove last element
            userInput = userInput/10;
        }

    }
}
