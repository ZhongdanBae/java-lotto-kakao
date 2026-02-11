package model;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers){
        if(numbers.size() != LOTTO_NUMBER_COUNT) throw new RuntimeException("로또 번호 개수가 6개가 아닙니다.");
        if(!numbers.stream().allMatch(new HashSet<Integer>()::add)) throw new RuntimeException("로또 번호는 중복될 수 없습니다");
        for( int i = 0; i < numbers.size(); i++ ) {
            isInRange(numbers.get(i));
        }
        this.numbers = numbers;
    }

    public boolean isInRange(Integer value) {
        if ( MIN_LOTTO_NUMBER <= value && value <= MAX_LOTTO_NUMBER ) return true;
        throw new RuntimeException("로또 번호는 1~45까지의 숫자여야 한다.");
    }

    public Integer size(){
        return numbers.size();
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
