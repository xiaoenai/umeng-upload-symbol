package com.xiaoenai;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.ocean.rawsdk.ApiExecutor;
import com.alibaba.ocean.rawsdk.client.exception.OceanException;
import com.umeng.uapm.param.UmengQuickbirdSymUploadParam;
import com.umeng.uapm.param.UmengQuickbirdSymUploadResult;

public class OpenAPI {
    public static UmengQuickbirdSymUploadResult umengQuickbirdSymUpload(ApiExecutor apiExecutor,String sourceId,String version,int type,String fileName) {
        UmengQuickbirdSymUploadResult result = null;
        UmengQuickbirdSymUploadParam param = new UmengQuickbirdSymUploadParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setDataSourceId(sourceId);
        param.setAppVersion(version);
        //文件类型(1 mapping文件；2 so文件；3 dSYM文件压缩包)
        param.setFileType(type);
        param.setFileName(fileName);

        try {
            result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSONString(result));
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }
        return result;
    }

}
