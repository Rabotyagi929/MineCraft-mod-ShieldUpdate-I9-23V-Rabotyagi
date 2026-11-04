package diamondshield;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiamondShieldMod implements ModInitializer {
    public static final String MOD_ID = "diamondshield";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.initialize();

        // Принудительно снимаем прочность при блокировании
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
            if (entity instanceof PlayerEntity player && player.isUsingItem()) {
                ItemStack active = player.getActiveItem();
                if (active.isOf(ModItems.DIAMOND_SHIELD)) {
                    active.damage(1, player,
                            player.getActiveHand() == Hand.MAIN_HAND
                                    ? EquipmentSlot.MAINHAND
                                    : EquipmentSlot.OFFHAND);
                }
            }
            return true;
        });

        LOGGER.info("MineCraft-mod-ShieldUpdate-I9-23V-Rabotyagi loaded!");
    }
}
