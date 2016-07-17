package com.github.tkctd.kindlefiler;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BookList {

    private List<String> booklist = new ArrayList<String>();
    private File[] files;

    public List<String> get() {
        String sdPath = Environment.getExternalStorageDirectory().getPath();
        sdPath += "/Android/data/com.amazon.kindle/files";
        files = new File(sdPath).listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory() && files[i].getName().startsWith("B0")) {
                    booklist.add(files[i].getName());
                }
            }
        }
        return booklist;
    }
}
