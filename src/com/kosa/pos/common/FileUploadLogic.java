package com.kosa.pos.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class FileUploadLogic {
	
	public static String fileUploadLogic(File inputFile) {
		String fileSeparator = File.separator;
		String fileAbsoluteName = inputFile.getAbsolutePath();
		int index = fileAbsoluteName.lastIndexOf(fileSeparator);
		String fileNameWithExtension = fileAbsoluteName.substring(index + 1); // 파일 이름과 확장자
		String fileExtension = fileNameWithExtension.substring(fileNameWithExtension.lastIndexOf(".") + 1); // 확장자
		// UUID 생성
		String uuid = UUID.randomUUID().toString();

		// UUID를 파일 이름에 추가
		String fileNameWithoutExtension = uuid;
		String fileName = fileNameWithoutExtension + "." + fileExtension;

		// 파일 저장 경로 설정
		String fileSaveRoute = "."+ fileSeparator +"img" + fileSeparator + "menuimg" + fileSeparator + fileName;
		System.out.println(fileSaveRoute);
		
		// 2. /images/파일명에 이미지 파일 저장
		File saveFile = new File(fileSaveRoute);
		if(!saveFile.getParentFile().exists())
			saveFile.getParentFile().mkdirs();
		
		try {
			FileInputStream fileInputStream = new FileInputStream(inputFile);
			FileOutputStream fileOutputStream = new FileOutputStream(fileSaveRoute);
			
			// 파일에서 읽어온 바이트를 저장할 버퍼
            byte[] buffer = new byte[1024];
            int length;
            
            // 파일에서 데이터를 읽어와서 다른 파일에 쓰기
            while ((length = fileInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }
            
            // 스트림 닫기
            fileInputStream.close();
            fileOutputStream.close();
            
		} catch (IOException e) {
	        System.err.println("파일 복사 중 오류가 발생했습니다: " + e.getMessage());
	    }
		
		return fileSaveRoute;
	}
}
