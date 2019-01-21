package com.microclouds.controller;

import com.microclouds.common.util.GetHash;
import com.microclouds.common.util.SystemPath;
import com.microclouds.entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.security.NoSuchAlgorithmException;

@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/microclouds")
public class FileSystemController {

    private static String systemPath = SystemPath.getSystemPath();

    private static String separator = File.separator;

    private static String temp = "Temp";

    /**
     * 检查文件存在与否
     */
    @PostMapping("/checkFile")
    @ResponseBody
    public Boolean checkFile(@RequestParam(value = "md5File") String md5File) throws IOException, NoSuchAlgorithmException {

        Boolean exist = false;

//        File file1 = (File) file;

//        String md5 = GetHash.getFileMD5(file1, "md5");

        System.out.println("check file : " + md5File);

        //实际项目中，这个md5File唯一值，应该保存到数据库或者缓存中，通过判断唯一值存不存在，来判断文件存不存在，这里我就不演示了
		/*if(true) {
			exist = true;
		}*/
        return exist;
    }

    /**
     * 检查分片存在与否
     */
    @PostMapping("/checkChunk")
    @ResponseBody
    public Boolean checkChunk(@RequestParam(value = "md5File") String md5File,
                              @RequestParam(value = "chunk") Integer chunk) {
        Boolean exist = false;
        String path = systemPath + temp + separator + md5File + separator;//分片存放目录
        String chunkName = chunk + ".tmp";//分片名
        File file = new File(path + chunkName);
        if (file.exists()) {
            exist = true;
        }
        return exist;
    }

    /**
     * 上传，这里根据文件md5值生成目录，并将分片文件放到该目录下
     */
    @PostMapping("/upload")
    @ResponseBody
    public Boolean upload(@RequestParam(value = "file") MultipartFile file,
                          @RequestParam(value = "md5File") String md5File,
                          @RequestParam(value = "chunk", required = false) Integer chunk) { //第几片，从0开始
        System.out.println("上传的文件的MD5 : " + md5File);
        String path = systemPath + temp + separator + md5File + separator;
        File dirfile = new File(path);
        if (!dirfile.exists()) {//目录不存在，创建目录
            dirfile.mkdirs();
        }
        String chunkName;
        if (chunk == null) {//表示是小文件，还没有一片
            chunkName = "0.tmp";
        } else {
            chunkName = chunk + ".tmp";
        }
        String filePath = path + chunkName;
        File savefile = new File(filePath);

        try {
            if (!savefile.exists()) {
                savefile.createNewFile();//文件不存在，则创建
            }
            file.transferTo(savefile);//将文件保存
        } catch (IOException e) {
            System.out.println("upload error :" + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 合成分片
     */
    @PostMapping("/merge")
    @ResponseBody
    public Boolean merge(@RequestParam(value = "chunks", required = false) Integer chunks,
                         @RequestParam(value = "md5File") String md5File,
                         @RequestParam(value = "name") String name) throws Exception {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String path = systemPath + temp + separator;
        String finalPath = systemPath + user.getUserMail() + separator;
        System.out.println("合并的分块 : " + md5File);
        // 合成后的文件
        FileOutputStream fileOutputStream = new FileOutputStream(finalPath + name);
        int len;
        byte[] buf = new byte[1024];
        try {
            for (long i = 0; i < chunks; i++) {
                String chunkFile = i + ".tmp";
                File file = new File(path + separator + md5File + separator + chunkFile);
                InputStream inputStream = new FileInputStream(file);
                while ((len = inputStream.read(buf)) != -1) {
                    fileOutputStream.write(buf, 0, len);
                }
                inputStream.close();
            }
            //合并完，要删除md5目录及临时文件，节省空间。这里代码省略
            String md5 = GetHash.getFileMD5(finalPath + name, "md5");
            System.out.println("用户上传的最终文件的md5 : " + md5);

        } catch (Exception e) {
            System.out.println("merge error : " + e.getMessage());
            return false;
        } finally {
            fileOutputStream.close();
        }
        return true;
    }
}
