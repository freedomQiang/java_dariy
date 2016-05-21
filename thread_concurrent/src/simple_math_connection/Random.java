package simple_math_connection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class Random {
	private static StringBuilder strb   = new StringBuilder();
	@Test
	public void test() throws InterruptedException{
		while(true){
			System.out.println((int)(Math.random()*10 + 1));
			Thread.sleep(1000);
		}
	}
	public static void main(String args []){
		int a [] = new int[5];
		for(int i  = 0 ;i < 5 ; i  ++){
			 a[i] = (int) (Math.random()*10) ;
		}
		
		new Random().getNumber(a);
		
	}
	private void getNumber(int a[]) {
		for(int i = 0; i < a.length; i++  ){
			System.out.print(a[i]);
			
		}
		System.out.println();
		System.out.print("+++++++++++++++++");
		System.out.println();
		int b[] = new int[5];
		b = a.clone();
		for(int i = 0; i < a.length; i++  ){
			for(int j=0; j<b.length; j++){
				if(b[j] == a[i]){}
				else{
					b[j] = a[i];
					for(int m = 0 ;  m <b.length; m ++){
						System.out.print(b[m]);
					}
					System.out.println();
					b = a.clone();
					
				}
			}
		}
	}
	
}