/*T
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list;

import Com.Employee;
import java.util.Scanner;

import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 *
 * @author MQ
 */
public class LL_EmpList extends SLL {

    Scanner sc = null;

    public LL_EmpList() {
        super();
        sc = new Scanner(System.in);
    }

    private SLLNode<Employee> find(String code) {
        SLLNode<Employee> ref;
        for (ref = this.getHead(); ref != null; ref = ref.next) {
            if (ref.info.getCode().equals(code)) {
                return ref;
            }
        }
        return null;
    }

    public static int checkName(String name) {
        int cn = 0;
        if (!"".equals(name)) {
            for (int i = 0; i < name.length(); i++) {
                char NN = name.charAt(i);
//only characters is allowed
                if (Character.isLetter(NN)) {
                    cn++;
                }
                if (NN == ' ') {
                    if (name.matches("\\W*")) {
                        cn--;
                    }
                    cn++;
                }
            }
            if (cn == name.length()) {
                return 1;
            }
        } else {
            return 0;
        }
        return 0;
    }

    public void add() {
        String code = "", name = "", salary;
        double nsalary = 0;
        System.out.println("Add new employee");
        boolean proceed = false;
        //code
        do {
            System.out.print("Enter employee's code:");
            code = sc.nextLine().toUpperCase();
            proceed = find(code) != null;
            if (proceed == true) {
                System.out.println("This code is duplicated");
            }
        } while (proceed);
        //name
        do {
            System.out.print("Enter employee's name:");
            name = sc.nextLine().trim();
            proceed = (name.length() == 0);
            if (proceed == true) {
                System.out.println("Employee's name must be inputted.");
            }
        } while (checkName(name) == 0 || proceed);
        //salary
        do {
            System.out.print("Enter employee's salary:");
            salary = sc.nextLine();
            if (isNumber(salary)) {
                nsalary = Double.parseDouble(salary);
                if (nsalary <= 0) {
                    System.out.println("Employee's salary must be greater than 0.");
                }
            } else {
                System.out.println("Wrong input, type again, must be an interger!");
            }
        } while (nsalary <= 0 || isNumber(salary));
        //add this emp to the end of list
        Employee emp = new Employee(code, name, nsalary);
        this.addToTail(emp);
        System.out.println("This employee is added.");
    }

    //remove an emp from list
    public void remove() {
        if (this.isEmpty()) {
            System.out.println("This list is empty.");
        } else {
            String code = "";
            System.out.println("Enter the code of employee who will be removed:");
            code = sc.nextLine().toUpperCase();
            SLLNode<Employee> ref = find(code);
            if (ref == null) {
                System.out.println("He/She does not exist.");
            } else {
                this.delete(ref.info);
                System.out.print("This employee has been removed.");
            }
        }
    }

    //Increase salary
    public void increaseSalary() {
        if (this.isEmpty()) {
            System.out.println("This list is empty.");
        } else {
            String code = "";
            System.out.print("Enter the code of employee who will be promoted:");
            code = sc.nextLine().toUpperCase();
            SLLNode<Employee> ref = find(code);
            if (ref == null) {
                System.out.println("He/She does not exist.");
            } else {
                double oldSal = ref.info.getSalary();
                double newSal = 0;
                String nS;

                do {
                    System.out.println("Old salary" + oldSal + ", new salary:");
                    if (isNumber(sc.nextLine())) {
                        newSal = Double.parseDouble(sc.nextLine());
                    } else {
                        System.out.println("Wrong input, type again!");
                    }
                } while (newSal <= oldSal);
                ref.info.setSalary(newSal);
                System.out.println("His/her salary has been updated.");
            }
        }
    }

    public void print() {
        if (this.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("EMPLOYEE LIST");
            this.printAll();
        }
    }

    public static boolean isNumber(String a) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(a, pos);
        return a.length() == pos.getIndex();
    }
}
