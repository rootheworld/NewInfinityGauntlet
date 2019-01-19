package com.common.items.stones;

import com.Main;
import net.minecraft.item.Item;
import com.tabs.InfinityTabs;
import com.util.IHasModel;
import com.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

public class MindStone extends Item implements IHasModel {

    public MindStone(String name) {
        setRegistryName(name);
        setCreativeTab(InfinityTabs.infinityTabs);
        setMaxStackSize(1);
        setMaxDamage(4500);

        ModItems.ITEMS.add(this);
    }

    public String getItemStackDisplayName(ItemStack stack) {
        return TextFormatting.BOLD + "Mind Stone";
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
