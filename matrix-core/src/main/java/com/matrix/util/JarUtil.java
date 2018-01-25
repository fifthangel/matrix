package com.matrix.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseClass;

/**
 * @description: 
 *
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2018年1月25日 上午10:57:44 
 * @version 1.0.0
 */
public class JarUtil extends BaseClass{
	
	private static class LazyHolder {
		private static final JarUtil INSTANCE = new JarUtil();
	}
	public static final JarUtil getInstance() {
		return LazyHolder.INSTANCE; 
	}
	
	/**
	 * @description: 向匹配的jar文件中注入资源 
	 *
	 * @param pattern_
	 * @return 
	 * @author Yangcl
	 * @date 2018年1月25日 下午4:56:20 
	 * @version 1.0.0
	 */
	public JSONObject jarInject(String pattern_) {
		JSONObject result = new JSONObject();
		if(!StringUtils.endsWith(pattern_ , "/")) {
			result.put("status", "error");
			result.put("msg", this.getInfo(100090021));   
			return result;
		}
		result = this.classpathScanning(pattern_);
		if(result.getString("status").equals("success")){
			String name = "";
			List<String> files = JSONArray.parseArray(result.getJSONArray("list").toJSONString() , String.class); 
			try {
				for(String s : files) {
					name = s;
					@SuppressWarnings("resource")
					JarFile jar = new JarFile(s); 
					Enumeration<JarEntry>  ens = jar.entries();
					while(ens.hasMoreElements()){
						JarEntry e = ens.nextElement(); 
						if(e.getName().equals(pattern_)) {
							System.out.println(e.getName());
						}
					}
				}
			} catch (Exception e) {
				result.put("status", "error");
				result.remove("list");
				result.put("msg", this.getInfo(100090020 , name, ExceptionUtils.getExceptionInfo(e)));   
				return result;
			}
		}
		return result;
	}
	
	/**
	 * @description: 扫描指定项目资源文件的jar包
	 *
	 * @param pattern_ classpath通配查找。
	 * @return 返回匹配资源文件名列表
	 * @author Yangcl
	 * @date 2018年1月25日 下午3:20:37 
	 * @version 1.0.0
	 */
	public JSONObject classpathScanning(String pattern_){
		JSONObject result = new JSONObject();
		if(StringUtils.isBlank(pattern_)) {
			result.put("status", "error");
			result.put("msg", this.getInfo(100090018)); 
			return result;
		}
		List<String> files = new ArrayList<String>();
		try {
			Resource[] resources = new IoUtil().listResources("classpath*:" + pattern_);
			if(resources.length == 0) {
				result.put("status", "error");
				result.put("msg", this.getInfo(100090001));  
				return result;
			}
			for (Resource r : resources) {
				String path_ = StringUtils.substringAfter(r.getURI().toString(), "jar:file:/");
				files.add(path_.split("!")[0]); 
			}
		}catch (Exception e) { 
			result.put("status", "error");
			result.put("msg", this.getInfo(100090019, ExceptionUtils.getExceptionInfo(e)));   
			return result;
		}
		result.put("status", "success");
		result.put("list", files);   
		return result;
	}
   
	
	
	
	
	
	
	
	public void ListJarFile(String path)throws Exception{
        JarFile jarFile = new JarFile(path);
        Enumeration<JarEntry> jarEntrys = jarFile.entries();
        while(jarEntrys.hasMoreElements()){
            JarEntry jarEntry = jarEntrys.nextElement();
            System.out.println(jarEntry.getName());
        }
    }
	
	public void JarFileTest(String path)throws Exception{
        JarFile jarFile = new JarFile(path);
        JarEntry jarEntry = jarFile.getJarEntry("META-INF/MANIFEST.MF");
        InputStream in = jarFile.getInputStream(jarEntry);
        int c = -1;
        while((c=in.read())!=-1){
            System.out.print((char)(c & 0XFF));
        }
        if(in!=null){
            in.close();
            in=null;
        }
        System.out.println();
    }
	
	public String Jar(String path,File file)throws IOException{
        if(file==null){
            return null;
        }
        String jarFileName = "";
        if(file.getName().indexOf(".") > -1){
            jarFileName = file.getName().substring(0,file.getName().indexOf(".")) + ".jar";
        }else{
            jarFileName = file.getName() + ".jar";
        }
        String jarFullName = path + File.separator + jarFileName;
        byte[] data = new byte[1024 * 2];
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(jarFullName);
        JarOutputStream jarOS = new JarOutputStream(fos);
        jarOS.setMethod(JarOutputStream.DEFLATED);
        jarOS.putNextEntry(new JarEntry(file.getName()));
        int length = 0;
        while ((length = fis.read(data)) != -1) {
        	jarOS.write(data, 0, length);
        }
        jarOS.finish();
        jarOS.close();
        fos.close();
        fis.close();
        return jarFileName;
    }
	
	public static String Jar(String path,String jarName,File[] files)throws IOException{
        if(files==null){
            return null;
        }
        String jarFullName = path + File.separator + jarName;
        byte[] data = new byte[1024];
        FileOutputStream fos = new FileOutputStream(jarFullName);
        for(File file : files){
            FileInputStream fis = new FileInputStream(file);
            JarOutputStream jarOS = new JarOutputStream(fos);
            jarOS.setMethod(JarOutputStream.DEFLATED);
            jarOS.putNextEntry(new JarEntry(file.getName()));
            int length = 0;
            while ((length = fis.read(data)) != -1) {
                jarOS.write(data, 0, length);
            }
            jarOS.finish();
            jarOS.close();
            fis.close();       
        }
        fos.close();
        return jarFullName;
    }
}





































