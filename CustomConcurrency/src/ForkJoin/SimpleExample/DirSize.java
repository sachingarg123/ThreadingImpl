package ForkJoin.SimpleExample;

import java.io.File;

public class DirSize {
	
	public static long sizeOf(final File file) {
	    System.out.println("Computing size of:"+file);
	    
	    long size = 0;

	    // Ignore files which are not files and dirs
	    if (file.isFile()) {
	      size = file.length();
	    } else {
	      final File[] children = file.listFiles();
	      if (children != null) {
	        for (final File child : children) {
	          size += DirSize.sizeOf(child);
	        }
	      }
	    }

	    return size;
	  }
	
	public static void main(String arg[]){
		 final long start = System.nanoTime();
		    final long size = DirSize.sizeOf(new File("C:\\Sachin\\com"));
		    final long taken = System.nanoTime() - start;

		    System.out.println("Size of : " +new File("C:\\Sachin\\com") +" "+ size+" bytes (in "+taken+ " nano)");
	}

}
