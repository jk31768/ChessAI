package Game;/*
* Juna Kim
* Chess Program V.2
* 3/27
*
* */
import Game.Pieces.*;
import Game.Pieces.Pawn;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class Board extends JPanel
{
    private JPanel board;
    private JPanel menu;
    public static JButton[][] boardButtons;
    public static PieceType[][] pieceTypes;
    private JLabel label;
    private ArrayList<Coordinate>storeLocations = new ArrayList<Coordinate>();
    private char playerTurn;

    public Board()
    {
        setLayout(new BorderLayout());
        label = new JLabel("Chess Program");
        setBoardButtons();//sets the center of the Game.Board with initialized buttons and color
        setMenu(); //adds menu buttons to the bottom of the screen
        setPngs(); //adds the images to the board
        setActionListener(); //adds the ActionListener Controller to each tile of the board
        setPieceTypes(); //adds the piece classes to the pieceTypes 2d array
        playerTurn= 'W';
    }
    /*
    * sets the 2d array pieceTypes. This will be used to determine what piece is on which tile on the board.
    * */
    public void setPieceTypes()
    {
        pieceTypes = new PieceType[8][8];
        /*Black Game.Pieces*/
        pieceTypes[0][0] = new Rook('B');
        pieceTypes[0][1] = new Knight('B');
        pieceTypes[0][2] = new Bishop('B');
        pieceTypes[0][3] = new Queen('B');
        pieceTypes[0][4] = new King('B');
        pieceTypes[0][5] = new Bishop('B') ;
        pieceTypes[0][6] = new Knight('B');
        pieceTypes[0][7] = new Rook('B');
        /*White Game.Pieces*/
        pieceTypes[7][0] = new Rook('W');
        pieceTypes[7][1] = new Knight('W');
        pieceTypes[7][2] = new Bishop('W');
        pieceTypes[7][3] = new Queen('W');
        pieceTypes[7][4] = new King('W');
        pieceTypes[7][5] = new Bishop('W') ;
        pieceTypes[7][6] = new Knight('W');
        pieceTypes[7][7] = new Rook('W');
        /*
        * Pawns
        * */
        for(int i=0;i<8;i++) {
            pieceTypes[1][i] = new Pawn('B');
            pieceTypes[6][i] = new Pawn('W');
        }
    }
    /*
    * adds the actionListener Controller to each button
    * */
    public void setActionListener()
    {
        for(int r=0;r<8;r++)
        {
            for(int c=0;c<8;c++)
            {
                boardButtons[r][c].addActionListener(new Controller(new Coordinate(r,c)));
            }
        }
    }
    /*
     *Sets the images to the chess board for each respective piece
     * try-catch block is used for any exceptions.
     * */
    public void setPngs()
    {
        try {
            //black pieces
            Image img = ImageIO.read(getClass().getResource("/ChessPng/blackrook.png"));
            boardButtons[0][0].setIcon(new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("/ChessPng/blackknight.png"));
            boardButtons[0][1].setIcon(new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("/ChessPng/blackbishop.png"));
            boardButtons[0][2].setIcon(new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("/ChessPng/blackqueen.png"));
            boardButtons[0][3].setIcon(new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("/ChessPng/blackking.png"));
            boardButtons[0][4].setIcon(new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("/ChessPng/blackbishop.png"));
            boardButtons[0][5].setIcon(new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("/ChessPng/blackknight.png"));
            boardButtons[0][6].setIcon(new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("/ChessPng/blackrook.png"));
            boardButtons[0][7].setIcon(new ImageIcon(img));

            //black pawns
            img = ImageIO.read(getClass().getResource("/ChessPng/blackpawn.png"));
            for(int i=0;i<8;i++)
            {
                boardButtons[1][i].setIcon(new ImageIcon(img));
            }
            /***************************************************************************************/

            //white pieces
            img = ImageIO.read(getClass().getResource("/ChessPng/whiterook.png"));
            boardButtons[7][0].setIcon(new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("/ChessPng/whiteknight.png"));
            boardButtons[7][1].setIcon(new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("/ChessPng/whitebishop.png"));
            boardButtons[7][2].setIcon(new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("/ChessPng/whitequeen.png"));
            boardButtons[7][3].setIcon(new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("/ChessPng/whiteking.png"));
            boardButtons[7][4].setIcon(new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("/ChessPng/whitebishop.png"));
            boardButtons[7][5].setIcon(new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("/ChessPng/whiteknight.png"));
            boardButtons[7][6].setIcon(new ImageIcon(img));
            img = ImageIO.read(getClass().getResource("/ChessPng/whiterook.png"));
            boardButtons[7][7].setIcon(new ImageIcon(img));

            //white pawns
            img = ImageIO.read(getClass().getResource("/ChessPng/whitepawn.png"));
            for(int i=0;i<8;i++)
            {
                boardButtons[6][i].setIcon(new ImageIcon(img));
            }
        } //try
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
    /*
    * sets up a menu of customizable buttons to south of borderLayout
    * */
    public void setMenu()
    {
        menu = new JPanel();
        menu.setLayout(new FlowLayout());
        JButton reset = new JButton("Reset");
        JButton null1 = new JButton("null");
        JButton null2 = new JButton("null");
        menu.add(reset);
        menu.add(null1);
        menu.add(null2);
        add(menu,BorderLayout.SOUTH);
    }
    /*
     * Adds boardButtons to JPanel
     * Initializes the individual buttons in boardButtons[][]
     * Makes the buttons black or white
     */
    public void setBoardButtons()
    {
        boardButtons= new JButton[8][8];
        board = new JPanel();
        board.setLayout(new GridLayout(8,8));
        for(int r=0;r<8;r++)
            for(int c=0;c<8;c++)
            {
                boardButtons[r][c] = new JButton();
                if((r%2==0&&c%2!=0) ||  (r%2!=0&&c%2==0))//if the location on the board is supposed to be black
                    boardButtons[r][c].setBackground(Color.GRAY);// set the background to gray bc black is too dark for black pieces
                else
                    boardButtons[r][c].setBackground(Color.WHITE);
                board.add(boardButtons[r][c]);
            }
        add(board,BorderLayout.CENTER);
    }

    private class Controller implements ActionListener
    {
        private Coordinate coords;
        private Coordinate blackKingLocation;
        private Coordinate whiteKingLocation;

        public Controller(Coordinate c)
        {
            coords =c;
            blackKingLocation = new Coordinate(0,4);
            whiteKingLocation = new Coordinate(7,4);
        }
        public void actionPerformed(ActionEvent e)
        {
            int row = coords.getRow();
            int col = coords.getCol();

            /*-------------------------------------------------------------------------------------------------------------------------------------*/

            if(storeLocations.isEmpty()&&pieceTypes[row][col]==null)//basically if the button pressed is not intended for play
                return;
            else if(storeLocations.isEmpty()&&pieceTypes[row][col].getPlayer()!=playerTurn)// prevents a player from moving an opponent's piece
                return;
            else if(storeLocations.isEmpty()&&kingWillBeExposed(row,col))//if king will be exposed, return as nonplayable
                return;
            else if(storeLocations.isEmpty()&&pieceTypes[row][col]!=null)//if your piece is selected, show possible paths
            {
                storeLocations.add(coords);
                showPossiblePaths(coords);
            }
            else if((!storeLocations.isEmpty())&&
                    (!boardButtons[row][col].getBackground().equals(new Color(171,241,236))&&
                    !boardButtons[row][col].getBackground().equals(Color.red)))//if random non playable tile after pressing piece
            {
                storeLocations.clear();
                restoreColors();
                if(pieceTypes[row][col]!=null&&pieceTypes[row][col].getPlayer()==playerTurn) //this makes the piece instantly showPossiblePaths instead of two clicks to clear storeLocations
                {
                    storeLocations.add(coords);
                    showPossiblePaths(coords);
                }
            }

            else //if a piece needs to be moved to a new position and is legal
            {
                //swap is the where the piece is and needs to be moved to row and col
                int swapRow = storeLocations.get(0).getRow();
                int swapCol = storeLocations.get(0).getCol();

                //swaps the values in the pieceType 2D array
                PieceType temp = pieceTypes[swapRow][swapCol];
                pieceTypes[row][col] = temp;
                //swaps the image in buttonsBoard 2d array
                try
                {
                    // since the pieceType is changed in above code, can just call on piece for new image
                    Image img = ImageIO.read(getClass().getResource(pieceTypes[row][col].getPng()));
                    boardButtons[row][col].setIcon(new ImageIcon(img));
                    boardButtons[swapRow][swapCol].setIcon(null);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                    System.out.println("IT ENTERED THE CATCH BLOCK!!!!! LOOK IN ACTIONPERFORMED FINAL ELSE STATEMENT");
                    // friendly error to help me pinpoint if an error occurs :)
                }
                pieceTypes[swapRow][swapCol]=null; //this is here because the imageIo needed to get the png before it erased
                if(pieceTypes[row][col].getType().equals("Pawn"))
                {
                    pieceTypes[row][col].setHasMovedToTrue();//updates the boolean hasMoved if it moved
                    if(pawnIsAtEnd(row,pieceTypes[row][col].getPlayer())) // if the piece that was moved was a pawn and is at end, upgrade pawn
                        upgradePawn(pieceTypes[row][col].getPlayer(),row,col);
                }
                else if(pieceTypes[row][col].getType().equals("King")) // update the kings location if king is moved
                {
                    if(playerTurn=='W')
                    {
                        whiteKingLocation.setRow(row);
                        whiteKingLocation.setCol(col);
                    }
                    else
                    {
                        blackKingLocation.setRow(row);
                        blackKingLocation.setCol(col);
                    }
                }
                restoreColors();
                storeLocations.clear();//removes every element in the arraylist allowing for reuse

                if(playerTurn=='W')   // allows for the next player to make a move and disables the player that just made a move
                    playerTurn='B';
                else
                    playerTurn='W';

            }
        }
        private void restoreColors()// changes every tile to its default colors again
        {
            for(int r=0;r<8;r++)
                for(int c=0;c<8;c++)
                {
                    if((r%2==0&&c%2!=0) ||  (r%2!=0&&c%2==0))//if the location on the board is supposed to be black
                        boardButtons[r][c].setBackground(Color.GRAY);// set the background to gray bc black is too dark for black pieces
                    else
                        boardButtons[r][c].setBackground(Color.WHITE);
                }
        }
        private void showPossiblePaths(Coordinate c)//changes the color of the possible squares that can be moved to
        {
            int row = coords.getRow();
            int col = coords.getCol();
            char player = pieceTypes[row][col].getPlayer();
            PieceType tempPiece = pieceTypes[row][col];
            Set<Game.Coordinate> set = tempPiece.getValidTiles(row,col);
            Color color = new Color(171,241,236);
            for(Coordinate temp:set)
            {
                int tempRow = temp.getRow();
                int tempCol = temp.getCol();
                if(pieceTypes[row][col].getType().equals("Pawn"))
                {
                    //this is for when a Pawn captures a piece. This is needed because the Pawn takes pieces diagonally not in its path
                    if(pieceTypes[row][col].getPlayer()=='W')
                    {
                        if(row-1>=0&&col+1<8)
                        {
                            if (pieceTypes[row - 1][col + 1] != null && pieceTypes[row - 1][col + 1].getPlayer() == 'B')
                            boardButtons[row - 1][col + 1].setBackground(Color.red);
                        }
                        if(row-1>=0&&col-1>=0)
                        {
                            if (pieceTypes[row - 1][col - 1] != null && pieceTypes[row - 1][col - 1].getPlayer() == 'B')
                                boardButtons[row - 1][col - 1].setBackground(Color.red);
                        }
                    }
                    else
                    {
                        if(row+1<8&&col+1<8)
                            if(pieceTypes[row+1][col+1]!=null&&pieceTypes[row+1][col+1].getPlayer()=='W')
                                boardButtons[row+1][col+1].setBackground(Color.red);
                        if(row+1<8&&col-1>=0)
                            if(pieceTypes[row+1][col-1]!=null&&pieceTypes[row+1][col-1].getPlayer()=='W')
                                boardButtons[row+1][col-1].setBackground(Color.red);
                    }
                }
                if(pieceTypes[tempRow][tempCol]==null)
                    boardButtons[tempRow][tempCol].setBackground(color); // if available spot, change color to blue
                else if(pieceTypes[tempRow][tempCol].getPlayer()==player);
                else if(pieceTypes[row][col].getType().equals("Pawn"));//will prevent pawn from capturing pieces directly in front
                else if (pieceTypes[tempRow][tempCol].getPlayer()!=player)
                    boardButtons[tempRow][tempCol].setBackground(Color.red);
            }
        }
        private boolean kingWillBeExposed(int Row,int Col)//returns true if king will be exposed, false otherwise
        {
            PieceType temp=pieceTypes[Row][Col];
            pieceTypes[Row][Col]=null;
            if(playerTurn=='W')
            {
                int kingRow = whiteKingLocation.getRow();
                int kingCol = whiteKingLocation.getCol();
                System.out.println(kingRow+" "+kingCol);
                pieceTypes[kingRow][kingCol]=new Queen(playerTurn);// makes the king a queen to use its getValidTiles to check if it will be exposed
                Set<Coordinate>set=pieceTypes[kingRow][kingCol].getValidTiles(kingRow,kingCol);
                for(Coordinate coord:set)
                {
                    PieceType tempCoord= pieceTypes[coord.row][coord.col];
                    if(tempCoord==null);
                    else if(tempCoord.getPlayer()=='B'&&
                            (tempCoord.getType().equals("Queen")||
                            tempCoord.getType().equals("Rook")||
                            tempCoord.getType().equals("Bishop"))) // these pieces are the only ones that apply to this method bc they can check from a distance
                    {
                        pieceTypes[kingRow][kingCol] = new King(playerTurn);
                        pieceTypes[Row][Col]=temp;
                        return true;
                    }
                }
                pieceTypes[kingRow][kingCol]=new King(playerTurn);
            }
            else
            {
                int kingRow = blackKingLocation.getRow();
                int kingCol = blackKingLocation.getCol();
                pieceTypes[kingRow][kingCol]=new Queen(playerTurn);// makes the king a queen temporarily to use its getValidTiles to check if it will be exposed
                Set<Coordinate>set=pieceTypes[kingRow][kingCol].getValidTiles(kingRow,kingCol);
                for(Coordinate coord:set)
                {
                    PieceType tempCoord = pieceTypes[coord.row][coord.col];
                    if(tempCoord==null);
                    else if(tempCoord.getPlayer()=='W'&&
                            (tempCoord.getType().equals("Queen")||
                                    tempCoord.getType().equals("Rook")||
                                    tempCoord.getType().equals("Bishop")))
                    {
                        pieceTypes[kingRow][kingCol] = new King(playerTurn);
                        pieceTypes[Row][Col]=temp;
                        return true;
                    }
                }
                pieceTypes[kingRow][kingCol]=new King(playerTurn); // make sure to change the king back to a king
            }
            pieceTypes[Row][Col]=temp; //restore piece
            return  false;
        }
        private boolean kingIsChecked()//returns true is opponent's king is checked, false otherwise
        {
            if(playerTurn=='W')
            {
            }
            return false;
        }
        private boolean pawnIsAtEnd(int r,char player)//if pawn reaches the end of the board and needs to upgrade to desired piece
        {
            if(player=='W'&&r==0)
                return true;
            else if(player=='B'&&r==7)
                return true;
            else
                return false;

        }
        private void upgradePawn(char player,int r,int c) //upgrades the pawn to a new piece of user's choice
        {
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            panel.add(new JLabel("Choose a Piece"));
            Image img;
            JButton pawn,rook,knight,bishop,queen;
            pawn=null;
            rook=null;
            knight=null;
            bishop=null;
            queen=null;
            try {   // makes the images appear on the Jpanel panel that was created for gui interface
                if (player == 'W')
                {
                    pawn = new JButton();
                    img = ImageIO.read(getClass().getResource("/ChessPng/whitepawn.png"));
                    pawn.setIcon(new ImageIcon(img));

                    knight = new JButton();
                    img = ImageIO.read(getClass().getResource("/ChessPng/whiteknight.png"));
                    knight.setIcon(new ImageIcon(img));

                    bishop = new JButton();
                    img = ImageIO.read(getClass().getResource("/ChessPng/whitebishop.png"));
                    bishop.setIcon(new ImageIcon(img));

                    rook = new JButton();
                    img = ImageIO.read(getClass().getResource("/ChessPng/whiterook.png"));
                    rook.setIcon(new ImageIcon(img));

                    queen = new JButton();
                    img = ImageIO.read(getClass().getResource("/ChessPng/whitequeen.png"));
                    queen.setIcon(new ImageIcon(img));
                }
                else
                {
                    pawn = new JButton();
                    img = ImageIO.read(getClass().getResource("/ChessPng/blackpawn.png"));
                    pawn.setIcon(new ImageIcon(img));

                    knight = new JButton();
                    img = ImageIO.read(getClass().getResource("/ChessPng/blackknight.png"));
                    knight.setIcon(new ImageIcon(img));

                    bishop = new JButton();
                    img = ImageIO.read(getClass().getResource("/ChessPng/blackbishop.png"));
                    bishop.setIcon(new ImageIcon(img));

                    rook = new JButton();
                    img = ImageIO.read(getClass().getResource("/ChessPng/blackrook.png"));
                    rook.setIcon(new ImageIcon(img));

                    queen = new JButton();
                    img = ImageIO.read(getClass().getResource("/ChessPng/blackqueen.png"));
                    queen.setIcon(new ImageIcon(img));
                }
            }
            catch(Exception e){}

            pawn.addActionListener(new Upgrade(0,r,c,player));
            panel.add(pawn);
            knight.addActionListener(new Upgrade(1,r,c,player));
            panel.add(knight);
            bishop.addActionListener(new Upgrade(2,r,c,player));
            panel.add(bishop);
            rook.addActionListener(new Upgrade(3,r,c,player));
            panel.add(rook);
            queen.addActionListener(new Upgrade(4,r,c,player));
            panel.add(queen);

            JFrame popup = new JFrame();
            popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            popup.setSize(1000, 250);
            popup.setLocation(1000, 500);
            popup.add(panel);
            popup.setVisible(true);

        }
        private class Upgrade implements ActionListener
        {
            private int index;
            private int row;
            private int col;
            private char player;
            public Upgrade(int i,int r,int c, char p)
            {
                index=i;
                row=r;
                col=c;
                player=p;
            }
            public void actionPerformed(ActionEvent e)
            {
                Image imo;
                try
                {
                    switch (index) // puts new piece in place according to buttons
                    {
                        case 0:
                        {
                            pieceTypes[row][col] = new Pawn(player);
                            if(player=='W')
                                imo=ImageIO.read(getClass().getResource("/ChessPng/whitepawn.png"));
                            else
                                imo=ImageIO.read(getClass().getResource("/ChessPng/blackpawn.png"));
                            boardButtons[row][col].setIcon(new ImageIcon(imo));
                            break;
                        }
                        case 1:
                        {
                            pieceTypes[row][col] = new Knight(player);
                            if(player=='W')
                                imo=ImageIO.read(getClass().getResource("/ChessPng/whiteknight.png"));
                            else
                                imo=ImageIO.read(getClass().getResource("/ChessPng/blackknight.png"));
                            boardButtons[row][col].setIcon(new ImageIcon(imo));
                            break;
                        }
                        case 2:
                        {
                            pieceTypes[row][col] = new Bishop(player);
                            if(player=='W')
                                imo=ImageIO.read(getClass().getResource("/ChessPng/whitebishop.png"));
                            else
                                imo=ImageIO.read(getClass().getResource("/ChessPng/blackbishop.png"));
                            boardButtons[row][col].setIcon(new ImageIcon(imo));
                            break;
                        }
                        case 3:
                        {
                            pieceTypes[row][col] = new Rook(player);
                            if(player=='W')
                                imo=ImageIO.read(getClass().getResource("/ChessPng/whiterook.png"));
                            else
                                imo=ImageIO.read(getClass().getResource("/ChessPng/blackrook.png"));
                            boardButtons[row][col].setIcon(new ImageIcon(imo));
                            break;
                        }
                        case 4:
                        {
                            pieceTypes[row][col] = new Queen(player);
                            if(player=='W')
                                imo=ImageIO.read(getClass().getResource("/ChessPng/whitequeen.png"));
                            else
                                imo=ImageIO.read(getClass().getResource("/ChessPng/blackqueen.png"));
                            boardButtons[row][col].setIcon(new ImageIcon(imo));
                            break;
                        }
                        default:;

                    }

                }
                catch(Exception e1){System.out.println("Class Upgrade catch error");};
            }
        }
    }


}
