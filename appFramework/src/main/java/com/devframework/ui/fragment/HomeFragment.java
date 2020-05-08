//package com.devframework.ui.fragment;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//
//import com.devframework.ui.login.BeLogin;
//import com.devframework.base.BaseFragment;
//
//
//
///**
// * @author maijn
// */
//public class HomeFragment extends BaseFragment implements AdapterView.OnItemClickListener {
//
//
//
//    private BeLogin beLogin;
//    private String  mSendurl = "com.devframework.http://192.168.4.230:8080/ismp.inspection/user/login";
//
//    @Override
//    protected void initView(Bundle savedInstanceState) {
//
////
////
////        RequestParams params = new RequestParams(mSendurl);
////        //params.setSslSocketFactory(...); // 设置ssl
////
////        params.addQueryStringParameter("username", "mj001");
////        params.addQueryStringParameter("password", "666666");
////
////        x.com.devframework.http().post(params, new Callback.CommonCallback<String>() {
////
////            public void onSuccess(String result) {
////                Log.d("majin", "httpLogin:" + result);
////                beLogin = (BeLogin) FastJsonUtils.convertJsonToObject(result, BeLogin.class);
////                Log.d("majin", "httpLogin:" + beLogin.toString());
////            }
////
////            //请求异常后的回调方法
////            @Override
////            public void onError(Throwable ex, boolean isOnCallback) {
////                Log.d("majin", "onError:");
////            }
////
////            //主动调用取消请求的回调方法
////            @Override
////            public void onCancelled(CancelledException cex) {
////                Log.d("majin", "onCancelled:");
////            }
////
////            @Override
////            public void onFinished() {
////                Log.d("majin", "onFinished:");
////            }
////        });
//
//
//        //
//        //        RequestParams params1 = new RequestParams("http://192.168.4.230:8080/ismp.inspection/device/getCameraByDepList");
//        //        //    params.setSslSocketFactory(...); // 设置ssl
//        //        if (beLogin != null)
//        //            params1.addHeader("sessionId", beLogin.getData().getSessionId());
//        //        params1.addQueryStringParameter("name", "");
//        //        params1.addQueryStringParameter("departmentId", "");
//        //        params1.addQueryStringParameter("page", "1");
//        //        params1.addQueryStringParameter("pageSize", "10000");
//        //
//        //        x.com.devframework.http().post(params1, new Callback.CommonCallback<String>() {
//        //
//        //            public void onSuccess(String result) {
//        //                Log.d("majin", "onSuccess:" + result);
//        //            }
//        //
//        //            //请求异常后的回调方法
//        //            @Override
//        //            public void onError(Throwable ex, boolean isOnCallback) {
//        //                Log.d("majin", "onError:"  );
//        //            }
//        //
//        //            //主动调用取消请求的回调方法
//        //            @Override
//        //            public void onCancelled(CancelledException cex) {
//        //                Log.d("majin", "onCancelled:"  );
//        //            }
//        //
//        //            @Override
//        //            public void onFinished() {
//        //                Log.d("majin", "onFinished:"  );
//        //
//        //            }
//        //        });
//
//    }
//
//
//    @Override
//    protected void setListener() {
//        super.setListener();
//
//    }
//
//    @Override
//    protected void processLogic(Bundle savedInstanceState) {
//
//    }
//
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        //  VideoPlayer.releaseAllVideos();
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//    }
//}
