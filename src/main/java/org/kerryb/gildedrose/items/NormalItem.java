package org.kerryb.gildedrose.items;
import org.kerryb.gildedrose.strategies.Strategy;
import org.kerryb.gildedrose.strategies.quality.DefaultQualityAdjustmentStrategy;
import org.kerryb.gildedrose.strategies.sellin.DefaultSellInAdjustmentStrategy;

public class NormalItem extends UpdatableItem {
  public NormalItem(final Item item) {
    super(item);
  }

  @Override
  protected Strategy sellInAdjustmentStrategy() {
    return new DefaultSellInAdjustmentStrategy(this);
  }

  @Override
  protected Strategy qualityAdjustmentStrategy() {
    return new DefaultQualityAdjustmentStrategy(this);
  }
}