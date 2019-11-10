/*
 * generated by Xtext 2.19.0
 */
package org.xtext.example.msat.bailluetbouaziz

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import org.xtext.example.mydsl1.mSat.SATMorphic
import org.xtext.example.mydsl1.tests.MSatInjectorProvider
import org.xtext.example.mydsl1.mSat.Expression
import java.util.HashMap
import java.nio.file.Files
import java.nio.file.Paths
import java.io.BufferedReader
import java.io.InputStreamReader
import org.sat4j.specs.ISolver
import org.sat4j.minisat.SolverFactory
import org.sat4j.reader.Reader
import org.sat4j.reader.DimacsReader
import java.io.PrintWriter
import org.sat4j.specs.IProblem
import java.io.FileWriter
import java.io.File
import org.xtext.example.mydsl1.mSat.Sat4JVariant
import org.eclipse.emf.common.util.EList
import org.xtext.example.mydsl1.mSat.SATSolver
import org.xtext.example.mydsl1.mSat.Benchmark
import org.xtext.example.mydsl1.mSat.BenchmarkDimacs
import org.xtext.example.mydsl1.mSat.BenchmarkFormula
import org.xtext.example.mydsl1.mSat.Sat4J
import org.xtext.example.mydsl1.mSat.And
import org.xtext.example.mydsl1.mSat.Not
import org.xtext.example.mydsl1.mSat.Or
import org.xtext.example.mydsl1.mSat.BiImpl
import org.xtext.example.mydsl1.mSat.Impl
import org.xtext.example.mydsl1.mSat.Nand
import java.io.PrintStream
import java.io.ByteArrayOutputStream
import java.io.StringWriter

@ExtendWith(InjectionExtension)
@InjectWith(MSatInjectorProvider)
class MSatParsingBailluetBouazizTest {
	@Inject
	ParseHelper<SATMorphic> parseHelper
	
	@Test
	def void parseTestFile()
	{
		var String inputFileName = "test.msat";
		var String content = new String(Files.readAllBytes(Paths.get(inputFileName)));
		var SATMorphic morphic = parseHelper.parse(content);
		parseAst(morphic, "test.cnf");
	}
	
