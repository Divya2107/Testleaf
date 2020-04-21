package week1.day3;

public class W1D3NextCharacterHW {
	public static void main(String[] args)
	{
		String text="A1B2C3";
		
		char[] characterArray = text.toCharArray();
		int length = characterArray.length;
		System.out.println(length);
		String newtext="";
		for (int i = 0; i < length; i++) {
		
			int temp=characterArray[i];
			temp=temp+1;
			newtext=newtext+(char)temp;
			
		}
		System.out.println(newtext);
	}
		
	}


