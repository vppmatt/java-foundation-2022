package uk.co.multicode.expenses.domain;

import java.util.*;

public class Employee implements Comparable<Employee> {

    private int id;
    private String title;
    private String firstName;
    private String surname;
    private String jobTitle;
    private Department department;
    private Map<Integer, ExpenseClaim> claims = new HashMap<>();

    public Employee() {
            }

    public Employee(int id, String jobTitle) {
        this.id = id;
        this.jobTitle = jobTitle;
    }

    public Employee(int id, String title, String firstName, String surname, String jobTitle, Department department) {
        this.id = id;
        this.title = title;
        this.firstName = firstName;
        this.surname = surname;
        this.jobTitle = jobTitle;
        this.department = department;
    }

    public String getMailingName() {
        return title + " " + firstName + " " + surname;
    }

    public String getMailingName(boolean firstInitialOnly) {
        if (firstInitialOnly) {
            return title + " " + firstName.substring(0,1) + " " + surname;
        }
        else {
            return title + " " + surname;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() <2) {
            System.out.println("Error - first name must be at least 2 characters");
        }
        else {
            this.firstName = firstName;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Map<Integer, ExpenseClaim> getClaims() {
        return claims;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(title, employee.title) && Objects.equals(firstName, employee.firstName) && Objects.equals(surname, employee.surname) && Objects.equals(jobTitle, employee.jobTitle) && department == employee.department && Objects.equals(claims, employee.claims);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, firstName, surname, jobTitle, department, claims);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", department=" + department +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.surname.compareTo(o.getSurname());
    }
}