	def void parseAst(SATMorphic morphic, String outputDimacsFileName) {

		var EList<SATSolver> solvers = morphic.solvers;
		if (solvers.length > 1)
			System.err.println("Multiple solvers detected, feature not supported yet, will only be using the first one!");
		
		if (!(solvers.get(0).solver instanceof Sat4J))
		{
			System.err.println("Unsupported solver, only Sat4J supported! Aborting...");
			System.exit(1);
		}
		
		var Sat4J solvertype = solvers.get(0).solver as Sat4J;
		var Benchmark bench = morphic.benchmark;
		 
		var String dimacs;
		if (bench instanceof BenchmarkFormula) {
			var BenchmarkFormula bench_form = bench as BenchmarkFormula;
			var EList<Expression> exprs = bench_form.expressions;
			if(exprs.length > 1)
				System.err.println("Multiple expressions detected, feature not supported yet, will only be using the first one!");
			var Expression expr = exprs.get(0);
			dimacs = getDIMACSFromInlineFormula(expr);

			var FileWriter writer = new FileWriter(new File(outputDimacsFileName));
			writer.write(dimacs);
			writer.close();
		} else if (bench instanceof BenchmarkDimacs) {
			var BenchmarkDimacs banch_dimacs = bench as BenchmarkDimacs;
			var EList<String> files = banch_dimacs.dimacses
			if(files.length > 1)
				System.err.println("Multiple input files detected, feature not supported yet, will only be using the first one!");
			var String filepath = files.get(0);
			dimacs = getDIMACSFromFile(filepath);
		}
		
		println(dimacs);		
		
		var Sat4JVariant solverMethod = (solvertype as Sat4J).getVariant();
		switch solverMethod
		{
			case Sat4JVariant.SAT4J_JAVA:
			{
				var ISolver solver = SolverFactory.newDefault();
		        solver.setTimeout(3600); // 1 hour timeout
		        var Reader reader = new DimacsReader(solver);
		        var PrintWriter out = new PrintWriter(System.out, true);
		        // CNF filename is given on the command line 
		        try {
		            var IProblem problem = reader.parseInstance(outputDimacsFileName);
		            if (problem.isSatisfiable()) {
		                System.out.println("Satisfiable !");
		                reader.decode(problem.model(), out);
		            } else {
		                System.out.println("Unsatisfiable !");
		            }
		        } catch (Exception e) {
		            System.out.println("Oops!");      
		        }
		        out.close();
			}
			
			case Sat4JVariant.SAT4J_JAR:
			{
				var Process p = Runtime.getRuntime().exec("java -jar org.sat4j.core.jar " + outputDimacsFileName);
				
				var BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
				
				var String s = null;
				while ((s = stdInput.readLine()) !== null) {
				    System.out.println(s);
				}
			}
			
			case Sat4JVariant.SAT4J_COMP:
			{
				var File app = new File("mvn/src/main/java/msat/bailluetbouaziz/App.java");
				Runtime.getRuntime().exec("mvn archetype:generate -DgroupId=msat.bailluetbouaziz -DartifactId=mvn -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false -e")
				var PrintWriter app_writer = new PrintWriter(app);
				app_writer.write('''
				package msat.bailluetbouaziz;
				
				import org.sat4j.specs.ISolver;
				import org.sat4j.minisat.SolverFactory;
				import org.sat4j.reader.Reader;
				import org.sat4j.reader.DimacsReader;
				import java.io.PrintWriter;
				import org.sat4j.specs.IProblem;
				
				public class App 
				{
				    public static void main( String[] args )
				    {
				    	ISolver solver = SolverFactory.newDefault();
				        solver.setTimeout(3600); // 1 hour timeout
				        Reader reader = new DimacsReader(solver);
				        PrintWriter out = new PrintWriter(System.out, true);
				        // CNF filename is given on the command line 
				        try {
				            IProblem problem = reader.parseInstance(args[0]);
				            if (problem.isSatisfiable()) {
				                System.out.println("Satisfiable !");
				                reader.decode(problem.model(), out);
				            } else {
				                System.out.println("Unsatisfiable !");
				            }
				        } catch (Exception e) {
				            System.out.println("Oops!");      
				        }
				        out.close();
				    }
				}
				''');
				app_writer.close();
				
				var File pom = new File("mvn/pom.xml");
				var PrintWriter pom_writer = new PrintWriter(pom);
				pom_writer.write('''
				<?xml version="1.0" encoding="UTF-8"?>
				
				<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
				  <modelVersion>4.0.0</modelVersion>
				
				  <groupId>msat.bailluetbouaziz</groupId>
				  <artifactId>mvn</artifactId>
				  <version>1.0-SNAPSHOT</version>
				
				  <name>mvn</name>
				  <!-- FIXME change it to the project's website -->
				  <url>http://www.example.com</url>
				
				  <properties>
				    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
				    <maven.compiler.source>1.7</maven.compiler.source>
				    <maven.compiler.target>1.7</maven.compiler.target>
				  </properties>
				
				  <dependencies>
				    <dependency>
				      <groupId>junit</groupId>
				      <artifactId>junit</artifactId>
				      <version>4.11</version>
				      <scope>test</scope>
				    </dependency>
				     <dependency>
					    <groupId>org.sat4j</groupId>
					    <artifactId>org.sat4j.core</artifactId>
					    <version>2.3.1</version>
				    </dependency>
				  </dependencies>
				</project>
				''');
				pom_writer.close();
				
				Runtime.getRuntime().exec("mvn install", null, new File("mvn/"));
				var Process p = Runtime.getRuntime().exec("mvn exec:java -Dexec.mainClass=msat.bailluetbouaziz.App -Dexec.args=../"+outputDimacsFileName, null, new File("mvn/"));
				var BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
				
				var String s = null;
				while ((s = stdInput.readLine()) !== null) {
				    System.out.println(s);
				}
			}
		}
	}
	
	def String getDIMACSFromInlineFormula(Expression ast)
	{
		ast.prettyPrint;
		println();
		
		var HashMap<String, Integer> literal_ids = new HashMap<String, Integer>();
		ast.parse_cnf_literals(literal_ids);
		return ast.toDIMACS(literal_ids);
	}
	
	def String getDIMACSFromFile(String file)
	{
		return new String(Files.readAllBytes(Paths.get(file)))
	}
	
	def parse_cnf_literals(Expression e, HashMap<String, Integer> literal_ids) {
		if(e.getId() !== null)
		{
			if(!literal_ids.containsKey(e.getId()))
				literal_ids.put(e.getId(), literal_ids.size() + 1); 
		} else if(e instanceof And) {
			e.getLeft().parse_cnf_literals(literal_ids);
			e.getRight().parse_cnf_literals(literal_ids);
		} else if (e instanceof Not) {
			e.getExpression().parse_cnf_literals(literal_ids);
		} else if (e instanceof Or) {
			e.getLeft().parse_cnf_literals(literal_ids);
			e.getRight().parse_cnf_literals(literal_ids);
		} 		
	}
	
	def count_cnf_clause(Expression e) {
		var Expression current = e;
		var int count = 1;
		while(current instanceof And)
		{
			count++;
			current = current.getLeft();
		}
		return count;
	}
	
