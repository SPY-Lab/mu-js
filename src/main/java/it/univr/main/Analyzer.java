package it.univr.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import it.univr.domain.AbstractDomain;
import it.univr.domain.coalasced.CoalascedAbstractDomain;
import it.univr.domain.coalasced.FA;
import it.univr.domain.lifted.LiftedUnionAbstractDomain;
import it.univr.state.AbstractMemory;
import it.univr.state.AbstractState;

public class Analyzer {

	public static void main(String[] args) throws IOException {
		System.out.println(potd());
		String file = args[0];

		boolean narrowing = false;
		boolean printInvariants = false;

		AbstractDomain domain = new CoalascedAbstractDomain();
		
		for (int i = 0; i < args.length; ++i) {
			if (args[i].equals("-narr"))
				narrowing = true;
			else if (args[i].equals("-coalesced"))
				domain = new CoalascedAbstractDomain();
			else if (args[i].equals("-lifted"))
				domain = new LiftedUnionAbstractDomain();
			else if (args[i].equals("-help")) {
				System.out.println(potd()  + "\n\n" + printHelp());
				return;
			}
			else if (args[i].equals("-widening")) {
				try {
					FA.setWidening(Integer.parseInt(args[i+1]));
				} catch (NumberFormatException e) {
					System.out.println(printHelp());
					return;
				}
			}
			else if (args[i].equals("-invariants")) {
				printInvariants = true;
			}
		}

		AbstractMemory memory = null;
		AbstractState state = null;
		
		try {
			if (printInvariants) {
				state = Analyzer.analyzeInvariants(file, domain, narrowing);
				System.out.println("\n\n\n");
				System.out.println(state);
			} else {
				memory = Analyzer.analyze(file, domain, narrowing);
				System.out.println("\n\n\n");
				System.out.println(memory);
			}
		} catch (FileNotFoundException f) {
			System.out.println(printHelp());
		}
	}

	public static AbstractMemory analyze(String file, AbstractDomain domain, boolean narrowing) throws IOException {
		AbstractInterpreter interpreter = new AbstractInterpreter(domain, narrowing, false);

		interpreter.setAbstractDomain(domain);
		InputStream stream = new FileInputStream(file);
				
		MuJsLexer lexer = new MuJsLexer(CharStreams.fromStream(stream, StandardCharsets.UTF_8));

		MuJsParser parser = new MuJsParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.program();
		interpreter.visit(tree);

		return interpreter.getFinalAbstractMemory();
	}
	
	public static AbstractState analyzeInvariants(String file, AbstractDomain domain, boolean narrowing) throws IOException {
		AbstractInterpreter interpreter = new AbstractInterpreter(domain, narrowing, true);

		interpreter.setAbstractDomain(domain);
		InputStream stream = new FileInputStream(file);
		MuJsLexer lexer = new MuJsLexer(CharStreams.fromStream(stream, StandardCharsets.UTF_8));

		MuJsParser parser = new MuJsParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.program();
		interpreter.visit(tree);

		return interpreter.getAbstractState();
	}

	private static String printHelp() {
		String result = "";
		result += "MuJS static analyzer.\n";
		result += "Usage:";
		result +="java -jar mujs.jar <file> (<opt>)*\n\n";
		result +="where <opt> is one of:\n\n";
		result += "\t -narr \t\t\t enables narrowing operator (default: disabled)\n";
		result += "\t -widening n \t\t set the parametric widening to n\n";
		result += "\t -coalesced \t\t enable the coalesced sum abstract domain (default)\n";
		result += "\t -lifted \t\t enable the lifted union abstract domain\n";
		result += "\t -invarians \t\t prints the invariants for each statement program point.\n";
		result += "\t\t\t\t By default, it prints only the memory holding at the end of the abstract execution\n";
		result += "\t -help \t\t\t print the menu\n";

		return result;
	}

	private static String potd() {
		return "MMMMMMMM               MMMMMMMM                            JJJJJJJJJJJ   SSSSSSSSSSSSSSS \n" +
				"M:::::::M             M:::::::M                            J:::::::::J SS:::::::::::::::S\n"+
				"M::::::::M           M::::::::M                            J:::::::::JS:::::SSSSSS::::::S\n"+
				"M:::::::::M         M:::::::::M                            JJ:::::::JJS:::::S     SSSSSSS\n"+
				"M::::::::::M       M::::::::::Muuuuuu    uuuuuu              J:::::J  S:::::S            \n"+
				"M:::::::::::M     M:::::::::::Mu::::u    u::::u              J:::::J  S:::::S            \n"+
				"M:::::::M::::M   M::::M:::::::Mu::::u    u::::u              J:::::J   S::::SSSS         \n"+
				"M::::::M M::::M M::::M M::::::Mu::::u    u::::u              J:::::j    SS::::::SSSSS    \n"+
				"M::::::M  M::::M::::M  M::::::Mu::::u    u::::u              J:::::J      SSS::::::::SS  \n"+
				"M::::::M   M:::::::M   M::::::Mu::::u    u::::u  JJJJJJJ     J:::::J         SSSSSS::::S \n"+
				"M::::::M    M:::::M    M::::::Mu::::u    u::::u  J:::::J     J:::::J              S:::::S\n"+
				"M::::::M     MMMMM     M::::::Mu:::::uuuu:::::u  J::::::J   J::::::J              S:::::S\n"+
				"M::::::M               M::::::Mu:::::::::::::::uuJ:::::::JJJ:::::::J  SSSSSSS     S:::::S\n"+
				"M::::::M               M::::::M u:::::::::::::::u JJ:::::::::::::JJ   S::::::SSSSSS:::::S\n"+
				"M::::::M               M::::::M  uu::::::::uu:::u   JJ:::::::::JJ     S:::::::::::::::SS \n"+
				"MMMMMMMM               MMMMMMMM    uuuuuuuu  uuuu     JJJJJJJJJ        SSSSSSSSSSSSSSS\n";
	}
}
