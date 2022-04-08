package com.proteus.framework;

import com.proteus.framework.app.AbstractBaseExtendedContext;

public interface IExtendedContextVisitor {
    public  AbstractBaseExtendedContext visit(org.antlr.v4.runtime.tree.ParseTree tree);
}
