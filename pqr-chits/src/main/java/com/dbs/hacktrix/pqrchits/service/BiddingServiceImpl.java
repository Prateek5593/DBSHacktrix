package com.dbs.hacktrix.pqrchits.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.hacktrix.pqrchits.domain.Bids;
import com.dbs.hacktrix.pqrchits.domain.Chits;
import com.dbs.hacktrix.pqrchits.domain.UserMoneyPerChit;
import com.dbs.hacktrix.pqrchits.repository.BidsRepo;
import com.dbs.hacktrix.pqrchits.repository.ChitsRepo;
import com.dbs.hacktrix.pqrchits.repository.ChitsUsersRepo;
import com.dbs.hacktrix.pqrchits.repository.UserMoneyPerChitRepo;
import com.dbs.hacktrix.pqrchits.util.BiddingUtil;

@Service
public class BiddingServiceImpl implements BiddingService {

	@Autowired
	private BidsRepo bidsRepo;

	@Autowired
	private ChitsRepo chitsRepo;

	@Autowired
	private UserMoneyPerChitRepo userMoneyPerChitRepo;

	@Autowired
	private ChitsUsersRepo chitsUsersRepo;

	@Override
	public String submitBid(Integer userId, Integer chitfundId, int amount) {
		if (BiddingUtil.isBidOpen(chitfundId)) {
			String bidMessage = BiddingUtil.isValidBid(userId, chitfundId, amount);
			if (bidMessage.equals("sucessful")) {
				Bids bid = bidsRepo.findByChitsID(chitfundId);
				if (null == bid) {

					bid = new Bids(chitfundId, userId, amount, true);
				} else {
					bid.setUserId(userId);
					bid.setAmount(amount);

				}
				bidsRepo.save(bid);
			}

		} else {
			return "Sorry Bidding Window is not opened now.";
		}

		return null;
	}

	@Override
	public void processesBid(Integer chitfundId) {
		Chits chit = chitsRepo.findById(chitfundId).isPresent() ? chitsRepo.findById(chitfundId).get() : null;
		Bids bidOfFund = bidsRepo.findByChitsID(chitfundId);
		processCurrentBid(bidOfFund, chit);
	}

	private void processCurrentBid(Bids bid, Chits chit) {
		int userId = bid.getUserId();
		int chitFundId = bid.getChitsID();
		int bidAmount = bid.getAmount();

		int commission = chit.getCommision();
		int chitAmount = chit.getAmount();
		int chargeableAmount = chitAmount * commission / 100;
		int discount = chitAmount - bidAmount;
		int perPersonAmount = chitAmount / chit.getNumPersons();
		int payableByBidder = perPersonAmount - bidAmount - discount / chit.getNumPersons()
				+ chargeableAmount / chit.getNumPersons();
		int paybaleByOther = perPersonAmount - discount / chit.getNumPersons()
				+ chargeableAmount / chit.getNumPersons();
		processAmount(userId, chitFundId, payableByBidder, paybaleByOther, chargeableAmount);

	}

	private void processAmount(int userId, int chitFundId, int payableByBidder, int paybaleByOther,
			int chargeableAmount) {
		List<UserMoneyPerChit> list = userMoneyPerChitRepo.findAllByChitID(chitFundId);
		for (UserMoneyPerChit userMoneyPerChit : list) {
			if (userMoneyPerChit.getUserId() == userId) {
				int amount = userMoneyPerChit.getAmount() + payableByBidder;
				userMoneyPerChit.setAmount(amount);
			} else {
				int amount = userMoneyPerChit.getAmount() + paybaleByOther;
				userMoneyPerChit.setAmount(amount);
			}
			userMoneyPerChitRepo.save(userMoneyPerChit);
		}

	}

	@Override
	public void updateDiscount(int amount) {
		// TODO Auto-generated method stub

	}

}
