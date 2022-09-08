package net.slimesurvival.common.item.weapon.melee;

import net.minecraft.item.SwordItem;
import net.slimesurvival.common.registry.ModItemGroups;
import net.slimesurvival.common.registry.ModToolMaterials;

public class SentientKatana extends SwordItem {

	public SentientKatana(Settings settings) {
		super(ModToolMaterials.MYSTITE, 19, -2.25F, settings
			.group(ModItemGroups.WEAPONS)
		);
	}
}
