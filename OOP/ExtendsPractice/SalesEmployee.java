/**
* @description A sales employee class
* @author Henry
* @version 0.0.1.20170614
*
*/
public class SalesEmployee extends Employee{
    
    public int monthSales;
    public double commissionRate;
    
    /**
    *
    * @description Construction method.
    * @param name
    *           the name of sales employee - String.
    * @param birthMonth
    *           the birth month of sales employee - int.
    * @param monthSales
    *           the month sales of sales employee - double.
    * @param commissionRate
    *           the commission rate of sales employee - int
    *   
    */
    public SalesEmployee(String name, int birthMonth, int monthSales, double commissionRate){
        super(name, birthMonth);
        this.monthSales = monthSales;
        this.commissionRate = commissionRate;
        
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
        return (int)((monthSales * commissionRate) + welfare);
    }
    
}