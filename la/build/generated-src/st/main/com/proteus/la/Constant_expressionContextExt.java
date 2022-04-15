package com.proteus.la;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LAParser.*;

public abstract class Constant_expressionContextExt extends AbstractBaseExtendedContext{

	public Constant_expressionContextExt(Constant_expressionContext ctx) {
		super("la", new LAParser(null), new LALexer(null), ctx, new LAParserExtendedContextVisitor());
	}
	public abstract Long eval() throws Exception;
}