package week1.day4;

public class W1D4Arrayactivity {
	
	public void main (String [] args)
	{
	// Write a program to find average of given array?
	int[] a = {20, 40, 50, 60};
	int count = a.length;
	int sum = 0;
	
	for (int i = 0;i < a.length; i++ )
	{
		sum = sum + a[i];
		
	}
int avg = sum/count;
System.out.println(avg);

}
}