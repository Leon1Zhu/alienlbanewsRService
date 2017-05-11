package com.alienlab.jsoup;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.alibaba.fastjson.JSON;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import static com.alienlab.jsoup.PdfDataGrab.jsonArrayAllData;
import static com.alienlab.util.Pdf2htmlEXUtil.pdf2html;


/**
 * 包括
 *
 * @author 赵刚
 */
@Component
public class NewsJsoup {
    @Autowired
    HttpDownload httpDownload;

    /**
     * 根据url地址,标签选择得到本网站所有的pdf文件
     *
     * @param getpath
     * @return list
     * @throws IOException
     */
    @Async
    public JSONArray getNeedFile(String url, String name, String getpath) throws IOException {
        //创建链接，得到html文本对象
        Document doc = Jsoup.connect(url).get();
        //文本选择
        Elements links = doc.select("a[href$=.pdf]");
        JSONArray jsonArray = new JSONArray();
        String today = NowTime.getNowTime("yyyy-MM-dd");
        File file = new File("" + getpath + "\\" + today + "");
        if (file.exists()) {
        } else {
            file.mkdir();
        }
        Set<String> set = new TreeSet<>();
        for (Element link : links) {
            //先把地址按顺序放到set集合中
            set.add(print("%s", link.attr("abs:href"), trim(link.text(), 35)));
        }
        Iterator<String> iterator = set.iterator();
        List<String> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        jsonArray = (JSONArray) JSON.toJSON(list);
        int listlen = list.size();
        JSONArray allPath = new JSONArray();
        for (int i = 0; i < listlen; i++) {
            String path = "" + getpath + "\\" + today + "\\" + today + "-" + name + "-" + i + ".pdf";
            allPath.add(path);
            httpDownload.download(list.get(i), path);
        }
        jsonArrayAllData.add(jsonArray);
        if(allPath.size()>0){
            for (int i=0;i<allPath.size();i++) {
                String pdfInfo = allPath.get(i).toString();
                String pdfHtml = pdfInfo.replace("pdf", "html");
                String pdfs[] = pdfHtml.split("/");
                String filename[] = pdfs[1].split("\\.");
                System.out.println("报纸urlTTT");
                pdf2html("E:\\pdf2HtmlEx\\pdf2htmlEX.exe --embed-css 0  --embed-javascript 0 --embed-image 0  --clean-tmp 1   --fit-width 1330 " + pdfInfo + "  --dest-dir " + pdfs[0] + "\\" + filename[0] + "  " + pdfs[1] + "", "v.pdf", "v2.html");
            }
        }
        return jsonArray;
    }

/*    public JSONArray getUrlPdf(List<String> name, List<String> url, String getpath) {
        NewsJsoup newsJsoup = new NewsJsoup();
        String today = NowTime.getNowTime("yyyy-MM/dd");
        int len = name.size();
        JSONArray jsonArray_all = new JSONArray();
        for (int i = 0; i < len; i++) {
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray2 = new JSONArray();
            try {
                String news_url = url.get(i).replace("$$", today);
                jsonArray = newsJsoup.getNeedFile(news_url, name.get(i), getpath);
            } catch (IOException e) {
                System.err.println("网址格式错误！");
            }
            jsonArray2.add(jsonArray);
            jsonArray_all.add(jsonArray2);
        }
        return jsonArray_all;
    }*/

    //格式化方法
    private String print(String msg, Object... args) {
        return String.format(msg, args);
    }

    //如果过长用点代替
    private String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width - 1) + ".";
        else
            return s;
    }
}
