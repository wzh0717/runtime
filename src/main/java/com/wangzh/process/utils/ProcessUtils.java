package com.wangzh.process.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Description:
 * @CreatedDate:2019-03-21 14:41
 * @Author:wangzh
 */
public abstract class ProcessUtils {
    /**
     * 执行shell命令
     *
     * @param command
     * @return
     */
    public static boolean execCommand(String command) {
        try {
            Process p = Runtime.getRuntime().exec(command);
            if (null == p) return false;
            //读取标准输出流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            System.out.println("标准输出流");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            //读取标准错误流
            System.out.println("标准错误流");
            BufferedReader brError = new BufferedReader(new InputStreamReader(p.getErrorStream(), "UTF-8"));
            while ((line = brError.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = p.waitFor();
            System.out.println("process exit value is " + exitVal);
            return exitVal == 0 ? true : false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
