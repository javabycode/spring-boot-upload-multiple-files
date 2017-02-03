package com.javabycode.uploadingfiles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    public static final String uploadDir = System.getProperty("user.dir") + "/uploadDir/";

    @RequestMapping("/")
    public String forwardUpload(Model model) {
        File file = new File(uploadDir);
        model.addAttribute("files", file.listFiles());
        return "upload_files";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String uploadFiles(@RequestParam("uploadedFiles") MultipartFile[] uploadedFiles) throws IOException {
        for(MultipartFile f : uploadedFiles) {
            File file = new File(uploadDir + f.getOriginalFilename());
            f.transferTo(file);
        }

        return "redirect:/";
    }
}
