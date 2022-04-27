import java.util.Scanner;  
import java.lang.System;
public class BankingApp {
	
	Scanner opt = new Scanner(System.in);
	public String decision;
	double prev_trans = 0;
	double prev_trans_wt = 0;
	public int count;
	
	public double current = Math.round((Math.random()*50000)*100)/100;
	
	public static void main(String[] args) {
		BankingApp option_obj = new BankingApp();
		option_obj.options();
	}
	
	public void quitApp(){
		System.exit(0);
	}

	public void options() {
		Scanner name = new Scanner(System.in);
		System.out.print("What is your name: ");
		
		String input = name.nextLine();
		System.out.println("Hello "+ input +", " + "please choose from the following options: \n 1. Check Balance(C) \n 2. Deposit(D) \n 3. Withdraw(W) \n 4. View Previous transaction(VPT) \n 5. Cash Back(CB) \n 6. Exit Application(X) \n" );
		
		while(true) {
			double cash_back = (double) (30);
			System.out.print("What do you want to do ? ");
			Scanner opt = new Scanner(System.in);
			String decision = opt.nextLine();
			
			if (decision.equals("C") || decision.equals("c")) {
				System.out.println("===========");
				System.out.println("$ " + current);
				System.out.println("===========");
				count = 1;
			} else if(decision.equals("D") || decision.equals("d")) {
				System.out.print("How much would you like to deposit ?");
				Scanner dep = new Scanner(System.in);
				double dep_num = dep.nextDouble();
				prev_trans += dep_num;
				current += dep_num;
				count = 2;
			} else if(decision.equals("W") || decision.equals("w")) {
				System.out.print("How much would you like to withdraw ?");
				Scanner with = new Scanner(System.in);
				double with_num = with.nextDouble();
				prev_trans_wt -= with_num;
				current -= with_num;
				count = 3;
			} else if(decision.equals("VPT") || decision.equals("vpt")) {
				if (count == 1) {
					System.out.println("=====================================");
					System.out.println(decision = "Check balance " +"$ " + current);
					System.out.println("=====================================");
				} else if (count == 2) {
					System.out.println("====================================");
					System.out.println(decision = "Deposited " +"$ " + prev_trans);
					System.out.println("====================================");
				} else if (count == 3) {
					System.out.println("=====================================");
					System.out.println(decision = "Withdrew " +"$ "+ Math.abs(prev_trans_wt));
					System.out.println("=====================================");
				} else if (count == 4) {
					System.out.println("===========================================");
					System.out.println(decision = "Cash back Recieved "+"$ " + cash_back);
					System.out.println("===========================================");
				}
			} else if (decision.equals("CB") || decision.equals("cb")) {
				current += cash_back;
				System.out.println("===================================================");
				System.out.println("Your current balance plus cash back is: " +"$ " + current);
				System.out.println("===================================================");
				count = 4;
			} else if (decision.equals("X") || decision.equals("x")) {
				System.out.println("===========================");
				System.out.println("Thanks for Banking with us!");
				System.out.println("===========================");
				quitApp();
			}
		}
	}
}
