import java.util.Scanner;

import model.Buyers;
import model.Lottos;
import model.StoreResult;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.printf("구입금액을 입력해 주세요.");
		Buyers buyer = new Buyers();

		int money = sc.nextInt();
		Lottos lottos = buyer.buyLotto(money);

		Lottos.printLottoTickets(lottos);

		System.out.printf("지난 주 당첨 번호를 입력해 주세요.");
		StoreResult store = new StoreResult();
		String numbers = sc.nextLine();
		store.setNumber(numbers);
		//
		// System.out.printf("보너스 볼을 입력해 주세요.");
		// String bonus = sc.nextLine();
		// store.setBonus(bonus);



	}
}