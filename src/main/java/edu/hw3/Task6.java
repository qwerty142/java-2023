package edu.hw3;

import java.util.Comparator;
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

    public static class StockComparator implements Comparator<Stock> {

        @Override
        public int compare(Stock o1, Stock o2) {
            return o1.compareTo(o2);
        }
    }

    interface StockMarket {

        void add(Stock stock);

        void remove(Stock stock);

        Stock mostValuableStock();
    }

    public static class Market implements StockMarket {

        private PriorityQueue<Stock> goods;

        public Market() {
            goods = new PriorityQueue<>(new StockComparator());
        }

        @Override
        public void add(Stock stock) {
            goods.add(stock);
        }

        @Override
        public void remove(Stock stock) {
            goods.remove(stock);
        }

        @Override
        public Stock mostValuableStock() {
            return goods.peek();
        }
    }
}
