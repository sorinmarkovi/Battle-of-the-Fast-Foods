import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
public class HUD 
{
	public Rectangle factionBar = new Rectangle(600, 150, 100, 50);
	public Rectangle healthBar = new Rectangle(600, 250, 100, 50);
	public Rectangle enegyBar = new Rectangle(600, 350, 100, 50);
	public Rectangle moneyBar = new Rectangle(600, 450, 100, 50);
	Game game;
	Player p;
	public void render(Graphics g) 
	{
		Font startingTitle = new Font("DejaVu Sans Light", Font.BOLD, 16);
		g.setFont(startingTitle);
		g.setColor(Color.black);
		g.fillRect(600, 0, 700, 700);
		g.setColor(Color.RED);
		g.drawString("HP", 650, 100);
		g.drawString("Energy", 643, 200);
		g.drawString("Cash", 646, 300);
		g.drawString("Score", 646, 400);
		if (Game.PlayerFaction == Faction.FACTION.SUBWAY)
			g.drawString("     Subway ", 605, 500);
		if (Game.PlayerFaction == Faction.FACTION.BRAUMS)
			g.drawString("     Braums ", 605, 500);
		if (Game.PlayerFaction == Faction.FACTION.TACOBELL)
			g.drawString("   TacoBell ", 605, 500);
		if (Game.PlayerFaction == Faction.FACTION.CAESAR)
			g.drawString("     Caesar ", 605, 500);
		if (Game.PlayerFaction == Faction.FACTION.ARBYS)
			g.drawString("     Arby's ", 605, 500);
		if (Game.PlayerFaction == Faction.FACTION.MCD)
			g.drawString("  McDonalds ", 605, 500);
		g.setColor(Color.GREEN);
		g.drawString("Level : " + Game.currentLevel, 625, 520);
	}
}