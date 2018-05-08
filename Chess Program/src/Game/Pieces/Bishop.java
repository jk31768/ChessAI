package Game.Pieces;

import Game.Board;

import java.util.HashSet;
import java.util.Set;

public class Bishop extends PieceType
{
    private String type;
    private char Player;
    private String png;
    //player is either W or B
    public Bishop(char player)
    {
        super(3);
        Player = player;
        if(player=='W')
            png= "/ChessPng/whitebishop.png";
        else
            png= "/ChessPng/blackbishop.png";
        type = "Bishop";
    }

    @Override
    public Set<Game.Coordinate> getValidTiles(int r, int c)
    {
        Set<Game.Coordinate>set = new HashSet<>();
        for(int i=1;i<8;i++)
        {
            if(r+i<8&&c+i<8)
            {
                PieceType tempType = Board.pieceTypes[r+i][c+i];
                if (tempType!= null && Board.pieceTypes[r+i][c+i].getPlayer() == Player)
                    break;
                else if (tempType != null && Board.pieceTypes[r+i][c+i].getPlayer() != Player) {
                    set.add(new Game.Coordinate(r+i, c+i));
                    break;
                } else
                    set.add(new Game.Coordinate(r+i, c+i));
            }
        }
        for(int i=1;i<8;i++)
        {
            if(r+i<8&&c-i>=0)
            {
                PieceType tempType = Board.pieceTypes[r+i][c-i];
                if (tempType != null && Board.pieceTypes[r+i][c-i].getPlayer() == Player)
                    break;
                else if(tempType != null && Board.pieceTypes[r+i][c-i].getPlayer()!= Player)
                {
                    set.add(new Game.Coordinate(r+i, c-i));
                    break;
                }
                else
                    set.add(new Game.Coordinate(r+i,c-i));
            }

        }
        for(int i=1;i<8;i++)
        {
            if(r-i>=0&&c-i>=0)
            {
                PieceType tempType = Board.pieceTypes[r-i][c-i];
                if (tempType!= null && Board.pieceTypes[r-i][c-i].getPlayer() == Player)
                    break;
                else if(tempType != null && Board.pieceTypes[r-i][c-i].getPlayer()!= Player)
                {
                    set.add(new Game.Coordinate(r-i, c-i));
                    break;
                }
                else
                    set.add(new Game.Coordinate(r-i,c-i));

            }
        }
        for(int i=1;i<8;i++)
        {
            if(r-i>=0&&c+i<8)
            {
                PieceType tempType = Board.pieceTypes[r-i][c+i];
                if (tempType != null && Board.pieceTypes[r-i][c+i].getPlayer()== Player)
                    break;
                else if(tempType != null && Board.pieceTypes[r-i][c+i].getPlayer()!= Player)
                {
                    set.add(new Game.Coordinate(r-i, c+i));
                    break;
                }
                else
                    set.add(new Game.Coordinate(r-i,c+i));
            }
        }
        return set;
    }
    @Override
    public String getType()
    {
        return type;
    }
    @Override
    public char getPlayer()
    {
        return Player;
    }
    public String getPng()
    {
        return png;
    }
}
