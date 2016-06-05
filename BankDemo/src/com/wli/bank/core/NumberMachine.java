package com.wli.bank.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 
 * 取号机，单例  
 * @author ali  
 * @version  0.8 
 * 2016年6月5日 下午4:41:02
 */
public class NumberMachine {
	
	private static Map<Integer,ConcurrentLinkedQueue<NumberTicket>> ticketMap;
	
	private static  NumberMachine machine=new NumberMachine();
	
	private NumberMachine(){
		ticketMap=new ConcurrentHashMap<Integer,ConcurrentLinkedQueue<NumberTicket>>();
		for(int i=1;i<=3;i++){
			ticketMap.put(i, new ConcurrentLinkedQueue<NumberTicket>());
		}
	}
	
	public static NumberMachine getMachine(){
		return machine;
	}
	
	public NumberTicket createTicket(int type){
		NumberTicket numberTicket=new NumberTicket(type);
		ticketMap.get(type).add(numberTicket);
		return numberTicket;
	}
	
	public NumberTicket popTicket(int type){
		NumberTicket numberTicket=ticketMap.get(type).poll();
		return  numberTicket;
	}
	

	public static Map<Integer, ConcurrentLinkedQueue<NumberTicket>> getTicketMap() {
		return ticketMap;
	}

	public static void setTicketMap(Map<Integer, ConcurrentLinkedQueue<NumberTicket>> ticketMap) {
		NumberMachine.ticketMap = ticketMap;
	}

	public NumberTicket VipOrFastPopCommonicket() {
		return popTicket(2);
	}
	
	
	
}
