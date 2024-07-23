import java.text.NumberFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte totalMonths = 12;
        final byte percent= 100;
        Scanner scanner = new Scanner(System.in);
        int principal = 0;
        double monthyInterest=0;
        int numbersOfPayments=0;

        while (true) {
           System.out.print("Enter Principal : ");
           principal = scanner.nextInt();
           if (principal>=1000 && principal<=1_000_000)
               break;
           System.out.println("Enter a value in between $1K to $1M");

       }
        while (true) {
            System.out.print("Annual interest rate : ");
            double annualInterest = scanner.nextDouble();
            if (annualInterest>1 && annualInterest<=30) {
            monthyInterest = annualInterest / percent / totalMonths;
                break;
            }
            System.out.println("Enter a value in between 1 to 30");
        }
        while (true) {
            System.out.print("Period (Year) : ");
            byte years = scanner.nextByte();
            if (years>=1 && years<=30) {
                numbersOfPayments = years * totalMonths;
                break;
            }
            System.out.println("Enter a value in between 1 to 30");
        }

        double mortgage = principal*((monthyInterest*Math.pow((1+monthyInterest),numbersOfPayments))/(Math.pow((1+monthyInterest),numbersOfPayments)-1));

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage : "+ mortgageFormatted);


}}