/**
* @description A students manage system entry program
* @author Henry
* @version 0.0.1.20170613
*
*/

import java.util.Scanner;

public class EntryProgram{
    
    public static void main(String[] args){
        StudentsMgmtSys stuMgmtSys = new StudentsMgmtSys();
        while(true){
            stuMgmtSys.printMenu();
            stuMgmtSys.getUserChoice();
        }
        
    }
}

/**
*
* @description A students manage system class. (This system has no halfway exit operation judgment.)
* @author Henry
* @version 0.0.1.20170613
*
*/
class StudentsMgmtSys{
    private final int TOTAL_NUMBER = 100;
    private final int PAGE_LINES = 10;
    private final int NOT_EXISTS_INDEX = -1;
    private Student[] stuArr = new Student[TOTAL_NUMBER];
    private int currentIndex = 0;
    private int numOfStudent = 0; // the number of student.
    
    /**
    *
    * @description Print a system menu.
    *
    */
    public void printMenu(){
        System.out.println("********************************************");
        System.out.println("|           1. Add Student                 |");
        System.out.println("|           2. Show Students               |");
        System.out.println("|           3. Update Student              |");
        System.out.println("|           4. Delete Student              |");
        System.out.println("|           5. Select Student              |");
        System.out.println("|           6. Exit System                 |");
        System.out.println("|     Please input your choice(1-6):       |");
        System.out.println("********************************************");
        
    }
    
    /**
    *
    * @description Get user choice.
    *
    */
    public void getUserChoice(){
        Scanner in = new Scanner(System.in);
        System.out.print("Please input your choice: ");
        // get user choice and excute the suitable method.
        try{
            int userChoice = in.nextInt();
            excuteMethod(userChoice);
            
        }catch(Exception e){
            System.out.println("Please input the right number.");
        }
    }
     /**
    *
    * @description Excute the suitable method.
    * @param userChoice
    *               user choice - a number in the menu.
    *
    */
    public void excuteMethod(int userChoice){
        switch(userChoice){
            case 1:
                // add student information.
                checkActionResult(addStudent());
                break;
                
            case 2:
                // show all student information.
                showStudentInfo();
                break;
            
            case 3:
                // update student information.
                checkActionResult(updateStudentInfo());
                break;
                
            case 4:
                // delete student information.
                checkActionResult(deleteStudentInfo());
                break;
                
            case 5:
                // select student information.
                selectStudentInfo();
                break;
                
            case 6:
                // exit this system.
                System.exit(0);
                break;
                
            default:
                System.out.println("Please input the right number.");
                break;
            
        }
    }
    
    /**
    *
    * @description check action result.
    * @param result
    *             user action result - a boolean value.
    *
    */
    public void checkActionResult(boolean result){
        if(result){
            System.out.println("Successed!");
            
        }else{
            System.out.println("Failed!");
            
        }
    }
    
    /**
    *
    * @description Add a student into system.
    * @return isSuccessed
    *           true - insert student information successed.
    *           false - insert student information failed.
    *
    */
    private boolean addStudent(){
        // init a scanner.
        Scanner in = new Scanner(System.in);
        boolean isSuccessed = false;
        
        while(true){
            // get user input information.
            System.out.println("Exit by E/e!");
            System.out.print("Please input student number: ");
            String stuNumber = in.nextLine();
            if(checkExit(stuNumber)){
                break;
            }            
            // check the student number, if it is exists, let user known it.
            if(checkStuExists(stuNumber) != NOT_EXISTS_INDEX){
                System.out.println("This student number is exists, please try other.");
            }else{
                // get the rest of student information.
                System.out.print("Please input student name: ");
                String stuName = in.nextLine();
                if(checkExit(stuNumber)){
                break;
                }
                System.out.print("Please input student class: ");
                String stuClass = in.nextLine();
                if(checkExit(stuNumber)){
                break;
                }   
                // save student information.
                Student stuTmp = new Student(stuNumber, stuName, stuClass);
                
                // check if the index can be insert.
                if(insertStuInfo(stuTmp)){
                    isSuccessed = true;
                    numOfStudent++;
                    break;
                }
            }
        }
        return isSuccessed;
    }
    
    /**
    *
    * @description check if student is exists.
    * @param stuNumber
    *           student number - String.
    * @return  index
    *           index - this student is in the students system and return a index of this student.
    *           NOT_EXISTS_INDEX - this student is not in the students system, return NOT_EXISTS_INDEX.
    *
    */
    private int checkStuExists(String stuNumber){
        for(int index = 0; index < TOTAL_NUMBER; index++){
            // If student information is currect, check student by student number.
            if(stuArr[index] != null){
                if(stuNumber.equals(stuArr[index].getStuNumber())){
                    return index;
                }
            }
        }
        return NOT_EXISTS_INDEX;
    }
    
