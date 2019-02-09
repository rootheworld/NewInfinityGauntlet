package com.igauntlet.common.items;

import com.igauntlet.Infinity;
import com.igauntlet.init.ModItems;
import com.igauntlet.tabs.InfinityTabs;
import com.igauntlet.util.handlers.SoundsHandler;
import com.igauntlet.util.handlers.helpers.IHasModel;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;

public class MixTape extends ItemRecord implements IHasModel {



    public MixTape(String name, SoundEvent sound) {
        super(name, sound);
        setTranslationKey(name);
        setRegistryName(name);
        setMaxStackSize(1);
        setMaxDamage(4500);
        setCreativeTab(InfinityTabs.infinityTabs);

        ModItems.ITEMS.add(this);
    }

    @Override
    public SoundEvent getSound() {
        return SoundsHandler.AWESOMEMIX;
    }


    @Override
    public void registerModels() {
        Infinity.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
