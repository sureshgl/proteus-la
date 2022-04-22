package com.proteus.framework.app;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proteus.framework.IExtendedContextVisitor;
import com.proteus.framework.app.IGetFormattedText;

/* 
  This is a base Application implementing a feature "GetFormattedText".
*/

public abstract class AbstractBaseExtendedContext implements IGetFormattedText {
	protected static final Logger logger = LoggerFactory.getLogger(AbstractBaseExtendedContext.class);

	// variables
	protected String grammarName;
	protected Parser parser;
	protected Lexer lexer;
	protected ParserRuleContext ctx;
	/*
	 * extendedContextVisitor, always returns the extendedcontext of a latest
	 * transformation on that context
	 */
	protected IExtendedContextVisitor extendedContextVisitor; // TODO, this can be a static and can be initialied at app
																														// level.
	protected SymbolTable localSymbolTable;

	/*
	 * Context store the transformations on that contexts. These contexts list acts
	 * as global for all the transformations
	 * on this context. Every transformation should see the same list of contexts.
	 * This way we are flattening the depth of the transformations.
	 */
	private List<ParserRuleContext> contexts;
	protected ParserRuleContext parent; // TODO fix the parent logic.

	// abstract methods
	abstract public ParserRuleContext getContext(String str);

	abstract public void setContext(ParserRuleContext ctx);

	// constructor
	public AbstractBaseExtendedContext(String grammarName, Parser parser, Lexer lexer, ParserRuleContext ctx,
			IExtendedContextVisitor extendedContextVisitor) {
		this.grammarName = grammarName;
		this.parser = parser;
		this.lexer = lexer;
		this.ctx = ctx;
		this.parent = ctx.getParent();
		this.extendedContextVisitor = extendedContextVisitor;
		this.contexts = new ArrayList<ParserRuleContext>();
		contexts.add(this.ctx);
		this.localSymbolTable = null;
	}

	public ParserRuleContext getLatestContext() {
		if (contexts.size() == 0) {
			return ctx;
		} else {
			return contexts.get(contexts.size() - 1);
		}
	}

	// This method is not exposed outside.
	public Parser getParser(String str) {
		lexer.setInputStream(new ANTLRInputStream(str));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		parser.setTokenStream(tokens);
		return parser;
	}

	protected void addToContexts(ParserRuleContext context) {
		contexts.add(context);

		AbstractBaseExtendedContext extCtx = getExtendedContext(context);
		if (extCtx != null) {
			extCtx.contexts = contexts;
			extCtx.parent = parent;
		}
	}

	public AbstractBaseExtendedContext getExtendedContext(ParseTree context) {
		if (context != null) {
			return (AbstractBaseExtendedContext) extendedContextVisitor.visit(context);
		} else {
			return null;
		}
	}

	protected class Params {
		public Params(ParserRuleContext ctx, StringBuilder sb) {
			this.context = ctx;
			beginingOfAlignmentText = 0;
			input = ctx.start.getInputStream();
			this.stringBuilder = sb;
		}

		private ParserRuleContext context;
		private CharStream input;
		private StringBuilder stringBuilder;
		// private int endOfAlignmentText;
		private int beginingOfAlignmentText;

		public ParserRuleContext getContext() {
			return this.context;
		}

		public void setContext(ParserRuleContext context) {
			this.context = context;
		}

		public CharStream getInput() {
			return this.input;
		}

		public StringBuilder getStringBuilder() {
			return this.stringBuilder;
		}

		public int getBeginingOfAlignmentText() {
			return this.beginingOfAlignmentText;
		}

		public void setBeginingOfAlignmentText(int value) {
			this.beginingOfAlignmentText = value;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();

			sb.append("Context = " + context.getClass().getSimpleName() + "\n" + context.getText());
			sb.append("\n");
			sb.append("Text = " + stringBuilder.toString());
			sb.append("\n");
			sb.append("start =" + beginingOfAlignmentText);
			sb.append("\n");
			// sb.append("end = "+endOfAlignmentText);sb.append("\n");
			return sb.toString();
		}

	}

