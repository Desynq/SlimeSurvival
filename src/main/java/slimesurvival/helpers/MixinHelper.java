package slimesurvival.helpers;

import io.github.apace100.apoli.component.PowerHolderComponent;
import net.minecraft.entity.Entity;
import slimesurvival.common.power.UnextinguishablePower;

public class MixinHelper {
	
	public static boolean isUnextinguishable(Entity entity) {
		return PowerHolderComponent.hasPower(entity, UnextinguishablePower.class);
	}
}
