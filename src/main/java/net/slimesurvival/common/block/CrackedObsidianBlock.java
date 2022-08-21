package net.slimesurvival.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class CrackedObsidianBlock extends Block {
	public static final IntProperty HEALTH = IntProperty.of("health", 1, 7);

	public CrackedObsidianBlock() {
		super(Settings.of(Material.STONE, MapColor.BLACK).requiresTool().strength(50.0F, 1200.0F));
		setDefaultState(getStateManager().getDefaultState().with(HEALTH, 7));
	}


	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(HEALTH);
	}
}
