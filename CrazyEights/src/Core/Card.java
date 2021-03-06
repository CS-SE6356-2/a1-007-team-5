package Core;

public class Card
{
    Face face;
    Suit suit;

    public Card(Face f, Suit s)
    {
        face = f;
        suit = s;
    }

    public Face getFace()
    {
        return face;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public String toString(){
        return face.getValue() + suit.getValue();
    }
}
