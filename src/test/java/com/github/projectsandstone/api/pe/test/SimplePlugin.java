/**
 *      SandstoneAPI_PE - Minecraft Server Modding API (PE)
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2016 Sandstone <https://github.com/ProjectSandstone/>
 *      Copyright (c) contributors
 *
 *
 *      Permission is hereby granted, free of charge, to any person obtaining a copy
 *      of this software and associated documentation files (the "Software"), to deal
 *      in the Software without restriction, including without limitation the rights
 *      to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *      copies of the Software, and to permit persons to whom the Software is
 *      furnished to do so, subject to the following conditions:
 *
 *      The above copyright notice and this permission notice shall be included in
 *      all copies or substantial portions of the Software.
 *
 *      THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *      IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *      FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *      AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *      LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *      OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *      THE SOFTWARE.
 */
package com.github.projectsandstone.api.pe.test;

import com.github.projectsandstone.api.Game;
import com.github.projectsandstone.api.block.BlockType;
import com.github.projectsandstone.api.event.Listener;
import com.github.projectsandstone.api.event.init.ServerStartedEvent;
import com.github.projectsandstone.api.item.ItemTypes;
import com.github.projectsandstone.api.logging.Logger;
import com.github.projectsandstone.api.pe.block.PEBlockTypes;
import com.github.projectsandstone.api.pe.item.PEItemTypesKt;
import com.github.projectsandstone.api.plugin.Plugin;

import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

@Plugin(id = "projectsandstone.api.pe.test.SimplePlugin", version = "1.0")
public class SimplePlugin {

    private final Game game;
    private final Logger logger;

    @Inject
    public SimplePlugin(Game game, Logger logger) {
        this.game = game;
        this.logger = logger;
    }


    @Listener
    public void started(ServerStartedEvent event) {
        @Nullable BlockType entry = game.getRegistry().getEntry("minecraft:invisible_bedrock", BlockType.class);

        PEItemTypesKt.getCAMERA(ItemTypes.INSTANCE).getBlock();

        // check if platform uses Minecraft PE Sandstone API:
        // TODO: platform.getGameEdition() == GameEdition.POCKET
        boolean isPe;

        try {
            Class.forName("com.github.projectsandstone.api.pe.SandstonePE");
            isPe = true;
        }catch (ClassNotFoundException e) {
            isPe = false;
        }

        if(isPe) {
            logger.info("You are running Sandstone on a MC:PE Platform");

            logger.info("'%s' == '%s': '%s'", "minecraft:invisible_bedrock", "PEBlockTypes.INVISIBLE_BEDROCK",
                    entry == null ? "null" : Boolean.toString(entry == PEBlockTypes.INVISIBLE_BEDROCK)
            );
        } else {
            logger.info("You aren't running Sandstone on a MC:PE Platform");
        }
    }
}
