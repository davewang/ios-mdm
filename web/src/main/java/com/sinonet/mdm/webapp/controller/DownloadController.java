package com.sinonet.mdm.webapp.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-24
 * Time: 下午3:32
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/download")
public class DownloadController {
    @RequestMapping("/enroll")
    public void downloadEnroll(HttpServletResponse res) throws IOException {
        OutputStream os = res.getOutputStream();
        try {
            res.reset();
            res.setHeader("Content-Disposition", "attachment; filename=Enroll.mobileconfig");
            res.setContentType("application/octet-stream; charset=utf-8");
            String filename = Thread.currentThread().getContextClassLoader().getResource("Enroll.mobileconfig").getPath();
            System.out.println(filename);
            os.write(FileUtils.readFileToByteArray(new File(filename)));
            os.flush();
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }
    @RequestMapping("/ca")
    public void downloadCa(HttpServletResponse res) throws IOException {
        OutputStream os = res.getOutputStream();
        try {
            res.reset();
            res.setHeader("Content-Disposition", "attachment; filename=CA.crt");
            res.setContentType("application/octet-stream; charset=utf-8");

            String filename = Thread.currentThread().getContextClassLoader().getResource("CA.crt").getPath();
            System.out.println(filename);
            os.write(FileUtils.readFileToByteArray(new File(filename)));
            os.flush();
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }
}
