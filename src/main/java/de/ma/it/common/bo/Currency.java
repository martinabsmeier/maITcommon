/*
 * Currency iso codes.
 * Copyright (C) 2012 Martin Absmeier, IT Consulting Services
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.ma.it.common.bo;

import java.util.HashMap;
import java.util.Map;

/**
 * Currency iso codes
 *
 * @author Martin Absmeier
 */
public enum Currency {

	/** Vereinigte Arabische Emirate */
	AED("AED", Integer.valueOf("784"), "Dirham"),
	/** Afghanistan */
	AFN("AFN", Integer.valueOf("971"), "Afghani"),
	/** Albanien */
	ALL("ALL", Integer.valueOf("008"), "Lek"),
	/** Armenien */
	AMD("AMD", Integer.valueOf("051"), "Dram"),
	/** Angola */
	AOA("AOA", Integer.valueOf("973"), "Kwanza"),
	/** Argentinien */
	ARS("ARS", Integer.valueOf("032"), "Peso"),
	/** Australien, Kiribati, Nauru, Tuvalu */
	AUD("AUD", Integer.valueOf("036"), "Dollar"),
	/** Aruba */
	AWG("AWG", Integer.valueOf("533"), "Florin"),
	/** Aserbaidschan */
	AZN("AZN", Integer.valueOf("944"), "Manat"),
	/** Bosnien und Herzegowina */
	BAM("BAM", Integer.valueOf("977"), "Konvertible Mark"),
	/** Barbados */
	BBD("BBD", Integer.valueOf("052"), "Dollar"),
	/**  */
	BDT("BDT", Integer.valueOf("050"), "Taka"),	
	/** Bulgarien */
	BGN("BGN", Integer.valueOf("975"), "Lew"),
	/** Bahrain */
	BHD("BHD", Integer.valueOf("048"), "Dinar"),
	/** Burundi */
	BIF("BIF", Integer.valueOf("108"), "Franc"),
	/** Bermuda */
	BMD("BMD", Integer.valueOf("060"), "Dollar"),
	/** Brunei */
	BND("BND", Integer.valueOf("096"), "Dollar"),	
	/** Bolivien 1987 */
	BOB("BOB", Integer.valueOf("068"), "Boliviano"),
	/** Bolivien */
	BOV("BOV", Integer.valueOf("984"), "Mvdol"),
	/** Brasilien */
	BRL("BRL", Integer.valueOf("986"), "Real"),
	/** Bahamas */
	BSD("BSD", Integer.valueOf("044"), "Dollar"),
	/** Bhutan */
	BTN("BTN", Integer.valueOf("064"), "Ngultrum"),
	/** Botswana */
	BWP("BWP", Integer.valueOf("072"), "Pula"),
	/** Weißrussland */
	BYR("BYR", Integer.valueOf("974"), "Rubel"),
	/** Belize */
	BZD("BZD", Integer.valueOf("084"), "Dollar"),
	/** Kanada */
	CAD("CAD", Integer.valueOf("124"), "Dollar"),
	/** Demokratische Republik Kongo */
	CDF("CDF", Integer.valueOf("976"), "Franc"),
	/** Schweiz */
	CHE("CHE", Integer.valueOf("947"), "WIR Euro"),	
	/** Schweiz, Liechtenstein */
	CHF("CHF", Integer.valueOf("756"), "Schweizer Franken"),
	/** Schweiz */
	CHW("CHW", Integer.valueOf("948"), "WIR Franc"),
	/** Chile */
	CLF("CLF", Integer.valueOf("990"), "Unidad de Fomento"),
	/** Chile */
	CLP("CLP", Integer.valueOf("152"), "Peso"),
	/**  */
	CMG("CMG", Integer.valueOf(""), "Karibischer Gulden"),
	/** Volksrepublik China */
	CNY("CNY", Integer.valueOf("156"), "Renminbi Yuan"),
	/** Kolumbien 1872 */
	COP("COP", Integer.valueOf("170"), "Peso"),
	/** Kolumbien */
	COU("COU", Integer.valueOf("970"), "Unidad de Valor Real"), 	
	/** Costa Rica */
	CRC("CRC", Integer.valueOf("188"), "Col�n"),
	/** Kuba 1994 */
	CUC("CUC", Integer.valueOf(""), "Peso Convertible"),
	/** Kuba */
	CUP("CUP", Integer.valueOf("192"), "Peso"),
	/** Kap Verde */
	CVE("CVE", Integer.valueOf("132"), "Escudo"),
	/** Tschechien */
	CZK("CZK", Integer.valueOf("203"), "Krone"),
	/** Dschibuti */
	DJF("DJF", Integer.valueOf("262"), "Franc"),	
	/** Dänemark (inkl. Faröer und Grönland) */
	DKK("DKK", Integer.valueOf("208"), "Krone"),
	/** Dominikanische Republik */
	DOP("DOP", Integer.valueOf("214"), "Peso"),
	/** Algerien */
	DZD("DZD", Integer.valueOf("012"), "Dinar"),
	/** Ägypten */
	EGP("EGP", Integer.valueOf("818"), "Pfund"),
	/** Eritrea */
	ERN("ERN", Integer.valueOf("232"), "Nakfa"),
	/**  */
	ETB("ETB", Integer.valueOf("230"), "Birr"),
	/**
	 * Europäische Währungsunion<br>
	 * Belgien, Deutschland, Estland, Finnland, Frankreich, Griechenland, Irland, Italien, Luxemburg, Malta, Niederlande, Österreich, 
	 * Portugal, Slowakei, Slowenien, Spanien, Zypern) sowie Andorra, Kosovo, Monaco, Montenegro, San Marino, Vatikanstadt
	 */
	EUR("EUR", Integer.valueOf("978"), "Euro"),
	/** Fidschi */
	FJD("FJD", Integer.valueOf("242"), "Dollar"),
	/** Falklandinseln */
	FKP("FKP", Integer.valueOf("238"), "Pfund"),
	/** Vereinigtes Königreich */
	GBP("GBP", Integer.valueOf("826"), "Pfund"),	
	/** Georgien */
	GEL("GEL", Integer.valueOf("981"), "Lari"),
	/** Ghana */
	GHS("GHS", Integer.valueOf("936"), "Ghana Cedi"),
	/** Gibraltar */
	GIP("GIP", Integer.valueOf("292"), "Pfund"),	
	/** Gambia */
	GMD("GMD", Integer.valueOf("270"), "Dalasi"),	
	/** Guinea */
	GNF("GNF", Integer.valueOf("324"), "Franc"), 	
	/** Guatemala */
	GTQ("GTQ", Integer.valueOf("320"), "Quetzal"), 	
	/** Guyana */
	GYD("GYD", Integer.valueOf("328"), "Dollar"),
	/** Hongkong */
	HKD("HKD", Integer.valueOf("344"), "Dollar"),
	/** Honduras */
	HNL("HNL", Integer.valueOf("340"), "Lempira"),	
	/** Kroatien */
	HRK("HRK", Integer.valueOf("191"), "Kuna"),	
	/** Haiti */
	HTG("HTG", Integer.valueOf("332"), "Gourde"),	
	/** Ungarn */
	HUF("HUF", Integer.valueOf("348"), "Forint"),
	/** Indonesien */
	IDR("IDR", Integer.valueOf("360"), "Rupiah"),
	/** Israel, Palästinensische Autonomiegebiete */
	ILS("ILS", Integer.valueOf("376"), "Schekel"),
	/** Indien */
	INR("INR", Integer.valueOf("356"), "Rupie"),
	/** Irak */
	IQD("IQD", Integer.valueOf("368"), "Dinar"),
	/** Iran */
	IRR("IRR", Integer.valueOf("364"), "Rial"),
	/** Island */
	ISK("ISK", Integer.valueOf("352"), "Krone"),
	/** Jamaika */
	JMD("JMD", Integer.valueOf("388"), "Dollar"),
	/** Jordanien */
	JOD("JOD", Integer.valueOf("400"), "Dinar"),
	/** Japan */
	JPY("JPY", Integer.valueOf("392"), "Yen"),	
	/** Kenia */
	KES("KES", Integer.valueOf("404"), "Schilling"), 	
	/** Kirgisistan */
	KGS("KGS", Integer.valueOf("417"), "Som"),
	/** Kambodscha */
	KHR("KHR", Integer.valueOf("116"), "Riel"),	
	/** Komoren */
	KMF("KMF", Integer.valueOf("174"), "Franc"),	
	/** Nordkorea */
	KPW("KPW", Integer.valueOf("408"), "Won"),	
	/** Südkorea */
	KRW("KRW", Integer.valueOf("410"), "Won"),	
	/** Kuwait */
	KWD("KWD", Integer.valueOf("414"), "Dinar"),	
	/** Kaimaninseln */
	KYD("KYD", Integer.valueOf("136"), "Dollar"),
	/** Kasachstan */
	KZT("KZT", Integer.valueOf("398"), "Tenge"),	
	/** Laos  */
	LAK("LAK", Integer.valueOf("418"), "Kip"), 	
	/** Libanon */
	LBP("LBP", Integer.valueOf("422"), "Pfund"), 	
	/** Sri Lanka */
	LKR("LKR", Integer.valueOf("144"), "Rupie"), 	
	/** Liberia */
	LRD("LRD", Integer.valueOf("430"), "Dollar"), 	
	/** Lesotho */
	LSL("LSL", Integer.valueOf("426"), "Loti"),	 	
	/** Litauen */
	LTL("LTL", Integer.valueOf("440"), "Litas"), 	
	/** Lettland */
	LVL("LVL", Integer.valueOf("428"), "Lats"), 	
	/** Libyen */
	LYD("LYD", Integer.valueOf("434"), "Dinar"),	
	/** Marokko, Westsahara */
	MAD("MAD", Integer.valueOf("504"), "Dirham"), 	
	/** Moldawien */
	MDL("MDL", Integer.valueOf("498"), "Leu"), 	
	/** Madagaskar */
	MGA("MGA", Integer.valueOf("969"), "Ariary"),
	/** Mazedonien */
	MKD("MKD", Integer.valueOf("807"), "Denar"),
	/** Myanmar */
	MMK("MMK", Integer.valueOf("104"), "Kyat"), 	
	/** Mongolei */
	MNT("MNT", Integer.valueOf("496"), "T�gr�g"),	
	/** Macao */
	MOP("MOP", Integer.valueOf("446"), "Pataca"), 	
	/** Mauretanien */
	MRO("MRO", Integer.valueOf("478"), "Ouguiya"), 	
	/** Mauritius */
	MUR("MUR", Integer.valueOf("480"), "Rupie"),	
	/** Malediven 1981 */
	MVR("MVR", Integer.valueOf("462"), "Rufiyaa"),
	/** Malawi */
	MWK("MWK", Integer.valueOf("454"), "Kwacha"),	
	/** Mexiko 1992 */
	MXN("MXN", Integer.valueOf("484"), "Peso"),
	/** Mexiko */
	MXV("MXV", Integer.valueOf("979"), "Unidad de Inversion"),	
	/** Malaysia */
	MYR("MYR", Integer.valueOf("458"), "Ringgit"),	
	/** Mosambik 1. Juli 2006 */
	MZN("MZN", Integer.valueOf("943"), "Metical"),
	/** Namibia */
	NAD("NAD", Integer.valueOf("516"), "Dollar"),	
	/** Nigeria */
	NGN("NGN", Integer.valueOf("566"), "Naira"),	
	/** Nicaragua 1990 */
	NIO("NIO", Integer.valueOf("558"), "Côrdoba Oro"),
	/** Norwegen */
	NOK("NOK", Integer.valueOf("578"), "Krone"),	
	/** Nepal */
	NPR("NPR", Integer.valueOf("524"), "Rupie"), 	
	/** Neuseeland, Niue, Pitcairninseln */
	NZD("NZD", Integer.valueOf("554"), "Dollar"),	
	/** Oman */
	OMR("OMR", Integer.valueOf("512"), "Rial"),		
	/** Panama */
	PAB("PAB", Integer.valueOf("590"), "Balboa"), 	
	/** Peru */
	PEN("PEN", Integer.valueOf("604"), ""),
	/** Papua-Neuguinea */
	PGK("PGK", Integer.valueOf("598"), "Kina"),	
	/** Philippinen */
	PHP("PHP", Integer.valueOf("608"), "Peso"),	
	/** Pakistan */
	PKR("PKR", Integer.valueOf("586"), "Rupie"),	
	/** Polen */
	PLN("PLN", Integer.valueOf("985"), "Zloty"),
	/** Paraguay */
	PYG("PYG", Integer.valueOf("600"), "Guaranó"),	
	/** Katar */
	QAR("QAR", Integer.valueOf("634"), "Riyal"), 	
	/** Rum�nien 2005 */
	RON("RON", Integer.valueOf("946"), "Leu"),
	/** Serbien 2006 */
	RSD("RSD", Integer.valueOf("941"), "Dinar"),
	/** Russland 1998 */
	RUB("RUB", Integer.valueOf("643"), "Rubel"),
	/** Ruanda */
	RWF("RWF", Integer.valueOf("646"), "Franc"),	
	/** Saudi-Arabien */
	SAR("SAR", Integer.valueOf("682"), "Riyal"), 	
	/** Salomonen */
	SBD("SBD", Integer.valueOf("090"), "Dollar"),	
	/** Seychellen */
	SCR("SCR", Integer.valueOf("690"), "Rupie"), 	
	/** Sudan 1. Juli 2007 */
	SDG("SDG", Integer.valueOf("938"), "Sudanesisches Pfund"),
	/** Südsudan 18. Juli 2011 */
	SSP("SSP", Integer.valueOf("225"), "Südsudanesisches Pfund"),
	/** Schweden */
	SEK("SEK", Integer.valueOf("752"), "Krone"),	
	/** Singapur */
	SGD("SGD", Integer.valueOf("702"), "Dollar"),	
	/** St. Helena, Ascension und Tristan da Cunha */
	SHP("SHP", Integer.valueOf("654"), "Pfund"), 	
	/** Sierra Leone */
	SLL("SLL", Integer.valueOf("694"), "Leone"),	
	/** Somalia */
	SOS("SOS", Integer.valueOf("706"), "Schilling"), 	
	/** Suriname 2004 */
	SRD("SRD", Integer.valueOf("968"), "Dollar"),
	/** S�o Tom� und Pr�ncipe */
	STD("STD", Integer.valueOf("678"), "Dobra"), 	
	/** El Salvador */
	SVC("SVC", Integer.valueOf("222"), "Col�n"), 	
	/** Syrien */
	SYP("SYP", Integer.valueOf("760"), "Lira"),	
	/** Swasiland */
	SZL("SZL", Integer.valueOf("748"), "Lilangeni"),	
	/** Thailand */
	THB("THB", Integer.valueOf("764"), "Baht"),	
	/** Tadschikistan 6. November 2000 */
	TJS("TJS", Integer.valueOf("972"), "Somoni"),
	/** Turkmenistan 2009 */
	TMT("TMT", Integer.valueOf("934"), "Manat"),
	/** Tunesien */
	TND("TND", Integer.valueOf("788"), "Dinar"), 	
	/** Tonga */
	TOP("TOP", Integer.valueOf("776"), "776"),	
	/** Türkei, Nordzypern 	2005 */
	TRY("TRY", Integer.valueOf("949"), "Lira"),
	/** Trinidad und Tobago */
	TTD("TTD", Integer.valueOf("780"), "Dollar"),	
	/** Republik China (Taiwan) */
	TWD("TWD", Integer.valueOf("901"), "Dollar"), 	
	/** Tansania */
	TZS("TZS", Integer.valueOf("834"), "Schilling"),	
	/** Ukraine */
	UAH("UAH", Integer.valueOf("980"), "Hrywnja"),	
	/** Uganda */
	UGX("UGX", Integer.valueOf("800"), "Schilling"), 	
	/** 
	 * Vereinigte Staaten, Ecuador, El Salvador, Föderierte Staaten von Mikronesien, Marshallinseln, Osttimor, Palau sowie die britischen 
	 * Überseegebiete Britische Jungferninseln und Turks- und Caicosinseln 
	 */
	USD("USD", Integer.valueOf("840"), "Dollar"),	 	
	/** Uruguay */
	UYI("UYI", Integer.valueOf("940"), "Peso en Unidades Indexadas"), 	
	/** Uruguay */
	UYU("UYU", Integer.valueOf("858"), "Peso"),
	/** Usbekistan */
	UZS("UZS", Integer.valueOf("860"), "So'm"),	 	
	/** Venezuela */
	VEF("VEF", Integer.valueOf("937"), "Bolívar"),
	/** Vietnam */
	VND("VND", Integer.valueOf("704"), "Dong"),	
	/** Vanuatu */
	VUV("VUV", Integer.valueOf("548"), "Vatu"),	
	/** Samoa */
	WST("WST", Integer.valueOf("882"), "Tala"),		
	/** Zentralafrikanische Wirtschafts- und Währungsunion (Äquatorialguinea, Gabun, Kamerun, Republik Kongo, Tschad, Zentralafrikanische Republik) */
	XAF("XAF", Integer.valueOf("950"), "CFA-Franc"),	 	
	/** 
	 * Ostkaribische Währungsunion (Antigua und Barbuda, Dominica, Grenada, St. Kitts und Nevis, St. Lucia, St. 
	 * Vincent und die Grenadinen sowie die britischen Überseegebiete Anguilla und Montserrat) 
	 */
	XCD("XCD", Integer.valueOf("951"), "Dollar"),
	/** Westafrikanische Wirtschafts- und Währungsunion (Benin, Burkina Faso, Elfenbeinküste, Guinea-Bissau, Mali, Niger, Senegal, Togo) */
	XOF("XOF", Integer.valueOf("952"), ""), 	 	
	/** Französisch-Polynesien, Neukaledonien, Wallis und Futuna */
	XPF("XPF", Integer.valueOf("953"), "Franc"),	
	/** Jemen */
	YER("YER", Integer.valueOf("886"), "Rial"),	
	/** Südafrika, Lesotho, Swasiland */
	ZAR("ZAR", Integer.valueOf("710"), "Rand"),
	/** Sambia */
	ZMK("ZMK", Integer.valueOf("894"), "Kwacha"),	
	/** Simbabwe 1. August 2008 */
	ZWR("ZWR", Integer.valueOf("935"), "Dollar");
	
