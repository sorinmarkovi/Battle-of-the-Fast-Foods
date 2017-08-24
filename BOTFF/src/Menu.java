import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu 
{
	public Rectangle playButton = new Rectangle(250, 150, 100, 50);
	public Rectangle howtoplayButton = new Rectangle(250, 250, 100, 50);
	public Rectangle quitButton = new Rectangle(250, 350, 100, 50);
	public Rectangle resumeButton = new Rectangle(250, 550, 100, 50);
	public Rectangle menuButton = new Rectangle(250, 550, 100, 50);
	public Rectangle okButton = new Rectangle(250, 550, 100, 50);
	Game game;
	Audio lose = new Audio("/no.wav");

	public void render(Graphics g) 
	{
		Graphics2D g2d = (Graphics2D) g;

		if (Game.pause || Game.endgame || Game.homeland || Game.pharmacy) 
		{
			if (Game.pause) 
			{
				Font startingTitle = new Font("DejaVu Sans Light", Font.BOLD, 16);
				g.setFont(startingTitle);
				g.setColor(Color.black);
				g.setColor(Color.black);
				g2d.draw(resumeButton);
				g.fillRect(0, 0, 650, 650);
				g.setColor(Color.red);
				g.drawString("Resume", resumeButton.x + 19, resumeButton.y + 30);
			}
			if (Game.pharmacy) 
			{
				Font startingTitle = new Font("DejaVu Sans Light", Font.BOLD, 48);
				Font secondTitle = new Font("DejaVu Sans Light", Font.BOLD, 24);
				Font buttonTitle = new Font("DejaVu Sans Light", Font.BOLD, 12);
				Font cashTitle = new Font("DejaVu Sans Light", Font.BOLD, 16);
				g.setFont(startingTitle);
				g.setColor(Color.WHITE);
				g.fillRect(-5, 0, 605, 650);
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, 700, 65);
				g.setColor(Color.RED);
				g.drawString("Pharmacy", 170, 50);
				g.setFont(secondTitle);
				g.setColor(Color.BLACK);
				g.fillRect(470, 500, 70, 40);
				g.setColor(Color.RED);
				g.drawString("Back", 470, 525);
				g.setColor(Color.RED);
				// upgrade buttons
				g.fillRect(250, 90, 100, 100);// hp up
				if (Game.CURRENTHEALTH != Game.MAXHEALTH)
					g.fillRect(250, 290, 100, 100);// full health
				g.fillRect(250, 490, 100, 100);// hp regen
				g.setFont(cashTitle);
				g.setColor(Color.yellow);
				g.drawString("$" + Game.healthCost, 260, 140);
				if (Game.CURRENTHEALTH != Game.MAXHEALTH)
					g.drawString("$" + (Game.MAXHEALTH - Game.CURRENTHEALTH), 260, 340);
				g.drawString("$" + Game.hpregenCost, 260, 540);
				g.setColor(Color.BLACK);
				g.setFont(buttonTitle);
				g.drawString("Max Health + 50", 260, 120);
				if (Game.CURRENTHEALTH != Game.MAXHEALTH)
					g.drawString("Full Health", 260, 320);
				g.drawString("Hp Regen + .25", 260, 520);
			}
			if (Game.homeland) 
			{
				Font startingTitle = new Font("DejaVu Sans Light", Font.BOLD, 48);
				Font secondTitle = new Font("DejaVu Sans Light", Font.BOLD, 24);
				Font buttonTitle = new Font("DejaVu Sans Light", Font.BOLD, 12);
				Font cashTitle = new Font("DejaVu Sans Light", Font.BOLD, 16);
				g.setFont(startingTitle);
				g.setColor(Color.black);
				g.fillRect(-5, 0, 605, 650);
				g.setColor(Color.white);
				g.fillRect(0, 0, 700, 65);
				g.setColor(Color.green);
				g.drawString("HOMELAND", 170, 50);
				g.setFont(secondTitle);
				g.drawString("Upgrades", 250, 125);
				g.drawString("Augments (You can only have one of them!)", 25, 400);
				g.setColor(Color.RED);
				g.fillRect(270, 300, 70, 40);
				g.setColor(Color.black);
				g.drawString("Back", 275, 325);
				g.setColor(Color.BLUE);
				// upgrade buttons
				g.fillRect(25, 150, 100, 100);// energy regen
				g.fillRect(175, 150, 100, 100);// muscle milk
				g.fillRect(325, 150, 100, 100);// lucker
				g.fillRect(475, 150, 100, 100);// moster
				// special augment buttons
				if (Game.hyper == false && Game.inv == false && Game.nuke == false && Game.stop == false) 
				{
					g.fillRect(25, 450, 100, 100);// stop time
					g.fillRect(175, 450, 100, 100);// HyperSpeed
					g.fillRect(325, 450, 100, 100);// invincibility
					g.fillRect(475, 450, 100, 100);// Nuke
				}
				g.setFont(cashTitle);
				g.setColor(Color.yellow);
				g.drawString("$" + Game.eregenCost, 25, 225);
				g.drawString("$" + Game.milkCost, 175, 225);
				g.drawString("$" + Game.luckerCost, 325, 225);
				g.drawString("$" + Game.stealCost, 475, 225);
				if (Game.hyper == false && Game.inv == false && Game.nuke == false && Game.stop == false) 
				{
					g.drawString("$" + Game.stopCost, 25, 525);
					g.drawString("$" + Game.hyperCost, 175, 525);
					g.drawString("$" + Game.nukeCost, 325, 525);
					g.drawString("$" + Game.invCost, 475, 525);
				}
				g.setColor(Color.CYAN);
				g.setFont(buttonTitle);
				g.drawString("Energy Regen", 25, 160);
				g.drawString("+ 0.5", 25, 180);
				g.drawString("Damage + 5", 175, 160);
				g.drawString("Gold", 325, 180);
				g.drawString("+ 15 min/max", 325, 160);
				g.drawString("LifeSteal + 5", 475, 160);
				if (Game.hyper == false && Game.inv == false && Game.nuke == false && Game.stop == false) 
				{
					g.drawString("Stop Time", 25, 470);
					g.drawString("HyperSpeed", 175, 470);
					g.drawString("Nuke", 325, 470);
					g.drawString("Invincibility", 475, 470);
				}
			}
			if (Game.endgame && Game.bossKilled == 5) 
			{
				Font startingTitle = new Font("DejaVu Sans Light", Font.BOLD, 12);
				Font endingTitle = new Font("DejaVu Sans Light", Font.BOLD, 48);
				g.setFont(startingTitle);
				g.setColor(Color.black);
				g.fillRect(0, 0, 650, 650);
				g.setColor(Color.black);
				g2d.draw(okButton);
				g.fillRect(250, 550, 100, 50);
				g.setColor(Color.red);
				g.setFont(endingTitle);
				g.drawString("Choose an upgrade and", 5, 150);
				g.drawString("continue to level:", 105, 200);
				g.drawString("" + (Game.currentLevel + 1), 275, 250);
				g.setFont(startingTitle);
				g.setColor(Color.ORANGE);
				g.fillRect(25, 365, 100, 100);// 2 Energy Regeneration 
				g.fillRect(175, 365, 100, 100);// 10 damage
				g.fillRect(325, 365, 100, 100);// 1 HP Regeneration
				g.fillRect(475, 365, 100, 100);// 5 life-steal
				g.setColor(Color.BLACK);
				g.drawString("E Regen + 2", 25, 380);
				g.drawString("Damage + 10", 175, 380);
				g.drawString("HP Regen + 1", 325, 380);
				g.drawString("LifeSteal + 5", 475, 380);g.setColor(Color.orange);
				g.drawString("Your score : " + Game.score, 200, 550);
			} 
			else if (Game.endgame && Game.bossKilled != 5) 
			{
				Font startingTitle = new Font("DejaVu Sans Light", Font.BOLD, 16);
				Font endingTitle = new Font("DejaVu Sans Light", Font.BOLD, 48);
				g.setFont(startingTitle);
				g.setColor(Color.black);
				g.fillRect(0, 0, 650, 650);
				g.setColor(Color.black);
				g2d.draw(okButton);
				g.fillRect(250, 550, 100, 50);
				g.setColor(Color.red);
				g.drawString("Ok", okButton.x + 19, okButton.y + 30);
				g.setFont(endingTitle);
				g.drawString("Game Over", 150, 200);
				g.setColor(Color.orange);
				g.drawString("Your score : ", 150, 300);
				g.drawString("" + Game.score, 250, 375);
			}
		} 
		else 
		{
			Font startingTitle = new Font("DejaVu Sans Light", Font.BOLD | Font.ITALIC, 24);
			g.setFont(startingTitle);
			g.setColor(Color.black);
			g.fillRect(125, 70, 350, 50);
			g.setColor(Color.RED);
			g.drawString("Battle of the Fast Foods", 150, 100);
			g.setColor(Color.black);
			g2d.draw(playButton);
			g.fillRect(250, 150, 100, 50);
			g.setColor(Color.red);
			g.drawString("Play", playButton.x + 19, playButton.y + 30);
			g.setColor(Color.black);
			g2d.draw(howtoplayButton);
			g.fillRect(200, 250, 200, 50);
			g.setColor(Color.red);
			g.drawString("How to play", 225, 285);
			g.setColor(Color.black);
			g2d.draw(quitButton);
			g.fillRect(250, 350, 100, 50);
			g.setColor(Color.red);
			g.drawString("Quit", quitButton.x + 19, quitButton.y + 30);
		}
	}

}