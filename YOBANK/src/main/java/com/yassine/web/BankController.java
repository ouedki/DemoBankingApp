package com.yassine.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yassine.modeles.Account;
import com.yassine.modeles.Transaction;
import com.yassine.services.IBankService;

@Controller
public class BankController {
	
	@Autowired
	private IBankService bankService;
	
	@RequestMapping("/operations")
	public String index () {
		return "index";
	}
	
	@RequestMapping("/checkAcc")
	public String consultAccount (Model m, String accId, 
			@RequestParam(name="page", defaultValue="0") int page, 
			@RequestParam(name="size", defaultValue="5")int size) {
		m.addAttribute("accountId", accId);
		try {
			Account acc = bankService.checkAccount(accId);
			Page<Transaction> p = bankService.getTransactions(accId, page, size);
			m.addAttribute("listTransaction", p.getContent());
			int[] pages = new int [p.getTotalPages()];
			m.addAttribute("pages", pages);
			m.addAttribute("account", acc);
		} catch (Exception e) {
			m.addAttribute("exception", e);
		}
		return "index";
	}
	
	@RequestMapping(value="/makeTransaction", method=RequestMethod.POST)
	public String makeTransaction (Model model, String typeOperation, String accId, double amount, String accId2) {
		try {
			if (typeOperation.equals("deposit")) {
				bankService.deposit(accId, amount);
			}else if(typeOperation.equals("withdraw")) {
				bankService.withdraw(accId, amount);
			}else if(typeOperation.equals("transfer")) {
				bankService.transfer(accId, accId2, amount);;
			}
		} catch (Exception e) {
			model.addAttribute("error", e);
			return "redirect:/checkAcc?accId=" + accId + "&error="+e.getMessage();
		}
		return "redirect:/checkAcc?accId=" + accId;
	}

}
