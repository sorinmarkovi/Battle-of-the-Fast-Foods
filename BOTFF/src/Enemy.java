import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import Entitys.EntityA;
import Entitys.EntityB;
public class Enemy extends GameObject implements EntityB 
{
	EntityA tempEnt;
	private Textures tex;
	Controller c;
	//private boolean ranged = false;
	private double HEALTH;
	private int ms = 5;
	BufferedImage image;
	Player p;
	Map map;
	Audio enemyHit = new Audio("/hitmarker.wav");
	Audio bossDefeated = new Audio("/success.wav");
	boolean boss, boss2;
	String faction;
	
	public Enemy(double x, double y, String faction, double health, Textures tex, boolean boss, boolean boss2) 
	{
		super(x, y);
		this.x = x;
		this.y = y;
		//this.ranged = ranged;
		this.HEALTH = health;
		this.tex = tex;
		this.faction = faction;
		this.boss = boss;
		this.boss2 = boss2;
	}
	public void tick() 
	{
		if (Game.nukedo) 
		{
			this.HEALTH -= 10000;
			Game.nukedo = false;
		}
		if (Game.poison == true) {
			if (((this.faction == "SUBWAY") && Game.PlayerFaction != Faction.FACTION.SUBWAY)
					|| ((this.faction == "ARBYS") && Game.PlayerFaction != Faction.FACTION.ARBYS)
					|| ((this.faction == "MCD") && Game.PlayerFaction != Faction.FACTION.MCD)
					|| ((this.faction == "BRAUMS") && Game.PlayerFaction != Faction.FACTION.BRAUMS)
					|| ((this.faction == "CAESAR") && Game.PlayerFaction != Faction.FACTION.CAESAR)
					|| ((this.faction == "TACOBELL") && Game.PlayerFaction != Faction.FACTION.TACOBELL)) 
			{
				this.HEALTH -= .2 * Game.currentLevel;
				if (this.HEALTH <= 0) 
				{
					Controller.removeEntity(this);
					Controller.enemyKilled(this);
					if (this.getBoss() || this.getBoss2()) 
						Game.bossKilled++;
					if (Game.ENERGY <= 100 && !Game.active)
						Game.ENERGY += 10;
					if (Game.ENERGY >= 100)
						Game.ENERGY = 100;
					Game.CURRENTHEALTH += Game.steal;
					Game.CASH += Game.gok;
					if (Game.CURRENTHEALTH >= Game.MAXHEALTH)
						Game.CURRENTHEALTH = Game.MAXHEALTH;
					spawned();
				}
			}
		}
		if ((this.getBoss() || this.getBoss2()) && !Game.stopped) 
		{
			if (((this.faction == "SUBWAY") && Game.PlayerFaction != Faction.FACTION.SUBWAY)
					|| ((this.faction == "ARBYS") && Game.PlayerFaction != Faction.FACTION.ARBYS)
					|| ((this.faction == "MCD") && Game.PlayerFaction != Faction.FACTION.MCD)
					|| ((this.faction == "BRAUMS") && Game.PlayerFaction != Faction.FACTION.BRAUMS)
					|| ((this.faction == "CAESAR") && Game.PlayerFaction != Faction.FACTION.CAESAR)
					|| ((this.faction == "TACOBELL") && Game.PlayerFaction != Faction.FACTION.TACOBELL)) 
			{
				x += ms;
				if (x <= 0) 
				{
					ms = -ms;
				}
				if (x >= 556)
					ms = -ms;
			}
		}
		for (int i = 0; i < Controller.ea.size(); i++)
		{
			EntityA tempEntA = Controller.ea.get(i);

			if (Game.nukedo) 
			{
				this.HEALTH -= 500;
				Game.nukedo = false;
			}

			if (Phs.Collision(tempEntA, this)) 
			{

				if (((this.faction == "SUBWAY") && Game.PlayerFaction != Faction.FACTION.SUBWAY)
						|| ((this.faction == "ARBYS") && Game.PlayerFaction != Faction.FACTION.ARBYS)
						|| ((this.faction == "MCD") && Game.PlayerFaction != Faction.FACTION.MCD)
						|| ((this.faction == "SONIC") && Game.PlayerFaction != Faction.FACTION.SONIC)
						|| ((this.faction == "BRAUMS") && Game.PlayerFaction != Faction.FACTION.BRAUMS)
						|| ((this.faction == "CAESAR") && Game.PlayerFaction != Faction.FACTION.CAESAR)
						|| ((this.faction == "TACOBELL") && Game.PlayerFaction != Faction.FACTION.TACOBELL)) 
				{
					enemyHit.play();
					if (Game.pierce == false)
						Controller.removeEntity(tempEntA);
					if (Game.ddamage == true)
						this.HEALTH -= 1.5 * tempEntA.getPower();
					else
						this.HEALTH -= tempEntA.getPower();
					if (Game.pierce)
						this.HEALTH += tempEntA.getPower() / 2;
					if (this.HEALTH <= 0) {
						Controller.removeEntity(this);
						Controller.enemyKilled(this);
						if (this.getBoss() || this.getBoss2()) 
							Game.bossKilled++;
						if (Game.ENERGY <= 100 && !Game.active)
							Game.ENERGY += 10;
						if (Game.ENERGY >= 100)
							Game.ENERGY = 100;
						Game.CURRENTHEALTH += Game.steal;
						Game.CASH += Game.gok;
						if (Game.CURRENTHEALTH >= Game.MAXHEALTH)
							Game.CURRENTHEALTH = Game.MAXHEALTH;
						spawned();
					}
				}
			}
		}
	}
	public void render(Graphics g) 
	{
		g.drawImage(tex.getEnemy(), (int) x, (int) y, null);
	}
	public double getY() 
	{
		return y;
	}
	public void setY(double y) 
	{
		this.y = y;
	}
	public double getX() 
	{
		return x;
	}
	public Rectangle getBounds() 
	{
		return new Rectangle((int) x, (int) y, 64, 64);
	}
	public double getHealth() 
	{
		return HEALTH;
	}
	public void setHealth(int HEALTH) 
	{
		this.HEALTH = HEALTH;
	}
	public void bump(int xChange, int yChange) 
	{
		this.x += xChange;
		this.y += yChange;
	}
	public boolean getBoss() 
	{
		return boss;
	}
	public boolean getBoss2() 
	{
		return boss2;
	}
	public String getFaction() 
	{
		return faction;
	}
	public void spawned() 
	{
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.a1) 
		{
			Game.a1 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.a2) 
		{
			Game.a2 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.a3) 
		{
			Game.a3 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.a4) 
		{
			Game.a4 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.a5) 
		{
			Game.a5 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.a6) 
		{
			Game.a6 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.a7) 
		{
			Game.a7 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.a8) 
		{
			Game.a8 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.a9) 
		{
			Game.a9 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.a10) 
		{
			Game.a10 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.b1) 
		{
			Game.b1 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.b2) 
		{
			Game.b2 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.b3) 
		{
			Game.b3 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.b4) 
		{
			Game.b4 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.b5) 
		{
			Game.b5 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.b6) 
		{
			Game.b6 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.b7) 
		{
			Game.b7 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.b8) 
		{
			Game.b8 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.b9) 
		{
			Game.b9 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.b10) 
		{
			Game.b10 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.c1) 
		{
			Game.c1 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.c2) 
		{
			Game.c2 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.c3) 
		{
			Game.c3 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.c4) 
		{
			Game.c4 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.c5) 
		{
			Game.c5 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.c6) 
		{
			Game.c6 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.c7) 
		{
			Game.c7 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.c8) 
		{
			Game.c8 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.c9) 
		{
			Game.c9 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.c10) 
		{
			Game.c10 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.d1) 
		{
			Game.d1 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.d2) 
		{
			Game.d2 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.d3) 
		{
			Game.d3 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.d4) 
		{
			Game.d4 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.d5) 
		{
			Game.d5 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.d6) 
		{
			Game.d6 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.d7) 
		{
			Game.d7 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.d8) 
		{
			Game.d8 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.d9) 
		{
			Game.d9 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.d10) 
		{
			Game.d10 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.e1) 
		{
			Game.e1 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.e2) 
		{
			Game.e2 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.e3) 
		{
			Game.e3 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.e4) 
		{
			Game.e4 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.e5) 
		{
			Game.e5 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.e6) 
		{
			Game.e6 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.e7) 
		{
			Game.e7 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.e8) 
		{
			Game.e8 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.e9) 
		{
			Game.e9 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.e10) 
		{
			Game.e10 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.f1) 
		{
			Game.f1 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.f2) 
		{
			Game.f2 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.f3) 
		{
			Game.f3 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.f4) 
		{
			Game.f4 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.f5) 
		{
			Game.f5 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.f6) 
		{
			Game.f6 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.f7) 
		{
			Game.f7 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.f8) 
		{
			Game.f8 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.f9)
		{
			Game.f9 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.f10) 
		{
			Game.f10 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.g1) 
		{
			Game.g1 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.g2) 
		{
			Game.g2 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.g3) 
		{
			Game.g3 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.g4) 
		{
			Game.g4 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.g5) 
		{
			Game.g5 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.g6) 
		{
			Game.g6 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.g7) 
		{
			Game.g7 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.g8) 
		{
			Game.g8 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.g9) 
		{
			Game.g9 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.g10) 
		{
			Game.g10 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.h1) 
		{
			Game.h1 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.h2) 
		{
			Game.h2 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.h3) 
		{
			Game.h3 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.h4) 
		{
			Game.h4 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.h5) 
		{
			Game.h5 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.h6) 
		{
			Game.h6 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.h7) 
		{
			Game.h7 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.h8) 
		{
			Game.h8 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.h9) 
		{
			Game.h9 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.h10) 
		{
			Game.h10 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.i1) 
		{
			Game.i1 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.i2) 
		{
			Game.i2 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.i3) 
		{
			Game.i3 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.i4) 
		{
			Game.i4 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.i5) 
		{
			Game.i5 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.i6) 
		{
			Game.i6 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.i7) 
		{
			Game.i7 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.i8) 
		{
			Game.i8 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.i9) 
		{
			Game.i9 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.i10) 
		{
			Game.i10 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.j1) 
		{
			Game.j1 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.j2) 
		{
			Game.j2 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.j3) 
		{
			Game.j3 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.j4) 
		{
			Game.j4 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.j5) 
		{
			Game.j5 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.j6) 
		{
			Game.j6 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.j7) 
		{
			Game.j7 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.j8) 
		{
			Game.j8 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.j9) 
		{
			Game.j9 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.j10) 
		{
			Game.j10 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.k1) 
		{
			Game.k1 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.k2) 
		{
			Game.k2 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.k3) 
		{
			Game.k3 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.k4) 
		{
			Game.k4 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.k5) 
		{
			Game.k5 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.k6) 
		{
			Game.k6 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.k7) 
		{
			Game.k7 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.k8) 
		{
			Game.k8 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.k9) 
		{
			Game.k9 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.k10) 
		{
			Game.k10 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.l1) 
		{
			Game.l1 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.l2) 
		{
			Game.l2 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.l3) 
		{
			Game.l3 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.l4) 
		{
			Game.l4 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.l5) 
		{
			Game.l5 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.l6) 
		{
			Game.l6 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.l7) 
		{
			Game.l7 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.l8) 
		{
			Game.l8 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.l9) 
		{
			Game.l9 = true;
		}
		if (Controller.eb.size() == 0 && Map.Location == Map.MAP.l10) 
		{
			Game.l10 = true;
		}
	}
}