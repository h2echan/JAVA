package day2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class file_io {
	
	File path = new File("C:\\Users\\h2ech\\Desktop\\길드 사진");
	String pattern = "jpg";
	
	String fileList[]=path.list(new FilenameFilter() {
		
		@Override
		public boolean accept(File dir, String name) {
			// TODO Auto-generated method stub
			return name.endsWith(pattern);
		}
	});
	
}
