package com.demo.config.wx;

import cn.hutool.core.util.StrUtil;

/**
 * 引导配置
 *
 * @author DokiYolo
 * Date 2022-08-22
 */
public class Bootstrap {

    /**
     * 公众号AppID
     */
    public static final String APP_ID = "wx1728da61f66e2d3f";

    /**
     * 公众号秘钥
     */
    public static final String SECRET = "6325074e59b43265bc658d922650a2f8";

    /**
     * 全局模板ID  也可针对单个Friend指定模板
     */
    public static final String TEMPLATE_ID = "bQWhlFMMgiymiiUggp8On0AF9C4lzm_omHF_iOrXbBk";

    public static final String TEMPLATE_ID_NEW = "s0iSsfrTO9ypeC2RqCsM-XocHFjgsxnuTwPHvofwAGk";





    /**
     * 初始化
     */
    public static void init() {
        if (StrUtil.hasEmpty(APP_ID, SECRET, TEMPLATE_ID)) {
            throw new IllegalArgumentException("请检查配置");
        }
        Wx.init();
    }

}
