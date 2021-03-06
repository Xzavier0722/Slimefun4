package io.github.thebusybiscuit.slimefun4.integrations;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.minebuilders.clearlag.Clearlag;
import me.minebuilders.clearlag.events.EntityRemoveEvent;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import javax.annotation.Nonnull;

/**
 * This handles all integrations with {@link Clearlag}.
 * We don't want it to clear our altar items.
 *
 * @author TheBusyBiscuit
 */
class ClearLagIntegration implements Listener {
    private final SlimefunPlugin plugin;

    ClearLagIntegration(@Nonnull SlimefunPlugin plugin) {
        this.plugin = plugin;
    }

    public void register() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onEntityRemove(EntityRemoveEvent e) {

        e.getEntityList().removeIf(n -> n instanceof Item && SlimefunUtils.hasNoPickupFlag((Item) n));
    }
}
