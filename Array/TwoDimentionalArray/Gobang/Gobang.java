/**
*
* @description gobang
* @author Henry
* @date 20170611
* @version 0.0.1.20170611
*
*/

import java.util.Scanner;
import java.util.Arrays;

public class Gobang{
    
    static String EXIT = "EXIT";
    static String AVAILABLE = "AVAILABLE";
    static String UNAVAILABLE = "UNAVAILABLE";
    static String ERROR = "ERROR";
    
    static char[][] chCheckerboard = new char[10][10];
    static boolean isPlayer1 = true;
    static char chPlayerSign = '$';
    static String strCoordinate = "";
    static int iX = -1;
    static int iY = -1;
    
    public static void main(String[] args){
        
        // init checkerboard
        for(int i = 0; i < 10; i++){
            Arrays.fill(chCheckerboard[i], '*');
        }        
        
        // init scannner.
        Scanner in = new Scanner(System.in);
        while(true){
            printCheckerboard();
            System.out.println("Exit by -1");
            if(isPlayer1){
                chPlayerSign = '$';
                isPlayer1 = false;
            }else{
                chPlayerSign = '#';
                isPlayer1 = true;
            }
            System.out.print("Please input coordinate ( " + chPlayerSign + " ) : ");
            strCoordinate = in.nextLine();
            String strRet = checkUserInputDate();
            
            /*
            *  judge the result.
            */
            if(strRet == EXIT){
                return;
            }else if(strRet == ERROR){
                System.out.println("coordinate error, please try again.");
                isPlayer1 = !isPlayer1;
            }else if(strRet == UNAVAILABLE){
                System.out.println("coordinate was already used, please try again.");
                isPlayer1 = !isPlayer1;
            }else if(strRet == AVAILABLE){
                chCheckerboard[iX][iY] = chPlayerSign;
                if(checkVictory()){
                    printCheckerboard();
                    System.out.println(chPlayerSign + " is victor!!!");
                    return;
                }
                
            }
            
        }
    }
    
    /**
    *
    * @description Pring checkerboard.
    * @author Henry
    *
    */
    public static void printCheckerboard(){
        for(char[] chTmpArr : chCheckerboard){
            for(char chTmp : chTmpArr){
                System.out.print(chTmp + "  ");
            }
            System.out.println();
        }
        
    }
    
    /**
    *
    * @description Check user input date.
    * @author Henry
    *
    */
    public static String checkUserInputDate(){
        if("-1".equals(strCoordinate)){
            return EXIT;
        }else{
            try{
                String[] strTmp = strCoordinate.split(",");
                iX = (Integer.parseInt(strTmp[0])) - 1; 
                iY = (Integer.parseInt(strTmp[1])) - 1;
                if((iX < 0) || (iX > 9) || (iY > 9) || (iY < 0)){
                    return ERROR;
                }else{
                    if(chCheckerboard[iX][iY] != '*'){
                        return UNAVAILABLE;
                    }else{
                        return AVAILABLE;
                    }
                }
                
            }catch(Exception e){
                return ERROR;
            }
        }
        
    }
    
    /**
    *
    * @description Check the winner.
    * @author Henry
    * @return isVectory.
    *
    */
    public static boolean checkVictory(){
        int count = 1;
        // check left.
        for(int y = iY - 1; y >= 0 ? (chCheckerboard[iX][y] == chPlayerSign) : false; y--){
            count += 1;
        }
        
        // check right.
        for(int y = iY + 1; y < 10 ? (chCheckerboard[iX][y] == chPlayerSign) : false; y++){
            count += 1;
        }
        
        // check victory condition
        if(count >= 5){
            return true;
        }else{
            count = 1;
        }
        
        // check above.
        for(int x = iX - 1; x >= 0 ? (chCheckerboard[x][iY] == chPlayerSign) : false; x--){
            count += 1;
            
        }
        
        // check below.
        for(int x = iX + 1; x < 10 ? (chCheckerboard[x][iY] == chPlayerSign) : false; x++){
            count += 1;
        }
        
        // check victory condition.
        if(count >= 5){
            return true;
        }else{
            count = 1;
        }
        
        // check top left.
        for(int x = iX - 1, y = iY - 1;  ((x > 0) && (y > 0))? (chCheckerboard[x][y] == chPlayerSign) : false; x--, y--){
            count += 1;
        }
        
        // check bottom right.
        for(int x = iX + 1, y = iY + 1; ((x < 10) && (y < 10)) ? (chCheckerboard[x][y] == chPlayerSign) : false; x++, y++){
            count += 1;
        }
        
        // check victory condition.
        if(count >= 5){
            return true;
        }else{
            count = 1;
        }
        
        // check top right.
        for(int x = iX + 1, y = iY - 1; ((x < 10) && (y > 0)) ? (chCheckerboard[x][y] == chPlayerSign) : false; x++, y--){
            count += 1;
        }
        
        // check bottom left.
        for(int x = iX - 1, y = iY + 1; ((x > 0) && (y < 10)) ? (chCheckerboard[x][y] == chPlayerSign) : false; x--, y++){
            count += 1;
        }
        // check victory condition.
        if(count >= 5){
            return true;
        }else{
            return false;
        }
    }
    
}