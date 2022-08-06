public static int getGCF(int a, int b) {
	String[] aPrime = pFactorize(a).split("x");
	String[] bPrime = pFactorize(b).split("x");
	int length = aPrime.length;
	int[] inCommon = new int[length];
	int currInd = 0;

	for(int i = 0; i < aPrime.length; i++) {
		for(int j = 0; j < bPrime.length && i < aPrime.length; j++) {
			if(aPrime[i].equals(bPrime[j])) {
				inCommon[currInd] = Integer.parseInt(bPrime[j]);
				bPrime[j] = "";
				i++;
				currInd++;
			}
		}
	}

	int gcf = 1;

	for(int i = 0; i < length; i++) {
		if(inCommon[i] != 0) gcf *= inCommon[i];
	}

	return gcf;
}
