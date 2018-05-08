package Game.Pieces;

import java.util.HashSet;
import java.util.Set;
import Game.Coordinate;
import Game.Board;

public class Queen extends PieceType
{
    private String type;
    private char Player;
    private String png;
    //player is either W or B
    public Queen(char player)
    {
        super(9);
        Player = player;
        if(player=='W')
            png= "/ChessPng/whitequeen.png";
        else
            png= "/ChessPng/blackqueen.png";
        type = "Queen";
    }

    @Override
    public Set<Coordinate> getValidTiles(int r,int c)
    {
        Set<Coordinate>set = new HashSet<>();
        /*---------------------------------------------------------------------------------*/
            // Rook like behavior
            // try to update this long block of code in future versions!!!!
        for(int i=1;i<8;i++)
        {
            if ((r + i < 8) && (r + i >= 0))
            {
                PieceType tempType = Board.pieceTypes[r+i][c];
                if (tempType!= null&&Board.pieceTypes[r+i][c].getPlayer()==Player)
                    break;
                else if(tempType!=null&&Board.pieceTypes[r+i][c].getPlayer()!=Player)
                {
                    set.add(new Coordinate(r+i,c));
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
        /*----------------------------------------------------------------------------------------*/
        //Bishop like behavior

        for(int i=1;i<8;i++)
        {
            if(r+i<8&&c+i<8)
            {
                PieceType tempType = Board.pieceTypes[r+i][c+i];
                if (tempType!= null && Board.pieceTypes[r+i][c+i].getPlayer() == Player)
                    break;
                else if (tempType != null && Board.pieceTypes[r+i][c+i].getPlayer() != Player) {
                    set.add(new Coordinate(r+i, c+i));
                    break;
                } else
                    set.add(new Coordinate(r+i, c+i));
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
                    set.add(new Coordinate(r+i, c-i));
                    break;
                }
                else
                    set.add(new Coordinate(r+i,c-i));
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
                    set.add(new Coordinate(r-i, c-i));
                    break;
                }
                else
                    set.add(new Coordinate(r-i,c-i));

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
                    set.add(new Coordinate(r-i, c+i));
                    break;
                }
                else
                    set.add(new Coordinate(r-i,c+i));
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
