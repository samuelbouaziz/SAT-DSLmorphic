/*
 * generated by Xtext 2.14.0
 */
package org.xtext.example


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class SatStandaloneSetup extends SatStandaloneSetupGenerated {

	def static void doSetup() {
		new SatStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}