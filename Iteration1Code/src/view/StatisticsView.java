package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatisticsView extends JInternalFrame {
	private JButton ret = new JButton("Return");
	public StatisticsView(ActionListener retAction) {
		ret.setFocusable(false);
		String livesLeft = Integer.toString(32);
		String strength = Integer.toString(32);
		String agility = Integer.toString(32);
		String intellect = Integer.toString(32);
		String hardiness = Integer.toString(32);
		String experience = Integer.toString(32);
		String movement = Integer.toString(32);
		
		String level = Integer.toString(32);
		String life = Integer.toString(32);
		String mana = Integer.toString(32);
		String offRating = Integer.toString(32);
		String defRating = Integer.toString(32);
		String armRating = Integer.toString(32);
		
		setTitle("Statistics");
		JLabel primaryStats = new JLabel("<html><style type='text/css'>.tg  {border-collapse:collapse;border-spacing:0;}.tg td{font-family:Arial, sans-serif;font-size:10px;padding:5px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}.tg .tg-e3zv{font-weight:bold}</style><table class='tg'>  <tr>    <th class='tg-e3zv'>Primary</th>    <th class='tg-e3zv'>Value</th>  </tr>  <tr>    <td class='tg-031e'>Lives left</td>    <td class='tg-031e'>" + livesLeft + "</td>  </tr>  <tr>    <td class='tg-031e'>Strength</td>    <td class='tg-031e'>" + strength +  "</td>  </tr>  <tr>    <td class='tg-031e'>Agility</td>    <td class='tg-031e'>" + agility + "</td>  </tr>  <tr>    <td class='tg-031e'>Intellect</td>    <td class='tg-031e'>" + intellect + "</td>  </tr>  <tr>    <td class='tg-031e'>Hardiness</td>    <td class='tg-031e'>" + hardiness + "</td>  </tr>  <tr>    <td class='tg-031e'>Experience</td>    <td class='tg-031e'>" + experience +  "</td>  </tr>  <tr>    <td class='tg-031e'>Movement</td>    <td class='tg-031e'>" + movement + "</td>  </tr></table></html>" + "test");
		JLabel derivedStats = new JLabel("<html><style type='text/css'>.tg  {border-collapse:collapse;border-spacing:0;}.tg td{font-family:Arial, sans-serif;font-size:10px;padding:5px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}.tg .tg-e3zv{font-weight:bold}</style><table class='tg'>  <tr>    <th class='tg-e3zv'>Derived</th>    <th class='tg-e3zv'>Value</th>  </tr>  <tr>    <td class='tg-031e'>Level</td>    <td class='tg-031e'>" + level + "</td>  </tr>  <tr>    <td class='tg-031e'>Life</td>    <td class='tg-031e'>" + life + "</td>  </tr>  <tr>    <td class='tg-031e'>Mana</td>    <td class='tg-031e'>" + mana + "</td>  </tr>  <tr>    <td class='tg-031e'>Offensive rating</td>    <td class='tg-031e'>" + offRating + "</td>  </tr>  <tr>    <td class='tg-031e'>Defensive rating</td>    <td class='tg-031e'>" + defRating + "</td>  </tr>  <tr>    <td class='tg-031e'>Armor rating</td>    <td class='tg-031e'>" + armRating + "</td>  </tr></table></html>");
		JPanel tables = new JPanel();
		tables.add(primaryStats);
		tables.add(derivedStats);
		tables.add(ret);
		add(tables);
		setBounds(50, 50, 500, 500);
		setVisible(true);
				
		ret.addActionListener(retAction);
	}
}