	def cnfToDIMACS(Expression e, HashMap<String, Integer> literal_ids) {
		if (e instanceof Or) {
			return(e.getLeft().cnfToDIMACS(literal_ids) + " " + e.getRight().cnfToDIMACS(literal_ids));
		} else if(e instanceof And) {
			return(e.getRight().cnfToDIMACS(literal_ids) + " 0\n" + e.getLeft().cnfToDIMACS(literal_ids));
		} else if (e instanceof Not) {
			return("-" + literal_ids.get(e.getExpression().getId()));
		} else if(e.getId() !== null) {
			return(literal_ids.get(e.getId()));
		}
	}
		
	
	def String toDIMACS(Expression e, HashMap<String, Integer> literal_ids) '''
		p cnf «literal_ids.size()» «e.count_cnf_clause»
		«e.cnfToDIMACS(literal_ids)» 0
	'''
	// -> print right with printclause
	//
	// -> parse the left
	// while we find a ^ we printclause the right
	// if we don't find a ^ we printclause the current expression
	
	def prettyPrint(And e) {
		print("(");
		e.getLeft().prettyPrint;
		print(" ^ ")
		e.getRight().prettyPrint;
		print(")");
	}
	
	def prettyPrint(BiImpl e) {
		print("(");
		e.getLeft().prettyPrint;
		print(" <=> ")
		e.getRight().prettyPrint;
		print(")");
	}
	
	def prettyPrint(Impl e) {
		print("(");
		e.getLeft().prettyPrint;
		print(" => ")
		e.getRight().prettyPrint;
		print(")");
	}
	
	def prettyPrint(Nand e) {
		print("(");
		e.getLeft().prettyPrint;
		print(" | ")
		e.getRight().prettyPrint;
		print(")");
	}
	
	def prettyPrint(Not e) {
		print("~");
		e.getExpression().prettyPrint;
	}
	
	def prettyPrint(Or e) {
		print("(");
		e.getLeft().prettyPrint;
		print(" v ")
		e.getRight().prettyPrint;
		print(")");
	}
	
	def prettyPrint(Expression e) {
		if(e instanceof And) {
			prettyPrint(e as And);
		} else if (e instanceof BiImpl) {
			prettyPrint(e as BiImpl);	
		} else if (e instanceof Impl) {
			prettyPrint(e as Impl);	
		} else if (e instanceof Nand) {
			prettyPrint(e as Nand);
		} else if (e instanceof Not) {
			prettyPrint(e as Not);
		} else if (e instanceof Or) {
			prettyPrint(e as Or);
		} else if(e.getId() !== null) {
			print(e.getId());
		}
	}
	
	
	@Test
	def void loadSolvers() {
		val result = parseHelper.parse('''
			solver 
				   minisat rnd-freq 1
				   cryptominisat
			benchmarkDIMACS "foo1.cnf", "foo2.cnf"
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
	}
	
	@Test
	def void loadSAT4J() {
		val result = parseHelper.parse('''
			solver 
				   sat4j-java
			benchmarkDIMACS "foo1.cnf"
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		
		var ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		var ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
    	System.setErr(new PrintStream(errContent));
		parseAst(result, "foo1.cnf");
		
		var StringWriter expectedStringWriter = new StringWriter();
		var PrintWriter printWriter = new PrintWriter(expectedStringWriter);

		printWriter.println("p cnf 5 3");
		printWriter.println("5 0");
		printWriter.println("3 -4 0");
		printWriter.println("1 2 0");
		printWriter.println();
		printWriter.println("Satisfiable !");
		printWriter.print("-1 2 -3 -4 5 0");
		printWriter.close();
		
		var String expected = expectedStringWriter.toString();
		Assertions.assertEquals(outContent.toString(), expected);
	}
	
	@Test
	def void loadSAT4J_MVN() {
		val result = parseHelper.parse('''
			solver 
				   sat4j-maven
			benchmarkDIMACS "foo1.cnf"
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')

		var ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		var ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
    	System.setErr(new PrintStream(errContent));
		parseAst(result, "foo1.cnf");
		
		Assertions.assertTrue(outContent.toString().contains("Satisfiable !"));
		Assertions.assertTrue(outContent.toString().contains("-1 2 -3 -4 5 0"));
	}
	
	@Test
	def void loadSAT4J_JAR() {
		val result = parseHelper.parse('''
			solver 
				   sat4j-jar
			benchmarkDIMACS "foo1.cnf"
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
		
		var ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		var ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
    	System.setErr(new PrintStream(errContent));
		parseAst(result, "foo1.cnf");
		
		var StringWriter expectedStringWriter = new StringWriter();
		var PrintWriter printWriter = new PrintWriter(expectedStringWriter);

		printWriter.println("p cnf 5 3");
		printWriter.println("5 0");
		printWriter.println("3 -4 0");
		printWriter.print("1 2 0");
		printWriter.close();

		
		var String expected = expectedStringWriter.toString();
		Assertions.assertTrue(outContent.toString().startsWith(expected));
		Assertions.assertTrue(outContent.toString().contains("s SATISFIABLE"));
		Assertions.assertTrue(outContent.toString().contains("v -1 2 -3 -4 5 0"));
	}
}
