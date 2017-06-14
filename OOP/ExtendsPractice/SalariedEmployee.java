/**
* @description A salaried employee class
* @author Henry
* @version 0.0.1.20170614
*
*/
public class SalariedEmployee extends Employee{
    
    public int monthSalary;
    
    /**
    *
    * @description Construction method.
    * @param name
    *           the name of salaried employee - String.
    * @param birthMonth
    *           the birth month of salaried employee - int.
    * @param monthSalary
    *           the month salary of salaried employee - int.
    * 
    */
    public SalariedEmployee(String name, int birth, int monthSalary){
        super(name, birth);
        this.monthSalary = monthSalary;
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
        return (monthSalary + welfare);
    }
    
}