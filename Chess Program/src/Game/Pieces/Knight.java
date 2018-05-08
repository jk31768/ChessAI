package Game.Pieces;
import Game.Coordinate;
import java.util.HashSet;
import java.util.Set;

public class Knight extends PieceType
{
    private String type;
    private char Player;
    private String png;
    //player is either W or B
    public Knight(char player)
    {
        super(3);
        Player = player;
        if(player=='W')
            png= "/ChessPng/whiteknight.png";
        else
            png= "/ChessPng/blackknight.png";
        type = "Knight";
    }

    @Override
    public Set<Coordinate> getValidTiles(int r,int c)
    {
        Set<Coordinate>set = new HashSet<>();
        if((r+2<8)&&(c+1<8))
            set.add(new Coordinate(r+2,c+1));
        if((r+2<8)&&(c-1>=0))
            set.add(new Coordinate(r+2,c-1));
        if((r+1<8)&&(c+2<8))
            set.add(new Coordinate(r+1,c+2));
        if((c-2>=0)&&(r+1<8))
            set.add(new Coordinate(r+1,c-2));
        if((r-1>=0)&&(c-2>=0))
            set.add(new Coordinate(r-1,c-2));
        if((r-1>=0)&&(c+2<8))
            set.add(new Coordinate(r-1,c+2));
        if((r-2>=0)&&(c-1>=0))
            set.add(new Coordinate(r-2,c-1));
        if((r-2>=0)&&(c+1<8))
            set.add(new Coordinate(r-2,c+1));

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
