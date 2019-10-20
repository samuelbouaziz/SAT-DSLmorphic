/*
 * generated by Xtext 2.19.0
 */
package projetDSL.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import projetDSL.parser.antlr.internal.InternalSATLParser;
import projetDSL.services.SATLGrammarAccess;

public class SATLParser extends AbstractAntlrParser {

	@Inject
	private SATLGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalSATLParser createParser(XtextTokenStream stream) {
		return new InternalSATLParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "BooleanExpressionsSystem";
	}

	public SATLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(SATLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
