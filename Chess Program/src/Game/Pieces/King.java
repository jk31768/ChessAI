package Game.Pieces;

import Game.Coordinate;

import java.util.HashSet;
import java.util.Set;

public class King extends PieceType
{
    private String type;
    private char Player;
    private String png;
    /*player is either W or B*/
    public King(char player)
    {
        super(99);
        Player = player;
        if(player=='W')
            png = "/ChessPng/whiteking.png";
        else
            png = "/ChessPng/blackking.png";
        type = "King";
    }
    @Override
    public Set<Coordinate> getValidTiles(int r,int c)
    {
        Set<Coordinate>set = new HashSet<>();
        if(r+1<8)
            set.add(new Coordinate(r+1,c));
        if(r+1<8&&c+1<8)
            set.add(new Coordinate(r+1,c+1));
        if(r+1<8&&c-1>=0)
            set.add(new Coordinate(r+1,c-1));
        if(c-1>=0)
            set.add(new Coordinate(r, c - 1));
        if(r-1>=0)
            set.add(new Coordinate(r-1,c));
        if(r-1>=0&&c-1>=0)
            set.add(new Coordinate(r-1,c-1));
        if(r-1>=0&&c+1<8)
            set.add(new Coordinate(r-1,c+1));
        if(c+1<8)
            set.add(new Coordinate(r,c+1));
        return  set;
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
