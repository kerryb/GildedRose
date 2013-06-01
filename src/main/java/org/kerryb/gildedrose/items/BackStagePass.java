package org.kerryb.gildedrose.items;
import org.kerryb.gildedrose.strategies.Strategy;
import org.kerryb.gildedrose.strategies.quality.BackstagePassQualityAdjustmentStrategy;
import org.kerryb.gildedrose.strategies.sellin.DefaultSellInAdjustmentStrategy;

public class BackStagePass extends UpdatableItem {

  public BackStagePass(Item item) {
    super(item);
  }

  @Override
  protected Strategy sellInAdjustmentStrategy() {
    return new DefaultSellInAdjustmentStrategy(item);
  }

  @Override
  protected Strategy qualityAdjustmentStrategy() {
    return new BackstagePassQualityAdjustmentStrategy(item);
  }
}