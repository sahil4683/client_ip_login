package com.as;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
@RestController
@RequestMapping("")
public class ClientIpLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientIpLoginApplication.class, args);
	}
	@RequestMapping("hello")
	public String myIp(HttpServletRequest httpServletRequest) {
		if(saveIp(extractIp(httpServletRequest))) {
			return extractIp(httpServletRequest);
		}
		else {
			return "IP Not Recognized !";	
		}
	}
	
	@RequestMapping("show")
	public String show(HttpServletRequest httpServletRequest) {
		StringBuffer sb=new StringBuffer();
		try {
			FileInputStream fis = new FileInputStream("abc.txt");
			Scanner sc = new Scanner(fis);
			while (sc.hasNextLine()) {
				sb.append("=>"+sc.nextLine());
				sb.append("\n");
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	private String extractIp(HttpServletRequest request) {
        String clientIp;
        String clientXForwardedForIp = request.getHeader("x-forwarded-for");
        if (clientXForwardedForIp!=null) {
            clientIp = parseXForwardedHeader(clientXForwardedForIp);
        } else {
            clientIp = request.getRemoteAddr();
        }
        return clientIp;
    }
	
	private String parseXForwardedHeader(String header) {
        return header.split(" *, *")[0];
    }
	
	private boolean saveIp(String ip) {
		try { 
	         File f1 = new File("abc.txt");
	         if(!f1.exists()) {
	            f1.createNewFile();
	         } 
	         FileWriter fileWritter = new FileWriter(f1.getName(),true);
	         BufferedWriter bw = new BufferedWriter(fileWritter);
	         bw.write("\n"+ip);
	         bw.close();
	         return true;
	      } catch(IOException e){
	         e.printStackTrace();
	         return false;
	      }
	}

}
