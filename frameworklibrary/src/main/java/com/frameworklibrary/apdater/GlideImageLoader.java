package com.frameworklibrary.apdater;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.frameworklibrary.MyAppGlideModule;


/**
 * Created by etongdai on 2018/1/22.
 */

public class GlideImageLoader implements MyAppGlideModule.ImageLoader {
    @Override
    public void displayImage(Context context, String path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }

}
