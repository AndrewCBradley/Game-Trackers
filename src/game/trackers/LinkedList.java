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
public class LinkedList {
    private ListNode front;
    private int size;

    public LinkedList(){
        front=null;
        size=0;
    }

    public int size(){
        return size+1;
    }
    //Gets the game at index n and returns null if not valid n
    public Game get(int n){//Returns the stored data
        if (front ==null||n<0||n>size) {
            return null;
        }
        ListNode current = front;
        for (int i = 0; i < n; i++) {
            current=current.getNext();
        }
        return current.getData();
    }
    public boolean remove(Game game){//Gets rid of a game
        if (front!=null) {//Makes sure there is something to remove
            ListNode current =front;
            while(current.getNext() !=null){
                if (current.getNext().getData().equals(game)) {//If the next is equal then it overwrites and makes it 1 smaller
                    current.setNext(current.getNext().getNext());
                    size--;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean remove(int n){
        if (n<0||n>size) {
            return false;
        }
        if (front==null) {
            return false;
        }
        ListNode current = front;
        for (int i = 0; i < n-1; i++) {
            current=current.getNext();
        }
        current.setNext(current.getNext().getNext());
        size--;
        return true;
    } 
    public boolean add(Game game) throws Exception{
        return add(game, size);
    }
    
    public boolean add(Game game, int n) throws Exception{
        if (n<0||n>size) {
            return false;
        }
        if (front==null) {//Creates new ListNode if there is none
            front= new ListNode(game);
        }
        ListNode current = front;
        for (int i = 0; i < n; i++) {
            current=current.getNext();
        }
        current.setNext(new ListNode(game));//Add name to the front
        size++;
        return true;
    }
    public boolean isEmpty(){
        return front==null;
    }
}