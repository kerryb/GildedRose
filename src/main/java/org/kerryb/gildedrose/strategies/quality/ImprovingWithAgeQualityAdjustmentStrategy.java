package org.kerryb.gildedrose.strategies.quality;
import org.kerryb.gildedrose.items.UpdatableItem;
import org.kerryb.gildedrose.strategies.Strategy;


public class ImprovingWithAgeQualityAdjustmentStrategy implements Strategy {
  private UpdatableItem item;

  public ImprovingWithAgeQualityAdjustmentStrategy(final UpdatableItem item) {
    this.item = item;
  }

  public void run() {
    item.increaseQualityBy(1);
  }
}
