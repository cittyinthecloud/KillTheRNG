package io.github.famous1622.killtherng;

import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM5;

public class RNGMethodVisitor extends MethodVisitor {
    public RNGMethodVisitor(MethodVisitor mv) {
        super(ASM5, mv);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        if (owner.equals("java/util/Random") && name.equals("<init>") && desc.equals("()V")) {
            super.visitLdcInsn(0L);
            super.visitMethodInsn(opcode, owner, name, "(J)V", itf);
        } else {
            super.visitMethodInsn(opcode, owner, name, desc, itf);
        }

    }
}