	/* --------------------------------------------------------------------- */

	private static final Map<Integer, Currency> NR_LOOKUP_MAP = new HashMap<Integer, Currency>();

	private static final Map<String, Currency> ISO_LOOKUP_MAP = new HashMap<String, Currency>();
	
	static {
		for (Currency currency : values()) {
			NR_LOOKUP_MAP.put(currency.getNumber(), currency);
			ISO_LOOKUP_MAP.put(currency.getISOCode(), currency);
		}
	}

	/* --------------------------------------------------------------------- */

	private String isoCode;
	
	private Integer number;
	
	private String currency;
	
	private String countryNr;
	
	/* --------------------------------------------------------------------- */

	public static Currency getByNumer(Integer number) {
		return NR_LOOKUP_MAP.get(number);
	}

	public static Currency getByISOCode(String isoCode) {
		if (isoCode.length() == 2) {
			return ISO_LOOKUP_MAP.get(isoCode);
		}
		return ISO_LOOKUP_MAP.get(isoCode);
	}

	/* --------------------------------------------------------------------- */
	
	/**
	 * Getter of field isoCode
	 *
	 * @return the isoCode
	 */
	public String getISOCode() {
		return isoCode;
	}

	/**
	 * Getter of field number
	 *
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * Getter of field currency
	 *
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Getter of field countryNr
	 *
	 * @return the countryNr
	 */
	public String getCountryNr() {
		return countryNr;
	}
	
	/* --------------------------------------------------------------------- */
	
	private Currency(String isoCode, Integer number, String currency) {
		this.isoCode = isoCode;
		this.number = number;
		this.currency = currency;
	}

}
