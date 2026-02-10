package model;

import java.util.*;
import java.util.stream.Collectors;

public class StoreResult {
	List<Integer> numbers;
	Integer bonus;

	public StoreResult(){
		numbers = new ArrayList<>();;
	}

	public List<Integer> setNumber(String input) {
		numbers = Arrays.stream(input.split(","))
			.map(String::trim)
			.map(Integer::parseInt)
			.collect(Collectors.toList());

		if(numbers.size() != 6) throw new RuntimeException("당첨 번호는 6개의 숫자로 이루어져야 합니다");

		numbers.forEach(n -> Optional.of(n).filter(v -> (1 <= v && v <= 45)).orElseThrow(() -> new RuntimeException("당첨 번호는 1 ~ 45 사이의 양수로 이루어져야 합니다.")));

		Set<Integer> set = new HashSet<>();
		numbers.stream()
				.filter(n -> !set.add(n)) // set에 추가 실패하면 중복임
				.findFirst()
				.ifPresent(n -> {
					throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다");
				});

		return numbers;
	}

	public Integer setBonus(String input) {
		bonus = Integer.parseInt(input);
		return bonus;
	}

	public Integer size(){
		return this.numbers.size();
	}

	public void validate(){

	}
}
