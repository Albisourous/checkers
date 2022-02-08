import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Created by 14479 on 4/28/17.
 */
public class GameTile extends JButton
{

    private int row;
    private int col;
    private ImageIcon pic;

    public GameTile(ImageIcon pic, int row, int col)
    {
        super(pic);
        this.row = row;
        this.col = col;
        this.setOpaque(true);
        
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public String toString()
    {
        return "Row: " + row + "\tCol: "  + col;
    }
}
