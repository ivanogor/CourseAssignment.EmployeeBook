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

    public void insert(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
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
                if (name.equals(nameInBase)) {
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