package com.zfq.thread.lock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCooperationTest {
	private static Account account = new Account();
	
	public static void main(String args []){
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new DepositeTask());
		executor.execute(new DrawTask());
		executor.shutdown();
	}
	private static  class DepositeTask implements Runnable {

		@Override
		public void run() {
			while(true){
			account.deposite((int) (Math.random()* 10));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}

	}
	private static class  DrawTask implements Runnable {

		@Override
		public void run() {
			while(true){
			account.withdraw((int) (Math.random()*10 + 1));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}

	}
	//通过静态内部类实现数据的共享
	private static class Account {
		private static Lock lock = new ReentrantLock();
		private Condition newCondition = lock.newCondition();
		private int balance ;
		public int getBalance(){
			return balance;
		}
		public void deposite (int amount ){
			lock.lock();
			try {
				balance += amount;
				//唤醒正在等待的线程
				newCondition.signal();
				System.out.println("deposite:" + amount + "\t\t\t\t"
						+ getBalance());
			} catch (Exception e) {
				
			}finally{
				lock.unlock();
			}
			
		}
		public void withdraw(int amount){
			lock.lock();
			try {
				while(amount > balance)
					//剩余的数目3不足，线程等待；
					newCondition.await();
				balance -= amount;
				System.out.println("deposite:" + amount + "\t\t\t\t"
						+ getBalance());
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				lock.unlock();
			}
		}
	}

}
