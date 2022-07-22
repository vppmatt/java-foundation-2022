public class Main {

    public static void main(String[] args) {
        InsurancePolicy policy1 = new InsurancePolicy(1,"Mr", "Albert", "Smith", 50000,1422, true);
        InsurancePolicy policy2 = new InsurancePolicy(2,"Prof", "Susie", "Jones", 45000,1399, true);
        InsurancePolicy policy3 = new InsurancePolicy(3,"Dr", "Arnold", "Wilson", 72000,1651, false);
        InsurancePolicy policy4 = new InsurancePolicy(4,"Mrs", "Shiobhan", "Montgomery", 150000,2044, true);
        InsurancePolicy policy5 = new InsurancePolicy(5,"Mme", "Divina", "Dales", 33000,1388, false);
        InsurancePolicy policy6 = new InsurancePolicy(6,"Rev", "Colin", "Markham", 19000,1201, true);

        InsurancePolicy[] policies = {policy1, policy2, policy3, policy4, policy5, policy6};
        int totalStartingWithA  = 0;
        for (InsurancePolicy policy : policies) {
            System.out.println(policy.getMailingName());
            if (policy.getFirstName().startsWith("A")) totalStartingWithA++;
        }
        System.out.println("The number of policies with a firstname starting with the letter A is " + totalStartingWithA);

    }
}
