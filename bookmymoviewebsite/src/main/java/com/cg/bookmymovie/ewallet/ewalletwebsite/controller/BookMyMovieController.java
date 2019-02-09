package com.cg.bookmymovie.ewallet.ewalletwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.cg.bookmymovie.ewallet.ewalletwebsite.entity.Ewallet;
import com.cg.bookmymovie.ewallet.ewalletwebsite.entity.Statement;

@Service
@Controller
@EnableOAuth2Sso
public class BookMyMovieController {

		@Autowired
		private RestTemplate restTemplate;

		@RequestMapping("/DepositForm")
		public String depositForm() {
			return "DepositForm";
		}
		@RequestMapping("/deposit")
		public String deposit(@ModelAttribute Ewallet wallet, Model model) {
			//restTemplate.postForEntity("http://localhost:1111/ewallets/", wallet, null);			
			restTemplate.put("http://localhost:1111/ewallets/"+ wallet.getProfileId() +"?amount="+wallet.getCurrentBalance(), null);
			model.addAttribute("message", "Successfully added money!");
			return "DepositForm";
		}
			
		@RequestMapping("/WithdrawForm")
		public String withdrawForm() {
			return "WithdrawForm";
		}
		@RequestMapping("/withdraw")
		public String withdraw(@ModelAttribute Ewallet wallet, Model model) {
			//restTemplate.postForEntity("http://localhost:1111/ewallets/", wallet, null);			
			restTemplate.put("http://localhost:1111/ewallets/ewallet/"+ wallet.getProfileId() +"?amount="+wallet.getCurrentBalance(), null);
			model.addAttribute("message", "ticket booked Successfully...!");
			return "WithdrawForm";
		}
	
		
		@RequestMapping("/StatementForm")
		public String statementForm() {
			return "StatementForm";
		}
		
		@RequestMapping("/statement")
		public String statement(@ModelAttribute Ewallet wallet, Model model) {
			restTemplate.getForObject("http://localhost:1111/ewallets/ewalletsstatement/"+wallet.getProfileId() , Statement.class);
			return "StatementForm";
		}
	
		
		
}
