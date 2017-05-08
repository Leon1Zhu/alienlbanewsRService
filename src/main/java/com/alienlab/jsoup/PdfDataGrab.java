package com.alienlab.jsoup;

import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Msater Zg on 2017/5/3.
 * 执行下载的方法
 */
@Component
public class PdfDataGrab {
    @Autowired
    private JsoupAsyncMethod jsoupAsyncMethod;
    public static JSONArray jsonArrayAllData = new JSONArray();

    public JSONArray getPdfUrl() {
        List newsName = new ArrayList();
        newsName.add("1");
        newsName.add("2");
        newsName.add("3");
        List newsUrl = new ArrayList();
        newsUrl.add("http://dz.xdkb.net/html/2017-05/03/node_41.htm");
        newsUrl.add("http://epaper.legaldaily.com.cn/fzrb/content/20170416/Page01TB.htm");
        newsUrl.add("http://epaper.legaldaily.com.cn/fzrb/content/20170416/Page01TB.htm");
        jsoupAsyncMethod.getUrlPdf(newsName, newsUrl, "D:/");
        while (true) {
            if (jsonArrayAllData.size() == newsName.size()) {
                break;
            } else {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(jsonArrayAllData);
        return jsonArrayAllData;
    }
}
