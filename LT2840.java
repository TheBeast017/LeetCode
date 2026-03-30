if (s1.length() != s2.length()) return false;
        StringBuilder evenS1 = new StringBuilder();
        StringBuilder oddS1 = new StringBuilder();
        StringBuilder evenS2 = new StringBuilder();
        StringBuilder oddS2 = new StringBuilder();
        
        for(int i = 0; i < s1.length(); i++){
            if (i % 2 == 0) {
                evenS1.append(s1.charAt(i));
                evenS2.append(s2.charAt(i));
            } else {
                oddS1.append(s1.charAt(i));
                oddS2.append(s2.charAt(i));
            }
        }
        char[] evenArray1 = evenS1.toString().toCharArray();
        char[] oddArray1 = oddS1.toString().toCharArray();
        char[] evenArray2 = evenS2.toString().toCharArray();
        char[] oddArray2 = oddS2.toString().toCharArray();
        
        Arrays.sort(evenArray1);
        Arrays.sort(oddArray1);
        Arrays.sort(evenArray2);
        Arrays.sort(oddArray2);
        return Arrays.equals(evenArray1, evenArray2) && Arrays.equals(oddArray1, oddArray2);