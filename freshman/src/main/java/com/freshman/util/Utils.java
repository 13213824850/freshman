package com.freshman.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/15 20:02
 * @Description:
 */
public class Utils {
    /**
     * 注意浅拷贝
     * @param src
     * @param start
     * @param desc
     * @param len
     * @return
     * @create 2019/8/16 12:31
     */
    public static  void copy(List src, int start, List desc, int len) {
        if (src == null || desc == null) {
            throw new RuntimeException("传入的值为空");
        }
        for (int i = 0; i < src.size(); i++) {
            if (start > i) {
                continue;
            }
            if (len <= 0) break;
            desc.add(src.get(i));
            len--;
        }
    }
}
