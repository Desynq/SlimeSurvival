package net.slimesurvival.common.item;

import net.minecraft.item.Item;
import net.slimesurvival.common.registry.ModItemGroups;

public class RawOrePieceItem extends Item {
	
	public RawOrePieceItem(Settings settings) {
		super(settings.group(ModItemGroups.MATERIALS));
	}
}
