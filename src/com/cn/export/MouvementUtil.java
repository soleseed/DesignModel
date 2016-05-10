/*
 * @(#)MouvementUtil.java 18 nov. 05 Copyright PSA Peugeot Citröen. All rights reserved.
 */
package com.cn.export;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;

/**
 * Classe d'aide à la Génération des mouvements
 * 
 * @version $Revision: 1.9 $
 * @since Globe 2.0
 */
public class MouvementUtil {
	/**
	 * dix
	 */
	private static final int DIX = 10;
	/**
	 * Expression reguliere decimale avec point
	 */
	private static final String REGEXP_PDECIMAL = "S?9\\((\\d*)\\)\\.9\\((\\d*)\\)";
	/**
	 * Expression reguliere decimale sans point separateur
	 */
	private static final String REGEXP_VDECIMAL = "S?9\\((\\d*)\\)V9\\((\\d*)\\)";

	/**
	 * Constructeur
	 */
	public MouvementUtil() {
		super();
	}

	/**
	 * Compléter une chaine, a droite, par le caractere car jusqu'a atteindre la
	 * longueur
	 * 
	 * @param oldStr
	 *            Chaine a completer
	 * @param longueur
	 *            Longueur a atteindre
	 * @param car
	 *            Caractere qui sert a combler le vide
	 * @return Chaine completee par la caractere car a droite
	 */
	public static String remplirChar(final String oldStr, final int longueur, final char car) {
		String str = oldStr;
		if (str == null) {
			str = "";
		}
		String result;
		final int len = str.trim().length();
		if (longueur <= len) {
			result = str.trim();
		} else {
			final StringBuilder buf = new StringBuilder(longueur);
			buf.append(str.trim());
			for (int i = len; i < longueur; i++) {
				buf.append(car);
			}
			result = buf.toString();
		}
		return result;
	}

	/**
	 * Compléter une chaine, a droite, par blanc jusqu'a longueur
	 * 
	 * @param str
	 *            Chaine a completer
	 * @param longueur
	 *            Longueur a atteindre
	 * @return Chaine completee par la caractere ' ' a droite
	 */
	public static String remplirBlancs(final String str, final int longueur) {
		return remplirChar(str, longueur, ' ');
	}

	/**
	 * Génération d'un filler
	 * 
	 * @param length
	 *            Longueur
	 * @return String de lenght caractere
	 */
	public String genFiller(final int length) {
		final StringBuilder filler = new StringBuilder();
		for (int i = 0; i < length; i++) {
			filler.append(' ');
		}
		return filler.toString();
	}

	/**
	 * Conversion chaine en chaine
	 * 
	 * @param item
	 *            Item
	 * @param valeur
	 *            Valeur
	 * @return Chaine completee
	 * @exception TechException
	 *                En cas d'erreur
	 */
	public static String convertString(final Item item, final String valeur) {
		StringBuilder result = new StringBuilder();
		final int lgReq = item.getTaille();
		boolean gauche = false;
		if (item.getFormat() != null && item.getJavaType().equals(Item.TYPE_NUMBER)) {
			gauche = true;
		}
		result.append(valeur.trim());
		final int lgCur = result.length();
		if (lgCur > lgReq) {
			// tronquer et le dire
			result = new StringBuilder(valeur.substring(0, lgReq - 1));
		} else if (lgCur < lgReq) {
			// ajouter des blancs
			if (gauche) {
				for (int i = lgCur; i < lgReq; i++) {
					result.insert(0, ' ');
				}
			} else {
				for (int i = lgCur; i < lgReq; i++) {
					result.append(' ');
				}
			}
		}
		return result.toString();
	}

	/**
	 * Conversion d'une date en chaine de caracteres
	 * 
	 * @param item
	 *            Item a convertir
	 * @param date
	 *            Date
	 * @param timezone
	 *            Timezone pour la conversion.
	 * @return String
	 */
	public static String convertDate(final Item item, final Date date, final String timezone) {
		String javaFormat = item.getFormat();
		if (javaFormat == null) {
			javaFormat = "yyyyMMddHHmmss";
		}
		if (item.getTaille() < javaFormat.length()) {
			javaFormat = javaFormat.substring(0, item.getTaille());
		}
		if (item.getTaille() > javaFormat.length()) {
			javaFormat = MouvementUtil.remplirBlancs(javaFormat, item.getTaille());
		}
		final SimpleDateFormat form = new SimpleDateFormat(javaFormat);
		final TimeZone timeZone = TimeZone.getTimeZone(timezone);
		form.setTimeZone(timeZone);
		return form.format(date);
	}

