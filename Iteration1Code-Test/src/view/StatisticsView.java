package view;


import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.Scaling;
<<<<<<< HEAD
import model.Entity.Avatar;
=======
import model.Avatar;
import model.Skill;
>>>>>>> origin/master

@SuppressWarnings("serial")
public class StatisticsView extends JInternalFrame {
	private JButton ret = new JButton("Return");
	JLabel primaryStats = new JLabel();
	JLabel derivedStats = new JLabel();
	JLabel skills = new JLabel();
	private int dimensions[] = {Scaling.INTERNAL_X,Scaling.INTERNAL_Y,Scaling.INTERNAL_WIDTH,700};
	public StatisticsView(Avatar avatar, ActionListener retAction) {
		ret.setFocusable(false);
		Updatetable(avatar);
		JPanel tables = new JPanel();
		tables.add(primaryStats);
		tables.add(derivedStats);
		tables.add(skills);
		tables.add(ret);
		add(tables);
		setBounds(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);
		setVisible(true);
				
		ret.addActionListener(retAction);
	}
	
	public void Updatetable(Avatar avatar){
		
		 Map<String, Skill> avSkills = avatar.getOccupation().getSkills();
		 String skillList = "<html><style type='text/css'>.tg  {border-collapse:collapse;border-spacing:0;}.tg td{font-family:Arial, sans-serif;font-size:10px;padding:5px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}.tg .tg-e3zv{font-weight:bold}</style><table class='tg'>  <tr>    <th class='tg-e3zv'>Skills</th>    <th class='tg-e3zv'>Value</th>  </tr>";
		 for(Entry<String, Skill> entry: avSkills.entrySet()){
			 String key = entry.getKey();
			 Skill skill = entry.getValue();
			 skillList += "<tr>    <td class='tg-031e'>" + key+  "</td>    <td class='tg-031e'>" + skill.getSkillLevel() + "</td>  </tr>";
		 }
		 skillList += "</table></html>";
		
		String livesLeft = Integer.toString(avatar.getStatValue("Lives"));
		String strength = Integer.toString(avatar.getStatValue("Strength"));
		String agility = Integer.toString(avatar.getStatValue("Agility"));
		String intellect = Integer.toString(avatar.getStatValue("Intellect"));
		String hardiness = Integer.toString(avatar.getStatValue("Hardiness"));
		String experience = Integer.toString(avatar.getStatValue("Experience"));
		String movement = Integer.toString(avatar.getStatValue("Movement"));
		
		String level = Integer.toString(avatar.getStatValue("Level"));
		String life = Integer.toString(avatar.getStatValue("Life"));
		String mana = Integer.toString(avatar.getStatValue("Mana"));
		String offRating = Integer.toString(avatar.getStatValue("OffensiveRating"));
		String defRating = Integer.toString(avatar.getStatValue("DefensiveRating"));
		String armRating = Integer.toString(avatar.getStatValue("ArmorRating"));
		
		skills.setText(skillList);
		primaryStats.setText("<html><style type='text/css'>.tg  {border-collapse:collapse;border-spacing:0;}.tg td{font-family:Arial, sans-serif;font-size:10px;padding:5px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}.tg .tg-e3zv{font-weight:bold}</style><table class='tg'>  <tr>    <th class='tg-e3zv'>Primary</th>    <th class='tg-e3zv'>Value</th>  </tr>  <tr>    <td class='tg-031e'>Lives left</td>    <td class='tg-031e'>" + livesLeft + "</td>  </tr>  <tr>    <td class='tg-031e'>Strength</td>    <td class='tg-031e'>" + strength +  "</td>  </tr>  <tr>    <td class='tg-031e'>Agility</td>    <td class='tg-031e'>" + agility + "</td>  </tr>  <tr>    <td class='tg-031e'>Intellect</td>    <td class='tg-031e'>" + intellect + "</td>  </tr>  <tr>    <td class='tg-031e'>Hardiness</td>    <td class='tg-031e'>" + hardiness + "</td>  </tr>  <tr>    <td class='tg-031e'>Experience</td>    <td class='tg-031e'>" + experience +  "</td>  </tr>  <tr>    <td class='tg-031e'>Movement</td>    <td class='tg-031e'>" + movement + "</td>  </tr></table></html>" + "test");
		derivedStats.setText("<html><style type='text/css'>.tg  {border-collapse:collapse;border-spacing:0;}.tg td{font-family:Arial, sans-serif;font-size:10px;padding:5px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}.tg .tg-e3zv{font-weight:bold}</style><table class='tg'>  <tr>    <th class='tg-e3zv'>Derived</th>    <th class='tg-e3zv'>Value</th>  </tr>  <tr>    <td class='tg-031e'>Level</td>    <td class='tg-031e'>" + level + "</td>  </tr>  <tr>    <td class='tg-031e'>Life</td>    <td class='tg-031e'>" + life + "</td>  </tr>  <tr>    <td class='tg-031e'>Mana</td>    <td class='tg-031e'>" + mana + "</td>  </tr>  <tr>    <td class='tg-031e'>Offensive rating</td>    <td class='tg-031e'>" + offRating + "</td>  </tr>  <tr>    <td class='tg-031e'>Defensive rating</td>    <td class='tg-031e'>" + defRating + "</td>  </tr>  <tr>    <td class='tg-031e'>Armor rating</td>    <td class='tg-031e'>" + armRating + "</td>  </tr></table></html>");
	}
}
