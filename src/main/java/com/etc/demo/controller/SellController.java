package com.etc.demo.controller;

import com.etc.demo.service.GoodsService;
import com.etc.demo.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class SellController {

    private static final String path = "D:\\E\\WorkPlace\\IdeaWorkPlace\\wxServerP\\src\\main\\resources\\static\\goodsImage\\";
    private static List<String> imgsList = new ArrayList<>();
    private static Map<String, List<String>> goodsMap = new HashMap<>();
    private static String name1;
    private static Integer id1;
    private static String price1;
    private static String adress1;
    private static String textarea1;
    private static String attribute1;

    @Autowired
    GoodsService goodsService;
    @Autowired
    ImgService imgService;

    @RequestMapping("/upload")
    public String uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file,
                             @RequestParam String adress,
                             @RequestParam String textarea,
                             @RequestParam Integer id,
                             @RequestParam String goodsName,
                             @RequestParam String price,
                             @RequestParam String attribute

    ) throws IOException {
        String originalFilename = null;
        if (!file.isEmpty()) {
            name1 = goodsName;
            price1 = price;
            id1 = id;
            adress1 = adress;
            textarea1 = textarea;
            attribute1 = attribute;
            originalFilename = file.getOriginalFilename();
//            String substring = originalFilename.substring(originalFilename.length() - 5);
//            System.out.println(substring);
            imgsList.add(originalFilename);

            File file1 = new File(path + originalFilename);
            if (!file1.getParentFile().exists()) {

                file1.getParentFile().mkdirs();
            }
            file.transferTo(file1);
        }
        goodsMap.put(goodsName, imgsList);

        return "aaaaaaa";
    }

    @RequestMapping("/saveGoods")
    public boolean saveGoods() {
        DateFormat dateFormat = new SimpleDateFormat();
        String senTime = dateFormat.format(new Date());
        return goodsService.saveGoods(name1, attribute1, imgsList.get(0), price1, senTime, id1, adress1, textarea1, imgsList);
    }
}
