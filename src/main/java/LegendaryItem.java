public class LegendaryItem extends UpdatableItem {

  public LegendaryItem(final Item item) {
    super(item);
  }

  @Override
  protected Strategy sellInAdjustmentStrategy() {
    return new NeverExpiringSellInAdjustmentStrategy();
  }

  @Override
  protected Strategy qualityAdjustmentStrategy() {
    return new DefaultQualityAdjustmentStrategy(item);
  }
}