package club.hdqyf.encryption.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author houdq
 * @version 1.0
 * @ClassName UploadController
 * @Description 文件加密解密controller
 * @date 2018/10/19 14:48
 **/
@Controller
public class UploadController {
    /**
     * 用于文件上传加密
     *
     * @param file
     * @param redirectAttributes 重定向页面传递参数
     * @param response
     * @return java.lang.String
     * @author houdq
     * @date 2018/10/19 15:38
     */
    @PostMapping(value = "/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, HttpServletResponse response) {
        if (file.isEmpty()) {
            //文件为空，返回提示信息
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/upload";
        }

        try {
            //修改文件编码
            String fileName = "(加密后)" + file.getOriginalFilename();
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
            response.setHeader("content-disposition", "attachment;filename=" + fileName);
            //获取文件流
            BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
            //获取输出流
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            //读取文件
            int len = 0;
            while ((len = bis.read()) != -1) {
                //写到前台
                bos.write(len ^ 123);
            }
            //关闭流
            bis.close();
            bos.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/upload";
    }

    /**
     * 用于文件上传解密
     *
     * @param file
     * @param redirectAttributes 重定向页面传递参数
     * @param response
     * @return java.lang.String
     * @author houdq
     * @date 2018/10/19 15:38
     */
    @PostMapping(value = "/encrypt")
    public String singleFileEncryption(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, HttpServletResponse response) {
        if (file.isEmpty()) {
            //文件为空，返回提示信息
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/encrypt";
        }

        try {
            //修改文件编码
            String fileName = "(解密后)" + file.getOriginalFilename();
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
            response.setHeader("content-disposition", "attachment;filename=" + fileName);
            //获取文件流
            BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
            //获取输出流
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            //读取文件
            int len = 0;
            while ((len = bis.read()) != -1) {
                //写到前台
                bos.write(len ^ 123);
            }
            //关闭流
            bis.close();
            bos.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/encrypt";
    }
}
