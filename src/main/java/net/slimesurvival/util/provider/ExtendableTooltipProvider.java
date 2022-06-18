package net.slimesurvival.util.provider;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public interface ExtendableTooltipProvider {
	Text SHOW_DETAILS_TOOLTIP = new TranslatableText("item.slimesurvival.tooltip.show_details");
	Text SHOW_HOW_TO_OBTAIN_TOOLTIP = new TranslatableText("item.slimesurvival.tooltip.show_how_to_obtain");

	String tooltipTranslationKey();

	default boolean hasExtendedTooltip() {
		return true;
	}
	default boolean hasDetails() {
		return false;
	}
	default boolean hasHowToObtain() {
		return false;
	}



	default void tryAppend(List<Text> tooltip, Integer details, Integer howToObtain) {
		if (!hasExtendedTooltip()) return;

		if (hasDetails() && Screen.hasShiftDown()) {
			for (int i = 0; i < details; i++) {
				append(tooltip, ".details" + i);
			}
		} else if (hasHowToObtain() && Screen.hasControlDown()) {
			for (int i = 0; i < howToObtain; i++) {
				append(tooltip, ".how_to_obtain" + i);
			}
		} else {
			if (hasDetails()) tooltip.add(SHOW_DETAILS_TOOLTIP);
			if (hasHowToObtain()) tooltip.add(SHOW_HOW_TO_OBTAIN_TOOLTIP);
		}
	}



	default void append(List<Text> tooltip, String type) {
		String[] lines = I18n.translate(tooltipTranslationKey() + type).split("\n");
		ArrayList<Text> texts = new ArrayList<Text>();

		for (String line : lines) {
			texts.add(new LiteralText(line));
		}

		tooltip.addAll(texts);
	}
}
