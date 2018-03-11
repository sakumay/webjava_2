package shopWork;

import productData.MenuData;
import productData.OrderData;
import productData.SelectionMenuData;

public class TotsuzenStakeShop extends Shop {

  TotsuzenStakeShop(String shopName) {
    super(shopName);
  }

  MenuData menuData = new MenuData();
  SelectionMenuData selectionMenuData = new SelectionMenuData();
  int totalFee = 0;

  @Override
  public void setMenu(){
    menuData.addData("リブロース", 7);
    menuData.addData("ヒレ", 9);
    menuData.addData("国産牛サーロイン", 10);

    selectionMenuData.addData("スープセット", 180);
    selectionMenuData.addData("ライスセット", 200);
    selectionMenuData.addData("サラダセット", 250);
    selectionMenuData.addData("ライル&スモールサラダセット", 350);
    selectionMenuData.addData("スープ&スモールサラダセット", 350);
    selectionMenuData.addData("ライル&スープ&スモールサラダセット", 530);
  }

  @Override
  public String orderCheck(OrderData orderData) {
    int meatFee = 0;
    // 突然ステーキの処理を記載
    System.out.println("◆◆"+shopName+"へようこそ◆◆");
    //肉の種類を確認
    String message1 = "\r\nお好きな肉の種類を選び、番号を入力してください\r\n";
    meatFee = checkMenuData(menuData, message1, orderData);
    if(meatFee < 0) {
      orderData.setOrderMessage("\r\nなにも注文をしなかった\r\n");
      return null;
    }else {
      orderData.setOrderMessage(shopName.concat("にて\r\n"));
    }
    //肉のグラム数を確認
    boolean continueFlg = true;
    boolean errorMassageFlg = false;
    int choseNumber = 0;
    while (continueFlg) {
      System.out.println("◆◆お好みのグラム数をお選びください◆◆");
      if (errorMassageFlg) {
        System.out.println("\r\n[!]入力コマンドが正しくありませんでした[!]");
      }
      System.out.print("\r\nグラム数を入力してください　＞ ");
      String input = getInputData();

      try {
        choseNumber = Integer.parseInt(input);
      } catch (NumberFormatException error) {
        errorMassageFlg = true;
      }
      if (0 == choseNumber) {
        errorMassageFlg = true;
      } else {
        continueFlg = false;
        totalFee += meatFee * choseNumber;
        String addMessage = " "+input+"g";
        orderData.addOrderMessage(orderData.getOrder().concat(addMessage));
      }
    }
    //セットメニューを確認
    String message2 = "\r\nお好きなセットメニューを選び、番号を入力してください\r\n";
    totalFee += checkSelectionMenuData(selectionMenuData, message2, orderData);
    if(orderData.getOrder() !=null) {
      orderData.addOrderMessage("\r\n"+orderData.getOrder());
    }
    return orderData.getOrderMessage();
  }

  @Override
  public int doAccounting() {
    //会計
    System.out.println("\r\n◆◆  お会計  ◆◆");
    System.out.println("小計　｜" + totalFee + "円");
    int consumptionTax = (int) (totalFee * 0.08);
    System.out.println("消費税｜" + consumptionTax + "円");
    System.out.println("合計　｜" + (totalFee + consumptionTax) + "円");
    System.out.println("となります");

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("\r\n◆◆" + shopName + "へのご利用ありがとうございました◆◆");
    System.out.println("◆◆またのご来店をお待ちしております◆◆");
    return totalFee + consumptionTax;
  }

}
