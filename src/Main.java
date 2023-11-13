public class Main {
    public static void main(String[] args) {
        Employee[] employers = new Employee[10];
        employers[0] = new Employee("Валентина", 1, 550_000);
        employers[1] = new Employee("Иван", 1, 356_000);
        employers[2] = new Employee("Мирослав", 2, 30_000);
        employers[3] = new Employee("Юлия", 4, 350_000);
        employers[4] = new Employee("Павел", 3, 550_000);
        employers[5] = new Employee("Владимир", 2, 650_000);
        employers[6] = new Employee("Петр", 1, 250_000);
        employers[7] = new Employee("Димас", 3, 650_000);
        employers[8] = new Employee("Соня", 2, 150_000);
        employers[9] = new Employee("Джек", 2, 350_000);


        for (Employee n : employers) {
            System.out.println("Меня зовут " + n.getName() + ". ");
            System.out.println("Я работаю в " + n.getDepartment() + " отделе.");
            System.out.println("Мой id - " + n.getId() + ".");
            System.out.println("Моя зарплата - " + n.getSalary() + ". ");

            System.out.println();
        }

    }
}

class Employee {
    final private String name;
    private int department;
    private int salary;
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

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }


    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


}