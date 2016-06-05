package com.wli.bank.po;

import com.wli.bank.core.NumberMachine;
import com.wli.bank.core.NumberTicket;

/**
 * 
 * 模拟客户   
 * @author ali  
 * @version  0.8 
 * 2016年6月5日 下午4:29:48
 */
public class User{
	
	private String name;
	
	/**
	 * 客户类型，1vip,2普通，3快速
	 */
	private int type=1;
	
	private NumberTicket numberTicket;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public User(String name, int type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	
	
	
	public NumberTicket getNumberTicket() {
		return numberTicket;
	}

	public void setNumberTicket(NumberTicket numberTicket) {
		this.numberTicket = numberTicket;
	}

	
	
	public void getTicket(){
		NumberTicket ticket= NumberMachine.getMachine().createTicket(type);
		this.numberTicket=ticket;
		System.out.println(ticket.getId()+"号"+ticket.getTypeStr()+"取到票");
	}
	
	
	
	
}
