package org.kerryb.gildedrose.strategies.sellin;
import org.kerryb.gildedrose.items.Item;
import org.kerryb.gildedrose.strategies.Strategy;


public class DefaultSellInAdjustmentStrategy implements Strategy {
  private Item item;

  public DefaultSellInAdjustmentStrategy(Item item) {
    this.item = item;
  }

  public void run() {
    item.setSellIn(item.getSellIn() - 1);
  }
}