    /**
    *
    * @description Insert student information.
    * @param student
    *           a student instance - Student.
    * @return isSuccessed
    *           true - insert student information successed.
    *           false - insert student information failed.
    *
    */
    private boolean insertStuInfo(Student student){
        boolean isSuccessed = false;
        // check if the index can be insert.
        // if not, let user known it.
        int tmpIndex = currentIndex;
        while((currentIndex < TOTAL_NUMBER) && (stuArr[currentIndex] != null)){
            currentIndex++;
        }
        if(currentIndex < TOTAL_NUMBER){
            stuArr[currentIndex] = student;
            isSuccessed = true;
        }else{
            // if currentIndex is bigger than TOTAL_NUMBER,
            // let it be a zero and try to check again and end of tmpIndex.
            for(currentIndex = 0; currentIndex < tmpIndex; currentIndex++){
                if(stuArr[currentIndex] == null){
                    stuArr[currentIndex] = student;
                    isSuccessed = true;
                }
            }
            
            // if this system can not be store more student, exit this system.
            System.out.println("This system is unable to store more students.");
            
        }
        
        return isSuccessed;
    }
    
    /**
    *
    * @description check if the user want to exit.
    * @param userInput
    *           user input information - String.
    * @param isExit
    *           true - end this action.
    *           false - continue this action.
    *
    */
    private boolean checkExit(String userInput){
        boolean isExit = false;
        if("E".equals(userInput) || "e".equals(userInput)){
            isExit = true;
        }
        return isExit;
    }
    
    /**
    *
    * @description show students information.
    *
    */
    private void showStudentInfo(){
        if(numOfStudent <= 0){
            System.out.println("This system has no student, please add it.");
            return;
        }
        Scanner in = new Scanner(System.in);
        // get all students in a temp array.
        Student[] tmpStuArr = new Student[numOfStudent];
        int tmpIndex = 0;
        for(Student tmpStu : stuArr){
            if((tmpIndex < numOfStudent) && (tmpStu != null)){
                tmpStuArr[tmpIndex] = tmpStu;
                tmpIndex++;
            }
        }
        
        // make a hint for the number of student and pages.
        int begin = 0;
        int currentPage = 1;
        int totalPages = 1;
        if(numOfStudent%PAGE_LINES == 0){
            totalPages = numOfStudent / PAGE_LINES;
        }else{
            totalPages = (numOfStudent /PAGE_LINES) + 1;
        }
        while(true){
            System.out.println("The number of student : " + numOfStudent 
                                + "\t Page : " + currentPage + "/" + totalPages);
            printStudentInfo(tmpStuArr, begin);
            
            // make a hint for user to choose the page.
            System.out.println("Exit by E/e!");
            System.out.print("Please input the page number : ");
            String strInput = in.nextLine();
            if(checkExit(strInput)){
                break;
            }else{
                // get user input page numebr.
                try{
                    int pageNum = Integer.parseInt(strInput);
                    //System.out.println(totalPages);
                    if((pageNum > 0) && (pageNum <= totalPages)){
                        currentPage = pageNum;
                        begin = (pageNum - 1) * PAGE_LINES;
                    }else{
                        System.out.println("Please input the right number.");
                    }
                }catch(Exception e){
                    System.out.println("Please input the right number.");
                }
            }
        }
    }
    
    /**
    *
    * @description print student information by page.
    *
    */
    private void printStudentInfo(Student[] tmpStuArr, int begin){
        int end = begin + PAGE_LINES;
        if(tmpStuArr.length < end){
            end = tmpStuArr.length;
        }
        for(int i = begin; i < end; i++){
            System.out.println(tmpStuArr[i].toString());
        }
    }
    
