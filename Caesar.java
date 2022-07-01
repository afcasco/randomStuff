import java.util.Scanner;
public class Caesar{
  
  /*
  Encrypt with Caesar method (+2)
  */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Type something you want to encrypt: \n");
		String message = input.nextLine();
		String encrypted = "";

		for(int i=0;i<message.length();i++){
			if(((int)message.charAt(i)>=65&&(int)message.charAt(i)<=90)||((int)message.charAt(i)>=97&&(int)message.charAt(i)<=122)){
				encrypted = encrypted + (char)((int) (message.charAt(i))+2);
			} else {
				encrypted = encrypted + " "; 
			}
		}
		System.out.println("Encritped message is: "+encrypted);
	}
}
