package Core;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Core.Player;

/**
 *
 * @author quanicus
 */
public class EightsPlayer extends Player {

    private int score;

    public EightsPlayer(int id){

        super(id);
        score = 0;
    }

    public int getScore(){ return score; }

    public void updateScore(int points){
        score += points;
    }


}
