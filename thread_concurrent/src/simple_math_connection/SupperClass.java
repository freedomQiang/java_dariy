package simple_math_connection;

import java.util.Date;

public class SupperClass extends Date {
 public static void main(String args []){
	 new SupperClass().test();
 }

private void test() {
	System.out.println(super.getClass().getName());
	System.out.println(getClass().getSuperclass().getName());
}
 }
