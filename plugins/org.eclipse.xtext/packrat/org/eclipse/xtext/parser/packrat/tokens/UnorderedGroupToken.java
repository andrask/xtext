/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;
import org.eclipse.xtext.parser.packrat.internal.IFurtherParsable;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnorderedGroupToken extends CompoundParsedToken implements IFurtherParsable<UnorderedGroupToken> {

//	private int alternative;
//	private final int totalAlternatives;

	public UnorderedGroupToken(int offset, UnorderedGroup group, IFurtherParsable.Source<UnorderedGroupToken> origin, boolean optional) {
			//, int totalAlternatives) {
		super(offset, group, origin, optional);
//		this.totalAlternatives = totalAlternatives;
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		visitor.visitUnorderedGroupToken(this);
	}

	@Override
	public UnorderedGroup getGrammarElement() {
		return (UnorderedGroup) super.getGrammarElement();
	}

//	public void setAlternative(int alternative) {
//		this.alternative = alternative;
//	}
//
//	public int getAlternative() {
//		return alternative;
//	}

	public UnorderedGroupToken getToken() {
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Source<UnorderedGroupToken> getSource() {
		return (Source<UnorderedGroupToken>) super.getSource();
	}

	public boolean canParseFurther() {
		return false; // alternative < totalAlternatives - 1;
	}

	public static class End extends CompoundParsedToken.End {
//		private final int alternative;

		public End(int offset) {
				//, int alternative) {
			super(offset);
//			this.alternative = alternative;
		}

//		public int getAlternative() {
//			return alternative;
//		}

		@Override
		public void accept(IParsedTokenVisitor visitor) {
			visitor.visitUnorderedGroupTokenEnd(this);
		}
	}
}
