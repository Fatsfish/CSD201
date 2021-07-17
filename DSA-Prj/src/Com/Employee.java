/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com;
import java.lang.Comparable;
/**
 *
 * @author MQ
 */
public class Employee {
    String code="", name="";
    double salary=0;

    public Employee(String c, String n, double s){
        code=c; name=n; salary=s;}
    public String getCode() {
        return code;}
    public void setCode(String code) {
        this.code = code;}
    public String getName() {
        return name;}
    public void setName(String name) {
        this.name = name;}
    public double getSalary() {
        return salary;}
    public void setSalary(double salary) {
        this.salary = salary;}
    
    public boolean equals (Employee emp){
        return emp.getCode().equals(this.getCode()) &&
               emp.getName().equals(this.getName()) &&
               emp.getSalary() == this.getSalary();
    }
    public String toString(){
        return code + "\t" + name + "\t" + salary;
    }
}
