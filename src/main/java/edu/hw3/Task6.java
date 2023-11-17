package edu.hw3;

import java.util.PriorityQueue;
import org.jetbrains.annotations.NotNull;

public final class Task6 {
    private Task6() {}

    public record Stock(String name, Integer price)
        implements Comparable<Stock> {

        @Override
        public int compareTo(@NotNull Task6.Stock o) {
            return o.price.compareTo(this.price);
        }
    }

    interface StockMarket {

        void add(Stock stock);

        void remove(Stock stock);

        Stock mostValuableStock();
    }

    public static class StockMarketImpl implements StockMarket {

        private PriorityQueue<Stock> stocks = new PriorityQueue<>();

        @Override
        public void add(Stock stock) {
            stocks.add(stock);
        }

        @Override
        public void remove(Stock stock) {
            stocks.remove(stock);
        }

        @Override
        public Stock mostValuableStock() {
            return stocks.peek();
        }
    }
}
