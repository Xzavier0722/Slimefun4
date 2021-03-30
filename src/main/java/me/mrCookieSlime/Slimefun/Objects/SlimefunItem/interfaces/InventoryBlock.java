package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.interfaces;

import io.github.starwishsama.utils.IntegrationHelper;
import io.github.thebusybiscuit.cscorelib2.protection.ProtectableAction;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.lang.reflect.Array;
import java.util.function.Consumer;

@Deprecated
public interface InventoryBlock {

    /**
     * This method returns an {@link Array} of slots that serve as the input
     * for the {@link Inventory} of this block.
     *
     * @return The input slots for the {@link Inventory} of this block
     */
    int[] getInputSlots();

    /**
     * This method returns an {@link Array} of slots that serve as the output
     * for the {@link Inventory} of this block.
     *
     * @return The output slots for the {@link Inventory} of this block
     */
    int[] getOutputSlots();

    default void createPreset(SlimefunItem item, Consumer<BlockMenuPreset> setup) {
        createPreset(item, item.getItemName(), setup);
    }

    default void createPreset(SlimefunItem item, String title, Consumer<BlockMenuPreset> setup) {
        new BlockMenuPreset(item.getId(), title) {

            @Override
            public void init() {
                setup.accept(this);
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow) {
                if (flow == ItemTransportFlow.INSERT) return getInputSlots();
                else return getOutputSlots();
            }

            @Override
            public boolean canOpen(Block b, Player p) {
                return p.hasPermission("slimefun.inventory.bypass") ||
                        (SlimefunPlugin.getProtectionManager().hasPermission(p, b.getLocation(), ProtectableAction.INTERACT_BLOCK)
                                && Slimefun.hasUnlocked(p, item, false)
                                && IntegrationHelper.checkPermission(p, b, ProtectableAction.INTERACT_BLOCK)
                        );
            }
        };
    }
}
