package simple_math_connection;

public class StringPKStringBuffer {

	public static void main(String[] args) {
		StringPKStringBuffer pk = new StringPKStringBuffer();
		pk.testString();
		pk.testStringBuffer();
		pk.testStringBuilder();
		
		
	}
	private void testString(){
		String str = new String();
		long timeStart  = System.currentTimeMillis();
		for(int i = 0 ; i <  10000; i ++){
			str = str + i;
		}
		long timeEnd  = System.currentTimeMillis();
		long time = timeEnd -  timeStart;
		System.out.println(time);
	}
	private void testStringBuffer(){
		StringBuffer buffer = new StringBuffer();
		long timeStart  = System.currentTimeMillis();
		for(int i = 0 ; i <  10000000; i ++){
			buffer = buffer.append(i);
		}
		long timeEnd  = System.currentTimeMillis();
		long time = timeEnd -  timeStart;
		System.out.println(time);

	}
	private void testStringBuilder(){
		StringBuilder buffer = new StringBuilder();
		long timeStart  = System.currentTimeMillis();
		for(int i = 0 ; i <  10000000; i ++){
			buffer = buffer.append(i);
		}
		long timeEnd  = System.currentTimeMillis();
		long time = timeEnd -  timeStart;
		System.out.println(time);

	}
}
