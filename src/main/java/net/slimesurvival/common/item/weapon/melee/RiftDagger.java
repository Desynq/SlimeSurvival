package net.slimesurvival.common.item.weapon.melee;

import net.minecraft.item.SwordItem;
import net.slimesurvival.common.item.SSToolMaterials;
import net.slimesurvival.common.registry.ModItemGroups;

public class RiftDagger extends SwordItem {

	public RiftDagger(Settings settings) {
		super(SSToolMaterials.MYSTITE, 14, 1.0F, settings
			.group(ModItemGroups.WEAPONS)
			.fireproof()
		);
	}
}
