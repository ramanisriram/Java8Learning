package nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaJJSSupport {
	public static void main(String args[]) {
		ScriptEngineManager scEM = new ScriptEngineManager();
		ScriptEngine scE = scEM.getEngineByName("nashorn");
		try {
			scE.eval("print('hello');");
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}