	// getFormattedText() app
	@Override
	public String getFormattedText() {
		StringBuilder sb = new StringBuilder();
		Params params = new Params(getLatestContext(), sb);
		params.setBeginingOfAlignmentText(getLatestContext().start.getStartIndex());
		getFormattedText(params);
		// logger.debug("output =\n" + sb.toString());
		return sb.toString();
	}

	protected void getFormattedText(Params params) {
		ParserRuleContext ctx = getLatestContext();
		if (ctx != null && ctx.children != null && ctx.children.size() > 0) {
			for (ParseTree childCtx : ctx.children) {
				if (childCtx instanceof TerminalNode) {
					printTerminalNode((TerminalNode) childCtx, params);
				} else if (childCtx.getText().length() > 0) {
					params.setContext((ParserRuleContext) childCtx);
					Params thisCtxParams = getExtendedContext(childCtx).getUpdatedParams(params);
					getExtendedContext(childCtx).getFormattedText(thisCtxParams);
				}
			}
			getUpdatedParams(params);
		}
	}

	/*
	 * check if they are pointing to the same char stream, else it resets the
	 * params with the new char stream params.
	 */

	private Params getUpdatedParams(Params params) {
		if (getLatestContext() == null) {
			// The item is removed during the transformation, hence skip its contents.
			String alignmentText = params.getInput()
					.getText(new Interval(params.getBeginingOfAlignmentText(), params.getContext().start.getStartIndex() - 1));
			params.getStringBuilder().append(alignmentText);
			params.setBeginingOfAlignmentText(params.getContext().stop.getStopIndex() + 1);
			return null;
		}
		if (getLatestContext().start.getInputStream() != params.getContext().start.getInputStream()) {
			/*
			 * advance the begining of alignment text, as we are going to consider
			 * 'mostRecentContext' in its place.
			 */
			if (params.beginingOfAlignmentText < params.getContext().start.getStartIndex()) {
				String alignmentText = params.getInput()
						.getText(new Interval(params.beginingOfAlignmentText, params.getContext().start.getStartIndex() - 1));
				params.getStringBuilder().append(alignmentText);
			}
			params.setBeginingOfAlignmentText(params.getContext().stop.getStopIndex() + 1);
			return new Params(getLatestContext(), params.getStringBuilder());
		} else {
			if (getLatestContext().parent == null) {
				String alignmentText = params.getInput()
						.getText(new Interval(params.beginingOfAlignmentText, params.getContext().start.getInputStream().size()));
				params.getStringBuilder().append(alignmentText);
			}
			params.setContext(getLatestContext());
			return params;
		}
	}

	private void printTerminalNode(TerminalNode node, Params params) {
		CharStream input = params.getContext().start.getInputStream();
		if (node.getText().equals("<EOF>")) {
			String end = input.getText(new Interval(params.getBeginingOfAlignmentText(), input.size()));
			params.getStringBuilder().append(end);
		} else {
			if (params.getBeginingOfAlignmentText() < node.getSymbol().getStartIndex()) {
				Interval alignmentTextInterval = new Interval(params.getBeginingOfAlignmentText(),
						node.getSymbol().getStartIndex() - 1);
				String alignmentText = input.getText(alignmentTextInterval);
				params.getStringBuilder().append(alignmentText);
			}
			params.getStringBuilder().append(node.getText());
			params.setBeginingOfAlignmentText(node.getSymbol().getStopIndex() + 1);
		}
	}

	public void PopulateSymbolTable(SymbolTable symbolTable) {
		ParserRuleContext ctx = getLatestContext();
		getExtendedContext(ctx).localSymbolTable = symbolTable;
		if (ctx != null && ctx.children != null && ctx.children.size() > 0) {
			for (ParseTree childCtx : ctx.children) {
				if (!(childCtx instanceof TerminalNode)) {
					if (childCtx.getText().length() > 0) {
						getExtendedContext(childCtx).PopulateSymbolTable(symbolTable);
					}
				}
			}
		}
	}

