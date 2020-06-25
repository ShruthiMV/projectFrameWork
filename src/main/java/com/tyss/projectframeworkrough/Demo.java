package com.tyss.projectframeworkrough;

import com.tyss.projectframework.init.IConstants;

public class Demo {

	public static void main(String[] args) {
      String path=IConstants.propFilePath;
		
		String a=System.getProperty("user.dir");
		System.out.println(a);
		System.out.println(path);

	}

}
