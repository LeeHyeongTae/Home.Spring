package com.lht91.web.lotto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lht91.web.util.Messenger;

@RestController
@RequestMapping("/lotto")
public class LottoController {
	@Autowired LottoService lottoSerive;
	
	@PostMapping("/buy")
	public Messenger buy(@RequestBody Lotto lotto) {
		int count = lottoSerive.count();
		lottoSerive.buy(lotto);
		return (lottoSerive.count()==count+1)? Messenger.SUCCESS:Messenger.FAIL;
	}
	
	@PostMapping("/result")
	public Messenger result(@RequestBody Lotto lotto) {
		
		return Messenger.일등;
	}
}
