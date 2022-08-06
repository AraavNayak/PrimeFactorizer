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
		//Handle the edge case
		if(n == 1) return "";
		
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
		
		f = useExponents(f);
		
		return f;
	}
	
	public static String useExponents(String s) {
		String s1 = s.split("x");
		int length = s1.length;
		int[] i1 = new int[length];
		for(int i = 0; i < length; i++) {
			i1[i] = Integer.parseInt(s1[i]);
		}
		
		int[] freq = new int[length];
		for(int i = 0; i < length; i++) {
			freq[i] = 1;
		}
		
		int i[] = new int[length];
		
		int freqInd = 0;
		
		for(int currInd = 0; currInd < length; currInd++) {
			if(getInd(i1[currInd], i) == -1) {
				i[currInd] = i1[currInd];
				freqind = currInd;
			} else {
				freq[freqInd]++;
				freq[currInd] = 0;
			}
		}
		
		//counting the frequency of zeroes
		int zeroCount = 0;
		for(int k = 0; k < freq.length; k++) {
			if(freq[k] == 0) zeroCount++;
		}
		
		String[] primes = new String[length-zeroCount];
		int currInd = 0;
		
		//cleaning up freq[]
		String[] freqs = new String[length-zeroCount];
		int curInd = 0;
		for(int k = 0; k < freq.length; k++) {
			if(freq[k] != 0) {
				freqs[curInd] = "" + freq[k];
				curInd++;
			}
		}
		
		for(int j = 0; j < freq.length; j++) {
			if(freq[j] != 0) {
				primes[currInd] = "" + i[j];
				currInd++;
			}
		}
		
		String primeFactorization = "";
		
		for(int k = 0; k < length-zeroCount; k++) {
			if(!freqs[k].equals("1")) primeFactorization += primes[k] + "^" + freqs[k] + " ";
			else primeFactorization += primes[k] + " ";
			if(k != length-zeroCount-1) primeFactorization += "x ";
		}
		
		return primeFactorization;
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
