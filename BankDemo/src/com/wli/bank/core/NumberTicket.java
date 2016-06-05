package com.wli.bank.core;

/**
 * 
 * 号码管理器
 * @author ali  
 * @version  0.8 
 * 2016年6月5日 下午4:42:49
 */
public class NumberTicket {
	
	private static int count=0;
	
	private final int id=count++;
	
	private int type;//1vip,2普通,3快速
	
	//private Long time;

	public int getId() {
		return id;
	}

	

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTypeStr(){
		String typeStr="";
		switch (type) {
		case 1:
			typeStr= "VIP客户";
			break;
		case 2:
			typeStr= "普通客户";
			break;
		case 3:
			typeStr= "快速客户";
			break;
		}
		return typeStr;
	}

	public NumberTicket(int type) {
		super();
		this.type = type;
	}
	
	
	
}
