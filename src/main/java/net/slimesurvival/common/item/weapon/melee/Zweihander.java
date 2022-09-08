package net.slimesurvival.common.item.weapon.melee;

import net.minecraft.item.SwordItem;
import net.slimesurvival.common.registry.ModItemGroups;
import net.slimesurvival.common.registry.ModToolMaterials;

public class Zweihander extends SwordItem {

	public Zweihander(Settings settings) {
		super(ModToolMaterials.MYSTITE, 29, -2.8F, settings
			.group(ModItemGroups.WEAPONS)
		);
	}
}
