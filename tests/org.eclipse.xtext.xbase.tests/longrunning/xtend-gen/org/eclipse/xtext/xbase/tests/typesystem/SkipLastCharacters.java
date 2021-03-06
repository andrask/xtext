/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractSmokeTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class SkipLastCharacters extends AbstractSmokeTest {
  public void assertNonSmoking(final String input) throws Exception {
    int _length = input.length();
    int _minus = (_length - 1);
    IntegerRange _upTo = new IntegerRange(0, _minus);
    for (final Integer i : _upTo) {
      String _substring = input.substring(0, (i).intValue());
      this.processExpression(_substring);
    }
  }
}
