package com.zfq.thread.lock;

public class SynchronizeException extends Thread{   
    private static volatile boolean flag = true;   
    private A a;   
    private B b;   
    public static void main(String[] args) {   
        A a = new A();   
        B b = new B();   
        new SynchronizeException(a,b).start();   
        new SynchronizeException(a,b).start();   
    }   
       
    public SynchronizeException(A a,B b) {   
        this.a = a;   
        this.b = b;   
    }   
       
    @Override  
    public void run() {   
        if(flag){   
            flag = false;   
            a.a1();   
            b.b1();   
        }else{   
            flag = true;   
            b.b1();   
            a.a1();   
        }   
    }   
}   
  
class A {  
	
    public synchronized void a1() {   
                 // 此处可以设置断点，两个线程只有一个可以执行   
    	System.out.println("执行");
        System.out.println(Thread.currentThread()+"a1");   
        if(true){   
            throw new NumberFormatException();   
        }   
    }   
}   
  
class B {   
    public synchronized void b1() {   
        System.out.println(Thread.currentThread()+"b1");   
    }   
}