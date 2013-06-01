public abstract class UpdatableItem {

  protected Item item;

  public UpdatableItem(Item item) {
    this.item = item;
  }

  public void update() {
    sellInAdjustmentStrategy().run();
    qualityAdjustmentStrategy().run();
  }

  public static UpdatableItem forItem(final Item item) {
    return new NormalItem(item);
  }

  private Strategy sellInAdjustmentStrategy() {
    if (isLegendary()) {
      return new NeverExpiringSellinAdjustmentStrategy();
    } else {
      return new DefaultSellInAdjustmentStrategy(item);
    }
  }

  private Strategy qualityAdjustmentStrategy() {
    return new DefaultQualityAdjustmentStrategy(item);
  }

  private boolean isLegendary() {
    return "Sulfuras, Hand of Ragnaros".equals(item.getName());
  }
}