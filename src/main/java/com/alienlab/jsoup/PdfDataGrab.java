package com.alienlab.jsoup;

import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Msater Zg on 2017/5/3.
 * 执行下载的方法
 */
@Component
public class PdfDataGrab {
    @Autowired
    private JsoupAsyncMethod jsoupAsyncMethod;

    public JSONArray getPdfUrl() {
        JSONArray jsonArray = new JSONArray();
        List newsName = new ArrayList();
        newsName.add("1");
        newsName.add("2");
        newsName.add("3");
        List newsUrl = new ArrayList();
        newsUrl.add("http://dz.xdkb.net/html/2017-05/03/node_41.htm");
        newsUrl.add("http://epaper.legaldaily.com.cn/fzrb/content/20170416/Page01TB.htm");
        newsUrl.add("http://epaper.legaldaily.com.cn/fzrb/content/20170416/Page01TB.htm");
        jsonArray = jsoupAsyncMethod.getUrlPdf(newsName, newsUrl, "D:/");
        System.out.println(jsonArray);
        return jsonArray;
    }
}
