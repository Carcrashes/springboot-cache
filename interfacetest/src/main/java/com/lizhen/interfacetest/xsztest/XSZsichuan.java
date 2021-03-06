package com.lizhen.interfacetest.xsztest;

import com.lizhen.interfacetest.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassNameXSZsichuan
 * @Description
 * @Author dingyu
 * @Date2019/7/3 16:59
 * @Version V1.0
 **/
public class XSZsichuan {

    /**
     *  简单版完整优化代码下载：http://code.fegine.com/sdk/cmapi027728.zip
     */
    public static void main(String[] args) {
        String host = "https://vehicle.market.alicloudapi.com";
        String path = "/vehicle";
        String method = "POST";
        String appcode = "b9d53fbaac0f4ea0ab33a7fb51bab4c0";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("img", "http://139.224.129.210:8080/lizhen/contract/2019/20190703/762181613915.jpg");
        //或者base64
        //bodys.put("img", "data:image/jpeg;base64,/9j/4A......");


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            //System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
