package uk.co.multicode.expenses.utilities;

import uk.co.multicode.expenses.domain.Employee;
import uk.co.multicode.expenses.domain.Employees;

public class EmployeeUtilities {

    public boolean employeeExists(Employees employees, Employee employee) {
        return employees.findBySurname(employee.getSurname()) != null;
    }

}
