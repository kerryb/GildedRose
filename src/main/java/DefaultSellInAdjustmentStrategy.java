public class DefaultSellInAdjustmentStrategy implements Strategy {
  private Item item;

  public DefaultSellInAdjustmentStrategy(Item item) {
    this.item = item;
  }

  public void run() {
    item.setSellIn(item.getSellIn() - 1);
  }
}