package org.kerryb.gildedrose.strategies.quality;
import org.kerryb.gildedrose.items.UpdatableItem;
import org.kerryb.gildedrose.strategies.Strategy;


public class DefaultQualityAdjustmentStrategy implements Strategy {
  private UpdatableItem item;

  public DefaultQualityAdjustmentStrategy(final UpdatableItem item) {
    this.item = item;
  }

  @Override
  public void run() {
    item.decreaseQualityBy(decrement());
  }

  private int decrement() {
    if (item.hasExpired()) {
      return 2;
    } else {
      return 1;
    }
  }
}