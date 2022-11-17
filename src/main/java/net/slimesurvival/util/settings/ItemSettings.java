package net.slimesurvival.util.settings;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.slimesurvival.SlimeSurvival;
import net.slimesurvival.common.item.SSItemGroups;

public class ItemSettings {

	public static final OwoItemSettings MATERIAL = new OwoItemSettings()
	.group(SlimeSurvival.TABBED_ITEM_GROUP)
	.tab(SSItemGroups.Tabs.MATERIALS.ordinal());

	public static final OwoItemSettings MISC = new OwoItemSettings()
	.group(SlimeSurvival.TABBED_ITEM_GROUP)
	.tab(SSItemGroups.Tabs.MISC.ordinal());

	public static final OwoItemSettings TOOLS = new OwoItemSettings()
	.group(SlimeSurvival.TABBED_ITEM_GROUP)
	.tab(SSItemGroups.Tabs.TOOLS.ordinal())
	.maxCount(1);

	public static final OwoItemSettings ARMOR = new OwoItemSettings()
	.group(SlimeSurvival.TABBED_ITEM_GROUP)
	.tab(SSItemGroups.Tabs.ARMOR.ordinal());
}
