package org.kerryb.gildedrose.strategies.quality;
import org.kerryb.gildedrose.items.UpdatableItem;
import org.kerryb.gildedrose.strategies.Strategy;


public class DecreasingQualityAdjustmentStrategy implements Strategy {
  private UpdatableItem item;
  private int rate;

  public DecreasingQualityAdjustmentStrategy(final UpdatableItem item, final int rate) {
    this.item = item;
    this.rate = rate;
  }

  @Override
  public void run() {
    item.decreaseQualityBy(decrement());
  }

  private int decrement() {
    if (item.hasExpired()) {
      return rate * 2;
    } else {
      return rate;
    }
  }
}