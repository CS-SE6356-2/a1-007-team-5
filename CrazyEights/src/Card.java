
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
}
