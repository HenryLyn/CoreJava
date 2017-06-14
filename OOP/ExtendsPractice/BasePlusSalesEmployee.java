/**
* @description A base plus sales employee class
* @author Henry
* @version 0.0.1.20170614
*
*/
public class BasePlusSalesEmployee extends SalesEmployee{
    
    public int baseSalary;
    /**
    *
    * @description Construction method.
    * @param name
    *           the name of base plus sales employee - String.
    * @param birthMonth
    *           the birth month of base plus sales employee - int.
    * @param monthSales
    *           the month sales of base plus sales employee - int.
    * @param commissionRate
    *           the commission rate of base plus sales employee - double.
    * @param baseSalary
    *           the base salary of base plus sales employee - int.
    *
    */
    public BasePlusSalesEmployee(String name, int birthMonth, int monthSales, double commissionRate, int baseSalary){
        super(name, birthMonth, monthSales, commissionRate);
        this.baseSalary = baseSalary;
        
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
        return (int)(baseSalary + (monthSales * commissionRate) + welfare);
    }
}