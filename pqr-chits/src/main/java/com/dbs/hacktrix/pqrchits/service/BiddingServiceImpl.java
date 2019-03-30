package com.dbs.hacktrix.pqrchits.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.dbs.hacktrix.pqrchits.domain.Bids;
import com.dbs.hacktrix.pqrchits.domain.Chits;
import com.dbs.hacktrix.pqrchits.util.BiddingUtil;

public class BiddingServiceImpl implements BiddingService {

	@Override
	public String submitBid(Integer userId, Integer chitfundId, int amount) {
		if (BiddingUtil.isBidOpen(chitfundId)) {
			String bidMessage = BiddingUtil.isValidBid(userId, chitfundId, amount);
			if (bidMessage.equals("sucessful")) {
				// TODO: saveDatainBidTable();
			}

		} else {
			return "Sorry Bidding Window is not opened now.";
		}

		return null;
	}

	@Override
	public void processesBid(Integer chitfundId) {
		// TODO: getBy ChitsFUndId
		Chits chit = new Chits();
		// TODO: get All active bid from db
		List<Bids> bids = new ArrayList<Bids>();
		// TODO: fecth list of tables from getBidSoFar();
		TreeMap<Integer, Bids> map = new TreeMap<>();
		for (Bids bid : bids) {
			map.put(1, bid);
		}
		Entry<Integer, Bids> firstEntry = map.firstEntry();
		if (firstEntry != null) {
			Bids bid = firstEntry.getValue();
			processCurrentBid(bid);
		}
	}

	private void processCurrentBid(Bids bid) {
		long userId = bid.getUserId();
		long chitFundId = bid.getChitsID();
		long bidAmount = bid.getAmount();

		long chargePrecentage = 5;
		long availableLimit = 0;
		long chargeableAmount = availableLimit * chargePrecentage / 100;
		long discount = availableLimit - bidAmount;
		long depositAmount = 0;// Is User Previously buys
		List<Object> abc = getAllUserBychitID();

	}

	@Override
	public void updateDiscount(int amount) {
		// TODO Auto-generated method stub

	}

}
