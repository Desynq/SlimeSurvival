package net.slimesurvival.util.settings;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.slimesurvival.SlimeSurvival;
import net.slimesurvival.common.item.SSItemGroups.Tabs;

public class ItemSettings {

	public static OwoItemSettings getPreset(Tabs tab) {
		return new OwoItemSettings().group(SlimeSurvival.TABBED_ITEM_GROUP).tab(tab.ordinal());
	}
}
