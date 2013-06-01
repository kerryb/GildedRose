public class NormalItem extends UpdatableItem {
  public NormalItem(final Item item) {
    super(item);
  }

  @Override
  protected Strategy sellInAdjustmentStrategy() {
    return new DefaultSellInAdjustmentStrategy(item);
  }

  @Override
  protected Strategy qualityAdjustmentStrategy() {
    return new DefaultQualityAdjustmentStrategy(item);
  }
}