package com.zfq.thread.lock;

public class TestThreadConstructor implements Runnable  {
	public static void main(String args[]){
	TestThreadConstructor test = new TestThreadConstructor();
	Thread ta = new Thread(test,"A");
	Thread tb = new Thread(test,"B");
	ta.start();
	tb.start();
	}

	@Override
	public void run() {
		synchronized (this) {
			
			System.out.println(Thread.currentThread().getName()+"\t"+Thread.currentThread().getThreadGroup());
		}
	}
	
}
