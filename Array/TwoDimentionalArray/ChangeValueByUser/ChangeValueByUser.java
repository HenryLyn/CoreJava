/**
*
* @description Change phalanx array value by user.
* @author Henry
* @date 20170610
* @version 0.0.1.20170610
*
*/

import java.util.Scanner;
import java.util.Arrays;

public class ChangeValueByUser{
    
    public static void main(String[] args){
        
        // init a string to save coordinate.
        String strCoordinate = "";
        
        // init a scanner.
        Scanner in = new Scanner(System.in);
        
        // init a phalanx array.
        char[][] chPhalanx = new char[4][4];
        for(int i = 0; i < 4; i++){
            Arrays.fill(chPhalanx[i], '*');
        }
        
        // get user input coordinate and change phalanx.
        // exit by the diagonal with $.
        while(true){
            
            printTwoDementionalArray(chPhalanx);

            if(checkExit(chPhalanx)){
                break;
            }else{
                System.out.print("Please input a coordinate, separate by ',': ");
                strCoordinate = in.nextLine();
                
                try{
                    String[] strTmp = strCoordinate.split(",");
                    int x = Integer.parseInt(strTmp[0]);
                    int y = Integer.parseInt(strTmp[1]);
                    
                    if((x > 4) || (y > 4)){
                        System.out.println("Input error! please try again.");
                    }else{
                        chPhalanx[x - 1][y - 1] = '$';
                    }
                }catch(Exception e){
                    System.out.println("Input error! please try again.");
                    continue;
                }
            }
        }
    }
    
    /**
    *
    * @description Print two-dimentional char array.
    * @author Henry
    * @param array
    *
    */
    public static void printTwoDementionalArray(char[][] array){
        
        for(char[] i : array){
            for(char j : i){
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }
    
    /**
    *
    * @description Check the exit condition.
    * @author Henry
    * @param array
    * @return isExit
    *
    */
    public static boolean checkExit(char[][] array){
        
        for(int i = 0, j = 0; (i < array.length) && (j < array[i].length); i++, j++){
            if('$' != array[i][j]){
                return false;
            }
        }
        return true;
    }
}