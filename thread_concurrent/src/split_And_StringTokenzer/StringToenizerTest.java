package split_And_StringTokenzer;

import java.util.StringTokenizer;

public class StringToenizerTest {

	public static void main(String[] args) {
		String str = "a,b,c,d,e,f,g";
		StringTokenizer token = new StringTokenizer(str, ",");
		while(token.hasMoreTokens()){
			System.out.print(token.nextToken());
		}
	}

}
