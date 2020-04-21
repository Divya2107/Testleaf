package week1.day3;

public class W1D3StringreversalHW {


		public static void main(String[] args) {
		//Pass the input as text
			String txt="Welcome";	
			
		//convert the string to new character array with return type as char array
			char[] charArray = txt.toCharArray();
	
		//Find the length of the charArray
			int length=charArray.length;
			System.out.println(length);
			
			String reversetext="";
			
			for (int i = length-1; i >=0 ; i--) {
			
				//Reversing the text
			reversetext = reversetext+ Character.toString(charArray[i]);
				 
			}
			System.out.println(reversetext);
			}

}
