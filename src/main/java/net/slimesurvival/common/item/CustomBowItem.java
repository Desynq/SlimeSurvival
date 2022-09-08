package net.slimesurvival.common.item;

import net.minecraft.item.BowItem;

public class CustomBowItem extends BowItem {

	public CustomBowItem(Settings settings) {
		super(settings);
	}

	public double getBaseProjectileDamage() {
		return 0;
	}
}
