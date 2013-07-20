/*
 * Countries of 3166 iso standard.
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
 *  along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package de.ma.it.common.bo;

import java.util.HashMap;
import java.util.Map;

/**
 * ISO 3166 country codes
 *
 * @author Martin Absmeier
 */
public enum Country { 

	/**  */
	AALAND_ISLANDS("AALAND ISLANDS", "AX", "ALA", Integer.valueOf("248")),
	/**  */
	AFGHANISTAN("AFGHANISTAN", "AF", "AFG", Integer.valueOf("004")),
	/**  */
	ALBANIA("ALBANIA", "AL", "ALB", Integer.valueOf("008")),
	/**  */
	ALGERIA("ALGERIA", "DZ", "DZA", Integer.valueOf("012")),
	/**  */
	AMERICAN_SAMOA("AMERICAN SAMOA", "AS", "ASM", Integer.valueOf("016")),
	/**  */
	ANDORRA("ANDORRA", "AD", " AND", Integer.valueOf("020")),
	/**  */
	ANGOLA("ANGOLA", "AO", "AGO", Integer.valueOf("024")),
	/**  */
	ANGUILLA("ANGUILLA", "AI", "AIA", Integer.valueOf("660")),
	/**  */
	ANTARCTICA("ANTARCTICA", "AQ", "ATA", Integer.valueOf("010")),
	/**  */
	ANTIGUA_AND_BARBUDA("ANTIGUA AND BARBUDA", "AG", "ATG", Integer.valueOf("028")),
	/**  */
	ARGENTINA("ARGENTINA", "AR", "ARG", Integer.valueOf("032")),
	/**  */
	ARMENIA("ARMENIA", "AM", "ARM", Integer.valueOf("051")),
	/**  */
	ARUBA("ARUBA", "AW", "ABW", Integer.valueOf("533")),
	/**  */
	AUSTRALIA("AUSTRALIA", "AU", "AUS", Integer.valueOf("036")),
	/**  */
	AUSTRIA("AUSTRIA", "AT", "AUT", Integer.valueOf("040")),
	/**  */
	AZERBAIJAN("AZERBAIJAN", "AZ", "AZE", Integer.valueOf("031")), 
	/**  */
	BAHAMAS("BAHAMAS", "BS", " BHS", Integer.valueOf("044")),
	/**  */
	BAHRAIN("BAHRAIN", "BH", " BHR", Integer.valueOf("048")),
	/**  */
	BANGLADESH("BANGLADESH", "BD", "BGD", Integer.valueOf("050")),
	/**  */
	BARBADOS("BARBADOS", "BB", "BRB", Integer.valueOf("052")),
	/**  */
	BELARUS("BELARUS", "BY", "BLR", Integer.valueOf("112")),
	/**  */
	BELGIUM("BELGIUM", "BE", "BEL", Integer.valueOf("056")),
	/**  */
	BELIZE("BELIZE", " BZ", "BLZ", Integer.valueOf("084")),
	/**  */
	BENIN("BENIN", "  BJ", "BEN", Integer.valueOf("204")),
	/**  */
	BERMUDA("BERMUDA", "BM", "BMU", Integer.valueOf("060")),
	/**  */
	BHUTAN("BHUTAN", " BT", "BTN", Integer.valueOf("064")),
	/**  */
	BOLIVIA("BOLIVIA", "BO", "BOL", Integer.valueOf("068")),
	/**  */
	BOSNIA_AND_HERZEGOWINA("BOSNIA AND HERZEGOWINA", "BA", "BIH", Integer.valueOf("070")),
	/**  */
	BOTSWANA("BOTSWANA", "BW", "BWA", Integer.valueOf("072")),
	/**  */
	BOUVET_ISLAND("BOUVET ISLAND", "BV", " BVT", Integer.valueOf("074")),
	/**  */
	BRAZIL("BRAZIL", "BR", "BRA", Integer.valueOf("076")),
	/**  */
	BRITISH_INDIAN_OCEAN_TERRITORY("BRITISH INDIAN OCEAN TERRITORY", "IO", "IOT", Integer.valueOf("086")),
	/**  */
	BRUNEI_DARUSSALAM("BRUNEI DARUSSALAM", "BN", "BRN", Integer.valueOf("096")),
	/**  */
	BULGARIA("BULGARIA", "BG", "BGR", Integer.valueOf("100")),
	/**  */
	BURKINA_FASO("BURKINA FASO", "BF", " BFA", Integer.valueOf("854")),
	/**  */
	BURUNDI("BURUNDI", "BI", "BDI", Integer.valueOf("108")),
	/**  */
	CAMBODIA("CAMBODIA", "KH", "KHM", Integer.valueOf("116")),
	/**  */
	CAMEROON("CAMEROON", "CM", "CMR", Integer.valueOf("120")),
	/**  */
	CANADA("CANADA", "CA", "CAN", Integer.valueOf("124")),
	/**  */
	CAPE_VERDE("CAPE VERDE", "CV", "CPV", Integer.valueOf("132")),
	/**  */
	CAYMAN_ISLANDS("CAYMAN ISLANDS", "KY", "CYM", Integer.valueOf("136")),
	/**  */
	CENTRAL_AFRICAN_REPUBLIC("CENTRAL AFRICAN REPUBLIC", " CF", "CAF", Integer.valueOf("140")),
	/**  */
	CHAD("CHAD", "TD", "TCD", Integer.valueOf("148")),
	/**  */
	CHILE("CHILE", "CL", "CHL", Integer.valueOf("152")),
	/**  */
	CHINA("CHINA", "CN", "CHN", Integer.valueOf("156")),
	/**  */
	CHRISTMAS_ISLAND("CHRISTMAS ISLAND", "CX", " CXR", Integer.valueOf("162")),
	/**  */
	COCOS_KEELING_ISLANDS("COCOS (KEELING) ISLANDS", "CC", "CCK", Integer.valueOf("166")),
	/**  */
	COLOMBIA("COLOMBIA", "CO", "COL", Integer.valueOf("170")),
	/**  */
	COMOROS("COMOROS", "KM", "COM", Integer.valueOf("174")),
	/**  */
	CONGO_DEMOCRATIC_REPUBLIC_OF("CONGO, Democratic Republic of (was Zaire)", "CD", "COD", Integer.valueOf("180")),
	/**  */
	CONGO_REPUBLIC_OF("CONGO, Republic of", "CG", "COG", Integer.valueOf("178")),
	/**  */
	COOK_ISLANDS("COOK ISLANDS", "CK", "COK", Integer.valueOf("184")),
	/**  */
	COSTA_RICA("COSTA RICA", "CR", "CRI", Integer.valueOf("188")),
	/**  */
	COTE_D_IVOIRE("COTE D'IVOIRE", "CI", "CIV", Integer.valueOf("384")),
	/**  */
	CROATIA("CROATIA (local name: Hrvatska)", "HR", "HRV", Integer.valueOf("191")),
	/**  */
	CUBA("CUBA", "CU", "CUB", Integer.valueOf("192")),
	/**  */
	CYPRUS("CYPRUS", "CY", "CYP", Integer.valueOf("196")),
	/**  */
	CZECH_REPUBLIC("CZECH REPUBLIC", "CZ", "CZE", Integer.valueOf("203")),
	/**  */
	DENMARK("DENMARK", "DK", "DNK", Integer.valueOf("208")),
	/**  */
	DJIBOUTI("DJIBOUTI", "DJ", "DJI", Integer.valueOf("262")),
	/**  */
	DOMINICA("DOMINICA", "DM", "DMA", Integer.valueOf("212")),
	/**  */
	DOMINICAN_REPUBLIC("DOMINICAN REPUBLIC", "DO", "DOM", Integer.valueOf("214")),
	/**  */
	ECUADOR("ECUADOR", "EC", "ECU", Integer.valueOf("218")),
	/**  */
	EGYPT("EGYPT", "EG", "EGY", Integer.valueOf("818")),
	/**  */
	EL_SALVADOR("EL SALVADOR", "SV", " SLV", Integer.valueOf("222")),
	/**  */
	EQUATORIAL_GUINEA("EQUATORIAL GUINEA", "GQ", "GNQ", Integer.valueOf("226")),
	/**  */
	ERITREA("ERITREA", "ER", "ERI", Integer.valueOf("232")),
	/**  */
	ESTONIA("ESTONIA", "EE", "EST", Integer.valueOf("233")),
	/**  */
	ETHIOPIA("ETHIOPIA", "ET", "ETH", Integer.valueOf("231")),
	/**  */
	FALKLAND_ISLANDS("FALKLAND ISLANDS (MALVINAS)", "FK", "FLK", Integer.valueOf("238")),
	/**  */
	FAROE_ISLANDS("FAROE ISLANDS", " FO", "FRO", Integer.valueOf("234")),
	/**  */
	FIJI("FIJI", "FJ", " FJI", Integer.valueOf("242")),
	/**  */
	FINLAND("FINLAND", "FI", "FIN", Integer.valueOf("246")),
	/**  */
	FRANCE("FRANCE", "FR", "FRA", Integer.valueOf("250")),
	/**  */
	FRENCH_GUIANA("FRENCH GUIANA", "GF", "GUF", Integer.valueOf("254")),
	/**  */
	FRENCH_POLYNESIA("FRENCH POLYNESIA", "PF", "PYF", Integer.valueOf("258")),
	/**  */
	FRENCH_SOUTHERN_TERRITORIES("FRENCH SOUTHERN TERRITORIES", "TF", "ATF", Integer.valueOf("260")),
	/**  */
	GABON("GABON", "GA", "GAB", Integer.valueOf("266")),
	/**  */
	GAMBIA("GAMBIA", "GM", "GMB", Integer.valueOf("270")),
	/**  */
	GEORGIA("GEORGIA", "GE", "GEO", Integer.valueOf("268")),
	/**  */
	GERMANY("GERMANY", "DE", "DEU", Integer.valueOf("276")),
	/**  */
	GHANA("GHANA", "  GH", "GHA", Integer.valueOf("288")),
	/**  */
	GIBRALTAR("GIBRALTAR", "GI", "GIB", Integer.valueOf("292")),
	/**  */
	GREECE("GREECE", " GR", "GRC", Integer.valueOf("300")),
	/**  */
	GREENLAND("GREENLAND", "GL", " GRL", Integer.valueOf("304")),
	/**  */
	GRENADA("GRENADA", "GD", "GRD", Integer.valueOf("308")),
	/**  */
	GUADELOUPE("GUADELOUPE", "GP", "GLP", Integer.valueOf("312")),
	/**  */
	GUAM("GUAM", "GU", "GUM", Integer.valueOf("316")),
	/**  */
	GUATEMALA("GUATEMALA", "GT", "GTM", Integer.valueOf("320")),
	/**  */
	GUINEA("GUINEA", "GN", "GIN", Integer.valueOf("324")),
	/**  */
	GUINEA_BISSAU("GUINEA-BISSAU", "GW", "GNB", Integer.valueOf("624")),
	/**  */
	GUYANA("GUYANA", "GY", "GUY", Integer.valueOf("328")),
	/**  */
	HAITI("HAITI", "HT", "HTI", Integer.valueOf("332")),
	/**  */
	HEARD_AND_MC_DONALD_ISLANDS("HEARD AND MC DONALD ISLANDS", "HM", "HMD", Integer.valueOf("334")),
	/**  */
	HONDURAS("HONDURAS", "HN", "HND", Integer.valueOf("340")),
	/**  */
	HONG_KONG("HONG KONG", "HK", "HKG", Integer.valueOf("344")),
	/**  */
	HUNGARY("HUNGARY", "HU", "HUN", Integer.valueOf("348")),
	/**  */
	ICELAND("ICELAND", "IS", "ISL", Integer.valueOf("352")),
	/**  */
	INDIA("INDIA", "IN", "IND", Integer.valueOf("356")),
	/**  */
	INDONESIA("INDONESIA", "ID", "IDN", Integer.valueOf("360")),
	/**  */
	IRAN("IRAN (ISLAMIC REPUBLIC OF)", "IR", "IRN", Integer.valueOf("364")),
	/**  */
	IRAQ("IRAQ", "IQ", "IRQ", Integer.valueOf("368")),
	/**  */
	IRELAND("IRELAND", "IE", "IRL", Integer.valueOf("372")),
	/**  */
	ISRAEL("ISRAEL", "IL", "ISR", Integer.valueOf("376")),
	/**  */
	ITALY("ITALY", "IT", "ITA", Integer.valueOf("380")),
	/**  */
	JAMAICA("JAMAICA", "JM", "JAM", Integer.valueOf("388")),
	/**  */
	JAPAN("JAPAN", "JP", "JPN", Integer.valueOf("392")),
	/**  */
	JORDAN("JORDAN", "JO", "JOR", Integer.valueOf("400")),
	/**  */
	KAZAKHSTAN("KAZAKHSTAN", "KZ", "KAZ", Integer.valueOf("398")),
	/**  */
	KENYA("KENYA", "KE", "KEN", Integer.valueOf("404")),
	/**  */
	KIRIBATI("KIRIBATI", "KI", "KIR", Integer.valueOf("296")),
	/**  */
	KOREA_DEMOCRATIC_PEOPLES_REPUBLIC_OF("KOREA, DEMOCRATIC PEOPLE'S REPUBLIC OF", "KP", "PRK", Integer.valueOf("408")),
	/**  */
	KOREA_REPUBLIC_OF("KOREA, REPUBLIC OF", "KR", "KOR", Integer.valueOf("410")),
	/**  */
	KUWAIT("KUWAIT", "KW", "KWT", Integer.valueOf("414")),
	/**  */
	KYRGYZSTAN("KYRGYZSTAN", "KG", "KGZ", Integer.valueOf("417")),
	/**  */
	LAO_PEOPLES_DEMOCRATIC_REPUBLIC("LAO PEOPLE'S DEMOCRATIC REPUBLIC", "LA", "LAO", Integer.valueOf("418")),
	/**  */
	LATVIA("LATVIA", "LV", "LVA", Integer.valueOf("428")),
	/**  */
	LEBANON("LEBANON", "LB", "LBN", Integer.valueOf("422")),
	/**  */
	LESOTHO("LESOTHO", "LS", "LSO", Integer.valueOf("426")),
	/**  */
	LIBERIA("LIBERIA", "LR", " LBR", Integer.valueOf("430")),
	/**  */
	LIBYAN_ARAB_JAMAHIRIYA("LIBYAN ARAB JAMAHIRIYA", "LY", "LBY", Integer.valueOf("434")),
	/**  */
	LIECHTENSTEIN("LIECHTENSTEIN", "LI", "LIE", Integer.valueOf("438")),
	/**  */
	LITHUANIA("LITHUANIA", "LT", "LTU", Integer.valueOf("440")),
	/**  */
	LUXEMBOURG("LUXEMBOURG", "LU", "LUX", Integer.valueOf("442")),
	/**  */
	MACAU("MACAU", "MO", "MAC", Integer.valueOf("446")),
	/**  */
	MACEDONIA("MACEDONIA, THE FORMER YUGOSLAV REPUBLIC OF", "MK", "MKD", Integer.valueOf("807")),
	/**  */
	MADAGASCAR("MADAGASCAR", "MG", "MDG", Integer.valueOf("450")),
	/**  */
	MALAWI("MALAWI", "MW", "MWI", Integer.valueOf("454")),
	/**  */
	MALAYSIA("MALAYSIA", "MY", "MYS", Integer.valueOf("458")),
	/**  */
	MALDIVES("MALDIVES", "MV", "MDV", Integer.valueOf("462")),
	/**  */
	MALI("MALI", "ML", "MLI", Integer.valueOf("466")),
	/**  */
	MALTA("MALTA", "MT", "MLT", Integer.valueOf("470")),
	/**  */
	MARSHALL("MARSHALL ISLANDS", "MH", " MHL", Integer.valueOf("584")),
	/**  */
	MARTINIQUE("MARTINIQUE", "MQ", "MTQ", Integer.valueOf("474")),
	/**  */
	MAURITANIA("MAURITANIA", "MR", "MRT", Integer.valueOf("478")),
	/**  */
	MAURITIUS("MAURITIUS", "MU", "MUS", Integer.valueOf("480")),
	/**  */
	MAYOTTE("MAYOTTE", "YT", "MYT", Integer.valueOf("175")),
	/**  */
	MEXICO("MEXICO", "MX", "MEX", Integer.valueOf("484")),
	/**  */
	MICRONESIA_FEDERATED_STATES_OF("MICRONESIA, FEDERATED STATES OF", "FM", "FSM", Integer.valueOf("583")),
	/**  */
	MOLDOVA("MOLDOVA, REPUBLIC OF", "MD", "MDA", Integer.valueOf("498")),
	/**  */
	MONACO("MONACO", "MC", "MCO", Integer.valueOf("492")),
	/**  */
	MONGOLIA("MONGOLIA", "MN", "MNG", Integer.valueOf("496")),
	/**  */
	MONTSERRAT("MONTSERRAT", "MS", "MSR", Integer.valueOf("500")),
	/**  */
	MOROCCO("MOROCCO", "MA", "MAR", Integer.valueOf("504")),
	/**  */
	MOZAMBIQUE("MOZAMBIQUE", "MZ", "MOZ", Integer.valueOf("508")),
	/**  */
	MYANMAR("MYANMAR", "MM", "MMR", Integer.valueOf("104")),
	/**  */
	NAMIBIA("NAMIBIA", "NA", "NAM", Integer.valueOf("516")),
	/**  */
	NAURU("NAURU", "NR", "NRU", Integer.valueOf("520")),
	/**  */
	NEPAL("NEPAL", "NP", "NPL", Integer.valueOf("524")),
	/**  */
	NETHERLANDS("NETHERLANDS", "NL", "NLD", Integer.valueOf("528")),
	/**  */
	NETHERLANDS_ANTILLES("NETHERLANDS ANTILLES", "AN", "ANT", Integer.valueOf("530")),
	/**  */
	NEW_CALEDONIA("NEW CALEDONIA", "NC", "NCL", Integer.valueOf("540")),
	/**  */
	NEW_ZEALAND("NEW ZEALAND", "NZ", "NZL", Integer.valueOf("554")),
	/**  */
	NICARAGUA("NICARAGUA", "NI", "NIC", Integer.valueOf("558")),
	/**  */
	NIGER("NIGER", "  NE", "NER", Integer.valueOf("562")),
	/**  */
	NIGERIA("NIGERIA", "NG", "NGA", Integer.valueOf("566")),
	/**  */
	NIUE("NIUE", "   NU", "NIU", Integer.valueOf("570")),
	/**  */
	NORFOLK_ISLAND("NORFOLK ISLAND", "NF", "NFK", Integer.valueOf("574")),
	/**  */
	NORTHERN_MARIANA_ISLANDS("NORTHERN MARIANA ISLANDS", " MP", " MNP", Integer.valueOf("580")),
	/**  */
	NORWAY("NORWAY", "NO", " NOR", Integer.valueOf("578")),
	/**  */
	OMAN("OMAN", "OM", "OMN", Integer.valueOf("512")),
	/**  */
	PAKISTAN("PAKISTAN", "PK", "PAK", Integer.valueOf("586")),
	/**  */
	PALAU("PALAU", "PW", "PLW", Integer.valueOf("585")),
	/**  */
	PALESTINIAN_TERRITORY_OCCUPIED("PALESTINIAN TERRITORY, Occupied", "PS", "PSE", Integer.valueOf("275")),
	/**  */
	PANAMA("PANAMA", "PA", "PAN", Integer.valueOf("591")),
	/**  */
	PAPUA_NEW_GUINEA("PAPUA NEW GUINEA", "PG", " PNG", Integer.valueOf("598")),
	/**  */
	PARAGUAY("PARAGUAY", "PY", "PRY", Integer.valueOf("600")),
	/**  */
	PERU("PERU", "PE", "PER", Integer.valueOf("604")),
	/**  */
	PHILIPPINES("PHILIPPINES", "PH", "PHL", Integer.valueOf("608")),
	/**  */
	PITCAIRN("PITCAIRN", "PN", "PCN", Integer.valueOf("612")),
	/**  */
	POLAND("POLAND", "PL", "POL", Integer.valueOf("616")),
	/**  */
	PORTUGAL("PORTUGAL", "PT", "PRT", Integer.valueOf("620")),
	/**  */
	PUERTO_RICO("PUERTO RICO", "PR", "PRI", Integer.valueOf("630")),
	/**  */
	QATAR("QATAR", "QA", "QAT", Integer.valueOf("634")),
	/**  */
	REUNION("REUNION", "RE", "REU", Integer.valueOf("638")),
	/**  */
	ROMANIA("ROMANIA", "RO", "ROU", Integer.valueOf("642")),
	/**  */
	RUSSIAN_FEDERATION("RUSSIAN FEDERATION", "RU", "RUS", Integer.valueOf("643")),
	/**  */
	RWANDA("RWANDA", "RW", "RWA", Integer.valueOf("646")),
	/**  */
	SAINT_HELENA("SAINT HELENA", "SH", "SHN", Integer.valueOf("654")),
	/**  */
	SAINT_KITTS_AND_NEVIS("SAINT KITTS AND NEVIS", "KN", "KNA", Integer.valueOf("659")),
	/**  */
	SAINT_LUCIA("SAINT LUCIA", "LC", "LCA", Integer.valueOf("662")),
	/**  */
	SAINT_PIERRE_AND_MIQUELON("SAINT PIERRE AND MIQUELON", "PM", "SPM", Integer.valueOf("666")),
	/**  */
	SAINT_VINCENT_AND_THE_GRENADINES("SAINT VINCENT AND THE GRENADINES", "VC", "VCT", Integer.valueOf("670")),
	/**  */
	SAMOA("SAMOA", "WS", "WSM", Integer.valueOf("882")),
	/**  */
	SAN_MARINO("SAN MARINO", "SM", "SMR", Integer.valueOf("674")),
	/**  */
	SAO_TOME_AND_PRINCIPE("SAO TOME AND PRINCIPE", "ST", "STP", Integer.valueOf("678")),
	/**  */
	SAUDI_ARABIA("SAUDI ARABIA", "SA", " SAU", Integer.valueOf("682")),
	/**  */
	SENEGAL("SENEGAL", "SN", "SEN", Integer.valueOf("686")),
	/**  */
	SERBIA_AND_MONTENEGRO("SERBIA AND MONTENEGRO", "CS", "SCG", Integer.valueOf("891")),
	/**  */
	SEYCHELLES("SEYCHELLES", "SC", "SYC", Integer.valueOf("690")),
	/**  */
	SIERRA_LEONE("SIERRA LEONE", "SL", "SLE", Integer.valueOf("694")),
	/**  */
	SINGAPORE("SINGAPORE", "SG", "SGP", Integer.valueOf("702")),
	/**  */
	SLOVAKIA("SLOVAKIA", "SK", "SVK", Integer.valueOf("703")),
	/**  */
	SLOVENIA("SLOVENIA", "SI", "SVN", Integer.valueOf("705")),
	/**  */
	SOLOMON_ISLANDS("SOLOMON ISLANDS", "SB", "SLB", Integer.valueOf("090")),
	/**  */
	SOMALIA("SOMALIA", "SO", "SOM", Integer.valueOf("706")),
	/**  */
	SOUTH_AFRICA("SOUTH AFRICA", "ZA", "ZAF", Integer.valueOf("710")),
	/**  */
	SOUTH_GEORGIA_AND_THE_SOUTH_SANDWICH_ISLANDS("SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS", "GS", "SGS", Integer.valueOf("239")),
	/**  */
	SPAIN("SPAIN", "ES", "ESP", Integer.valueOf("724")),
	/**  */
	SRI_LANKA("SRI LANKA", "LK", "LKA", Integer.valueOf("144")),
	/**  */
	SUDAN("SUDAN", "SD", "SDN", Integer.valueOf("736")),
	/**  */
	SURINAME("SURINAME", "SR", "SUR", Integer.valueOf("740")),
	/**  */
	SVALBARD_AND_JAN_MAYEN_ISLANDS("SVALBARD AND JAN MAYEN ISLANDS", "SJ", "SJM", Integer.valueOf("744")),
	/**  */
	SWAZILAND("SWAZILAND", "SZ", "SWZ", Integer.valueOf("748")),
	/**  */
	SWEDEN("SWEDEN", "SE", "SWE", Integer.valueOf("752")),
	/**  */
	SWITZERLAND("SWITZERLAND", "CH", "CHE", Integer.valueOf("756")),
	/**  */
	SYRIAN_ARAB_REPUBLIC("SYRIAN ARAB REPUBLIC", "SY", "SYR", Integer.valueOf("760")),
	/**  */
	TAIWAN("TAIWAN", "TW", "TWN", Integer.valueOf("158")),
	/**  */
	TAJIKISTAN("TAJIKISTAN", "TJ", "TJK", Integer.valueOf("762")),
	/**  */
	TANZANIA("TANZANIA, UNITED REPUBLIC OF", "TZ", "TZA", Integer.valueOf("834")),
	/**  */
	THAILAND("THAILAND", "TH", "THA", Integer.valueOf("764")),
	/**  */
	TIMOR_LESTE("TIMOR-LESTE", "TL", "TLS", Integer.valueOf("626")),
	/**  */
	TOGO("TOGO", "TG", "TGO", Integer.valueOf("768")),
	/**  */
	TOKELAU("TOKELAU", "TK", "TKL", Integer.valueOf("772")),
	/**  */
	TONGA("TONGA", "TO", "TON", Integer.valueOf("776")),
	/**  */
	TRINIDAD_AND_TOBAGO("TRINIDAD AND TOBAGO", "TT", "TTO", Integer.valueOf("780")),
	/**  */
	TUNISIA("TUNISIA", "TN", "TUN", Integer.valueOf("788")),
	/**  */
	TURKEY("TURKEY", "TR", "TUR", Integer.valueOf("792")),
	/**  */
	TURKMENISTAN("TURKMENISTAN", "TM", "TKM", Integer.valueOf("795")),
	/**  */
	TURKS_AND_CAICOS_ISLANDS("TURKS AND CAICOS ISLANDS", "TC", "TCA", Integer.valueOf("796")),
	/**  */
	TUVALU("TUVALU", "TV", "TUV", Integer.valueOf("798")),
	/**  */
	UGANDA("UGANDA", "UG", "UGA", Integer.valueOf("800")),
	/**  */
	UKRAINE("UKRAINE", "UA", "UKR", Integer.valueOf("804")),
	/**  */
	UNITED_ARAB_EMIRATES("UNITED ARAB EMIRATES", "AE", "ARE", Integer.valueOf("784")),
	/**  */
	UNITED_KINGDOM("UNITED KINGDOM", "GB", "GBR", Integer.valueOf("826")),
	/**  */
	UNITED_STATES("UNITED STATES", "US", "USA", Integer.valueOf("840")),
	/**  */
	UNITED_STATES_MINOR_OUTLYING_ISLANDS("UNITED STATES MINOR OUTLYING ISLANDS", "UM", "UMI", Integer.valueOf("581")),
	/**  */
	URUGUAY("URUGUAY", "UY", "URY", Integer.valueOf("858")),
	/**  */
	UZBEKISTAN("UZBEKISTAN", "UZ", "UZB", Integer.valueOf("860")),
	/**  */
	VANUATU("VANUATU", "VU", "VUT", Integer.valueOf("548")),
	/**  */
	VATICAN_CITY_STATE("VATICAN CITY STATE (HOLY SEE)", "VA", "VAT", Integer.valueOf("336")),
	/**  */
	VENEZUELA("VENEZUELA", "VE", "VEN", Integer.valueOf("862")),
	/**  */
	VIET_NAM("VIET NAM", "VN", "VNM", Integer.valueOf("704")),
	/**  */
	VIRGIN_ISLANDS_GB("VIRGIN ISLANDS (BRITISH)", "VG", "VGB", Integer.valueOf("092")),
	/**  */
	VIRGIN_ISLANDS_US("VIRGIN ISLANDS (U.S.)", "VI", "VIR", Integer.valueOf("850")),
	/**  */
	WALLIS_AND_FUTUNA_ISLANDS("WALLIS AND FUTUNA ISLANDS", "WF", "WLF", Integer.valueOf("876")),
	/**  */
	WESTERN_SAHARA("WESTERN SAHARA", "EH", "ESH", Integer.valueOf("732")),
	/**  */
	YEMEN("YEMEN", "YE", "YEM", Integer.valueOf("887")),
	/**  */
	ZAMBIA("ZAMBIA", "ZM", "ZMB", Integer.valueOf("894")),
	/**  */
	ZIMBABWE("ZIMBABWE", "ZW", "ZWE", Integer.valueOf("716"));
	
