public class AmexProcessor implements PaymentProcessor{
    @Override
    public boolean takePayment(InsurancePolicy policy) {
        return false;
    }
}
