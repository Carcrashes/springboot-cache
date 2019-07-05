package com.lizhen.interfacetest.util;


import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;


public class Base64 {

    private static String strNetImageToBase64;

    /**
     * 网络图片转换Base64的方法
     *
     * @param netImagePath     
     */
    public static String NetImageToBase64(String netImagePath) {
        final ByteArrayOutputStream data = new ByteArrayOutputStream();
        try {
            // 创建URL
            URL url = new URL(netImagePath);
            final byte[] by = new byte[1024];
            // 创建链接
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            InputStream is = conn.getInputStream();
            // 将内容读取内存中
            int len = -1;
            while ((len = is.read(by)) != -1) {
                data.write(by, 0, len);
            }
            // 对字节数组Base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            strNetImageToBase64 = encoder.encode(data.toByteArray());
            //System.out.println("网络图片转换Base64:" + strNetImageToBase64);
            // 关闭流
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strNetImageToBase64;
    }


    /**
     * 本地图片转换Base64的方法
     *
     * @param imgPath     
     */

    public static String ImageToBase64(String imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        System.out.println("本地图片转换Base64:" + encoder.encode(Objects.requireNonNull(data)));
        return encoder.encode(Objects.requireNonNull(data));
    }

    public static void main(String[] args) {
        //第一个:把网络图片装换成Base64
        String netImagePath = "http://139.224.129.210:8080/lizhen/contract/2019/20190703/015391618082.jpg";
        //下面是网络图片转换Base64的方法
        String str = NetImageToBase64(netImagePath);
        System.out.println(str);

        //下面是本地图片转换Base64的方法
        //String imagePath = "本地图片路径";
        //ImageToBase64(imagePath);
    }

}
