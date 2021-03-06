/*
 * generated by Xtext
 */
package org.eclipse.xtend.ide;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.eclipse.xtend.ide.internal.XtendActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class XtendExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return XtendActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return XtendActivator.getInstance().getInjector(XtendActivator.ORG_ECLIPSE_XTEND_CORE_XTEND);
	}
	
}
