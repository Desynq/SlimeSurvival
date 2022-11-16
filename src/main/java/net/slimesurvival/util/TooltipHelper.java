package net.slimesurvival.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.slimesurvival.util.settings.ExtendableTooltipSettings;

public class TooltipHelper {
	public static final Text SHOW_DETAILS_TOOLTIP = new TranslatableText("tooltip.slimesurvival.show_details");
	public static final Text SHOW_HOW_TO_OBTAIN_TOOLTIP = new TranslatableText("tooltip.slimesurvival.show_how_to_obtain");
	public static final Text SHOW_LORE = new TranslatableText("tooltip.slimesurvival.show_lore");
	public static final Text SHOW_CREDITS = new TranslatableText("tooltip.slimesurvival.show_credits");



	public static void append(List<Text> tooltip, String translationKey) {
		String[] lines = I18n.translate(translationKey).split("\n");
		ArrayList<Text> texts = new ArrayList<Text>();

		for (String line : lines) {
			texts.add(new LiteralText(line));
		}

		tooltip.addAll(texts);
	}






	public static void addExtendableTooltip(List<Text> tooltip, ExtendableTooltipSettings tooltipSettings) {
		boolean hasDetails = tooltipSettings.hasDetails;
		boolean hasHowToObtain = tooltipSettings.hasHowToObtain;
		boolean hasLore = tooltipSettings.hasDetails;
		boolean hasCredits = tooltipSettings.hasCredits;
		String translationKey = tooltipSettings.translationKey;

		if (hasCredits && Screen.hasControlDown() && Screen.hasAltDown()) {
			TooltipHelper.append(tooltip, translationKey + ".credits");
		} else if (hasDetails && Screen.hasShiftDown()) {
			TooltipHelper.append(tooltip, translationKey + ".details");
		} else if (hasHowToObtain && Screen.hasControlDown()) {
			TooltipHelper.append(tooltip, translationKey + ".how_to_obtain");
		} else if (hasLore && Screen.hasAltDown()) {
			TooltipHelper.append(tooltip, translationKey + ".lore");
		} else {
			if (hasCredits) {
				TooltipHelper.append(tooltip, ".tooltip");
			}
			if (hasDetails) {
				tooltip.add(TooltipHelper.SHOW_DETAILS_TOOLTIP);
			}
			if (hasHowToObtain) {
				tooltip.add(TooltipHelper.SHOW_HOW_TO_OBTAIN_TOOLTIP);
			}
			if (hasLore) {
				tooltip.add(TooltipHelper.SHOW_LORE);
			}
			if (hasCredits) {
				tooltip.add(TooltipHelper.SHOW_CREDITS);
			}
		}
	}
}
