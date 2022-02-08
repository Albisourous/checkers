import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Checkers implements ActionListener
{
	JFrame frame = new JFrame("Checkers");
    JPanel panel = new JPanel();
    JPanel text = new JPanel();
    GameTile[][] tiles;
    String turn = "r";
    String lastTile;
    int lRow;
	int lCol;
	String winner;
	boolean musicOn;
	boolean seOn;
	boolean clasicMode;
	public Checkers() 
	{
		int result = JOptionPane.showConfirmDialog(null, 
				   "Do you want music on?",null, JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) 
		{
		    musicOn = true;
		} else {
			musicOn = false;
		}
		
		result = JOptionPane.showConfirmDialog(null, 
				   "Do you want sound effects on?",null, JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) 
		{
		    seOn = true;
		} else {
			seOn = false;
		}
		
	    String[] options = new String[] {"Clasic Mode", "Free Mode",};
	    int response = JOptionPane.showOptionDialog(null, "What Mode do you want",  null,
	        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	        null, options, options[0]);
	    if(response == 0)
	    {
	    	clasicMode = true;
	    }
	    if(response==1)
	    {
	    	clasicMode = false;
	    }
	    

	    // Where response == 0 for Yes, 1 for No, 2 for Maybe and -1 or 3 for Escape/Cancel.
		if(musicOn)
		{
			playSound();
		}
		 panel.setLayout(new GridLayout(8,8));
		 int row;
		 int column;
		 tiles = new GameTile[8][8];
		 	for (row = 0; row < 8; row++) 
			{	
				for (column = 0; column < 8; column++)
			   	{
					
					if ((row % 2) == (column % 2)) 
					{	 
						GameTile tile = new GameTile(new ImageIcon("blacksquare.png"), row, column);	
					    tiles[row][column] = tile;
			            tile.addActionListener(this);
			            panel.add(tile);
					}
					else
					{
						if (row >= 0 && row < 3) 
						{	
							GameTile tile = new GameTile(new ImageIcon("bluecheck.png"), row, column);
							tiles[row][column] = tile;
							tile.addActionListener(this);
					        panel.add(tile);     
						}
						else if (row >= 5 && row < 8) 
						{	
							GameTile tile = new GameTile(new ImageIcon("redcheck.png"), row, column);
							tiles[row][column] = tile;
							tile.addActionListener(this);
					        panel.add(tile);
						}
						else
						{
							GameTile tile = new GameTile(new ImageIcon("whitesquare.png"), row, column);
							tiles[row][column] = tile;
				            tile.addActionListener(this);
				            panel.add(tile);
						}
				   	}
				 }	
			 }
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setPreferredSize(new Dimension(1000, 1000));
			frame.setResizable(false);
			frame.setLayout(new BorderLayout());
			frame.setLayout(new BorderLayout());
			frame.setContentPane(text);
			frame.setContentPane(panel);
			frame.pack();
			frame.setVisible(true);
			
	}
	public void playSound() //plays music 
	{
		int rick = (int) (Math.random() * 420 + 1);
		int randSong = (int) (Math.random() * 6 + 1);
	    try {
	        AudioInputStream song1 = AudioSystem.getAudioInputStream(new File("Porter Robinson  Madeon - Shelter (Official Audio).wav").getAbsoluteFile());
	        AudioInputStream song2 = AudioSystem.getAudioInputStream(new File("Porter Robinson - Flicker (Official Video).wav").getAbsoluteFile());
	        AudioInputStream song3 = AudioSystem.getAudioInputStream(new File("Porter Robinson - Sad Machine (Lyric Video).wav").getAbsoluteFile());
	        AudioInputStream song4 = AudioSystem.getAudioInputStream(new File("ZEN.wav").getAbsoluteFile());
	        AudioInputStream song5 = AudioSystem.getAudioInputStream(new File("NANO.wav").getAbsoluteFile());
	        AudioInputStream song6 = AudioSystem.getAudioInputStream(new File("BUMP.wav").getAbsoluteFile());
	        AudioInputStream notMEME = AudioSystem.getAudioInputStream(new File("Rick Astley - Never Gonna Give You Up.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        if(rick == 69)
	        {
	        	clip.open(notMEME);
	        }
	        else if(randSong == 1)
	        {
	        	 clip.open(song1);
	        }
	        else if(randSong == 2)
	        {
	        	 clip.open(song2);
	        }
	        else if(randSong == 3)
	        {
	        	 clip.open(song3);
	        }
	        else if(randSong == 4)
	        {
	        	 clip.open(song4);
	        }
	        else if(randSong == 5)
	        {
	        	 clip.open(song5);
	        }
	        else if(randSong == 6)
	        {
	        	 clip.open(song6);
	        }
	        clip.start();
	        clip.loop(rick);
	    } 
	    catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	public void playMove() //plays music when a piece moves 
	{
		if(seOn)
		{
			try 
			{
				Clip clip = AudioSystem.getClip();
				AudioInputStream move = AudioSystem.getAudioInputStream(new File("Sonic.wav").getAbsoluteFile());
				clip.open(move);
				clip.start();
			}
			catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
		}
	}
	public void playEat() //plays sound when eaten 
	{
		if(seOn)
		{
			try 
			{
				Clip clip = AudioSystem.getClip();
				AudioInputStream move = AudioSystem.getAudioInputStream(new File("Mario.wav").getAbsoluteFile());
				clip.open(move);
				clip.start();
			}
			catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
		}
	}
	public void changeTurn()//changes the turn
	{
		if(turn == "r")
		{
			turn = "b";
			System.out.println("It is Blues Turn");
		}
		else if(turn == "b")
		{
			turn = "r";
			System.err.println("It is Reds Turn");
		}
	}
	public void clearYellow()//clears our any yellow
	{
		for(GameTile[] bob: tiles)
		{
			for(GameTile tile: bob)
			{
				if(tile.getIcon().toString().equals("yellowsquare.jpeg"))
				{
					tile.setIcon(new ImageIcon("whitesquare.png"));
				}
			}
		}
	}
	public void clearAll()//clears our any arrows or yellow
	{
		for(GameTile[] bob: tiles)
		{
			for(GameTile tile: bob)
			{
				if(tile.getIcon().toString().equals("yellowsquare.jpeg"))
				{
					tile.setIcon(new ImageIcon("whitesquare.png"));
				}
				if(tile.getIcon().toString().equals("SE.jpeg"))
				{
					tile.setIcon(new ImageIcon("whitesquare.png"));
				}
				if(tile.getIcon().toString().equals("NW.jpeg"))
				{
					tile.setIcon(new ImageIcon("whitesquare.png"));
				}
				if(tile.getIcon().toString().equals("NE.jpeg"))
				{
					tile.setIcon(new ImageIcon("whitesquare.png"));
				}
				if(tile.getIcon().toString().equals("SW.jpeg"))
				{
					tile.setIcon(new ImageIcon("whitesquare.png"));
				}
			}
		}
	}
	public void checkWin()//checks if any side has won
	{
		int redCount = 0;
		int blueCount = 0;
		for(GameTile[] bob: tiles)
		{
			for(GameTile tile: bob)
			{
				if(tile.getIcon().toString().equals("redcheck.png") || tile.getIcon().toString().equals("redcheckKing.png"))
				{
					redCount++;
				}
				if(tile.getIcon().toString().equals("bluecheck.png") || tile.getIcon().toString().equals("bluecheckKing.png"))
				{
					blueCount++;
				}
			}
		}
		if(redCount == 0)
		{
			winner = "Blue wins with " + blueCount + " pieces left";
			JOptionPane.showMessageDialog(null, winner);
		}
		else if(blueCount == 0)
		{
			winner = "Red wins with " + redCount + " pieces left";
			JOptionPane.showMessageDialog(null, winner);
		}
	}
	public void lastMove(int r, int c, ActionEvent e)// saves the last move to be used later
	{
		GameTile clicked = (GameTile) e.getSource();
		int row = clicked.getRow();
		int col = clicked.getCol();
		if(turn == "r")
		{
			if(tiles[row][col].getIcon().toString().equals("redcheck.png"))
			{
				lRow = r;
				lCol = c;
				lastTile = "redcheck.png";
			}
			if(tiles[row][col].getIcon().toString().equals("redcheckKing.png"))
			{
				lRow = r;
				lCol = c;
				lastTile = "redcheckKing.png";
			}
		}
		else if(turn == "b")
		{
			if(tiles[row][col].getIcon().toString().equals("bluecheck.png"))
			{
				lRow = r;
				lCol = c;
				lastTile = "bluecheck.png";
			}
			if(tiles[row][col].getIcon().toString().equals("bluecheckKing.png"))
			{
				lRow = r;
				lCol = c;
				lastTile = "bluecheckKing.png";
			}
		}
	}
	public boolean legalMove(int r, int c)//checks if move in in bounce
	{
		if(r >= 0 && r < 8 && c >= 0 && c < 8)
		{
			return true;
		}	
		else 
		{
			return false;
		}
	}
	public boolean checkArrow()//run through all of the arrays and check of there are any arrow
	{
		for(GameTile[] bob: tiles)
		{
			for(GameTile tile: bob)
			{
				if(tile.getIcon().toString().equals("SE.jpeg"))
				{
					return true;
				}
				if(tile.getIcon().toString().equals("NW.jpeg"))
				{
					return true;
				}
				if(tile.getIcon().toString().equals("NE.jpeg"))
				{
					return true;
				}
				if(tile.getIcon().toString().equals("SW.jpeg"))
				{
					return true;
				}
			}
		}
		return false;
	}
	public void showForcedMove(ActionEvent e)// goes through the entire code and 
	{
		for(GameTile[] bob: tiles)
		{
			for(GameTile tile: bob)
			{
				int row = tile.getRow();
				int col = tile.getCol();
				if(turn.equals("r"))
				{
					if(legalMove(row-2,col-2) && tiles[row-2][col-2].getIcon().toString().equals("whitesquare.png") && 
							(tiles[row][col].getIcon().toString().equals("redcheckKing.png") || tiles[row][col].getIcon().toString().equals("redcheck.png")) && 
							(tiles[row-1][col-1].getIcon().toString().equals("bluecheckKing.png") || tiles[row-1][col-1].getIcon().toString().equals("bluecheck.png")))
					{
						tiles[row-2][col-2].setIcon(new ImageIcon("NW.jpeg"));
					}
					if(legalMove(row-2,col+2) && tiles[row-2][col+2].getIcon().toString().equals("whitesquare.png") && 
							(tiles[row][col].getIcon().toString().equals("redcheckKing.png") || tiles[row][col].getIcon().toString().equals("redcheck.png")) && 
							(tiles[row-1][col+1].getIcon().toString().equals("bluecheckKing.png") || tiles[row-1][col+1].getIcon().toString().equals("bluecheck.png")))
					{
						tiles[row-2][col+2].setIcon(new ImageIcon("NE.jpeg"));
					}	
					if(legalMove(row+2,col-2) && tiles[row+2][col-2].getIcon().toString().equals("whitesquare.png") &&
							(tiles[row][col].getIcon().toString().equals("redcheckKing.png")) && 
							(tiles[row+1][col-1].getIcon().toString().equals("bluecheckKing.png") || tiles[row+1][col-1].getIcon().toString().equals("bluecheck.png")))
					{
						tiles[row+2][col-2].setIcon(new ImageIcon("SW.jpeg"));
					}
					if(legalMove(row+2,col+2) && tiles[row+2][col+2].getIcon().toString().equals("whitesquare.png") && 
							(tiles[row][col].getIcon().toString().equals("redcheckKing.png")) && 
							(tiles[row+1][col+1].getIcon().toString().equals("bluecheckKing.png") || tiles[row+1][col+1].getIcon().toString().equals("bluecheck.png")))
					{
						tiles[row+2][col+2].setIcon(new ImageIcon("SE.jpeg"));
					}
				}
				if(turn.equals("b"))
				{
					if(legalMove(row+2,col-2) && tiles[row+2][col-2].getIcon().toString().equals("whitesquare.png") && 
							(tiles[row][col].getIcon().toString().equals("bluecheck.png") || tiles[row][col].getIcon().toString().equals("bluecheckKing.png")) &&
							(tiles[row+1][col-1].getIcon().toString().equals("redcheck.png") || tiles[row+1][col-1].getIcon().toString().equals("redcheckKing.png")))
									
					{
						tiles[row+2][col-2].setIcon(new ImageIcon("SW.jpeg"));
					}
					if(legalMove(row+2,col+2) && tiles[row+2][col+2].getIcon().toString().equals("whitesquare.png") && 
							(tiles[row][col].getIcon().toString().equals("bluecheck.png") || tiles[row][col].getIcon().toString().equals("bluecheckKing.png"))&&
							(tiles[row+1][col+1].getIcon().toString().equals("redcheck.png") || tiles[row+1][col+1].getIcon().toString().equals("redcheckKing.png")))
									
					{
						tiles[row+2][col+2].setIcon(new ImageIcon("SE.jpeg"));
					}
					if((legalMove(row-2,col-2) && tiles[row-2][col-2].getIcon().toString().equals("whitesquare.png") && 
							tiles[row][col].getIcon().toString().equals("bluecheckKing.png")) && 
							(tiles[row-1][col-1].getIcon().toString().equals("redcheckKing.png") || tiles[row-1][col-1].getIcon().toString().equals("redcheck.png")))
					{
						tiles[row-2][col-2].setIcon(new ImageIcon("NW.jpeg"));
					}
					if(legalMove(row-2,col+2) && tiles[row-2][col+2].getIcon().toString().equals("whitesquare.png") && 
							tiles[row][col].getIcon().toString().equals("bluecheckKing.png") && 
							(tiles[row-1][col+1].getIcon().toString().equals("redcheckKing.png") || tiles[row-1][col+1].getIcon().toString().equals("redcheck.png")))
					{
						tiles[row-2][col+2].setIcon(new ImageIcon("NE.jpeg"));
					}
				}
			}
		}	
	}
	public void checkMove(ActionEvent e)// check of a spot is empty to move
	{
		GameTile clicked = (GameTile) e.getSource();
		int row = clicked.getRow();
		int col = clicked.getCol();
		lastMove(row,col, e);
		showForcedMove(e);
		if(!checkArrow() || !clasicMode)
		{
			if((turn.equals("r") && clicked.getIcon().toString().equals("redcheck.png")) || (turn.equals("r") && clicked.getIcon().toString().equals("redcheckKing.png")) || (turn.equals("b") && clicked.getIcon().toString().equals("bluecheckKing.png")))
			{
				if(legalMove(row-1,col-1) && tiles[row-1][col-1].getIcon().toString().equals("whitesquare.png"))
				{
					tiles[row-1][col-1].setIcon(new ImageIcon("yellowsquare.jpeg"));
				}
				if(legalMove(row-1,col+1) && tiles[row-1][col+1].getIcon().toString().equals("whitesquare.png") )
				{
					tiles[row-1][col+1].setIcon(new ImageIcon("yellowsquare.jpeg"));
				}	
			}
			if((turn.equals("b") && clicked.getIcon().toString().equals("bluecheck.png")) || (turn.equals("r") && clicked.getIcon().toString().equals("redcheckKing.png")) || (turn.equals("b") && clicked.getIcon().toString().equals("bluecheckKing.png")))
			{
				if(legalMove(row+1,col+1) && tiles[row+1][col+1].getIcon().toString().equals("whitesquare.png"))
				{
					tiles[row+1][col+1].setIcon(new ImageIcon("yellowsquare.jpeg"));
				}
				if(legalMove(row+1,col-1) && tiles[row+1][col-1].getIcon().toString().equals("whitesquare.png"))
				{
					tiles[row+1][col-1].setIcon(new ImageIcon("yellowsquare.jpeg"));
				}	
			}
		}
	}
	public void makeMove(ActionEvent e)//makes the move of it has an arrow or yellow
	{
		GameTile clicked = (GameTile) e.getSource();
		int row = clicked.getRow();
		int col = clicked.getCol();
		if(turn.equals("r"))
		{
			if(clicked.getIcon().toString().equals("yellowsquare.jpeg"))
			{
				if(clicked.getRow() == 0 || lastTile.equals("redcheckKing.png"))
				{
					tiles[row][col].setIcon(new ImageIcon("redcheckKing.png"));
				}
				else
				{
					tiles[row][col].setIcon(new ImageIcon("redcheck.png"));
				}
				tiles[lRow][lCol].setIcon(new ImageIcon("whitesquare.png"));
				clearAll();
				playMove();
				changeTurn();
			}
			else if(clicked.getIcon().toString().equals("NE.jpeg"))
			{
				if(clicked.getRow() == 0 || (lastTile.equals("redcheckKing.png") && tiles[row+2][col-2].getIcon().toString().equals("redcheckKing.png")))
				{
					tiles[row][col].setIcon(new ImageIcon("redcheckKing.png"));
				}
				else
				{
					tiles[row][col].setIcon(new ImageIcon("redcheck.png"));
				}
				tiles[row+2][col-2].setIcon(new ImageIcon("whitesquare.png"));
				tiles[row+1][col-1].setIcon(new ImageIcon("whitesquare.png"));
				clearAll();
				playEat();
				showForcedMove(e);
				if(!checkArrow())
				{
					changeTurn();
				}
			}
			else if(clicked.getIcon().toString().equals("NW.jpeg"))
			{
				if(clicked.getRow() == 0 || (lastTile.equals("redcheckKing.png") && tiles[row+2][col+2].getIcon().toString().equals("redcheckKing.png")))
				{
					tiles[row][col].setIcon(new ImageIcon("redcheckKing.png"));
				}
				else
				{
					tiles[row][col].setIcon(new ImageIcon("redcheck.png"));
				}
				tiles[row+2][col+2].setIcon(new ImageIcon("whitesquare.png"));
				tiles[row+1][col+1].setIcon(new ImageIcon("whitesquare.png"));
				clearAll();
				playEat();
				showForcedMove(e);
				if(!checkArrow())
				{
					changeTurn();
				}
			}
			else if(clicked.getIcon().toString().equals("SE.jpeg"))
			{
				tiles[row-2][col-2].setIcon(new ImageIcon("whitesquare.png"));
				tiles[row-1][col-1].setIcon(new ImageIcon("whitesquare.png"));
				tiles[row][col].setIcon(new ImageIcon("redcheckKing.png"));
				clearAll();
				playEat();
				showForcedMove(e);
				if(!checkArrow())
				{
					changeTurn();
				}
			}
			else if(clicked.getIcon().toString().equals("SW.jpeg"))
			{
				tiles[row-2][col+2].setIcon(new ImageIcon("whitesquare.png"));
				tiles[row-1][col+1].setIcon(new ImageIcon("whitesquare.png"));
				tiles[row][col].setIcon(new ImageIcon("redcheckKing.png"));
				clearAll();
				playEat();
				showForcedMove(e);
				if(!checkArrow())
				{
					changeTurn();
				}
			}
		}
		else if(turn.equals("b"))
		{
			if(clicked.getIcon().toString().equals("yellowsquare.jpeg"))
			{
				if(clicked.getRow() >= 7 || lastTile.equals("bluecheckKing.png"))
				{
					tiles[row][col].setIcon(new ImageIcon("bluecheckKing.png"));
				}
				else
				{
					tiles[row][col].setIcon(new ImageIcon("bluecheck.png"));
				}
				tiles[lRow][lCol].setIcon(new ImageIcon("whitesquare.png"));
				clearAll();
				playMove();
				changeTurn();
			}
			else if(clicked.getIcon().toString().equals("SE.jpeg"))
			{
				if(clicked.getRow() >= 7 || (lastTile.equals("bluecheckKing.png") && tiles[row-2][col-2].getIcon().toString().equals("bluecheckKing.png")))
				{
					tiles[row][col].setIcon(new ImageIcon("bluecheckKing.png"));
				}
				else
				{
					tiles[row][col].setIcon(new ImageIcon("bluecheck.png"));
				}
				tiles[row-2][col-2].setIcon(new ImageIcon("whitesquare.png"));
				tiles[row-1][col-1].setIcon(new ImageIcon("whitesquare.png"));
				clearAll();
				playEat();
				showForcedMove(e);
				if(!checkArrow())
				{
					changeTurn();
				}
			}
			else if(clicked.getIcon().toString().equals("SW.jpeg"))
			{
				if(clicked.getRow() >= 7 || (lastTile.equals("bluecheckKing.png") && tiles[row-2][col+2].getIcon().toString().equals("bluecheckKing.png")))
				{
					tiles[row][col].setIcon(new ImageIcon("bluecheckKing.png"));
				}
				else
				{
					tiles[row][col].setIcon(new ImageIcon("bluecheck.png"));
				}
				tiles[row-2][col+2].setIcon(new ImageIcon("whitesquare.png"));
				tiles[row-1][col+1].setIcon(new ImageIcon("whitesquare.png"));
				clearAll();
				playEat();
				showForcedMove(e);
				if(!checkArrow())
				{
					changeTurn();
				}
			}
			else if(clicked.getIcon().toString().equals("NE.jpeg"))
			{
				tiles[row+2][col-2].setIcon(new ImageIcon("whitesquare.png"));
				tiles[row+1][col-1].setIcon(new ImageIcon("whitesquare.png"));
				tiles[row][col].setIcon(new ImageIcon("bluecheckKing.png"));
				clearAll();
				playEat();
				showForcedMove(e);
				if(!checkArrow())
				{
					changeTurn();
				}
			}
			else if(clicked.getIcon().toString().equals("NW.jpeg"))
			{
				tiles[row+2][col+2].setIcon(new ImageIcon("whitesquare.png"));
				tiles[row+1][col+1].setIcon(new ImageIcon("whitesquare.png"));
				tiles[row][col].setIcon(new ImageIcon("bluecheckKing.png"));
				clearAll();
				playEat();
				showForcedMove(e);
				if(!checkArrow())
				{
					changeTurn();
				}
			}
		}
	}
	public void actionPerformed(ActionEvent e)//runs check move if you press a checker, else run makeMove to move the piece
	{
		GameTile clicked = (GameTile) e.getSource();
		if(clicked.getIcon().toString().equals("bluecheck.png") || clicked.getIcon().toString().equals("redcheck.png") || clicked.getIcon().toString().equals("redcheckKing.png") || clicked.getIcon().toString().equals("bluecheckKing.png"))
		{
			clearYellow();
			if(!clasicMode)
			{
				clearAll();
			}
			lastMove(clicked.getRow(),clicked.getCol(), e);
			checkMove(e);
		}	
		else
		{
			makeMove(e);
		}
		checkWin();
	}
	public static void main(String[] args) //runs the game
 	{
		new Checkers();
	}
}