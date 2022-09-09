/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.trackers;

/**
 *
 * @author andre
 */
public class ListNode {
    private Game data;
    private ListNode next;

    public ListNode(){//Basic set up

    }
    public ListNode(Game data){
        this.data=data;
    }
    public ListNode(Game data, ListNode next){
        this.data=data;
        this.next=next;
    }
    public Game getData(){//Getters and Setters
        return data;
    }
    public ListNode getNext(){
        return next;
    }
    public void setData(Game data){
        this.data=data;
    }
    public void setNext(ListNode next){
        this.next=next;
    }
}