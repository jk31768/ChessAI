package Game.Pieces;

import java.util.HashSet;
import java.util.Set;

import Game.Board;
import Game.Coordinate;

public class Pawn extends PieceType
{
    private String type;
    private char Player;
    private String png;
    //player is either W or B
    public Pawn(char player)
    {
        super(1);
        Player = player;
        if(player=='W')
            png= "/ChessPng/whitepawn.png";
        else
            png= "/ChessPng/blackpawn.png";
        type = "Pawn";
    }

    @Override
    public Set<Coordinate> getValidTiles(int r,int c)
    {
        Set<Coordinate>set = new HashSet<>();
        if(Player=='W') //if player is white
        {
            if(super.getHasMoved()==false)
            {
                set.add(new Coordinate(r - 1, c));
                if(Board.pieceTypes[r-1][c]==null)// prevents jumping over pieces
                    set.add(new Coordinate(r - 2, c));
            }
            else
                if(r-1>=0)
                    set.add(new Coordinate(r-1,c));
        }
        else //if player is black
        {
            if (super.getHasMoved() == false)
            {
                set.add(new Coordinate(r + 1, c));
                if(Board.pieceTypes[r+1][c]==null) //prevents jumping over pieces
                    set.add(new Coordinate(r + 2, c));
            }
            else
                if (r + 1 < 8)
                    set.add(new Coordinate(r + 1, c));
        }
        return set;
    }

    @Override
    public char getPlayer()
    {
        return Player;
    }
    public String getType()
    {
        return type;
    }
    public String getPng()
    {
        return png;
    }
}
