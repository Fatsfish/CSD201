/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com;

import java.util.Scanner;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;

/**
 *
 * @author MQ
 */
public class Menu extends ArrayList<String> {

    public Menu() {
        super();
    }

    public int getUserChoice() {
        int i;
        String choice;
        double nchoice = 0;
        for (i = 0; i < this.size(); i++) {
            System.out.println((i + 1) + "-" + this.get(i));
        }
        System.out.print("Select an option : 1 to " + i + ":");
        do {
            Scanner sc = new Scanner(System.in);
            choice = sc.nextLine();
            if (!"".equals(choice)) {
                if (isNumber(choice)) {
                    nchoice = Double.parseDouble(choice);
                    if (nchoice > -10000000 && nchoice < 1000000) {
                        return (int) nchoice;
                    } else {
                        System.out.println("Unsupported input, type again!");
                    }
                } else {
                    System.out.println("Invalid input. Please Type again or type 5 to quit");
                }
            } else {
                System.out.println("Can not process empty input, type an integer!");
            }
        } while ((nchoice > 0));
        return i;

    }

    public static boolean isNumber(String a) {

        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(a, pos);
        return a.length() == pos.getIndex();

    }

}
