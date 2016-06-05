package com.wli.bank.po;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.wli.bank.core.NumberMachine;
import com.wli.bank.core.NumberTicket;

/**
 * 
 * 模拟客办理业务窗口  
 * @author ali  
 * @version  0.8 
 * 2016年6月5日 下午4:29:48
 */
public class BankWindow implements Runnable{
	
	private int id;//窗口号,自增
	
	private int type;//1vip,2普通，3快速
	
	private static int maxServiceTime=2000;
	private static int minServiceTime=500;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public BankWindow(int id, int type) {
		super();
		this.id = id;
		this.type = type;
	}
	
	

	public static int getMaxServiceTime() {
		return maxServiceTime;
	}

	public static void setMaxServiceTime(int maxServiceTime) {
		BankWindow.maxServiceTime = maxServiceTime;
	}

	public static int getMinServiceTime() {
		return minServiceTime;
	}

	public static void setMinServiceTime(int minServiceTime) {
		BankWindow.minServiceTime = minServiceTime;
	}

	@Override
	public void run() {
		while(true){
			NumberTicket n=NumberMachine.getMachine().popTicket(type);
			if(n==null&&(this.type==1||this.type==3)){
				n=NumberMachine.getMachine().VipOrFastPopCommonicket();
			}
			if(n!=null){
				System.out.println(this.getId()+"号"+this.getTypeStr()+"开始为"+n.getId()+"号"+n.getTypeStr()+"服务");
				long serviceTime=getServiceTime(n.getType());
				try {
					Thread.sleep(serviceTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(this.getId()+"号"+this.getTypeStr()+"为"+n.getId()+"号"+n.getTypeStr()+"服务结束，用时"+serviceTime/1000+"秒");
			}
		}
	}

	private String getTypeStr() {
		String typeStr="";
		switch (type) {
		case 1:
			typeStr= "VIP窗口";
			break;
		case 2:
			typeStr= "普通窗口";
			break;
		case 3:
			typeStr= "快速窗口";
			break;
		}
		return typeStr;
	}
	
	private long getServiceTime(int type){
		Random random=new Random();
		long time=0;
		switch (type) {
		case 1:
		case 3:
			time=random.nextInt(maxServiceTime-minServiceTime)+minServiceTime;
			break;
		case 2:
			time=minServiceTime;
			break;
		}
		return time;
	}
	
	
}
