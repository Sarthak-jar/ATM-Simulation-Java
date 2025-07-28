package ATM_java;

import java.util.Scanner;

class ATMmachine{
    float Balance = 0 ;
    int PIN = 1234;


    public void checkpin(){
        System.out.println("Enter Your PIN:");
        Scanner sc = new Scanner(System.in);
        int attempt = 0;

        while (attempt < 3) {

            int enteredpin = sc.nextInt();

            if (enteredpin == PIN) {
                System.out.println("Correct PIN, you can proceed...");
                menu();
                return;
            } else {
                System.out.println("Invalid PIN! Try again.");
                attempt++;
            }
        }

        System.out.println("Too many incorrect attempts. Exiting...");
        System.exit(0);
    }


    public void createPIN(){

        System.out.print("Create your Custom 4 Digit PIN or Change Your PIN : ");
        Scanner abc = new Scanner(System.in);
        int newPIN = abc.nextInt();
        PIN = newPIN;
        System.out.println("Your PIN is Successfully Created or Changed");
        menu();


    }

    public void checkBalance(){
        System.out.println(Balance + " is your remaining balance :( ");
        menu();


    }

    public void depositMoney(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter amount of money to deposit ");
        float tempBal = sc.nextFloat();
        Balance = Balance + tempBal;

        System.out.println("Your updated Balance is " +Balance);

        menu();


    }

    public void withdrawMoney(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter amount of money to Withdraw ");
        float decrBal = sc.nextFloat();

        if(decrBal > Balance){
            System.out.println("Insufficient Account Balance " +Balance);
            menu();
        }

        Balance = Balance - decrBal;

        System.out.println("Successfully debited Rupees "+decrBal+ " from your account");
        checkBalance();
        menu();


    }


    public void menu (){
        System.out.println("Enter Your Choice:");
        System.out.println("1.Check A/C Balance");
        System.out.println("2.Withdraw Money");
        System.out.println("3.Deposit Money");
        System.out.println("4.Change PIN");
        System.out.println("5.EXIT");

        Scanner sc = new Scanner (System.in);
        int opt = sc.nextInt();

        switch (opt) {
            case 1:
                checkBalance();
                break;

            case 2:
                withdrawMoney();
                break;

            case 3:
                depositMoney();
                break;

            case 4:
                createPIN();
                break;

            case 5:
                System.out.println("Thank you for using the ATM!");
                System.exit(0);
                break;


            default:
                System.out.println("Invalid option. Please try again.");
                menu();
        }



    }

}




public class ATM {
    public static void main(String[] args) {

        ATMmachine atm = new ATMmachine();
        atm.checkpin();

    }
}
