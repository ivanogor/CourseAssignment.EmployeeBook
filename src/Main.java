import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        int max = 11;
        EmployeeBook arr = new EmployeeBook(max);
        arr.insert("Валентина", 1, 550_000);
        arr.insert("Иван", 4, 356_000);
        arr.insert("Мирослав", 2, 30_000);
        arr.insert("Юлия", 4, 350_000);
        arr.insert("Павел", 3, 550_000);
        arr.insert("Владимир", 2, 650_000);
        arr.insert("Петр", 1, 250_000);
        arr.insert("Дмитрий", 3, 650_000);
        arr.insert("Соня", 5, 150_000);
        arr.insert("Джек", 5, 350_000);

        arr.displayInformationAboutEachDepartment();


    }
}

class Employee {
    private String name;
    private int department;
    private double salary;
    final private int id;
    private static int nextId = 1;

    public Employee(String name, int department, double salary) {
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

    public void setName(String name) {
        this.name = name;
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


}

class EmployeeBook {
    private final Employee[] employees;


    public EmployeeBook(int max) {
        employees = new Employee[max];

    }

    public void delete(int id) {
        int index = find(id);
        if (index >= 0) {
            employees[index] = null;

        }
    }

    public void delete(String name) {
        int index = find(name);
        if (index >= 0) {
            employees[index] = null;

        }
    }

    public void insert(String name, int department, double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(name, department, salary);
                break;
            }
        }
    }

    public void changeSalary(String name, double newSalary) {
        int index = find(name);
        if (index >= 0) {
            employees[index].setSalary(newSalary);
        }
    }

    public void changeDepartment(String name, int newDepartment) {
        int index = find(name);
        if (index >= 0) {
            employees[index].setDepartment(newDepartment);
        }
    }

    public int find(String name) {
        int index = -1;
        name = name.toLowerCase();
        for (Employee employee : employees) {
            if (employee != null) {
                String nameInBase = employee.getName().toLowerCase();
                if (Objects.equals(name, nameInBase)) {
                    index = employee.getId() - 1;
                }
            }
        }
        return index;
    }

    public int find(int id) {
        int index = -1;
        for (Employee employee : employees) {
            if (employee != null && id == employee.getId())
                index = employee.getId() - 1;
        }
        return index;
    }

    public String employeeWithLowestSalaryInTheDepartment(int department) {
        double minSalary = Double.MAX_VALUE;
        String worker = "";

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                worker = employee.getName();
            }
        }
        return worker;
    }

    public String employeeWithBiggestSalaryInTheDepartment(int department) {
        double maxSalary = Double.MIN_VALUE;
        String worker = "";

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                worker = employee.getName();
            }
        }
        return worker;
    }

    public double sumOfSalaryInTheDepartment(int department) {
        double sum = 0;

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double averageSalaryInTheDepartment(int department) {
        double sumOfSalaryInTheDepartment = sumOfSalaryInTheDepartment(department);
        int countOfEmloyeesInTheDepartament = countOfEmployeesInTheDepartment(department);

        return sumOfSalaryInTheDepartment / countOfEmloyeesInTheDepartament;
    }

    public int countOfEmployeesInTheDepartment(int department) {
        int countOfEmloyeesInTheDepartament = 0;

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                countOfEmloyeesInTheDepartament += 1;
            }
        }
        return countOfEmloyeesInTheDepartament;
    }

    public void indexSalaries(double indexingParametr) {
        double newSalary;
        for (Employee employee : employees) {
            if (employee != null) {
                newSalary = employee.getSalary() * (1 + indexingParametr / 100);
                employee.setSalary(Math.round(newSalary));
            }
        }
    }


    public void findWorkersWithSalaryLessThanNumber(int number) {
        System.out.println("Работники с зарплатой меньше " + number + " рублей:");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < number) {
                System.out.println("----------------------------");
                System.out.println("Id - " + employee.getId());
                System.out.println("Имя - " + employee.getName());
                System.out.println("Зарплата -  " + employee.getSalary() + " рублей.");
            }
        }
        System.out.println();
    }


    public void findWorkersWithSalaryGreaterThanNumber(int number) {
        System.out.println("Работники с зарплатой больше " + number + " рублей:");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > number) {
                System.out.println("----------------------------");
                System.out.println("Id - " + employee.getId());
                System.out.println("Имя - " + employee.getName());
                System.out.println("Зарплата -  " + employee.getSalary() + " рублей.");
            }
        }
    }

    public void displayDepartamentInformation(int department) {
        System.out.println(department + " отдел. \n");

        System.out.println("Сотрудник с минимальной зарплатой - " + employeeWithLowestSalaryInTheDepartment(department));
        System.out.println("Сотрудник с максимальной зарплатой - " + employeeWithBiggestSalaryInTheDepartment(department));
        System.out.println("Сумму затрат на зарплату по отделу - " + sumOfSalaryInTheDepartment(department));
        System.out.println("Средняя зарпалата по отделу - " + averageSalaryInTheDepartment(department));
        displayEmployeeInTheDepartmentInformation(department);
    }

    public void displayEmployeeInTheDepartmentInformation(int department) {
        for (Employee employee : employees) {
            if (employee != null && department == employee.getDepartment()) {
                System.out.println("----------------------------");
                System.out.println("Id - " + employee.getId());
                System.out.println("Имя - " + employee.getName());
                System.out.println("Зарплата -  " + employee.getSalary() + " рублей.");
            }
        }
        System.out.println();
    }

    public void displayInformationAboutEachDepartment() {
        for (int i = 1; i <= 5; i++) {
            displayDepartamentInformation(i);
        }
    }
}