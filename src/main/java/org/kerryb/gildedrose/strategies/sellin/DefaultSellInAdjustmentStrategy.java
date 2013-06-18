package org.kerryb.gildedrose.strategies.sellin;
import org.kerryb.gildedrose.items.UpdatableItem;
import org.kerryb.gildedrose.strategies.Strategy;


public class DefaultSellInAdjustmentStrategy implements Strategy {
  private UpdatableItem item;

  public DefaultSellInAdjustmentStrategy(UpdatableItem item) {
    this.item = item;
  }

  public void execute() {
    item.decreaseSellIn();
  }
}