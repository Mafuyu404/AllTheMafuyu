package com.mafuyu404.allthemafuyu.event;

import com.mafuyu404.allthemafuyu.Allthemafuyu;
import com.mafuyu404.allthemafuyu.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collection;
import java.util.HashSet;

@Mod.EventBusSubscriber(modid = Allthemafuyu.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VariedModelSetup {
    private static final HashSet<ModelResourceLocation> cache = new HashSet<>();

    public static void putRegistryCache(ModelResourceLocation e) {
        cache.add(e);
    }

    @SubscribeEvent
    public static void onModelRegistry(ModelEvent.RegisterAdditional event) {
        if (!Config.VariedModel.LOAD_IDLE_MODEL.get()) return;

        ResourceManager resourceManager = Minecraft.getInstance().getResourceManager();
        String modelDir = "models/item"; // 目标目录

        // 遍历所有资源命名空间
        for (String namespace : resourceManager.getNamespaces()) {
            // 只处理当前Mod的资源
            // 获取models/item目录下的所有资源
            Collection<ResourceLocation> resources = resourceManager.listResources(modelDir,
                    location -> location.getPath().endsWith(".json") && location.getNamespace().equals(namespace)
            ).keySet();

            for (ResourceLocation rl : resources) {
                // 提取物品ID：从路径中移除目录和扩展名
                String path = rl.getPath();
                String itemId = path.substring(modelDir.length() + 1, path.length() - 5); // 移除"models/item/"和".json"

                // 构造模型资源位置并注册
                ResourceLocation modelLocation = new ResourceLocation(namespace, itemId);
                ModelResourceLocation result = new ModelResourceLocation(modelLocation, "inventory");
                if (!cache.contains(result)) {
                    Allthemafuyu.LOGGER.warn("Loaded model: {}", result);
                    event.register(result);
                }
            }
        }
    }
}
