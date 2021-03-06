package education.zhiyuan.com.picturebooks.adpter;

import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Spring on 2017/7/25.
 */

public class AdapterVP extends PagerAdapter {

    public AdapterVP(List<String> tabList, List<RecyclerView> list) {
        this.tabList = tabList;
        this.list = list;
    }

    private List<String> tabList;
    public AdapterVP(List<RecyclerView> list) {
        this.list = list;
    }

    private List<RecyclerView> list;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(list.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabList.get(position);
    }


}
