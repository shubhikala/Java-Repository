package in.com.psi.dashboard.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageReader.
 */
public class MessageReader {

	/** The properties. */
	private static Properties properties = null;

	/** The self. */
	private static MessageReader self;

	/**
	 * Instantiates a new message reader.
	 */
	public MessageReader() {

	}

	/**
	 * Inits the.
	 *
	 * @return single instance of MessageReader
	 */
	public static MessageReader getInstance() {
		if (self == null) {
			synchronized (MessageReader.class) {
				if (self == null) {
					self = new MessageReader();
					InputStream propStream = self.getClass().getClassLoader()
							.getResourceAsStream("messages.properties");
					if (propStream != null) {
						properties = new Properties();
						try {
							properties.load(propStream);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} else {
					return self;
				}
			}
		}
		return self;
	}

	/*
	 * public static MessageReader getInstance(){ if(self == null){ synchronized
	 * (MessageReader.class) { if(self == null){ self = new MessageReader();
	 * InputStream propStream = self.getClass().getClassLoader()
	 * .getResourceAsStream("constants.properties"); if(propStream != null){
	 * properties = new Properties(); try { properties.load(propStream); } catch
	 * (IOException e) { e.printStackTrace(); } } } else{ return self; } } }
	 * return self; }
	 */

	/**
	 * Gets the property.
	 *
	 * @param key
	 *            the key
	 * @return the property
	 */
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}