package tile;

import java.awt.Graphics;

import Catio.Handler;
import Catio.Id;

public abstract class Tile {
	public int x,y;
	public int width, height;
	public int velX, velY;
	
	public Id id;
	public Handler handler;
	
	public boolean solid;
	
	public Tile(int x, int y, int width, int height, boolean solid, Id id, Handler handler){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.solid = solid;
		this.id = id;
		this.handler = handler;
	}
	
	public abstract void render(Graphics g);
	public abstract void tick();
	
	
	public void die(){
		handler.removeTile(this);
	}
	
	public Id getId(){
		return id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isSolid() {
		return solid;
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	
}
