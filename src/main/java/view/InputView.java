package view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public Integer readPurchaseMoney() {
        System.out.print("구입금액을 입력해 주세요.");
        if (!scanner.hasNextLine()) return null;
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public String readWinningNumbers() {
        System.out.print("지난 주 당첨 번호를 입력해 주세요.");
        if (!scanner.hasNextLine()) return null;
        return scanner.nextLine();
    }

    public String readBonusNumber() {
        System.out.print("보너스 볼을 입력해 주세요.");
        if (!scanner.hasNextLine()) return null;
        return scanner.nextLine();
    }
}
