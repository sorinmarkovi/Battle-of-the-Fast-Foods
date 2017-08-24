import java.awt.Image;
import java.awt.image.BufferedImage;
public class Textures 
{
	public static BufferedImage player, missle, enemy, startingMap, drop;
	SpriteSheet ps = null;// Player Sprite
	SpriteSheet ms = null;// Map Sheet
	SpriteSheet bs = null;// Bullet Sheet
	PlayerBullet b;
	Player p;
	Map m;
	public Textures(Game game) 
	{
		ps = new SpriteSheet(game.getPlayerSheet());
		ms = new SpriteSheet(game.getMapSheet());
		bs = new SpriteSheet(game.getBulletSheet());
	}
	public BufferedImage getPlayerFront() 
	{
		if (Game.PlayerFaction == Faction.FACTION.SUBWAY) 
		{
			player = ps.grabPlayerImage(1, 2, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.BRAUMS) 
		{
			player = ps.grabPlayerImage(1, 6, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.SONIC) 
		{
			player = ps.grabPlayerImage(1, 7, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.TACOBELL) 
		{
			player = ps.grabPlayerImage(1, 4, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.CAESAR) 
		{
			player = ps.grabPlayerImage(1, 5, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.ARBYS) 
		{
			player = ps.grabPlayerImage(1, 1, 64, 64);
			return player;

		}
		if (Game.PlayerFaction == Faction.FACTION.MCD) 
		{
			player = ps.grabPlayerImage(1, 3, 64, 64);
			return player;
		}
		return null;
	}
	public BufferedImage getPlayerBack() 
	{
		if (Game.PlayerFaction == Faction.FACTION.SUBWAY) 
		{
			player = ps.grabPlayerImage(2, 2, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.BRAUMS) 
		{
			player = ps.grabPlayerImage(2, 6, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.SONIC) 
		{
			player = ps.grabPlayerImage(2, 7, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.TACOBELL) 
		{
			player = ps.grabPlayerImage(2, 4, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.CAESAR) 
		{
			player = ps.grabPlayerImage(2, 5, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.ARBYS) 
		{
			player = ps.grabPlayerImage(2, 1, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.MCD) 
		{
			player = ps.grabPlayerImage(2, 3, 64, 64);
			return player;
		}
		return null;
	}
	public BufferedImage getPlayerLeft() 
{
		if (Game.PlayerFaction == Faction.FACTION.SUBWAY) 
		{
			player = ps.grabPlayerImage(3, 2, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.BRAUMS) 
		{
			player = ps.grabPlayerImage(3, 6, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.SONIC) 
		{
			player = ps.grabPlayerImage(3, 7, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.TACOBELL) 
		{
			player = ps.grabPlayerImage(3, 4, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.CAESAR) 
		{
			player = ps.grabPlayerImage(3, 5, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.ARBYS) 
		{
			player = ps.grabPlayerImage(3, 1, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.MCD) 
		{
			player = ps.grabPlayerImage(3, 3, 64, 64);
			return player;
		}
		return null;
	}
	public BufferedImage getPlayerRight() 
	{
		if (Game.PlayerFaction == Faction.FACTION.SUBWAY) 
		{
			player = ps.grabPlayerImage(4, 2, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.BRAUMS) 
		{
			player = ps.grabPlayerImage(4, 6, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.SONIC) 
		{
			player = ps.grabPlayerImage(4, 7, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.TACOBELL) 
		{
			player = ps.grabPlayerImage(4, 4, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.CAESAR) 
		{
			player = ps.grabPlayerImage(4, 5, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.ARBYS) 
		{
			player = ps.grabPlayerImage(4, 1, 64, 64);
			return player;
		}
		if (Game.PlayerFaction == Faction.FACTION.MCD) 
		{
			player = ps.grabPlayerImage(4, 3, 64, 64);
			return player;
		}
		return null;
	}
	public BufferedImage getStartingMap() 
	{

		if (Game.PlayerFaction == Faction.FACTION.SUBWAY) 
		{
			startingMap = ms.grabMapImage(2, 1, 600, 600);
			return startingMap;
		}
		if (Game.PlayerFaction == Faction.FACTION.BRAUMS) 
		{
			startingMap = ms.grabMapImage(9, 7, 600, 600);
			return startingMap;
		}
		if (Game.PlayerFaction == Faction.FACTION.SONIC) 
		{
			startingMap = ms.grabMapImage(8, 2, 600, 600);
			return startingMap;
		}
		if (Game.PlayerFaction == Faction.FACTION.TACOBELL) 
		{
			startingMap = ms.grabMapImage(1, 11, 600, 600);
			return startingMap;
		}
		if (Game.PlayerFaction == Faction.FACTION.CAESAR) 
		{
			startingMap = ms.grabMapImage(7, 12, 600, 600);
			return startingMap;
		}
		if (Game.PlayerFaction == Faction.FACTION.ARBYS) 
		{
			startingMap = ms.grabMapImage(5, 9, 600, 600);
			return startingMap;
		}
		if (Game.PlayerFaction == Faction.FACTION.MCD) 
		{
			startingMap = ms.grabMapImage(4, 6, 600, 600);
			return startingMap;
		}
		return null;
	}
	public BufferedImage getDBullet() 
	{
		if (Game.PlayerFaction == Faction.FACTION.SUBWAY) 
		{
			missle = bs.grabBulletImage(8, 1, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.BRAUMS) 
		{
			missle = bs.grabBulletImage(4, 3, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.SONIC) 
		{
			missle = bs.grabBulletImage(5, 1, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.TACOBELL) 
		{
			missle = bs.grabBulletImage(1, 2, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.CAESAR) 
		{
			missle = bs.grabBulletImage(2, 1, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.ARBYS) 
		{
			missle = bs.grabBulletImage(6, 1, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.MCD) 
		{
			missle = bs.grabBulletImage(4, 1, 32, 32);
			return missle;
		}
		return null;
	}
	public BufferedImage getUBullet() 
	{
		if (Game.PlayerFaction == Faction.FACTION.SUBWAY) 
		{
			missle = bs.grabBulletImage(8, 1, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.BRAUMS) 
		{
			missle = bs.grabBulletImage(3, 1, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.SONIC) 
		{
			missle = bs.grabBulletImage(5, 1, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.TACOBELL) 
		{

			missle = bs.grabBulletImage(1, 2, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.CAESAR) 
		{
			missle = bs.grabBulletImage(2, 1, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.ARBYS) 
		{
			missle = bs.grabBulletImage(6, 1, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.MCD) 
		{
			missle = bs.grabBulletImage(4, 1, 32, 32);
			return missle;
		}
		return null;
	}
	public BufferedImage getLBullet() 
	{
		if (Game.PlayerFaction == Faction.FACTION.SUBWAY) 
		{
			missle = bs.grabBulletImage(4, 2, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.BRAUMS) 
		{
			missle = bs.grabBulletImage(7, 2, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.SONIC) 
		{
			missle = bs.grabBulletImage(5, 3, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.TACOBELL) 
		{
			missle = bs.grabBulletImage(6, 2, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.CAESAR) 
		{
			missle = bs.grabBulletImage(2, 1, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.ARBYS) 
		{
			missle = bs.grabBulletImage(6, 1, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.MCD) 
		{
			missle = bs.grabBulletImage(8, 2, 32, 32);
			return missle;
		}
		return null;
	}
	public BufferedImage getRBullet() 
{
		if (Game.PlayerFaction == Faction.FACTION.SUBWAY) 
		{
			missle = bs.grabBulletImage(4, 2, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.BRAUMS) 
		{
			missle = bs.grabBulletImage(3, 3, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.SONIC) 
		{
			missle = bs.grabBulletImage(5, 3, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.TACOBELL) 
		{
			missle = bs.grabBulletImage(6, 2, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.CAESAR) 
		{
			missle = bs.grabBulletImage(2, 1, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.ARBYS) 
		{
			missle = bs.grabBulletImage(6, 1, 32, 32);
			return missle;
		}
		if (Game.PlayerFaction == Faction.FACTION.MCD) 
		{
			missle = bs.grabBulletImage(8, 2, 32, 32);
			return missle;
		}
		return null;
	}
	public BufferedImage getEnemyBullet() 
	{
		missle = bs.grabBulletImage(1, 1, 32, 32);
		return missle;
	}
	public BufferedImage getEnemy() 
	{
		if (Map.Location == Map.MAP.a1) 
		{
			enemy = ps.grabPlayerImage(1, 2, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.a2) 
		{
			enemy = ps.grabPlayerImage(1, 2, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.b1) 
		{
			enemy = ps.grabPlayerImage(1, 2, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.b2) 
		{
			enemy = ps.grabPlayerImage(1, 2, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.h4) 
		{
			enemy = ps.grabPlayerImage(1, 1, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.i3) 
		{
			enemy = ps.grabPlayerImage(1, 1, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.i4) 
		{
			enemy = ps.grabPlayerImage(1, 1, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.i5) 
		{
			enemy = ps.grabPlayerImage(1, 1, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.j3) 
		{
			enemy = ps.grabPlayerImage(1, 1, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.j4) 
		{
			enemy = ps.grabPlayerImage(1, 1, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.j5) 
		{
			enemy = ps.grabPlayerImage(1, 1, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.e4) 
		{
			enemy = ps.grabPlayerImage(1, 3, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.f4) 
		{
			enemy = ps.grabPlayerImage(1, 3, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.g4) 
		{
			enemy = ps.grabPlayerImage(1, 3, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.f5) 
		{
			enemy = ps.grabPlayerImage(1, 3, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.f8) 
		{
			enemy = ps.grabPlayerImage(1, 6, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.f9) 
		{
			enemy = ps.grabPlayerImage(1, 6, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.f10) 
		{
			enemy = ps.grabPlayerImage(1, 6, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.g5) 
		{
			enemy = ps.grabPlayerImage(1, 3, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.g8) 
		{
			enemy = ps.grabPlayerImage(1, 6, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.g9) 
		{
			enemy = ps.grabPlayerImage(1, 6, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.g10) 
		{
			enemy = ps.grabPlayerImage(1, 6, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.e5) 
		{
			enemy = ps.grabPlayerImage(1, 3, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.h8) 
		{
			enemy = ps.grabPlayerImage(1, 6, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.h9) 
		{
			enemy = ps.grabPlayerImage(1, 6, 64, 64);
			return enemy;

		}
		if (Map.Location == Map.MAP.i1) 
		{
			enemy = ps.grabPlayerImage(1, 4, 64, 64);
			return enemy;
		}

		if (Map.Location == Map.MAP.i2) 
		{
			enemy = ps.grabPlayerImage(1, 4, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.j1) 
		{
			enemy = ps.grabPlayerImage(1, 4, 64, 64);
			return enemy;
		}

		if (Map.Location == Map.MAP.j2) 
		{
			enemy = ps.grabPlayerImage(1, 4, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.k1) 
		{
			enemy = ps.grabPlayerImage(1, 4, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.k2) 
		{
			enemy = ps.grabPlayerImage(1, 4, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.l1) 
		{
			enemy = ps.grabPlayerImage(1, 4, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.l2) 
		{
			enemy = ps.grabPlayerImage(1, 4, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.l6) 
		{
			enemy = ps.grabPlayerImage(1, 5, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.l7) 
		{
			enemy = ps.grabPlayerImage(1, 5, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.l8) 
		{
			enemy = ps.grabPlayerImage(1, 5, 64, 64);
			return enemy;
		}
		if (Map.Location == Map.MAP.l9) 
		{
			enemy = ps.grabPlayerImage(1, 5, 64, 64);
			return enemy;
		}
		return null;
	}
	public BufferedImage getDrops() 
	{
		drop = bs.grabBulletImage(8, 3, 32, 32);
		return drop;
	}
	public Image getBullet() 
	{
		return null;
	}
}