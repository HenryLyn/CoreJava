/**
* @description A entry program for testing employee class.
* @author Henry
* @version 0.0.1.20170614
*
*/
public class EntryProgram{
    public static void main(String[] args){
        testEmployee();
        testSalariedEmployee();
        testHourlyEmployee();
        testSalesEmployee();
        testBasePlusSalesEmployee();
    }
    
    /**
    *
    * @description Testing employee class.
    *
    */
    private static void testEmployee(){
        Employee employee = new Employee("employee", 2);
        System.out.println("Salary of " + employee.name + " in normal month is " + employee.getSalary(1) + "\n"
                            + "Salary of " + employee.name + " in birth month is " + employee.getSalary(2));
    }
    
    /**
    *
    * @description Testing salaried employee class.
    *
    */
    private static void testSalariedEmployee(){
        SalariedEmployee salEmp = new SalariedEmployee("salariedEmployee", 2, 1000);
        System.out.println("Salary of " + salEmp.name + " in normal month is " + salEmp.getSalary(1) + "\n"
                            + "Salary of " + salEmp.name + " in birth month is " + salEmp.getSalary(2));
    }
    
    /**
    *
    * @description Testing hourly employee class.
    *
    */
    private static void testHourlyEmployee(){
        HourlyEmployee houEmp = new HourlyEmployee("hourlyEmployee", 2, 20, 100);
        System.out.println("Salary of " + houEmp.name + " in normal month is " + houEmp.getSalary(1) + "\n"
                            + "Salary of " + houEmp.name + " in birth month is " + houEmp.getSalary(2));
    }
    
    /**
    *
    * @description Testing sales employee class.
    *
    */
    private static void testSalesEmployee(){
        SalesEmployee salEmp = new SalesEmployee("salesEmployee", 2, 10000, 0.5);
        System.out.println("Salary of " + salEmp.name + " in normal month is " + salEmp.getSalary(1) + "\n"
                            + "Salary of " + salEmp.name + " in birth month is " + salEmp.getSalary(2));
    }
    
    /**
    *
    * @description Testing base plus sales employee class.
    *
    */
    private static void testBasePlusSalesEmployee(){
        BasePlusSalesEmployee bpsEmp = new BasePlusSalesEmployee("basePlusSalesEmployee", 2, 5000, 0.2, 3000);
        System.out.println("Salary of " + bpsEmp.name + " in normal month is " + bpsEmp.getSalary(1) + "\n"
                            + "Salary of " + bpsEmp.name + " in birth month is " + bpsEmp.getSalary(2));
    }
}