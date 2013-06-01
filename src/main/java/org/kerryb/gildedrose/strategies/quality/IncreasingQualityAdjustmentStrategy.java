package org.kerryb.gildedrose.strategies.quality;
import org.kerryb.gildedrose.items.UpdatableItem;
import org.kerryb.gildedrose.strategies.Strategy;


public class IncreasingQualityAdjustmentStrategy implements Strategy {
  private UpdatableItem item;

  public IncreasingQualityAdjustmentStrategy(final UpdatableItem item) {
    this.item = item;
  }

  public void run() {
    item.increaseQualityBy(1);
  }
}
