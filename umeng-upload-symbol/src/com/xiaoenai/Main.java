package com.xiaoenai;
import com.alibaba.ocean.rawsdk.ApiExecutor;
import com.umeng.uapm.param.UmengQuickbirdSymUploadResult;

import java.io.File;
import java.time.chrono.MinguoDate;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws Exception {

        String appKey = "";
        String secKey = "";
        String sourceId = "";
        String version = "";
        int type = 0;
        String fileName = "";
        String symbolFile = "";

        for(int index = 0 ; index < args.length;index++){
            String item = args[index];
            if(item.contains("-appkey") && args.length > index + 1){
                appKey = args[index + 1];
            }
            if(item.contains("-seckey") && args.length > index + 1){
                secKey = args[index + 1];
            }
            if(item.contains("-sourceid") && args.length > index + 1){
                sourceId = args[index + 1];
            }
            if(item.contains("-type") && args.length > index + 1){
                String str = args[index + 1];
                type = Integer.parseInt(str);
            }
            if(item.contains("-version") && args.length > index + 1){
                version = args[index + 1];
            }
            if(item.contains("-symbolfile") && args.length > index + 1){
                symbolFile = args[index + 1];
                File tempFile =new File( symbolFile.trim());
                fileName = tempFile.getName();
            }
        }

        System.out.println("appKey:" + appKey);
        System.out.println("secKey:" + secKey);
        System.out.println("sourceId:" + sourceId);
        System.out.println("type:" + type);
        System.out.println("version:" + version);
        System.out.println("symbolFile:" + symbolFile);
        System.out.println("fileName:" + fileName);

        if(appKey.length() > 0 && secKey.length() > 0 && sourceId.length() > 0 && type > 0 && version.length() > 0 && symbolFile.length() > 0 && fileName.length() > 0){
            ApiExecutor apiExecutor = new ApiExecutor(appKey, secKey);
            apiExecutor.setServerHost("gateway.open.umeng.com");

            UmengQuickbirdSymUploadResult result = OpenAPI.umengQuickbirdSymUpload(apiExecutor,sourceId,version,type,fileName);
            if(result != null){
                Map<String, String> formFields = new HashMap<>();
                formFields.put("OSSAccessKeyId",result.getAccessKeyId());
                formFields.put("key",result.getKey());
                formFields.put("policy",result.getPolicy());
                formFields.put("signature",result.getSignature());
                formFields.put("callback",result.getCallback());
                String uploadAddress = "https://quickbird.oss-cn-shanghai.aliyuncs.com";
                String res = Upload.form(uploadAddress,formFields,symbolFile);
                System.out.println(res);
            }else{
                System.out.println("Api参数获取出错");
            }
        }else{
            System.out.println("错少参数");
        }
        System.out.println("Process Complete");
    }


}
