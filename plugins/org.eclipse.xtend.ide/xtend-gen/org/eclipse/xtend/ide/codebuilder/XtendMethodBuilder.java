/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.ide.codebuilder.AbstractMethodBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder.Xtend;
import org.eclipse.xtend.ide.codebuilder.InsertionOffsets;
import org.eclipse.xtend.ide.codebuilder.XtendTypeReferenceSerializer;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;

@SuppressWarnings("all")
public class XtendMethodBuilder extends AbstractMethodBuilder implements Xtend {
  @Inject
  private XtendTypeReferenceSerializer typeRefSerializer;
  
  @Inject
  private InsertionOffsets _insertionOffsets;
  
  protected TypeReferenceSerializer getTypeReferenceSerializer() {
    return this.typeRefSerializer;
  }
  
  public IAppendable build(final IAppendable appendable) {
    IAppendable _append = appendable.append("def ");
    JvmVisibility _visibility = this.getVisibility();
    IAppendable _appendVisibility = this.appendVisibility(_append, _visibility, JvmVisibility.PUBLIC);
    String _methodName = this.getMethodName();
    IAppendable _append_1 = _appendVisibility.append(_methodName);
    List<JvmTypeReference> _parameterTypes = this.getParameterTypes();
    IAppendable _appendParameters = this.appendParameters(_append_1, _parameterTypes);
    IAppendable _append_2 = _appendParameters.append(" {");
    IAppendable _increaseIndentation = _append_2.increaseIndentation();
    IAppendable _newLine = _increaseIndentation.newLine();
    IAppendable _appendDefaultBody = this.appendDefaultBody(_newLine, "");
    IAppendable _decreaseIndentation = _appendDefaultBody.decreaseIndentation();
    IAppendable _newLine_1 = _decreaseIndentation.newLine();
    IAppendable _append_3 = _newLine_1.append("}");
    return _append_3;
  }
  
  public int getInsertOffset() {
    EObject _context = this.getContext();
    XtendClass _xtendClass = this.getXtendClass();
    int _newMethodInsertOffset = this._insertionOffsets.getNewMethodInsertOffset(_context, _xtendClass);
    return _newMethodInsertOffset;
  }
  
  public XtendClass getXtendClass() {
    Object _ownerSource = this.getOwnerSource();
    return ((XtendClass) _ownerSource);
  }
}