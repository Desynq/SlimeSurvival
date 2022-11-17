package net.slimesurvival.common.item.weapon.melee;

import net.minecraft.item.SwordItem;
import net.slimesurvival.common.item.SSToolMaterials;
import net.slimesurvival.common.registry.ModItemGroups;

public class SentientKatana extends SwordItem {

	public SentientKatana(Settings settings) {
		super(SSToolMaterials.MYSTITE, 19, -2.25F, settings
			.group(ModItemGroups.WEAPONS)
		);
	}
}
