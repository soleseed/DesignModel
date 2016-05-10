/*
 * @(#)Item.java 16 août 05 Copyright PSA Peugeot Citröen. All rights reserved.
 */
package com.cn.export;

/**
 * Description d'un Champ d'un fichier hierarchique
 * 
 * @version $Revision: 1.6 $
 * @since Globe 2.0
 */
public class Item implements Cloneable {
	/**
	 * Nom
	 */
	private String nom;
	/**
	 * Format cobol
	 */
	private String cobolFormat;
	/**
	 * Taille
	 */
	private int taille;
	/**
	 * Debut zone
	 */
	private int debut;
	/**
	 * Type Java
	 */
	private String javaType = "String";
	/**
	 * Format de conversion
	 */
	private String format;
	/**
	 * Format I18N
	 */
	private String i18nFormat;
	/**
	 * Valeur
	 */
	private String valeur;
	/**
	 * Modifiable
	 */
	private String modifiable = "N";
	/**
	 * Type Booleen
	 */
	public static final String TYPE_BOOLEAN = "Boolean";
	/**
	 * Type Number
	 */
	public static final String TYPE_NUMBER = "Number";
	/**
	 * Type Date
	 */
	public static final String TYPE_DATE = "Date";
	/**
	 * Type String
	 */
	public static final String TYPE_STRING = "String";

	/**
	 * Constructeur Item
	 * 
	 * @param nom
	 *            Nom
	 * @param desc
	 *            Description
	 */
	public Item(final String nom, final String desc) {
		this.nom = nom;
		final String[] fields = desc.split(",");
		this.taille = Integer.valueOf(fields[1]).intValue();
		this.debut = Integer.valueOf(fields[2]).intValue();
		this.cobolFormat = fields[0];
		if (fields.length >= 4) {
			this.javaType = fields[3];
		}
		if (fields.length >= 5) {
			this.format = fields[4];
		}
	}

	/**
	 * toString
	 * 
	 * @return String
	 */
	public String toString() {
		final StringBuilder buf = new StringBuilder(54);
		buf.append("[nom=");
		buf.append(nom);
		buf.append(",cobolFormat=");
		buf.append(cobolFormat);
		buf.append(",taille=");
		buf.append(taille);
		buf.append(",debut=");
		buf.append(debut);
		buf.append(",javaType=");
		buf.append(javaType);
		buf.append(",format=");
		buf.append(format);
		buf.append("]\n");
		return buf.toString();
	}

	/**
	 * Getter I18N
	 * 
	 * @return String
	 */
	public String getI18nFormat() {
		return i18nFormat;
	}

	/**
	 * Setter I18N
	 * 
	 * @param string
	 *            String
	 */
	public void setI18nFormat(final String string) {
		i18nFormat = string;
	}

	/**
	 * Getter Valeur
	 * 
	 * @return String
	 */
	public String getValeur() {
		return valeur;
	}

	/**
	 * Setter Valeur
	 * 
	 * @param string
	 *            String
	 */
	public void setValeur(final String string) {
		valeur = string;
	}

	/**
	 * Getter Format cobol
	 * 
	 * @return String
	 */
	public String getCobolFormat() {
		return cobolFormat;
	}

	/**
	 * Getter Debut
	 * 
	 * @return Position de debut
	 */
	public int getDebut() {
		return debut;
	}

	/**
	 * Getter Format de conversion
	 * 
	 * @return String
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Getter type Java
	 * 
	 * @return String
	 */
	public String getJavaType() {
		return javaType;
	}

	/**
	 * Getter Nom
	 * 
	 * @return String
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Getter Taille
	 * 
	 * @return Taile de la zone a convertir
	 */
	public int getTaille() {
		return taille;
	}

	/**
	 * Setter Format cobol
	 * 
	 * @param string
	 *            String
	 */
	public void setCobolFormat(final String string) {
		cobolFormat = string;
	}

	/**
	 * Setter Debut
	 * 
	 * @param value
	 *            Debut de la zone a convertir
	 */
	public void setDebut(final int value) {
		debut = value;
	}

	/**
	 * Setter Format
	 * 
	 * @param string
	 *            String
	 */
	public void setFormat(final String string) {
		format = string;
	}

	/**
	 * Setter Type Java
	 * 
	 * @param string
	 *            String
	 */
	public void setJavaType(final String string) {
		javaType = string;
	}

	/**
	 * Setter Nom
	 * 
	 * @param string
	 *            String
	 */
	public void setNom(final String string) {
		nom = string;
	}

	/**
	 * Setter Taille de la zone a convertir
	 * 
	 * @param value
	 *            Taille
	 */
	public void setTaille(final int value) {
		taille = value;
	}

	/**
	 * Getter Modifiable
	 * 
	 * @return String
	 */
	public String getModifiable() {
		return modifiable;
	}

	/**
	 * Setter Modifiable
	 * 
	 * @param string
	 *            String
	 */
	public void setModifiable(final String string) {
		modifiable = string;
	}
}