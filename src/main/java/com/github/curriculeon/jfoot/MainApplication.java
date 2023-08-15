package com.github.curriculeon.jfoot;

import com.github.git_leon.jfoot.system.JFootApplication;
import greenfoot.Greenfoot;
import greenfoot.World;
import greenfoot.core.WorldHandler;

/**
 * @author leonhunter
 * @created 04/03/2020 - 3:59 PM
 */
public class MainApplication {
    public static void main(String[] args) {
        new JFootApplication().run();
        WombatWorld world = new WombatWorld();
        world.populate();
        Greenfoot.setWorld(world);
        Greenfoot.setSpeed(35);
        WorldHandler.getInstance().getWorld();
    }
}
