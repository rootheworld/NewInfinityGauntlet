package com.igauntlet.util.helpers;

import net.minecraft.entity.Entity;

public class EntityHelper
{
    public static boolean EntityIsFriend(Entity e) {
        return e.getEntityData().getBoolean("isfriend");
    }
}
