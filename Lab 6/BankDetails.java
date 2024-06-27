import java.util.Scanner;

public class BankDetails {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[5];
        for(int i=0; i<5; i++){
            accounts[i] = new BankAccount();
            accounts[i].setDetails();
            System.out.println("------------------------------");
        }

        System.out.println("Enter 1 for Deposit Money\nEnter 2 For Withdraw Money\nEnter 3 For Check Balance");
        int requirement=sc.nextInt();

        System.out.println("Enter the Index(Between 0 to 4): ");
        int n=sc.nextInt();

        if(requirement==1){
            accounts[n].depositMoney();
            System.out.println("---------------------");
            System.out.println("Your Current Balance");
            accounts[n].checkBalance();
        }
        else if(requirement==2){
            accounts[n].withdrawMoney();
            System.out.println("---------------------");
            System.out.println("Your Current Balance");
            accounts[n].checkBalance();
        }
        else if(requirement==3){
            accounts[n].checkBalance();
        }

    }
}

class BankAccount{
    int account_No;
    String name;
    double balance;

    Scanner sc=new Scanner(System.in);
    public void setDetails(){
        System.out.println("Enter account no : ");
        account_No = sc.nextInt();
        System.out.println("Enter name : ");
        name = sc.next();
        System.out.println("Enter balance : ");
        balance = sc.nextDouble();
    }

    public void depositMoney(){
        System.out.println("Enter The Amount: ");
        double amount=sc.nextDouble();
        balance += amount;
        System.out.println("Deposit Succesefully");
    }

    public void withdrawMoney(){
        System.out.println("Enter The Amount: ");
        double amount=sc.nextDouble();
        if(balance == 0 || balance - amount < 0){
            System.out.println("Not sufficient balance");
            return;
        }

        balance -= amount;
        System.out.println("Withdraw Succesefully");
    }

    public void checkBalance(){
        System.out.println("Balance = "+balance);
    }
}

