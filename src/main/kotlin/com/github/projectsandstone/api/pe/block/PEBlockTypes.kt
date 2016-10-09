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
package com.github.projectsandstone.api.pe.block

import com.github.projectsandstone.api.block.BlockType
import com.github.projectsandstone.api.block.BlockTypes
import com.github.projectsandstone.api.util.extension.registry.uninitializedEntry

/**
 * Minecraft PE Block types.
 */
object PEBlockTypes {

    @JvmField
    val INVISIBLE_BEDROCK: BlockType = uninitializedEntry()

    @JvmField
    val GLOWING_OBSIDIAN: BlockType = uninitializedEntry()
}

val BlockTypes.INVISIBLE_BEDROCK: BlockType
    get() = PEBlockTypes.INVISIBLE_BEDROCK

val BlockTypes.GLOWING_OBSIDIAN: BlockType
    get() = PEBlockTypes.GLOWING_OBSIDIAN