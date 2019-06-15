package io.github.famous1622.killtherng;

import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class RNGEntityMethodVisitor extends MethodVisitor {
    public RNGEntityMethodVisitor(MethodVisitor mv) {
        super(ASM5, mv);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        if (owner.equals("java/util/Random") && name.equals("<init>") && desc.equals("()V")) {
            super.visitLdcInsn(0L);
            super.visitMethodInsn(opcode, owner, name, "(J)V", itf);
        } else if (desc.equals("(Ljava/util/Random;)Ljava/util/UUID;")) {
            super.visitInsn(POP);
            super.visitTypeInsn(NEW, "java/util/Random");
            super.visitInsn(DUP);
            super.visitMethodInsn(INVOKESPECIAL, "java/util/Random", "<init>", "()V", false);
            super.visitMethodInsn(opcode, owner, name, desc, itf);
            System.out.println("Applied UUID patch OwO");
        } else {
            super.visitMethodInsn(opcode, owner, name, desc, itf);
        }
    }
}
