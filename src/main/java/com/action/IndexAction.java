package com.action;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexAction {

	/**
	 * 写入之后跳转到index查看
	 * @return
	 */
	@RequestMapping(value = "updateIndex", method = RequestMethod.GET)
	public String updateIndex() {
//		try {
//			Class.forName("IndexAction").getResource("/index.jsp");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}E://Project//learngit//SimplePoint//src//main//webapp
		File file = new File("E://Project//learngit//SimplePoint//src//main//webapp//index.jsp");
		String baseUri = "http://127.0.0.1:8001/index.jsp";
		Document document = null;
		try {
			document = Jsoup.parse(file, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements h2 = document.getElementsByTag("h2");
		String html = "<span>1111111111111</span>";
		System.out.println(document.html());
		h2.append(html);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(document.html());

		char[] buffer = new char[32];
		int hasRead = 0;
		//读取数据到 输入流
		StringReader sr = new StringReader(html);
		try {
			while((hasRead = sr.read(buffer)) > 0) {
				System.out.println(new String(buffer, 0, hasRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sr != null) {
				sr.close();
			}
		}
		return "index";
	}
	
}
