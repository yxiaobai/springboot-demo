package com.spring.boot.springbootdemo.utils;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: Yi xiaobai
 * @Date: 2018/10/8 0008 上午 10:34
 * 系统常用工具类
 */


public class MMSCommonUtils {


    /**  不需要A权限验证的接口关键字
     *    各个关键字以符号&分开，代表1个或多个关键字
     * */
    private static final String unAuthApiKeywords= "loginUser&D1&D2";


    public static List<Long> toLongList(String[] array){
        List<Long> longList = new ArrayList<>();
        for (String s: array) {
            if (!s.equals("")){
                Long longValue = Long.parseLong(s);
                longList.add(longValue);
            }
        }
        return longList;
    }

    public static Boolean needAuthCheck(String urls){
        String[] authWords = unAuthApiKeywords.split("&");
        if (authWords.length <=0){
            //不需要验证登录权限
            return false;
        }
        for (String authWord:authWords ) {
            if (urls.indexOf(authWord)!=-1)
                return false;
        }
        return true;
    }

    public static String getAuthWords( String url){
        if (url.indexOf("auth_")!=-1){
            String[] paths = url.split("/");
            for (String path:paths) {
                if (path.indexOf("auth_")!=-1){
                    return path.split("_")[1];
                }
            }
        }
        return "";
    }

    public static String getAuthRightUrl(String url){
        return StringUtils.replace(url,"/auth_"+getAuthWords(url),"");
    }
    public static String getUUIDString(){
        return UUID.randomUUID().toString();
    }

    public static void downFile(HttpServletResponse response, String filePath, String attachName){
        try {
            File file = new File(filePath);
            //String fileName = filePath.substring(filePath.lastIndexOf(File.separator)+1);//得到文件名
            attachName = new String(attachName.getBytes("UTF-8"),"ISO8859-1");//把文件名按UTF-8取出并按ISO8859-1编码，保证弹出窗口中的文件名中文不乱码，中文不要太多，最多支持17个中文，因为header有150个字节限制。
            response.setContentType("application/octet-stream");//告诉浏览器输出内容为流
            response.addHeader("Content-Disposition", "attachment;filename="+attachName.replace(" ",""));//Content-Disposition中指定的类型是文件的扩展名，并且弹出的下载对话框中的文件类型图片是按照文件的扩展名显示的，点保存后，文件以filename的值命名，保存类型以Content中设置的为准。注意：在设置Content-Disposition头字段之前，一定要设置Content-Type头字段。
            String len = String.valueOf(file.length());
//            response.setHeader("Content-Length", len);//设置内容长度
            OutputStream out = response.getOutputStream();
            FileInputStream in = new FileInputStream(file);
            byte[] b = new byte[1024];
            int n;
            while((n=in.read(b))!=-1){
                out.write(b, 0, n);
            }
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
