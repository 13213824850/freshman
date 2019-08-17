package com.freshman.controller;

import com.alibaba.fastjson.JSON;
import com.freshman.data.Data;
import com.freshman.pack.vo.Player;
import com.freshman.pack.vo.Rank;
import com.freshman.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import javax.validation.constraints.Size;
import java.util.ArrayList;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/5 09:59
 * @Description:
 */
@ShellComponent
public class PlayerController {

    public static String userName;
    @Autowired
    PlayerService playerService;

    @ShellMethod("登陆, 【用户名】")
    public String login(@Size(min = 1, max = 6) String name) {
        playerService.login(name);
        userName = name;
        return "登陆成功";
    }

    @ShellMethod("排行榜")
    public void rank() {
        playerService.showRank();
    }

    @ShellMethod("我的排名")
    public String myrank() {
        return "当前排名" + String.valueOf(playerService.getMyRank(userName));
    }

    @ShellMethod("更换装备")
    public String add(int id) {
        String add = playerService.add(id, userName);
        String show = show();
        return add + show + myrank();
    }

    @ShellMethod("显示背包")
    public void showpack() {
        playerService.showPack(userName);
    }

    @ShellMethod("查找物品")
    public String serch(int id) {
        return playerService.serach(userName, id);
    }

    @ShellMethod("显示个人信息")
    public String show() {
        return playerService.show(userName);
    }

    @ShellMethod("帮助")
    public String readhelp() {
        StringBuffer sb = new StringBuffer();
        sb.append("login+ userName 登陆\n");
        sb.append("show   --查看当前装备\n");
        sb.append("showpack  --查看背包\n");
        sb.append("rank  --查看排行榜\n");
        sb.append("myrank --查看个人排名\n");
        sb.append("add +物品id  --将背包装备装上\n");
        sb.append("serch + 物品id  --查找背包物品\n");
        sb.append("暂时没用过这种， 所有用户状态保存用静态只能同时登陆一个做的");
        return sb.toString();
    }

}
