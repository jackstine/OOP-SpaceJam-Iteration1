package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.Scaling;
import model.Avatar;

public class StatisticsView extends JInternalFrame {
	private JButton ret = new JButton("Return");
	private int dimensions[] = {Scaling.INTERNAL_X,Scaling.INTERNAL_Y,Scaling.INTERNAL_WIDTH,Scaling.INTERNAL_HEIGHT};
	public StatisticsView(Avatar avatar, ActionListener retAction) {
		ret.setFocusable(false);
		String livesLeft = avatar.getStat("Lives");
		String strength = avatar.getStat("Strength");
		String agility = avatar.getStat("Agility");
		String intellect = avatar.getStat("Intellect");
		String hardiness = avatar.getStat("Hardiness");
		String experience = avatar.getStat("Experience");
		String movement = avatar.getStat("Movement");
		
		String level = avatar.getStat("Level");
		String life = avatar.getStat("Life");
		String mana = avatar.getStat("Mana");
		String offRating = avatar.getStat("OffensiveRating");
		String defRating = avatar.getStat("DefensiveRating");
		String armRating = avatar.getStat("ArmorRating");
		
		setTitle("Statistics");
		JLabel primaryStats = new JLabel("<html><style type='text/css'>.tg  {border-collapse:collapse;border-spacing:0;}.tg td{font-family:Arial, sans-serif;font-size:10px;padding:5px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}.tg .tg-e3zv{font-weight:bold}</style><table class='tg'>  <tr>    <th class='tg-e3zv'>Primary</th>    <th class='tg-e3zv'>Value</th>  </tr>  <tr>    <td class='tg-031e'>Lives left</td>    <td class='tg-031e'>" + livesLeft + "</td>  </tr>  <tr>    <td class='tg-031e'>Strength</td>    <td class='tg-031e'>" + strength +  "</td>  </tr>  <tr>    <td class='tg-031e'>Agility</td>    <td class='tg-031e'>" + agility + "</td>  </tr>  <tr>    <td class='tg-031e'>Intellect</td>    <td class='tg-031e'>" + intellect + "</td>  </tr>  <tr>    <td class='tg-031e'>Hardiness</td>    <td class='tg-031e'>" + hardiness + "</td>  </tr>  <tr>    <td class='tg-031e'>Experience</td>    <td class='tg-031e'>" + experience +  "</td>  </tr>  <tr>    <td class='tg-031e'>Movement</td>    <td class='tg-031e'>" + movement + "</td>  </tr></table></html>" + "test");
		JLabel derivedStats = new JLabel("<html><style type='text/css'>.tg  {border-collapse:collapse;border-spacing:0;}.tg td{font-family:Arial, sans-serif;font-size:10px;padding:5px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}.tg .tg-e3zv{font-weight:bold}</style><table class='tg'>  <tr>    <th class='tg-e3zv'>Derived</th>    <th class='tg-e3zv'>Value</th>  </tr>  <tr>    <td class='tg-031e'>Level</td>    <td class='tg-031e'>" + level + "</td>  </tr>  <tr>    <td class='tg-031e'>Life</td>    <td class='tg-031e'>" + life + "</td>  </tr>  <tr>    <td class='tg-031e'>Mana</td>    <td class='tg-031e'>" + mana + "</td>  </tr>  <tr>    <td class='tg-031e'>Offensive rating</td>    <td class='tg-031e'>" + offRating + "</td>  </tr>  <tr>    <td class='tg-031e'>Defensive rating</td>    <td class='tg-031e'>" + defRating + "</td>  </tr>  <tr>    <td class='tg-031e'>Armor rating</td>    <td class='tg-031e'>" + armRating + "</td>  </tr></table></html>");
		JPanel tables = new JPanel();
		tables.add(primaryStats);
		tables.add(derivedStats);
		tables.add(ret);
		add(tables);
		setBounds(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);
		setVisible(true);
				
		ret.addActionListener(retAction);
	}
}
