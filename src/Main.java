public class Main {
    public static void main(String[] args) {
        int max = 11;
        EmployeeBook arr = new EmployeeBook(max);

        Employee valentina = new Employee("Валентина", 1, 550_000);
        Employee ivan = new Employee("Иван", 4, 356_000);
        Employee miroslaw = new Employee("Мирослав", 2, 30_000);
        Employee pavel = new Employee("Павел", 3, 550_000);
        Employee yulia = new Employee("Юлия", 4, 350_000);
        Employee petr = new Employee("Петр", 1, 250_000);
        Employee dmitriy = new Employee("Дмитрий", 3, 650_000);
        Employee sonya = new Employee("Соня", 5, 150_000);
        Employee jack = new Employee("Джек", 5, 350_000);
        Employee vladimir = new Employee("Владимир", 2, 521_000);

        arr.insert(valentina);
        arr.insert(ivan);
        arr.insert(miroslaw);
        arr.insert(pavel);
        arr.insert(yulia);
        arr.insert(petr);
        arr.insert(dmitriy);
        arr.insert(sonya);
        arr.insert(jack);
        arr.insert(vladimir);

        arr.displayInformationAboutEachDepartment();


    }
}