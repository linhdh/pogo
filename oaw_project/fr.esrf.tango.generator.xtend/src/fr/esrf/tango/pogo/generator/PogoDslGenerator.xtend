/*
 * generated by Xtext
 */
package fr.esrf.tango.pogo.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import com.google.inject.Inject
import fr.esrf.tango.pogo.generator.python.PythonDevice
import fr.esrf.tango.pogo.generator.cpp.CppGenerator
import fr.esrf.tango.pogo.generator.java.JavaGenerator
import fr.esrf.tango.pogo.generator.html.HtmlGenerator

class PogoDslGenerator implements IGenerator {
	
	@Inject CppGenerator cppDeviceGenerator
	@Inject JavaGenerator javaDeviceGenerator
	@Inject PythonDevice pythonDevice
	@Inject HtmlGenerator htmlGenerator

	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		cppDeviceGenerator.doGenerate(resource,fsa)
		javaDeviceGenerator.doGenerate(resource,fsa)
		pythonDevice.doGenerate(resource,fsa)
		htmlGenerator.doGenerate(resource,fsa)
	}
}
