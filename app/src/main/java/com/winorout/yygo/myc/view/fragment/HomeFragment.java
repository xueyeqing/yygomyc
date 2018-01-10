package com.winorout.yygo.myc.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.winorout.yygo.myc.MyApplication;
import com.winorout.yygo.myc.R;
import com.winorout.yygo.myc.bdlocation.LocationService;
import com.winorout.yygo.myc.utils.LogUtils;

/**
 * @Description: 首页页面
 * @Author: zyzhang
 * @Date: 18/1/6 上午9:35
 */
public class HomeFragment extends Fragment {

    private LocationService locationService;

    private String locationInfo = "";
    private TextView locationinfo_tv;

    // 从MainActivity获取title 暂时没用到
    public static HomeFragment newInstance(String name) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("args", name);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_content, container, false);

        ViewStub practiceStub = (ViewStub) view.findViewById(R.id.practiceStub);
        practiceStub.setLayoutResource(R.layout.fragment_main);
        practiceStub.inflate();

        //位置信息
        locationinfo_tv = (TextView) view.findViewById(R.id.locationinfo_tv);

        return view;
    }

    @Override
    public void onStart() {

        // -----------location config ------------
        //获取locationservice实例，建议应用中只初始化1个location实例，然后使用
        locationService = ((MyApplication) getActivity().getApplication()).locationService;
        //注册监听
        locationService.registerListener(mListener);
        int type = getActivity().getIntent().getIntExtra("from", 0);
        if (type == 0) {
            locationService.setLocationOption(locationService.getDefaultLocationClientOption());
        } else if (type == 1) {
            locationService.setLocationOption(locationService.getOption());
        }

        //开始定位
        locationService.start();

        super.onStart();
    }

    @Override
    public void onStop() {
        locationService.unregisterListener(mListener); //注销掉监听
        locationService.stop(); //停止定位服务
        super.onStop();
    }

    /**
     * 显示位置信息
     *
     * @param str
     */
    public void showLocationInfo(String str) {
        final String location_adr = str;
        try {
            if (locationinfo_tv != null) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        locationinfo_tv.post(new Runnable() {
                            @Override
                            public void run() {
                                locationinfo_tv.setText(location_adr);
                            }
                        });

                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*****
     *
     * 定位结果回调，重写onReceiveLocation方法，可以直接拷贝如下代码到自己工程中修改
     *
     */
    private BDAbstractLocationListener mListener = new BDAbstractLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation location) {
            if (null != location && location.getLocType() != BDLocation.TypeServerError) {

                LogUtils.d("地址:" + location.getCity() + location.getDistrict());
                locationInfo = location.getCity() + location.getDistrict();

                if (location.getPoiList() != null && !location.getPoiList().isEmpty()) {
                    for (int i = 0; i < location.getPoiList().size(); i++) {
                        Poi poi = (Poi) location.getPoiList().get(i);
                        //LogUtils.d("poi:" + poi.getName());
                    }
                }
                if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
                    LogUtils.d("gps定位成功");
                } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
                    LogUtils.d("网络定位成功");
                } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                    LogUtils.d("离线定位成功，离线定位结果也是有效的");
                } else if (location.getLocType() == BDLocation.TypeServerError) {
                    LogUtils.d("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
                } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                    LogUtils.d("网络不同导致定位失败，请检查网络是否通畅");
                } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                    LogUtils.d("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
                }

            } else {
                LogUtils.d("-------------------错误-------------------");
            }

            showLocationInfo(locationInfo);
        }
    };
}
