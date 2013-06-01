package org.kerryb.gildedrose.items;
import org.kerryb.gildedrose.strategies.Strategy;
import org.kerryb.gildedrose.strategies.quality.IncreasingQualityAdjustmentStrategy;
import org.kerryb.gildedrose.strategies.sellin.DefaultSellInAdjustmentStrategy;

public class ImprovingWithAgeItem extends UpdatableItem {
  public ImprovingWithAgeItem(final Item item) {
    super(item);
  }

  @Override
  protected Strategy sellInAdjustmentStrategy() {
    return new DefaultSellInAdjustmentStrategy(this);
  }

  @Override
  protected Strategy qualityAdjustmentStrategy() {
    return new IncreasingQualityAdjustmentStrategy(this);
  }
}