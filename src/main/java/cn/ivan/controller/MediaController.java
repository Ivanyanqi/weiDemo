package cn.ivan.controller;

import cn.ivan.model.base.TMedia;
import cn.ivan.service.MediaService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: 仙人球
 * Date: 2017/5/15
 * Time: 17:07
 */
@Controller
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @RequestMapping(value = "/toMediaList",method = RequestMethod.GET)
    public String toMediaList(@RequestParam(required = true,defaultValue = "1") int currentPage,
                              @RequestParam(defaultValue = "5") int pageSize,
                              Model model){
        PageInfo<TMedia> page = mediaService.selectByPage(currentPage,pageSize);
        model.addAttribute("page",page);
        return "mediaList";
    }

    @RequestMapping(value = "/toUploadPage",method = RequestMethod.GET)
    public String toUploadPage(){
        return "uploadMeida";
    }


    @RequestMapping(value = "/uploadMedia",method = RequestMethod.POST)
    public String uploadMedia(String type, MultipartFile multipartFile, HttpServletRequest request){

        if(multipartFile != null){
            // 获取源文件名
            String originalFilename = multipartFile.getOriginalFilename();
            if(StringUtils.isNotBlank(originalFilename)){
                String realPath = request.getSession().getServletContext().getRealPath("/");
                String basePath = realPath + "/temp";
                File file = new File(basePath);
                if(!file.exists()){
                    file.mkdir();
                }
                try {
                    String filePath = basePath + "/" + originalFilename;
                    multipartFile.transferTo(new File(filePath));
                    String result = mediaService.uploadMedia(type, filePath);
                    if(result.equals("success")){
                        return "redirect:toMediaList";
                    }else {
                        request.setAttribute("msg",result);
                        return "uploadMeida";
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        request.setAttribute("msg","上传的文件有误！");
        return "uploadMeida";
    }
}