	/**
	 * Conversion d'un number en une chaine de caracteres
	 * 
	 * @param valeur
	 *            Valeur
	 * @param item
	 *            Item
	 * @return String
	 * @exception TechException
	 *                En cas d'erreur
	 */
	public static String convertNumber(final Item item, final Number valeur) throws Exception {
		String javaFormat;
		double mult = 1;
		if (item.getFormat() != null) {
			javaFormat = item.getFormat();
		} else {
			final boolean signed = item.getCobolFormat().charAt(0) == 'S';
			if (item.getCobolFormat().matches(REGEXP_VDECIMAL)) {
				final String[] elts = item.getCobolFormat().replaceAll(REGEXP_VDECIMAL, "$1,$2").split(",");
				final int apres = Integer.valueOf(elts[1]).intValue();
				final int avant = Integer.valueOf(elts[0]).intValue();
				final String subFormat = MouvementUtil.remplirChar("", avant + apres, '0');
				String plus = "";
				if (signed) {
					plus = "+";
				}
				final String negatif = ";" + "-" + subFormat;
				javaFormat = plus + subFormat + (signed ? negatif : "");
				mult = Math.pow(DIX, apres);
			} else if (item.getCobolFormat().matches(REGEXP_PDECIMAL)) {
				final String[] elts = item.getCobolFormat().replaceAll(REGEXP_PDECIMAL, "$1,$2").split(",");
				final int apres = Integer.valueOf(elts[1]).intValue();
				final int avant = Integer.valueOf(elts[0]).intValue();
				final String subFormat = MouvementUtil.remplirChar("", avant, '0') + "."
						+ MouvementUtil.remplirChar("", apres, '0');
				String plus = "";
				if (signed) {
					plus = "+";
				}
				final String negatif = ";" + "-" + subFormat;
				javaFormat = plus + subFormat + (signed ? negatif : "");
			} else if (signed) {
				final String subFormat = MouvementUtil.remplirChar("", item.getTaille() - 1, '0');
				javaFormat = "+" + subFormat + ";-" + subFormat;
			} else {
				javaFormat = MouvementUtil.remplirChar("", item.getTaille(), '0');
			}
		}
		final DecimalFormat form = new DecimalFormat(javaFormat);
		final DecimalFormatSymbols dfs = form.getDecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		form.setDecimalFormatSymbols(dfs);
		form.setMultiplier((int) mult);
		String result = form.format(valeur.doubleValue());
		// normalisation du resultat
		result = convertString(item, result);
		if (result.length() != item.getTaille()) {
			throw new Exception();
		}
		return result;
	}

	/**
	 * Conversion Booleen en chaine
	 * 
	 * @param valeur
	 *            .
	 * @param item
	 *            .
	 * @return .
	 */
	public static String convertBoolean(final Item item, final Boolean valeur) {
		String result;
		String charTrue = "Y";
		String charFalse = "N";
		if (item.getFormat() != null) {
			final String[] vals = item.getFormat().trim().split(";");
			charTrue = vals[0];
			charFalse = vals[1];
		}
		if (valeur.booleanValue()) {
			result = charTrue;
		} else {
			result = charFalse;
		}
		return result;
	}

	/**
	 * Ajout cnt fois, a droite, le caractere donne a un StringBuffer
	 * 
	 * @param buf
	 *            StringBuffer
	 * @param cnt
	 *            Nombre de fois que le caractere doit etre ajoute
	 * @param car
	 *            Caractere ajouter cnt fois a droite dans le StringBuffer
	 */
	public void addNChars(final StringBuilder buf, final int cnt, final char car) {
		for (int i = 0; i < cnt; i++) {
			buf.append(car);
		}
	}

	/**
	 * Conversion d'un Objet en une chaine de caractere
	 * 
	 * @param item
	 *            Item
	 * @param value
	 *            Valeur
	 * @param timezone
	 *            Timezone pour la conversion
	 * @return String
	 * @throws TechException
	 *             En cas d'erreur
	 */
	public static String convertObject(final Item item, final Object value, final String timezone) throws Exception {
		String stringValue = "";
		if (item.getJavaType().equals(Item.TYPE_STRING)) {
			if (value == null) {
				stringValue = convertString(item, "");
			} else {
				stringValue = convertString(item, (String) value);
			}
		} else if (item.getJavaType().equals(Item.TYPE_NUMBER)) {
			if (value == null) {
				stringValue = convertNumber(item, Integer.valueOf(0));
			} else {
				stringValue = convertNumber(item, (Number) value);
			}
		} else if (item.getJavaType().equals(Item.TYPE_DATE)) {
			if (value == null) {
				stringValue = convertString(item, "");
			} else {
				stringValue = convertDate(item, (Date) value, timezone);
			}
		} else if (item.getJavaType().equals(Item.TYPE_BOOLEAN)) {
			if (value == null) {
				stringValue = convertString(item, "");
			} else {
				stringValue = convertBoolean(item, (Boolean) value);
			}
		}
		return stringValue;
	}

	/**
	 * Génération d'une ligne champs par champ dans un Fichier dans lequel on
	 * souhaite ecrire - PrintStream en autoflush
	 * 
	 * @param map
	 *            les valeurs
	 * @param items
	 *            les descriptions
	 * @param printStream
	 *            Fichier dans lequel on ecrit
	 * @param zone
	 *            Zone
	 * @throws TechException
	 *             En cas d'erreur de format
	 */
	public static void genLine(final Map map, final Collection items, final PrintStream printStream, final String zone)
			throws Exception {
		for (final Iterator it = items.iterator(); it.hasNext();) {
			final Item item = (Item) it.next();
			final Object value = map.get(item.getNom());
			final String chaine = MouvementUtil.convertObject(item, value, zone);
			printStream.print(chaine);
		}
		printStream.println();
	}

	/**
	 * Génération d'une ligne champ par champ dans un Fichier dans lequel on
	 * souhaite ecrire puis realise un flush - PrintStream en flush manuel
	 * 
	 * @param map
	 *            les valeurs
	 * @param items
	 *            les descriptions
	 * @param printStream
	 *            Fichier dans lequel on ecrit
	 * @param zone
	 *            Zone
	 * @throws TechException
	 *             En cas d'erreur de format
	 */
	public static void genLineAndFlush(final Map map, final Collection items, final PrintStream printStream,
			final String zone) throws Exception {
		for (final Iterator it = items.iterator(); it.hasNext();) {
			final Item item = (Item) it.next();
			final Object value = map.get(item.getNom());
			final String chaine = MouvementUtil.convertObject(item, value, zone);
			printStream.print(chaine);
		}
		printStream.println();
		printStream.flush();
	}
}
