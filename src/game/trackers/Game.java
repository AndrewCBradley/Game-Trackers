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

public class Game
{
    private Date date;
    private String gameName;
    private int rounds;
    private int frags;
    private int deaths;
    private int assists;
    
    public Game(Date date,String gameName, int rounds, int frags, int deaths, int assists){
        this.date = date;
        this.gameName = gameName;
        this.rounds = rounds;
        this.frags = frags;
        this.deaths = deaths;
        this.assists = assists;
        
    }
    
    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getGameName()
    {
        return gameName;
    }

    public void setGameName(String gameName)
    {
        this.gameName = gameName;
    }

    public int getFrags()
    {
        return frags;
    }

    public void setFrags(int frags)
    {
        this.frags = frags;
    }

    public int getDeaths()
    {
        return deaths;
    }

    public void setDeaths(int deaths)
    {
        this.deaths = deaths;
    }

    public int getAssists()
    {
        return assists;
    }

    public void setAssists(int assists)
    {
        this.assists = assists;
    }
    public int getRounds()
    {
        return rounds;
    }

    public void setRounds(int rounds)
    {
        this.rounds = rounds;
    }
}
