package com.demo.controller;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author : wenL
 * @create 2023/11/27 13:29
 */
@RestController
public class ErermaController {

    @ApiOperation(value = "终端类型二维码最新版本下载", response = Map.class)
    @PostMapping("/api/bts/terminal/qrcode/generate/download")
    public Map downloadTerminalTypeQrcode(String url, HttpServletResponse response) {
        String terminalTypeCode;
        String patientAreaId;
        boolean hwAutoAdjust;
        boolean base64Content = false;
        boolean base64Img = false;
        int width = 200;
        int height = 200;
        String imageRgb;
        String bgRgb;
        QrConfig qrConfig = new QrConfig();
        qrConfig.setErrorCorrection(ErrorCorrectionLevel.H);
        qrConfig.setHeight(height);
        qrConfig.setWidth(width);
        qrConfig.setMargin(1);
        try {
            QrCodeUtil.generate(url, qrConfig, "png", response.getOutputStream());
            return null;
        } catch (IOException e) {
            return null;
        }

    }
}
