package util;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Obj {
	static DocumentBuilderFactory docBuilderFactory = null;
	static DocumentBuilder docBuilder = null;
	static Document doc = null;

	public static String getIdentify(String objectName) {
		try {
			docBuilderFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.parse(new File("src/objectrepository/objectrepository.xml"));

			boolean flag = false;
			NodeList listOfObject = doc.getElementsByTagName("object");
			for (int s = 0; s < listOfObject.getLength(); s++) {

				Node firstOjectNode = listOfObject.item(s);
				if (firstOjectNode.getNodeType() == Node.ELEMENT_NODE) {

					Element firstObjectElement = (Element) firstOjectNode;
					NodeList firstNameList = firstObjectElement.getElementsByTagName("name");
					Element firstNameElement = (Element) firstNameList.item(0);

					NodeList textFNList = firstNameElement.getChildNodes();
					String name = ((Node) textFNList.item(0)).getNodeValue().trim();

					if (name.equals(objectName)) {
						flag = true;
						NodeList lastNameList = firstObjectElement.getElementsByTagName("identifyby");
						Element lastNameElement = (Element) lastNameList.item(0);
						NodeList textLNList = lastNameElement.getChildNodes();
						String identification = ((Node) textLNList.item(0)).getNodeValue().trim();
						if (identification == "") {
							System.out.println("idenfication null");
							// Reporter.failureReport("The XML Object does not have a identifyBy attribute value for the Object"+objectName,"");
							System.out.println("The XML Object does not have a identifyBy attribute value for the Object" + objectName);
						}
						return identification;

					} else {
						continue;
					}
				}
			}
			if (!flag) {
				System.out.println("there was no tag with " + objectName + " value");
			}

			return "";
		} catch (Exception e) {
			System.out.println(e.getStackTrace());

			return "";
		}
	}

	public static String getLocation(String objectName) {
		try {
			docBuilderFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.parse(new File("src/objectrepository/objectrepository.xml"));
			NodeList listOfObject = doc.getElementsByTagName("object");
			boolean flag = false;
			for (int s = 0; s < listOfObject.getLength(); s++) {

				Node firstOjectNode = listOfObject.item(s);
				if (firstOjectNode.getNodeType() == Node.ELEMENT_NODE) {

					Element firstObjectElement = (Element) firstOjectNode;

					// -------
					NodeList firstNameList = firstObjectElement.getElementsByTagName("name");
					Element firstNameElement = (Element) firstNameList.item(0);

					NodeList textFNList = firstNameElement.getChildNodes();
					String name = ((Node) textFNList.item(0)).getNodeValue().trim();
					if (name.equals(objectName)) {
						flag = true;
						NodeList lastNameList = firstObjectElement.getElementsByTagName("value");
						Element lastNameElement = (Element) lastNameList.item(0);
						NodeList textLNList = lastNameElement.getChildNodes();
						String identification = ((Node) textLNList.item(0)).getNodeValue().trim();
						if (identification == "") {
							System.out.println("idenfication null");
							// Reporter.failureReport("The XML Object does not have a identifyBy attribute value for the Object"+objectName,"");
							System.out.println("The XML Object does not have a identifyBy attribute value for the Object" + objectName);
						}
						return identification;
					} else {
						continue;
					}
				}
			}
			if (!flag) {
				System.out.println("There was no tag with " + objectName + " value");
			
			}

			return "";
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return "";
		}

	}

}
