package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {

    @Test
    public void StockMarketBaseFuncTest() {
        var market = new Task6.Market();
        var aliExpress = new Task6.Stock("Aliexpress", 220);
        var tesla = new Task6.Stock("Tesla", 150);

        market.add(aliExpress);
        market.add(tesla);

        assertThat(market.mostValuableStock()).isEqualTo(aliExpress);
        market.remove(aliExpress);
        assertThat(market.mostValuableStock()).isEqualTo(tesla);
    }
}
