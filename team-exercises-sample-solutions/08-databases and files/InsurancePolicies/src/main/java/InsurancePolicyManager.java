import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class InsurancePolicyManager {

    Scanner scanner = new Scanner(System.in);

    private void getBaseDetails(InsurancePolicy policy) throws InvalidEntryException, InvalidEntryException {
        policy.setPolicyNumber(0);
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

    private void printPolicies(List<InsurancePolicy> policies) {
        System.out.print("Enter 1 for all policies or 2 for only active policies:");
        boolean filterOnActive = scanner.nextLine().toUpperCase().equals("2");
        System.out.print("Enter 1 to sort by Surname or 2 to sort by policy number:");
        String sortPreference = scanner.nextLine().toUpperCase();

        List<InsurancePolicy> policiesToPrint =
        policies.stream()
                .filter( policy -> !filterOnActive || policy.isActive())
                .sorted( (p1,p2) -> sortPreference.equals("1") ? p1.getSurname().compareTo(p2.getSurname()) : Long.compare(p1.getPolicyNumber(),p2.getPolicyNumber()))
                .collect(Collectors.toUnmodifiableList());
        FileUtils.createFile(policiesToPrint);
    }

    public void start() throws InvalidEntryException, ClassNotFoundException {
        DatabaseUtils dbUtils = new DatabaseUtils();

        System.out.print("Enter a new policy? Y/N:");
        boolean another = scanner.nextLine().toUpperCase().equals("Y");
        while (another) {
            InsurancePolicy newPolicy = askCustomerForPolicy();
            dbUtils.savePolicy(newPolicy);
            System.out.print("Enter another policy? Y/N:");
            another = scanner.nextLine().toUpperCase().equals("Y");
        }
        another = true;
        while (another) {
            System.out.print("Do you wish to export the policies to a file? Y/N:");
            another = scanner.nextLine().toUpperCase().equals("Y");
            if (another) {
                List<InsurancePolicy> policies = dbUtils.getAll();
                printPolicies(policies);
            }
        }

    }

}
