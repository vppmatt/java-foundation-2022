import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileUtils {

    public static void createFile(List<InsurancePolicy> policies)  {
        String homeFolder = System.getProperty("user.home");
        String separator = File.separator;
        String newLine = System.getProperty("line.separator");

        Path outputFile = Paths.get(homeFolder + separator + "policies.csv");
        if (Files.exists(outputFile)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Output file exists - overwite it? (Y or N): ");
            if (scanner.nextLine().toUpperCase().equals("Y")) {
                try {
                    Files.delete(outputFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                return;
            }
        }

        String firstLine = "policyNumber, title, firstName, surname, sumInsured, price, active, startDate, policyType, " +
                "make, model, yearOfRegistration, address, yearBuilt" + newLine;

        List<String> outputData = policies.stream().map(
                policy -> {
                    String base = policy.getPolicyNumber() + ", \"" + policy.getTitle() + "\", \"" + policy.getFirstName() +
                            "\", \"" + policy.getSurname() +"\", " + policy.getSumInsured() + "," + policy.getPrice() + ", " +
                            policy.isActive() + ", \"" + policy.getStartDate() + "\", \"" + policy.getPolicyType() + "\", ";

                    if (policy.getPolicyType() == PolicyType.MOTOR) {
                        MotorInsurancePolicy mip = (MotorInsurancePolicy)policy;
                        return base + "\"" + mip.getMake() +"\", \"" + mip.getModel() + "\", " + mip.getYearOfRegistration() +
                                ", \"\" , ";
                    }
                    else {
                        HomeInsurancePolicy hip = (HomeInsurancePolicy) policy;
                        return base + "\"\", \"\", , \"" + hip.getAddress() + "\", " + hip.getYearBuilt();
                    }
                }
        ).collect(Collectors.toUnmodifiableList());

        try {
            Files.writeString(outputFile , firstLine);
            Files.write(outputFile, outputData, StandardOpenOption.APPEND);
            System.out.println("Data has been output as " + outputFile.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
