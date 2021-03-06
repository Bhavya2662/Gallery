package com.example.gallery;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;

public class ImagesGallery {
    public static ArrayList<String > listOfImages(Context context){
        Uri uri;
        Cursor cursor;
        int columnIndexData,columnIndexFolderName;
        ArrayList<String> listOfAllImages = new ArrayList<>();
        String absolutePathOfImage;
        uri= MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {MediaStore.MediaColumns.DATA,MediaStore.Images.Media.BUCKET_DISPLAY_NAME};

        String orderBy = MediaStore.Video.Media.DATE_TAKEN;
        cursor=context.getContentResolver().query(uri,projection,null,null,orderBy+" DESC");

        columnIndexData=cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);

        while(cursor.moveToNext()){
            absolutePathOfImage = cursor.getString(columnIndexData);
            listOfAllImages.add(absolutePathOfImage);
        }
        return listOfAllImages;
    }
}
