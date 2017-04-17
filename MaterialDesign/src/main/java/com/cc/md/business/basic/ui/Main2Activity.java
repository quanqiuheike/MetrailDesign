package com.cc.md.business.basic.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.cc.md.business.basic.adapter.FragmentPagerAdapter;
import com.cc.md.R;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends BaseActivity {
    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewpager;
    private List<Fragment> fragmentList;
    private List<String> titleList;
    private FragmentPagerAdapter fragmentPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentList=new ArrayList<>();
        titleList=new ArrayList<>();

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        tablayout= (TabLayout) findViewById(R.id.tablayout);
        viewpager= (ViewPager) findViewById(R.id.viewpager);

        initViewpagerData();

        fragmentPagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager(),fragmentList,titleList);
        //给ViewPager设置适配器
        viewpager.setAdapter(fragmentPagerAdapter);
        //将TabLayout和ViewPager关联起来。
        tablayout.setupWithViewPager(viewpager);
        //给TabLayout设置适配器
        tablayout.setTabsFromPagerAdapter(fragmentPagerAdapter);

    }
    private void initViewpagerData(){
        titleList.add("精选");
        titleList.add("热点");
        titleList.add("科技");
        titleList.add("军事");
        titleList.add("娱乐");
        titleList.add("社会");
        titleList.add("搞笑");
        titleList.add("国际");
        titleList.add("汽车");
        titleList.add("财经");
        for (int i = 0; i <titleList.size() ; i++) {
            tablayout.addTab(tablayout.newTab().setText(titleList.get(i)));
        }
        for (int i = 0; i <titleList.size() ; i++) {
            fragmentList.add(new ListFragment());
        }
    }


}
