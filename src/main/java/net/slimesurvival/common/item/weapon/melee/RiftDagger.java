package net.slimesurvival.common.item.weapon.melee;

import net.minecraft.item.SwordItem;
import net.slimesurvival.common.registry.ModItemGroups;
import net.slimesurvival.common.registry.ModToolMaterials;

public class RiftDagger extends SwordItem {

	public RiftDagger(Settings settings) {
		super(ModToolMaterials.MYSTITE, 14, 1.0F, settings
			.group(ModItemGroups.WEAPONS)
			.fireproof()
		);
	}
}
