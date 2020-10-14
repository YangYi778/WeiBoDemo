package com.ysu.weibo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;
import com.ysu.weibo.entity.Hot3D;
import com.ysu.weibo.entity.HotYun3D;
import com.ysu.weibo.service.JsonService;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
public class JsonTool {

    @Autowired
    private JsonService jsonService;

    //读取json文件
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public  void SAVEDB(){
        //String path = JsonTool.class.getClassLoader().getResource("Hot3D.json").getPath();
        String path = JsonTool.class.getClassLoader().getResource("Hot3D1.json").getPath();
        String s = readJsonFile(path);
        JSONObject jobj = JSON.parseObject(s);
        JSONArray dates = jobj.getJSONArray("dates");
        JSONArray jsonLine = jobj.getJSONArray("jsonLine");
        JSONArray li = jobj.getJSONArray("li");
        /*
        * 将Hot3D导入DB
        * */
        for (int i = 0 ; i < dates.size();i++){
            Hot3D hot3D = new Hot3D();
            hot3D.setEventname("青岛疫情");
            //hot3D.setEventname("湖人总冠军");
            hot3D.setHotdate(dates.getString(i));
            hot3D.setHotvalue(jsonLine.getInteger(i));
            jsonService.saveHot3D(hot3D);
        }

        /*
        * 将HotYun3D导入DB
        * */
        for (int i = 0;i < li.size();i++){
            HotYun3D hotYun3D = new HotYun3D();
            hotYun3D.setWord(li.getJSONObject(i).getString("name"));
            hotYun3D.setCount(li.getJSONObject(i).getInteger("value"));
            jsonService.saveHotYun3D(hotYun3D);
        }
    }
}