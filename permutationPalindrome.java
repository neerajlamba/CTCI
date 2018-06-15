import java.util.*;
import java.lang.*;


public class permutationPalindrome{

	public static boolean isPermutationOfPalindrome(String phrase){
		int[] table = buildCharacterFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}

	public static boolean checkMaxOneOdd(int[] table){
		boolean foundOdd = false;
		for(int count : table){
			if(count% 2 == 1){
				if(foundOdd){
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}

	public static int getCharNumber(char c){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a <= val && val <= z){
			return val - a;
		}
		return -1;
	}

	public static int[] buildCharacterFrequencyTable(String phrase){
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') - 1];
		for( char c : phrase.toCharArray()){
			int x = getCharNumber(c);
			if(x != -1){
				table[x]++;
			}
		}
		return table;
	}

	public static void main(String[] args) {
		String pali = "Rats live on no evil star";
		System.out.println(isPermutationOfPalindrome(pali));
	}
}