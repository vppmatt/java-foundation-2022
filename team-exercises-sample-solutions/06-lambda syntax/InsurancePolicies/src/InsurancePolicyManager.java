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

    private void printPolicies(List<InsurancePolicy> policies) {
        System.out.print("Enter 1 for all policies or 2 for only active policies:");
        boolean filterOnActive = scanner.nextLine().toUpperCase().equals("2");
        System.out.print("Enter 1 to sort by Surname or 2 to sort by policy number:");
        String sortPreference = scanner.nextLine().toUpperCase();

        policies.stream()
                .filter( policy -> !filterOnActive || policy.isActive())
                .sorted( (p1,p2) -> sortPreference.equals("1") ? p1.getSurname().compareTo(p2.getSurname()) : Long.compare(p1.getPolicyNumber(),p2.getPolicyNumber()))
                .forEach(System.out::println);
    }

    public void start() throws InvalidEntryException {
        List<InsurancePolicy> policies = new ArrayList<InsurancePolicy>();

        policies.add(new MotorInsurancePolicy(1,"Mr","Simon", "Smith", 16000,new BigDecimal("154.22"),true,"Honda","Jazz",2017));
        policies.add(new HomeInsurancePolicy(3,"Mrs","Sandra", "Jones", 16000,new BigDecimal("154.22"),true,"15 The High St, AnyTown",1967));
        policies.add(new MotorInsurancePolicy(5,"Mr","David", "Carlton", 16000,new BigDecimal("154.22"),false,"Nissan","Micra",2017));
        policies.add(new MotorInsurancePolicy(6,"Miss","Rochelle", "Singer", 16000,new BigDecimal("154.22"),true,"Citroen","Berlingo",2017));
        policies.add(new HomeInsurancePolicy(2,"Dr","Davina", "Price", 16000,new BigDecimal("154.22"),false,"16 The High St, AnyTown",1967));
        policies.add(new MotorInsurancePolicy(8,"Rev","Richard", "Smyth", 16000,new BigDecimal("154.22"),false,"Peugeot","206",2017));
        policies.add(new MotorInsurancePolicy(9,"Lady","Penelope", "Pitstop", 16000,new BigDecimal("154.22"),true,"Fiat","Punto",2017));
        policies.add(new HomeInsurancePolicy(4,"HRH Princess","Beatrice", "Windsor", 16000,new BigDecimal("154.22"),false,"18 The High St, AnyTown",1967));
        policies.add(new HomeInsurancePolicy(7,"Prof","Edward", "Hillard", 16000,new BigDecimal("154.22"),true,"17 The High St, AnyTown",1967));

        boolean another = true;
        while (another) {
            policies.add(askCustomerForPolicy());
            System.out.print("Enter another policy? Y/N:");
            another = scanner.nextLine().toUpperCase().equals("Y");
        }
        another = true;
        while (another) {
            System.out.print("Do you wish to print the policies? Y/N:");
            another = scanner.nextLine().toUpperCase().equals("Y");
            if (another) printPolicies(policies);
        }

    }

}
