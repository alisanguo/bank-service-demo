package com.wli.test;

import java.awt.Window;

import com.wli.bank.po.BankWindow;
import com.wli.bank.po.User;

public class Test {
	
	public static void main(String[] args) {
		for(int i=1;i<=3;i++){
			int index=i;
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true){
						long time=0;
						switch (index) {
						case 1:
							time=6000;
							break;
						case 2:
							time=1000;
							break;
						case 3:
							time=3000;
							break;
						}
						
						new User("##", index).getTicket();
						
						try {
							Thread.sleep(time);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
		
		for(int i=1;i<=6;i++){
			int type=1;
			switch (i) {
			case 1:
			case 2:
			case 3:
			case 4:
				type=2;
				break;
			case 5:
				type=3;
				break;
			case 6:
				type=1;
				break;
			}
			BankWindow window=new BankWindow(i,type);
			new Thread(window).start();
			
		}
	}
	
	
}
