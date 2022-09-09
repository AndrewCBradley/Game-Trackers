/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.trackers;

import java.sql.Date;

/**
 *
 * @author andre
 */
public class GameRAF extends Game {
    private int id;
    public GameRAF(Date date,String gameName, int rounds, int frags, int deaths, int assists){
        super(date,gameName,rounds,frags,deaths,assists);
        this.id =id;
    }
    public int getId()//Allows ID to be stored and helps for deletion.
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

}
