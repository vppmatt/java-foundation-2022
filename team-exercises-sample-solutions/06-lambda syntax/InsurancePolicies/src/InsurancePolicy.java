import java.math.*;
import java.time.*;
import java.util.*;

public abstract class InsurancePolicy {
    private  long policyNumber;
    private String title;
    private String firstName;
    private String surname;
    private long sumInsured;
    private BigDecimal price;
    private boolean active;
    private LocalDate startDate;
    private PolicyType policyType;

    public InsurancePolicy(PolicyType policyType) {
        this.startDate = LocalDate.now();
        this.policyType = policyType;
    }

    public InsurancePolicy(long policyNumber, String title, String firstName, String surname, long sumInsured, BigDecimal price, boolean active, PolicyType policyType) {
        this.policyNumber = policyNumber;
        this.title = title;
        this.firstName = firstName;
        this.surname = surname;
        this.sumInsured = sumInsured;
        this.price = price;
        this.active = active;
        this.startDate = LocalDate.now();
    }

    public long getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(long policyNumber) {
        this.policyNumber = policyNumber;
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
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(long sumInsured) {
        this.sumInsured = sumInsured;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getMailingName() {
        return title + " " + firstName + " " + surname;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public PolicyType getPolicyType() {
        return policyType;
    }

    public void setPolicyType(PolicyType policyType) {
        this.policyType = policyType;
    }

    @Override
    public String toString() {
        return "InsurancePolicy{" +
                "policyNumber=" + policyNumber +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", sumInsured=" + sumInsured +
                ", price=" + price +
                ", active=" + active +
                ", startDate=" + startDate +
                ", policyType=" + policyType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsurancePolicy that = (InsurancePolicy) o;
        return policyNumber == that.policyNumber && sumInsured == that.sumInsured && active == that.active && Objects.equals(title, that.title) && Objects.equals(firstName, that.firstName) && Objects.equals(surname, that.surname) && Objects.equals(price, that.price) && Objects.equals(startDate, that.startDate) && policyType == that.policyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber, title, firstName, surname, sumInsured, price, active, startDate, policyType);
    }
}