	// Driver to perform the semantic checks.
	public void SemanticCheck() {
		ParserRuleContext ctx = getLatestContext();
		if (ctx != null && ctx.children != null && ctx.children.size() > 0) {
			for (ParseTree childCtx : ctx.children) {
				if (!(childCtx instanceof TerminalNode)) {
					if (childCtx.getText().length() > 0) {
						getExtendedContext(childCtx).SemanticCheck();
					}
				}
			}
		}
	}

	protected Boolean initialized = false;

	// Use this step to initialize all the data structures in the AST.super.
	public void Initialize() throws Exception {
		if (!initialized) {
			ParserRuleContext ctx = getLatestContext();
			if (ctx != null && ctx.children != null && ctx.children.size() > 0) {
				for (ParseTree childCtx : ctx.children) {
					if (!(childCtx instanceof TerminalNode)) {
						if (childCtx.getText().length() > 0) {
							getExtendedContext(childCtx).Initialize();
						}
					}
				}
			}
			initialized = true;
		}
	}

	public AbstractBaseExtendedContext lookUp(String symbol) {
		AbstractBaseExtendedContext symbolExtendedContext = null;
		if (localSymbolTable != null) {
			symbolExtendedContext = localSymbolTable.get(symbol);
		}
		if (symbolExtendedContext == null) {
			if (parent != null) {
				return extendedContextVisitor.visit(parent).lookUp(symbol);
			} else {
				return null;
			}
		} else {
			return symbolExtendedContext;
		}
	}

	public AbstractBaseExtendedContext lookIn(String symbol) {
		return localSymbolTable.get(symbol);
	}

	// get chain_a.group_b.element_c.field_d -> fieldExtendedcontext of field_d
	public AbstractBaseExtendedContext getSymbol(String symbol) {
		if (symbol == null || symbol.length() == 0)
			return null;
		AbstractBaseExtendedContext abstractBaseExtendedContext = null;
		String[] args = symbol.split("\\.");
		abstractBaseExtendedContext = lookUp(args[0]); // LOOK UP

		for (int i = 1; i < args.length; i++) {
			if (abstractBaseExtendedContext != null) {
				abstractBaseExtendedContext = abstractBaseExtendedContext.lookIn(args[i]); // LOOK IN
			} else {
				return null;
			}
		}
		return abstractBaseExtendedContext;
	}

	public void processFieldReferences() {
		ParserRuleContext ctx = getLatestContext();
		if (ctx != null && ctx.children != null && ctx.children.size() > 0) {
			for (ParseTree childCtx : ctx.children) {
				if (!(childCtx instanceof TerminalNode)) {
					if (childCtx.getText().length() > 0) {
						getExtendedContext(childCtx).processFieldReferences();
					}
				}
			}
		}
	}

	public void symanticCheck() {
		ParserRuleContext ctx = getLatestContext();
		if (ctx != null && ctx.children != null && ctx.children.size() > 0) {
			for (ParseTree childCtx : ctx.children) {
				if (!(childCtx instanceof TerminalNode)) {
					if (childCtx.getText().length() > 0) {
						getExtendedContext(childCtx).symanticCheck();
					}
				}
			}
		}
	}

	public void GenerateAddresses() {
		ParserRuleContext ctx = getLatestContext();
		if (ctx != null && ctx.children != null && ctx.children.size() > 0) {
			for (ParseTree childCtx : ctx.children) {
				if (!(childCtx instanceof TerminalNode)) {
					if (childCtx.getText().length() > 0) {
						getExtendedContext(childCtx).GenerateAddresses();
					}
				}
			}
		}
	}

	public void printConfiguration(StringBuilder sb) {
		ParserRuleContext ctx = getLatestContext();
		if (ctx != null && ctx.children != null && ctx.children.size() > 0) {
			for (ParseTree childCtx : ctx.children) {
				if (!(childCtx instanceof TerminalNode)) {
					if (childCtx.getText().length() > 0) {
						getExtendedContext(childCtx).printConfiguration(sb);
					}
				}
			}
		}
	}

}