package com.devframework.ui.fragment;

import android.annotation.SuppressLint;
import android.view.View;

import com.devframework.R;
import com.devframework.base.BaseFragment;

import butterknife.OnClick;

/**
 * @author：rjhsmile
 * @PROJECT_NAME:TaoKeLink
 * @DATE：2018/3/1 17:11
 * @PACKAGE_NAME：MainFragment
 */

public class MainFragment extends BaseFragment {


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_main;
    }

    @SuppressLint("CheckResult")
    @Override
    protected void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.id_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_button:

//                Map<String, Object> map = new HashMap<>();
//                map.put("username", "mj001");
//                map.put("password", "666666");
//                ApiSource.getInstance().login(map)//.compose(this.<BaseResponse<BeUserLogin>>bindUntilEvent(FragmentEvent.START))
//                        .subscribe(new ResponseObserver<BaseResponse<BeUserLogin>>(getActivity(), true) {
//                            @Override
//                            public void onSuccess(BaseResponse<BeUserLogin> response) {
//                                Logger.d("onSuccess--" + response.toString());
//                            }
//
//                            @Override
//                            public void onFail(int code, String message) {
//                                Logger.d("onFail--" + code + message);
//                            }
//                        });

                //RxBus.get().post(new EventBus(Keys.EVENT_WHAT_SUCCESS));
                break;
        }
    }

}
