package com.proteus.la;

import com.proteus.framework.app.*;
import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Constant_expressionContextExt extends AbstractBaseExtendedContext{

	public Constant_expressionContextExt(Constant_expressionContext ctx) {
		super("la", new LAParser(null), new LALexer(null), new LAParserExtendedContextVisitor());
		addToContexts(ctx);
		parent = ctx;
	}

	@Override
	public Constant_expressionContext getContext(){
		throw new UnsupportedOperationException("Alt rule should not call the base class method");
	}

	@Override
	public ParserRuleContext getContext(String str){
		throw new UnsupportedOperationException("Alt rule should not call the base class method");
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		throw new UnsupportedOperationException("Alt rule should not call the base class method");
	}

}