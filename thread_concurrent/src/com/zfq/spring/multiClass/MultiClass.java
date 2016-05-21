package com.zfq.spring.multiClass;

public class MultiClass {

	public static void main(String[] args) {
		new Thread(new Thread1()).start();
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		new Thread(new Thread2()).start();
	}
	private static  class Thread1 implements Runnable{

		@Override
		public void run() {
			System.out.println("thread1 statrt ;");
			synchronized (MultiClass.class) {
				System.out.println("entered multiClass ");
				System.out.println("thread1 will waiting ");
				try {
					MultiClass.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("thread1 is going on;");
				System.out.println("thread1 is going over");
			}
		}
		
	}
	private static class Thread2 implements Runnable {

		@Override
		public void run() {
			System.out.println("thread2 started ");
			synchronized (MultiClass.class) {
				MultiClass.class.notify();
				System.out.println("thread2 is notify thrad1 ,  and it is wake");
				System.out.println("thread2 is going to sleep ");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("thread2 is over");
			}
		}
		
	}
}
