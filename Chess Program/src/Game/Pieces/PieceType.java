package Game.Pieces;

import java.util.Set;
import Game.Coordinate;

public abstract class PieceType
{
    private int value;
    private boolean hasMoved;
    public PieceType(int i)
    {
        value = i;
        hasMoved = false;
    }
    public abstract  Set<Coordinate> getValidTiles(int row,int col);
    public abstract char getPlayer();
    public abstract String getPng();
    public abstract String getType();
    public void setHasMovedToTrue()
    {
        hasMoved =true;
    }
    public boolean getHasMoved()
    {
        return hasMoved;
    }


}
