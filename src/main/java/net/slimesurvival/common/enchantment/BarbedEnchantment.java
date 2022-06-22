package net.slimesurvival.common.enchantment;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldEnchantment;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;

public class BarbedEnchantment extends FabricShieldEnchantment {
	
	public BarbedEnchantment(Rarity weight, boolean isTreasure, boolean isCurse) {
		super(weight, isTreasure, isCurse);
	}



	@Override
	public int getMinPower(int level) {
		return 0;
	}

	@Override
	public int getMaxPower(int level) {
		return 50;
	}

	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		return super.isAcceptableItem(stack) && stack.getItem() instanceof ShieldItem;
	}
}
