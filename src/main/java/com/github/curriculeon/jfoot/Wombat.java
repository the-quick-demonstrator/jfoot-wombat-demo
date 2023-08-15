package com.github.curriculeon.jfoot;

import static com.github.curriculeon.jfoot.Direction.*;

/**
 * Wombat. A Wombat moves forward until it hits the edge of the world, at
 * which point it turns left. If a wombat finds a leaf, it eats it.
 *
 * @author Michael Kölling
 * @version 2.0
 */
public class Wombat extends Herbivore {
    public Wombat() {
        setImage("wombat.png");
    }

    public void act() {
        if (this.foundLeaf()) { // found leaf
            this.eatLeaf();
        } else if (this.canMove()) { // no leaf is found & can move
            this.move();
        } else { // no leaf is found and can't move
            if (this.getDirection() == EAST) {
                this.turnLeft();
                this.move();
                this.turnLeft();
            } else if (this.getDirection() == WEST) { // NOT FACING EAST AND IS FACING WEST
                this.turnRight();
                this.move();
                this.turnRight();
            }

            if (isAtTopLeft()) {
                this.setDirection(SOUTH);
            }

            if(isAtBottomLeft()) {
                this.setDirection(EAST);
            }
        }
    }

    private boolean isAtBottomLeft() {
        return !canMove(SOUTH) && canMove(EAST);
    }

    private boolean isAtTopLeft() {
        return !canMove(NORTH) && !canMove(WEST);
    }

    private boolean canMove(Direction direction) {
        Direction originalDirection = getDirection();
        setDirection(direction);
        boolean canMove = canMove();
        setDirection(originalDirection);
        return canMove;
    }

    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    public void turnLeft() {
        if (this.getDirection() == EAST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == WEST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(WEST);
        } else {
            this.setDirection(EAST);
        }
    }
}
