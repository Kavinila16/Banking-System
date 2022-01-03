import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BankingProcess {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kavi", "root","Kavi@967761");

		Statement stmt = con.createStatement();
		System.out.println("Enter your Name:");
		String name=sc.next();
		ResultSet rs = stmt.executeQuery("select* from Elements3");
	
		

			while (rs.next()) {

				String Result = rs.getString(2);
				if (Result.equals(name)) {
					System.out.println("Welcome "+rs.getString(2)+" Your Id is "+rs.getString(3));

				}
			
			}
					
	
			
		System.out.println("----------------------------------------------------------");
		kavi sc3 = new kavi();
		sc3.show();
	
	}

}

class kavi {

	
	int balance;
	int previoustrans;

	

	void deposit(int amount) {
		balance = balance + amount;
		previoustrans = amount;

	}

	void withdrawal(int amount) {
		balance = balance - amount;
		previoustrans = -amount;

	}

	void getprevoiusTrans() {
		if (previoustrans > 0) {
			System.out.println("Deposited:" + previoustrans);

		} else if (previoustrans < 0) {
			System.out.println("Withdrawal:" + previoustrans);

		} else {
			System.out.println("Sorry....No Transaction has been done....");
		}
	}

	void show() {
		char option = '0';
		
		

		System.out.println("Enter A for Check Your Balance");
		System.out.println("Enter B for Deposit");
		System.out.println("Enter C for Withdrawal");
		System.out.println("Enter D for Previous Transaction");
		System.out.println("Enter E for Exit");
		System.out.println("------------------------------------------------------------------------------");
	do {
			System.out.println("Enter your Option:");
			Scanner sc = new Scanner(System.in);
			option = sc.next().charAt(0);
			
			switch (option) {
			case 'A':
				System.out.println("Your Balance is:" + balance);
				break;
			case 'B':
				System.out.println("Enter the Amount:");
				int s = sc.nextInt();
				deposit(s);
				break;
			case 'C':
				System.out.println("Enter the Amount:");
				int s1 = sc.nextInt();
				withdrawal(s1);
				break;
			case 'D':
				System.out.println("--------");
				getprevoiusTrans();
				break;

			default:
				System.out.println("----------------");
				break;
			}
	}while (option != 'E');

		System.out.println("ThankYou");

	}

}

