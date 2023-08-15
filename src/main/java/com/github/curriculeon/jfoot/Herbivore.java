package com.github.curriculeon.jfoot;

import com.github.git_leon.jfoot.sprite.Sprite;
import com.github.git_leon.jfoot.sprite.SpriteCreatorRemover;
import greenfoot.Actor;

/**
 * @author Michael Kölling
 * @version 2.0
 */
public abstract class Herbivore extends Actor {
    private int leavesEaten;
    private Direction direction;

    public Herbivore() {
        setDirection(Direction.EAST);
        leavesEaten = 0;
    }

    /**
     * Move one step forward.
     */
    public final void move() {
        move(1);
    }

    /**
     * Check whether there is a leaf in the same cell as we are.
     * Return true, if there is, false otherwise.
     */
    public final boolean foundLeaf() {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        return leaf != null;
    }

    /**
     * Eat a leaf (if there is one in our cell).
     */
    public final void eatLeaf() {
        Actor leaf = getOneIntersectingObject(Leaf.class);
        SpriteCreatorRemover spriteCreatorRemover = new SpriteCreatorRemover(leaf);
        spriteCreatorRemover.destroy();
        leavesEaten = leavesEaten + 1;
    }

    /**
     * Set the direction we're facing. The 'direction' parameter must
     * be in the range [0..3].
     */
    private final void setDirection(int direction) {
        if ((direction >= 0) && (direction <= 3)) {
            setRotation(direction * 90);
        }
    }

    public final void setDirection(Direction direction) {
        System.out.println("Current Direction = " + getDirection());
        this.direction = direction;
        setDirection(direction.ordinal());
        System.out.println("New Direction = " + getDirection());
        System.out.println("=================================");
    }

    public Direction getDirection() {
        return this.direction;
    }

    public Boolean isAtTopEdge() {
        return getY() == 0;
    }

    public Boolean isAtBottomEdge() {
        return getY() == getWorld().getHeight();
    }

    /**
     * Test if we can move forward. Return true if we can, false otherwise.
     */
    public final boolean canMove() {
        int rotation = getRotation();
        int x = getX();
        int y = getY();
        boolean facingEdge = false;

        switch (rotation) {
            case 0:
                facingEdge = (x == getWorld().getWidth() - 1);
                break;
            case 90:
                facingEdge = (y == getWorld().getHeight() - 1);
                break;
            case 180:
                facingEdge = (x == 0);
                break;
            case 270:
                facingEdge = (y == 0);
                break;
        }

        return !facingEdge;
    }

    /**
     * Tell how many leaves we have eaten.
     */
    public final int getLeavesEaten() {
        return leavesEaten;
    }
}
