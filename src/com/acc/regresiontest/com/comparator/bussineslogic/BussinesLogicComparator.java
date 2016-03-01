package com.acc.regresiontest.com.comparator.bussineslogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.xml.sax.SAXException;

import com.acc.regresiontest.com.comparator.domains.Difference;
import com.acc.regresiontest.com.comparator.domains.Value;

/**
 * 
 * @author j.rodriguezguardeno
 *
 */
public class BussinesLogicComparator extends XMLTestCase {

	/**
	 * Compare diff two XML and Print txt
	 * 
	 * @param xml2String
	 * @param xml2String2
	 */

	public static void CompareXML(String xml2String, String xml2String2) {

		// Ignore white space
		XMLUnit.setIgnoreWhitespace(true);
		// ignore comments
		XMLUnit.setIgnoreComments(true);

		DetailedDiff diff = null;

		try {
			// Render all differences between the two xml.

			diff = new DetailedDiff(XMLUnit.compareXML(xml2String, xml2String2));

			// Call the function to create the file.
			writeFile(diff);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * create List with xml diff
	 * 
	 * @param diff
	 *            return List<Diferencia>
	 */

	public static List<Difference> GenerateList(DetailedDiff diff) {
		ArrayList<Difference> difference = new ArrayList<Difference>();
		String espectedValue;
		String valueFound;
		String route;
		String message;
		try {

			if (diff.identical()) {
				return difference;
			} else {

				// List containing all the differences
				List<?> allDifferences = diff.getAllDifferences();

				// travel all differences to remove the path value
				// expected and found value.
				for (Object o : allDifferences) {

					// It gives value to the indices for cutting values
					// differences

					message = o.toString();

					espectedValue = StringUtils.substringAfter(message, "value '");
					espectedValue = StringUtils.substringBefore(espectedValue, "' but");

					valueFound = StringUtils.substringAfter(message, "' but was '");
					valueFound = StringUtils.substringBefore(valueFound, "'");

					route = StringUtils.substringAfter(message, "at /");
					route = StringUtils.substringBefore(route, "/text()");

					Difference d = new Difference();
					Value v = new Value();

					File dontSearch = new File("txt/dontSearch.txt");
					List<String> dontSearchList = ReadFile(dontSearch);
					

					// takes the values and save

					v.setExpectedValue(espectedValue);
					v.setValueFound(valueFound);
					d.setValues(v);

					// Break the route to generate nodes
					String delimiter = "/";
					String[] tree;
					tree = route.split(delimiter);

					// Removes characters added to the route ([x])
					// stores the array of nodes and stores them in the list of
					// differences
					for (int i = 0; i < tree.length; i++) {

						tree[i] = StringUtils.substringBefore(tree[i], "[");
					}
					d.setTree(tree);

					for (String s : dontSearchList) {
						int l = tree.length;
						if (tree[l-1].equals(s)) {

						}

						else {
							difference.add(d);
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return difference;

	}

	/**
	 * Create file with the tree Json differences
	 * 
	 * @param diff
	 */

	public static void writeFile(DetailedDiff diff) {

		FileWriter fw = null;

		ArrayList<Difference> differences = (ArrayList<Difference>) GenerateList(diff);

		try {

			if (differences == null) {
				FileWriter file = new FileWriter("Report.json");
				file.write("Identical");
				file.close();
			} else {
				String json = createXML2Json(differences);

				FileWriter file = new FileWriter("Report.json");
				file.write(json);
				file.close();
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (null != fw) {
					fw.close();
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}

	}

	/**
	 * Parse XML archive to one String Line
	 * 
	 * @param xmlFile
	 * @return
	 * @throws IOException
	 */
	public static String XMLtoString(File xmlFile) throws IOException {

		// Let's get XML file as String using BufferedReader
		// FileReader uses platform's default character encoding
		// if you need to specify a different encoding, use InputStreamReader

		Reader fileReader = new FileReader(xmlFile);
		BufferedReader bufReader = new BufferedReader(fileReader);

		StringBuilder sb = new StringBuilder();
		String line = bufReader.readLine();

		while (line != null) {
			sb.append(line).append("\n");
			line = bufReader.readLine();
		}
		String xml2String = sb.toString();
		bufReader.close();

		return xml2String;
	}
	
	

	public static List<String> ReadFile(File fileName) throws IOException {

		List<String> dontSearchList = new ArrayList<String>();

		Reader fileReader = new FileReader(fileName);
		BufferedReader bufReader = new BufferedReader(fileReader);
		String line = bufReader.readLine();

		while (line != null) {
			String dontSearch = line;
			dontSearchList.add(dontSearch);
			line = bufReader.readLine();
		}
		bufReader.close();
		return dontSearchList;

	}

	/**
	 * from a list of differences it generates a string structure xml and json
	 * transforms
	 * 
	 * @param differences
	 * @return
	 */
	public static String createXML2Json(List<Difference> differences) {

		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
		xml += "<Report>";
		String tree[];

		// through the list of nodes and copy a string in XML format

		for (int i = 0; i < differences.size(); i++) {

			tree = differences.get(i).getTree();
			for (int j = 0; j < tree.length; j++) {
				xml += "<" + tree[j] + ">";
			}

			// added value expected and value found

			xml += "<found>" + differences.get(i).getValues().getValueFound() + "</found>";
			xml += "<expected>" + differences.get(i).getValues().getExpectedValue() + "</expected>";

			// closed loop nodes

			for (int j = tree.length - 1; j >= 0; j--) {

				xml += "</" + tree[j] + ">";
			}
		}

		xml += "</Report>";

		// transforms the string in json

		int prettyPrintIndentFactor = 4;
		String jsonPrettyPrintString = "";

		try {
			JSONObject xmlJSONObj = XML.toJSONObject(xml);

			jsonPrettyPrintString = xmlJSONObj.toString(prettyPrintIndentFactor);

			System.out.println("jsonCreado");
		} catch (JSONException je) {
			System.out.println(je.toString());

		}

		return jsonPrettyPrintString;

	}

}
