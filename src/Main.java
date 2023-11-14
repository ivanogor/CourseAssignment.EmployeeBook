public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Валентина", 1, 550_000);
        employees[1] = new Employee("Иван", 4, 356_000);
        employees[2] = new Employee("Мирослав", 2, 30_000);
        employees[3] = new Employee("Юлия", 4, 350_000);
        employees[4] = new Employee("Павел", 3, 550_000);
        employees[5] = new Employee("Владимир", 2, 650_000);
        employees[6] = new Employee("Петр", 1, 250_000);
        employees[7] = new Employee("Дмитрий", 3, 650_000);
        employees[8] = new Employee("Соня", 5, 150_000);
        employees[9] = new Employee("Джек", 5, 350_000);

        Employee.displayDepartamentInformation(employees, 1);


        Employee.findWorkersWithSalaryLessThanNumber(employees, 500_000);
        Employee.findWorkersWithSalaryGreaterThanNumber(employees, 250_000);



    }
}

class Employee {
    final private String name;
    private int department;
    private double salary;
    final private int id;
    private static int nextId = 1;

    public Employee(String name, int department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }


    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static String lowestSalaryInTheDepartment(Employee[] employees, int department) {
        double minSalary = Double.MAX_VALUE;
        String worker = "";

        for (Employee employee : employees) {
            if (employee.getDepartment() == department && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                worker = employee.getName();
            }
        }
        return worker;
    }

    public static String biggestSalaryInTheDepartment(Employee[] employees, int department){
        double maxSalary = Double.MIN_VALUE;
        String worker = "";

        for (Employee employee : employees) {
            if (employee.getDepartment() == department && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                worker = employee.getName();
            }
        }
        return worker;
    }

    public static double salaryCostsInTheDepartment(Employee[] employees, int department){
        double sum = 0;

        for (Employee employee: employees){
            if(employee.getDepartment() == department){
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static double averageSalary(Employee[] employees, int department){
        int countOfEmloyeesInTheDepartament = 0;
        double sumOfSalaryInTheDepartment = Employee.salaryCostsInTheDepartment(employees, department);

        for (Employee employee: employees) {
            if(employee.getDepartment() == department){
                countOfEmloyeesInTheDepartament += 1;
            }
        }
        return sumOfSalaryInTheDepartment / countOfEmloyeesInTheDepartament;
    }

    public static void indexedSalary(Employee[] employees, double indexingParametr){
        double newSalary;
        for (Employee employee: employees){
            newSalary = employee.getSalary() * (1 + indexingParametr / 100);
            employee.setSalary(Math.round(newSalary));
        }
    }

    public static void displayDepartamentInformation(Employee[] employees, int department){
        System.out.println(department + " отдел. \n");

        System.out.println("Сотрудник с минимальной зарплатой - " + Employee.lowestSalaryInTheDepartment(employees, department));
        System.out.println("Сотрудник с максимальной зарплатой - " + Employee.biggestSalaryInTheDepartment(employees, department));
        System.out.println("Сумму затрат на зарплату по отделу - " + salaryCostsInTheDepartment(employees, department));
        System.out.println("Средняя зарпалата по отделу - " + Employee.averageSalary(employees, department));
        Employee.indexedSalary(employees, 13);
        Employee.displayEployeeInformation(employees, department);
    }

    public static void displayEployeeInformation(Employee[] employees, int department){
        for (Employee employee : employees){
            if (department == employee.getDepartment()) {
                System.out.println("----------------------------");
                System.out.println("Id - " + employee.getId());
                System.out.println("Имя - " + employee.getName());
                System.out.println("Зарплата -  " + employee.getSalary() + " рублей.");
            }
        }
        System.out.println();
    }

    public static void findWorkersWithSalaryLessThanNumber(Employee[] employees, int number){
        System.out.println("Работники с зарплатой меньше " + number + " рублей:");
        for (Employee employee : employees) {
            if (employee.getSalary() < number) {
                System.out.println("----------------------------");
                System.out.println("Id - " + employee.getId());
                System.out.println("Имя - " + employee.getName());
                System.out.println("Зарплата -  " + employee.getSalary() + " рублей");
            }
        }
        System.out.println();
    }

    public static void findWorkersWithSalaryGreaterThanNumber(Employee[] employees, int number){
        System.out.println("Работники с зарплатой больше " + number + " рублей:");
        for (Employee employee : employees) {
            if (employee.getSalary() > number) {
                System.out.println("----------------------------");
                System.out.println("Id - " + employee.getId());
                System.out.println("Имя - " + employee.getName());
                System.out.println("Зарплата -  " + employee.getSalary() + " рублей.");
            }
        }
    }
}