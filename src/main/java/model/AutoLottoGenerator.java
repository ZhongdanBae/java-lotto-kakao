package model;

import java.util.List;

public class AutoLottoGenerator {
	public List<Integer> makeLotto() {
		return List.of(1, 2, 3, 4, 5, 6);
	}

	public Lotto issueLotto() {
		return new Lotto(List.of(1, 2, 3, 4, 5, 6));
	}
}
