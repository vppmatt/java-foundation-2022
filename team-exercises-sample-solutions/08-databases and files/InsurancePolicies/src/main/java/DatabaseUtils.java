import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {

    String connectionString = "jdbc:mysql://localhost:3306/InsurancePolicies?user=root&password=password&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/London&useSSL=false";

    public DatabaseUtils() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    public List<InsurancePolicy> getAll() {

        List<InsurancePolicy> results = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString);
             Statement statement = connection.createStatement();
             ResultSet allPolicies = statement.executeQuery("SELECT * FROM InsurancePolicy")) {
            while (allPolicies.next()) {

                InsurancePolicy newPolicy;

                if (allPolicies.getString("policyType").equals("MOTOR")) {
                    MotorInsurancePolicy mip = new MotorInsurancePolicy();
                    mip.setMake(allPolicies.getString("make"));
                    mip.setModel(allPolicies.getString("model"));
                    mip.setYearOfRegistration(allPolicies.getInt("yearOfRegistration"));
                    newPolicy = mip;
                }
                else {
                    HomeInsurancePolicy hip = new HomeInsurancePolicy();
                    hip.setAddress(allPolicies.getString("address"));
                    hip.setYearBuilt(allPolicies.getInt("yearBuilt"));
                    newPolicy = hip;
                }

                newPolicy.setTitle(allPolicies.getString("title"));
                newPolicy.setFirstName(allPolicies.getString("firstName"));
                newPolicy.setSurname(allPolicies.getString("surname"));
                newPolicy.setSumInsured(allPolicies.getLong("sumInsured"));
                newPolicy.setPrice(allPolicies.getBigDecimal("price"));
                newPolicy.setActive(allPolicies.getBoolean("active"));
                newPolicy.setStartDate(allPolicies.getDate("startDate").toLocalDate());

                results.add(newPolicy);

            }
        } catch (SQLException | InvalidEntryException e) {
            e.printStackTrace();
        }
        return results;

    }

    public void savePolicy(InsurancePolicy policy) {
        String statement = "INSERT INTO InsurancePolicy (title, firstName, surname, sumInsured,price,active, " +
                "startDate, policyType, address, yearBuilt, make, model, yearOfRegistration) " +
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?);";

        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement stm = connection.prepareStatement(statement);
        ) {
            stm.setString(1,policy.getTitle());
            stm.setString(2, policy.getFirstName());
            stm.setString(3, policy.getSurname());
            stm.setLong(4, policy.getSumInsured());
            stm.setBigDecimal(5, policy.getPrice());
            stm.setBoolean(6, policy.isActive());
           stm.setDate(7, java.sql.Date.valueOf( policy.getStartDate()));
           stm.setString(8, policy.getPolicyType().toString());
           if (policy.getPolicyType() == PolicyType.HOME) {
               HomeInsurancePolicy hPolicy = (HomeInsurancePolicy)policy;
               stm.setString(9, hPolicy.getAddress());
               stm.setInt(10, hPolicy.getYearBuilt());
               stm.setString(11, "");
               stm.setString(12,"");
               stm.setInt(13, 0);
           }
           else {
               MotorInsurancePolicy mPolicy = (MotorInsurancePolicy) policy;
               stm.setString(9, "");
               stm.setInt(10, 0);
               stm.setString(11, mPolicy.getMake());
               stm.setString(12,mPolicy.getModel());
               stm.setInt(13, mPolicy.getYearOfRegistration());
           }

           int result = stm.executeUpdate();
           if (result == 1) {
               System.out.println("Policy saved");
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
