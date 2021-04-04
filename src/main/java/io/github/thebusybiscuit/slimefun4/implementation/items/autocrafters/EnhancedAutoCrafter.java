package io.github.thebusybiscuit.slimefun4.implementation.items.autocrafters;

import io.github.thebusybiscuit.slimefun4.implementation.items.multiblocks.EnhancedCraftingTable;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * The {@link EnhancedAutoCrafter} is an implementation of the {@link AbstractAutoCrafter}.
 * It can craft items that are crafted using the {@link EnhancedCraftingTable}.
 *
 * @author TheBusyBiscuit
 *
 * @see AbstractAutoCrafter
 * @see VanillaAutoCrafter
 * @see SlimefunItemRecipe
 *
 */
public class EnhancedAutoCrafter extends SlimefunAutoCrafter {

    @ParametersAreNonnullByDefault
    public EnhancedAutoCrafter(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe, RecipeType.ENHANCED_CRAFTING_TABLE);
    }

}