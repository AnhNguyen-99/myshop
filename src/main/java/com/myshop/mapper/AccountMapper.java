package com.myshop.mapper;

import com.myshop.dto.AccountDTO;
import com.myshop.entity.Account;

public class AccountMapper {

	public static AccountDTO toAccountDTO(Account account) {
		AccountDTO tmp = new AccountDTO();
		tmp.setAccountId(account.getAccountId());
		tmp.setAccountName(account.getAccountName());
		tmp.setAccountPass(account.getAccountPass());
		tmp.setFullName(account.getFullName());
		tmp.setAddress(account.getAddress());
		tmp.setMail(account.getMail());
		tmp.setMobile(account.getMobile());
		tmp.setAccountStatus(account.getAccountStatus());
		tmp.setCreateDate(account.getCreateDate());
		return tmp;
	}
}
