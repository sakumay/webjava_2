
public abstract class Restaurant {
  public abstract int work(MenuData menuData, AdditionalMenuData additionalData);

  public abstract int work(MenuData menuData, SelectionMenuData selectionMenuData) ;

  public abstract int work(MenuData menuData, SelectionMenuData selectionMenuData, AdditionalMenuData additionalData);
}
