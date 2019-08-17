package com.freshman.handle;

import com.freshman.annos.ReceAnno;
import com.freshman.event.SkillEvent;
import org.springframework.stereotype.Component;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/13 18:54
 * @Description:
 */
@Component
public class SKillEventHandle {
    @ReceAnno
    public void test(SkillEvent event){
        System.out.println("testevent");
    }
}
