/**
*
* @date 2017/06/09
* @author Henry
* @description Using two-dimensional array to save students scores.
* @version 0.0.1.20170609
*
*/
//import java.util.Random;

public class StudentScores{
    
    public static void main(String[] args){
        // Define a two-dimensional array to save students scores.
        // According to the follow order, core C++, core Java, Servlet, JSP and EJB.
        // Randomly assign values.
        int[][] studentsScores = new int[20][5];
        int[] studentsTotalScores = new int[20];
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 5; j++){
                studentsScores[i][j] = (int)(Math.random()*101);
            }
        }
        
        // Print students scores and compute the total scores.
        System.out.println("StuNo \t Core C++ \t Core Java \t Servlet \t JSP \t EJB \t Total Score");
        for(int i = 0; i < 20; i++){
            System.out.print((i + 1) + " \t ");
            int totalScore = 0;
            for(int j = 0; j < 5; j++){
                System.out.print(studentsScores[i][j] + " \t ");
                totalScore += studentsScores[i][j];
            }
            studentsTotalScores[i] = totalScore;
            System.out.print(studentsTotalScores[i]);
            System.out.println();
        }
        
        // Compute the students average score and print the detail.
        System.out.println("Core C++ \t Core Java \t Servlet \t JSP \t EJB");
        for(int i = 0; i < 5; i++){
            int sum = 0;
            for(int j = 0; j < 20; j++){
                sum += studentsScores[j][i];
            }
            System.out.print((sum / 20) + " \t ");
        }
    }
}