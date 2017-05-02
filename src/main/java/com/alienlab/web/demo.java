package com.alienlab.web;

import com.alienlab.domain.AlinewsPaper;
import com.alienlab.domain.AlinewsPaperType;
import com.alienlab.domain.AlinewsUsers;
import com.alienlab.repository.AlinewsPaperRepository;
import com.alienlab.repository.AlinewsPaperTypeRepository;
import com.alienlab.service.serviceImpl.AlinewsUserServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhuliang on 2017/4/3.
 */
@RestController
public class demo {
    @Autowired
    private AlinewsUserServiceImpl alinewsUserServiceImpl;
    @Autowired
    private AlinewsPaperTypeRepository alinewsPaperTypeRepository;
    @Autowired
    private AlinewsPaperRepository alinewsPaperRepository;
    @RequestMapping(value="/test",method = RequestMethod.GET)
    public ResponseEntity test(){
        List<AlinewsUsers> alinewsUserss = alinewsUserServiceImpl.findALLUser();
        return  ResponseEntity.ok().body(alinewsUserss);
    }

    @ApiOperation(value="新增报纸类型接口",notes="测试用。")
    @RequestMapping(value="/savetype",method = RequestMethod.GET)
    public ResponseEntity savetype(){
        List<String> list = new ArrayList();
        list.add("商业新闻报");
        list.add("晚报");
        list.add("都市报");
        list.add("对象报");
        list.add("生活报");
        for (String name: list) {
            AlinewsPaperType alinewsPaperType = new AlinewsPaperType();
            alinewsPaperType.setTypeName(name);
            alinewsPaperType.setStauts("1");
            System.out.println(ZonedDateTime.now());
            alinewsPaperType = alinewsPaperTypeRepository.save(alinewsPaperType);
        }

        return  ResponseEntity.ok().body("完成");
    }

    @ApiOperation(value="新增报纸接口",notes="测试用。")
    @RequestMapping(value="/savepaper",method = RequestMethod.GET)
    public ResponseEntity savepaper(){
        List<String> list = new ArrayList();
        list.add("武汉晨报");
        list.add("宁波日报");
        list.add("重庆日报");
        list.add("现代金报");
        list.add("晶报");
        list.add("东方早报");
        list.add("现代快报");
        list.add("新华日报");

        List<String> list2 = new ArrayList();
        list2.add("http://whcb.cjn.cn/html/$$/node_42.htm");
        list2.add("http://daily.cnnb.com.cn/nbrb/html/$$/node_2.htm");
        list2.add("http://cqrbepaper.cqnews.net/cqrb/html/$$/node_124.htm");
        list2.add("http://dzb.jinbaonet.com/html/$$/node_23.htm");
        list2.add("http://jb.sznews.com/html/$$/node_1163.htm");
        list2.add("http://epaper.dfdaily.com/dfzb/html/$$/node_2.htm");
        list2.add("http://dz.xdkb.net/html/$$/node_41.htm");
        list2.add("http://xh.xhby.net/mp2/html/$$/node_2.htm");
        for (int i = 0;i<list.size();i++) {
            AlinewsPaper alinewsPaper = new AlinewsPaper();
            alinewsPaper.setCreateTime(new Date());
            alinewsPaper.setCollectCount(0);
            alinewsPaper.setPaperName(list.get(i));
            alinewsPaper.setPaperStatus("1");
            alinewsPaper.setPaperType("生活报");
            alinewsPaper.setPaperUrl(list2.get(i));
            System.out.println(ZonedDateTime.now());
            alinewsPaper = alinewsPaperRepository.save(alinewsPaper);
        }

        return  ResponseEntity.ok().body("完成");
    }

    @RequestMapping(value="/save",method = RequestMethod.GET)
    public ResponseEntity save(@RequestParam String name,@RequestParam String password,@RequestParam String tel,@RequestParam String email,@RequestParam String resource){
        AlinewsUsers alinewsUsers = new AlinewsUsers();
        alinewsUsers.setUserName(name);
        alinewsUsers.setUserPassword(password);
        alinewsUsers.setTel(tel);
        alinewsUsers.setEmail(email);
        alinewsUsers.setSource(resource);
        alinewsUsers = alinewsUserServiceImpl.save(alinewsUsers);
        return  ResponseEntity.ok().body(alinewsUsers);
    }

}
