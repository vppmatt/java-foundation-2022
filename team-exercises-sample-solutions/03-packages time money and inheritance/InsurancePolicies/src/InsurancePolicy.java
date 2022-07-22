import java.math.*;

public class InsurancePolicy {

    private  long policyNumber;
    private String title;
    private String firstName;
    private String surname;
    private long sumInsured;
    private BigDecimal price;
    private boolean active;

    public InsurancePolicy() {}

    public InsurancePolicy(long policyNumber, String title, String firstName, String surname, long sumInsured, BigDecimal price, boolean active) {
        this.policyNumber = policyNumber;
        this.title = title;
        this.firstName = firstName;
        this.surname = surname;
        this.sumInsured = sumInsured;
        this.price = price;
        this.active = active;
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

}
