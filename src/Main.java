import java.text.NumberFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    final static byte totalMonths = 12;
    final static byte percent= 100;
    public static void main(String[] args) {
        int principal= (int) readNumber("Principal : ",1000,1_000_000);
        double annualInterest = readNumber("Annual interest rate : ",1,30);
        byte years = (byte) readNumber("Years : ", 1,30);

        printMortgage(principal, annualInterest, years);
        System.out.println("\n");
        printPaymentSchedule(principal, annualInterest, years);

    }
    private static void printMortgage(int principal, double annualInterest, byte years) {
        double mortgage= calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("----------");
        System.out.print("Monthly Payments : "+ mortgageFormatted);
    }

    private static void printPaymentSchedule(int principal, double annualInterest, byte years) {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------");
        for (short month = 1; month<= years *totalMonths; month++){
        double balance= calculateBalance(principal, annualInterest, years,month);
        System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
            while (true) {
                System.out.print(prompt);
                value = scanner.nextDouble();
                if (value>=min && value<=max)
                    break;
                System.out.println("Enter a value in between "+min+" and "+max);
            }
        return value;
    }
    public static double calculateMortgage(
            int principal,
            double annualInterest,
            byte years){
        short numbersOfPayments =(short)(years * totalMonths);
        double monthyInterest = annualInterest / percent / totalMonths;
        return principal*((monthyInterest*Math.pow((1+monthyInterest),numbersOfPayments))/
                (Math.pow((1+monthyInterest),numbersOfPayments)-1));
    }
    public static double calculateBalance(
            int principal,
            double annualInterest,
            byte years,
            short numbersOfPaymentsMade
    ){

        short numbersOfPayments =(short)(years * totalMonths);
        double monthyInterest = annualInterest / percent / totalMonths;
        return principal*(Math.pow((1+monthyInterest),numbersOfPayments)-Math.pow((1+monthyInterest),numbersOfPaymentsMade))/
                (Math.pow((1+monthyInterest),numbersOfPayments)-1);
    }
}
