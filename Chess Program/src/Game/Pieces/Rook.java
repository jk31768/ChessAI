package Game.Pieces;

import Game.Board;
import Game.Coordinate;
import java.util.HashSet;
import java.util.Set;

public class Rook extends PieceType
{
    private String type;
    private char Player;
    private String png;
    //player is either W or B
    public Rook(char player)
    {
        super(5);
        Player = player;
        if(player=='W')
            png= "/ChessPng/whiterook.png";
        else
            png= "/ChessPng/blackrook.png";
        type = "Rook";
    }

    @Override
    public Set<Coordinate> getValidTiles(int r,int c)
    {
        Set<Coordinate>set = new HashSet<>();
        for(int i=1;i<8;i++)
        {
            if ((r + i < 8) && (r + i >= 0))
            {
                PieceType tempType = Board.pieceTypes[r+i][c];
                // remember cant make a tempPlayer bc it might be null so just call in the boolean condition below
                // the first condition should take care of it if it is null
                if (tempType!= null&&Board.pieceTypes[r+i][c].getPlayer()==Player)
                    break;
                else if(tempType!=null&&Board.pieceTypes[r+i][c].getPlayer()!=Player)
                { set.add(new Coordinate(r+i,c));
                    break;
                }
                else
                    set.add(new Coordinate(r + i, c));
            }
        }
        for(int i=1;i<8;i++)
        {
            if ((r - i >= 0) && (r - i < 8))
            {
                PieceType tempType = Board.pieceTypes[r-i][c];
                if (tempType!= null&&Board.pieceTypes[r-i][c].getPlayer()==Player)
                    break;
                else if(tempType!=null&&Board.pieceTypes[r-i][c].getPlayer()!=Player)
                {
                    set.add(new Coordinate(r-i,c));
                    break;
                }
                else
                    set.add(new Coordinate(r - i, c));
            }

        }
        for(int i=1;i<8;i++)
        {
            if ((c + i < 8) && (c + i >= 0))
            {
                PieceType tempType = Board.pieceTypes[r][c+i];
                if (tempType != null&&Board.pieceTypes[r][c+i].getPlayer()==Player)
                    break;
                else if(tempType!=null&&Board.pieceTypes[r][c+i].getPlayer()!=Player)
                {
                    set.add(new Coordinate(r,c+i));
                    break;
                }
                else
                    set.add(new Coordinate(r, c + i));
            }
        }
        for(int i=1;i<8;i++)
        {
            if ((c - i >= 0) && (c - i < 8))
            {
                PieceType tempType = Board.pieceTypes[r][c-i];
                if (tempType != null&&Board.pieceTypes[r][c-i].getPlayer()==Player)
                    break;
                else if(tempType!=null&&Board.pieceTypes[r][c-i].getPlayer()!=Player)
                {
                    set.add(new Coordinate(r,c-i));
                    break;
                }
                else
                    set.add(new Coordinate(r, c - i));
            }
        }
        return set;
    }

    @Override
    public String getType()
    {
        return type;
    }
    public char getPlayer()
    {
        return Player;
    }
    public String getPng()
    {
        return png;
    }
}
