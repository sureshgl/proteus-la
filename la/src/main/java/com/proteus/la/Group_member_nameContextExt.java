package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Group_member_nameContextExt extends AbstractBaseExtendedContext{

	public Group_member_nameContextExt(Group_member_nameContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Group_member_nameContext getLatestContext(){
		return (Group_member_nameContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Group_member_nameContext getContext(String str){
		return (Group_member_nameContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).group_member_name());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Group_member_nameContext){
				addToContexts((Group_member_nameContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Group_member_nameContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}