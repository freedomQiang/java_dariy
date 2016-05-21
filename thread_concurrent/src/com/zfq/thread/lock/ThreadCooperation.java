package com.zfq.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCooperation {

	private static Account account = new Account();

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new DepositeTask());
		executor.execute(new WithdrawTask());
		executor.shutdown();
		System.out.println("Thread 1\t\tThread2\t\tBalance");
	}

	private static class DepositeTask implements Runnable {

		@Override
		public void run() {
		// TODO Auto-generated method stub
		try {
		
			while (true) {
					account.deposite((int) (Math.random() * 10) + 1);
					Thread.sleep(1000);
				}
			
				} catch (Exception ex) {
				ex.printStackTrace();
				}
			}
		}
	private static class WithdrawTask implements Runnable {

		@Override
		public void run() {
				// TODO Auto-generated method stub
				while (true) {
				account.withdraw((int) (Math.random() * 10) + 1);
				}
			}
		}

		private static class Account {
		//将账户锁定，线程同步的一种方式
		private static Lock lock = new ReentrantLock();

		private static Condition newDeposite = lock.newCondition();

		private int balance = 0;

		public int getBalance() {
			return this.balance;
		}

		public void withdraw(int amount) {
			lock.lock();
	
			try {
				while (this.balance < amount) {
				newDeposite.await();
				//super.wait();
			}
	
				balance -= amount;
				System.out.println("\t\twithdraw " + amount + "\t\t"
				+ getBalance());
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				} finally {
				lock.unlock();
			}
	
			}

		public void deposite(int amount) {
				lock.lock();
				try {
					balance += amount;
					System.out.println("deposite:" + amount + "\t\t\t\t"
					+ getBalance());
					newDeposite.signal();
					//super.notifyAll();
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					lock.unlock();
				}
			}

		}
	}
