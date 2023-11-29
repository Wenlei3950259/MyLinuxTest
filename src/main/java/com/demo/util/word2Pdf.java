package com.demo.util;


import org.icepdf.core.exceptions.PDFException;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.pobjects.PDimension;
import org.icepdf.core.pobjects.Page;
import org.icepdf.core.util.GraphicsRenderingHints;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class word2Pdf {
    public static List<BufferedImage> pdf2BufferedImage(String pdfFile) {
        float scale = 1f;
        float rotation = 0f;
        Document document = new Document();
        List<BufferedImage> images = new LinkedList<>();
        try {
            document.setFile(pdfFile);
            int numberOfPages = document.getPageTree().getNumberOfPages();
            for (int i = 0; i < numberOfPages; i++) {
                Page currentPage = document.getPageTree().getPage(i);
                currentPage.init();
                PDimension sz = currentPage.getSize(Page.BOUNDARY_CROPBOX, rotation, scale);
                int pageWidth = (int) sz.getWidth();
                int pageHeight = (int) sz.getHeight();
                BufferedImage image = new BufferedImage(pageWidth,
                        pageHeight,
                        BufferedImage.TYPE_INT_RGB);
                Graphics g = image.createGraphics();
                currentPage.paint(g, GraphicsRenderingHints.PRINT,
                        Page.BOUNDARY_CROPBOX, rotation, scale);
                g.dispose();
                images.add(image);
            }
        } catch (PDFException e) {
            e.printStackTrace();
        } catch (PDFSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            document.dispose();
        }
        return images;
    }

    /**
     * @param pdfFile
     * @param outpath
     * @created 2019年4月19日 下午1:54:13
     */
    public static void pdf2multiImage(String pdfFile, String outpath) {
        List<BufferedImage> bufferedImages = pdf2BufferedImage(pdfFile);
        yPic(bufferedImages, outpath);
    }

    /**
     * 将宽度相同的图片，竖向追加在一起 ##注意：宽度必须相同
     *
     * @param piclist 文件流数组
     * @param outPath 输出路径
     */
    private static void yPic(List<BufferedImage> piclist, String outPath) {// 纵向处理图片
        if (piclist == null || piclist.size() <= 0) {
            System.out.println("图片数组为空!");
            return;
        }
        try {
            int height = 0, // 总高度
                    width = 0, // 总宽度
                    _height = 0, // 临时的高度 , 或保存偏移高度
                    __height = 0, // 临时的高度，主要保存每个高度
                    picNum = piclist.size();// 图片的数量
            int[] heightArray = new int[picNum]; // 保存每个文件的高度
            BufferedImage buffer = null; // 保存图片流
            List<int[]> imgRGB = new ArrayList<int[]>(); // 保存所有的图片的RGB
            int[] _imgRGB; // 保存一张图片中的RGB数据
            for (int i = 0; i < picNum; i++) {
                buffer = piclist.get(i);
                heightArray[i] = _height = buffer.getHeight();// 图片高度
                if (i == 0) {
                    width = buffer.getWidth();// 图片宽度
                }
                height += _height; // 获取总高度
                _imgRGB = new int[width * _height];// 从图片中读取RGB
                _imgRGB = buffer.getRGB(0, 0, width, _height, _imgRGB, 0, width);
                imgRGB.add(_imgRGB);
            }
            _height = 0; // 设置偏移高度为0
            // 生成新图片
            BufferedImage imageResult = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < picNum; i++) {
                __height = heightArray[i];
                if (i != 0) _height += __height; // 计算偏移高度
                imageResult.setRGB(0, _height, width, __height, imgRGB.get(i), 0, width); // 写入流中
            }
            File outFile = new File(outPath);
            ImageIO.write(imageResult, "jpg", outFile);// 写图片
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        pdf2multiImage("D:\\临时文件\\pdf2.pdf","D:\\临时文件");
    }
}




