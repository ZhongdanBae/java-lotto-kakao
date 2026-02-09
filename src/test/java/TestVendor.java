import static org.assertj.core.api.AssertionsForClassTypes.*;

import model.Vendor;
import org.junit.jupiter.api.Test;

public class TestVendor {
    @Test
    void 올바른_금액이_주어졌을때는_적정_개수의_로또를_반환한다(){
        Integer money = 13000;

        Vendor vendor = new Vendor();

        assertThat(vendor.sell(money).getQuantity()).isEqualTo(13);

    }

    @Test
    void 천원_단위의_금액이_들어오지_않았을_때_에러를_반환한다() {
        Integer money = 13700;
        Vendor vendor = new Vendor();
        try {
            vendor.sell(money);
            fail();
        }
        catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("천원 단위의 금액을 입력해주세요.");
        }
    }

    @Test
    void 양이_아닌_정수가_들어오면_에러를_반환한다(){
        Integer money = 0;
        Vendor vendor = new Vendor();

        try{
            vendor.sell(money);
            fail();
        }
        catch (RuntimeException e){
            assertThat(e.getMessage()).isEqualTo("금액은 0보다 커야 합니다");
        }
    }
}
