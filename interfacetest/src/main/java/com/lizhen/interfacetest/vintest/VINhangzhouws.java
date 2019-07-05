package com.lizhen.interfacetest.vintest;





import com.lizhen.interfacetest.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassNameVINhangzhouws
 * @Description 杭州网上科技ViN测试
 * @Author dingyu
 * @Date2019/7/3 16:03
 * @Version V1.0
 **/
public class VINhangzhouws {

    public static void main(String[] args) {
        String host = "https://jisuvindm.market.alicloudapi.com";
        String path = "/vin/query";
        String method = "GET";
        String appcode = "b9d53fbaac0f4ea0ab33a7fb51bab4c0";
        Map<String, String> headers = new HashMap<String, String>();

        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("vin", "LSJW54U97KG069112");
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
