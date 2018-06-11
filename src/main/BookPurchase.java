package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import common.Constant;

public class BookPurchase {

    Map<String, Integer> employeeNameAndMoneyMap = new HashMap<String, Integer>();

    public static void main(String args[]) {
        BookPurchase bookPurchase = new BookPurchase();
        // 入力
        bookPurchase.input();
        // 出力
        bookPurchase.output();
    }

    public void input() {
        System.out.println(Constant.INPUT_START);
        Scanner sc = new Scanner(System.in);
        // 社員数
        System.out.print(Constant.EMPLOYEE_NUM);
        int employeeNum = sc.nextInt();
        // 社員名
        System.out.print(Constant.EMPLOYEE_NAME);
        List<String> employeeNamelist = new ArrayList<String>();
        for (int i = 0; i < employeeNum; i++) {
            employeeNamelist.add(sc.next());
        }
        // 社員が購入した本の数
        System.out.print(Constant.EMPLOYEE_PURCHASE_BOOK_NUM);
        int employeePurchaseBookNum = sc.nextInt();
        // 社員名と金額
        System.out.print(Constant.EMPLOYEE_NAME_AND_MONEY);
        for (int i = 0; i < employeePurchaseBookNum; i++) {
            String key = sc.next();
            int value = sc.nextInt();
            for (String name : employeeNamelist) {
                if (name.equals(key)) {
                    if (employeeNameAndMoneyMap.get(key) != null) {
                        employeeNameAndMoneyMap.put(key, employeeNameAndMoneyMap.get(key) + value);
                    } else {
                        employeeNameAndMoneyMap.put(key, value);
                    }
                    break;
                }
            }
        }
        System.out.println();
        System.out.println(Constant.INPUT_END);
    }

    public void output() {
        // ---出力開始---
        System.out.println(Constant.OUTPUT_START);
        List<Entry<String, Integer>> list_entries =
                new ArrayList<Entry<String, Integer>>(employeeNameAndMoneyMap.entrySet());
        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        for (Entry<String, Integer> entry : list_entries) {
            System.out.println(entry.getKey());
        }
        // ---出力終了---
        System.out.println();
        System.out.println(Constant.OUTPUT_END);
    }

}
