/**
* @description A hourly employee class
* @author Henry
* @version 0.0.1.20170614
*
*/
public class HourlyEmployee extends Employee{
    
    private final int TOTAL_HOURS = 160;
    private final double MULTIPLE = 1.5;
    
    public int hourSalary;
    public int hours;
    
    /**
    *
    * @description Construction method.
    * @param name
    *           the name of hourly employee - String.
    * @param birthMonth
    *           the birth month of hourly employee - int.
    * @param hourSalary
    *           the hour salary of hourly employee - int.
    * @param hours
    *           the work hours of hourly employee - int
    *   
    */
    public HourlyEmployee(String name, int birthMonth, int hourSalary, int hours){
        super(name, birthMonth);
        this.hourSalary = hourSalary;
        this.hours = hours;
        
    }
    
    /**
    *
    * @description set employee birth month.
    * @param month
    *           the month of year - int.
    *
    */
    public int getSalary(int month){
        int welfare = super.getSalary(month);
        if(hours < TOTAL_HOURS){
            return ((hourSalary * hours) + welfare);
        }else{
            // if hours > TOTAL_HOURS, compute the multiple salary.
            return (int)((hourSalary * TOTAL_HOURS) 
                    + (hourSalary * MULTIPLE * (hours - TOTAL_HOURS)) 
                    + welfare);
        }
    }
    
}