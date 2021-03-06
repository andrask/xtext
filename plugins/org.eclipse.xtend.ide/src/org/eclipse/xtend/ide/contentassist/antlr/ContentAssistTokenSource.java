package org.eclipse.xtend.ide.contentassist.antlr;

import java.io.IOException;
import java.io.Reader;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtend.ide.contentassist.antlr.internal.InternalXtendFlexer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistTokenSource implements TokenSource {

	private final InternalXtendFlexer flexer;
	private int offset;

	protected ContentAssistTokenSource(InternalXtendFlexer flexer) {
		this.flexer = flexer;
		offset = 0;
	}
	
	public void reset(Reader reader) {
		flexer.yyreset(reader);
		offset = 0;
	}

	public Token nextToken() {
		try {
			int type = flexer.advance();
			if (type == Token.EOF) {
				return Token.EOF_TOKEN;
			}
			int length = flexer.getTokenLength();
			CommonToken result = new CommonTokenWithoutText(type, Token.DEFAULT_CHANNEL, offset, length);
			offset += length;
			return result;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String getSourceName() {
		return "FlexTokenSource";
	}
	
	public static class CommonTokenWithoutText extends CommonToken {

		private static final long serialVersionUID = 1L;

		public CommonTokenWithoutText(int type, int defaultChannel, int offset, int length) {
			super(null, type, defaultChannel, offset, offset + length - 1);
		}
		
	}

}
