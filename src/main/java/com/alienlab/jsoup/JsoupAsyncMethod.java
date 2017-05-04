package com.alienlab.jsoup;

import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by Msater Zg on 2017/5/3.
 */
@Component
public class JsoupAsyncMethod {
    @Autowired
    private NewsJsoup newsJsoup;

    public JSONArray getUrlPdf(List<String> name, List<String> url, String getpath) {
        String today = NowTime.getNowTime("yyyy-MM/dd");
        int len = name.size();
        JSONArray jsonArray_all = new JSONArray();
        for (int i = 0; i < len; i++) {
            JSONArray jsonArray = new JSONArray();
            try {
                String news_url = url.get(i).replace("$$", today);
                jsonArray = newsJsoup.getNeedFile(news_url, name.get(i), getpath);
                jsonArray_all.add(jsonArray);
            } catch (IOException e) {
                System.err.println("网址格式错误！");
            }
        }
        while (true) {
            if (jsonArray_all.get(len - 1) != null) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return jsonArray_all;
    }
}