	/* --------------------------------------------------------------------- */
	
	private static final Map<Integer, Country> NR_LOOKUP_MAP = new HashMap<Integer, Country>();

	private static final Map<String, Country> A2_LOOKUP_MAP = new HashMap<String, Country>();

	private static final Map<String, Country> A3_LOOKUP_MAP = new HashMap<String, Country>();
	
	static {
		for (Country country : values()) {
			NR_LOOKUP_MAP.put(country.getNumber(), country);
			A2_LOOKUP_MAP.put(country.getISOCodeA2(), country);
			A3_LOOKUP_MAP.put(country.getISOCodeA3(), country);
		}
	}

	/* --------------------------------------------------------------------- */

	private Integer number;
	
	private String isoCodeA2;

	private String isoCodeA3;
	
	private String country;

	/* --------------------------------------------------------------------- */

	public static Country getByNumer(Integer number) {
		return NR_LOOKUP_MAP.get(number);
	}
	
	public static Country getByISOCode(String isoCode) {
		if (isoCode.length() == 2) {
			return A2_LOOKUP_MAP.get(isoCode);
		}
		return A3_LOOKUP_MAP.get(isoCode);
	}
	
	/* --------------------------------------------------------------------- */
	
	/**
	 * Getter of field number
	 *
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * Getter of field isoCodeA2
	 *
	 * @return the isoCodeA2
	 */
	public String getISOCodeA2() {
		return isoCodeA2;
	}

	/**
	 * Getter of field isoCodeA3
	 *
	 * @return the isoCodeA3
	 */
	public String getISOCodeA3() {
		return isoCodeA3;
	}

	/**
	 * Getter of field country
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/* --------------------------------------------------------------------- */

	private Country(String country, String isoCodeA2, String isoCodeA3, Integer number) {
		this.country = country;
		this.isoCodeA2 = isoCodeA2;
		this.isoCodeA3 = isoCodeA3;
		this.number = number;
	}

}
