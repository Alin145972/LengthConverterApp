package lenghtConverter;

public class LenghtConverter {
	
public static long ConvertToCentimeters(double feet, double inches) {

		if(feet < 0 || inches <0) return -1;
		
		long centimeters = (long)Math.round(2.54*(inches + (12*feet)));

		return centimeters;
	}
	
	public static String printConversion(double feet, double inches) {
		String str;
		
		if(ConvertToCentimeters(feet, inches)==-1) str= "Please enter only positive values!";
		else str= feet+" ft and "+ inches+ " in = "+ ConvertToCentimeters(feet, inches)+" cm.";
		
		return str;
	}
}
