package edu.csbsju;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class SearchControllerTest {
	private SearchController sc;
	
	@Before
	public void setUp() throws Exception {
		sc = new SearchController();
	}

	@Test
	public void testSearchController() {
		SearchController s = new SearchController();
		assertTrue("'s' is not null: "+ true, s!=null);
	}

	@Test
	public void testCriteriaEmptyCase1() {
		boolean b = sc.criteriaEmpty(null,null,null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		assertEquals("The search criteria are empty: FALSE",true, b);
	}
	
	@Test
	public void testCriteriaEmptyCase2() {
		boolean b = sc.criteriaEmpty(null,null,null,null,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		assertEquals("The search criteria are empty: FALSE",false,b);
	}
	
	@Test
	public void testCriteriaEmptyCase3() {
		List<String> emphases = Arrays.asList("ENGINEERING");
		boolean b = sc.criteriaEmpty("UNIVERSITY OF MINNESOTA","MINNESOTA","URBAN","STATE",40000,60000,40,50,400,500,500,600,13000,15000,40,60,8000,10000,80,90,55,65,3,5,3,5,3,5,emphases);
		assertEquals("The search criteria are empty: FALSE",false, b);
	}

	@Test
	public void testSearchCase1() {
		int result = 0;
		int expected = 1;
		List<University> list = sc.search("YALE",null,null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			if(u.getUniversityName().equals("YALE"));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase2() {
		int result = 0;
		int expected = 2;
		List<String> schools = Arrays.asList("UNIVERSITY OF MINNESOTA","AUGSBURG");
		List<University> list = sc.search(null,"MINNESOTA",null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase3() {
		int result = 0;
		int expected = 75;
		List<String> schools = Arrays.asList("AMERICAN UNIVERSITY OF BEIRUT","BARNARD","BARUCH","BAYLOR UNIVERSITY","BOSTON UNIVERSITY",
				"BROWN","BUTLER","CARNEGIE MELLON","CASE WESTERN","CCNY","CHALMERS UNIVERSITY OF TECHNOLOGY","CLARK UNIVERSITY","COLORADO COLLEGE",
				"COLUMBIA","COOPER UNION","DEPAUL UNIVERSITY","DRAKE UNIVERSITY","EASTMAN SCHOOL OF MUSIC","ECOLE NATIONALE SUPERIEURE DE TELECOMMUNICATION DE PARIS",
				"ECOLE POLYTECHNIQUE","EMORY","FLORIDA ACADEMIC UNIVERSITY","FORDHAM","GEORGE WASHINGTON","GEORGETOWN","GEORGIA TECH","GOLDEN GATE COLLEGE",
				"GOTHENBURG UNIVERSITY","HARVARD","ILLINOIS TECH","JOHNS HOPKINS","JUILLIARD","LESLEY","MASSACHUSETTS INSTITUTE OF TECHNOLOGY","MICHIGAN STATE",
				"MORGAN STATE","NEW JERSEY TECH","NEW YORK UNIVERSITY","NEWJERSEY TECH","NORTH CAROLINA STATE UNIVERSITY","NOTRE DAME","OHIO STATE","PENN STATE",
				"POLYTECHNIC INSTITUTE OF NEWYORK","PRATT","QUEENS","SAN JOSE STATE","ST JOHNS UNIVERSITY","STEVENS","SUNY BUFFALO","TEMPLE","TOURO","TRINITY COLLEGE",
				"TULANE","UNIVERSITY OF CALIFORNIA BERKELEY","UNIVERSITY OF CALIFORNIA LOS ANGELES","UNIVERSITY OF CHICAGO","UNIVERSITY OF LOWELL","UNIVERSITY OF MINNESOTA",
				"UNIVERSITY OF MISSOURI","UNIVERSITY OF NOTRE DAME","UNIVERSITY OF OREGON","UNIVERSITY OF PENNSYLVANIA","UNIVERSITY OF PITTSBURGH","UNIVERSITY OF PUGET SOUND",
				"UNIVERSITY OF ROCHESTER","UNIVERSITY OF SAN FRANCISCO","UNIVERSITY OF SOUTHERN CALIFORNIA","UNIVERSITY OF THE DISTRICT OF COLUMBIA","UNIVERSITY OF THE PACIFIC",
				"UNIVERSITY OF TOLEDO","UNIVERSITY OF WASHINGTON","VANDERBILT","VASSAR","WORCESTER");
		List<University> list = sc.search(null,null,"URBAN",null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase4() {
		int result = 0;
		int expected = 106;
		List<String> schools = Arrays.asList("ABILENE CHRISTIAN UNIVERSITY",
				"ADELPHI","AMERICAN UNIVERSITY OF BEIRUT","AUGSBURG","BARD","BARNARD","BAYLOR UNIVERSITY","BENNINGTON",
				"BOSTON COLLEGE","BOSTON UNIVERSITY","BRANDEIS","BROWN","BRYN MAWR","BUCKNELL","BUTLER","CAL TECH",
				"CARNEGIE MELLON","CASE WESTERN","CLARK UNIVERSITY","CLARKSON UNIVERSITY","COLGATE","COLLEGE OF NEWROCHELLE","COLORADO COLLEGE",
				"COLUMBIA","CONNECTICUT COLLEGE","COOPER UNION","CORNELL","DALLAS BAPTIST COLLEGE",
				"DARTMOUTH","DEPAUL UNIVERSITY","DRAKE UNIVERSITY","DREW","EASTMAN SCHOOL OF MUSIC","EMORY","FLORIDA TECH",
				"FORDHAM","GEORGE WASHINGTON","GEORGETOWN","GOLDEN GATE COLLEGE","HAMPSHIRE COLLEGE","HARVARD","HOFSTRA",
				"HOLY CROSS","HUNTINGTON COLLEGE","JOHNS HOPKINS","JUILLIARD","LEHIGH UNIVERSITY","LESLEY","LEWIS AND CLARK","MANHATTANVILLE COLLEGE",
				"MARIST COLLEGE","MASSACHUSETTS INSTITUTE OF TECHNOLOGY","MONMOUTH COLLEGE","MOUNT HOLYOKE",
				"NEW YORK UNIVERSITY","NEWENGLAND COLLEGE","NEWYORK IT","NORTHWESTERN","NOTRE DAME","OBERLIN",
				"ORAL ROBERTS UNIVERSITY","POLYTECHNIC INSTITUTE OF NEWYORK","PRATT","PRINCETON",
				"REED","RENSSELAER","RICE","ROCHESTER TECH","SAINT ELIZABETHS","SETON HALL","SMITH","ST JOHNS UNIVERSITY",
				"STANFORD","STEVENS","SWARTHMORE","SYRACUSE","TEXAS CHRISTIAN UNIVERSITY","TOURO","TRINITY COLLEGE",
				"TUFTS","TULANE","UNIVERSITE SAINT JOSEPH","UNIVERSITY OF BRIDGEPORT","UNIVERSITY OF CHICAGO","UNIVERSITY OF EVANSVILLE",
				"UNIVERSITY OF HARTFORD","UNIVERSITY OF MISSOURI","UNIVERSITY OF NOTRE DAME","UNIVERSITY OF PENNSYLVANIA",
				"UNIVERSITY OF PORTLAND","UNIVERSITY OF PUGET SOUND","UNIVERSITY OF ROCHESTER","UNIVERSITY OF SAN FRANCISCO",
				"UNIVERSITY OF SOUTHERN CALIFORNIA","UNIVERSITY OF THE PACIFIC","UNIVERSITY OF THE SOUTH","UNIVERSITY OF TULSA",
				"VANDERBILT","VASSAR","VILLANOVA","WALLA WALLA COLLEGE","WASHINGTON AND LEE","WESLEYAN",
				"WORCESTER","YALE","YANKTOWN COLLEGE");
		List<University> list = sc.search(null,null,null,"PRIVATE",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase5() {
		int result = 0;
		int expected = 57;
		List<String> schools = Arrays.asList("ARIZONA STATE","AUBURN","BARUCH","BOSTON UNIVERSITY","CCNY","CORNELL",
				"EASTERN MICHIGAN","FLORIDA STATE","GOTHENBURG UNIVERSITY","MICHIGAN STATE","NEWENGLAND COLLEGE","NEWYORK IT",
				"NORTH CAROLINA STATE UNIVERSITY","NORTHWESTERN","NOTRE DAME","OHIO STATE","OKLAHOMA STATE UNIVERSITY","OREGON STATE",
				"PENN STATE","PURDUE","QUEENS","SAM HOUSTON STATE UNIVERSITY","SETON HALL","ST JOHNS UNIVERSITY","SUFFOLK COMMUNITY COLLEGE","SUNY ALBANY",
				"SUNY BINGHAMTON","SUNY BUFFALO","SUNY STONY BROOK","SYRACUSE","TEMPLE","TEXAS A&M","UNIVERSITY OF ALABAMA",
				"UNIVERSITY OF CALIFORNIA BERKELEY","UNIVERSITY OF CALIFORNIA DAVIS","UNIVERSITY OF CALIFORNIA LOS ANGELES","UNIVERSITY OF COLORADO",
				"UNIVERSITY OF GEORGIA","UNIVERSITY OF KANSAS","UNIVERSITY OF MAINE","UNIVERSITY OF MARYLAND","UNIVERSITY OF MASSACHUSETTS AMHERST",
				"UNIVERSITY OF MICHIGAN","UNIVERSITY OF MINNESOTA","UNIVERSITY OF MISSOURI","UNIVERSITY OF NORTHCAROLINA","UNIVERSITY OF OKLAHOMA",
				"UNIVERSITY OF OREGON","UNIVERSITY OF PENNSYLVANIA","UNIVERSITY OF PITTSBURGH","UNIVERSITY OF SOUTHERN CALIFORNIA",
				"UNIVERSITY OF TEXAS","UNIVERSITY OF TOLEDO","UNIVERSITY OF VIRGINIA","UNIVERSITY OF WASHINGTON","UNIVERSITY WEST VIRGINIA","VILLANOVA");
		List<University> list = sc.search(null,null,null,null,20000,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase6() {
		int result = 0;
		int expected = 25;
		List<String> schools = Arrays.asList("BARUCH","BOSTON UNIVERSITY","CCNY","CORNELL","EASTERN MICHIGAN","GOTHENBURG UNIVERSITY",
				"NEWENGLAND COLLEGE","NEWYORK IT","NORTHWESTERN","SAM HOUSTON STATE UNIVERSITY","SETON HALL","ST JOHNS UNIVERSITY",
				"SUFFOLK COMMUNITY COLLEGE","SUNY BINGHAMTON","SUNY STONY BROOK","SYRACUSE","UNIVERSITY OF CALIFORNIA DAVIS","UNIVERSITY OF GEORGIA",
				"UNIVERSITY OF MAINE","UNIVERSITY OF MISSOURI","UNIVERSITY OF OKLAHOMA","UNIVERSITY OF OREGON","UNIVERSITY OF SOUTHERN CALIFORNIA",
				"UNIVERSITY OF VIRGINIA","VILLANOVA");
		List<University> list = sc.search(null,null,null,null,20000,25000,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase7() {
		int result = 0;
		int expected = 8;
		List<String> schools = Arrays.asList("BARNARD","BRYN MAWR","COLLEGE OF NEWROCHELLE","COLORADO COLLEGE","MOUNT HOLYOKE",
				"SAINT ELIZABETHS","SMITH","SUFFOLK COMMUNITY COLLEGE");
		List<University> list = sc.search(null,null,null,null,0,0,90,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase8() {
		int result = 0;
		int expected = 54;
		List<String> schools = Arrays.asList("ABILENE CHRISTIAN UNIVERSITY","ARIZONA STATE","BARD","BARUCH",
				"BAYLOR UNIVERSITY","BOSTON UNIVERSITY","BRANDEIS","BROWN","CLARK UNIVERSITY","DEPAUL UNIVERSITY",
				"FLORIDA STATE","GEORGE WASHINGTON","GLASSBORO STATE COLLEGE","GOTHENBURG UNIVERSITY","HAMPSHIRE COLLEGE",
				"HOFSTRA","HOLY CROSS","LEWIS AND CLARK","MARIST COLLEGE","MICHIGAN STATE","MONMOUTH COLLEGE","NEW YORK UNIVERSITY",
				"NICHOLLS STATE","OBERLIN","ORAL ROBERTS UNIVERSITY","RUTGERS","SAM HOUSTON STATE UNIVERSITY","SAN JOSE STATE",
				"SETON HALL","SUNY ALBANY","SUNY BINGHAMTON","TEMPLE","TEXAS CHRISTIAN UNIVERSITY","TUFTS",
				"UNIVERSITY OF CALIFORNIA DAVIS","UNIVERSITY OF CALIFORNIA LOS ANGELES","UNIVERSITY OF CALIFORNIA SANTA CRUZ","UNIVERSITY OF GEORGIA",
				"UNIVERSITY OF HARTFORD","UNIVERSITY OF MASSACHUSETTS AMHERST","UNIVERSITY OF MICHIGAN","UNIVERSITY OF MISSOURI",
				"UNIVERSITY OF PORTLAND","UNIVERSITY OF PUGET SOUND","UNIVERSITY OF SAN FRANCISCO","UNIVERSITY OF SOUTH DAKOTA","UNIVERSITY OF TEXAS",
				"UNIVERSITY OF THE PACIFIC","UNIVERSITY OF TOLEDO","UNIVERSITY OF VIRGINIA","UNIVERSITY OF WASHINGTON",
				"VANDERBILT","WESLEYAN","WILLIAM PATERSON COLLEGE");
		List<University> list = sc.search(null,null,null,null,0,0,50,55,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase9() {
		int result = 0;
		int expected = 1;
		List<String> schools = Arrays.asList("HARVARD");
		List<University> list = sc.search(null,null,null,null,0,0,0,0,700,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase10() {
		int result = 0;
		int expected = 5;
		List<String> schools = Arrays.asList("CAL TECH","HARVARD","MASSACHUSETTS INSTITUTE OF TECHNOLOGY",
				"PRINCETON","YALE");
		List<University> list = sc.search(null,null,null,null,0,0,0,0,650,700,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase11() {
		int result = 0;
		int expected = 3;
		List<String> schools = Arrays.asList("CAL TECH","MASSACHUSETTS INSTITUTE OF TECHNOLOGY","RENSSELAER");
		List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,700,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase12() {
		int result = 0;
		int expected = 10;
		List<String> schools = Arrays.asList("BARUCH","EASTMAN SCHOOL OF MUSIC","LESLEY","OREGON INSTITUTE OF TECHNOLOGY",
				"QUEENS","SAINT ELIZABETHS","SAM HOUSTON STATE UNIVERSITY","UNIVERSITY OF TOLEDO","WALLA WALLA COLLEGE","YANKTOWN COLLEGE");
		List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,400,450,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase13() {
		int result = 0;
		int expected = 49;
		List<String> schools = Arrays.asList("ADELPHI","BARD","BARNARD","BOSTON COLLEGE","BOSTON UNIVERSITY",
				"BRANDEIS","BROWN","BUCKNELL","CARNEGIE MELLON","CASE WESTERN","CLARK UNIVERSITY","CLARKSON UNIVERSITY",
				"COLUMBIA","CONNECTICUT COLLEGE","CORNELL","DARTMOUTH","EASTMAN SCHOOL OF MUSIC","EMORY",
				"GEORGE WASHINGTON","HAMPSHIRE COLLEGE","HARVARD","HOLY CROSS","JOHNS HOPKINS","JUILLIARD","MANHATTANVILLE COLLEGE",
				"MASSACHUSETTS INSTITUTE OF TECHNOLOGY","NEW YORK UNIVERSITY","NEWENGLAND COLLEGE","NORTHWESTERN",
				"PENN STATE","POLYTECHNIC INSTITUTE OF NEWYORK","PRINCETON","REED","RENSSELAER","SMITH",
				"STANFORD","STEVENS","SUNY PLATTSBURGH","TRINITY COLLEGE","TUFTS","UNIVERSITY OF BRIDGEPORT",
				"UNIVERSITY OF HARTFORD","UNIVERSITY OF PENNSYLVANIA","UNIVERSITY OF ROCHESTER","UNIVERSITY OF SOUTHERN CALIFORNIA","UNIVERSITY OF THE PACIFIC",
				"VASSAR","WORCESTER","YALE");
				List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,0,0,30000,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase14() {
		int result = 0;
		int expected = 20;
		List<String> schools = Arrays.asList("AUGSBURG","BENNINGTON","BUTLER","CAL TECH",
				"COLGATE","COLORADO COLLEGE","GEORGETOWN","HOFSTRA","LEHIGH UNIVERSITY","LEWIS AND CLARK",
				"MARIST COLLEGE","MONMOUTH COLLEGE","MOUNT HOLYOKE","SYRACUSE","UNIVERSITY OF CHICAGO",
				"UNIVERSITY OF EVANSVILLE","UNIVERSITY OF NOTRE DAME","UNIVERSITY OF SAN FRANCISCO",
				"WALLA WALLA COLLEGE","WESLEYAN");
				List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,0,0,26000,30000,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase15() {
		int result = 0;
		int expected = 43;
		List<String> schools = Arrays.asList("ABILENE CHRISTIAN UNIVERSITY","AUGSBURG","BARD","BARUCH",
				"BRYN MAWR","BUCKNELL","BUTLER","CAL TECH","CARNEGIE MELLON","CCNY",
				"CHALMERS UNIVERSITY OF TECHNOLOGY","CLARKSON UNIVERSITY","COLLEGE OF NEWROCHELLE","ECOLE POLYTECHNIQUE","FLORIDA ACADEMIC UNIVERSITY",
				"FORDHAM","GOTHENBURG UNIVERSITY","HOFSTRA","HUNTINGTON COLLEGE","JOHNS HOPKINS","JUILLIARD",
				"MARIST COLLEGE","NEWYORK IT","NICHOLLS STATE","ORAL ROBERTS UNIVERSITY","POLYTECHNIC INSTITUTE OF NEWYORK","PRATT",
				"RICE","ST JOHNS UNIVERSITY","SUNY ALBANY","SUNY BINGHAMTON","TOURO","TRINITY COLLEGE","UNIVERSITY OF MAINE","UNIVERSITY OF PUGET SOUND",
				"UNIVERSITY OF ROCHESTER","UNIVERSITY OF SAN FRANCISCO","UNIVERSITY OF SOUTH DAKOTA","UNIVERSITY OF TOLEDO",
				"UNIVERSITY WEST VIRGINIA","WALLA WALLA COLLEGE","WORCESTER","YANKTOWN COLLEGE");
				List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,0,0,0,0,70,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase16() {
		int result = 0;
		int expected = 19;
		List<String> schools = Arrays.asList("ABILENE CHRISTIAN UNIVERSITY","BRYN MAWR","BUCKNELL","BUTLER","CAL TECH",
				"CARNEGIE MELLON","FLORIDA ACADEMIC UNIVERSITY","FORDHAM","JOHNS HOPKINS","JUILLIARD","NEWYORK IT",
				"ORAL ROBERTS UNIVERSITY","ST JOHNS UNIVERSITY","UNIVERSITY OF MAINE",
				"UNIVERSITY OF PUGET SOUND","UNIVERSITY OF SAN FRANCISCO","UNIVERSITY OF TOLEDO","WALLA WALLA COLLEGE","WORCESTER");
				List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,0,0,0,0,70,75,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase17() {
		int result = 0;
		int expected = 41;
		List<String> schools = Arrays.asList("ARIZONA STATE","BAYLOR UNIVERSITY","BOSTON COLLEGE","BOSTON UNIVERSITY","BROWN","CORNELL",
				"OTHENBURG UNIVERSITY","HARVARD","MICHIGAN STATE","MOUNT HOLYOKE","OHIO STATE","OKLAHOMA STATE UNIVERSITY","PENN STATE","PRINCETON","PURDUE","RUTGERS","SETON HALL",
				"STANFORD","SUFFOLK COMMUNITY COLLEGE","SUNY ALBANY","SUNY BINGHAMTON","SUNY BUFFALO","TEMPLE","TEXAS A&M","TUFTS","TULANE","UNIVERSITY OF CALIFORNIA BERKELEY",
				"UNIVERSITY OF COLORADO","UNIVERSITY OF KANSAS","UNIVERSITY OF MARYLAND","UNIVERSITY OF MASSACHUSETTS AMHERST","UNIVERSITY OF MICHIGAN","UNIVERSITY OF NORTHCAROLINA",
				"UNIVERSITY OF OKLAHOMA","UNIVERSITY OF PENNSYLVANIA","UNIVERSITY OF PITTSBURGH","UNIVERSITY OF SOUTHERN CALIFORNIA","UNIVERSITY OF TEXAS","UNIVERSITY OF VIRGINIA",
				"WESLEYAN","YALE");
				List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,0,0,0,0,0,0,10000,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase18() {
		int result = 0;
		int expected = 21;
		List<String> schools = Arrays.asList("BAYLOR UNIVERSITY","BOSTON COLLEGE","BROWN","GOTHENBURG UNIVERSITY",
				"MOUNT HOLYOKE","OKLAHOMA STATE UNIVERSITY","PENN STATE","PRINCETON","RUTGERS","SUFFOLK COMMUNITY COLLEGE",
				"SUNY BINGHAMTON","SUNY BUFFALO","TEMPLE","TEXAS A&M","TUFTS","UNIVERSITY OF KANSAS","UNIVERSITY OF OKLAHOMA",
				"UNIVERSITY OF PENNSYLVANIA","UNIVERSITY OF SOUTHERN CALIFORNIA","UNIVERSITY OF VIRGINIA","YALE");
				List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,0,0,0,0,0,0,10000,12000,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		//assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase19() {
		int result = 0;
		int expected = 24;
		List<String> schools = Arrays.asList("ABILENE CHRISTIAN UNIVERSITY","AUBURN","AUGSBURG","CASE WESTERN",
				"DALLAS BAPTIST COLLEGE","GOLDEN GATE COLLEGE","HUNTINGTON COLLEGE","MESA","MICHIGAN STATE","NICHOLLS STATE",
				"OHIO STATE","OREGON STATE","SAINT ELIZABETHS","SUNY BUFFALO","UNIVERSITY OF MAINE","UNIVERSITY OF MISSISSIPPI",
				"UNIVERSITY OF MONTANA","UNIVERSITY OF OKLAHOMA","UNIVERSITY OF PORTLAND","UNIVERSITY OF THE DISTRICT OF COLUMBIA",
				"UNIVERSITY OF TOLEDO","UNIVERSITY WEST VIRGINIA","WAYNE STATE COLLEGE","YANKTOWN COLLEGE");
				List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,85,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase20() {
		int result = 0;
		int expected = 12;
		List<String> schools = Arrays.asList("BROWN","CAL TECH","CHALMERS UNIVERSITY OF TECHNOLOGY",
				"COOPER UNION","DARTMOUTH","EASTMAN SCHOOL OF MUSIC","ECOLE POLYTECHNIQUE","HARVARD",
				"JUILLIARD","PRINCETON","STANFORD","YALE");
				List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10,20,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase21() {
		int result = 0;
		int expected = 15;
		List<String> schools = Arrays.asList("BABILENE CHRISTIAN UNIVERSITY","AMERICAN UNIVERSITY OF BEIRUT",
				"CAL TECH","CHALMERS UNIVERSITY OF TECHNOLOGY","ECOLE POLYTECHNIQUE","HARVARD","JUILLIARD","NEWENGLAND COLLEGE",
				"SUFFOLK COMMUNITY COLLEGE","TEXAS CHRISTIAN UNIVERSITY","UNIVERSITE SAINT JOSEPH","UNIVERSITY OF NORTHCAROLINA","UNIVERSITY OF SOUTH DAKOTA",
				"UNIVERSITY OF THE DISTRICT OF COLUMBIA","YANKTOWN COLLEGE");
		List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,80,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase22() {
		int result = 0;
		int expected = 7;
		List<String> schools = Arrays.asList("BARNARD","BUCKNELL","GEORGETOWN","SMITH","SUNY PLATTSBURGH","UNIVERSITY OF CHICAGO","UNIVERSITY OF VIRGINIA");
				List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,20,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase23() {
		int result = 0;
		int expected = 22;
		List<String> schools = Arrays.asList("BROWN","BRYN MAWR","CAL TECH","COLUMBIA","CORNELL","DARTMOUTH",
				"ECOLE POLYTECHNIQUE","HARVARD","JOHNS HOPKINS","MASSACHUSETTS INSTITUTE OF TECHNOLOGY","NOTRE DAME","PENN STATE",
				"PRINCETON","RICE","STANFORD","SWARTHMORE","UNIVERSITY OF CALIFORNIA BERKELEY","UNIVERSITY OF MICHIGAN","UNIVERSITY OF PENNSYLVANIA",
				"VASSAR","WESLEYAN","YALE");
				List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase24() {
		int result = 0;
		int expected = 15;
		List<String> schools = Arrays.asList("AUGSBURG","CORPUS CHRISTI STATE U","CSBSJU","DALLAS BAPTIST COLLEGE","DRAKE UNIVERSITY","GLASSBORO STATE COLLEGE",
				"SAINT ELIZABETHS","U OF M DULUTH","UNIVERSITY OF BRIDGEPORT","UNIVERSITY OF MISSISSIPPI","UNIVERSITY OF TOLEDO","COLLEGE OF SAINT BENEDICT",
				"VILLANOVA","WAYNE STATE COLLEGE","YANKTOWN COLLEGE");
				List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,1,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}

	@Test
	public void testSearchCase25() {
		int result = 0;
		int expected = 14;
		List<String> schools = Arrays.asList("BENNINGTON","BOSTON COLLEGE","CHALMERS UNIVERSITY OF TECHNOLOGY","DARTMOUTH","DRAKE UNIVERSITY","ECOLE POLYTECHNIQUE","FLORIDA ACADEMIC UNIVERSITY",
				"TULANE","UNIVERSITY OF COLORADO","UNIVERSITY OF EVANSVILLE","UNIVERSITY OF MASSACHUSETTS AMHERST","UNIVERSITY OF MICHIGAN","UNIVERSITY OF PITTSBURGH","UNIVERSITY OF TEXAS");
				List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase26() {
		int result = 0;
		int expected = 57;
		List<String> schools = Arrays.asList("ARIZONA STATE","AUBURN","BARD","BAYLOR UNIVERSITY","BENNINGTON","BOSTON COLLEGE","BOSTON UNIVERSITY","BROWN","BRYN MAWR",
				"CHALMERS UNIVERSITY OF TECHNOLOGY","DARTMOUTH","DRAKE UNIVERSITY","EASTMAN SCHOOL OF MUSIC","ECOLE NATIONALE SUPERIEURE DE TELECOMMUNICATION DE PARIS",
				"ECOLE POLYTECHNIQUE","EMORY","FLORIDA ACADEMIC UNIVERSITY","GEORGE WASHINGTON","GEORGETOWN","HAMPSHIRE COLLEGE",
				"HUNTINGTON COLLEGE","JUILLIARD","LEHIGH UNIVERSITY","MICHIGAN STATE","OHIO STATE","OREGON STATE","PENN STATE",
				"PURDUE","STANFORD","SUNY PLATTSBURGH","SUNY STONY BROOK","TULANE","UNIVERSITE SAINT JOSEPH","UNIVERSITY OF ALABAMA","UNIVERSITY OF BRIDGEPORT",
				"UNIVERSITY OF CALIFORNIA SAN DIEGO","UNIVERSITY OF COLORADO","UNIVERSITY OF EVANSVILLE","UNIVERSITY OF GEORGIA","UNIVERSITY OF MAINE",
				"UNIVERSITY OF MASSACHUSETTS AMHERST","UNIVERSITY OF MICHIGAN","UNIVERSITY OF NORTHCAROLINA","UNIVERSITY OF NOTRE DAME","UNIVERSITY OF OREGON",
				"UNIVERSITY OF PENNSYLVANIA","UNIVERSITY OF PITTSBURGH","UNIVERSITY OF PUGET SOUND","UNIVERSITY OF SOUTHERN CALIFORNIA","UNIVERSITY OF TEXAS",
				"UNIVERSITY OF THE PACIFIC","UNIVERSITY OF TULSA","UNIVERSITY OF VIRGINIA","UNIVERSITY WEST VIRGINIA","VASSAR","WASHINGTON AND LEE","WESLEYAN");
				List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,5,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase27() {
		int result = 0;
		int expected = 12;
		List<String> schools = Arrays.asList("ARIZONA STATE","BROWN","CHALMERS UNIVERSITY OF TECHNOLOGY","ECOLE POLYTECHNIQUE","STANFORD","UNIVERSITY OF CALIFORNIA SANTA CRUZ",
				"UNIVERSITY OF COLORADO","UNIVERSITY OF GEORGIA","UNIVERSITY OF KANSAS","UNIVERSITY OF MICHIGAN","UNIVERSITY OF TEXAS","WALLA WALLA COLLEGE");
				List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase28() {
		int result = 0;
		int expected = 25;
		List<String> schools = Arrays.asList("ADELPHI","CCNY","CORNELL","DALLAS BAPTIST COLLEGE","GEORGIA TECH","HOFSTRA","JUILLIARD","LEHIGH UNIVERSITY",
				"MORGAN STATE","NEWYORK IT","OBERLIN","OREGON INSTITUTE OF TECHNOLOGY","OREGON STATE","POLYTECHNIC INSTITUTE OF NEWYORK","PRATT",
				"SAM HOUSTON STATE UNIVERSITY","ST JOHNS UNIVERSITY","SUNY BINGHAMTON","SUNY BUFFALO","TEMPLE","UNIVERSITY OF PORTLAND",
				"UNIVERSITY OF PUGET SOUND","UNIVERSITY OF THE DISTRICT OF COLUMBIA","UNIVERSITY OF TOLEDO","YANKTOWN COLLEGE");
		List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase29() {
		int result = 0;
		int expected = 8;
		List<String> emphases = Arrays.asList("BIOLOGY","ENGINEERING");
		List<String> schools = Arrays.asList("JOHNS HOPKINS","NORTHWESTERN","STANFORD",
				"UNIVERSITY OF CALIFORNIA SAN DIEGO","UNIVERSITY OF MICHIGAN","UNIVERSITY OF ROCHESTER","UNIVERSITY OF WASHINGTON","UNIVERSITY WEST VIRGINIA");
		List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,emphases);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase30() {
		int result = 0;
		int expected = 3;
		List<String> schools = Arrays.asList("COLLEGE OF SAINT BENEDICT","CSBSJU","U OF M DULUTH");
		List<University> list = sc.search(null,null,null,null,0,10000,0,50,0,400,0,400,0,15000,0,50,0,1000,0,100,0,100,0,5,0,5,0,5,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCase31() {
		int result = 0;
		int expected = 1;
		List<String> schools = Arrays.asList("UNIVERSITY OF MINNESOTA");
		List<University> list = sc.search(null,null,null,null,40000,40000,45,45,490,490,557,557,13772.0,13772.0,50.0,50.0,8500,8500,80,80,60,60,4,4,3,3,4,5,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	
	@Test
	public void testSearchStateLocationStudents() {
		int result = 0;
		int expected = 16;
		List<String> schools = Arrays.asList("BARNARD","BARUCH","CCNY","COLUMBIA",
				"COOPER UNION","EASTMAN SCHOOL OF MUSIC","FORDHAM","JUILLIARD","NEW YORK UNIVERSITY",
				"POLYTECHNIC INSTITUTE OF NEWYORK","PRATT","QUEENS","ST JOHNS UNIVERSITY","SUNY BUFFALO",
				"TOURO","UNIVERSITY OF ROCHESTER");
		List<University> list = sc.search(null,"NEW YORK","URBAN",null,10000,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchStateLocation() {
		int result = 0;
		int expected = 16;
		List<String> schools = Arrays.asList("BARNARD","BARUCH","CCNY","COLUMBIA",
				"COOPER UNION","EASTMAN SCHOOL OF MUSIC","FORDHAM","JUILLIARD","NEW YORK UNIVERSITY",
				"POLYTECHNIC INSTITUTE OF NEWYORK","PRATT","QUEENS","ST JOHNS UNIVERSITY","SUNY BUFFALO",
				"TOURO","UNIVERSITY OF ROCHESTER");
		List<University> list = sc.search(null,"NEW YORK","URBAN",null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchLocationStudents() {
		int result = 0;
		int expected = 74;
		List<String> schools = Arrays.asList("AMERICAN UNIVERSITY OF BEIRUT","BARNARD","BARUCH","BAYLOR UNIVERSITY","BOSTON UNIVERSITY","BROWN",
				"BUTLER","CARNEGIE MELLON","CASE WESTERN","CCNY","CHALMERS UNIVERSITY OF TECHNOLOGY","CLARK UNIVERSITY","COLORADO COLLEGE",
				"COLUMBIA","COOPER UNION","DEPAUL UNIVERSITY","EASTMAN SCHOOL OF MUSIC","ECOLE NATIONALE SUPERIEURE DE TELECOMMUNICATION DE PARIS","ECOLE POLYTECHNIQUE",
				"EMORY","FLORIDA ACADEMIC UNIVERSITY","FORDHAM","GEORGE WASHINGTON","GEORGETOWN","GEORGIA TECH","GOLDEN GATE COLLEGE",
				"GOTHENBURG UNIVERSITY","HARVARD","ILLINOIS TECH","JOHNS HOPKINS","JUILLIARD","LESLEY","MASSACHUSETTS INSTITUTE OF TECHNOLOGY","MICHIGAN STATE",
				"MORGAN STATE","NEW JERSEY TECH","NEW YORK UNIVERSITY","NEWJERSEY TECH","NORTH CAROLINA STATE UNIVERSITY",
				"NOTRE DAME","OHIO STATE","PENN STATE","POLYTECHNIC INSTITUTE OF NEWYORK","PRATT","QUEENS","SAN JOSE STATE","ST JOHNS UNIVERSITY","STEVENS","SUNY BUFFALO","TEMPLE",
				"TOURO","TRINITY COLLEGE","TULANE","UNIVERSITY OF CALIFORNIA BERKELEY",
				"UNIVERSITY OF CALIFORNIA LOS ANGELES","UNIVERSITY OF CHICAGO","UNIVERSITY OF LOWELL","UNIVERSITY OF MINNESOTA",
				"UNIVERSITY OF MISSOURI","UNIVERSITY OF NOTRE DAME","UNIVERSITY OF OREGON","UNIVERSITY OF PENNSYLVANIA","UNIVERSITY OF PITTSBURGH","UNIVERSITY OF PUGET SOUND",
				"UNIVERSITY OF ROCHESTER","UNIVERSITY OF SAN FRANCISCO","UNIVERSITY OF SOUTHERN CALIFORNIA",
				"UNIVERSITY OF THE DISTRICT OF COLUMBIA","UNIVERSITY OF THE PACIFIC","UNIVERSITY OF TOLEDO","UNIVERSITY OF WASHINGTON","VANDERBILT","VASSAR","WORCESTER");
		List<University> list = sc.search(null,null,"URBAN",null,10000,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchStateStudents() {
		int result = 0;
		int expected = 35;
		List<String> schools = Arrays.asList("ADELPHI","BARD","BARNARD","BARUCH","CCNY","CLARKSON UNIVERSITY","COLGATE","COLLEGE OF NEWROCHELLE",
				"COLUMBIA","COOPER UNION","CORNELL","EASTMAN SCHOOL OF MUSIC","FORDHAM","HOFSTRA","JUILLIARD","MANHATTANVILLE COLLEGE","MARIST COLLEGE","NEW YORK UNIVERSITY",
				"NEWYORK IT","POLYTECHNIC INSTITUTE OF NEWYORK","PRATT","QUEENS","RENSSELAER","ROCHESTER TECH","ST JOHNS UNIVERSITY","SUFFOLK COMMUNITY COLLEGE","SUNY ALBANY",
				"SUNY BINGHAMTON","SUNY BUFFALO","SUNY PLATTSBURGH","SUNY PURCHASE","SUNY STONY BROOK","SYRACUSE","TOURO","UNIVERSITY OF ROCHESTER");
		List<University> list = sc.search(null,"NEW YORK",null,null,10000,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchCaseLocation() {
		int result = 0;
		int expected = 75;
		List<String> schools = Arrays.asList("AMERICAN UNIVERSITY OF BEIRUT","BARNARD","BARUCH","BAYLOR UNIVERSITY","BOSTON UNIVERSITY",
				"BROWN","BUTLER","CARNEGIE MELLON","CASE WESTERN","CCNY","CHALMERS UNIVERSITY OF TECHNOLOGY","CLARK UNIVERSITY","COLORADO COLLEGE",
				"COLUMBIA","COOPER UNION","DEPAUL UNIVERSITY","DRAKE UNIVERSITY","EASTMAN SCHOOL OF MUSIC","ECOLE NATIONALE SUPERIEURE DE TELECOMMUNICATION DE PARIS",
				"ECOLE POLYTECHNIQUE","EMORY","FLORIDA ACADEMIC UNIVERSITY","FORDHAM","GEORGE WASHINGTON","GEORGETOWN","GEORGIA TECH","GOLDEN GATE COLLEGE",
				"GOTHENBURG UNIVERSITY","HARVARD","ILLINOIS TECH","JOHNS HOPKINS","JUILLIARD","LESLEY","MASSACHUSETTS INSTITUTE OF TECHNOLOGY","MICHIGAN STATE",
				"MORGAN STATE","NEW JERSEY TECH","NEW YORK UNIVERSITY","NEWJERSEY TECH","NORTH CAROLINA STATE UNIVERSITY","NOTRE DAME","OHIO STATE","PENN STATE",
				"POLYTECHNIC INSTITUTE OF NEWYORK","PRATT","QUEENS","SAN JOSE STATE","ST JOHNS UNIVERSITY","STEVENS","SUNY BUFFALO","TEMPLE","TOURO","TRINITY COLLEGE",
				"TULANE","UNIVERSITY OF CALIFORNIA BERKELEY","UNIVERSITY OF CALIFORNIA LOS ANGELES","UNIVERSITY OF CHICAGO","UNIVERSITY OF LOWELL","UNIVERSITY OF MINNESOTA",
				"UNIVERSITY OF MISSOURI","UNIVERSITY OF NOTRE DAME","UNIVERSITY OF OREGON","UNIVERSITY OF PENNSYLVANIA","UNIVERSITY OF PITTSBURGH","UNIVERSITY OF PUGET SOUND",
				"UNIVERSITY OF ROCHESTER","UNIVERSITY OF SAN FRANCISCO","UNIVERSITY OF SOUTHERN CALIFORNIA","UNIVERSITY OF THE DISTRICT OF COLUMBIA","UNIVERSITY OF THE PACIFIC",
				"UNIVERSITY OF TOLEDO","UNIVERSITY OF WASHINGTON","VANDERBILT","VASSAR","WORCESTER");
		List<University> list = sc.search(null,null,"URBAN",null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchState() {
		int result = 0;
		int expected = 35;
		List<String> schools = Arrays.asList("ADELPHI","BARD","BARNARD","BARUCH","CCNY","CLARKSON UNIVERSITY","COLGATE","COLLEGE OF NEWROCHELLE","COLUMBIA","COOPER UNION",
				"CORNELL","EASTMAN SCHOOL OF MUSIC","FORDHAM","HOFSTRA","JUILLIARD","MANHATTANVILLE COLLEGE","MARIST COLLEGE","NEW YORK UNIVERSITY","NEWYORK IT",
				"POLYTECHNIC INSTITUTE OF NEWYORK","PRATT","QUEENS","RENSSELAER","ROCHESTER TECH","ST JOHNS UNIVERSITY","SUFFOLK COMMUNITY COLLEGE","SUNY ALBANY","SUNY BINGHAMTON",
				"SUNY BUFFALO","SUNY PLATTSBURGH","SUNY PURCHASE","SUNY STONY BROOK","SYRACUSE","TOURO","UNIVERSITY OF ROCHESTER");
		List<University> list = sc.search(null,"NEW YORK",null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchStudents() {
		int result = 0;
		int expected = 22;
		List<String> schools = Arrays.asList("ARIZONA STATE","MICHIGAN STATE","NORTH CAROLINA STATE",
				"OHIO STATE","OKLAHOMA STATE UNIVERSITY","PENN STATE","PURDUE","SUNY BUFFALO","TEXAS A&M","UNIVERSITY OF CALIFORNIA BERKELEY","UNIVERSITY OF CALIFORNIA LOS ANGELES",
				"UNIVERSITY OF COLORADO","UNIVERSITY OF KANSAS","UNIVERSITY OF MARYLAND","UNIVERSITY OF MASSACHUSETTS AMHERST","UNIVERSITY OF MICHIGAN","UNIVERSITY OF MINNESOTA",
				"UNIVERSITY OF NORTHCAROLINA","UNIVERSITY OF PITTSBURGH","UNIVERSITY OF TEXAS","UNIVERSITY OF WASHINGTON","UNIVERSITY WEST VIRGINIA");
		List<University> list = sc.search(null,null,null,null,40000,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchNoCriteria() {
		int result = 0;
		int expected = 182;
		DBController d = new DBController();
		List<University> y = d.getAllUniversities();
		List<String> schools = new ArrayList<String>();
		for(University q: y){
			String name = q.getUniversityName();
			schools.add(name);
		}
		
		List<University> list = sc.search(null,null,null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testSearchAllCriteria() {
		int result = 0;
		int expected = 1;
		List<String> emphases = Arrays.asList("ENGINEERING");
		List<String> schools = Arrays.asList("UNIVERSITY OF MINNESOTA");
		List<University> list = sc.search("UNIVERSITY OF MINNESOTA","MINNESOTA","URBAN","STATE",40000,60000,40,50,400,500,500,600,13000,15000,40,60,8000,10000,80,90,55,65,3,5,3,5,3,5,emphases);
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	
	}
	
	@Test
	public void testDisplay5SchoolsCase1() {
		DBController d = new DBController();
		int result = 0;
		int expected = 5;
		List<String> schools = Arrays.asList("UNIVERSITY OF WASHINGTON","UNIVERSITY OF CALIFORNIA LOS ANGELES",
				"OKLAHOMA STATE UNIVERSITY","UNIVERSITY OF KANSAS","UNIVERSITY OF CALIFORNIA DAVIS");
		List<University> list = sc.display5Schools(d.getAUniversity("UNIVERSITY OF MINNESOTA"));
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}
	
	@Test
	public void testDisplay5SchoolsCase2() {
		DBController d = new DBController();
		int result = 0;
		int expected = 5;
		List<String> schools = Arrays.asList("CSBSJU","U OF M DULUTH",
				"UNIVERSITY OF MICHIGAN","WAYNE STATE COLLEGE","UNIVERSITY OF MISSISSIPPI");
		List<University> list = sc.display5Schools(d.getAUniversity("COLLEGE OF SAINT BENEDICT"));
		for(University u:list){
			result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
		result = 0;
		for(University u:list){
			for(String s:schools)
			if(u.getUniversityName().equals(s));
				result++;
		}
		assertEquals("The length of the list is:" + expected, expected, result);
	}

}
