package com.cn.jvm.test.jvm;

public class FinalizeEscapeGC {
	
	public static FinalizeEscapeGC SHAVE_HOOK = null;
	
	public void isAlive(){
		System.out.println("yes, i am still alive");
	}

	protected void finalize() throws Throwable{
		super.finalize();
		System.out.println("finalize method executed!");
		FinalizeEscapeGC.SHAVE_HOOK = this;
	}
	
	public static void main(String[] args) throws InterruptedException {
		SHAVE_HOOK = new FinalizeEscapeGC();
		SHAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if(SHAVE_HOOK != null){
			SHAVE_HOOK.isAlive();
		}else{
			System.out.println("no, i am already dead");
		}
		//一个对象的finalize()方法只会触发一次,所以第二次的逃不过第二次的gc
		SHAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if(SHAVE_HOOK != null){
			SHAVE_HOOK.isAlive();
		}else{
			System.out.println("no, i am already dead");
		}
	}
}
