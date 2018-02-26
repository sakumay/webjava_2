package shopWork;

import java.util.Scanner;
import productData.AdditionalMenuData;
import productData.MenuData;
import productData.SelectionMenuData;

public class SelectItemPrice {
  int ItemPrice = 0;

  public boolean select(MenuData menuData, boolean errorMassageFlg) {
    int choseNumber = 0;

    for(int count = 0; count < menuData.getSize(); count++) {
      System.out.print((count+1)+"）"+menuData.getName(count)+" ");
      System.out.print("： "+menuData.getPrice(count)+"円\r\n");
    }
    System.out.print("e）選択を終了する\r\n");

    if(errorMassageFlg) {
      System.out.println("\r\n[!]入力コマンドが正しくありませんでした[!]");
    }
    System.out.print("\r\n番号を入力してください　＞ ");

    String input = getInputData();

    if(input.equals("e")) {
      ItemPrice = -1;
      return true;

    }else {
      try {
        choseNumber = Integer.parseInt(input);
      }catch(NumberFormatException error) {
      }
      if(menuData.getSize() < choseNumber || choseNumber == 0) {
      }else {
        ItemPrice = menuData.getPrice(choseNumber-1);
        return true;
      }
    }

    return false;
  }


  public boolean select(SelectionMenuData selectionMenuData, boolean errorMassageFlg) {
    int choseNumber = 0;

    for(int count = 0; count < selectionMenuData.getSize(); count++) {
      System.out.print((count+1)+"）"+selectionMenuData.getName(count)+" ");
      System.out.print("： "+selectionMenuData.getPrice(count)+"円\r\n");
    }
    System.out.print("e）選択を終了する\r\n");

    if(errorMassageFlg) {
      System.out.println("\r\n[!]入力コマンドが正しくありませんでした[!]");
    }
    System.out.print("\r\n番号を入力してください　＞ ");

    String input = getInputData();

    if(input.equals("e")) {
      ItemPrice = -1;
      return true;

    }else {
      try {
        choseNumber = Integer.parseInt(input);
      }catch(NumberFormatException error) {
      }
      if(selectionMenuData.getSize() < choseNumber || choseNumber == 0) {
      }else {
        ItemPrice = selectionMenuData.getPrice(choseNumber-1);
        return true;
      }
    }

    return false;
  }

  public boolean select(AdditionalMenuData additionalData, boolean errorMassageFlg) {
    int choseNumber = 0;

    for(int count = 0; count < additionalData.getSize(); count++) {
      System.out.print((count+1)+"）"+additionalData.getName(count)+" ");
      System.out.print("：＋ "+additionalData.getPrice(count)+"円\r\n");
    }
    System.out.print("e）追加の選択を終了する\r\n");

    if(errorMassageFlg) {
      System.out.println("\r\n[!]入力コマンドが正しくありませんでした[!]");
    }
    System.out.print("\r\n番号を入力してください　＞ ");

    String input = getInputData();

    if(input.equals("e")) {
      ItemPrice = -1;
      return true;
    }else {
      try {
        choseNumber = Integer.parseInt(input);
      }catch(NumberFormatException error) {
      }
      if(additionalData.getSize() < choseNumber || choseNumber == 0) {
      }else {
        ItemPrice = additionalData.getPrice(choseNumber-1);
        return true;
      }
    }
    return false;
  }

  public int getPrice() {
    return ItemPrice;
  }

  private String getInputData() {
    Scanner scan = new Scanner(System.in);
    String input = scan.next();

    if(input.isEmpty()) {
      input = "b";
    }
    return input;
  }

}
