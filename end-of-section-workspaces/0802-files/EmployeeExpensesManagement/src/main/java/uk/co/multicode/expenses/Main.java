package uk.co.multicode.expenses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import uk.co.multicode.expenses.domain.*;

import java.sql.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws JsonProcessingException, ClassNotFoundException, SQLException {
        Employee employee1 = new StaffEmployee();
        employee1.setId(1);
        employee1.setTitle("Mr");
        employee1.setFirstName("Matt");
        employee1.setSurname("Greencroft");

        System.out.println(employee1.getMailingName());
        System.out.println(employee1.getMailingName(true));
        System.out.println(employee1.getMailingName(false));

        Employee employee2 = new Employee(2, "Manager");
        employee2.setTitle("Dr");
        employee2.setFirstName("Denis");
        employee2.setSurname("Yellow");

        EmployeesInMemoryImpl employees = new EmployeesInMemoryImpl();
        employees.addEmployee(employee1);
        employees.addEmployee(employee2);
        employees.addEmployee( new Employee(3, "Mrs", "Susan", "Brown", "Director", Department.MARKETING)  );

        employees.printEmployees();

        Employee foundEmployee = employees.findBySurname("Brown");
        System.out.println("Found " + foundEmployee.getMailingName());

        Employee foundEmployee2 = employees.findBySurname("Cyan");
        System.out.println("Didn't find " + (foundEmployee2 == null));


        ExpenseClaim expenseClaim = new ExpenseClaim(24,642, LocalDate.now());
        System.out.println(expenseClaim.getEmployeeId());
        expenseClaim.setPaid(true);
        System.out.println(expenseClaim.getPaid());
        expenseClaim.setApproved(true);
        expenseClaim.setPaid(true);
        System.out.println(expenseClaim.getPaid());

        ExpenseItem expenseItem = new ExpenseItem(24, 102, ExpenseType.ACCOMODATION, "The Grand Hotel", 69.99);
        System.out.println(expenseItem.getDescription());

        System.out.println(employee1);

        String name1 = "Matt";
        String name2 = "Matt";

        Employee employee3 = new Employee();
        employee3.setId(1);
        employee3.setTitle("Mr");
        employee3.setFirstName("Matt");
        employee3.setSurname("Greencroft");

        System.out.println(employee1.equals(employee3));
        System.out.println(employee1 == employee1);
        System.out.println(employee1.getClass());

        System.out.println(employee1);

        ObjectMapper objectMapper = new ObjectMapper();
        String employee1Json = objectMapper.writeValueAsString(employee1);
        System.out.println(employee1Json);

        StaffEmployee employeeFromJson = objectMapper.readValue(employee1Json, StaffEmployee.class);
        System.out.println(employeeFromJson);

        //Class.forName("com.mysql.cj.jdbc.Driver");
        Class.forName("org.h2.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./customerdata", "sa", ""))
        {

            Statement statement = connection.createStatement();
            //statement.executeUpdate("CREATE TABLE customer (id INTEGER, name VARCHAR(255), age INTEGER, PRIMARY KEY (id) )");
            //statement.executeUpdate("INSERT INTO customer (id, name, age) VALUES (2, 'Sally', 36)");

            ResultSet rs = statement.executeQuery("SELECT * FROM customer");

            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
            }
        }
    }
}
