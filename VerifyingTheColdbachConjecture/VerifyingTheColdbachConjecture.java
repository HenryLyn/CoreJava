/**
*
* @date 2017/06/09
* @author Henry
* @description Verifying the Goldbach conjecture.
* @version 0.0.1.20170609
*
*/

import java.util.Scanner;

public class VerifyingTheColdbachConjecture{
    
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        boolean isError = false;
        int number = -1;
        while(true){
            try{
                // get a number by user.
                System.out.println("Exit by -1.");
                System.out.print("Please input a even number, bigger than 6: ");
                number = in.nextInt();
                
            }catch(Exception e){
                isError = true;
                in = new Scanner(System.in);
                System.out.println("Input error, please try again.");
            }
            // Check and verify the number.
            if(isError){
                isError = false;
                continue;
                
            }else if(-1 == number){
                break;
                
            }else if(number < 6){
                System.out.println("Your number is less than 6, please try again.");
                
            }else if(checkIfTheNumberIsPrime(number)){
                System.out.println("Your number is a prime number, please try again.");
            
            }else{
                for(int left = 2; left < (number / 2); left++){
                    if(checkIfTheNumberIsPrime(left)){
                        int right = number - left;
                        if(checkIfTheNumberIsPrime(right)){
                            System.out.println(number + " = " + left + " + " + right);
                        }
                    }
                }
                System.out.println();
            }
        }
    }
    
    /**
    *
    * @description Check if the number is prime.
    * @param number
    * @return isPrime
    *
    */
    public static boolean checkIfTheNumberIsPrime(int number){
        double end = Math.sqrt(number);
        for(int i = 2; i <= end; i++){
            if(0 == (number % i)){
                return false;
            }
        }
        return true;
    }
}