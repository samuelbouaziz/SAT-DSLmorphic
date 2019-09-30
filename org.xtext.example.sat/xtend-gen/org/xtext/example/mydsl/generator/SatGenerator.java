/**
 * generated by Xtext 2.19.0
 */
package org.xtext.example.mydsl.generator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.xtext.example.mydsl.generator.PrettyPrinter;
import org.xtext.example.mydsl.generator.Simplifier;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class SatGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    final EObject simplifiedExpression = this.simplify(resource.getContents().get(0));
    final String content = this.prettyPrint(simplifiedExpression);
    fsa.generateFile("sat.cnf", content);
  }
  
  public EObject simplify(final EObject e) {
    return Simplifier.simplify(e);
  }
  
  public String prettyPrint(final EObject e) {
    return PrettyPrinter.prettyPrint(e);
  }
}