    /**
    *
    * @description update a student information in system.
    * @return isSuccessed
    *           true - update student information successed.
    *           false - update student information failed.
    *
    */
    private boolean updateStudentInfo(){
        Scanner in = new Scanner(System.in);
        boolean isSuccessed = false;
        while(true){
            // make a hint for user to input his choice.
            System.out.println("Exit by E/e!");
            System.out.print("Please input the student number: ");
            String strInput = in.nextLine();
            
            // check the user input information
            if(checkExit(strInput)){
                break;
            }else{
                int iStuIndex = checkStuExists(strInput);
                if(iStuIndex != NOT_EXISTS_INDEX){
                    
                    // if student exists, change user information by user.
                    System.out.println("The Student information :");
                    System.out.println(stuArr[iStuIndex].toString());
                    
                    // update student detail.
                    System.out.print("Please input student name :");
                    String strTmp = in.nextLine();
                    stuArr[iStuIndex].setStuName(strTmp);
                    System.out.print("Please input student class :");
                    strTmp = in.nextLine();
                    stuArr[iStuIndex].setStuClass(strTmp);
                    isSuccessed = true;
                    break;
                    
                }else{
                    System.out.println("This student is not in the system, please add it.");
                    
                }
                
            }
        }
        return isSuccessed;
    }
    
    /**
    *
    * @description delete a student information in system.
    * @return isSuccessed
    *           true - delete student information successed.
    *           false - delete student information failed.
    *
    */
    private boolean deleteStudentInfo(){
        boolean isSuccessed = false;
        Scanner in = new Scanner(System.in);
        while(true){
            // make a hint for user to input his choice.
            System.out.println("Exit by E/e!");
            System.out.print("Please input the student number: ");
            String strInput = in.nextLine();
            
            // check the user input information
            if(checkExit(strInput)){
                break;
            }else{
                
                int iStuIndex = checkStuExists(strInput);
                if(iStuIndex != NOT_EXISTS_INDEX){
                    // if student is exists, delete student information.
                    stuArr[iStuIndex] = null;
                    numOfStudent--;
                    isSuccessed = true;
                    break;
                }else{
                    System.out.println("This student is not in the system.");
                }
            }
        }
        return isSuccessed;
    }
    
    /**
    *
    * @description select a student information in system.
    * 
    */
    private void selectStudentInfo(){
        Scanner in = new Scanner(System.in);
        while(true){
            // make a hint for user to input his choice.
            System.out.println("Exit by E/e!");
            System.out.print("Please input the student number: ");
            String strInput = in.nextLine();
            
            // check the user input information
            if(checkExit(strInput)){
                break;
            }else{
                int iStuIndex = checkStuExists(strInput);
                if(iStuIndex != NOT_EXISTS_INDEX){
                    // if student exists, show user information.
                    System.out.println("The Student information :");
                    System.out.println(stuArr[iStuIndex].toString());
                    break;
                }else{
                    
                    System.out.println("This student is not in the system, please add it.");
                }
            }
            
        }
    }
}

/**
*
* @description A student class.
* @author Henry
* @version 0.0.1.20170613
*
*/
class Student{
    
    private String stuNumber;
    private String stuName;
    private String stuClass;
    
    /**
    *
    * @description Init a student with empty information.
    *
    */
    public Student(){
        // do nothing.
    }
    
    
    /**
    *
    * @description Init a student with student number, student name, student class.
    * @param stuNumber
    *           student number - String.
    * @param stuName
    *           student name - String.
    * @param stuClass
    *           student class - String.
    *
    */
    public Student(String stuNumber, String stuName, String stuClass){
        this.stuNumber = stuNumber;
        this.stuName = stuName;
        this.stuClass = stuClass;
    }
    
    /*
    *
    * @description stuNumber setter method.
    * @param stuNumber
    *           student number - String.
    *
    */
    public void setStuNumber(String stuNumber){
        this.stuNumber = stuNumber;
        
    }
    
    /*
    *
    * @description stuNumber getter method.
    * @return stuNumber
    *           student number - String.
    *
    */
    public String getStuNumber(){
        return stuNumber;
        
    }
    
    /*
    *
    * @description stuName setter method.
    * @param stuName
    *           student name - String.
    *
    */
    public void setStuName(String stuName){
        this.stuName = stuName;
        
    }
    
    /*
    *
    * @description stuName getter method.
    * @return stuName
    *           student name - String.
    *
    */
    public String getStuName(){
        return stuName;
        
    }
    
    /*
    *
    * @description stuClass setter method.
    * @param stuClass
    *           student class - String.
    *
    */
    public void setStuClass(String stuClass){
        this.stuClass = stuClass;
        
    }
    
    /*
    *
    * @description stuClass getter method.
    * @return stuClass
    *           student class - String.
    *
    */
    public String getStuClass(){
        return stuClass;
        
    }
    
    public String toString(){
        return "Student number : " + stuNumber 
                + " Student name : " + stuName 
                + " Student class : " + stuClass;
        
    }
}