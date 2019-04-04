package com.team5;

//This class is a dummy version of the EightsGame class, to allow the GUI team to utilize the same API, only a dummy version

public class DummyEightsCore
{
    public DummyEightsCore()
    {
    }

    public void initializeGame()
    {
        System.out.println("Game has begun.");
    }

    public void takeTurn(String player)
    {
        System.out.println(player + " has taken turn.");
    }

    public boolean canPlayCard(String card)
    {
        System.out.println(card + " has been checked if can be played.");
        return true;
    }

    public boolean drawCard(String player)
    {
        System.out.println(player + " draws a card and then system checks if draw deck has more cards.");

        return true;
    }

    public boolean playCard(String player, String card)
    {
        System.out.println(player + " plays " + card + " and then system checks if player has one.");

        return false;
    }

    public void changeSuit(Integer suit)
    {
        System.out.println("Play pile has been changed to " + suit);
    }
}
