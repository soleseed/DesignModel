package com.cn.export;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Descripteur de fichier structure (champs fixes)
 * 
 * @version $Revision: 1.5 $
 * @since Globe 2.0
 */
public class FileDesc {
	/**
	 * Map d'items
	 */
	private final Map items = new HashMap();
	/**
	 * Map de lignes
	 */
	private final Map lines = new HashMap();

	/**
	 * Constructeur
	 * 
	 * @param prop
	 *            Proprietes
	 * @exception Exception
	 *                En cas d'erreur
	 */
	public FileDesc(final Properties prop) throws Exception {
		initSourceConfig(prop);
	}

	/**
	 * Initialisation de l'objet
	 * 
	 * @param prop
	 *            Proprietes
	 * @exception Exception
	 *                En cas d'erreur
	 */
	private void initSourceConfig(final Properties prop) throws Exception {
		// gestion des inclusions
		final String redirect = prop.getProperty("@redirect");
		if (redirect != null) {
			// FieldReader.RSRC_PREFIX 路径名的String e.g:"/data/broker/"
			final Properties newProp = FileDesc
					.loadProperties("FieldReader.RSRC_PREFIX" + redirect + "/" + "desc.properties");
			initSourceConfig(newProp);
			return;
		}
		// liste des champs
		for (final Enumeration e = prop.keys(); e.hasMoreElements();) {
			final String cle = (String) e.nextElement();
			if (!(cle.charAt(0) == '_' || cle.charAt(0) == '@')) {
				// un item
				final String desc = (String) prop.get(cle);
				final Item item = new Item(cle, desc);
				items.put(cle, item);
			}
		}
		// liste des lignes
		lines.clear();
		for (final Enumeration e = prop.keys(); e.hasMoreElements();) {
			final String cle = (String) e.nextElement();
			if (cle.charAt(0) == '_') {
				// un item
				final String desc = (String) prop.get(cle);
				final String[] list = desc.split(",");
				final List line = new ArrayList();
				for (int i = 0; i < list.length; i++) {
					line.add(items.get(list[i]));
				}
				lines.put(cle.substring(1), line);
			}
		}
	}

	/**
	 * Getter sur les items
	 * 
	 * @return Map d'items
	 */
	public Map getItems() {
		return items;
	}

	/**
	 * Getter sur les lignes
	 * 
	 * @return Map de lignes
	 */
	public Map getLines() {
		return lines;
	}

	/**
	 * Lecture des Proprietes
	 * 
	 * @param config
	 *            Configuration
	 * @return Proprietes
	 * @throws Exception
	 *             En cas d'erreur
	 */
	public static Properties loadProperties(final String config) throws Exception {
		final Properties prop = new Properties();
		final InputStream stream = FileDesc.class.getResourceAsStream(config);
		if (stream == null) {
			throw new Exception("ressource " + config + " inexistante");
		}
		try {
			prop.load(stream);
			stream.close();
		} catch (final IOException e) {
			throw new Exception("ressource " + config + " inexistante", e);
		}
		return prop;
	}
}