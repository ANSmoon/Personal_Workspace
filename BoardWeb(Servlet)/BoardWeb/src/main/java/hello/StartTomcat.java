package hello;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class StartTomcat {
	
	public static void main(String[] args) {
		Tomcat server = new Tomcat();
		try {
			server.start();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
	}
}
