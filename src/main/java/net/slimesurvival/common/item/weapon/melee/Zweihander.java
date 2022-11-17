package net.slimesurvival.common.item.weapon.melee;

import net.minecraft.item.SwordItem;
import net.slimesurvival.common.item.SSToolMaterials;
import net.slimesurvival.common.registry.ModItemGroups;

public class Zweihander extends SwordItem {

	public Zweihander(Settings settings) {
		super(SSToolMaterials.MYSTITE, 29, -2.8F, settings
			.group(ModItemGroups.WEAPONS)
		);
	}
}
