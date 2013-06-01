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