package com.igauntlet.common.blocks;

import com.igauntlet.Infinity;
import com.igauntlet.common.tileentity.TileAshPile;
import com.igauntlet.init.InfinityBlocks;
import com.igauntlet.init.InfinityItems;
import com.igauntlet.tabs.InfinityTabs;
import com.igauntlet.util.helpers.IHasModel;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class AshPile extends BlockFalling implements IHasModel, ITileEntityProvider {


    public static final AxisAlignedBB DUST_AABB = new AxisAlignedBB(0.296875, 0, 0.296875, 0.6900, 0.1875 / 2, 0.6900);


    public AshPile(String name, Material material, boolean tab) {
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setSoundType(SoundType.SAND);
        setHardness(0.0F);
        setResistance(0.1F);
        setLightOpacity(1);

        if (tab)
            setCreativeTab(InfinityTabs.infinityTabs);

        InfinityBlocks.BLOCKS.add(this);
        InfinityItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }


    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return DUST_AABB;
    }


    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return DUST_AABB;
    }


    @Override
    public void registerModels() {
        Infinity.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }


    @Nullable
    @Override
    public TileEntity createNewTileEntity(World world, int data) {
        return new TileAshPile();
    }
}
