package diamondshield;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ShieldItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item DIAMOND_SHIELD = Registry.register(
            Registries.ITEM,
            Identifier.of(DiamondShieldMod.MOD_ID, "diamond_shield"),
            new ShieldItem(new Item.Settings().maxDamage(850))
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register(entries -> entries.add(DIAMOND_SHIELD));
    }
}
