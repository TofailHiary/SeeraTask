package general.manager;

/**
 * Created by AKhawatrah on 1/13/2019.
 */

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

// this class created to handle the props method used  in project 
public class PropertiesManager {

	public static Properties props = new Properties();
	public static Properties envProps = new Properties();
	public static Properties localeProps = new Properties();
	public static Properties extentReportProps = new Properties();

	private static ThreadLocal<Properties> appProps = new ThreadLocal<Properties>();

	public PropertiesManager() {

	}

	public static Properties getProperties() {

		String fileName = "RunProperties";

		props = new Properties();
		props = loadProperties(fileName, props);

		return props;
	}

	public static Properties loadProperties(String fileName, Properties props) {

		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

		try {

			props.load(inputStream);
			appProps.set(new Properties());
			appProps.get().load(inputStream);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return props;
	}

	public static void updateProperties(String fileName, Properties props, String key, String value) {

		try {
			FileOutputStream out = new FileOutputStream(fileName);
			props.setProperty(key, value);
			props.store(out, null);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());

		}

	}

}
