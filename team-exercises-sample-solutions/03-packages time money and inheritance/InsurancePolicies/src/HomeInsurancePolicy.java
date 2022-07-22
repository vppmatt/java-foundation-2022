import java.math.*;

public class HomeInsurancePolicy extends InsurancePolicy {

    private String address;
    private int yearBuilt;

    public HomeInsurancePolicy() {
        super();
    }

    public HomeInsurancePolicy(long policyNumber, String title, String firstName, String surname, long sumInsured, BigDecimal price, boolean active, String address, int yearBuilt) {
        super(policyNumber, title, firstName, surname, sumInsured, price, active);
        this.address = address;
        this.yearBuilt = yearBuilt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }
}