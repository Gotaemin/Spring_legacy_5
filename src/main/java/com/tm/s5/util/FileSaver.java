package com.tm.s5.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	
	public int deleteFile(String fileName,String path) throws Exception{
		
		File file = new File(path, fileName);
		
		boolean check = false;
		int result = 0;
		
		if(file.exists()) {
			check = file.delete();
		}
		if(check) {
			result = 1;
		}
		
		return result;
	}

	public String saveByUtils(MultipartFile file, String path) throws Exception {
		// 1.폴더가 존재하지 않으면 폴더 생성
		File f = new File(path);
		if (!f.exists()) {
			f.mkdirs();
		}

		// 2.파일명 생성
		String fileName = this.makeNameByUUID(file.getOriginalFilename());

		System.out.println("fileSaverfileName:"+fileName);
		
		
		// 3.HDD에 저장
		// 방법1.FileCopyUtils
		f = new File(f, fileName);
		FileCopyUtils.copy(file.getBytes(), f);

		return fileName;
	}

	public String saveByTransfer(MultipartFile file, String path) throws Exception {
		// 1.폴더가 존재하지 않으면 폴더 생성
		File f = new File(path);
		if (!f.exists()) {
			f.mkdirs();
		}

		// 2.파일명 생성
		String fileName = this.makeNameByTime(file.getOriginalFilename());

		// 3.HDD에 저장
		// 방법2.TransferUtils
		f = new File(f, fileName);
		file.transferTo(f);
		
		return fileName;
	}

	public String saveByStream(MultipartFile file,String path) throws Exception{
		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		String fileName = this.makeNameByTime(file.getOriginalFilename());
		
		// 방법2.FileOutputStream
		f = new File(f, fileName);
		FileOutputStream fs = new FileOutputStream(f);
		fs.write(file.getBytes());
		fs.close();
		
		return fileName;
	}
	
	//---------------------------
	// 1.파일의 이름 설정방법
	private String makeNameByTime(String name) {

		Calendar cal = Calendar.getInstance();
		Long l = cal.getTimeInMillis();

//		String[] names = name.split("\\.");
//		name = names[0] + "_" + l + "." + names[1];
		
		System.out.println(name);
		String result = name.substring(0,name.lastIndexOf("."));
		result = result + "_" + l;
		result = result + name.substring(name.lastIndexOf("."));
		System.out.println(result);

		return name;
	}

	// 2.파일의 이름 설정방법
	private String makeNameByUUID(String name) {
		String f = UUID.randomUUID().toString();

		f = f + "_" + name;

		return f;
	}

}
