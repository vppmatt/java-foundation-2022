import java.math.*;
import java.util.*;

public class Main {

public static void main(String[] args) throws InvalidEntryException {
        Scanner scanner = new Scanner(System.in);
        String type = "";
        while (!type.equals("M") && !type.equals("H")) {
            System.out.println("What type of policy are you creating? (M)otor or (H)ome?");
            type = scanner.nextLine().toUpperCase();
        }
        if (type.equals("M")) {
            MotorInsurancePolicy policy = new MotorInsurancePolicy();
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

            System.out.print("make: ");
            policy.setMake(scanner.nextLine());
            System.out.print("model: ");
            policy.setModel(scanner.nextLine());
            System.out.print("year of registration: ");
            try {
            policy.setYearOfRegistration(Integer.parseInt(scanner.nextLine()));
            }
            catch (NumberFormatException e) {
                throw new InvalidEntryException();
            }

            System.out.println(policy);
        }
        else {
            HomeInsurancePolicy policy = new HomeInsurancePolicy();
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
            System.out.print("address: ");
            policy.setAddress(scanner.nextLine());
            System.out.print("year built: ");
            try {
                policy.setYearBuilt(Integer.parseInt(scanner.nextLine()));
            }
            catch (NumberFormatException e) {
                throw new InvalidEntryException();
            }
            System.out.println(policy);
        }
    }

}
