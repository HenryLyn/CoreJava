/**
* @description A employee class
* @author Henry
* @version 0.0.1.20170614
*
*/

public class Employee{
    
    private final int WELFARE = 100;
    
    public String name;
    public int birthMonth;
    
    /**
    *
    * @description Construction method.
    * @param name
    *           the name of employee - String.
    * @param birthMonth
    *           the birth month of employee - int.
    *
    */
    public Employee(String name, int birthMonth){
        this.name = name;
        this.birthMonth = birthMonth;
    }
    
    /**
    *
    * @description get employee salary.
    * @param month
    *           the month of year - int.
    * @return welfare
    *           if the month is employee birth month, return a WELFARE.
    */
    public int getSalary(int month){
        if(month == birthMonth){
            return WELFARE;
        }else{
            return 0;
        }
        
    }
}
