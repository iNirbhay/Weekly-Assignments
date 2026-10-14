public class CompanyEmployee {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        CompanyEmployee emp1 = new CompanyEmployee("Aarav", 50000);
        CompanyEmployee emp2 = new CompanyEmployee("Bhavna", 60000);
        CompanyEmployee emp3 = new CompanyEmployee("Chetan", 55000);

        CompanyEmployee.printCompanyInfo();
    }
}
