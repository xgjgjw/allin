package com.mj.allin.util;

import org.slf4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 日志输出工具类
 *
 * @author zyx
 */
public final class LogUtil {
    private static String MSG_FORMAT = "%s:%s";

    /**
     * 获取异常堆栈信息
     *
     * @param e 异常
     * @return 异常堆栈信息
     */
    public static String getStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        if (e != null) {
            e.printStackTrace(new PrintWriter(sw, true));
        }
        return sw.toString();
    }

    /**
     * 记录异常堆栈信息日志
     *
     * @param log 日志
     * @param msg 提示信息
     * @param e   异常
     */
    public static void info(Logger log, String msg, Exception e) {
        if (log.isInfoEnabled()) {
            if (msg != null) {
                log.info(String.format(MSG_FORMAT, msg, getStackTrace(e)));
            } else {
                log.info(getStackTrace(e));
            }
        }
    }

    /**
     * 记录异常堆栈信息日志
     *
     * @param log 日志
     * @param msg 提示信息
     * @param e   异常
     */
    public static void debug(Logger log, String msg, Exception e) {
        if (log.isDebugEnabled()) {
            if (msg != null) {
                log.debug(String.format(MSG_FORMAT, msg, getStackTrace(e)));
            } else {
                log.debug(getStackTrace(e));
            }
        }
    }

    /**
     * 记录异常堆栈信息日志
     *
     * @param log 日志
     * @param msg 提示信息
     * @param e   异常
     */
    public static void warn(Logger log, String msg, Exception e) {
        if (log.isWarnEnabled()) {
            if (msg != null) {
                log.warn(String.format(MSG_FORMAT, msg, getStackTrace(e)));
            } else {
                log.warn(getStackTrace(e));
            }
        }
    }

    /**
     * 记录异常堆栈信息日志
     *
     * @param log 日志
     * @param msg 提示信息
     * @param e   异常
     */
    public static void error(Logger log, String msg, Exception e) {
        if (log.isErrorEnabled()) {
            if (msg != null) {
                log.error(String.format(MSG_FORMAT, msg, getStackTrace(e)));
            } else {
                log.error(getStackTrace(e));
            }
        }
    }

    /**
     * 记录异常堆栈信息日志
     *
     * @param log 日志
     * @param msg 提示信息
     */
    public static void info(Logger log, String msg) {
        info(log, msg, null);
    }

    /**
     * 记录异常堆栈信息日志
     *
     * @param log 日志
     * @param msg 提示信息
     */
    public static void debug(Logger log, String msg) {
        debug(log, msg, null);
    }

    /**
     * 记录异常堆栈信息日志
     *
     * @param log 日志
     * @param msg 提示信息
     */
    public static void warn(Logger log, String msg) {
        warn(log, msg, null);
    }

    /**
     * 记录异常堆栈信息日志
     *
     * @param log 日志
     * @param msg 提示信息
     */
    public static void error(Logger log, String msg) {
        error(log, msg, null);
    }
}
