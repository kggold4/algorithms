package algorithms_1.exercise1;
/**
 * Alice and Bob flip coin game:
 * Strategy 1. Alice calls a random number - Probability 1/2
 * Strategy 2. Alice calls 1 and Bob calls 1 - Probability 3/4
 * Strategy 2A. Alice calls 0 and Bob calls 0 - Probability 3/4
 * Strategy 3. Everyone says that he (she) received - Probability 1/2
 * Strategy 4. Alice calls that she got and 
 * 			   Bob calls the opposite of what he received - Probability 1
 */

public class AliceAndBobFlipCoinGame {
	//**************************************************
	//************************************************
	//********** method returns 0 or 1 randomly **********
	//************************************************
	public static int CoinFlips() {
		long result = 0;
		result = Math.round( Math.random());
		return (int)result;
	}
	//**************************************************
	//**********************************************
	//********** method returns result of Alice **********
	//**********************************************
	public static int AliceGame(){
		return CoinFlips();
	}
	//**************************************************
	//**********************************************
	//********** method returns result of Bob **********
	//**********************************************
	public static int BobGame(){
		return CoinFlips();
	}

	//**************************************************
	//********************************************
	//********** game strategy 1 **********
	//********************************************
	public static boolean GameStrategy1(){
		boolean result = false;
		int AliceResult = AliceGame();
		if (AliceResult > 0)
			result = true;
		return result;
	}
	//**************************************************
	//********************************************
	//********** game strategy 2 **********
	//********************************************
	public static boolean GameStrategy2(){
		boolean result = false;
		int AliceResult = AliceGame();
		int BobResult = BobGame();
		if ((AliceResult == 1) || (BobResult == 1))
			result = true;
		return result;
	}
	//**************************************************
	//*********************************************
	//********** game strategy 2A **********
	//*********************************************
	public static boolean GameStrategy2A(){
		boolean result = false;
		int AliceResult = AliceGame();
		int BobResult = BobGame();
		if ((AliceResult == 0) || (BobResult == 0))
			result = true;
		return result;
	}
	//********************************************
	//********** game strategy 3 **********
	//********************************************
	public static boolean GameStrategy3(){
		boolean result = false;
		int AliceResult = AliceGame();
		int BobResult = BobGame();
		if (AliceResult == BobResult )
			result = true;
		return result;
	}
	//********************************************
	//********** game strategy 4 **********
	//********************************************
	public static boolean GameStrategy4(){
		boolean result = false;
		int AliceResult = AliceGame();
		int BobResult = BobGame();

		// if bob and alice got different numbers
		if ((AliceResult == BobResult) ||
				// if bo and alice got the same numbers
				(BobResult == 1 - AliceResult))
			result = true;
		return result;
	}
	//**************************************************
	public static void main(String[] args) {
		int count = 10000000;
		int GameStrategy1 = 0;
		int GameStrategy2 = 0;
		int GameStrategy2A = 0;
		int GameStrategy3 = 0;
		int GameStrategy4 = 0;
		boolean result1;
		boolean result2;
		boolean result2A;
		boolean result3;
		boolean result4;
		for (int i = 0; i < count; i++){
			result1 = GameStrategy1();
			if (result1 == true)
				GameStrategy1++;
			result2 = GameStrategy2();
			if (result2 == true)
				GameStrategy2++;
			result2A = GameStrategy2A();
			if (result2A == true)
				GameStrategy2A++;
			result3 = GameStrategy3();
			if (result3 == true)
				GameStrategy3++;
			result4 = GameStrategy4();
			if (result4 == true)
				GameStrategy4++;
		}
		System.out.println("Alice & Bob game : Strategy1 probability = " + (double)GameStrategy1/(double)count);
		System.out.println("Alice & Bob game : Strategy2 probability = " + (double)GameStrategy2/(double)count);
		System.out.println("Alice & Bob game : Strategy2A probability = " + (double)GameStrategy2A/(double)count);
		System.out.println("Alice & Bob game : Strategy3 probability = " + (double)GameStrategy3/(double)count);
		System.out.println("Alice & Bob game : Strategy4 probability = " + (double)GameStrategy4/(double)count);
	}
}
