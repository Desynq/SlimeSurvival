package net.slimesurvival.common.item.weapon.ranged;

import net.minecraft.item.BowItem;
import net.projectile_damage.api.IProjectileWeapon;
import net.slimesurvival.common.registry.ModItemGroups;

public class ZeusBow extends BowItem {
	
	public ZeusBow(Settings settings) {
		super(settings
			.group(ModItemGroups.WEAPONS)
			.maxDamage(1337)
		);
		((IProjectileWeapon) this).setProjectileDamage(7.5f);
	}
}
