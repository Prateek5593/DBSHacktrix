package com.dbs.hacktrix.pqrchits.service;

public interface BiddingService {

	public String submitBid(Integer userId,Integer chitfundId,int amount);
	
		
	public void processesBid(Integer chitfundId);
	
	public void updateDiscount(int amount);
	
	
}
