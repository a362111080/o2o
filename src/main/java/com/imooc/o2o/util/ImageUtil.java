package com.imooc.o2o.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	
	private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

	private static String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random r=new Random();
	public static String generateThumbnail(InputStream thumbnailInputStream,String fileName,String targetAddr) {
		String realFileName=getRandomFileName();
		String extension=getFileExtension(fileName);
		makeDiPhat(targetAddr);
		String relativeAddr=targetAddr+realFileName+extension;
		logger.debug("current relativeAddr is:"+relativeAddr);
		File dest=new File(PathUtil.getImgBasePath()+relativeAddr);
		logger.debug("current completedAddr is:"+PathUtil.getImgBasePath()+relativeAddr);
		try {
			Thumbnails.of(thumbnailInputStream).size(200,200)
			.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath+"/watermark.jpg")),0.25f)
			.outputQuality(0.8f).toFile(dest);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return relativeAddr;
	}
	/**
	 * 创建目标路径所涉及的目录，即/home/work/xiangze/xxx.jpg
	 * @param targetAddr
	 */
	private static void makeDiPhat(String targetAddr) {
		String realFileParentPath=PathUtil.getImgBasePath()+targetAddr;
		File dirPath=new File(realFileParentPath);
		if(!dirPath.exists()) {
			dirPath.mkdirs();
		}
		
	}
	/**
	 * 获取输入文件流的扩展名
	 * @param thumbnail
	 * @return
	 */
	private static String getFileExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}
	/**
	 * 生产随机文件名，当前年月日小时分钟秒钟+五位随机数
	 * @return
	 */
	public static String getRandomFileName() {
		//获取随机的五位数
		int rannum=r.nextInt(89999)+10000;
		String nowTimeStr=sDateFormat.format(new Date());
		return nowTimeStr+rannum;
	}
	public static void main(String[] args) throws IOException {
		Thumbnails.of(new File("D:\\tp\\xxx.jpg"))
		.size(200, 200).watermark(Positions.BOTTOM_RIGHT, 
				ImageIO.read(new File(basePath+"/watermark.jpg")), 0.25f).outputQuality(0.8f)
		.toFile("D:\\tp\\xxxnew.jpg");
	}
	/**
	 * storePath是文件的路径还是目录的路径，
	 * 如果storePath是文件路径则删除该文件，
	 * 如果storePath是目录路径则删除该目录下的所有文件
	 * @param storePath
	 */
	public static void deleteFlieOrPath(String storePath) {
		File fileOrPath=new File(PathUtil.getImgBasePath()+storePath);
		if(fileOrPath.exists()) {
			if(fileOrPath.isDirectory()) {
				File files[]=fileOrPath.listFiles();
				for(int i=0;i<files.length;i++) {
					files[i].delete();
				}
			}
			fileOrPath.delete();
		}
	}
}