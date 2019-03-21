package com.wangzh.process;

import com.wangzh.process.utils.ProcessUtils;

/**
 * @Description:
 * @CreatedDate:2019-03-21 14:39
 * @Author:wangzh
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("process main...");
        String cmdText = "java -jar /data/docker/devops-web-admin/jar/matrix-apk-canary-0.4.10.jar --config /data/docker/devops-web-admin/package/uploadPath/TuandaiAS2-debug-config.json";
        System.out.println(cmdText);
        ProcessUtils.execCommand(cmdText);

    }
}
