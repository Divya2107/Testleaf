package week1.day1;

public class Android {
	
	boolean isItAndroid = true;
	
	long costOfMobile = 40000;
	
	float lengthOfMobileincm = 5.5f;
	
	int androidNumber = 11;
			
	String androidVersion = "Kitkat";

	public static void main(String[] args) {
		
		
		 Android mob= new Android();
		boolean isItAndroid2 = mob.isItAndroid;
		System.out.println(isItAndroid2);
	
		long costOfMobile2 = mob.costOfMobile;
		System.out.println(costOfMobile2);
		
		float lengthOfMobileincm2 = mob.lengthOfMobileincm;
		System.out.println(lengthOfMobileincm2);
		
		int androidNumber2 = mob.androidNumber;
		System.out.println(androidNumber2);
		
		String androidVersion2 = mob.androidVersion;
		System.out.println(androidVersion2);
		
		
	}
}
