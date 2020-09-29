/**
 * 
 */
package com.billReimbursement.util;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * @author shubhi
 *
 */
public class PropertiesUtil {

	private static Properties props;

	// whatever code is needed for initialization goes here
	static {
		props = new Properties();
		try {
			PropertiesUtil util = new PropertiesUtil();
			props = util.getProperties("message.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// private constructor
	private PropertiesUtil() {
	}

	public static String getProperty(String key) {
		return props.getProperty(key).trim();
	}

	public static Set<Object> getkeys() {
		return props.keySet();
	}

	/**
	 * loads properties file
	 * 
	 * @param propFileName
	 * @return
	 * @throws IOException
	 */
	private Properties getProperties(String propFileName) throws IOException {
		Properties props = new Properties();
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream(propFileName);

		if (inputStream == null) {
			throw new FileNotFoundException("property file '" + propFileName
					+ "' not found in the classpath");
		}

		props.load(inputStream);
		return props;
	}
}
