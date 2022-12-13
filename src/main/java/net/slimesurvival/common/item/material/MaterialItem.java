package net.slimesurvival.common.item.material;

import net.minecraft.item.Item;
import net.slimesurvival.common.item.SSItemGroups.Tabs;
import net.slimesurvival.util.settings.ItemSettings;

public class MaterialItem extends Item {

	public MaterialItem() {
		super(ItemSettings.getPreset(Tabs.MATERIALS));
	}
}
