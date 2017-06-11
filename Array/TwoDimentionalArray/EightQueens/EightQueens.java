/**
*
* @description Arrangement method of eight queens.
* @author Henry
* @date 20170610
* @version 0.0.1.20170610
*
*/

public class EightQueens{
    
    static int[] iUseCoordinate = {-1, -1, -1, -1, -1, -1, -1, -1};
    static int count = 0;
    static int iCycle = 0;
    
    public static void main(String[] args){
        
        tryToPut(0);
        System.out.println(count);
        count = 0;
        tryToPut2(0);
        System.out.println(count);
        
    }
    
    /**
    *
    * @description try to put queen. (including diagonals)
    * @author Henry
    * @param cycles
    *
    */
    public static void tryToPut(int cycles){
        if(cycles == 8){
            count ++;
            return;
        }else{
            for(int i = 0; i < 8; i ++){
                iUseCoordinate[cycles] = i;
                boolean isPut = true;
                for(int j = 0; j < cycles; j ++){
                    if(iUseCoordinate[cycles] == iUseCoordinate[j]){
                        isPut = false;
                        break;
                    }
                }
                if(isPut){
                    tryToPut(cycles + 1);
                }
            }
            
        }
        
    }
    
    /**
    *
    * @description try to put queen. (does not include diagonals)
    * @author Henry
    * @param cycles
    *
    */
    public static void tryToPut2(int cycles){
        if(cycles == 8){
            count ++;
            return;
        }else{
            for(int i = 0; i < 8; i++){
                iUseCoordinate[cycles] = i;
                boolean isPut = true;
                for(int j = 0; j < cycles; j ++){
                if(iUseCoordinate[cycles] == iUseCoordinate[j] 
                    || (iUseCoordinate[cycles] - iUseCoordinate[j] == j - cycles)
                    || (cycles - j == iUseCoordinate[cycles] - iUseCoordinate[j])){
                        isPut = false;
                        break;
                    }
                } 
                if(isPut){
                    tryToPut2(cycles + 1);
                }
            }
            
            
        }
        
    }
}