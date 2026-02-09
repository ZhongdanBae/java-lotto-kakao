import model.Vendor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVendor {
    @Test
    void 올바른_금액이_주어졌을때는_적정_개수의_로또를_반환한다(){
        int money = 13700;

        Vendor vendor = new Vendor();

        assertThat(vendor.sell(money).getQuantity()).isEqualTo(13);

    }
}
