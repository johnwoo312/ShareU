package es.source.wuzejun.shareu.fragment;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import es.source.wuzejun.shareu.R;
import es.source.wuzejun.shareu.fragment.basic.PictureSelectFragment;

import butterknife.Bind;
/**
 * Created by wuzejun on 2016/11/2.
 */
public class MainFragment extends PictureSelectFragment {

    /** Toolbar */
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.main_frag_picture_iv)
    ImageView mPictureIv;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_main;
    }

    @Override
    public void initViews(View view) {
        initToolbar(toolbar);
    }

    @Override
    public void initEvents() {
        // 设置图片点击监听
        mPictureIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPicture();
            }
        });
        // 设置裁剪图片结果监听
        setOnPictureSelectedListener(new OnPictureSelectedListener() {
            @Override
            public void onPictureSelected(Uri fileUri, Bitmap bitmap) {
                mPictureIv.setImageBitmap(bitmap);

                String filePath = fileUri.getEncodedPath();
                String imagePath = Uri.decode(filePath);
                Toast.makeText(mContext, "图片已经保存到:" + imagePath, Toast.LENGTH_LONG).show();
            }
        });
    }

}
