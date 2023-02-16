package learn.quickweb.util;

import lombok.extern.slf4j.Slf4j;

/**
 * 醒目地打印错误信息
 *
 * @author Peter Cheung
 * 2023/2/16 15:08
 */
@Slf4j
public class ErrorPrintUtil {
    /**
     * 醒目地打印错误信息
     */
    public static void print(Object e) {
        //控制台颜色 91-亮红 1-字体加粗
        System.out.println("\033[91;1m");
        //错误信息打印
        log.error("错误信息：" + e);
        //控制台清除状态
        System.out.print("\033[0m");
        //控制台颜色还原 93-亮黄
        System.out.print("\033[93m");
    }
}
