package com.lht91.web.lotto;

import org.springframework.stereotype.Service;

@Service
public class LottoServiceImpl implements LottoService{
	private Lotto[] lottos;
	private int count;
	
	public LottoServiceImpl() {
		lottos = new Lotto[10];
		count = 0;
	}

	@Override
	public void buy(Lotto lotto) {
		lottos[count] = lotto;
		count++;
	}

	@Override
	public int count() {
		return count;
	}
}
