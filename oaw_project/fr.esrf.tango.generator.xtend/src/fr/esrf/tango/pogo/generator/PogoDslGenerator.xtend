/*
 * generated by Xtext
 */
package fr.esrf.tango.pogo.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import com.google.inject.Inject

class PogoDslGenerator implements IGenerator {
	@Inject
	JavaDevice javaDeviceGenerator
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		javaDeviceGenerator.doGenerate(resource,fsa)
	}
}