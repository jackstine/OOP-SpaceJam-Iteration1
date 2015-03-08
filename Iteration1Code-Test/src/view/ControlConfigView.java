package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import utilities.Scaling;

@SuppressWarnings("serial")
public class ControlConfigView extends JInternalFrame{
	private int dimensions[] = {Scaling.INTERNAL_X,Scaling.INTERNAL_Y,Scaling.INTERNAL_WIDTH,Scaling.INTERNAL_HEIGHT};
	private JButton backButton = new JButton("Back");
	private JButton doneButton = new JButton("Bind Keys");
	private JButton rstButton = new JButton("Reset");
	private JPanel canvas = new JPanel();
	JPanel config = new JPanel();
	JPanel buttons = new JPanel();
	
	private ControlField n;
	private ControlField ne;
	private ControlField nw;
	private ControlField s;
	private ControlField se;
	private ControlField sw;
	private ControlField w;
	private ControlField e;
	private ControlField d1;
	private ControlField d2;
	
	private Map<String, ControlField> buttonSet = new HashMap<String, ControlField>();
	private Map<String, Integer> keySet;
	
	public ControlConfigView(ActionListener back, ActionListener bind, ActionListener reset, Map<String, Integer> keys){
		keySet = keys;
		
		backButton.setFocusable(false);
		doneButton.setFocusable(false);
		
		setTitle("Control Configuration");
		canvas.setLayout(new BorderLayout());
		config.setLayout(new GridLayout(5,2));
		
		n = new ControlField("NORTH",keyToChar(keySet.get("NORTH")));
		ne = new ControlField("NORTHEAST", keyToChar(keySet.get("NORTHEAST")));
		nw = new ControlField("NORTHWEST", keyToChar(keySet.get("NORTHWEST")));
		w = new ControlField("WEST",keyToChar(keySet.get("WEST")));
		sw = new ControlField("SOUTHWEST",keyToChar(keySet.get("SOUTHWEST")));
		s = new ControlField("SOUTH",keyToChar(keySet.get("SOUTH")));
		se = new ControlField("SOUTHEAST",keyToChar(keySet.get("SOUTHEAST")));
		e = new ControlField("EAST",keyToChar(keySet.get("EAST")));
		d1 = new ControlField("DANCE1",keyToChar(keySet.get("DANCE1")));
		d2 = new ControlField("DANCE1",keyToChar(keySet.get("DANCE2")));
		
		config.add(nw);
		config.add(n);
		config.add(ne);
		config.add(w);
		config.add(e);
		config.add(sw);
		config.add(s);
		config.add(se);	
		config.add(d1);	
		config.add(d2);	
		
		buttons.setLayout(new GridLayout(3,1));
		buttons.add(doneButton);
		buttons.add(backButton);
		buttons.add(rstButton);
	    
		
		canvas.add(config, BorderLayout.EAST);
		canvas.add(buttons, BorderLayout.CENTER);
		
		add(canvas);
		
		setTitle("Control Configuration");
		setBounds(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);
		setVisible(true);
		
		backButton.addActionListener(back);
		doneButton.addActionListener(bind);
		rstButton.addActionListener(reset);
		
		buttonSet.put("NORTH", n);
		buttonSet.put("NORTHEAST", ne);
		buttonSet.put("NORTHWEST", nw);
		buttonSet.put("SOUTH", s);
		buttonSet.put("SOUTHEAST", se);
		buttonSet.put("SOUTHWEST", sw);
		buttonSet.put("WEST", w);
		buttonSet.put("EAST", e);
		buttonSet.put("DANCE1", d1);
		buttonSet.put("DANCE2", d2);
	}
	
	public String keyToChar(int i){
		return KeyEvent.getKeyText(i);
	}
	
	public int charToKey(String s){
		s = s.toUpperCase();
		return KeyEvent.getExtendedKeyCodeForChar(s.charAt(0));
	}
	
	public void BindKey(){
		int newKey = 0;
		String text = "";
		for (String key : buttonSet.keySet()) {
			text = buttonSet.get(key).getInput();
			if(text.length() == 1){
				newKey = charToKey(text);
				keySet.put(key, newKey);
			}
		}
	}
	
	public void reset(){
		for (Entry<String, ControlField> entry : buttonSet.entrySet()) {
		    String key = entry.getKey();
		    ControlField text = entry.getValue();
		    text.setInput(keyToChar(keySet.get(key)));
		}
	}
}
