package com.dbs.hacktrix.pqrchits.util;

import com.dbs.hacktrix.pqrchits.domain.Chits;
import com.dbs.hacktrix.pqrchits.domain.User;
import com.dbs.hacktrix.pqrchits.domain.UserMoneyPerChit;

public class BiddingUtil {

	public static boolean isBidOpen(Integer chitID) {
		long startTime = 0;
		// TODO:
		// chitFundServiceGetStartTime()
		long endTime = 0;
		long currentTimeMillis = System.currentTimeMillis();
		if (currentTimeMillis > startTime && endTime > currentTimeMillis) {
			return true;
		}
		return false;

	}

	public static String isValidBid(Integer userId, Integer chitfundId, int bidAmount) {
		// TODO:
		Chits chit = new Chits();
		int amountAvaliable = chit.getAmount();
		if (bidAmount < 0 || bidAmount > amountAvaliable) {
			return "Please select valid bid amount";
		}
		int currentBalance = getCurrentBalanceOfUser(userId, chitfundId);
		if (currentBalance < 0) {
			return "Your are not eligible for current bid";
		}

		return "sucessful";
	}

	private static int getCurrentBalanceOfUser(Integer userId, Integer chitfundId) {
		// TODO:
		UserMoneyPerChit userMoneyPerChit = null;
		return userMoneyPerChit.getAmount();
	}
}
