package com.cn.export;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Classe FieldWriter. Eciture de fichiers hierarchiques a champs fixes.
 * <p>
 * Configure par un fichier de properties. Voir le constructeur pour le format
 * 
 * @author e185842
 * @version $Revision: 1.12 $
 * @since Globe 2.0
 */
public class FieldWriter {
	/**
	 * Source
	 */
	private final FileDesc source;

	/**
	 * FieldWriter
	 * 
	 * @param configToken
	 *            .
	 * @param initialContext
	 *            .
	 * @throws Exception
	 *             En cas d'erreur
	 */
	public FieldWriter(final String configToken, final Map<String, Comparable> initialContext) throws Exception {
		super();
		source = loadFileDesc(configToken);
	}

	/**
	 * FieldWriter
	 * 
	 * @param configToken
	 *            .
	 * @throws Exception
	 *             En cas d'erreur
	 */
	public FieldWriter(final String configToken) throws Exception {
		super();
		source = loadFileDesc(configToken);
	}

	/**
	 * LoadFileDesc
	 * 
	 * @param configToken
	 *            .
	 * @return FileDesc
	 * @throws Exception
	 *             EN cas d'erreur
	 */
	public static FileDesc loadFileDesc(final String configToken) throws Exception {
		// FieldReader.RSRC_PREFIX = "/data/broker/"

		final String fileDesc = "FieldReader.RSRC_PREFIX" + configToken + "/" + "desc.properties";
		final Properties srcConfigProp = FileDesc.loadProperties(fileDesc);
		return new FileDesc(srcConfigProp);
	}

	/**
	 * Write Line champ par champ - PrintStream en autoflush
	 * 
	 * @param printStream
	 *            PrintStream
	 * @param map
	 *            Map
	 * @param code
	 *            Code
	 * @throws Exception
	 *             En cas d'erreur
	 */
	public void writeLine(final PrintStream printStream, final Map<String, Comparable> map, final String code)
			throws Exception {
		final List items = (List) source.getLines().get(code);
		if (items == null) {
			throw new Exception("Code " + code + " invalide");
		}
		final Item first = (Item) items.get(0);
		map.put(first.getNom(), code);
		// FieldReader.TIMEZONE="Europe/Paris" 时区字符串
		MouvementUtil.genLine(map, items, printStream, "FieldReader.TIMEZONE");
	}

	/**
	 * Write Line champ par champ puis flush - PrintStream en flush manuel
	 * 
	 * @param printStream
	 *            PrintStream
	 * @param map
	 *            Map
	 * @param code
	 *            Code
	 * @throws Exception
	 *             En cas d'erreur
	 */
	public void writeLineAndFlush(final PrintStream printStream, final Map<String, String> map, final String code)
			throws Exception {
		final List items = (List) source.getLines().get(code);
		if (items == null) {
			throw new Exception("Code " + code + " invalide");
		}
		final Item first = (Item) items.get(0);
		map.put(first.getNom(), code);
		// FieldReader.TIMEZONE="Europe/Paris" 时区字符串
		MouvementUtil.genLineAndFlush(map, items, printStream, "FieldReader.TIMEZONE");
	}

	/**
	 * Getter
	 * 
	 * @return Source
	 */
	public FileDesc getSource() {
		return source;
	}

	/**
	 * PatchItem
	 * 
	 * @param name
	 *            Name
	 * @param desc
	 *            Desc
	 */
	public void patchItem(final String name, final String desc) {
		// CodeDt0900.FLD_T09A001_STRING = "T09A001" 字符串名字代号
		final Item item = new Item("CodeDt0900.FLD_T09A001_STRING", desc);
		final Item newItem = (Item) getSource().getItems().get(name);
		newItem.setCobolFormat(item.getCobolFormat());
		newItem.setJavaType(item.getJavaType());
		newItem.setFormat(item.getFormat());
	}
}
