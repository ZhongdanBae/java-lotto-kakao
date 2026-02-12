package model;

import java.util.ArrayList;
import java.util.List;

public class Result {
	private List<Integer> numbers;
	private Integer bonus;

	public Result() {
		numbers = new ArrayList<>();
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public Integer getBonus() {
		return bonus;
	}

	public Integer size() {
		return numbers.size();
	}
}
