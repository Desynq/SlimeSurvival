package net.slimesurvival.common.item.shield;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class DragonShield extends FabricShieldItem {
	public int cooldownTicks = 20;

	public DragonShield(Settings settings, int cooldownTicks, int enchantability, Item[] repairItems) {
		super(settings, 20, 15, Items.NETHERITE_INGOT);
	}
}
