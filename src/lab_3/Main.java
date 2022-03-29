package lab_3;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Loan loan = new Loan();
        System.out.print("Enter annual interest rate, for example, 8.25: ");
        loan.setAnnualInterestRate((input.nextDouble())/100);
        System.out.print("Enter number of years as an integer: ");
        loan.setNumberOfYears(input.nextInt());
        System.out.print("Enter loan amount, for example, 120000.95: ");
        loan.setLoanAmount(input.nextDouble());
        System.out.println("The loan was created on " + loan.getLoanDate());
        
        double monthlyInterestRate = loan.getAnnualInterestRate()/12;
        double monthlyPayment = (loan.getLoanAmount()*monthlyInterestRate)/
                (1-(1/(Math.pow((1+monthlyInterestRate), (loan.getNumberOfYears()*12)))));
        System.out.println("The monthly payment is " + (Math.round(monthlyPayment * 100.0) / 100.0));
        double totalPayment = monthlyPayment*loan.getNumberOfYears()*12;
        System.out.println("The total payment is " + (Math.round(totalPayment * 100.0) / 100.0));
        input.close();
    }
}

