package com.matrix.support;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

import com.alibaba.fastjson.JSONObject;

/**
 * @descriptions 基础的文件操作支持
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2017年8月2日 下午5:37:18
 * @version 1.0.1
 */
public class FileSupport {
	
	private FileSupport(){
	}
	private static class LazyHolder{
		private static final FileSupport INSTANCE = new FileSupport();
	}
	public static final FileSupport getInstance() {
		return LazyHolder.INSTANCE; 
	}
	
	/**
	 * @descriptions 获取任意网站上图片的属性
	 *
	 * @param imgUrl
	 * @date 2017年8月2日 下午5:34:57
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public JSONObject getImageProperty(String imgUrl) {
		JSONObject property = new JSONObject(); 
		property.put("width", "10");
		property.put("height", "10");
		property.put("size", "10");
		
		URL url = null;  
		HttpURLConnection conn = null;
		InputStream is = null;  
	    BufferedImage img = null; 
	    int length = 0;
	    try {  
	        url = new URL(imgUrl);   
	        conn = (HttpURLConnection) url.openConnection();
	        length = conn.getContentLength(); // 获取图片字节数，kb
			String result = String.valueOf(length / 1024.0);
			if(result.length() > 5){
				result = result.substring(0, 5);  // 保留两位小数
			} 
			property.put("size", result);
			
	        is = url.openStream();  
	        img = ImageIO.read(is);  
	        is.close();
	        property.put("width", String.valueOf(img.getWidth()) );    // 获取图片长宽属性
			property.put("height",  String.valueOf(img.getHeight()) ); 
	    }catch (Exception e) {  
	        e.printStackTrace();  
	    } finally {  
	    	conn.disconnect();  
	    } 
		
		return property;
	}
	
	/**
	 * @description:获得指定文件的byte数组 
	 * 
	 * @param file 文件
	 * @author Yangcl 
	 * @date 2017年7月13日 上午11:40:11 
	 * @version 1.0.0.1
	 */
	public byte[] getFileBytes(File file){  
	    byte[] buffer = null;  
	    try {  
	        FileInputStream fis = new FileInputStream(file);  
	        ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);  
	        byte[] b = new byte[1024];  
	        int n;  
	        while ((n = fis.read(b)) != -1) {  
	            bos.write(b, 0, n);  
	        }  
	        fis.close();  
	        bos.close();  
	        buffer = bos.toByteArray();  
	    } catch (FileNotFoundException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	    return buffer;  
	}
	
	/**
	 * @description: 根据byte数组，生成文件
	 * 
	 * @param bfile
	 * @param filePath 目的目录
	 * @param name 文件名
	 * @author Yangcl 
	 * @date 2017年7月13日 下午2:07:25 
	 * @version 1.0.0.1
	 */
	public void writeFile(byte[] bfile, String filePath,String name) {  
	    BufferedOutputStream bos = null;  
	    FileOutputStream fos = null;  
	    File file = null;  
	    try {  
	        File dir = new File(filePath);  
	        if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在  
	            dir.mkdirs();  
	        }  
	        file = new File(filePath + File.separator + name);  
	        fos = new FileOutputStream(file);  
	        bos = new BufferedOutputStream(fos);  
	        bos.write(bfile);  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    } finally {  
	        if (bos != null) {  
	            try {  
	                bos.close();  
	            } catch (IOException e1) {  
	                e1.printStackTrace();  
	            }  
	        }  
	        if (fos != null) {  
	            try {  
	                fos.close();  
	            } catch (IOException e1) {  
	                e1.printStackTrace();  
	            }  
	        }  
	    }  
	}
}
