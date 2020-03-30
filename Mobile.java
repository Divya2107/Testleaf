package week1.day1;

public class Mobile {
	
	boolean isItMobilePhone = true;
	
	int mobileNumber = 34527388;
			
	String mobileModel = "Nokia";

	public static void main(String[] args) {
		
		System.out.println("Am ready");
		
		
		
		 Mobile mob= new Mobile();
		boolean isItMobilePhone2 = mob.isItMobilePhone;
		System.out.println(isItMobilePhone2);
	
		int mobileNumber2 = mob.mobileNumber;
		System.out.println(mobileNumber2);
		
		String mobileModel2 = mob.mobileModel;
		System.out.println(mobileModel2);
		
		
	}
}
