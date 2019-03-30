package com.dbs.hacktrix.pqrchits.util;

import com.dbs.hacktrix.pqrchits.domain.Bids;
import com.dbs.hacktrix.pqrchits.domain.Chits;
import com.dbs.hacktrix.pqrchits.domain.UserMoneyPerChit;
import com.dbs.hacktrix.pqrchits.repository.ChitsRepo;

public class BiddingUtil {

	private static ChitsRepo chitsRepo;

	public static boolean isBidOpen(Integer chitID) {
		Chits chit = chitsRepo.findById(chitID).isPresent() ? chitsRepo.findById(chitID).get() : null;
		long startTime = chit.getBidStartTime();
		long endTime = chit.getBidEndTime();
		long currentTimeMillis = System.currentTimeMillis();
		if (currentTimeMillis > startTime && endTime > currentTimeMillis) {
			return true;
		}
		return false;

	}

	public static String isValidBid(Integer userId, Integer chitfundId, int bidAmount) {
		Chits chit = chitsRepo.findById(chitfundId).isPresent() ? chitsRepo.findById(chitfundId).get() : null;

		int amountAvaliable = chit.getAmount();
		if (bidAmount < 0 || bidAmount > amountAvaliable) {
			return "Please select valid bid amount";
		}
		int currentBalance = getCurrentBalanceOfUser(userId, chitfundId);
		if (currentBalance < 0) {
			return "Your are not eligible for current bid";
		}
		Bids bid = new Bids();
		if (bid.getUserId().equals(userId)) {
			return "Your are highest bidder as of now";
		}
		if (bid.getAmount() < bidAmount) {
			return "Bid Amount Should be >" + bid.getAmount();
		}

		return "sucessful";
	}

	private static int getCurrentBalanceOfUser(Integer userId, Integer chitfundId) {
		// TODO:
		UserMoneyPerChit userMoneyPerChit = null;
		return userMoneyPerChit.getAmount();
	}
}
