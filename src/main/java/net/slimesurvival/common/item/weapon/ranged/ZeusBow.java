package net.slimesurvival.common.item.weapon.ranged;

import net.slimesurvival.common.item.CustomBowItem;
import net.slimesurvival.common.registry.ModItemGroups;

public class ZeusBow extends CustomBowItem {
	
	public ZeusBow(Settings settings) {
		super(settings
			.group(ModItemGroups.WEAPONS)
			.maxDamage(1337)
		);
	}



	@Override
	public double getBaseProjectileDamage() {
		return 1.25;
	}
}
