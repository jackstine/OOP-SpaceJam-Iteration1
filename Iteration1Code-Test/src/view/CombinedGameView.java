package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.GameController.BoardMouseListener;
import model.GameMap;
import model.entity.Avatar;
import utilities.FontHandler;
import utilities.Scaling;

@SuppressWarnings("serial")
public class CombinedGameView extends View {
	 //Dimensions
    int boardDimensions[] = {Scaling.BOARD_X,Scaling.BOARD_Y,Scaling.BOARD_WIDTH,Scaling.BOARD_HEIGHT};
    int characterDimensions[] = {Scaling.CHAR_X , Scaling.CHAR_Y, Scaling.CHAR_WIDTH, Scaling.CHAR_HEIGHT};
    int buttonDimensions[] = {Scaling.SYSTEM_BUTTON_X , Scaling.SYSTEM_BUTTON_Y, Scaling.SYSTEM_BUTTON_WIDTH, Scaling.SYSTEM_BUTTON_HEIGHT};
    int statusDimensions[] = {Scaling.STATUS_X , Scaling.STATUS_Y, Scaling.STATUS_WIDTH, Scaling.STATUS_HEIGHT};
   
    //Components
    // private JTextField input = new JTextField(20);
    private JPanel buttons = new JPanel();
    private JButton systemButton = new JButton("Systems");
    private JButton statButton = new JButton("Statistics");
    private JButton levelUp = new JButton("Level Up!");
   
    //Views
    private GameView board;
    private InventoryEquipmentView character;
    private StatusView statusView;
    private Avatar avatar;
    
    //Utilities
    private FontHandler fh = new FontHandler();
    private Font buttonFont;
   
    public CombinedGameView(GameMap map, Avatar avatar,BoardMouseListener boardListener, ActionListener lvlup, ActionListener sysbtn, ActionListener statbtn){
    		this.avatar = avatar;
    		buttons.setBackground(new Color(169, 221, 221));
    		//Set font to buttons
    		buttonFont = fh.AfterDisasterFont();
    		systemButton.setFont(buttonFont.deriveFont(15f));
    		statButton.setFont(buttonFont.deriveFont(15f));
    		levelUp.setFont(buttonFont.deriveFont(15f));    		
    		
            board = new GameView(map,avatar, map.getLocation(avatar));
            character = new InventoryEquipmentView(avatar);
            statusView = new StatusView(avatar);
            
            // add the mouse listener to the board
            board.addMouseListener(boardListener);
            //Add to the canvas
            buttons.add(systemButton);
            buttons.add(statButton);
            buttons.add(levelUp);
            buttons.setBorder(new LineBorder(Color.black, 3));
            add(buttons);
//                          add(input);
//                          add(savedText);
            add(board);
            character.setBorder(new LineBorder(Color.black, 3));
            add(character);
            statusView.setBorder(new LineBorder(Color.black, 3));
            add(statusView);
           
            //Alignment --NEEDS ADJUSTMENT
            //systemButton.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 + 5, 0, 100, 25);
            //input.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 + 106, 0, 200, 25);
            //savedText.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 + 306, 100, 200, 25);

            board.setBounds(boardDimensions[0],boardDimensions[1],boardDimensions[2],boardDimensions[3]);
            character.setBounds(characterDimensions[0], characterDimensions[1], characterDimensions[2], characterDimensions[3]);
            buttons.setBounds(buttonDimensions[0],buttonDimensions[1], buttonDimensions[2], buttonDimensions[3]);
            statusView.setBounds(statusDimensions[0],statusDimensions[1], statusDimensions[2], statusDimensions[3]);
           
            systemButton.setToolTipText("(ESC)");
            statButton.setToolTipText("(C)");
            
            levelUp.setFocusable(false);
            levelUp.addActionListener(lvlup);

            systemButton.setFocusable(false);
            systemButton.addActionListener(sysbtn);
            
           
            statButton.setFocusable(false);
            statButton.addActionListener(statbtn);
            
                       
    }
    
    public MapView getMapView(){
    	return board.getMapView();
    }
    
    public void updateStatus(){
    	statusView.updateStatus();
    }
 
    
    public void addExternalViews(JInternalFrame info){
        add(info);
        info.setVisible(false);
        info.moveToBack();
    }
    
    public void removeExternalView(JInternalFrame info){
    	info.moveToBack();
    	info.setVisible(false);
        getTopLevelAncestor().requestFocus();
    }
    
    public void changeMap(GameMap map){
    	board.changeMap(map);
    }
    
    public void flash(MapFlash flash) {
    	
    }
}
