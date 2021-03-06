package com.igauntlet.init;


import com.igauntlet.world.dimension.dwarf.WorldProviderDwarf;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class InfinityDimensions {
    public static final DimensionType DWARF = DimensionType.register("Dwarf", "_dwarf", InfinityConfig.Dimensions.DwarfDimensionID, WorldProviderDwarf.class, false);

    public static void registerDimensions() {
        DimensionManager.registerDimension(InfinityConfig.Dimensions.DwarfDimensionID, DWARF);
    }
}
