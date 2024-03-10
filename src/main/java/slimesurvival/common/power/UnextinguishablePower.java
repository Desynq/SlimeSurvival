package slimesurvival.common.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.calio.data.SerializableData;
import net.minecraft.entity.LivingEntity;
import slimesurvival.SlimeSurvival;

public class UnextinguishablePower extends Power {
	
	public UnextinguishablePower(PowerType<?> type, LivingEntity livingEntity) {
		super(type, livingEntity);
	}

	public static PowerFactory<?> getFactory() {
		return new PowerFactory<UnextinguishablePower>(
			SlimeSurvival.ID("unextinguishable"),
			new SerializableData(),
			data -> (type, livingEntity) -> new UnextinguishablePower(type, livingEntity)
		).allowCondition();
	}
}
