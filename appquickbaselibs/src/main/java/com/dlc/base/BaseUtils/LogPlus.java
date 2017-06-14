package com.dlc.base.BaseUtils;

import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by lzy on 2015/6/6.  荔枝勇提供 log工具
 */
public class LogPlus {

    private static final int CURRENT_LOG_LEVEL = Log.DEBUG;
    private static final String PREFIX = "DLC_";

    public static void v(@Nullable String tag, String msg, @Nullable Throwable tr) {
        log(Log.VERBOSE, tag, msg, tr);
    }

    public static void v(@Nullable String tag, String msg) {
        log(Log.VERBOSE, tag, msg, null);
    }

    public static void v(String msg, @Nullable Throwable tr) {
        log(Log.VERBOSE, null, msg, tr);
    }

    public static void v(String msg) {
        log(Log.VERBOSE, null, msg, null);
    }

    public static void d(@Nullable String tag, String msg, @Nullable Throwable tr) {
        log(Log.DEBUG, tag, msg, tr);
    }

    public static void d(@Nullable String tag, String msg) {
        log(Log.DEBUG, tag, msg, null);
    }

    public static void d(String msg, @Nullable Throwable tr) {
        log(Log.DEBUG, null, msg, tr);
    }

    public static void d(String msg) {
        log(Log.DEBUG, null, msg, null);
    }

    public static void i(@Nullable String tag, String msg, @Nullable Throwable tr) {
        log(Log.INFO, tag, msg, tr);
    }

    public static void i(@Nullable String tag, String msg) {
        log(Log.INFO, tag, msg, null);
    }

    public static void i(String msg, @Nullable Throwable tr) {
        log(Log.INFO, null, msg, tr);
    }

    public static void i(String msg) {
        log(Log.INFO, null, msg, null);
    }

    public static void w(@Nullable String tag, String msg, @Nullable Throwable tr) {
        log(Log.WARN, tag, msg, tr);
    }

    public static void w(@Nullable String tag, String msg) {
        log(Log.WARN, tag, msg, null);
    }

    public static void w(String msg, @Nullable Throwable tr) {
        log(Log.WARN, null, msg, tr);
    }

    public static void w(String msg) {
        log(Log.WARN, null, msg, null);
    }

    public static void e(@Nullable String tag, String msg, @Nullable Throwable tr) {
        log(Log.ERROR, tag, msg, tr);
    }

    public static void e(@Nullable String tag, String msg) {
        log(Log.ERROR, tag, msg, null);
    }

    public static void e(String msg, @Nullable Throwable tr) {
        log(Log.ERROR, null, msg, tr);
    }

    public static void e(String msg) {
        log(Log.ERROR, null, msg, null);
    }

    private static void log(int logLevel, String tag, String msg, Throwable tr) {

        if (logLevel < CURRENT_LOG_LEVEL) {
            return;
        }
        StackTraceElement e = Thread.currentThread().getStackTrace()[4];
        String fileName = e.getFileName();
        int lineNum = e.getLineNumber();
        String methodName = e.getMethodName();
        msg = methodName + "(" + fileName + ":" + lineNum + ")" + msg;
        
        // 注意，如果tag是"IMS"开头的(还有其他)，log会不打印，所以加个"前缀_"
        // 参考这里 http://stackoverflow.com/a/36469141/5324526
        if (tag == null || tag.length() == 0 || tag.trim().length() == 0) {
            String className = e.getClassName();
            int index = className.lastIndexOf('.') + 1;
            className = className.substring(index);
            tag = PREFIX + className;
        } else {
            tag = PREFIX + tag;
        }

        if (tr == null) {
            switch (logLevel) {
                case Log.VERBOSE:
                    Log.v(tag, msg);
                    break;
                case Log.DEBUG:
                    Log.d(tag, msg);
                    break;
                case Log.INFO:
                    Log.i(tag, msg);
                    break;
                case Log.WARN:
                    Log.w(tag, msg);
                    break;
                case Log.ERROR:
                    Log.e(tag, msg);
                    break;
            }
        } else {
            switch (logLevel) {
                case Log.VERBOSE:
                    Log.v(tag, msg, tr);
                    break;
                case Log.DEBUG:
                    Log.d(tag, msg, tr);
                    break;
                case Log.INFO:
                    Log.i(tag, msg, tr);
                    break;
                case Log.WARN:
                    Log.w(tag, msg, tr);
                    break;
                case Log.ERROR:
                    Log.e(tag, msg, tr);
                    break;
            }
        }
    }

    public static void write(Throwable tr) {
        // TODO 写异常，暂时不处理
    }
}
