package com.collect.alipay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtil {
	

	
	/**
	 * 读取xml
	 * @param path
	 */
	public static Document readXML(String path) {
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			ClassLoader classLoader = XmlUtil.class.getClassLoader();
			InputStream inputStream = classLoader.getResourceAsStream(path);
			document = reader.read(inputStream);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
	}
	
	public static void updateElement(Document document,String singleNodePath,String text) {
		Element node = (Element)document.selectSingleNode(singleNodePath);
		node.setText(text);
	}
	
	/**
	 * 增加节点
	 * @param document
	 * @param singleNodePath
	 * @param value
	 */
	public static Document addElement(Document document,String singleNodePath, Map<String, String> value) {
		Element node = (Element)document.selectSingleNode(singleNodePath);
		for(Entry<String, String> entry : value.entrySet()) {
			Element el = node.addElement(entry.getKey());
			el.setText(entry.getValue());
		}		
		return document;
	}
	
	/**
	 * 增加节点属性
	 * @param document
	 * @param singleNodePath
	 * @param value
	 */
	public static Document addAttribute(Document document,String singleNodePath, Map<String, String> value) {
		Element node = (Element)document.selectSingleNode(singleNodePath);
		for(Entry<String, String> entry : value.entrySet()) {
			node.addAttribute(entry.getKey(), entry.getValue());
		}
		return document;
	}
	
	public static Document getDocument(String str) {
		try {
			System.out.println(str);
			return DocumentHelper.parseText(str);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void writeXml(String path ,String name,String xml) {
		OutputFormat format = OutputFormat.createPrettyPrint();
		File file = new File(path+name);
        format.setEncoding("UTF-8");// 设置XML文件的编码格式
        XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileWriter(file),format);
			writer.setEscapeText(false);
			writer.write(xml);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	public static void main(String[] args) {
		Document document = XmlUtil.readXML("com/enovell/collect/serviceImpl/u2000/deviceRequest.xml");
		XmlUtil.writeXml("/Users/xzy_del/workspace/enterprise/collectWeb/src/com/enovell/collect/serviceImpl/u2000/", "3212.xml", document.asXML().toString());
	}
	
}
