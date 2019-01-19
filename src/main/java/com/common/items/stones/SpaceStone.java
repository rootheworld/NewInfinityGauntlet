package com.common.items.stones;

import com.Main;
import net.minecraft.item.Item;
import com.tabs.InfinityTabs;
import com.util.IHasModel;
import com.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

public class SpaceStone extends Item implements IHasModel {

    public SpaceStone(String name) {
        setRegistryName(name);
        setCreativeTab(InfinityTabs.infinityTabs);
        setMaxStackSize(1);
        setMaxDamage(4500);

        ModItems.ITEMS.add(this);
    }

    public String getItemStackDisplayName(ItemStack stack) {
        return TextFormatting.BOLD + "Space Stone";
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
