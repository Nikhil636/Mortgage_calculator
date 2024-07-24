import java.text.NumberFormat;

public class MortgageReport {
    private final NumberFormat currencyInstance;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currencyInstance = NumberFormat.getCurrencyInstance();
    }
    public void printPaymentSchedule() {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------");
        for (double balance : calculator.getRemainingBalances())
             System.out.println(currencyInstance.format(balance));
        }

    public void printMortgage() {
        double mortgage= calculator.calculateMortgage();
        String mortgageFormatted = currencyInstance.format(mortgage);
        System.out.println();
        System.out.println("MORTGAG" + "E");
        System.out.println("----------");
        System.out.print("Monthly Payments : "+ mortgageFormatted);
    }
}
