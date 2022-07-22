public class PaypalProcessor implements PaymentProcessor {
    @Override
    public boolean takePayment(InsurancePolicy policy) {
        return true;
    }
}
