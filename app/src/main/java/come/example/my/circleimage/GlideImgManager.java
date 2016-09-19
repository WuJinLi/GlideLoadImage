package come.example.my.circleimage;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * 自定义GlideImgManager工具类，用来加载不同形状的图片
 */
public class GlideImgManager {

    /**
     * load normal  for img
     *
     * @param url
     * @param erroImg
     * @param emptyImg
     * @param iv       加载正常的图片
     */
    public static void glideLoader(Context context, String url, int erroImg, int emptyImg,
                                   ImageView iv) {
        //原生 API
        Glide.with(context).load(url).placeholder(emptyImg).error(erroImg).into(iv);
    }

    /**
     * load normal  for  circle or round img
     *
     * @param url
     * @param erroImg
     * @param emptyImg
     * @param iv
     * @param tag      根据tag的不同值，加载不同形状的图片
     */
    public static void glideLoader(Context context, String url, int erroImg, int emptyImg,
                                   ImageView iv, int tag) {
        if (0 == tag) {
            Glide.with(context).load(url).placeholder(emptyImg).error(erroImg).transform(new
                    GlideCircleTransform(context)).into(iv);
        } else if (1 == tag) {
            Glide.with(context).load(url).placeholder(emptyImg).error(erroImg).transform(new
                    GlideRoundTransform(context, 10)).into(iv);
        }
    }
}
