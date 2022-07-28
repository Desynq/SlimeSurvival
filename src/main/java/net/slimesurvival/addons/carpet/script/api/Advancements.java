package net.slimesurvival.addons.carpet.script.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import carpet.script.CarpetContext;
import carpet.script.Expression;
import carpet.script.exception.InternalExpressionException;
import carpet.script.utils.InputValidator;
import carpet.script.value.ListValue;
import carpet.script.value.StringValue;
import carpet.script.value.Value;
import net.minecraft.advancement.Advancement;

public class Advancements {

	public static void apply(Expression expression) {

		expression.addContextFunction("advancement", -1, (c, t, lv) -> {
			CarpetContext cc = (CarpetContext) c;
			List<String> validArguments = new ArrayList<String>();
			validArguments.add("title");
			validArguments.add("description");
			validArguments.add("frame");
			validArguments.add("parent");
			validArguments.add("children");


			if (lv.size() == 1) return ListValue.wrap(validArguments.stream().map(StringValue::new).collect(Collectors.toList()));
			if (lv.size() != 2) throw new InternalExpressionException("Advancement-type argument should be defined by its identifier as a string and then by a string that defines what to get from the advancement");

			Advancement advancement = cc.s.getServer().getAdvancementLoader().get(InputValidator.identifierOf(lv.get(0).getString()));

			if (advancement == null) return Value.NULL;

			String arg2 = lv.get(1).getString();



			if (arg2.equals("title")) {
				return new StringValue(advancement.getDisplay().getTitle().getString());
			}
			if (arg2.equals("description")) {
				return new StringValue(advancement.getDisplay().getDescription().getString());
			}
			if (arg2.equals("frame")) {
				return new StringValue(advancement.getDisplay().getFrame().getId().toString());
			}


			if (arg2.equals("parent")) {
				return new StringValue(advancement.getParent().getId().toString());
			}
			if (arg2.equals("children")) {
				List<String> children = new ArrayList<String>();
				for (Advancement child : advancement.getChildren()) {
					children.add(child.getId().toString());
				}
				return ListValue.wrap(children.stream().map(StringValue::new).collect(Collectors.toList()));
			}

			return Value.NULL;
		});
	}
}
