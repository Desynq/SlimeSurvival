package net.slimesurvival.addons.carpet.script.api;

import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import carpet.script.Expression;
import carpet.script.value.ListValue;
import carpet.script.value.NumericValue;
import carpet.script.value.Value;
import net.minecraft.nbt.NbtHelper;

public class UUIDUtils {

	// copy and paste regex go brrr
	private static final Pattern UUID_REGEX = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");

	public static void apply(Expression expression) {

		expression.addContextFunction("uuid_to_int_array", 1, (c, t, lv) -> {
			String string = lv.get(0).getString();
			if (!UUID_REGEX.matcher(string).matches()) {
				return Value.NULL;
			}

			UUID uuid = UUID.fromString(string);
			return ListValue.wrap(NbtHelper.fromUuid(uuid).stream().map(nbtint -> NumericValue.of(nbtint.intValue())).collect(Collectors.toList()));
		});
	}
}
