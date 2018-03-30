package education.zhiyuan.com.picturebooks.adpter;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import education.zhiyuan.com.picturebooks.MyApp;
import education.zhiyuan.com.picturebooks.R;
import education.zhiyuan.com.picturebooks.bean.MyLessonBean;
import education.zhiyuan.com.picturebooks.http.Api;
import education.zhiyuan.com.picturebooks.utils.GlideUtils;

/**
 * Created by LH on 2018/1/11.
 * Description ： lesson
 */

public class LessonAdapter extends BaseQuickAdapter<MyLessonBean.DataBean, BaseViewHolder> {

    public LessonAdapter(int layoutResId, @Nullable List<MyLessonBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, MyLessonBean.DataBean dataBean) {
        GlideUtils.GlideNormal(MyApp.getInstance(), Api.QN + dataBean.getIcon().get(0), (ImageView) holder.getView(R.id.iv_today_left), R.drawable.iv_replace_les);
        holder.setText(R.id.tv_lessonName, dataBean.getName());
        if (dataBean.getFit() == 0) {
            holder.setText(R.id.tv_fit, "3-5岁");
        } else if (dataBean.getFit() == 1) {
            holder.setText(R.id.tv_fit, "6-8岁");
        } else if (dataBean.getFit() == 2) {
            holder.setText(R.id.tv_fit, "9-12岁");
        } else if (dataBean.getFit() == 3) {
            holder.setText(R.id.tv_fit, "4-7岁");
        } else if (dataBean.getFit() == 4) {
            holder.setText(R.id.tv_fit, "8-10岁");
        }
        if (dataBean.getStatus() == 0) {  //，0：未开课(报名中)，1：已开课，2：已结束
            holder.setText(R.id.tv_lessonFlag, "未开课");
        } else if (dataBean.getStatus() == 1) {
            holder.setText(R.id.tv_lessonFlag, "已开课");
        } else {
            holder.setText(R.id.tv_lessonFlag, "已结束");
        }
        holder.setText(R.id.tv_cycle, dataBean.getCycle() + "天");
        LinearLayout ll = holder.getView(R.id.ll_tag);  //标签
        ll.removeAllViews();
        if (dataBean.getTag().size() > 0) {
            for (int i = 0; i < 1; i++) { // dataBean.getTag().size()
                View view = LayoutInflater.from(MyApp.getInstance()).inflate(R.layout.item_lesson_tag, null);
                TextView textView = view.findViewById(R.id.tv_tag);
                textView.setText(dataBean.getTag().get(i));
                ll.addView(view);
            }
        }
        holder.setText(R.id.price, "¥" + dataBean.getPrice() + "");
    }
}