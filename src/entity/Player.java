package entity;

import java.awt.Color;
import java.awt.Graphics;

import Catio.Handler;
import Catio.Id;
import tile.Tile;

public class Player extends Entity{

	public Player(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
		
	}

	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		if(x<=0) x = 0;
		if(x+width >= 1000) x = 1000 - width;
		if(y+height >= 771) y = 771 - height;
		for(Tile t:handler.tile){
			if(!t.solid) break;
			if(t.getId() == Id.wall){
				if(getBoundsTop().intersects(t.getBounds())){
					setVelY(0);
					if(jumping){
						jumping = false;
						gravity = 0.0;
						falling = true;
					}
				} if(getBoundsBottom().intersects(t.getBounds())){
					setVelY(0);
					if(falling) falling = false;
					
				} if(getBoundsLeft().intersects(t.getBounds())){
					setVelX(0);
					x = t.getX()+t.width;
				} if(getBoundsRight().intersects(t.getBounds())){
					setVelX(0);
					x = t.getX()-t.width;
				} else { 
					if(!falling && !jumping){
						gravity = 0.0;
						falling = true;
					}
				}
				
			}
		}
		if(jumping){
			gravity -= 0.1;
			setVelY((int)-gravity);
			if(gravity <= 0.0){
				jumping = false;
				falling = true;
			}
		} else if(falling){
			gravity += 0.1;
			setVelY((int)gravity);
		}
	}
	
}
