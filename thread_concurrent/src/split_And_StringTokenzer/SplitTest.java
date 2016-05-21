package split_And_StringTokenzer;

public class SplitTest {
	public static void main(String args []){
		String str = "a,b,c,d,e,f,g";
		String string [] = str.split(",");
		for(String ch :string){
			System.out.print(ch +"\t\t\t");
		}
	}
}
