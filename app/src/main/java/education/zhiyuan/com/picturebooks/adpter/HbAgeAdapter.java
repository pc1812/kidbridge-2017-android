package education.zhiyuan.com.picturebooks.adpter;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import education.zhiyuan.com.picturebooks.MyApp;
import education.zhiyuan.com.picturebooks.R;
import education.zhiyuan.com.picturebooks.bean.HuiBenBean;
import education.zhiyuan.com.picturebooks.http.Api;
import education.zhiyuan.com.picturebooks.utils.GlideUtils;

/**
 * Created by LH on 2018/1/11.
 * Description ：hahah
 */

public class HbAgeAdapter extends BaseQuickAdapter<HuiBenBean.DataBean, BaseViewHolder> {

    private Map<Integer, String> fitMap;

    public HbAgeAdapter(int layoutResId, @Nullable List<HuiBenBean.DataBean> data) {
        super(layoutResId, data);
        fitMap = new HashMap<>();
        fitMap.put(0, "3-5岁");
        fitMap.put(1, "6-8岁");
        fitMap.put(2, "9-12岁");
        fitMap.put(3, "4-7岁");
        fitMap.put(4, "8-10岁");
    }

    @Override
    protected void convert(BaseViewHolder holder, HuiBenBean.DataBean dataBean) {
        GlideUtils.GlideNormal(MyApp.getInstance(), Api.QN + dataBean.getIcon().get(0), (ImageView) holder.getView(R.id.iv_today_left), R.drawable.iv_replace_hb);
        holder.setVisible(R.id.iv_charge, dataBean.getLock() == 0); //是否解锁
        LinearLayout ll = holder.getView(R.id.ll_tag);  //标签
        ll.removeAllViews();
        if (dataBean.getTag().size() > 0) {
            for (int i = 0; i < 1; i++) { //dataBean.getTag().size()
                View view = LayoutInflater.from(MyApp.getInstance()).inflate(R.layout.item_lesson_tag, null);
                TextView textView = view.findViewById(R.id.tv_tag);
                textView.setText(dataBean.getTag().get(i));
                ll.addView(view);
            }
        }
        holder.setText(R.id.tv_today_left, dataBean.getName());
        if (dataBean.getPrice() > 0) {
            //收费
            holder.setVisible(R.id.tv_today_mid, false);
            holder.setText(R.id.tv_today_left_age, fitMap.get(dataBean.getFit()));
        } else {
            holder.setVisible(R.id.tv_today_mid, true);
            holder.setText(R.id.tv_today_mid, fitMap.get(dataBean.getFit()));
            holder.setText(R.id.tv_today_left_age, "免费");
        }
    }
}