package Game;

public class Coordinate
{
    int row;
    int col;
    public Coordinate(int r, int c)
    {
        row = r;
        col = c;
    }
    public int getRow()
    {
        return row;
    }
    public int getCol()
    {
        return col;
    }
    public void setRow(int r)
    {
        row=r;
    }
    public void setCol(int c)
    {
        col=c;
    }
}
