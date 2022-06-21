package kr.co.dw.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;



public class UpUtils {
  
  
  public static String getImgFilePath(String filename) {// /2022/06/03/s_uuid_oriname.png
    String orgName = "";
    
    // /2022/06/03/s_uuid_oriname.png
    String prefix = filename.substring(0, 12);  // /2022/06/03/
    String suffix = filename.substring(14);     // uuid_oriname.png
    
    orgName = prefix + suffix;      // /2022/06/03/uuid_oriname.png
    
    return orgName;
  }
  
  
  public static void deleteFile(String uploadPath, String filename) {
    File deleteFile = new File(uploadPath, filename);
    
    if(deleteFile.exists()) {
      deleteFile.delete();
    }
    
    try {
      Thread.sleep(20);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    if(isImgFile(filename)) {
      String orgImgFilePath = getImgFilePath(filename);
      File deleteOrgImgFile = new File(uploadPath, orgImgFilePath);
      
      if(deleteOrgImgFile.exists()) {
        deleteOrgImgFile.delete();
      }
    }
  }
    
  
  public static MediaType getMediaType(String filename) {
    Map<String, MediaType> map = new HashMap<String, MediaType>();
    map.put("png", MediaType.IMAGE_PNG);
    map.put("gif", MediaType.IMAGE_GIF);
    map.put("jpg", MediaType.IMAGE_JPEG);
    map.put("jpeg", MediaType.IMAGE_JPEG);
    
    int idx = filename.lastIndexOf(".") + 1;
    String formatName = filename.substring(idx).toLowerCase();

    MediaType mType = map.get(formatName);
    
    return mType;
   
  }
  
  public static String uploadFile(String uploadPath, String oriName, byte[] fileData) throws Exception {
    String uploadedFilename = "";
    
    String datePath = makeFolder(uploadPath);
    String newFilename = makeNewFilename(oriName);
    boolean isImg = isImgFile(newFilename);
    
    FileCopyUtils.copy(fileData, new File(uploadPath+datePath, newFilename));
    
    
    if(isImg) {
      try {
        uploadedFilename = makeThumbnail(uploadPath, datePath, newFilename);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }else {
      uploadedFilename = makeIcon(datePath, newFilename);
    }
    
    return uploadedFilename;
  }
  
  
  public static String makeIcon(String datePath, String newFilename) {
    
    String iconPath = datePath + File.separator + newFilename;
    
    
    return iconPath.replace(File.separatorChar, '/');
  }
  
  
  public static String makeThumbnail(String uploadPath, String datePath, String newFilename) throws Exception {
    
    String thumbnailPath = null;
    
    System.out.println(uploadPath + datePath);
    
    BufferedImage sourceImg = ImageIO.read(new File(uploadPath+datePath, newFilename));
    
    BufferedImage destImg =
        Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
    
    String thumbnailNamePath = datePath + File.separator + "s_" + newFilename;
    
    int idx = newFilename.lastIndexOf(".") + 1;
    String formatName = newFilename.substring(idx);
    
    ImageIO.write(destImg, formatName.toLowerCase(), new File(uploadPath, thumbnailNamePath));
    
    thumbnailPath = thumbnailNamePath.replace(File.separatorChar, '/');
    
    
    return thumbnailPath;
  }
  
  public static boolean isImgFile(String newFilename) {
    boolean isImageFile = false;
    
    List<String> list = new ArrayList<String>();
    list.add("png");
    list.add("gif");
    list.add("jpg");
    list.add("jpeg");
    
    int idx = newFilename.lastIndexOf(".") + 1;
    String formatName = newFilename.substring(idx).toLowerCase();
    
    isImageFile = list.contains(formatName);
    
    
    return isImageFile;
  }
  
  public static String makeNewFilename(String oriName) {

    String newFilename = null;

    UUID uid = UUID.randomUUID();
    newFilename = uid.toString() + "_" + oriName;

    return newFilename;

  }
  
  public static String makeFolder(String parent) {

    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH) + 1;
    int date = cal.get(Calendar.DATE);
    
	String path = "C:"+File.separator+"coffeeupload";
	
	File coffeeFolder = new File(path);
	if (!coffeeFolder.exists()) {
		coffeeFolder.mkdir();
	}

    File parentPath = new File(parent);

    File yearFile = new File(parentPath, year + "");
    if (!yearFile.exists()) {
      yearFile.mkdir();
    }

    File monthFile = new File(yearFile, new DecimalFormat("00").format(month));
    if (!monthFile.exists()) {
      monthFile.mkdir();
    }

    File dateFile = new File(monthFile, new DecimalFormat("00").format(date));
    if (!dateFile.exists()) {
      dateFile.mkdir();
    }

   
    return File.separator + year + File.separator + new DecimalFormat("00").format(month)
        + File.separator + new DecimalFormat("00").format(date);
  }
	
}
