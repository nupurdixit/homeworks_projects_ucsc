
public class PowerBall {

	/**
	 * File Name: PowerBall.java
	 * 
	 * @author Jagadeesh Vasudevamurthy
	 * @year 2016
	 */
	/*
	 * To compile you require: IntUtil.java RandomInt.java PowerBall.java
	 */

	/*
	 * ALL PRIVATE DATA BELOW CANNOT ADD ANY MORE MEMBER
	 */
	private int[] winningNumber;
	private int[] ticketNumber;
	private long cash;
	static private boolean display = true;
	static final long jackpot = 100000000;
	static private IntUtil u = new IntUtil();

	private void printNumbers() {
		if (display) {
			System.out.println("winningNumber ");
			u.pLn(winningNumber);
			System.out.println("ticketNumber  ");
			u.pLn(ticketNumber);
		}
	}

	public long cash() {
		return cash;
	}

	private void check() {
		// WRITE CODE HERE
		// YOU CAN WRITE AS MANY PRIVATE ROUTINES AS YOU NEED
		int count = 0;
		int PBcount = 0;
		boolean flag = true;
		if (ticketNumber.length != 6) {
			System.out.println("The ticket is faulty as it does not have 6 numbers in it");
			return;
		}

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 5; j++) {
				if (winningNumber[i] == ticketNumber[j]) {
					count++;
					break;
				}
			}
		}

		// System.out.println("Value of flag is"+flag);

		// if(flag==true){

		if (winningNumber[5] == ticketNumber[5]) {
			PBcount = 1;
		}
		// }
		if ((count == 0) && PBcount == 1) {
			cash = 4;
			System.out.println("You won cash = $4 ");
		} else if ((count == 1) && PBcount == 1) {
			cash = 4;
			System.out.println("You won cash = $4 ");
		} else if ((count == 2) && PBcount == 1) {
			cash = 7;
			System.out.println("You won cash = $7 ");
		} else if ((count == 3) && PBcount == 0) {
			cash = 7;
			System.out.println("You won cash = $7 ");
		} else if ((count == 3) && PBcount == 1) {
			cash = 100;
			System.out.println("You won cash = $100 ");
		}

		else if ((count == 4) && PBcount == 0) {
			cash = 100;
			System.out.println("You won cash = $100 ");
		} else if ((count == 4) && PBcount == 1) {
			cash = 50000;
			System.out.println("You won cash = $50000 ");
		} else if ((count == 5) && PBcount == 0) {
			cash = 1000000;
			System.out.println("You won cash = $1000000 ");
		} else if ((count == 5) && PBcount == 1) {
			cash = 100000000;
			System.out.println("You won JACKPOT!!! ");
		} else {
			System.out.println("Sorry, you did not win anything");
		}
	}

	// }

	PowerBall(int[] w, int[] t) {
		winningNumber = w;
		ticketNumber = t;
		cash = 0;
		check();
	}

	private static void test1() {
		// CANNOT CHANGE BELOW
		int[] w = { 4, 8, 19, 27, 24, 10 };
		{
			int[] n = { 4, 8, 19, 27, 24, 10 };
			PowerBall x = new PowerBall(w, n);
		}
		{
			int[] n = { 24, 27, 19, 8, 4, 10 };
			PowerBall x = new PowerBall(w, n);
		}
		{
			int[] n = { 24, 27, 19, 8, 4, 5 };
			PowerBall x = new PowerBall(w, n);
		}
		{
			int[] n = { 124, 127, 119, 18, 14, 10 };
			PowerBall x = new PowerBall(w, n);
		}
		{
			int[] n = { 124, 127, 119, 18, 14, 5 };
			PowerBall x = new PowerBall(w, n);
		}
		{
			int[] n = { 124, 127, 119, 18, 14 };
			PowerBall x = new PowerBall(w, n);
		}
		{
			int[] n = { 124, 124, 19, 119, 18, 14 };
			PowerBall x = new PowerBall(w, n);
		}
	}

	private static void testRandom() {
		// CANNOT CHANGE BELOW
		System.out.println("----------testRandom()  starts-------------");
		display = false;
		int[] w = { 4, 8, 19, 27, 24, 10 };
		int max = 1000000;
		long c = 0;
		System.out.println("Buying " + max + " tickets of worth " + max * 2 + "$");
		for (int i = 0; i < max; ++i) {
			int[] n = u.generateRandomNumber(6, true, 1, 60);
			PowerBall x = new PowerBall(w, n);
			if (x.cash() == jackpot) {
				System.out.println("Won Jacckpot");
			}
			c = c + x.cash();
		}
		long p = (c - (max * 2));
		System.out.println("Out of " + max + " times you win " + c + "$");
		if (p > 0) {
			System.out.println("Profit = " + p);
		} else {
			System.out.println("Loss = " + p);
		}
		System.out.println("----------testRandom()  ends-------------");
	}

	private static void testBench() {
		// CANNOT CHANGE BELOW
		test1();
		testRandom();
	}

	public static void main(String[] args) {
		// CANNOT CHANGE BELOW
		System.out.println("PowerBall.java");
		testBench();
		System.out.println("Done");
	}
}