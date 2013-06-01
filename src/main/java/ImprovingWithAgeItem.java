public class ImprovingWithAgeItem extends UpdatableItem {
  public ImprovingWithAgeItem(final Item item) {
    super(item);
  }

  @Override
  protected Strategy sellInAdjustmentStrategy() {
    return new DefaultSellInAdjustmentStrategy(item);
  }

  @Override
  protected Strategy qualityAdjustmentStrategy() {
    return new ImprovingWithAgeQualityAdjustmentStrategy(item);
  }
}