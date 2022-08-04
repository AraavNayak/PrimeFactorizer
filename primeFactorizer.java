// Araav Nayak 
// 07/23/22 8:00pm

package mathUtil;

import java.util.Scanner;

public class primeFactorizer {

	private static Scanner s;
	private static int[] factors;
	
	
	public static void main(String[] args) {
		s = new Scanner(System.in);
		getFactors(s.nextInt());
		s.close();
	}
	
	
	public static void getFactors(int n) {
		System.out.print("Factors: ");
		int factorCount = 0;
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) {
				System.out.print(i);
				if(i != n) System.out.print(",");		
				factorCount++;
			}
		}
		System.out.print("\nFactorization terminated;\nIs prime: " + (factorCount==2) + "\nIs composite: " + (factorCount > 2) + "\n" + factorCount + " factors.\n");
		System.out.println(pFactorize(n));
	}


	public static String pFactorize(int n) {
		int num = n;
		String f = "";
		int i = 2;
		
		while(num != 1) {
			while(i <= num) {
				if(isPrime(i) && num % i == 0) {
					num /= i;
					f += "x";
					f += i;
					i = 2;
				} else i++;
			}
		}
		f = f.substring(1);		
		
		if(isPrime(n)) return f + "x1";
		
		return f;
	}
	
	
	public static int getInd(int n, int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == n) return i;
		}
		return -1;
	}


	public static int[] obtainFactors(int n) {
		int count = 0;
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) {
				count++;
			}
		}
		int[] factors = new int[count];
		int ind = 0;
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) {
				factors[ind] = i;
				ind++;
			}
		}
		return factors;
	}
	

	public static boolean isPrime(int n) {
		int a = 0;
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) a++;
		}
		return a <= 2;
	}

}
