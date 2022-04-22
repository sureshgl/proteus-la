package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Chain_definitionContextExt extends AbstractBaseExtendedContext {

	private Long currLoc;
	private Long[] nibbleMask = { -1L, -1L, -1L, -1L, -1L, -1L, -1L, -1L, -1L, -1L, -1L, -1L, -1L, -1L, -1L, -1L };
	private Long[] nibbleSize = { 4L, 4L, 4L, 4L, 4L, 4L, 4L, 4L, 4L, 4L, 4L, 4L, 4L, 4L, 4L, 4L };

	public Chain_definitionContextExt(Chain_definitionContext ctx) {
		super("la", new LAParser(null), new LALexer(null), ctx, new LAParserExtendedContextVisitor());
		localSymbolTable = new SymbolTable();
		currLoc = 0L;
	}

	/*
	 * Create a context for the given string with extended context populated in that
	 */
	@Override
	public Chain_definitionContext getLatestContext() {
		return (Chain_definitionContext) super.getLatestContext();
	}

	/*
	 * Create a context for the given string with extended context populated in that
	 */
	@Override
	public Chain_definitionContext getContext(String str) {
		return (Chain_definitionContext) new LAParserPopulateExtendedContextVisitor()
				.visit(((LAParser) getParser(str)).chain_definition());
	}

	@Override
	public void setContext(ParserRuleContext ctx) {
		if (ctx != null) {
			if (ctx instanceof Chain_definitionContext) {
				addToContexts((Chain_definitionContext) ctx);
			} else {
				throw new ClassCastException(
						ctx.getClass().getSimpleName() + " cannot be cased to " + Chain_definitionContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	@Override
	public void PopulateSymbolTable(SymbolTable symbolTable) {
		super.PopulateSymbolTable(localSymbolTable);
		Chain_nameContext chain_nameContext = getLatestContext().chain_name();
		String chainName = chain_nameContext.extendedContext.getName();
		symbolTable.put(chainName, this);
	}

	@Override
	public void processFieldReferences() {
		// Stop further processing on this branch- as that is no-op
		return;
	}

	public Long getCurrLoc() {
		return this.currLoc;
	}

	public void updateCurrLoc(Long value) {
		this.currLoc = value;
	}

	public Long[] getNibbleMask() {
		return this.nibbleMask;
	}

	public Long[] getNibbleSize() {
		return this.nibbleSize;
	}

	@Override
	public void Initialize() throws Exception {
		for (int i = 0; i < nibbleMask.length; i++) {
			nibbleMask[i] = Utils.getNibbleMask(Long.valueOf(i), 0L);
		}
		super.Initialize();
	}

}
