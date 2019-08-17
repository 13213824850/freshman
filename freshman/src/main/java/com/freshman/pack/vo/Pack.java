package com.freshman.pack.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: huang yuanli
 * @Date: 2019/8/5 09:31
 * @Description:
 */
public class Pack {
 private Map<Integer,Arm> armList = new HashMap<>();
 private Map<Integer,Shose> shoseList = new HashMap<>();
 private Map<Integer,Clothe> clotheList = new HashMap<>();

 public Map<Integer, Arm> getArmList() {
  return armList;
 }

 public void setArmList(Map<Integer, Arm> armList) {
  this.armList = armList;
 }

 public Map<Integer, Shose> getShoseList() {
  return shoseList;
 }

 public void setShoseList(Map<Integer, Shose> shoseList) {
  this.shoseList = shoseList;
 }

 public Map<Integer, Clothe> getClotheList() {
  return clotheList;
 }

 public void setClotheList(Map<Integer, Clothe> clotheList) {
  this.clotheList = clotheList;
 }
}
