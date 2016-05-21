package com.zfq.thread.lock;

public class LockAndSynchronized {

	public static void main(String[] args) {
		LockAndSynchronized test =  new LockAndSynchronized();
		new  Thread (test.new Thread1()).start();
		new  Thread (test.new Thread2()).start();
		
	}
	private class Thread1 implements Runnable {
		int i ;
		@Override
		public void run() {
			synchronized (LockAndSynchronized.class) {
				try {
					System.out.println(i/0);
				} catch (Exception e) {
				System.out.println("Å×³öÁËÒì³£");
				}
				try {
					Thread.currentThread().sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("goon for thread ");
			}
		}
		
	}
	private class Thread2 implements Runnable{

		@Override
		public void run() {
			synchronized (LockAndSynchronized.class) {
				
				System.out.println("thread 2");
			}
		}}

}
