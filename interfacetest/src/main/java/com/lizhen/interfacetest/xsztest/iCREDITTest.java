package com.lizhen.interfacetest.xsztest;

import com.lizhen.interfacetest.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassNameiCREDITTest
 * @Description
 * @Author dingyu
 * @Date2019/7/3 18:20
 * @Version V1.0
 **/
public class iCREDITTest {

    public static void main(String[] args) {
        //API产品路径
        String host = "http://carcard.market.alicloudapi.com";
        String path = "/ai_driving_vehicle_license";
        String method = "POST";
        //阿里云APPCODE
        String appcode = "b9d53fbaac0f4ea0ab33a7fb51bab4c0";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();

        //内容数据类型，如：0，则表示BASE64编码；1，则表示图像文件URL链接
        //启用BASE64编码方式进行识别
        //内容数据类型是BASE64编码
        //String imgFile = "图片文件路径";
        //String imgBase64 = "";
        /*try {
            File file = new File(imgFile);
            byte[] content = new byte[(int) file.length()];
            FileInputStream finputstream = new FileInputStream(file);
            finputstream.read(content);
            finputstream.close();
            imgBase64 = new String(encodeBase64(content));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }*/
        //bodys.put("AI_LICENSE_IMAGE", imgBase64);
        //bodys.put("AI_LICENSE_IMAGE_TYPE", "0");

        //启用URL方式进行识别
        //内容数据类型是图像文件URL链接
        bodys.put("AI_LICENSE_IMAGE", "http://139.224.129.210:8080/lizhen/contract/2019/20190703/920301729514.jpg");
        bodys.put("AI_LICENSE_IMAGE_TYPE", "1");

        //行驶证和驾驶证选择，如：0,行驶证；1,驾驶证
        bodys.put("AI_LICENSE_TYPE", "0");

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
