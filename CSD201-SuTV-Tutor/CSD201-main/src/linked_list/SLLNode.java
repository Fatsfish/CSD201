/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list;

/**
 *
 * @author HP
 */
public class SLLNode <T> {
    T info;
    SLLNode<T> next;
    
    public SLLNode() 
    {
        next = null;
    }
    
    public SLLNode(T e1)
    {
        info = e1;
        next = null;
    }
    
    public SLLNode(T e1, SLLNode<T> afterEle)
    {
        info = e1; 
        next = afterEle;
    }
}
