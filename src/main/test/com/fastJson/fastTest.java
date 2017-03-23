package com.fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc5 on 2017/3/23.
 * faseJsonz转换实例
 */
public class fastTest {
    /**
     * 类型转换json
     */
    @Test
    public void changeJson()
    {
        List<studentInfo> list_attr=new ArrayList<studentInfo>();
        for (int i=0;i<10;i++)
        {
            studentInfo studentInfo=new studentInfo();
            String[] likes={"羽毛球","篮球"};
            studentInfo.setLikes(likes);
            studentInfo.setStudentName("王彪"+i);
            list_attr.add(studentInfo);
        }
        System.out.print(JSON.toJSONString(list_attr));
    }

    /**
     * json转对象
     */
    @Test
    public void JsonToString()
    {
        String json="{'likes':['羽毛球','篮球'],'studentAge':0,'studentName':'王彪','studentSex':false}";
        studentInfo s= JSON.parseObject(json,studentInfo.class);
        System.out.print(s.getLikes().length+"???????/"+s.getStudentName());
    }

    /**
     * json转泛型
     */
    @Test
    public void JsonAttrChangeObject()
    {
        String json="[{\"likes\":[\"羽毛球\",\"篮球\"],\"studentAge\":0,\"studentName\":\"王彪0\",\"studentSex\":false},{\"likes\":[\"羽毛球\",\"篮球\"],\"studentAge\":0,\"studentName\":\"王彪1\",\"studentSex\":false},{\"likes\":[\"羽毛球\",\"篮球\"],\"studentAge\":0,\"studentName\":\"王彪2\",\"studentSex\":false},{\"likes\":[\"羽毛球\",\"篮球\"],\"studentAge\":0,\"studentName\":\"王彪3\",\"studentSex\":false},{\"likes\":[\"羽毛球\",\"篮球\"],\"studentAge\":0,\"studentName\":\"王彪4\",\"studentSex\":false},{\"likes\":[\"羽毛球\",\"篮球\"],\"studentAge\":0,\"studentName\":\"王彪5\",\"studentSex\":false},{\"likes\":[\"羽毛球\",\"篮球\"],\"studentAge\":0,\"studentName\":\"王彪6\",\"studentSex\":false},{\"likes\":[\"羽毛球\",\"篮球\"],\"studentAge\":0,\"studentName\":\"王彪7\",\"studentSex\":false},{\"likes\":[\"羽毛球\",\"篮球\"],\"studentAge\":0,\"studentName\":\"王彪8\",\"studentSex\":false},{\"likes\":[\"羽毛球\",\"篮球\"],\"studentAge\":0,\"studentName\":\"王彪9\",\"studentSex\":false}]";
        List<studentInfo> list = JSON.parseObject(json, new TypeReference<List<studentInfo>>() {});
        System.out.print(list.size()+">>>>>>>>>>>>>>>>");
    }


}
