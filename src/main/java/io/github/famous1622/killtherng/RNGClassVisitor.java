package io.github.famous1622.killtherng;

import net.minecraftforge.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM5;

public class RNGClassVisitor extends ClassVisitor {
    private final String name;

    public RNGClassVisitor(ClassVisitor cv, String name) {
        super(ASM5, cv);
        this.name = name;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (FMLDeobfuscatingRemapper.INSTANCE.map(this.name).endsWith("Entity")) {
            System.out.println("Entity! UwU");
            return new RNGEntityMethodVisitor(mv);
        }
        return new RNGMethodVisitor(mv);
    }
}
