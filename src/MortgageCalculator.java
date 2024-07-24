public class MortgageCalculator {
    private final static byte totalMonths = 12;
    private final static byte percent= 100;
    private int principal;
    private double annualInterest;
    private byte years;

    public MortgageCalculator(int principal, double annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public  double calculateMortgage(){
        short numbersOfPayments = getNumberOfPayments();
        double monthyInterest = getMonthlyInterest();
        return principal*((monthyInterest*Math.pow((1+monthyInterest),numbersOfPayments))/
                (Math.pow((1+monthyInterest),numbersOfPayments)-1));
    }
    public double calculateBalance(short numbersOfPaymentsMade){
        short numbersOfPayments = getNumberOfPayments();
        double monthyInterest = getMonthlyInterest();
        return principal*(Math.pow((1+monthyInterest),numbersOfPayments)-Math.pow((1+monthyInterest),numbersOfPaymentsMade))/
                (Math.pow((1+monthyInterest),numbersOfPayments)-1);
    }
    public double[] getRemainingBalances(){
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month<= balances.length; month++) {
            balances[month -1]= calculateBalance(month);
        }
        return balances;
    }
    private short getNumberOfPayments() {
        return (short) (years * totalMonths);
    }
    private double getMonthlyInterest() {
        return annualInterest / percent / totalMonths;
    }
}
