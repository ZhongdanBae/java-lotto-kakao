package model;

import java.util.*;
import java.util.stream.Collectors;

public class StoreResult {
	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;

	private final Result result;

	public StoreResult(){
		result = new Result();
	}

	public List<Integer> setNumber(String input) {
		List<Integer> numbers = Arrays.stream(input.split(","))
			.map(String::trim)
			.map(Integer::parseInt)
			.collect(Collectors.toList());

		if(numbers.size() != LOTTO_NUMBER_COUNT) throw new RuntimeException("당첨 번호는 6개의 숫자로 이루어져야 합니다");

		numbers.forEach(n -> Optional.of(n).filter(v -> (MIN_LOTTO_NUMBER <= v && v <= MAX_LOTTO_NUMBER)).orElseThrow(() -> new RuntimeException("당첨 번호는 1 ~ 45 사이의 양수로 이루어져야 합니다.")));

		Set<Integer> set = new HashSet<>();
		numbers.stream()
				.filter(n -> !set.add(n))
				.findFirst()
				.ifPresent(n -> {
					throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다");
				});

		result.setNumbers(numbers);
		return result.getNumbers();
	}

	public Integer setBonus(String input) {
		try {
			Integer parsedInt = Integer.parseInt(input);
			if (parsedInt < MIN_LOTTO_NUMBER || parsedInt > MAX_LOTTO_NUMBER) throw new RuntimeException("보너스 번호는 1 ~ 45 사이의 양수로 이루어져야 합니다.");
			if (result.getNumbers().contains(parsedInt)) throw new RuntimeException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
			result.setBonus(parsedInt);
			return result.getBonus();
		}
		catch (NumberFormatException e) {
			throw new RuntimeException("보너스 번호는 1 ~ 45 사이의 양수로 이루어져야 합니다.");
		}
	}

	public Integer size(){
		return this.result.size();
	}

	public Result getResult() {
		return this.result;
	}
}
