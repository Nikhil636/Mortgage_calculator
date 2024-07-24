public class Main {
    public static void main(String[] args) {
        int principal= (int) console.readNumber("Principal : ",1000,1_000_000);
        double annualInterest = console.readNumber("Annual interest rate : ",1,30);
        byte years = (byte) console.readNumber("Years : ", 1,30);
        var calculator = new MortgageCalculator(principal,annualInterest,years);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        System.out.println("\n");
        report.printPaymentSchedule();
    }
}
