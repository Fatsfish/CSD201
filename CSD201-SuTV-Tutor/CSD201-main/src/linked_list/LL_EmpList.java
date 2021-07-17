/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list;
import com.Employee;
import java.util.Scanner;
/**
 *
 * @author HP
 */
public class LL_EmpList extends SLL {
    Scanner sc=null;
    public LL_EmpList()
    {
        super();
                sc = new Scanner(System.in);
    }
    
    private SLLNode<Employee> find (String code)
    {
        SLLNode<Employee> ref;
        for(ref = this.getHead(); ref !=null; ref = ref.next)
            if(ref.info.getCode().equals(code)) return ref;
        return null;
    }
    public void add()
    {
        String code = "", name=""; int salary=0;
        System.out.println("Add new employee");
        boolean proceed = false;
        do
        {
            System.out.println("Enter employee's code: ");
            code = sc.nextLine().toUpperCase();
            proceed = find(code)!=null;
            if(proceed==true) System.out.println("This code is duplicated!");
        }
        while(proceed);
        do
        {
            System.out.println("Enter employee's name: ");
            name = sc.nextLine().trim();
            proceed = (name.length()==0);
            if(proceed == true) System.out.println("Emmployee's name must be inputted.");
        }
        while(proceed);
        do
        {
            System.out.println("Enter employee's salary:");
            salary = Integer.parseInt(sc.nextLine());
            if(salary<=0) System.out.println("Employee's salary must be greater than 0.");
    }
        while(salary<=0);
        Employee emp = new Employee(code, name, salary);
        this.addToTail(emp);
        System.out.println("This employee is added.");
}
    public void remove()
    {
        if(this.isEmpty()) System.out.println("The list is empty.");
        else 
        {
            String code="";
            System.out.println("Enter the code of the employee who will be removed: ");
            code = sc.nextLine().toUpperCase();
            SLLNode<Employee> ref = find(code);
            if(ref==null) System.out.println("He/she does not exist.");
            else
            {
                this.delete(ref.info);
                System.out.println("This employee has been removed.");
            }
        }
    }
    public void increaseSalary()
    {
        if(this.isEmpty()) System.out.println("The list is empty.");
        else 
        {
            String code = "";
            System.out.println("Enter the code of employee who will be promoted: ");
            code = sc.nextLine().toUpperCase();
            SLLNode<Employee> ref = find(code);
            if(ref == null) System.out.println("He/she does not exist.");
            else
            {
                int oldSal = ref.info.getSalary();
                int newSal;
                do
                {
                    System.out.println("Old salary: " + oldSal + ", new salary: ");
                    newSal = Integer.parseInt(sc.nextLine());
                }
                while(newSal<=oldSal);
                ref.info.setSalary(newSal);
                System.out.println("His/her salary has been updated.");
            }
        }
    }
    public void print()
    {
        if(this.isEmpty()) System.out.println("The list is empty.");
        else 
        {
            System.out.println("EMPLOYEE LIST");
            this.printAll();
        }
    }
}
