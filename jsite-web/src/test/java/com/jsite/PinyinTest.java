//package com.jsite;
//
//
////import net.sourceforge.pinyin4j.PinyinHelper;
////import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
////import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
////import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
////import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
//
//import org.junit.Test;
//
///**
// * 类PinyinTest.java的实现描述：TODO 类实现描述
// * @author riqi 2013-6-28 下午5:24:57
// */
//public class PinyinTest {
//
//    @Test
//    public void pinyinTest() {
////        String input = "报销人\t报销时间\t发票代码\t发票号码\t报销金额";
//        String input = "序号\t提出时间\t模块/页面\t需求描述\t优先级\t处理状态\t邮件\t\t\n序号\t提出时间\t模块/页面\t需求描述\t优先级\t处理状态";
////        String input = "序号\t报名时间\t姓名\t身份证\t学校\t年级\t专业\t宿舍楼\t手机号码\tQQ\t性别\t套餐\t生日\t户籍所在地\t市场成交人员\t是否送书\t领书记录\t已上课程\t正在上课程\t备注";
////        String input = "接口名称\t" +
////                "接口类型\t" +
////                "请求URL\t" +
////                "请求body\t" +
////                "成功时返回消息\t" +
////                "失败时返回消息\t" +
////                "备注信息";
//
//
//
//
//
//
//
//
//
//
//
////        String input = "阿里巴巴";
//        StringBuilder pinyin = new StringBuilder();
//
//        for (int i = 0; i < input.length(); i++) {
//            HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
//            defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
//            defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
//            char c = input.charAt(i);
//            String[] pinyinArray = null;
//            try {
//                pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat);
//            } catch (BadHanyuPinyinOutputFormatCombination e) {
//                e.printStackTrace();
//            }
//            if (pinyinArray != null) {
//                pinyin.append(pinyinArray[0]);
//            } else if (c != ' ') {
//                pinyin.append(input.charAt(i));
//            }
//        }
//
//        System.out.println(pinyin.toString().trim().toLowerCase());
//
//        String[] ch = input.split("\t");
//        String[] en = pinyin.toString().trim().toLowerCase().split("\t");
//
//        StringBuilder content = new StringBuilder();
//
//        for (int i= 0;i<ch.length ;i++){
//            content.append("`"+en[i]+"` varchar(255) NULL COMMENT '"+ch[i]+"',\n");
//        }
//
//
//        String sql = "CREATE TABLE `jsite`.`Untitled`  (\n" +
//                "  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '编号',\n" +
//                content.toString()+
//
//                "  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者',\n" +
//                "  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',\n" +
//                "  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新者',\n" +
//                "  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',\n" +
//                "  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注信息',\n" +
//                "  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',\n" +
//                "  PRIMARY KEY (`id`)\n" +
//                ");";
//
//
//        System.out.println(sql);
//
//
//
//    }
//
//}
