package pro.sky.course2.v.aliyev.employeebookstreams.model;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final float salary;
    private final int department;

    /**
     * Constructor
     *
     * @param firstName     - firstname
     * @param lastName      - lastname
     * @param salary        - salary
     * @param departmentId  - department ID
     */
    public Employee(String firstName, String lastName, float salary, int departmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = departmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public float getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ": salary = " + salary + ", department " + department;
    }

    @Override
    public int hashCode() {
        return 29 * firstName.hashCode() + 31 * lastName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean result;
        if (this == obj) {
            result = true;
        } else if (obj == null || getClass() != obj.getClass()) {
            result = false;
        } else {
            result = Objects.equals(firstName, ((Employee) obj).firstName) && Objects.equals(lastName, ((Employee) obj).lastName);
        }
        return result;
    }
}
