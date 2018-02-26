package productData;
import java.util.ArrayList;

abstract class ItemData {

  ArrayList<String> itemNames = new ArrayList<String>();
  ArrayList<Integer> itemPrices = new ArrayList<Integer>();

  public void addData(String name,int price) {
    itemNames.add(name);
    itemPrices.add(price);
  }

  public String getName(int number) {
    return itemNames.get(number);
  }

  public int getPrice(int number) {
    return itemPrices.get(number);
  }

  public int getSize() {
    return itemNames.size();

  }
}
