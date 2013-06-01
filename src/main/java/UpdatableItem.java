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
    if (isLegendary(item)) {
      return new LegendaryItem(item);
    } else {
      return new NormalItem(item);
    }
  }

  protected abstract Strategy sellInAdjustmentStrategy();

  protected abstract Strategy qualityAdjustmentStrategy();

  private static boolean isLegendary(final Item item) {
    return "Sulfuras, Hand of Ragnaros".equals(item.getName());
  }
}