

import java.math.*;
import java.util.*;

public class InsurancePolicyManager {

    Scanner scanner = new Scanner(System.in);

    private void getBaseDetails(InsurancePolicy policy) throws InvalidEntryException, InvalidEntryException {
        System.out.print("Policy number: ");
        try {
            policy.setPolicyNumber(Long.parseLong(scanner.nextLine()));
        }
        catch (NumberFormatException e) {
            throw new InvalidEntryException();
        }
        System.out.print("Title: ");
        policy.setTitle(scanner.nextLine());
        System.out.print("First Name: ");
        policy.setFirstName(scanner.nextLine());
        System.out.print("Surname: ");
        policy.setSurname(scanner.nextLine());
        System.out.print("Sum Insured: ");
        try {
            policy.setSumInsured(Long.parseLong(scanner.nextLine()));
        }
        catch (NumberFormatException e) {
            throw new InvalidEntryException();
        }
        System.out.print("Price: ");
        try {
            policy.setPrice(new BigDecimal(scanner.nextLine()));
        }
        catch (NumberFormatException e) {
            throw new InvalidEntryException();
        }
        System.out.print("active? (Y or N): ");
        if (scanner.nextLine().toUpperCase().equals("Y")) {
            policy.setActive(true);
        }
        else {
            policy.setActive(false);
        }
    }

    private InsurancePolicy askCustomerForPolicy() throws InvalidEntryException {
        String type = "";
        while (!type.equals("M") && !type.equals("H")) {
            System.out.println("What type of policy are you creating? (M)otor or (H)ome?");
            type = scanner.nextLine().toUpperCase();
        }
        if (type.equals("M")) {
            MotorInsurancePolicy policy = new MotorInsurancePolicy();
            getBaseDetails(policy);
            System.out.print("make: ");
            policy.setMake(scanner.nextLine());
            System.out.print("model: ");
            policy.setModel(scanner.nextLine());
            System.out.print("year of registration: ");
            policy.setYearOfRegistration(Integer.parseInt(scanner.nextLine()));
            return policy;
        }
        else {
            HomeInsurancePolicy policy = new HomeInsurancePolicy();
            getBaseDetails(policy);
            System.out.print("address: ");
            policy.setAddress(scanner.nextLine());
            System.out.print("year built: ");
            policy.setYearBuilt(Integer.parseInt(scanner.nextLine()));
            return policy;
        }

    }

    public void start() throws InvalidEntryException {
        List<InsurancePolicy> policies = new ArrayList<InsurancePolicy>();
        boolean another = true;
        while (another) {
            policies.add(askCustomerForPolicy());
            System.out.print("Enter another policy? Y/N:");
            another = scanner.nextLine().toUpperCase().equals("Y");
        }
        for (InsurancePolicy policy : policies) {
            System.out.println(policy);
        }
    }

}
