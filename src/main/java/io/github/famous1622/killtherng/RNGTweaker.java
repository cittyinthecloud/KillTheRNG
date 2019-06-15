package io.github.famous1622.killtherng;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

import java.io.File;
import java.util.List;

// Not unused, we're writing an FML mod not a Forge mod
@SuppressWarnings("unused")
public class RNGTweaker implements ITweaker {

    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {

    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {
        classLoader.addTransformerExclusion("io.github.famous1622.");
        classLoader.registerTransformer(RNGTransformer.class.getName());
        System.out.println("Injected KillTheRNG");
    }

    @Override
    public String getLaunchTarget() {
        return null;
    }

    @Override
    public String[] getLaunchArguments() {
        return new String[0];
    }
}